/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3110JigyoKogakuShikyuShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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

/**
 * {@link JigyoKogakuShikyuShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JigyoKogakuShikyuShinseiTest extends DbcTestBase {

    private static DbT3110JigyoKogakuShikyuShinseiEntity JigyoKogakuShikyuShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JigyoKogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuShinseiEntity = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.createDbT3110JigyoKogakuShikyuShinseiEntity();
            JigyoKogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoKogakuShikyuShinsei(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoKogakuShikyuShinsei(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3110JigyoKogakuShikyuShinseiEntityにセットされている() {
            sut = new JigyoKogakuShikyuShinsei(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJigyoKogakuShikyuShinseiIdentifierにセットされている() {
            sut = new JigyoKogakuShikyuShinsei(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JigyoKogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuShinseiEntity = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.createDbT3110JigyoKogakuShikyuShinseiEntity();
            JigyoKogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JigyoKogakuShikyuShinsei(null);
        }

        @Test
        public void 指定したDbT3110JigyoKogakuShikyuShinseiEntityのキー情報を識別子が持つ() {

            sut = new JigyoKogakuShikyuShinsei(JigyoKogakuShikyuShinseiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JigyoKogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuShinseiEntity = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.createDbT3110JigyoKogakuShikyuShinseiEntity();
            JigyoKogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuShikyuShinsei(JigyoKogakuShikyuShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JigyoKogakuShikyuShinseiEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(JigyoKogakuShikyuShinseiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(JigyoKogakuShikyuShinseiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JigyoKogakuShikyuShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(JigyoKogakuShikyuShinseiEntity.getUketsukeYMD()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(JigyoKogakuShikyuShinseiEntity.getShinseiYMD()));
        }

        @Test
        public void get申請理由は_entityが持つ申請理由を返す() {
            assertThat(sut.get申請理由(), is(JigyoKogakuShikyuShinseiEntity.getShinseiRiyu()));
        }

        @Test
        public void get申請者区分は_entityが持つ申請者区分を返す() {
            assertThat(sut.get申請者区分(), is(JigyoKogakuShikyuShinseiEntity.getShinseishaKubun()));
        }

        @Test
        public void get申請者氏名は_entityが持つ申請者氏名を返す() {
            assertThat(sut.get申請者氏名(), is(JigyoKogakuShikyuShinseiEntity.getShinseishaShimei()));
        }

        @Test
        public void get申請者氏名カナは_entityが持つ申請者氏名カナを返す() {
            assertThat(sut.get申請者氏名カナ(), is(JigyoKogakuShikyuShinseiEntity.getShinseishaShimeiKana()));
        }

        @Test
        public void get申請者住所は_entityが持つ申請者住所を返す() {
            assertThat(sut.get申請者住所(), is(JigyoKogakuShikyuShinseiEntity.getShinseishaJusho()));
        }

        @Test
        public void get申請者電話番号は_entityが持つ申請者電話番号を返す() {
            assertThat(sut.get申請者電話番号(), is(JigyoKogakuShikyuShinseiEntity.getShinseishaTelNo()));
        }

        @Test
        public void get申請事業者番号は_entityが持つ申請事業者番号を返す() {
            assertThat(sut.get申請事業者番号(), is(JigyoKogakuShikyuShinseiEntity.getShinseiJigyoshaNo()));
        }

        @Test
        public void get支払方法区分コードは_entityが持つ支払方法区分コードを返す() {
            assertThat(sut.get支払方法区分コード(), is(JigyoKogakuShikyuShinseiEntity.getShiharaiHohoKubunCode()));
        }

        @Test
        public void get支払場所は_entityが持つ支払場所を返す() {
            assertThat(sut.get支払場所(), is(JigyoKogakuShikyuShinseiEntity.getShiharaiBasho()));
        }

        @Test
        public void get支払期間開始年月日は_entityが持つ支払期間開始年月日を返す() {
            assertThat(sut.get支払期間開始年月日(), is(JigyoKogakuShikyuShinseiEntity.getShiharaiKaishiYMD()));
        }

        @Test
        public void get支払期間終了年月日は_entityが持つ支払期間終了年月日を返す() {
            assertThat(sut.get支払期間終了年月日(), is(JigyoKogakuShikyuShinseiEntity.getShiharaiShuryoYMD()));
        }

        @Test
        public void get閉庁内容は_entityが持つ閉庁内容を返す() {
            assertThat(sut.get閉庁内容(), is(JigyoKogakuShikyuShinseiEntity.getHeichoNaiyo()));
        }

        @Test
        public void get支払窓口開始時間は_entityが持つ支払窓口開始時間を返す() {
            assertThat(sut.get支払窓口開始時間(), is(JigyoKogakuShikyuShinseiEntity.getShiharaiKaishiTime()));
        }

        @Test
        public void get支払窓口終了時間は_entityが持つ支払窓口終了時間を返す() {
            assertThat(sut.get支払窓口終了時間(), is(JigyoKogakuShikyuShinseiEntity.getShiharaiShuryoTime()));
        }

        @Test
        public void get口座IDは_entityが持つ口座IDを返す() {
            assertThat(sut.get口座ID(), is(JigyoKogakuShikyuShinseiEntity.getKozaID()));
        }

        @Test
        public void get受領委任契約番号は_entityが持つ受領委任契約番号を返す() {
            assertThat(sut.get受領委任契約番号(), is(JigyoKogakuShikyuShinseiEntity.getJuryoininKeiyakuNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JigyoKogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuShinseiEntity = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.createDbT3110JigyoKogakuShikyuShinseiEntity();
            JigyoKogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuShikyuShinsei(JigyoKogakuShikyuShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JigyoKogakuShikyuShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JigyoKogakuShikyuShinsei sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuShinseiEntity = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.createDbT3110JigyoKogakuShikyuShinseiEntity();
            JigyoKogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuShikyuShinsei(JigyoKogakuShikyuShinseiEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JigyoKogakuShikyuShinsei sut;
        private static JigyoKogakuShikyuShinsei result;

        @Before
        public void setUp() {
            JigyoKogakuShikyuShinseiEntity = DbT3110JigyoKogakuShikyuShinseiEntityGenerator.createDbT3110JigyoKogakuShikyuShinseiEntity();
            JigyoKogakuShikyuShinseiEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuShinseiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void JigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがDeletedに指定されたJigyoKogakuShikyuShinseiが返る() {
            sut = TestSupport.setStateJigyoKogakuShikyuShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがDeletedに指定されたJigyoKogakuShikyuShinseiが返る() {
            sut = TestSupport.setStateJigyoKogakuShikyuShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがDeletedに指定されたJigyoKogakuShikyuShinseiが返る() {
            sut = TestSupport.setStateJigyoKogakuShikyuShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JigyoKogakuShikyuShinseiが保持するDbT3110JigyoKogakuShikyuShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJigyoKogakuShikyuShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JigyoKogakuShikyuShinsei setStateJigyoKogakuShikyuShinsei(EntityDataState parentState) {
            JigyoKogakuShikyuShinseiEntity.setState(parentState);
            return new JigyoKogakuShikyuShinsei(JigyoKogakuShikyuShinseiEntity);
        }
    }
}
