/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3068KogakuGassanShinseishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
 * {@link KogakuGassanShinseishoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShinseishoBuilderTest extends DbcTestBase {

    private static DbT3068KogakuGassanShinseishoEntity KogakuGassanShinseishoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static Decimal 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
        主キー名5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KogakuGassanShinseishoBuilder sut;
        private static KogakuGassanShinseisho business;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = new DbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);

            business = new KogakuGassanShinseisho(KogakuGassanShinseishoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申請状況区分は_設定した値と同じ申請状況区分を返す() {
            business = sut.set申請状況区分(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請状況区分).build();
            assertThat(business.get申請状況区分(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請状況区分));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            business = sut.set支給申請書整理番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請書整理番号).build();
            assertThat(business.get支給申請書整理番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の国保支給申請書整理番号は_設定した値と同じ国保支給申請書整理番号を返す() {
            business = sut.set国保支給申請書整理番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保支給申請書整理番号).build();
            assertThat(business.get国保支給申請書整理番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保支給申請書整理番号));
        }

        @Test
        public void 戻り値の支給申請区分は_設定した値と同じ支給申請区分を返す() {
            business = sut.set支給申請区分(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請区分).build();
            assertThat(business.get支給申請区分(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請区分));
        }

        @Test
        public void 戻り値の対象計算期間開始年月日は_設定した値と同じ対象計算期間開始年月日を返す() {
            business = sut.set対象計算期間開始年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象計算期間開始年月日).build();
            assertThat(business.get対象計算期間開始年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象計算期間開始年月日));
        }

        @Test
        public void 戻り値の対象計算期間終了年月日は_設定した値と同じ対象計算期間終了年月日を返す() {
            business = sut.set対象計算期間終了年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象計算期間終了年月日).build();
            assertThat(business.get対象計算期間終了年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象計算期間終了年月日));
        }

        @Test
        public void 戻り値の支給申請形態は_設定した値と同じ支給申請形態を返す() {
            business = sut.set支給申請形態(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請形態).build();
            assertThat(business.get支給申請形態(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請形態));
        }

        @Test
        public void 戻り値の自己負担額証明書交付申請の有無は_設定した値と同じ自己負担額証明書交付申請の有無を返す() {
            business = sut.set自己負担額証明書交付申請の有無(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_自己負担額証明書交付申請の有無).build();
            assertThat(business.get自己負担額証明書交付申請の有無(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_自己負担額証明書交付申請の有無));
        }

        @Test
        public void 戻り値の申請代表者氏名は_設定した値と同じ申請代表者氏名を返す() {
            business = sut.set申請代表者氏名(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者氏名).build();
            assertThat(business.get申請代表者氏名(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者氏名));
        }

        @Test
        public void 戻り値の申請代表者郵便番号は_設定した値と同じ申請代表者郵便番号を返す() {
            business = sut.set申請代表者郵便番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者郵便番号).build();
            assertThat(business.get申請代表者郵便番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者郵便番号));
        }

        @Test
        public void 戻り値の申請代表者住所は_設定した値と同じ申請代表者住所を返す() {
            business = sut.set申請代表者住所(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者住所).build();
            assertThat(business.get申請代表者住所(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者住所));
        }

        @Test
        public void 戻り値の申請代表者電話番号は_設定した値と同じ申請代表者電話番号を返す() {
            business = sut.set申請代表者電話番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者電話番号).build();
            assertThat(business.get申請代表者電話番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_申請代表者電話番号));
        }

        @Test
        public void 戻り値の所得区分は_設定した値と同じ所得区分を返す() {
            business = sut.set所得区分(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_所得区分).build();
            assertThat(business.get所得区分(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_所得区分));
        }

        @Test
        public void 戻り値の70歳以上の者に係る所得区分は_設定した値と同じ70歳以上の者に係る所得区分を返す() {
            business = sut.set所得区分_70歳以上の者に係る(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_70歳以上の者に係る所得区分).build();
            assertThat(business.get所得区分_70歳以上の者に係る(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_70歳以上の者に係る所得区分));
        }

        @Test
        public void 戻り値の資格喪失年月日は_設定した値と同じ資格喪失年月日を返す() {
            business = sut.set資格喪失年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_資格喪失年月日).build();
            assertThat(business.get資格喪失年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_資格喪失年月日));
        }

        @Test
        public void 戻り値の資格喪失事由は_設定した値と同じ資格喪失事由を返す() {
            business = sut.set資格喪失事由(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_資格喪失事由).build();
            assertThat(business.get資格喪失事由(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_資格喪失事由));
        }

        @Test
        public void 戻り値の加入期間開始年月日は_設定した値と同じ加入期間開始年月日を返す() {
            business = sut.set加入期間開始年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_加入期間開始年月日).build();
            assertThat(business.get加入期間開始年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_加入期間開始年月日));
        }

        @Test
        public void 戻り値の加入期間終了年月日は_設定した値と同じ加入期間終了年月日を返す() {
            business = sut.set加入期間終了年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_加入期間終了年月日).build();
            assertThat(business.get加入期間終了年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_加入期間終了年月日));
        }

        @Test
        public void 戻り値の国保保険者番号は_設定した値と同じ国保保険者番号を返す() {
            business = sut.set国保保険者番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保保険者番号).build();
            assertThat(business.get国保保険者番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保保険者番号));
        }

        @Test
        public void 戻り値の国保保険者名称は_設定した値と同じ国保保険者名称を返す() {
            business = sut.set国保保険者名称(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保保険者名称).build();
            assertThat(business.get国保保険者名称(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保保険者名称));
        }

        @Test
        public void 戻り値の国保被保険者証記号は_設定した値と同じ国保被保険者証記号を返す() {
            business = sut.set国保被保険者証記号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保被保険者証記号).build();
            assertThat(business.get国保被保険者証記号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保被保険者証記号));
        }

        @Test
        public void 戻り値の国保被保険者証番号は_設定した値と同じ国保被保険者証番号を返す() {
            business = sut.set国保被保険者証番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保被保険者証番号).build();
            assertThat(business.get国保被保険者証番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保被保険者証番号));
        }

        @Test
        public void 戻り値の国保世帯番号は_設定した値と同じ国保世帯番号を返す() {
            business = sut.set国保世帯番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保世帯番号).build();
            assertThat(business.get国保世帯番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保世帯番号));
        }

        @Test
        public void 戻り値の国保続柄は_設定した値と同じ国保続柄を返す() {
            business = sut.set国保続柄(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保続柄).build();
            assertThat(business.get国保続柄(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保続柄));
        }

        @Test
        public void 戻り値の国保加入期間開始年月日は_設定した値と同じ国保加入期間開始年月日を返す() {
            business = sut.set国保加入期間開始年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保加入期間開始年月日).build();
            assertThat(business.get国保加入期間開始年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保加入期間開始年月日));
        }

        @Test
        public void 戻り値の国保加入期間終了年月日は_設定した値と同じ国保加入期間終了年月日を返す() {
            business = sut.set国保加入期間終了年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保加入期間終了年月日).build();
            assertThat(business.get国保加入期間終了年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_国保加入期間終了年月日));
        }

        @Test
        public void 戻り値の後期保険者番号は_設定した値と同じ後期保険者番号を返す() {
            business = sut.set後期保険者番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期保険者番号).build();
            assertThat(business.get後期保険者番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期保険者番号));
        }

        @Test
        public void 戻り値の後期広域連合名称は_設定した値と同じ後期広域連合名称を返す() {
            business = sut.set後期広域連合名称(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期広域連合名称).build();
            assertThat(business.get後期広域連合名称(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期広域連合名称));
        }

        @Test
        public void 戻り値の後期被保険者番号は_設定した値と同じ後期被保険者番号を返す() {
            business = sut.set後期被保険者番号(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期被保険者番号).build();
            assertThat(business.get後期被保険者番号(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期被保険者番号));
        }

        @Test
        public void 戻り値の後期加入期間開始年月日は_設定した値と同じ後期加入期間開始年月日を返す() {
            business = sut.set後期加入期間開始年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期加入期間開始年月日).build();
            assertThat(business.get後期加入期間開始年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期加入期間開始年月日));
        }

        @Test
        public void 戻り値の後期加入期間終了年月日は_設定した値と同じ後期加入期間終了年月日を返す() {
            business = sut.set後期加入期間終了年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期加入期間終了年月日).build();
            assertThat(business.get後期加入期間終了年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_後期加入期間終了年月日));
        }

        @Test
        public void 戻り値の支払方法区分は_設定した値と同じ支払方法区分を返す() {
            business = sut.set支払方法区分(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払方法区分).build();
            assertThat(business.get支払方法区分(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払方法区分));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            business = sut.set支払場所(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払場所).build();
            assertThat(business.get支払場所(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            business = sut.set支払期間開始年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間開始年月日).build();
            assertThat(business.get支払期間開始年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            business = sut.set支払期間終了年月日(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間終了年月日).build();
            assertThat(business.get支払期間終了年月日(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            business = sut.set閉庁内容(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_閉庁内容).build();
            assertThat(business.get閉庁内容(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払期間開始時間は_設定した値と同じ支払期間開始時間を返す() {
            business = sut.set支払期間開始時間(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間開始時間).build();
            assertThat(business.get支払期間開始時間(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間開始時間));
        }

        @Test
        public void 戻り値の支払期間終了時間は_設定した値と同じ支払期間終了時間を返す() {
            business = sut.set支払期間終了時間(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間終了時間).build();
            assertThat(business.get支払期間終了時間(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支払期間終了時間));
        }

        @Test
        public void 戻り値の口座IDは_設定した値と同じ口座IDを返す() {
            business = sut.set口座ID(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_口座ID).build();
            assertThat(business.get口座ID(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_口座ID));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の支給申請書情報送付年月は_設定した値と同じ支給申請書情報送付年月を返す() {
            business = sut.set支給申請書情報送付年月(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請書情報送付年月).build();
            assertThat(business.get支給申請書情報送付年月(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_支給申請書情報送付年月));
        }

        @Test
        public void 戻り値の再送フラグは_設定した値と同じ再送フラグを返す() {
            business = sut.set再送フラグ(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_再送フラグ).build();
            assertThat(business.get再送フラグ(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_再送フラグ));
        }

        @Test
        public void 戻り値の自己負担額計算年月は_設定した値と同じ自己負担額計算年月を返す() {
            business = sut.set自己負担額計算年月(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_自己負担額計算年月).build();
            assertThat(business.get自己負担額計算年月(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_自己負担額計算年月));
        }

        @Test
        public void 戻り値の再計算区分は_設定した値と同じ再計算区分を返す() {
            business = sut.set再計算区分(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_再計算区分).build();
            assertThat(business.get再計算区分(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_再計算区分));
        }

    }
}
