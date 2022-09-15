package config;

import lombok.Getter;
import lombok.Setter;
import org.flywaydb.core.Flyway;

@Getter
@Setter
public class FlywayConfig {

    private static FlywayConfig instance;
    private final Flyway flyway;

    private FlywayConfig() {
        flyway = Flyway.configure()
                .dataSource( "jdbc:postgresql://ec2-44-209-158-64.compute-1.amazonaws.com/d8el0m9a1811og" ,
                        "xttvocuwhrudtg" ,
                        "616e96cc7f69e63cc65b1182befd22fa980ab722a6b3d19a4b6e293ac8920381")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
    }

    public static FlywayConfig getInstance() {
        if (instance == null) {
            instance = new FlywayConfig();
        }
        return instance;
    }
}
