/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催時間のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaishiTimeTest {

    private static ShinsakaiKaishiTime sut;

    public static class コンストラクタ_RStringを渡す場合のテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            RString 時間 = null;
            sut = new ShinsakaiKaishiTime(時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に4桁でない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            RString 時間 = new RString("12345");
            sut = new ShinsakaiKaishiTime(時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に数字以外で構成される文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            RString 時間 = new RString("a123");
            sut = new ShinsakaiKaishiTime(時間);
        }
    }

    public static class コンストラクタ_Stringを渡す場合のテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            String 時間 = null;
            sut = new ShinsakaiKaishiTime(時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に4桁でない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            String 時間 = "12345";
            sut = new ShinsakaiKaishiTime(時間);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に数字以外で構成される文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            String 時間 = "a123";
            sut = new ShinsakaiKaishiTime(時間);
        }
    }
}
