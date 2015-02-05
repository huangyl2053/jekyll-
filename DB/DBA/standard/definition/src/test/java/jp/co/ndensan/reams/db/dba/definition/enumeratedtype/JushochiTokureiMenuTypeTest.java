/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.definition.enumeratedtype.JushochiTokureiMenuType}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiMenuTypeTest {

    public static class toValue extends DbaTestBase {

        @Test
        public void 引数にDBAMN25001が渡された場合_DBAMN25001_届出により適用が返る() {
            JushochiTokureiMenuType result = JushochiTokureiMenuType.toValue(new RString("DBAMN25001"));
            assertThat(result, is(JushochiTokureiMenuType.DBAMN25001_届出により適用));
        }

        @Test
        public void 引数にDBAMN61002が渡された場合_DBAMN61002_転入転出保留対象者管理が返る() {
            JushochiTokureiMenuType result = JushochiTokureiMenuType.toValue(new RString("DBAMN61002"));
            assertThat(result, is(JushochiTokureiMenuType.DBAMN61002_転入転出保留対象者管理));
        }

        @Test
        public void 引数にDBAMN25002が渡された場合_DBAMN25002_届出により解除が返る() {
            JushochiTokureiMenuType result = JushochiTokureiMenuType.toValue(new RString("DBAMN25002"));
            assertThat(result, is(JushochiTokureiMenuType.DBAMN25002_届出により解除));
        }

        @Test
        public void 引数にDBAMN25003が渡された場合_DBAMN25003_届出により施設変更が返る() {
            JushochiTokureiMenuType result = JushochiTokureiMenuType.toValue(new RString("DBAMN25003"));
            assertThat(result, is(JushochiTokureiMenuType.DBAMN25003_届出により施設変更));
        }

        @Test
        public void 引数にDBAMN52002が渡された場合_DBAMN52002_合併前の住所地特例措置解除が返る() {
            JushochiTokureiMenuType result = JushochiTokureiMenuType.toValue(new RString("DBAMN52002"));
            assertThat(result, is(JushochiTokureiMenuType.DBAMN52002_合併前の住所地特例措置解除));
        }

        @Test
        public void 引数に該当する項目が存在しない場合_その他が返る() {
            JushochiTokureiMenuType result = JushochiTokureiMenuType.toValue(new RString("DBAMN04649"));
            assertThat(result, is(JushochiTokureiMenuType.その他));
        }
    }

    public static class is適用前の処理 extends DbaTestBase {

        @Test
        public void 適用前に行う処理であることを示すJushochiTokureiMenuTypeを渡すと_trueが返る() {
            assertThat(JushochiTokureiMenuType.DBAMN25001_届出により適用.is適用前の処理(), is(true));
        }

        @Test
        public void 適用中に行う処理であることを示すJushochiTokureiMenuTypeを渡すと_falseが返る() {
            assertThat(JushochiTokureiMenuType.DBAMN25002_届出により解除.is適用前の処理(), is(false));
        }

        @Test
        public void 上記どちらでも無い場合を示すJushochiTokureiMenuTypeを渡すと_falseが返る() {
            assertThat(JushochiTokureiMenuType.その他.is適用前の処理(), is(false));
        }
    }

    public static class is適用中の処理 extends DbaTestBase {

        @Test
        public void 適用前に行う処理であることを示すJushochiTokureiMenuTypeを渡すと_falseが返る() {
            assertThat(JushochiTokureiMenuType.DBAMN25001_届出により適用.is適用中の処理(), is(false));
        }

        @Test
        public void 適用中に行う処理であることを示すJushochiTokureiMenuTypeを渡すと_trueが返る() {
            assertThat(JushochiTokureiMenuType.DBAMN25002_届出により解除.is適用中の処理(), is(true));
        }

        @Test
        public void 上記どちらでも無い場合を示すJushochiTokureiMenuTypeを渡すと_falseが返る() {
            assertThat(JushochiTokureiMenuType.その他.is適用中の処理(), is(false));
        }

    }

}
