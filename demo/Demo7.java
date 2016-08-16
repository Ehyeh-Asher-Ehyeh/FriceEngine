import org.frice.game.Game;
import org.frice.game.anim.move.SimpleMove;
import org.frice.game.event.OnClickEvent;
import org.frice.game.event.OnMouseEvent;
import org.frice.game.obj.ShapeObject;
import org.frice.game.resource.ColorResource;
import org.frice.game.utils.message.log.FLog;
import org.frice.game.utils.shape.FRectangle;
import org.frice.game.utils.time.FTimer;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

/**
 * Created by ice1000 on 2016/8/16.
 *
 * @author ice1000
 */
public class Demo7 extends Game {

	public static void main(String[] args) {
		new Demo7();
	}

	private Random random = new Random();
	private FTimer timer = new FTimer(3000);
	private int height;

	@Override
	protected void onInit() {
		setSize(500, 800);
		setTitle("Flappy bird demo by ice1000");
	}

	@Override
	protected void onRefresh() {
		try {
			if (timer.ended()) addObjects(getObj());
		} catch (Exception e) {
			FLog.e(e.getMessage());
		}
	}

	@Override
	protected void onClick(@Nullable OnClickEvent e) {
	}

	@Override
	protected void onMouse(@Nullable OnMouseEvent e) {
	}

	private ShapeObject[] getObj() {
		height = random.nextInt(600);
		return new ShapeObject[]{new ShapeObject(ColorResource.Companion.get教主黄(),
				new FRectangle(50, height), 550.0, 0.0) {{
			getAnims().add(new SimpleMove(-100, 0));
		}}, new ShapeObject(ColorResource.Companion.get教主黄(),
				new FRectangle(50, getHeight() - height), 550.0, height + 200.0) {{
			getAnims().add(new SimpleMove(-100, 0));
		}}};
	}
}
