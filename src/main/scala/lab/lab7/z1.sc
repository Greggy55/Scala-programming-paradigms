import scala.annotation.tailrec
import scala.runtime.Nothing$

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

val t = Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty)


def mirror_tree[A](bt: BT[A]): BT[A] = {
  bt match {
    case Empty => Empty
    case Node(el, tl, tr) => Node(el, mirror_tree(tr), mirror_tree(tl))
  }
}

mirror_tree(t)



//@tailrec
//def mirror_tree[A](node: Node[A]): Node[A] = {
//  node match {
//    case Node(_, tl, tr) => mirror_tree(Node(node.elem, node.right, node.left))
//  }
//}

