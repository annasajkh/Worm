package com.github.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.github.annasajkh.shapes.Circle;

public class Trail extends Circle
{
	
	boolean delete = false;
	float lifetime = 1;

	public Trail(Vector2 position)
	{
		super(position,4);
		
	}

	@Override
	public void update(float delta)
	{

		lifetime -= Gdx.graphics.getDeltaTime(); 
		
		if(lifetime < 0)
		{
			delete = true;
		}
		
	}

	@Override
	public void draw(ShapeRenderer shapeRenderer)
	{
		radius = lifetime * 4;
		shapeRenderer.setColor(0,0,lifetime,1);
		shapeRenderer.circle(position.x,position.y, radius);
	}

}
