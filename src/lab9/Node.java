/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 *
 * @author Ahmed Al-Brashdi
 */
public class Node<Object> {
	Object item;
	int key;
	Node<Object> next;
	public Node(int _key) {
		key=_key;
	}
}

