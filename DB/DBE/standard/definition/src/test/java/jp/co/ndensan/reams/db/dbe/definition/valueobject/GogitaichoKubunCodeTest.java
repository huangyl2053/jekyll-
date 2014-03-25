/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体長区分コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaichoKubunCodeTest {

    private static GogitaichoKubunCode sut;

    public static class コンストラクタ_引数にコードを表す文字列を渡す場合のテスト extends DbeTestBase {

        private RString code;

        @Before
        public void setUp() {
            code = new RString("0001");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが返る() {
            RString str = null;
            sut = new GogitaichoKubunCode(str);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コードに20桁以上の値が渡されたとき_IllegalArgumentExceptionが返る() {
            code = new RString("0123456789abcdefchijklmnopqlstrvwxyz");
            sut = new GogitaichoKubunCode(code);
        }
    }

    public static class コンストラクタ_引数にコードを渡す場合のテスト extends DbeTestBase {

        private Code code;

        @Before
        public void setUp() {
            code = new Code("0001");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが返る() {
            Code str = null;
            sut = new GogitaichoKubunCode(str);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コードに20桁以上の値が渡されたとき_IllegalArgumentExceptionが返る() {
            code = new Code("0123456789abcdefchijklmnopqlstrvwxyz");
            sut = new GogitaichoKubunCode(code);
        }
    }
}
