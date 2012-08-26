package code

import lib.Parser
import org.specs2.mutable.Specification
import net.liftweb.json.DefaultFormats

/**
 * User: colt44
 * Date: 8/23/12
 * Time: 10:30 PM
 */
class ParserSpec extends Specification {
  implicit val formats = DefaultFormats

  "task service inf.eureka.tarsier.rest" should {
    "parse tasks without tags" in {
      val json =
        """
        {
        "data": [
        {
        "name":"a_query",
        "fql_result_set": []
        },
        {
        "name":"another_query",
        "fql_result_set": []
        },
        {
        "name":"yet_another_query",
        "fql_result_set": []
        }
        ]
        }
        """

      val obj = Parser.find(json, "a_query")

      obj.get.name must be equalTo "a_query"
    }
  }
}
