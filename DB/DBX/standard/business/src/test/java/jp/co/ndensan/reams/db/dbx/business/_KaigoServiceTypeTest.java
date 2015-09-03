/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービス種類を扱うクラステストです。
 *
 * @author LDNS 李鋭
 */
@RunWith(Enclosed.class)
public class _KaigoServiceTypeTest extends DbxTestBase {

    private static _KaigoServiceType sut;

    private static final IKaigoServiceTypeCode サービス種類コード = new _KaigoServiceTypeCode(new RString("010"));
    private static final RYearMonth 提供開始年月 = new RYearMonth("201503");
    private static final RString サービス種類名称 = new RString("001");
    private static final RString サービス種類略称 = new RString("002");
    private static final RString サービス分類 = new RString("003");

    @BeforeClass
    public static void setUpClass() {
        sut = new _KaigoServiceType(サービス種類コード, 提供開始年月, サービス種類名称, サービス種類略称, サービス分類);
    }

    public static class getサービス種類コードのテスト extends DbxTestBase {

        @Test
        public void LDNS_サービス種類コードを指定する場合_getサービス種類コードは_サービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
        }
    }

    public static class get提供開始年月のテスト extends DbxTestBase {

        @Test
        public void LDNS_提供開始年月を指定する場合_get提供開始年月は_201503を返す() {
            assertThat(sut.get提供開始年月(), is(new RYearMonth("201503")));
        }
    }

    public static class getサービス種類名称のテスト extends DbxTestBase {

        @Test
        public void LDNS_サービス種類名称を指定する場合_getサービス種類名称は_001を返す() {
            assertThat(sut.getサービス種類名称(), is(new RString("001")));
        }
    }

    public static class getサービス種類略称のテスト extends DbxTestBase {

        @Test
        public void LDNS_サービス種類略称を指定する場合_getサービス種類略称は_002を返す() {
            assertThat(sut.getサービス種類略称(), is(new RString("002")));
        }
    }

    public static class getサービス分類のテスト extends DbxTestBase {

        @Test
        public void LDNS_サービス分類を指定する場合_getサービス分類は_003を返す() {
            assertThat(sut.getサービス分類(), is(new RString("003")));
        }
    }
}
