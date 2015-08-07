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
 * {@link KyufuhiKashitsukekinShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShinseiTest extends DbcTestBase {

    private static DbT3086KyufuhiKashitsukekinShinseiEntity KyufuhiKashitsukekinShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShinsei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinShinsei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinShinsei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3086KyufuhiKashitsukekinShinseiEntityにセットされている() {
            sut = new KyufuhiKashitsukekinShinsei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukekinShinseiIdentifierにセットされている() {
            sut = new KyufuhiKashitsukekinShinsei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShinsei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukekinShinsei(null);
        }

        @Test
        public void 指定したDbT3086KyufuhiKashitsukekinShinseiEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukekinShinsei(KyufuhiKashitsukekinShinseiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShinsei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukekinShinsei(KyufuhiKashitsukekinShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukekinShinseiEntity.getHihokenshaNo()));
        }

        @Test
        public void get借入申請年月日は_entityが持つ借入申請年月日を返す() {
            assertThat(sut.get借入申請年月日(), is(KyufuhiKashitsukekinShinseiEntity.getKariireShinseiYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukekinShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get申請者郵便番号は_entityが持つ申請者郵便番号を返す() {
            assertThat(sut.get申請者郵便番号(), is(KyufuhiKashitsukekinShinseiEntity.getShinseishaYubinNo()));
        }

        @Test
        public void get申請者住所は_entityが持つ申請者住所を返す() {
            assertThat(sut.get申請者住所(), is(KyufuhiKashitsukekinShinseiEntity.getShinseishaJusho()));
        }

        @Test
        public void get申請者氏名カナは_entityが持つ申請者氏名カナを返す() {
            assertThat(sut.get申請者氏名カナ(), is(KyufuhiKashitsukekinShinseiEntity.getShinseishaShimeiKana()));
        }

        @Test
        public void get申請者氏名は_entityが持つ申請者氏名を返す() {
            assertThat(sut.get申請者氏名(), is(KyufuhiKashitsukekinShinseiEntity.getShinseishaShimei()));
        }

        @Test
        public void get申請者電話番号は_entityが持つ申請者電話番号を返す() {
            assertThat(sut.get申請者電話番号(), is(KyufuhiKashitsukekinShinseiEntity.getShinseishaTelNo()));
        }

        @Test
        public void get申請者との関係は_entityが持つ申請者との関係を返す() {
            assertThat(sut.get申請者との関係(), is(KyufuhiKashitsukekinShinseiEntity.getShinseishaKankei()));
        }

        @Test
        public void get借入利用期間開始年月日は_entityが持つ借入利用期間開始年月日を返す() {
            assertThat(sut.get借入利用期間開始年月日(), is(KyufuhiKashitsukekinShinseiEntity.getKariireRiyoKaishiYMD()));
        }

        @Test
        public void get借入利用期間終了年月日は_entityが持つ借入利用期間終了年月日を返す() {
            assertThat(sut.get借入利用期間終了年月日(), is(KyufuhiKashitsukekinShinseiEntity.getKariireRiyoShuryoYMD()));
        }

        @Test
        public void get貸付対象・高額介護サービス費等有無は_entityが持つ貸付対象・高額介護サービス費等有無を返す() {
            assertThat(sut.get貸付対象・高額介護サービス費等有無(), is(KyufuhiKashitsukekinShinseiEntity.getKashitsuke_KogakuUmu()));
        }

        @Test
        public void get貸付対象・住宅改修費等有無は_entityが持つ貸付対象・住宅改修費等有無を返す() {
            assertThat(sut.get貸付対象・住宅改修費等有無(), is(KyufuhiKashitsukekinShinseiEntity.getKashitsuke_JutakuKaishuUmu()));
        }

        @Test
        public void get貸付対象・福祉用具購入費等有無は_entityが持つ貸付対象・福祉用具購入費等有無を返す() {
            assertThat(sut.get貸付対象・福祉用具購入費等有無(), is(KyufuhiKashitsukekinShinseiEntity.getKahitsuke_YoguKonyuUmu()));
        }

        @Test
        public void get貸付対象・特例介護サービス費等有無は_entityが持つ貸付対象・特例介護サービス費等有無を返す() {
            assertThat(sut.get貸付対象・特例介護サービス費等有無(), is(KyufuhiKashitsukekinShinseiEntity.getKashitsuke_TokureiServiceUmu()));
        }

        @Test
        public void get保証人氏名カナは_entityが持つ保証人氏名カナを返す() {
            assertThat(sut.get保証人氏名カナ(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_ShimeiKana()));
        }

        @Test
        public void get保証人氏名は_entityが持つ保証人氏名を返す() {
            assertThat(sut.get保証人氏名(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_Shimei()));
        }

        @Test
        public void get保証人生年月日は_entityが持つ保証人生年月日を返す() {
            assertThat(sut.get保証人生年月日(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_UmareYMD()));
        }

        @Test
        public void get保証人性別は_entityが持つ保証人性別を返す() {
            assertThat(sut.get保証人性別(), is(KyufuhiKashitsukekinShinseiEntity.getHoshinin_SeibetsuCd()));
        }

        @Test
        public void get保証人郵便番号は_entityが持つ保証人郵便番号を返す() {
            assertThat(sut.get保証人郵便番号(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_YubinNo()));
        }

        @Test
        public void get保証人住所は_entityが持つ保証人住所を返す() {
            assertThat(sut.get保証人住所(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_Jusho()));
        }

        @Test
        public void get保証人電話番号は_entityが持つ保証人電話番号を返す() {
            assertThat(sut.get保証人電話番号(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_TelNo()));
        }

        @Test
        public void get借入申請者との関係は_entityが持つ借入申請者との関係を返す() {
            assertThat(sut.get借入申請者との関係(), is(KyufuhiKashitsukekinShinseiEntity.getKariireShinseishaKankei()));
        }

        @Test
        public void get保証人勤務先名称は_entityが持つ保証人勤務先名称を返す() {
            assertThat(sut.get保証人勤務先名称(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_KinmusakiMeisho()));
        }

        @Test
        public void get保証人勤務先郵便番号は_entityが持つ保証人勤務先郵便番号を返す() {
            assertThat(sut.get保証人勤務先郵便番号(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_KinmusakiYubinNo()));
        }

        @Test
        public void get保証人勤務先所在地は_entityが持つ保証人勤務先所在地を返す() {
            assertThat(sut.get保証人勤務先所在地(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_KinmusakiJusho()));
        }

        @Test
        public void get保証人勤務先電話番号は_entityが持つ保証人勤務先電話番号を返す() {
            assertThat(sut.get保証人勤務先電話番号(), is(KyufuhiKashitsukekinShinseiEntity.getHoshonin_KinmusakiTelNo()));
        }

        @Test
        public void get請求書・領収書の有無は_entityが持つ請求書・領収書の有無を返す() {
            assertThat(sut.get請求書・領収書の有無(), is(KyufuhiKashitsukekinShinseiEntity.getSeikyusho_RyoshushoUmu()));
        }

        @Test
        public void get提出物管理番号は_entityが持つ提出物管理番号を返す() {
            assertThat(sut.get提出物管理番号(), is(KyufuhiKashitsukekinShinseiEntity.getTeishutsubutsuKanriNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShinsei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukekinShinsei(KyufuhiKashitsukekinShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukekinShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShinsei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukekinShinsei(KyufuhiKashitsukekinShinseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShinsei sut;
        private static KyufuhiKashitsukekinShinsei result;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShinseiEntity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinShinseiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinShinseiが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinShinseiが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinShinseiが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukekinShinseiが保持するDbT3086KyufuhiKashitsukekinShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukekinShinsei setStateKyufuhiKashitsukekinShinsei(EntityDataState parentState) {
            KyufuhiKashitsukekinShinseiEntity.setState(parentState);
            return new KyufuhiKashitsukekinShinsei(KyufuhiKashitsukekinShinseiEntity);
        }
    }
}
