/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiKijunTimeItemGroup;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定等合計のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class YokaigoNinteiKijunTimeTest {

    private static YokaigoNinteiKijunTime sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private Map<YokaigoNinteiKijunTimeItemGroup, Integer> 要介護認定等基準時間;
        private int 基準時間_合計;
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
            基準時間_合計 = 1;
            食事基準時間 = 2;
            排泄基準時間 = 3;
            移動基準時間 = 4;
            清潔保持基準時間 = 5;
            間接ケア基準時間 = 6;
            BPSD関連基準時間 = 7;
            機能訓練基準時間 = 8;
            医療関連基準時間 = 9;
            認知症加算基準時間 = 0;

            要介護認定等基準時間 = new EnumMap<>(YokaigoNinteiKijunTimeItemGroup.class);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.合計, 基準時間_合計);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.食事, 食事基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.排泄, 排泄基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.移動, 移動基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.清潔保持, 清潔保持基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.間接ケア, 間接ケア基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.BPSD関連, BPSD関連基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.機能訓練, 機能訓練基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.医療関連, 医療関連基準時間);
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.認知症加算, 認知症加算基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.合計, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 食事基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.食事, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 排泄基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.排泄, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 移動基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.移動, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 清潔保持基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.清潔保持, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 間接ケア基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.間接ケア, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void BPSD関連基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.BPSD関連, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 機能訓練基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.機能訓練, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 医療関連基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.医療関連, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 認知症加算基準時間に0より小さい数字が渡されたとき_IllegalArgumentExceptionが発生する() {
            要介護認定等基準時間.put(YokaigoNinteiKijunTimeItemGroup.認知症加算, -1);
            sut = new YokaigoNinteiKijunTime(要介護認定等基準時間);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new YokaigoNinteiKijunTime(null);
        }
    }
}
