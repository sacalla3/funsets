package funsets

/**
 * Clase con las pruebas para los métodos del objeto FunSets
 *
 * Para ejecutar las pruebas, inicie "sbt" y luego ejecute el comando "test".
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * Para reutilizar los casos de prueba se crea un trait llamado TestSets con atributos
   * que pueden usarse en los distintos métodos de prueba.
   *
   */

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

  /**
   * Esta prueba está deshabilitada (usando @Ignore) porque el método
   * "singletonSet" todavía no está implementado, por tanto podría fallar.
   *
   * Una vez haya terminado su implementación de "singletonSet", quite la
   * anotación  .ignore
   */
  test("singleton set one contains one".ignore) {

    /**
     *Dentro de la prueba se crea una instancia de TestSets para usar
     * los casos de prueba  "s1" a "s3".
     */
    new TestSets:

      assert(contains(s1, 1), "Singleton")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }
  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
