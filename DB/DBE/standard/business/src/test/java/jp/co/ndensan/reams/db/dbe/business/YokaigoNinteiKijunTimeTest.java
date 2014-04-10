/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定等基準時間のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class YokaigoNinteiKijunTimeTest {

    private static YokaigoNinteiKijunTime sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private int 基準時間;
        private int 食事基準時間;
        private int 排泄基準時間;
        private int 移動基準時間;
        private int 清潔保持基準時間;
        private int 間接ケア基準時間;
        private int BPSD関連基準時間;
        private int 機能訓練基準時間;
        private int 医療関連基準時間;
        private int 認知症加算基準時間;

        @Before
        public void setUp() {
            基準時間 = 1;
            食事基準時間 = 2;
            排泄基準時間 = 3;
            移動基準時間 = 4;
            清潔保持基準時間 = 5;
            間接ケア基準時間 = 6;
            BPSD関連基準時間 = 7;
            機能訓練基準時間 = 8;
            医療関連基準時間 = 9;
            認知症加算基準時間 = 0;
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(-1, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 食事基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, -1, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 排泄基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, -1,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 移動基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    -1, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 清潔保持基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, -1, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 間接ケア基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, -1, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void BPSD関連基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, -1,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 機能訓練基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    -1, 医療関連基準時間, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 医療関連基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, -1, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 認知症加算基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, -1);
        }

        @Test
        public void すべての引数に0以上の値が渡されているとき_インスタンスが生成される() {
            sut = new YokaigoNinteiKijunTime(基準時間, 食事基準時間, 排泄基準時間,
                    移動基準時間, 清潔保持基準時間, 間接ケア基準時間, BPSD関連基準時間,
                    機能訓練基準時間, 医療関連基準時間, 認知症加算基準時間);
            assertThat(sut, is(instanceOf(YokaigoNinteiKijunTime.class)));
        }
    }
}
