/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link ShokanShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShinseiTest extends DbcTestBase {

    private static DbT3034ShokanShinseiEntity ShokanShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3034ShokanShinseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanShinsei sut;

        @Before
        public void setUp() {
            ShokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setXXX(主キー名1);
            ShokanShinseiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShinsei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShinsei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3034ShokanShinseiEntityにセットされている() {
            sut = new ShokanShinsei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanShinseiIdentifierにセットされている() {
            sut = new ShokanShinsei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanShinsei sut;

        @Before
        public void setUp() {
            ShokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setXXX(主キー名1);
            ShokanShinseiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanShinsei(null);
        }

        @Test
        public void 指定したDbT3034ShokanShinseiEntityのキー情報を識別子が持つ() {

            sut = new ShokanShinsei(ShokanShinseiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanShinsei sut;

        @Before
        public void setUp() {
            ShokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setXXX(主キー名1);
            ShokanShinseiEntity.setXXX(主キー名2);

            sut = new ShokanShinsei(ShokanShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanShinseiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanShinseiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanShinseiEntity.getSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(ShokanShinseiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(ShokanShinseiEntity.getUketsukeYMD()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(ShokanShinseiEntity.getShinseiYMD()));
        }

        @Test
        public void get申請理由は_entityが持つ申請理由を返す() {
            assertThat(sut.get申請理由(), is(ShokanShinseiEntity.getShinseiRiyu()));
        }

        @Test
        public void get申請者区分は_entityが持つ申請者区分を返す() {
            assertThat(sut.get申請者区分(), is(ShokanShinseiEntity.getShinseishaKubun()));
        }

        @Test
        public void get申請者氏名は_entityが持つ申請者氏名を返す() {
            assertThat(sut.get申請者氏名(), is(ShokanShinseiEntity.getShinseishaNameKanji()));
        }

        @Test
        public void get申請者氏名カナは_entityが持つ申請者氏名カナを返す() {
            assertThat(sut.get申請者氏名カナ(), is(ShokanShinseiEntity.getShinseishaNameKana()));
        }

        @Test
        public void get申請者住所は_entityが持つ申請者住所を返す() {
            assertThat(sut.get申請者住所(), is(ShokanShinseiEntity.getShinseishaAddress()));
        }

        @Test
        public void get申請者電話番号は_entityが持つ申請者電話番号を返す() {
            assertThat(sut.get申請者電話番号(), is(ShokanShinseiEntity.getShinseishaTelNo()));
        }

        @Test
        public void get申請事業者コードは_entityが持つ申請事業者コードを返す() {
            assertThat(sut.get申請事業者コード(), is(ShokanShinseiEntity.getShinseiJigyoshaCode()));
        }

        @Test
        public void get支払金額合計は_entityが持つ支払金額合計を返す() {
            assertThat(sut.get支払金額合計(), is(ShokanShinseiEntity.getShiharaiKingakuTotal()));
        }

        @Test
        public void get保険給付額は_entityが持つ保険給付額を返す() {
            assertThat(sut.get保険給付額(), is(ShokanShinseiEntity.getHokenKyufuritsu()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(ShokanShinseiEntity.getRiyoshaFutangaku()));
        }

        @Test
        public void get支給申請審査区分は_entityが持つ支給申請審査区分を返す() {
            assertThat(sut.get支給申請審査区分(), is(ShokanShinseiEntity.getShikyuShinseiShinsaKubun()));
        }

        @Test
        public void get審査方法区分は_entityが持つ審査方法区分を返す() {
            assertThat(sut.get審査方法区分(), is(ShokanShinseiEntity.getShinsaHohoKubun()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(ShokanShinseiEntity.getSofuYM()));
        }

        @Test
        public void get支払方法区分コードは_entityが持つ支払方法区分コードを返す() {
            assertThat(sut.get支払方法区分コード(), is(ShokanShinseiEntity.getShiharaiHohoKubunCode()));
        }

        @Test
        public void get支払場所は_entityが持つ支払場所を返す() {
            assertThat(sut.get支払場所(), is(ShokanShinseiEntity.getShiharaiBasho()));
        }

        @Test
        public void get支払期間開始年月日は_entityが持つ支払期間開始年月日を返す() {
            assertThat(sut.get支払期間開始年月日(), is(ShokanShinseiEntity.getShiharaiKaishiYMD()));
        }

        @Test
        public void get支払期間終了年月日は_entityが持つ支払期間終了年月日を返す() {
            assertThat(sut.get支払期間終了年月日(), is(ShokanShinseiEntity.getShiharaiShuryoYMD()));
        }

        @Test
        public void get閉庁内容は_entityが持つ閉庁内容を返す() {
            assertThat(sut.get閉庁内容(), is(ShokanShinseiEntity.getHeichoNaiyo()));
        }

        @Test
        public void get支払窓口開始時間は_entityが持つ支払窓口開始時間を返す() {
            assertThat(sut.get支払窓口開始時間(), is(ShokanShinseiEntity.getShiharaiKaishiTime()));
        }

        @Test
        public void get支払窓口終了期間は_entityが持つ支払窓口終了期間を返す() {
            assertThat(sut.get支払窓口終了期間(), is(ShokanShinseiEntity.getShiharaiShuryoTime()));
        }

        @Test
        public void get口座IDは_entityが持つ口座IDを返す() {
            assertThat(sut.get口座ID(), is(ShokanShinseiEntity.getKozaID()));
        }

        @Test
        public void get受領委任契約番号は_entityが持つ受領委任契約番号を返す() {
            assertThat(sut.get受領委任契約番号(), is(ShokanShinseiEntity.getJuryoininKeiyakuNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanShinsei sut;

        @Before
        public void setUp() {
            ShokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setXXX(主キー名1);
            ShokanShinseiEntity.setXXX(主キー名2);

            sut = new ShokanShinsei(ShokanShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanShinsei sut;

        @Before
        public void setUp() {
            ShokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setXXX(主キー名1);
            ShokanShinseiEntity.setXXX(主キー名2);

            sut = new ShokanShinsei(ShokanShinseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanShinsei sut;
        private static ShokanShinsei result;

        @Before
        public void setUp() {
            ShokanShinseiEntity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
            ShokanShinseiEntity.setXXX(主キー名1);
            ShokanShinseiEntity.setXXX(主キー名2);

        }

        @Test
        public void ShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがDeletedに指定されたShokanShinseiが返る() {
            sut = TestSupport.setStateShokanShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがDeletedに指定されたShokanShinseiが返る() {
            sut = TestSupport.setStateShokanShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがDeletedに指定されたShokanShinseiが返る() {
            sut = TestSupport.setStateShokanShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanShinseiが保持するDbT3034ShokanShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanShinsei setStateShokanShinsei(EntityDataState parentState) {
            ShokanShinseiEntity.setState(parentState);
            return new ShokanShinsei(ShokanShinseiEntity);
        }
    }
}
