/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3068KogakuGassanShinseishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanShinseisho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShinseishoTest extends DbcTestBase {

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

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShinseisho sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShinseisho(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShinseisho(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3068KogakuGassanShinseishoEntityにセットされている() {
            sut = new KogakuGassanShinseisho(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanShinseishoIdentifierにセットされている() {
            sut = new KogakuGassanShinseisho(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShinseisho sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanShinseisho(null);
        }

        @Test
        public void 指定したDbT3068KogakuGassanShinseishoEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanShinseisho(KogakuGassanShinseishoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanShinseisho sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShinseisho(KogakuGassanShinseishoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanShinseishoEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanShinseishoEntity.getTaishoNendo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KogakuGassanShinseishoEntity.getHokenshaNo()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KogakuGassanShinseishoEntity.getSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanShinseishoEntity.getRirekiNo()));
        }

        @Test
        public void get申請状況区分は_entityが持つ申請状況区分を返す() {
            assertThat(sut.get申請状況区分(), is(KogakuGassanShinseishoEntity.getShinseiJokyoKubun()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KogakuGassanShinseishoEntity.getShinseiYMD()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanShinseishoEntity.getShikyuShinseishoSeiriNo()));
        }

        @Test
        public void get国保支給申請書整理番号は_entityが持つ国保支給申請書整理番号を返す() {
            assertThat(sut.get国保支給申請書整理番号(), is(KogakuGassanShinseishoEntity.getKokuhoShikyuShinseishoSeiriNo()));
        }

        @Test
        public void get支給申請区分は_entityが持つ支給申請区分を返す() {
            assertThat(sut.get支給申請区分(), is(KogakuGassanShinseishoEntity.getShikyuShinseiKubun()));
        }

        @Test
        public void get対象計算期間開始年月日は_entityが持つ対象計算期間開始年月日を返す() {
            assertThat(sut.get対象計算期間開始年月日(), is(KogakuGassanShinseishoEntity.getTaishoKeisanKaishiYMD()));
        }

        @Test
        public void get対象計算期間終了年月日は_entityが持つ対象計算期間終了年月日を返す() {
            assertThat(sut.get対象計算期間終了年月日(), is(KogakuGassanShinseishoEntity.getTaishoKeisanShuryoYMD()));
        }

        @Test
        public void get支給申請形態は_entityが持つ支給申請形態を返す() {
            assertThat(sut.get支給申請形態(), is(KogakuGassanShinseishoEntity.getShikyuShinseiKeitai()));
        }

        @Test
        public void get自己負担額証明書交付申請の有無は_entityが持つ自己負担額証明書交付申請の有無を返す() {
            assertThat(sut.get自己負担額証明書交付申請の有無(), is(KogakuGassanShinseishoEntity.getJikoFutanKofuUmu()));
        }

        @Test
        public void get申請代表者氏名は_entityが持つ申請代表者氏名を返す() {
            assertThat(sut.get申請代表者氏名(), is(KogakuGassanShinseishoEntity.getShinseiDaihyoshaShimei()));
        }

        @Test
        public void get申請代表者郵便番号は_entityが持つ申請代表者郵便番号を返す() {
            assertThat(sut.get申請代表者郵便番号(), is(KogakuGassanShinseishoEntity.getShinseiDaihyoshaYubinNo()));
        }

        @Test
        public void get申請代表者住所は_entityが持つ申請代表者住所を返す() {
            assertThat(sut.get申請代表者住所(), is(KogakuGassanShinseishoEntity.getShinseiDaihyoshaJusho()));
        }

        @Test
        public void get申請代表者電話番号は_entityが持つ申請代表者電話番号を返す() {
            assertThat(sut.get申請代表者電話番号(), is(KogakuGassanShinseishoEntity.getShinseiDaihyoshaTelNo()));
        }

        @Test
        public void get所得区分は_entityが持つ所得区分を返す() {
            assertThat(sut.get所得区分(), is(KogakuGassanShinseishoEntity.getShotokuKubun()));
        }

        @Test
        public void get70歳以上の者に係る所得区分は_entityが持つ70歳以上の者に係る所得区分を返す() {
            assertThat(sut.get所得区分_70歳以上の者に係る(), is(KogakuGassanShinseishoEntity.getOver70_ShotokuKubun()));
        }

        @Test
        public void get資格喪失年月日は_entityが持つ資格喪失年月日を返す() {
            assertThat(sut.get資格喪失年月日(), is(KogakuGassanShinseishoEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get資格喪失事由は_entityが持つ資格喪失事由を返す() {
            assertThat(sut.get資格喪失事由(), is(KogakuGassanShinseishoEntity.getShikakuSoshitsuJiyu()));
        }

        @Test
        public void get加入期間開始年月日は_entityが持つ加入期間開始年月日を返す() {
            assertThat(sut.get加入期間開始年月日(), is(KogakuGassanShinseishoEntity.getKanyuKaishiYMD()));
        }

        @Test
        public void get加入期間終了年月日は_entityが持つ加入期間終了年月日を返す() {
            assertThat(sut.get加入期間終了年月日(), is(KogakuGassanShinseishoEntity.getKanyuShuryoYMD()));
        }

        @Test
        public void get国保保険者番号は_entityが持つ国保保険者番号を返す() {
            assertThat(sut.get国保保険者番号(), is(KogakuGassanShinseishoEntity.getKokuho_HokenshaNo()));
        }

        @Test
        public void get国保保険者名称は_entityが持つ国保保険者名称を返す() {
            assertThat(sut.get国保保険者名称(), is(KogakuGassanShinseishoEntity.getKokuho_HokenshaMeisho()));
        }

        @Test
        public void get国保被保険者証記号は_entityが持つ国保被保険者証記号を返す() {
            assertThat(sut.get国保被保険者証記号(), is(KogakuGassanShinseishoEntity.getKokuho_HihokenshaShoKigo()));
        }

        @Test
        public void get国保被保険者証番号は_entityが持つ国保被保険者証番号を返す() {
            assertThat(sut.get国保被保険者証番号(), is(KogakuGassanShinseishoEntity.getKokuho_HihokenshaShoNo()));
        }

        @Test
        public void get国保世帯番号は_entityが持つ国保世帯番号を返す() {
            assertThat(sut.get国保世帯番号(), is(KogakuGassanShinseishoEntity.getKokuho_SetaiNo()));
        }

        @Test
        public void get国保続柄は_entityが持つ国保続柄を返す() {
            assertThat(sut.get国保続柄(), is(KogakuGassanShinseishoEntity.getKokuho_Zokugara()));
        }

        @Test
        public void get国保加入期間開始年月日は_entityが持つ国保加入期間開始年月日を返す() {
            assertThat(sut.get国保加入期間開始年月日(), is(KogakuGassanShinseishoEntity.getKokuho_KanyuKaishiYMD()));
        }

        @Test
        public void get国保加入期間終了年月日は_entityが持つ国保加入期間終了年月日を返す() {
            assertThat(sut.get国保加入期間終了年月日(), is(KogakuGassanShinseishoEntity.getKokuho_KanyuShuryoYMD()));
        }

        @Test
        public void get後期保険者番号は_entityが持つ後期保険者番号を返す() {
            assertThat(sut.get後期保険者番号(), is(KogakuGassanShinseishoEntity.getKoki_HokenshaNo()));
        }

        @Test
        public void get後期広域連合名称は_entityが持つ後期広域連合名称を返す() {
            assertThat(sut.get後期広域連合名称(), is(KogakuGassanShinseishoEntity.getKoki_KoikiRengoMeisho()));
        }

        @Test
        public void get後期被保険者番号は_entityが持つ後期被保険者番号を返す() {
            assertThat(sut.get後期被保険者番号(), is(KogakuGassanShinseishoEntity.getKoki_HihokenshaNo()));
        }

        @Test
        public void get後期加入期間開始年月日は_entityが持つ後期加入期間開始年月日を返す() {
            assertThat(sut.get後期加入期間開始年月日(), is(KogakuGassanShinseishoEntity.getKoki_KanyuKaishiYMD()));
        }

        @Test
        public void get後期加入期間終了年月日は_entityが持つ後期加入期間終了年月日を返す() {
            assertThat(sut.get後期加入期間終了年月日(), is(KogakuGassanShinseishoEntity.getKoki_KanyuShuryoYMD()));
        }

        @Test
        public void get支払方法区分は_entityが持つ支払方法区分を返す() {
            assertThat(sut.get支払方法区分(), is(KogakuGassanShinseishoEntity.getShiharaiHohoKubun()));
        }

        @Test
        public void get支払場所は_entityが持つ支払場所を返す() {
            assertThat(sut.get支払場所(), is(KogakuGassanShinseishoEntity.getShiharaiBasho()));
        }

        @Test
        public void get支払期間開始年月日は_entityが持つ支払期間開始年月日を返す() {
            assertThat(sut.get支払期間開始年月日(), is(KogakuGassanShinseishoEntity.getShiharaiKaishiYMD()));
        }

        @Test
        public void get支払期間終了年月日は_entityが持つ支払期間終了年月日を返す() {
            assertThat(sut.get支払期間終了年月日(), is(KogakuGassanShinseishoEntity.getShiharaiShuryoYMD()));
        }

        @Test
        public void get閉庁内容は_entityが持つ閉庁内容を返す() {
            assertThat(sut.get閉庁内容(), is(KogakuGassanShinseishoEntity.getHeichoNaiyo()));
        }

        @Test
        public void get支払期間開始時間は_entityが持つ支払期間開始時間を返す() {
            assertThat(sut.get支払期間開始時間(), is(KogakuGassanShinseishoEntity.getShiharaiKaishiTime()));
        }

        @Test
        public void get支払期間終了時間は_entityが持つ支払期間終了時間を返す() {
            assertThat(sut.get支払期間終了時間(), is(KogakuGassanShinseishoEntity.getShiharaiShuryoTime()));
        }

        @Test
        public void get口座IDは_entityが持つ口座IDを返す() {
            assertThat(sut.get口座ID(), is(KogakuGassanShinseishoEntity.getKozaID()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KogakuGassanShinseishoEntity.getBiko()));
        }

        @Test
        public void get支給申請書情報送付年月は_entityが持つ支給申請書情報送付年月を返す() {
            assertThat(sut.get支給申請書情報送付年月(), is(KogakuGassanShinseishoEntity.getShikyuShinseisho_SofuYM()));
        }

        @Test
        public void get再送フラグは_entityが持つ再送フラグを返す() {
            assertThat(sut.get再送フラグ(), is(KogakuGassanShinseishoEntity.getSaiSofuFlag()));
        }

        @Test
        public void get自己負担額計算年月は_entityが持つ自己負担額計算年月を返す() {
            assertThat(sut.get自己負担額計算年月(), is(KogakuGassanShinseishoEntity.getJikoFutan_KeisanYM()));
        }

        @Test
        public void get再計算区分は_entityが持つ再計算区分を返す() {
            assertThat(sut.get再計算区分(), is(KogakuGassanShinseishoEntity.getSaiKeisanKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanShinseisho sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShinseisho(KogakuGassanShinseishoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanShinseishoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanShinseisho sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShinseisho(KogakuGassanShinseishoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanShinseisho sut;
        private static KogakuGassanShinseisho result;

        @Before
        public void setUp() {
            KogakuGassanShinseishoEntity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseishoEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoが返る() {
            sut = TestSupport.setStateKogakuGassanShinseisho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoが返る() {
            sut = TestSupport.setStateKogakuGassanShinseisho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoが返る() {
            sut = TestSupport.setStateKogakuGassanShinseisho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanShinseishoが保持するDbT3068KogakuGassanShinseishoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanShinseisho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanShinseisho setStateKogakuGassanShinseisho(EntityDataState parentState) {
            KogakuGassanShinseishoEntity.setState(parentState);
            return new KogakuGassanShinseisho(KogakuGassanShinseishoEntity);
        }
    }
}
