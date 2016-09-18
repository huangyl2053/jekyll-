/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.jushochitokureirirekilist.util;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiExecutionStatusTest {

    public static JushochiTokureiExecutionStatus sut;

    public static class toValue extends DbzTestBase {

        @Test
        public void 引数に_文字列Tekiyoが渡されたとき_戻り値にTekiyoが返る() {
            sut = JushochiTokureiExecutionStatus.toValue(new RString("Tekiyo"));
            assertThat(sut == JushochiTokureiExecutionStatus.Tekiyo, is(true));
        }

        @Test
        public void 引数に_文字列Kaijoが渡されたとき_戻り値にKaijoが返る() {
            sut = JushochiTokureiExecutionStatus.toValue(new RString("Kaijo"));
            assertThat(sut == JushochiTokureiExecutionStatus.Kaijo, is(true));
        }

        @Test
        public void 引数に文字列Teiseiが渡されたとき_戻り値にTeiseiが返る() {
            sut = JushochiTokureiExecutionStatus.toValue(new RString("Teisei"));
            assertThat(sut == JushochiTokureiExecutionStatus.Teisei, is(true));
        }

        @Test
        public void 引数に_文字列Shokaiが渡されたとき_戻り値にShokaiが返る() {
            sut = JushochiTokureiExecutionStatus.toValue(new RString("Shokai"));
            assertThat(sut == JushochiTokureiExecutionStatus.Shokai, is(true));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_対応するステータスが存在しない文字列が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = JushochiTokureiExecutionStatus.toValue(new RString("更新するふり"));
            fail();
        }
    }

}
