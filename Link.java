package com.amar.linklist;

public class Link {

	public int data;
	public Link next;
	
	
	public Link()
	{
		
	}

	public Link(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}

}
