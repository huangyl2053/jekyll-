/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategory;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * サービス種類コードを元にサービスカテゴリーを返すクラス。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceCategoryTest extends DbcTestBase {

    public static class getカテゴリのテスト extends DbcTestBase {

        KyufuJissekiServiceCategory sut = new KyufuJissekiServiceCategory();

        public void setUp() {
        }

        @Test
        public void nullを指定したとき_nullを返す() {
            assertThat(sut.get合計カテゴリ(null),
                    nullValue());
        }

        @Test
        public void サービス種類_訪問介護_11_を指定したとき_居宅サービスを返す() {
            assertThat(sut.get合計カテゴリ(new ServiceShuruiCode(new RString("11"))),
                    is(ServiceCategory.居宅サービス));
        }

        @Test
        public void サービス種類_予防特定施設入所者生活介護_35_を指定したとき_居宅サービスを返す() {
            assertThat(sut.get合計カテゴリ(new ServiceShuruiCode(new RString("35"))),
                    is(ServiceCategory.居宅サービス));
        }

        @Test
        public void サービス種類_介護福祉施設サービス_51_を指定したとき_施設サービスを返す() {
            assertThat(sut.get合計カテゴリ(new ServiceShuruiCode(new RString("51"))),
                    is(ServiceCategory.施設サービス));
        }

        @Test
        public void サービス種類_介護療養施設サービス_53_を指定したとき_施設サービスを返す() {
            assertThat(sut.get合計カテゴリ(new ServiceShuruiCode(new RString("53"))),
                    is(ServiceCategory.施設サービス));
        }

        @Test
        public void サービス種類_認知症対応型共同生活介護_32_を指定したとき_地域密着型サービスを返す() {
            assertThat(sut.get合計カテゴリ(new ServiceShuruiCode(new RString("32"))),
                    is(ServiceCategory.地域密着型サービス));
        }

        @Test
        public void サービス種類_地域密着型介護老人福祉施設_54_を指定したとき_地域密着型サービスを返す() {
            assertThat(sut.get合計カテゴリ(new ServiceShuruiCode(new RString("54"))),
                    is(ServiceCategory.地域密着型サービス));
        }
    }
}
