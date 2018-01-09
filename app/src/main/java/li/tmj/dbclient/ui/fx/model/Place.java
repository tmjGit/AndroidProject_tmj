//package li.tmj.tablelikefields.ui.fx.model;
//
//import java.io.Serializable;
//
//public class Place implements Serializable {
//	private static final long serialVersionUID = 1L;
//	private int left;
//	private int top;
//	private int width;
//	private int height;
//	private PlaceRelation leftRelation=PlaceRelation.ABSOLUTE;
//	private PlaceRelation topRelation=PlaceRelation.ABSOLUTE;
//	private PlaceRelation widthRelation=PlaceRelation.ABSOLUTE;
//	private PlaceRelation heightRelation=PlaceRelation.DEFAULT;
//	private int leftRelationDistance=0;
//	private int topRelationDistance=0;
//
//	public Place() {
//
//	}
//
//	public Place(int left, int top, int width, int height) {
//		if(0==left) {
//			leftRelation=PlaceRelation.DEFAULT;
//		}else {
//			this.left=left;
//		}
//		if(0==top) {
//			topRelation=PlaceRelation.DEFAULT;
//		}else {
//			this.top=top;
//		}
//		if(0==width) {
//			widthRelation=PlaceRelation.DEFAULT;
//		}else {
//			this.width=width;
//		}
//		if(0==height) {
//			heightRelation=PlaceRelation.DEFAULT;
//		}else {
//			this.height=height;
//		}
//	}
//
//
//	public int getLeft() {
//		return left;
//	}
//	public void setLeft(int left) {
//		this.left = left;
//	}
//	public int getTop() {
//		return top;
//	}
//	public void setTop(int top) {
//		this.top = top;
//	}
//	public int getWidth() {
//		return width;
//	}
//	public void setWidth(int width) {
//		this.width = width;
//	}
//	public int getHeight() {
//		return height;
//	}
//	public void setHeight(int height) {
//		this.height = height;
//	}
//
//	public PlaceRelation getLeftRelation() {
//		return leftRelation;
//	}
//	public void setLeftRelation(PlaceRelation placeRelation) {
//		this.leftRelation = placeRelation;
//	}
//	public void setLeftRelation(PlaceRelation placeRelation, int leftDistance) {
//		this.leftRelation = placeRelation;
//		setLeftRelationDistance(leftDistance);
//	}
//	public PlaceRelation getTopRelation() {
//		return topRelation;
//	}
//	public void setTopRelation(PlaceRelation placeRelation) {
//		this.topRelation = placeRelation;
//	}
//	public void setTopRelation(PlaceRelation placeRelation, int topDistance) {
//		this.topRelation = placeRelation;
//		setTopRelationDistance(topDistance);
//	}
//	public PlaceRelation getWidthRelation() {
//		return widthRelation;
//	}
//	public void setWidthRelation(PlaceRelation placeRelation) {
//		this.widthRelation = placeRelation;
//	}
//
//	public PlaceRelation getHeightRelation() {
//		return heightRelation;
//	}
//	public void setHeightRelation(PlaceRelation placeRelation) {
//		this.heightRelation = placeRelation;
//	}
//
//	public int getLeftRelationDistance() {
//		return leftRelationDistance;
//	}
//
//	public void setLeftRelationDistance(int leftRelationDistance) {
//		this.leftRelationDistance = leftRelationDistance;
//	}
//
//	public int getTopRelationDistance() {
//		return topRelationDistance;
//	}
//
//	public void setTopRelationDistance(int topRelationDistance) {
//		this.topRelationDistance = topRelationDistance;
//	}
//
//	public static Place createPlaceRightOf(int relatedPlace) {//short cut
//		return createPlaceRightOf(relatedPlace, 0);
//	}
//
//	public static Place createPlaceRightOf(int relatedPlace,int leftDistance) {//short cut
//		Place p=new Place();
//		p.setLeft(relatedPlace);
//		p.setLeftRelation(PlaceRelation.RIGHT_OF);
//		p.setLeftRelationDistance(leftDistance);
//		p.setTop(relatedPlace);
//		p.setTopRelation(PlaceRelation.RIGHT_OF);
//		p.setHeight(relatedPlace);
//		p.setHeightRelation(PlaceRelation.RIGHT_OF);
//		return p;
//	}
//
//	public static Place createPlaceBeneath(int relatedPlace) {//short cut
//		return createPlaceBeneath(relatedPlace, 0);
//	}
//	public static Place createPlaceBeneath(int relatedPlace,int topDistance) {//short cut
//		Place p=new Place();
//		p.setLeft(relatedPlace);
//		p.setLeftRelation(PlaceRelation.BENEATH);
//		p.setTop(relatedPlace);
//		p.setTopRelation(PlaceRelation.BENEATH);
//		p.setTopRelationDistance(topDistance);
//		p.setWidth(relatedPlace);
//		p.setWidthRelation(PlaceRelation.BENEATH);
//		return p;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		long temp;
//		temp = int.intToLongBits(height);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = int.intToLongBits(left);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = int.intToLongBits(width);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Place other = (Place) obj;
//		if (int.intToLongBits(height) != int.intToLongBits(other.height))
//			return false;
//		if (int.intToLongBits(left) != int.intToLongBits(other.left))
//			return false;
//		if (int.intToLongBits(width) != int.intToLongBits(other.width))
//			return false;
//		return true;
//	}
//	@Override
//	public String toString() {
//		return "Place [left=" + left + ", width=" + width + ", height=" + height + "]";
//	}
//
//
//}
