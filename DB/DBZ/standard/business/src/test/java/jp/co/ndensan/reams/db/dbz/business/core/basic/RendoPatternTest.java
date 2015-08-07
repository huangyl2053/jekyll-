/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
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
 * {@link RendoPattern}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoPatternTest extends DbzTestBase {

    private static DbT7035RendoPatternEntity RendoPatternEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7035RendoPatternEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7035RendoPatternEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static RendoPattern sut;

        @Before
        public void setUp() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPatternEntity.setXXX(主キー名1);
            RendoPatternEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7035RendoPatternEntityにセットされている() {
            sut = new RendoPattern(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するRendoPatternIdentifierにセットされている() {
            sut = new RendoPattern(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static RendoPattern sut;

        @Before
        public void setUp() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPatternEntity.setXXX(主キー名1);
            RendoPatternEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RendoPattern(null);
        }

        @Test
        public void 指定したDbT7035RendoPatternEntityのキー情報を識別子が持つ() {

            sut = new RendoPattern(RendoPatternEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static RendoPattern sut;

        @Before
        public void setUp() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPatternEntity.setXXX(主キー名1);
            RendoPatternEntity.setXXX(主キー名2);

            sut = new RendoPattern(RendoPatternEntity);
        }

        @Test
        public void get送信元市町村コードは_entityが持つ送信元市町村コードを返す() {
            assertThat(sut.get送信元市町村コード(), is(RendoPatternEntity.getMotoShichosonCode()));
        }

        @Test
        public void get送信先市町村コードは_entityが持つ送信先市町村コードを返す() {
            assertThat(sut.get送信先市町村コード(), is(RendoPatternEntity.getSakiShichosonCode()));
        }

        @Test
        public void get種別は_entityが持つ種別を返す() {
            assertThat(sut.get種別(), is(RendoPatternEntity.getShubetsu()));
        }

        @Test
        public void get有効開始年月日は_entityが持つ有効開始年月日を返す() {
            assertThat(sut.get有効開始年月日(), is(RendoPatternEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了年月日は_entityが持つ有効終了年月日を返す() {
            assertThat(sut.get有効終了年月日(), is(RendoPatternEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get連動形態コードは_entityが持つ連動形態コードを返す() {
            assertThat(sut.get連動形態コード(), is(RendoPatternEntity.getRendoKeitaiCode()));
        }

        @Test
        public void get送信元フォーマットバージョンは_entityが持つ送信元フォーマットバージョンを返す() {
            assertThat(sut.get送信元フォーマットバージョン(), is(RendoPatternEntity.getMotoFormatVersion()));
        }

        @Test
        public void get送信元エンコーディングは_entityが持つ送信元エンコーディングを返す() {
            assertThat(sut.get送信元エンコーディング(), is(RendoPatternEntity.getMotoEncodeKeitai()));
        }

        @Test
        public void get送信先フォーマットバージョンは_entityが持つ送信先フォーマットバージョンを返す() {
            assertThat(sut.get送信先フォーマットバージョン(), is(RendoPatternEntity.getSakiFormatVersion()));
        }

        @Test
        public void get送信先エンコーディングは_entityが持つ送信先エンコーディングを返す() {
            assertThat(sut.get送信先エンコーディング(), is(RendoPatternEntity.getSakiEncodeKeitai()));
        }

        @Test
        public void getコード変換区分は_entityが持つコード変換区分を返す() {
            assertThat(sut.getコード変換区分(), is(RendoPatternEntity.getCodeHenkanKubun()));
        }

        @Test
        public void get外字変換区分は_entityが持つ外字変換区分を返す() {
            assertThat(sut.get外字変換区分(), is(RendoPatternEntity.getGaijiHenkanKubun()));
        }

        @Test
        public void get全件連動区分は_entityが持つ全件連動区分を返す() {
            assertThat(sut.get全件連動区分(), is(RendoPatternEntity.getZenkenRendoKubun()));
        }

        @Test
        public void get連携区分は_entityが持つ連携区分を返す() {
            assertThat(sut.get連携区分(), is(RendoPatternEntity.getRendoKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static RendoPattern sut;

        @Before
        public void setUp() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPatternEntity.setXXX(主キー名1);
            RendoPatternEntity.setXXX(主キー名2);

            sut = new RendoPattern(RendoPatternEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RendoPatternEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static RendoPattern sut;

        @Before
        public void setUp() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPatternEntity.setXXX(主キー名1);
            RendoPatternEntity.setXXX(主キー名2);

            sut = new RendoPattern(RendoPatternEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static RendoPattern sut;
        private static RendoPattern result;

        @Before
        public void setUp() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPatternEntity.setXXX(主キー名1);
            RendoPatternEntity.setXXX(主キー名2);

        }

        @Test
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedに指定されたRendoPatternが返る() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedに指定されたRendoPatternが返る() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedに指定されたRendoPatternが返る() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RendoPattern setStateRendoPattern(EntityDataState parentState) {
            RendoPatternEntity.setState(parentState);
            return new RendoPattern(RendoPatternEntity);
        }
    }
}
