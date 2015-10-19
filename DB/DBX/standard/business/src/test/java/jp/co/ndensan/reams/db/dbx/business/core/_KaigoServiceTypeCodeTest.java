/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービス種類コードを表したクラステストです。
 *
 * @author LDNS 李鋭
 */
@RunWith(Enclosed.class)
public class _KaigoServiceTypeCodeTest extends DbxTestBase {

    private static _KaigoServiceTypeCode sut;

    @BeforeClass
    public static void setUpClass() {
        RString サービス種類コード = new RString("001");
        sut = new _KaigoServiceTypeCode(サービス種類コード);
    }

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void LDNS_コンストラクタの引数のサービス種類コードにnullを指定した場合__KaigoServiceTypeCodeは_NullPointerExceptionが発生する() {
            sut = new _KaigoServiceTypeCode(null);
        }
    }

    public static class getValueのテスト extends DbxTestBase {

        @Test
        public void LDNS_サービス種類コード指定する場合_getValueは_001を返す() {
            assertThat(sut.getValue(), is(new RString("001")));
        }
    }
}
