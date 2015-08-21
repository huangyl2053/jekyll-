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
 * 介護サービス種類の情報を表す列挙型のテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiSearchItemTest extends DbxTestBase {

    public KaigoServiceShuruiSearchItemTest() {
    }

    public static class getItemNameTest extends DbxTestBase {

        @Test
        public void LDNS_メソッドgetItemNameが呼び出される場合_getItemNameは_serviceShuruiMeishoを返す() {
            assertThat(KaigoServiceShuruiSearchItem.介護サービス名称.getItemName(), is("serviceShuruiMeisho"));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_介護サービス種類検索項目が提供終了年月の場合_valueOfは_提供終了年月を返す() {
            assertThat(KaigoServiceShuruiSearchItem.valueOf("提供終了年月"), is(KaigoServiceShuruiSearchItem.提供終了年月));
        }
    }

    public static class valuesTest extends DbxTestBase {

        @Test
        public void LDNS_メソッドvaluesが呼び出される場合_valuesは_lengthが6を返す() {
            assertThat(KaigoServiceShuruiSearchItem.values().length, is(6));
        }
    }
}
