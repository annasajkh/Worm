package com.github.annasajkh.shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.github.annasajkh.GameObject;

public class Circle extends GameObject
{
	public float radius;
	public Color color;
	
	public Circle(Vector2 position,float radius)
	{
		super(position);
		this.radius = radius;
		color = Color.WHITE;
	}
	
	public boolean intersects(Circle other)
	{
		float distanceSquared = position.dst2(other.position);
		
		return distanceSquared <= radius * radius + other.radius * other.radius;
	}

	@Override
	public void draw(ShapeRenderer shapeRenderer)
	{
		shapeRenderer.setColor(color);
		shapeRenderer.circle(position.x,position.y,radius);
	}

	@Override
	public void update(float delta) { }
}
