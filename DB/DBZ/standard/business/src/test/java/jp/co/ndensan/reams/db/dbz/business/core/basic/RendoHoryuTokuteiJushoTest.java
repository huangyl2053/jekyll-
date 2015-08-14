/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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

/**
 * {@link RendoHoryuTokuteiJusho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoHoryuTokuteiJushoTest extends DbzTestBase {

    private static DbT7023RendoHoryuTokuteiJushoEntity RendoHoryuTokuteiJushoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 管理番号;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        管理番号 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号;
        市町村コード = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static RendoHoryuTokuteiJusho sut;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setKanriNo(管理番号);
            RendoHoryuTokuteiJushoEntity.setShichosonCode(市町村コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoHoryuTokuteiJusho(null, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoHoryuTokuteiJusho(管理番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT7023RendoHoryuTokuteiJushoEntityにセットされている() {
            sut = new RendoHoryuTokuteiJusho(管理番号, 市町村コード);
            assertThat(sut.get管理番号(), is(管理番号));
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 指定したキーが保持するRendoHoryuTokuteiJushoIdentifierにセットされている() {
            sut = new RendoHoryuTokuteiJusho(管理番号, 市町村コード);
//            assertThat(sut.identifier().getXXX(), is(管理番号));
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static RendoHoryuTokuteiJusho sut;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setKanriNo(管理番号);
            RendoHoryuTokuteiJushoEntity.setShichosonCode(市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RendoHoryuTokuteiJusho(null);
        }

        @Test
        public void 指定したDbT7023RendoHoryuTokuteiJushoEntityのキー情報を識別子が持つ() {

            sut = new RendoHoryuTokuteiJusho(RendoHoryuTokuteiJushoEntity);

//            assertThat(sut.identifier().getXXX(), is(管理番号));
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static RendoHoryuTokuteiJusho sut;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setKanriNo(管理番号);
            RendoHoryuTokuteiJushoEntity.setShichosonCode(市町村コード);

            sut = new RendoHoryuTokuteiJusho(RendoHoryuTokuteiJushoEntity);
        }

        @Test
        public void get管理番号は_entityが持つ管理番号を返す() {
            assertThat(sut.get管理番号(), is(RendoHoryuTokuteiJushoEntity.getKanriNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(RendoHoryuTokuteiJushoEntity.getShichosonCode()));
        }

        @Test
        public void get住所コードは_entityが持つ住所コードを返す() {
            assertThat(sut.get住所コード(), is(RendoHoryuTokuteiJushoEntity.getJushoCode()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(RendoHoryuTokuteiJushoEntity.getJusho()));
        }

        @Test
        public void get番地コード１は_entityが持つ番地コード１を返す() {
            assertThat(sut.get番地コード１(), is(RendoHoryuTokuteiJushoEntity.getBanchiCode1()));
        }

        @Test
        public void get番地コード２は_entityが持つ番地コード２を返す() {
            assertThat(sut.get番地コード２(), is(RendoHoryuTokuteiJushoEntity.getBanchiCode2()));
        }

        @Test
        public void get番地コード３は_entityが持つ番地コード３を返す() {
            assertThat(sut.get番地コード３(), is(RendoHoryuTokuteiJushoEntity.getBanchiCode3()));
        }

        @Test
        public void get番地は_entityが持つ番地を返す() {
            assertThat(sut.get番地(), is(RendoHoryuTokuteiJushoEntity.getBanchi()));
        }

        @Test
        public void get施設種類は_entityが持つ施設種類を返す() {
            assertThat(sut.get施設種類(), is(RendoHoryuTokuteiJushoEntity.getShisetsuShurui()));
        }

        @Test
        public void get施設コードは_entityが持つ施設コードを返す() {
            assertThat(sut.get施設コード(), is(RendoHoryuTokuteiJushoEntity.getShisetsuCode()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static RendoHoryuTokuteiJusho sut;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setKanriNo(管理番号);
            RendoHoryuTokuteiJushoEntity.setShichosonCode(市町村コード);

            sut = new RendoHoryuTokuteiJusho(RendoHoryuTokuteiJushoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RendoHoryuTokuteiJushoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static RendoHoryuTokuteiJusho sut;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setKanriNo(管理番号);
            RendoHoryuTokuteiJushoEntity.setShichosonCode(市町村コード);

            sut = new RendoHoryuTokuteiJusho(RendoHoryuTokuteiJushoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static RendoHoryuTokuteiJusho sut;
        private static RendoHoryuTokuteiJusho result;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setKanriNo(管理番号);
            RendoHoryuTokuteiJushoEntity.setShichosonCode(市町村コード);

        }

        @Test
        public void RendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがDeletedに指定されたRendoHoryuTokuteiJushoが返る() {
            sut = TestSupport.setStateRendoHoryuTokuteiJusho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがDeletedに指定されたRendoHoryuTokuteiJushoが返る() {
            sut = TestSupport.setStateRendoHoryuTokuteiJusho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがDeletedに指定されたRendoHoryuTokuteiJushoが返る() {
            sut = TestSupport.setStateRendoHoryuTokuteiJusho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RendoHoryuTokuteiJushoが保持するDbT7023RendoHoryuTokuteiJushoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRendoHoryuTokuteiJusho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RendoHoryuTokuteiJusho setStateRendoHoryuTokuteiJusho(EntityDataState parentState) {
            RendoHoryuTokuteiJushoEntity.setState(parentState);
            return new RendoHoryuTokuteiJusho(RendoHoryuTokuteiJushoEntity);
        }
    }
}
