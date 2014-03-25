/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定状態安定性コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class SuiteiKyuhuKubunCodeTest {

    private static SuiteiKyuhuKubunCode sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new SuiteiKyuhuKubunCode(null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に20桁より大きい文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new SuiteiKyuhuKubunCode(new RString("012345678901234567890"));
        }

        @Test
        public void 引数に20桁以内の文字列が渡されたとき_インスタンスが生成される() {
            sut = new SuiteiKyuhuKubunCode(new RString("01234567890123456789"));
            assertThat(sut, is(instanceOf(SuiteiKyuhuKubunCode.class)));
        }
    }
}
