/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KyufuhiKashitsukekinShokanKigenHenko}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinShokanKigenHenkoTest extends DbcTestBase {

    private static DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity KyufuhiKashitsukekinShokanKigenHenkoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 貸付管理番号;
    private static FlexibleDate 償還期限延長受付年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_被保険者番号;
        貸付管理番号 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_貸付管理番号;
        償還期限延長受付年月日 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_償還期限延長受付年月日;
        履歴番号 = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.DEFAULT_履歴番号;

    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenko sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinShokanKigenHenko(null, 貸付管理番号, 償還期限延長受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 貸付管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinShokanKigenHenko(被保険者番号, null, 償還期限延長受付年月日, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityにセットされている() {
            sut = new KyufuhiKashitsukekinShokanKigenHenko(被保険者番号, 貸付管理番号, 償還期限延長受付年月日, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get貸付管理番号(), is(貸付管理番号));
            assertThat(sut.get償還期限延長受付年月日(), is(償還期限延長受付年月日));
            assertThat(sut.get履歴番号(), is(履歴番号));

        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukekinShokanKigenHenkoIdentifierにセットされている() {
            sut = new KyufuhiKashitsukekinShokanKigenHenko(被保険者番号, 貸付管理番号, 償還期限延長受付年月日, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get貸付管理番号(), is(貸付管理番号));
            assertThat(sut.identifier().get償還期限延長受付年月日(), is(償還期限延長受付年月日));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenko sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukekinShokanKigenHenko(null);
        }

        @Test
        public void 指定したDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukekinShokanKigenHenko(KyufuhiKashitsukekinShokanKigenHenkoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get貸付管理番号(), is(貸付管理番号));
            assertThat(sut.identifier().get償還期限延長受付年月日(), is(償還期限延長受付年月日));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenko sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);

            sut = new KyufuhiKashitsukekinShokanKigenHenko(KyufuhiKashitsukekinShokanKigenHenkoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getHihokenshaNo()));
        }

        @Test
        public void get貸付管理番号は_entityが持つ貸付管理番号を返す() {
            assertThat(sut.get貸付管理番号(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getKashitsukeKanriNo()));
        }

        @Test
        public void get償還期限延長受付年月日は_entityが持つ償還期限延長受付年月日を返す() {
            assertThat(sut.get償還期限延長受付年月日(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getShokanKigenEnchoUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getRirekiNo()));
        }

        @Test
        public void get償還期限延長申請年月日は_entityが持つ償還期限延長申請年月日を返す() {
            assertThat(sut.get償還期限延長申請年月日(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getShokanKigenEnchoShinseiYMD()));
        }

        @Test
        public void get借受人郵便番号は_entityが持つ借受人郵便番号を返す() {
            assertThat(sut.get借受人郵便番号(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getKariukeninYubinNo()));
        }

        @Test
        public void get借受人住所は_entityが持つ借受人住所を返す() {
            assertThat(sut.get借受人住所(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getKariukeninJusho()));
        }

        @Test
        public void get借受人氏名カナは_entityが持つ借受人氏名カナを返す() {
            assertThat(sut.get借受人氏名カナ(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getKariukeninShimeiKana()));
        }

        @Test
        public void get借受人氏名は_entityが持つ借受人氏名を返す() {
            assertThat(sut.get借受人氏名(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getKariukeninShimei()));
        }

        @Test
        public void get借受人電話番号は_entityが持つ借受人電話番号を返す() {
            assertThat(sut.get借受人電話番号(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getKariukeninTelNo()));
        }

        @Test
        public void get未償還金額は_entityが持つ未償還金額を返す() {
            assertThat(sut.get未償還金額(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getMiShokanKingaku()));
        }

        @Test
        public void get償還期限延長希望期間開始年月日は_entityが持つ償還期限延長希望期間開始年月日を返す() {
            assertThat(sut.get償還期限延長希望期間開始年月日(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getEnchoKiboKaishiYMD()));
        }

        @Test
        public void get償還期限延長希望期間終了年月日は_entityが持つ償還期限延長希望期間終了年月日を返す() {
            assertThat(sut.get償還期限延長希望期間終了年月日(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getEnchoKiboShuryoYMD()));
        }

        @Test
        public void get償還期限延長理由等は_entityが持つ償還期限延長理由等を返す() {
            assertThat(sut.get償還期限延長理由等(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getEnchoRiyu()));
        }

        @Test
        public void get償還期限変更決定年月日は_entityが持つ償還期限変更決定年月日を返す() {
            assertThat(sut.get償還期限変更決定年月日(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getHenkoKetteiYMD()));
        }

        @Test
        public void get償還期限変更承認_不承認区分は_entityが持つ償還期限変更承認_不承認区分を返す() {
            assertThat(sut.get償還期限変更承認_不承認区分(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getHenkoShonin_FuShoninKubun()));
        }

        @Test
        public void get変更後償還期限は_entityが持つ変更後償還期限を返す() {
            assertThat(sut.get変更後償還期限(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getHenkoGoShokanKigenYMD()));
        }

        @Test
        public void get償還期限変更不承認理由は_entityが持つ償還期限変更不承認理由を返す() {
            assertThat(sut.get償還期限変更不承認理由(), is(KyufuhiKashitsukekinShokanKigenHenkoEntity.getHenkoFuShoninRiyu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenko sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);

            sut = new KyufuhiKashitsukekinShokanKigenHenko(KyufuhiKashitsukekinShokanKigenHenkoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukekinShokanKigenHenkoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenko sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);

            sut = new KyufuhiKashitsukekinShokanKigenHenko(KyufuhiKashitsukekinShokanKigenHenkoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinShokanKigenHenko sut;
        private static KyufuhiKashitsukekinShokanKigenHenko result;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinShokanKigenHenkoEntity = DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityGenerator.createDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void KyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinShokanKigenHenkoが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShokanKigenHenko(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinShokanKigenHenkoが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShokanKigenHenko(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinShokanKigenHenkoが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShokanKigenHenko(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukekinShokanKigenHenkoが保持するDbT3089KyufuhiKashitsukekinShokanKigenHenkoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukekinShokanKigenHenko(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukekinShokanKigenHenko setStateKyufuhiKashitsukekinShokanKigenHenko(EntityDataState parentState) {
            KyufuhiKashitsukekinShokanKigenHenkoEntity.setState(parentState);
            return new KyufuhiKashitsukekinShokanKigenHenko(KyufuhiKashitsukekinShokanKigenHenkoEntity);
        }
    }
}
