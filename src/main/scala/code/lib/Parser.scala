package code.lib

import net.liftweb.json.Serialization

/**
 * User: colt44
 * Date: 8/25/12
 * Time: 11:21 PM
 */

case class QueryJson(name: String, fql_result_seq: List[String])
case class TestJson(data: List[QueryJson])

object Parser {
  implicit val formats = net.liftweb.json.DefaultFormats

  private def parse(json: String) = Serialization.read[TestJson](json)

  def find(json: String, q: String) = {
    val obj = parse(json)
    obj.data.filter((o) => o.name.equals(q)).headOption
  }
}
