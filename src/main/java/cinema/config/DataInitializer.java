package cinema.config;

import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.Role;
import cinema.model.User;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.time.LocalDateTime;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final MovieService movieService;
    private final MovieSessionService movieSessionService;
    private final CinemaHallService cinemaHallService;

    public DataInitializer(RoleService roleService,
                           UserService userService,
                           MovieService movieService,
                           MovieSessionService movieSessionService,
                           CinemaHallService cinemaHallService) {
        this.roleService = roleService;
        this.userService = userService;
        this.movieService = movieService;
        this.movieSessionService = movieSessionService;
        this.cinemaHallService = cinemaHallService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRole(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRole(Role.RoleName.USER);

        roleService.add(userRole);
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1234");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("1234");
        user.setRoles(Set.of(userRole));
        userService.add(user);

        Movie shawshank = new Movie();
        shawshank.setTitle("The Shawshank Redemption");
        shawshank.setDescription("Two imprisoned men bond over a number of years, "
                + "finding solace and eventual redemption through acts of common decency.");
        movieService.add(shawshank);

        Movie lotr = new Movie();
        lotr.setTitle("The Lord of the Rings");
        lotr.setDescription("A meek Hobbit from the Shire and eight companions set out on a journey"
                + " to destroy the powerful One Ring and save Middle-earth.");
        movieService.add(lotr);

        CinemaHall kievOldMovie = new CinemaHall();
        kievOldMovie.setDescription("Repertory theaters are theaters that primarily show "
                + "classic movies the way they were meant to be seen.");
        kievOldMovie.setCapacity(322);
        cinemaHallService.add(kievOldMovie);

        MovieSession fantasySession = new MovieSession();
        fantasySession.setCinemaHall(kievOldMovie);
        fantasySession.setMovie(lotr);
        fantasySession.setShowTime(LocalDateTime.of(2023, 3, 22, 19, 55));
        movieSessionService.add(fantasySession);

        MovieSession classicSession = new MovieSession();
        classicSession.setMovie(shawshank);
        classicSession.setCinemaHall(kievOldMovie);
        classicSession.setShowTime(LocalDateTime.of(2023, 4, 12, 22, 15));
        movieSessionService.add(classicSession);
    }
}
