/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.search;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービス内容の情報を表す列挙型のテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyoSearchItemTest extends DbxTestBase {

    public KaigoServiceNaiyoSearchItemTest() {
    }

    public static class getItemNameTest extends DbxTestBase {

        @Test
        public void LDNS_メソッドgetItemNameが呼び出される場合_getItemNameは_serviceNameを返す() {
            assertThat(KaigoServiceNaiyoSearchItem.サービス名称.getItemName(), is("serviceName"));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_介護サービス内容検索項目が単位数の場合_valueOfは_単位数を返す() {
            assertThat(KaigoServiceNaiyoSearchItem.valueOf("単位数"), is(KaigoServiceNaiyoSearchItem.単位数));
        }
    }

    public static class valuesTest extends DbxTestBase {

        @Test
        public void LDNS_メソッドvaluesが呼び出される場合_valuesは_lengthが10を返す() {
            assertThat(KaigoServiceNaiyoSearchItem.values().length, is(10));
        }
    }
}
