/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3056KogakuShikyuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link KogakuShikyuShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuShikyuShinseiTest extends DbcTestBase {

    private static DbT3056KogakuShikyuShinseiEntity KogakuShikyuShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3056KogakuShikyuShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuShikyuShinsei(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuShikyuShinsei(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3056KogakuShikyuShinseiEntityにセットされている() {
            sut = new KogakuShikyuShinsei(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuShikyuShinseiIdentifierにセットされている() {
            sut = new KogakuShikyuShinsei(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuShikyuShinsei(null);
        }

        @Test
        public void 指定したDbT3056KogakuShikyuShinseiEntityのキー情報を識別子が持つ() {

            sut = new KogakuShikyuShinsei(KogakuShikyuShinseiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            sut = new KogakuShikyuShinsei(KogakuShikyuShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuShikyuShinseiEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KogakuShikyuShinseiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KogakuShikyuShinseiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuShikyuShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(KogakuShikyuShinseiEntity.getUketsukeYMD()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KogakuShikyuShinseiEntity.getShinseiYMD()));
        }

        @Test
        public void get申請理由は_entityが持つ申請理由を返す() {
            assertThat(sut.get申請理由(), is(KogakuShikyuShinseiEntity.getShinseiRiyu()));
        }

        @Test
        public void get申請者区分は_entityが持つ申請者区分を返す() {
            assertThat(sut.get申請者区分(), is(KogakuShikyuShinseiEntity.getShinseishaKubun()));
        }

        @Test
        public void get申請者氏名は_entityが持つ申請者氏名を返す() {
            assertThat(sut.get申請者氏名(), is(KogakuShikyuShinseiEntity.getShinseishaShimei()));
        }

        @Test
        public void get申請者氏名カナは_entityが持つ申請者氏名カナを返す() {
            assertThat(sut.get申請者氏名カナ(), is(KogakuShikyuShinseiEntity.getShinseishaShimeiKana()));
        }

        @Test
        public void get申請者住所は_entityが持つ申請者住所を返す() {
            assertThat(sut.get申請者住所(), is(KogakuShikyuShinseiEntity.getShinseishaJusho()));
        }

        @Test
        public void get申請者電話番号は_entityが持つ申請者電話番号を返す() {
            assertThat(sut.get申請者電話番号(), is(KogakuShikyuShinseiEntity.getShinseishaTelNo()));
        }

        @Test
        public void get申請事業者番号は_entityが持つ申請事業者番号を返す() {
            assertThat(sut.get申請事業者番号(), is(KogakuShikyuShinseiEntity.getShinseiJigyoshaNo()));
        }

        @Test
        public void get支払方法区分コードは_entityが持つ支払方法区分コードを返す() {
            assertThat(sut.get支払方法区分コード(), is(KogakuShikyuShinseiEntity.getShiharaiHohoKubunCode()));
        }

        @Test
        public void get支払場所は_entityが持つ支払場所を返す() {
            assertThat(sut.get支払場所(), is(KogakuShikyuShinseiEntity.getShiharaiBasho()));
        }

        @Test
        public void get支払期間開始年月日は_entityが持つ支払期間開始年月日を返す() {
            assertThat(sut.get支払期間開始年月日(), is(KogakuShikyuShinseiEntity.getShiharaiKaishiYMD()));
        }

        @Test
        public void get支払期間終了年月日は_entityが持つ支払期間終了年月日を返す() {
            assertThat(sut.get支払期間終了年月日(), is(KogakuShikyuShinseiEntity.getShiharaiShuryoYMD()));
        }

        @Test
        public void get閉庁内容は_entityが持つ閉庁内容を返す() {
            assertThat(sut.get閉庁内容(), is(KogakuShikyuShinseiEntity.getHeichoNaiyo()));
        }

        @Test
        public void get支払窓口開始時間は_entityが持つ支払窓口開始時間を返す() {
            assertThat(sut.get支払窓口開始時間(), is(KogakuShikyuShinseiEntity.getShiharaiKaishiTime()));
        }

        @Test
        public void get支払窓口終了時間は_entityが持つ支払窓口終了時間を返す() {
            assertThat(sut.get支払窓口終了時間(), is(KogakuShikyuShinseiEntity.getShiharaiShuryoTime()));
        }

        @Test
        public void get口座IDは_entityが持つ口座IDを返す() {
            assertThat(sut.get口座ID(), is(KogakuShikyuShinseiEntity.getKozaID()));
        }

        @Test
        public void get受領委任契約番号は_entityが持つ受領委任契約番号を返す() {
            assertThat(sut.get受領委任契約番号(), is(KogakuShikyuShinseiEntity.getJuryoininKeiyakuNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            sut = new KogakuShikyuShinsei(KogakuShikyuShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuShikyuShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            sut = new KogakuShikyuShinsei(KogakuShikyuShinseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuShikyuShinsei sut;
        private static KogakuShikyuShinsei result;

        @Before
        public void setUp() {
            KogakuShikyuShinseiEntity = DbT3056KogakuShikyuShinseiEntityGenerator.createDbT3056KogakuShikyuShinseiEntity();
            KogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            KogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void KogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがDeletedに指定されたKogakuShikyuShinseiが返る() {
            sut = TestSupport.setStateKogakuShikyuShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがDeletedに指定されたKogakuShikyuShinseiが返る() {
            sut = TestSupport.setStateKogakuShikyuShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがDeletedに指定されたKogakuShikyuShinseiが返る() {
            sut = TestSupport.setStateKogakuShikyuShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuShikyuShinseiが保持するDbT3056KogakuShikyuShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuShikyuShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuShikyuShinsei setStateKogakuShikyuShinsei(EntityDataState parentState) {
            KogakuShikyuShinseiEntity.setState(parentState);
            return new KogakuShikyuShinsei(KogakuShikyuShinseiEntity);
        }
    }
}
