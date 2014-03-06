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
 * 合議体長区分のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaichoKubunTest {

    private static GogitaichoKubun sut;

    public static class コンストラクタ_引数にコードを表す文字列と名称を渡す場合のテスト extends DbeTestBase {

        private RString code;
        private RString name;

        @Before
        public void setUp() {
            code = new RString("0001");
            name = new RString("name");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが返る() {
            RString str = null;
            sut = new GogitaichoKubun(str, name);
        }

        @Test(expected = NullPointerException.class)
        public void 名称にnullが渡されたとき_NullPointerExceptionが返る() {
            sut = new GogitaichoKubun(code, null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コードに20桁以上の値が渡されたとき_IllegalArgumentExceptionが返る() {
            code = new RString("0123456789abcdefchijklmnopqlstrvwxyz");
            sut = new GogitaichoKubun(code, name);
        }
    }

    public static class コンストラクタ_引数にコードと名称を渡す場合のテスト extends DbeTestBase {

        private Code code;
        private RString name;

        @Before
        public void setUp() {
            code = new Code("0001");
            name = new RString("name");
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが返る() {
            Code str = null;
            sut = new GogitaichoKubun(str, name);
        }

        @Test(expected = NullPointerException.class)
        public void 名称にnullが渡されたとき_NullPointerExceptionが返る() {
            sut = new GogitaichoKubun(code, null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void コードに20桁以上の値が渡されたとき_IllegalArgumentExceptionが返る() {
            code = new Code("0123456789abcdefchijklmnopqlstrvwxyz");
            sut = new GogitaichoKubun(code, name);
        }
    }
}
