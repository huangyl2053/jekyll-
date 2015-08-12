/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7034KoikiGaijiHenkanErrorLogEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {@link KoikiGaijiHenkanErrorLog}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiGaijiHenkanErrorLogTest extends DbzTestBase {

    private static DbT7034KoikiGaijiHenkanErrorLogEntity KoikiGaijiHenkanErrorLogEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLog sut;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiGaijiHenkanErrorLog(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiGaijiHenkanErrorLog(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7034KoikiGaijiHenkanErrorLogEntityにセットされている() {
            sut = new KoikiGaijiHenkanErrorLog(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKoikiGaijiHenkanErrorLogIdentifierにセットされている() {
            sut = new KoikiGaijiHenkanErrorLog(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLog sut;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoikiGaijiHenkanErrorLog(null);
        }

        @Test
        public void 指定したDbT7034KoikiGaijiHenkanErrorLogEntityのキー情報を識別子が持つ() {

            sut = new KoikiGaijiHenkanErrorLog(KoikiGaijiHenkanErrorLogEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLog sut;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);

            sut = new KoikiGaijiHenkanErrorLog(KoikiGaijiHenkanErrorLogEntity);
        }

        @Test
        public void get処理番号は_entityが持つ処理番号を返す() {
            assertThat(sut.get処理番号(), is(KoikiGaijiHenkanErrorLogEntity.getShoriNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(KoikiGaijiHenkanErrorLogEntity.getRenNo()));
        }

        @Test
        public void get市町村番号は_entityが持つ市町村番号を返す() {
            assertThat(sut.get市町村番号(), is(KoikiGaijiHenkanErrorLogEntity.getShichosonCode()));
        }

        @Test
        public void get種別は_entityが持つ種別を返す() {
            assertThat(sut.get種別(), is(KoikiGaijiHenkanErrorLogEntity.getShubetsu()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KoikiGaijiHenkanErrorLogEntity.getRirekiNo()));
        }

        @Test
        public void get送信元市町村コードは_entityが持つ送信元市町村コードを返す() {
            assertThat(sut.get送信元市町村コード(), is(KoikiGaijiHenkanErrorLogEntity.getMotoShichosonCode()));
        }

        @Test
        public void get送信元市町村名称は_entityが持つ送信元市町村名称を返す() {
            assertThat(sut.get送信元市町村名称(), is(KoikiGaijiHenkanErrorLogEntity.getMotoShichosonMeisho()));
        }

        @Test
        public void get送信先市町村コードは_entityが持つ送信先市町村コードを返す() {
            assertThat(sut.get送信先市町村コード(), is(KoikiGaijiHenkanErrorLogEntity.getSakiShichosonCode()));
        }

        @Test
        public void get送信先市町村名称は_entityが持つ送信先市町村名称を返す() {
            assertThat(sut.get送信先市町村名称(), is(KoikiGaijiHenkanErrorLogEntity.getSakiShichosonMeisho()));
        }

        @Test
        public void get住基識別コードは_entityが持つ住基識別コードを返す() {
            assertThat(sut.get住基識別コード(), is(KoikiGaijiHenkanErrorLogEntity.getJukiShikibetsuCode()));
        }

        @Test
        public void get確認区分は_entityが持つ確認区分を返す() {
            assertThat(sut.get確認区分(), is(KoikiGaijiHenkanErrorLogEntity.getKakuninKubun()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(KoikiGaijiHenkanErrorLogEntity.getShikibetsuCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KoikiGaijiHenkanErrorLogEntity.getHihokenshaNo()));
        }

        @Test
        public void getレコードＮｏは_entityが持つレコードＮｏを返す() {
            assertThat(sut.getレコードＮｏ(), is(KoikiGaijiHenkanErrorLogEntity.getRecoadNo()));
        }

        @Test
        public void get変換エラーフィールド名称は_entityが持つ変換エラーフィールド名称を返す() {
            assertThat(sut.get変換エラーフィールド名称(), is(KoikiGaijiHenkanErrorLogEntity.getErrorKomokuMeisho()));
        }

        @Test
        public void get変換エラーフィールドＮｏは_entityが持つ変換エラーフィールドＮｏを返す() {
            assertThat(sut.get変換エラーフィールドＮｏ(), is(KoikiGaijiHenkanErrorLogEntity.getErrorKomokuNo()));
        }

        @Test
        public void get変換エラーコードは_entityが持つ変換エラーコードを返す() {
            assertThat(sut.get変換エラーコード(), is(KoikiGaijiHenkanErrorLogEntity.getErrorCode()));
        }

        @Test
        public void getエラー表示連番は_entityが持つエラー表示連番を返す() {
            assertThat(sut.getエラー表示連番(), is(KoikiGaijiHenkanErrorLogEntity.getErrorHyojiRenban()));
        }

        @Test
        public void getエラー表示フィールド名称は_entityが持つエラー表示フィールド名称を返す() {
            assertThat(sut.getエラー表示フィールド名称(), is(KoikiGaijiHenkanErrorLogEntity.getErrorHyojiKomokuMeisho()));
        }

        @Test
        public void getエラー表示フィールドは_entityが持つエラー表示フィールドを返す() {
            assertThat(sut.getエラー表示フィールド(), is(KoikiGaijiHenkanErrorLogEntity.getErrorHyojiKomoku()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLog sut;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);

            sut = new KoikiGaijiHenkanErrorLog(KoikiGaijiHenkanErrorLogEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoikiGaijiHenkanErrorLogEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLog sut;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);

            sut = new KoikiGaijiHenkanErrorLog(KoikiGaijiHenkanErrorLogEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KoikiGaijiHenkanErrorLog sut;
        private static KoikiGaijiHenkanErrorLog result;

        @Before
        public void setUp() {
            KoikiGaijiHenkanErrorLogEntity = DbT7034KoikiGaijiHenkanErrorLogEntityGenerator.createDbT7034KoikiGaijiHenkanErrorLogEntity();
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名1);
            KoikiGaijiHenkanErrorLogEntity.setXXX(主キー名2);

        }

        @Test
        public void KoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがDeletedに指定されたKoikiGaijiHenkanErrorLogが返る() {
            sut = TestSupport.setStateKoikiGaijiHenkanErrorLog(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがDeletedに指定されたKoikiGaijiHenkanErrorLogが返る() {
            sut = TestSupport.setStateKoikiGaijiHenkanErrorLog(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがDeletedに指定されたKoikiGaijiHenkanErrorLogが返る() {
            sut = TestSupport.setStateKoikiGaijiHenkanErrorLog(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoikiGaijiHenkanErrorLogが保持するDbT7034KoikiGaijiHenkanErrorLogEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKoikiGaijiHenkanErrorLog(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KoikiGaijiHenkanErrorLog setStateKoikiGaijiHenkanErrorLog(EntityDataState parentState) {
            KoikiGaijiHenkanErrorLogEntity.setState(parentState);
            return new KoikiGaijiHenkanErrorLog(KoikiGaijiHenkanErrorLogEntity);
        }
    }
}
