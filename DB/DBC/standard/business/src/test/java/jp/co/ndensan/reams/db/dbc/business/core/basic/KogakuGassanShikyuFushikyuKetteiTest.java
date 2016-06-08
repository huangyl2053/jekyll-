/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link KogakuGassanShikyuFushikyuKettei}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuGassanShikyuFushikyuKetteiTest extends DbcTestBase {

    private static DbT3074KogakuGassanShikyuFushikyuKetteiEntity KogakuGassanShikyuFushikyuKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static int 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKettei sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShikyuFushikyuKettei(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShikyuFushikyuKettei(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityにセットされている() {
            sut = new KogakuGassanShikyuFushikyuKettei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanShikyuFushikyuKetteiIdentifierにセットされている() {
            sut = new KogakuGassanShikyuFushikyuKettei(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKettei sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanShikyuFushikyuKettei(null);
        }

        @Test
        public void 指定したDbT3074KogakuGassanShikyuFushikyuKetteiEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanShikyuFushikyuKettei(KogakuGassanShikyuFushikyuKetteiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKettei sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyuFushikyuKettei(KogakuGassanShikyuFushikyuKetteiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanShikyuFushikyuKetteiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanShikyuFushikyuKetteiEntity.getTaishoNendo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KogakuGassanShikyuFushikyuKetteiEntity.getHokenshaNo()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShikyuSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanShikyuFushikyuKetteiEntity.getRirekiNo()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanShikyuFushikyuKetteiEntity.getJikoFutanSeiriNo()));
        }

        @Test
        public void get保険制度コードは_entityが持つ保険制度コードを返す() {
            assertThat(sut.get保険制度コード(), is(KogakuGassanShikyuFushikyuKetteiEntity.getHokenSeidoCode()));
        }

        @Test
        public void get国保_被保険者証記号は_entityが持つ国保_被保険者証記号を返す() {
            assertThat(sut.get国保_被保険者証記号(), is(KogakuGassanShikyuFushikyuKetteiEntity.getKokuho_HihokenshaShoKigo()));
        }

        @Test
        public void get対象計算期間開始年月日は_entityが持つ対象計算期間開始年月日を返す() {
            assertThat(sut.get対象計算期間開始年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getKeisanKaishiYMD()));
        }

        @Test
        public void get対象計算期間終了年月日は_entityが持つ対象計算期間終了年月日を返す() {
            assertThat(sut.get対象計算期間終了年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getKeisanShuryoYMD()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShinseiYMD()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getKetteiYMD()));
        }

        @Test
        public void get自己負担総額は_entityが持つ自己負担総額を返す() {
            assertThat(sut.get自己負担総額(), is(KogakuGassanShikyuFushikyuKetteiEntity.getJikoFutanSogaku()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShikyuKubunCode()));
        }

        @Test
        public void get支給額は_entityが持つ支給額を返す() {
            assertThat(sut.get支給額(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShikyugaku()));
        }

        @Test
        public void get給付の種類は_entityが持つ給付の種類を返す() {
            assertThat(sut.get給付の種類(), is(KogakuGassanShikyuFushikyuKetteiEntity.getKyufuShurui()));
        }

        @Test
        public void get不支給理由は_entityが持つ不支給理由を返す() {
            assertThat(sut.get不支給理由(), is(KogakuGassanShikyuFushikyuKetteiEntity.getFushikyuRiyu()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KogakuGassanShikyuFushikyuKetteiEntity.getBiko()));
        }

        @Test
        public void get支払方法区分は_entityが持つ支払方法区分を返す() {
            assertThat(sut.get支払方法区分(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShiharaiHohoKubun()));
        }

        @Test
        public void get支払場所は_entityが持つ支払場所を返す() {
            assertThat(sut.get支払場所(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShiharaiBasho()));
        }

        @Test
        public void get支払期間開始年月日は_entityが持つ支払期間開始年月日を返す() {
            assertThat(sut.get支払期間開始年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShiharaiKaishiYMD()));
        }

        @Test
        public void get支払期間終了年月日は_entityが持つ支払期間終了年月日を返す() {
            assertThat(sut.get支払期間終了年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShiharaiShuryoYMD()));
        }

        @Test
        public void get閉庁内容は_entityが持つ閉庁内容を返す() {
            assertThat(sut.get閉庁内容(), is(KogakuGassanShikyuFushikyuKetteiEntity.getHeichoNaiyo()));
        }

        @Test
        public void get支払期間開始時間は_entityが持つ支払期間開始時間を返す() {
            assertThat(sut.get支払期間開始時間(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShiharaiKaishiTime()));
        }

        @Test
        public void get支払期間終了時間は_entityが持つ支払期間終了時間を返す() {
            assertThat(sut.get支払期間終了時間(), is(KogakuGassanShikyuFushikyuKetteiEntity.getShiharaiShuryoTime()));
        }

        @Test
        public void get決定通知書作成年月日は_entityが持つ決定通知書作成年月日を返す() {
            assertThat(sut.get決定通知書作成年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getKetteiTsuchiSakuseiYMD()));
        }

        @Test
        public void get振込通知書作成年月日は_entityが持つ振込通知書作成年月日を返す() {
            assertThat(sut.get振込通知書作成年月日(), is(KogakuGassanShikyuFushikyuKetteiEntity.getFurikomiTsuchiSakuseiYMD()));
        }

        @Test
        public void get受取年月は_entityが持つ受取年月を返す() {
            assertThat(sut.get受取年月(), is(KogakuGassanShikyuFushikyuKetteiEntity.getUketoriYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKettei sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyuFushikyuKettei(KogakuGassanShikyuFushikyuKetteiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanShikyuFushikyuKetteiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKettei sut;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyuFushikyuKettei(KogakuGassanShikyuFushikyuKetteiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanShikyuFushikyuKettei sut;
        private static KogakuGassanShikyuFushikyuKettei result;

        @Before
        public void setUp() {
            KogakuGassanShikyuFushikyuKetteiEntity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            KogakuGassanShikyuFushikyuKetteiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyuFushikyuKetteiEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyuFushikyuKetteiが返る() {
            sut = TestSupport.setStateKogakuGassanShikyuFushikyuKettei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyuFushikyuKetteiが返る() {
            sut = TestSupport.setStateKogakuGassanShikyuFushikyuKettei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyuFushikyuKetteiが返る() {
            sut = TestSupport.setStateKogakuGassanShikyuFushikyuKettei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanShikyuFushikyuKetteiが保持するDbT3074KogakuGassanShikyuFushikyuKetteiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanShikyuFushikyuKettei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanShikyuFushikyuKettei setStateKogakuGassanShikyuFushikyuKettei(EntityDataState parentState) {
            KogakuGassanShikyuFushikyuKetteiEntity.setState(parentState);
            return new KogakuGassanShikyuFushikyuKettei(KogakuGassanShikyuFushikyuKetteiEntity);
        }
    }
}
