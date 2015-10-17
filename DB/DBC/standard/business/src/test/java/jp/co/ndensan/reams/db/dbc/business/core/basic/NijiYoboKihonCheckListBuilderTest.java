/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NijiYoboKihonCheckListBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboKihonCheckListBuilderTest extends DbcTestBase {

    private static DbT3101NijiYoboKihonCheckListEntity NijiYoboKihonCheckListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 受付年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
        被保険者番号 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
        受付年月日 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日;
        履歴番号 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static NijiYoboKihonCheckListBuilder sut;
        private static NijiYoboKihonCheckList business;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = new DbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

            business = new NijiYoboKihonCheckList(NijiYoboKihonCheckListEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の記入年月日は_設定した値と同じ記入年月日を返す() {
            business = sut.set記入年月日(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_記入年月日).build();
            assertThat(business.get記入年月日(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_記入年月日));
        }

        @Test
        public void 戻り値の質問事項１は_設定した値と同じ質問事項１を返す() {
            business = sut.set質問事項１(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１).build();
            assertThat(business.get質問事項１(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１));
        }

        @Test
        public void 戻り値の質問事項２は_設定した値と同じ質問事項２を返す() {
            business = sut.set質問事項２(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２).build();
            assertThat(business.get質問事項２(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２));
        }

        @Test
        public void 戻り値の質問事項３は_設定した値と同じ質問事項３を返す() {
            business = sut.set質問事項３(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項３).build();
            assertThat(business.get質問事項３(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項３));
        }

        @Test
        public void 戻り値の質問事項４は_設定した値と同じ質問事項４を返す() {
            business = sut.set質問事項４(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項４).build();
            assertThat(business.get質問事項４(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項４));
        }

        @Test
        public void 戻り値の質問事項５は_設定した値と同じ質問事項５を返す() {
            business = sut.set質問事項５(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項５).build();
            assertThat(business.get質問事項５(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項５));
        }

        @Test
        public void 戻り値の質問事項６は_設定した値と同じ質問事項６を返す() {
            business = sut.set質問事項６(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項６).build();
            assertThat(business.get質問事項６(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項６));
        }

        @Test
        public void 戻り値の質問事項７は_設定した値と同じ質問事項７を返す() {
            business = sut.set質問事項７(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項７).build();
            assertThat(business.get質問事項７(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項７));
        }

        @Test
        public void 戻り値の質問事項８は_設定した値と同じ質問事項８を返す() {
            business = sut.set質問事項８(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項８).build();
            assertThat(business.get質問事項８(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項８));
        }

        @Test
        public void 戻り値の質問事項９は_設定した値と同じ質問事項９を返す() {
            business = sut.set質問事項９(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項９).build();
            assertThat(business.get質問事項９(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項９));
        }

        @Test
        public void 戻り値の質問事項１０は_設定した値と同じ質問事項１０を返す() {
            business = sut.set質問事項１０(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１０).build();
            assertThat(business.get質問事項１０(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１０));
        }

        @Test
        public void 戻り値の質問事項１１は_設定した値と同じ質問事項１１を返す() {
            business = sut.set質問事項１１(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１１).build();
            assertThat(business.get質問事項１１(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１１));
        }

        @Test
        public void 戻り値の質問事項１２身長は_設定した値と同じ質問事項１２身長を返す() {
            business = sut.set質問事項１２身長(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２身長).build();
            assertThat(business.get質問事項１２身長(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２身長));
        }

        @Test
        public void 戻り値の質問事項１２体重は_設定した値と同じ質問事項１２体重を返す() {
            business = sut.set質問事項１２体重(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２体重).build();
            assertThat(business.get質問事項１２体重(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１２体重));
        }

        @Test
        public void 戻り値の質問事項１３は_設定した値と同じ質問事項１３を返す() {
            business = sut.set質問事項１３(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１３).build();
            assertThat(business.get質問事項１３(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１３));
        }

        @Test
        public void 戻り値の質問事項１４は_設定した値と同じ質問事項１４を返す() {
            business = sut.set質問事項１４(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１４).build();
            assertThat(business.get質問事項１４(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１４));
        }

        @Test
        public void 戻り値の質問事項１５は_設定した値と同じ質問事項１５を返す() {
            business = sut.set質問事項１５(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１５).build();
            assertThat(business.get質問事項１５(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１５));
        }

        @Test
        public void 戻り値の質問事項１６は_設定した値と同じ質問事項１６を返す() {
            business = sut.set質問事項１６(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１６).build();
            assertThat(business.get質問事項１６(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１６));
        }

        @Test
        public void 戻り値の質問事項１７は_設定した値と同じ質問事項１７を返す() {
            business = sut.set質問事項１７(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１７).build();
            assertThat(business.get質問事項１７(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１７));
        }

        @Test
        public void 戻り値の質問事項１８は_設定した値と同じ質問事項１８を返す() {
            business = sut.set質問事項１８(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１８).build();
            assertThat(business.get質問事項１８(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１８));
        }

        @Test
        public void 戻り値の質問事項１９は_設定した値と同じ質問事項１９を返す() {
            business = sut.set質問事項１９(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１９).build();
            assertThat(business.get質問事項１９(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項１９));
        }

        @Test
        public void 戻り値の質問事項２０は_設定した値と同じ質問事項２０を返す() {
            business = sut.set質問事項２０(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２０).build();
            assertThat(business.get質問事項２０(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２０));
        }

        @Test
        public void 戻り値の質問事項２１は_設定した値と同じ質問事項２１を返す() {
            business = sut.set質問事項２１(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２１).build();
            assertThat(business.get質問事項２１(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２１));
        }

        @Test
        public void 戻り値の質問事項２２は_設定した値と同じ質問事項２２を返す() {
            business = sut.set質問事項２２(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２２).build();
            assertThat(business.get質問事項２２(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２２));
        }

        @Test
        public void 戻り値の質問事項２３は_設定した値と同じ質問事項２３を返す() {
            business = sut.set質問事項２３(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２３).build();
            assertThat(business.get質問事項２３(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２３));
        }

        @Test
        public void 戻り値の質問事項２４は_設定した値と同じ質問事項２４を返す() {
            business = sut.set質問事項２４(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２４).build();
            assertThat(business.get質問事項２４(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２４));
        }

        @Test
        public void 戻り値の質問事項２５は_設定した値と同じ質問事項２５を返す() {
            business = sut.set質問事項２５(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２５).build();
            assertThat(business.get質問事項２５(), is(DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_質問事項２５));
        }

    }
}
