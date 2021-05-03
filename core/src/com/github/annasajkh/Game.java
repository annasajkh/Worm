package com.github.annasajkh;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Game extends ApplicationAdapter
{
	ShapeRenderer shapeRenderer;
	Worm[] worms;
	public static List<Trail> trails;
	Timer trailSpawnTimer;
	
	@Override
	public void create()
	{
		trails = new ArrayList<>();
		
		shapeRenderer = new ShapeRenderer();
		
		worms = new Worm[100];
		
		for(int i = 0; i < worms.length; i++)
		{
			Vector2 dir = new Vector2(1, 0).setToRandomDirection();
			Vector2 wormPos = new Vector2(MathUtils.random(Gdx.graphics.getWidth()),MathUtils.random(Gdx.graphics.getHeight()));
			worms[i] = new Worm(wormPos,dir.angleRad());
		}
		
		
		trailSpawnTimer = new Timer();
		
		trailSpawnTimer.scheduleTask(new Task()
		{
			
			@Override
			public void run()
			{
				for(Worm worm : worms)
				{					
					Game.trails.add(new Trail(worm.position.cpy()));
				}
			}
			
		},0,0.05f);
		
		
	}
	
	public void update()
	{
		for(Trail trail : trails)
		{
			trail.update(0);
		}
		
		for(int i = trails.size() - 1; i > 0; i--)
		{
			Trail trail = trails.get(i);
			
			if(trail.delete)
			{
				trails.remove(trail);
			}
		}
		
		for(Worm worm : worms)
		{
			worm.update(Gdx.graphics.getDeltaTime());
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE))
		{
			trailSpawnTimer.stop();
			create();
		}
	}

	@Override
	public void render()
	{
		update();
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Filled);
		
		
		for(Trail trail : trails)
		{
			trail.draw(shapeRenderer);
		}
		
		for(Worm worm : worms)
		{
			worm.draw(shapeRenderer);
		}
		
		shapeRenderer.end();
		
		
	}

	@Override
	public void dispose()
	{
		shapeRenderer.dispose();
	}
}
