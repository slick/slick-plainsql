package slick.examples.plainsql
import slick.jdbc.GetResult

/** The Data Transfer Objects for the PlainSQL app */
trait Transfer { this: PlainSQL.type =>

  // Case classes for our data
  case class Supplier(
      id: Int,
      name: String,
      street: String,
      city: String,
      state: String,
      zip: String
  )
  case class Coffee(
      name: String,
      supID: Int,
      price: Double,
      sales: Int,
      total: Int
  )

  // Result set getters
  given GetResult[Supplier] = r =>
    Supplier(
      r.nextInt(),
      r.nextString(),
      r.nextString(),
      r.nextString(),
      r.nextString(),
      r.nextString()
    )
  given GetResult[Coffee]   = r => Coffee(r.<<, r.<<, r.<<, r.<<, r.<<)
}
