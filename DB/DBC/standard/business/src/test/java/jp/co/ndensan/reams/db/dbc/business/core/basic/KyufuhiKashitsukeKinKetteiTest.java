/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KyufuhiKashitsukeKinKettei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinKetteiTest extends DbcTestBase {

    private static DbT3087KyufuhiKashitsukeKinKetteiEntity KyufuhiKashitsukeKinKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_借入申請年月日;
        主キー名3 = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKettei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinKettei(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinKettei(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityにセットされている() {
            sut = new KyufuhiKashitsukeKinKettei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get借入申請年月日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukeKinKetteiIdentifierにセットされている() {
            sut = new KyufuhiKashitsukeKinKettei(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get借入申請年月日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKettei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukeKinKettei(null);
        }

        @Test
        public void 指定したDbT3087KyufuhiKashitsukeKinKetteiEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukeKinKettei(KyufuhiKashitsukeKinKetteiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get借入申請年月日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKettei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);

            sut = new KyufuhiKashitsukeKinKettei(KyufuhiKashitsukeKinKetteiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukeKinKetteiEntity.getHihokenshaNo()));
        }

        @Test
        public void get借入申請年月日は_entityが持つ借入申請年月日を返す() {
            assertThat(sut.get借入申請年月日(), is(KyufuhiKashitsukeKinKetteiEntity.getKariireShinseiYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukeKinKetteiEntity.getRirekiNo()));
        }

        @Test
        public void get貸付審査決定年月日は_entityが持つ貸付審査決定年月日を返す() {
            assertThat(sut.get貸付審査決定年月日(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeShinsaKetteiYMD()));
        }

        @Test
        public void get貸付承認_不承認区分は_entityが持つ貸付承認_不承認区分を返す() {
            assertThat(sut.get貸付承認_不承認区分(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeShonin_FuShoninKubun()));
        }

        @Test
        public void get貸付管理番号は_entityが持つ貸付管理番号を返す() {
            assertThat(sut.get貸付管理番号(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeKanriNo()));
        }

        @Test
        public void get貸付金額は_entityが持つ貸付金額を返す() {
            assertThat(sut.get貸付金額(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeKingaku()));
        }

        @Test
        public void get償還方法は_entityが持つ償還方法を返す() {
            assertThat(sut.get償還方法(), is(KyufuhiKashitsukeKinKetteiEntity.getShokanHoho()));
        }

        @Test
        public void get償還期限は_entityが持つ償還期限を返す() {
            assertThat(sut.get償還期限(), is(KyufuhiKashitsukeKinKetteiEntity.getShokanKigenYMD()));
        }

        @Test
        public void get貸付年月日は_entityが持つ貸付年月日を返す() {
            assertThat(sut.get貸付年月日(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeYMD()));
        }

        @Test
        public void get貸付支払方法は_entityが持つ貸付支払方法を返す() {
            assertThat(sut.get貸付支払方法(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeShiharaiHoho()));
        }

        @Test
        public void get貸付窓口支払場所は_entityが持つ貸付窓口支払場所を返す() {
            assertThat(sut.get貸付窓口支払場所(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeMadoguchiShiharaiBasho()));
        }

        @Test
        public void get貸付窓口開始年月日は_entityが持つ貸付窓口開始年月日を返す() {
            assertThat(sut.get貸付窓口開始年月日(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeMadoguchiKaishiYMD()));
        }

        @Test
        public void get貸付窓口終了年月日は_entityが持つ貸付窓口終了年月日を返す() {
            assertThat(sut.get貸付窓口終了年月日(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeMadoguchiShuryoYMD()));
        }

        @Test
        public void get貸付窓口閉庁内容は_entityが持つ貸付窓口閉庁内容を返す() {
            assertThat(sut.get貸付窓口閉庁内容(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeMadoguchiHeichoNaiyo()));
        }

        @Test
        public void get貸付窓口開始時間は_entityが持つ貸付窓口開始時間を返す() {
            assertThat(sut.get貸付窓口開始時間(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeMadoguchiKaishiTime()));
        }

        @Test
        public void get貸付窓口終了時間は_entityが持つ貸付窓口終了時間を返す() {
            assertThat(sut.get貸付窓口終了時間(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeMadoguchiShuryoTime()));
        }

        @Test
        public void get貸付不承認理由は_entityが持つ貸付不承認理由を返す() {
            assertThat(sut.get貸付不承認理由(), is(KyufuhiKashitsukeKinKetteiEntity.getKashitsukeFuShoninRiyu()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(KyufuhiKashitsukeKinKetteiEntity.getShikibetsuCode()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKettei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);

            sut = new KyufuhiKashitsukeKinKettei(KyufuhiKashitsukeKinKetteiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukeKinKetteiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKettei sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);

            sut = new KyufuhiKashitsukeKinKettei(KyufuhiKashitsukeKinKetteiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinKettei sut;
        private static KyufuhiKashitsukeKinKettei result;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinKetteiEntity = DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator.createDbT3087KyufuhiKashitsukeKinKetteiEntity();
            KyufuhiKashitsukeKinKetteiEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinKetteiEntity.setKariireShinseiYMD(主キー名2);

        }

        @Test
        public void KyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinKetteiが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKettei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinKetteiが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKettei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinKetteiが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKettei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukeKinKetteiが保持するDbT3087KyufuhiKashitsukeKinKetteiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinKettei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukeKinKettei setStateKyufuhiKashitsukeKinKettei(EntityDataState parentState) {
            KyufuhiKashitsukeKinKetteiEntity.setState(parentState);
            return new KyufuhiKashitsukeKinKettei(KyufuhiKashitsukeKinKetteiEntity);
        }
    }
}
