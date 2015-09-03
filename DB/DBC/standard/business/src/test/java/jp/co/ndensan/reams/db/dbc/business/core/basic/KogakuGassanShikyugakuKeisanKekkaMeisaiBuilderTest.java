/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShikyugakuKeisanKekkaMeisaiBuilderTest extends DbcTestBase {

    private static DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static RString 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号;
        主キー名6 = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisaiBuilder sut;
        private static KogakuGassanShikyugakuKeisanKekkaMeisai business;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = new DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);

            business = new KogakuGassanShikyugakuKeisanKekkaMeisai(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            business = sut.set明細番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号).build();
            assertThat(business.get明細番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            business = sut.set保険制度コード(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_保険制度コード).build();
            assertThat(business.get保険制度コード(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の内訳保険者番号は_設定した値と同じ内訳保険者番号を返す() {
            business = sut.set内訳保険者番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者番号).build();
            assertThat(business.get内訳保険者番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者番号));
        }

        @Test
        public void 戻り値の国保被保険者証記号は_設定した値と同じ国保被保険者証記号を返す() {
            business = sut.set国保被保険者証記号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_国保被保険者証記号).build();
            assertThat(business.get国保被保険者証記号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_国保被保険者証記号));
        }

        @Test
        public void 戻り値の被保険者_証番号は_設定した値と同じ被保険者_証_番号を返す() {
            business = sut.set被保険者_証番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者_証_番号).build();
            assertThat(business.get被保険者_証番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_被保険者_証_番号));
        }

        @Test
        public void 戻り値の内訳保険者名は_設定した値と同じ内訳保険者名を返す() {
            business = sut.set内訳保険者名(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者名).build();
            assertThat(business.get内訳保険者名(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_内訳保険者名));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            business = sut.set自己負担額証明書整理番号(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_自己負担額証明書整理番号).build();
            assertThat(business.get自己負担額証明書整理番号(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の対象者氏名_漢字_は_設定した値と同じ対象者氏名_漢字_を返す() {
            business = sut.set対象者氏名_漢字(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象者氏名_漢字).build();
            assertThat(business.get対象者氏名_漢字(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_対象者氏名_漢字));
        }

        @Test
        public void 戻り値の70歳以上負担額は_設定した値と同じ70歳以上負担額を返す() {
            business = sut.set70歳以上負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上負担額).build();
            assertThat(business.get70歳以上負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上負担額));
        }

        @Test
        public void 戻り値の70歳以上按分率は_設定した値と同じ70歳以上按分率を返す() {
            business = sut.set70歳以上按分率(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上按分率).build();
            assertThat(business.get70歳以上按分率(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上按分率));
        }

        @Test
        public void 戻り値の70歳以上支給額は_設定した値と同じ70歳以上支給額を返す() {
            business = sut.set70歳以上支給額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上支給額).build();
            assertThat(business.get70歳以上支給額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳以上支給額));
        }

        @Test
        public void 戻り値の70歳未満負担額は_設定した値と同じ70歳未満負担額を返す() {
            business = sut.set70歳未満負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満負担額).build();
            assertThat(business.get70歳未満負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満負担額));
        }

        @Test
        public void 戻り値の負担額は_設定した値と同じ負担額を返す() {
            business = sut.set負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_負担額).build();
            assertThat(business.get負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_負担額));
        }

        @Test
        public void 戻り値の按分率は_設定した値と同じ按分率を返す() {
            business = sut.set按分率(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_按分率).build();
            assertThat(business.get按分率(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_按分率));
        }

        @Test
        public void 戻り値の70歳未満支給額は_設定した値と同じ70歳未満支給額を返す() {
            business = sut.set70歳未満支給額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満支給額).build();
            assertThat(business.get70歳未満支給額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_70歳未満支給額));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            business = sut.set支給額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給額).build();
            assertThat(business.get支給額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の備考欄記載70歳以上負担額は_設定した値と同じ備考欄記載70歳以上負担額を返す() {
            business = sut.set備考欄記載70歳以上負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳以上負担額).build();
            assertThat(business.get備考欄記載70歳以上負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳以上負担額));
        }

        @Test
        public void 戻り値の備考欄記載70歳未満負担額は_設定した値と同じ備考欄記載70歳未満負担額を返す() {
            business = sut.set備考欄記載70歳未満負担額(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳未満負担額).build();
            assertThat(business.get備考欄記載70歳未満負担額(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_備考欄記載70歳未満負担額));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            business = sut.setデータ区分(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_データ区分).build();
            assertThat(business.getデータ区分(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_データ区分));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            business = sut.set受取年月(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_受取年月).build();
            assertThat(business.get受取年月(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_受取年月));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.DEFAULT_送付年月));
        }

    }
}
