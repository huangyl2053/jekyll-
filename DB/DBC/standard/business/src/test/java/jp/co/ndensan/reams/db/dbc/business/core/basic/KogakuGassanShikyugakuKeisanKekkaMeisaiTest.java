/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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
import org.junit.Ignore;

/**
 * {@link KogakuGassanShikyugakuKeisanKekkaMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuGassanShikyugakuKeisanKekkaMeisaiTest extends DbcTestBase {

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

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityにセットされている() {
            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanShikyugakuKeisanKekkaMeisaiIdentifierにセットされている() {
            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(null);
        }

        @Test
        public void 指定したDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getTaishoNendo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getShikyuShinseishoSeiriNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getMeisanNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get保険制度コードは_entityが持つ保険制度コードを返す() {
            assertThat(sut.get保険制度コード(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getHokenSeidoCode()));
        }

        @Test
        public void get内訳保険者番号は_entityが持つ内訳保険者番号を返す() {
            assertThat(sut.get内訳保険者番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getUchiwakeHokenshaNo()));
        }

        @Test
        public void get国保被保険者証記号は_entityが持つ国保被保険者証記号を返す() {
            assertThat(sut.get国保被保険者証記号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getKokuho_HihokenshaShoKigo()));
        }

        @Test
        public void get被保険者_証番号は_entityが持つ被保険者_証番号を返す() {
            assertThat(sut.get被保険者_証番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getHiHokenshaShoNo()));
        }

        @Test
        public void get内訳保険者名は_entityが持つ内訳保険者名を返す() {
            assertThat(sut.get内訳保険者名(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getUchiwakeHokenshaMei()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getJikoFutanSeiriNo()));
        }

        @Test
        public void get対象者氏名_漢字は_entityが持つ対象者氏名_漢字を返す() {
            assertThat(sut.get対象者氏名_漢字(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getTaishoshaShimei()));
        }

        @Test
        public void get70歳以上負担額は_entityが持つ70歳以上負担額を返す() {
            assertThat(sut.get70歳以上負担額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getOver70_Futangaku()));
        }

        @Test
        public void get70歳以上按分率は_entityが持つ70歳以上按分率を返す() {
            assertThat(sut.get70歳以上按分率(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getOver70_AmbunRitsu()));
        }

        @Test
        public void get70歳以上支給額は_entityが持つ70歳以上支給額を返す() {
            assertThat(sut.get70歳以上支給額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getOver70_Shikyugaku()));
        }

        @Test
        public void get70歳未満負担額は_entityが持つ70歳未満負担額を返す() {
            assertThat(sut.get70歳未満負担額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getUnder70_Futangaku()));
        }

        @Test
        public void get負担額は_entityが持つ負担額を返す() {
            assertThat(sut.get負担額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getFutangaku()));
        }

        @Test
        public void get按分率は_entityが持つ按分率を返す() {
            assertThat(sut.get按分率(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getAmbunRitsu()));
        }

        @Test
        public void get70歳未満支給額は_entityが持つ70歳未満支給額を返す() {
            assertThat(sut.get70歳未満支給額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getUnder70_Shikyugaku()));
        }

        @Test
        public void get支給額は_entityが持つ支給額を返す() {
            assertThat(sut.get支給額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getShikyugaku()));
        }

        @Test
        public void get備考欄記載70歳以上負担額は_entityが持つ備考欄記載70歳以上負担額を返す() {
            assertThat(sut.get備考欄記載70歳以上負担額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getOver70_Biko()));
        }

        @Test
        public void get備考欄記載70歳未満負担額は_entityが持つ備考欄記載70歳未満負担額を返す() {
            assertThat(sut.get備考欄記載70歳未満負担額(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getUnder70_Biko()));
        }

        @Test
        public void getデータ区分は_entityが持つデータ区分を返す() {
            assertThat(sut.getデータ区分(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getDataKubun()));
        }

        @Test
        public void get受取年月は_entityが持つ受取年月を返す() {
            assertThat(sut.get受取年月(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getUketoriYM()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.getSofuYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShikyugakuKeisanKekkaMeisai(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanShikyugakuKeisanKekkaMeisai sut;
        private static KogakuGassanShikyugakuKeisanKekkaMeisai result;

        @Before
        public void setUp() {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity = DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator.createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyugakuKeisanKekkaMeisaiが返る() {
            sut = TestSupport.setStateKogakuGassanShikyugakuKeisanKekkaMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyugakuKeisanKekkaMeisaiが返る() {
            sut = TestSupport.setStateKogakuGassanShikyugakuKeisanKekkaMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShikyugakuKeisanKekkaMeisaiが返る() {
            sut = TestSupport.setStateKogakuGassanShikyugakuKeisanKekkaMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanShikyugakuKeisanKekkaMeisaiが保持するDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanShikyugakuKeisanKekkaMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanShikyugakuKeisanKekkaMeisai setStateKogakuGassanShikyugakuKeisanKekkaMeisai(EntityDataState parentState) {
            KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.setState(parentState);
            return new KogakuGassanShikyugakuKeisanKekkaMeisai(KogakuGassanShikyugakuKeisanKekkaMeisaiEntity);
        }
    }
}
