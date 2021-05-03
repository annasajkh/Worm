package com.github.annasajkh;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject
{
	public Vector2 position;
	
	public GameObject(Vector2 position)
	{
		this.position = position;
	}
	
	public abstract void update(float delta);
	
	public abstract void draw(ShapeRenderer shapeRenderer);
}
