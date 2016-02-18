/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanKyufuJissekiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanKyufuJissekiBuilderTest extends DbcTestBase {

    private static DbT3075KogakuGassanKyufuJissekiEntity KogakuGassanKyufuJissekiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static RString 主キー名3;
    private static RString 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuGassanKyufuJissekiBuilder sut;
        private static KogakuGassanKyufuJisseki business;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = new DbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);

            business = new KogakuGassanKyufuJisseki(KogakuGassanKyufuJissekiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            business = sut.set自己負担額証明書整理番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担額証明書整理番号).build();
            assertThat(business.get自己負担額証明書整理番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

        @Test
        public void 戻り値の保険制度コードは_設定した値と同じ保険制度コードを返す() {
            business = sut.set保険制度コード(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_保険制度コード).build();
            assertThat(business.get保険制度コード(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_保険制度コード));
        }

        @Test
        public void 戻り値の給付実績作成区分コードは_設定した値と同じ給付実績作成区分コードを返す() {
            business = sut.set給付実績作成区分コード(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_給付実績作成区分コード).build();
            assertThat(business.get給付実績作成区分コード(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_給付実績作成区分コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の国保_被保険者証記号は_設定した値と同じ国保_被保険者証記号を返す() {
            business = sut.set国保_被保険者証記号(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_国保_被保険者証記号).build();
            assertThat(business.get国保_被保険者証記号(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_国保_被保険者証記号));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の自己負担総額は_設定した値と同じ自己負担総額を返す() {
            business = sut.set自己負担総額(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担総額).build();
            assertThat(business.get自己負担総額(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_自己負担総額));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            business = sut.set支給額(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給額).build();
            assertThat(business.get支給額(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の処理年月は_設定した値と同じ処理年月を返す() {
            business = sut.set処理年月(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理年月).build();
            assertThat(business.get処理年月(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理年月));
        }

        @Test
        public void 戻り値の受取年月は_設定した値と同じ受取年月を返す() {
            business = sut.set受取年月(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_受取年月).build();
            assertThat(business.get受取年月(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_受取年月));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値のデータ区分は_設定した値と同じデータ区分を返す() {
            business = sut.setデータ区分(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_データ区分).build();
            assertThat(business.getデータ区分(), is(DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_データ区分));
        }

    }
}
