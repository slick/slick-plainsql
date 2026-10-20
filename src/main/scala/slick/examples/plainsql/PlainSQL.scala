package slick.examples.plainsql

import cats.effect.{IO, IOApp}
import slick.cats.Database
import slick.jdbc.{DatabaseConfig, H2Profile}
import slick.jdbc.H2Profile.api.*

/** A simple example that uses plain SQL queries against an in-memory H2
  * database. The example data comes from Oracle's JDBC tutorial at
  * http://download.oracle.com/javase/tutorial/jdbc/basics/tables.html.
  */
object PlainSQL extends IOApp.Simple with Interpolation with Transfer {
  def run: IO[Unit] =
    Database
      .resource(DatabaseConfig.forProfileConfig(H2Profile, "h2mem1"))
      .use { db =>
        db.run(
          DBIO.seq(
            createSuppliers,
            createCoffees,
            insertSuppliers,
            insertCoffees.map { rows =>
              println(s"Inserted $rows coffees")
            },
            printAll,
            printParameterized,
            coffeeByName("Colombian").map { s =>
              println(s"Coffee Colombian: $s")
            },
            deleteCoffee("Colombian").map { rows =>
              println(s"Deleted $rows rows")
            },
            coffeeByName("Colombian").map { s =>
              println(s"Coffee Colombian: $s")
            }
          )
        )
      }
}
