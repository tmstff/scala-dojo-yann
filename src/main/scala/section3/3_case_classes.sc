case class SomeCaseClass(w: Int, var x: Int, y: Int = 100, private var z: Int)
//                       |           |       |                         |
//                       |           |       |                         private variable
//                       |           |       |
//                       |           |       public read only with default
//                       |           |
//                       |           public writable variable
//                       |
//                       public read only value
//

val foo = SomeCaseClass(1, 2, z = 42)
foo.w
foo.x = 12
foo.x
foo.y

