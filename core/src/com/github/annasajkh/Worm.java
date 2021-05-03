package com.github.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.github.annasajkh.shapes.Circle;

public class Worm extends Circle
{
	Vector2 velocity;
	
	float speed = 20;
	//angle in radians;
	float angle;
	float randomScale = 0.5f;
	static float speedScale = 20;
	float maxSpeed = 200;


	public Worm(final Vector2 position, float angle)
	{
		super(position,4);
		
		this.angle = angle;
		color = Color.RED;
		
		
	}

	@Override
	public void update(float delta)
	{
		
		angle += MathUtils.random(-1, 1) * randomScale;
		speed += MathUtils.random(-1, 1) * speedScale;
		
		speed = MathUtils.clamp(speed, -maxSpeed, maxSpeed);
		
		position.x += MathUtils.cos(angle) * speed * delta;
		position.y += MathUtils.sin(angle) * speed * delta;
		
		if(position.x < -radius)
		{
			position.x = Gdx.graphics.getWidth() + radius;
		}
		else if(position.x > Gdx.graphics.getWidth() + radius)
		{
			position.x = -radius;
		}
		
		if(position.y < -radius)
		{
			position.y = Gdx.graphics.getHeight() + radius;
		}
		else if(position.y > Gdx.graphics.getHeight() + radius)
		{
			position.y = -radius;
		}
	}
	

}
