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
 * 認定調査員区分コードのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsainKubunCodeTest {

    private static ShinsainKubunCode sut;

    public static class コンストラクタ_コードを表す文字列を渡す場合のテスト extends DbeTestBase {

        private RString code;

        @Before
        public void setUp() {
            code = new RString("code");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            code = null;
            sut = new ShinsainKubunCode(code);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コードに20桁以上の値が渡されたとき_IllegalArgumentExceptionが返る() {
            code = new RString("0123456789abcdefchijklmnopqlstrvwxyz");
            sut = new ShinsainKubunCode(code);
        }
    }

    public static class コンストラクタ_コードを渡す場合のテスト extends DbeTestBase {

        private Code code;

        @Before
        public void setUp() {
            code = new Code("code");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            code = null;
            sut = new ShinsainKubunCode(code);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コードに20桁以上の値が渡されたとき_IllegalArgumentExceptionが返る() {
            code = new Code("0123456789abcdefchijklmnopqlstrvwxyz");
            sut = new ShinsainKubunCode(code);
        }
    }
}
