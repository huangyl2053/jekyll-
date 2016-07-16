/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7908KaigoDonyuKeitaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoDonyuKeitai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoDonyuKeitaiTest extends DbxTestBase {

    private static DbT7908KaigoDonyuKeitaiEntity KaigoDonyuKeitaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static Code 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_業務分類;
        主キー名2 = DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_導入形態コード;
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoDonyuKeitai sut;

        @Before
        public void setUp() {
            KaigoDonyuKeitaiEntity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitaiEntity.setGyomuBunrui(主キー名1);
            KaigoDonyuKeitaiEntity.setDonyuKeitaiCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoDonyuKeitai(null);
        }

        @Test
        public void 指定したDbT7908KaigoDonyuKeitaiEntityのキー情報を識別子が持つ() {

            sut = new KaigoDonyuKeitai(KaigoDonyuKeitaiEntity);

            assertThat(sut.identifier().get業務分類(), is(主キー名1));
            assertThat(sut.identifier().get導入形態コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoDonyuKeitai sut;

        @Before
        public void setUp() {
            KaigoDonyuKeitaiEntity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitaiEntity.setGyomuBunrui(主キー名1);
            KaigoDonyuKeitaiEntity.setDonyuKeitaiCode(主キー名2);

            sut = new KaigoDonyuKeitai(KaigoDonyuKeitaiEntity);
        }

        @Test
        public void get業務分類は_entityが持つ業務分類を返す() {
            assertThat(sut.get業務分類(), is(GyomuBunrui.toValue(KaigoDonyuKeitaiEntity.getGyomuBunrui())));
        }

        @Test
        public void get導入形態は_entityが持つ導入形態コードを返す() {
            assertThat(sut.get導入形態コード(), is(DonyuKeitaiCode.toValue(KaigoDonyuKeitaiEntity.getDonyuKeitaiCode().value())));
        }

        @Test
        public void is支所管理有無フラグは_entityが持つ支所管理有無フラグを返す() {
            assertThat(sut.exists支所管理(), is(KaigoDonyuKeitaiEntity.getShishoKanriUmuFlag()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoDonyuKeitai sut;

        @Before
        public void setUp() {
            KaigoDonyuKeitaiEntity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitaiEntity.setGyomuBunrui(主キー名1);
            KaigoDonyuKeitaiEntity.setDonyuKeitaiCode(主キー名2);

            sut = new KaigoDonyuKeitai(KaigoDonyuKeitaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoDonyuKeitaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoDonyuKeitai sut;

        @Before
        public void setUp() {
            KaigoDonyuKeitaiEntity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitaiEntity.setGyomuBunrui(主キー名1);
            KaigoDonyuKeitaiEntity.setDonyuKeitaiCode(主キー名2);

            sut = new KaigoDonyuKeitai(KaigoDonyuKeitaiEntity);
        }

        @Test
        @Ignore()
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoDonyuKeitai sut;
        private static KaigoDonyuKeitai result;

        @Before
        public void setUp() {
            KaigoDonyuKeitaiEntity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitaiEntity.setGyomuBunrui(主キー名1);
            KaigoDonyuKeitaiEntity.setDonyuKeitaiCode(主キー名2);

        }

        @Test
        public void KaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがDeletedに指定されたKaigoDonyuKeitaiが返る() {
            sut = TestSupport.setStateKaigoDonyuKeitai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがDeletedに指定されたKaigoDonyuKeitaiが返る() {
            sut = TestSupport.setStateKaigoDonyuKeitai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがDeletedに指定されたKaigoDonyuKeitaiが返る() {
            sut = TestSupport.setStateKaigoDonyuKeitai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoDonyuKeitaiが保持するDbT7908KaigoDonyuKeitaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoDonyuKeitai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoDonyuKeitai setStateKaigoDonyuKeitai(EntityDataState parentState) {
            KaigoDonyuKeitaiEntity.setState(parentState);
            return new KaigoDonyuKeitai(KaigoDonyuKeitaiEntity);
        }
    }
}
