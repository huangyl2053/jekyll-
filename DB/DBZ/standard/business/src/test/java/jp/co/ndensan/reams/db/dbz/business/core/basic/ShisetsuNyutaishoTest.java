/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link ShisetsuNyutaisho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoTest extends DbzTestBase {

    private static DbT1004ShisetsuNyutaishoEntity ShisetsuNyutaishoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShisetsuNyutaisho sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(null, 履歴番号);
        }

//        @Test(expected = NullPointerException.class)
//        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new ShisetsuNyutaisho(識別コード, null);
//        }
        @Test
        public void 指定したキーが保持するDbT1004ShisetsuNyutaishoEntityにセットされている() {
            sut = new ShisetsuNyutaisho(識別コード, 履歴番号);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するShisetsuNyutaishoIdentifierにセットされている() {
            sut = new ShisetsuNyutaisho(識別コード, 履歴番号);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShisetsuNyutaisho sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShisetsuNyutaisho(null);
        }

        @Test
        public void 指定したDbT1004ShisetsuNyutaishoEntityのキー情報を識別子が持つ() {

            sut = new ShisetsuNyutaisho(ShisetsuNyutaishoEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShisetsuNyutaisho sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);

            sut = new ShisetsuNyutaisho(ShisetsuNyutaishoEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(ShisetsuNyutaishoEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShisetsuNyutaishoEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShisetsuNyutaishoEntity.getShichosonCode()));
        }

        @Test
        public void get台帳種別は_entityが持つ台帳種別を返す() {
            assertThat(sut.get台帳種別(), is(ShisetsuNyutaishoEntity.getDaichoShubetsu()));
        }

        @Test
        public void get入所施設種類は_entityが持つ入所施設種類を返す() {
            assertThat(sut.get入所施設種類(), is(ShisetsuNyutaishoEntity.getNyushoShisetsuShurui()));
        }

        @Test
        public void get入所施設コードは_entityが持つ入所施設コードを返す() {
            assertThat(sut.get入所施設コード(), is(ShisetsuNyutaishoEntity.getNyushoShisetsuCode()));
        }

        @Test
        public void get入所処理年月日は_entityが持つ入所処理年月日を返す() {
            assertThat(sut.get入所処理年月日(), is(ShisetsuNyutaishoEntity.getNyushoShoriYMD()));
        }

        @Test
        public void get入所年月日は_entityが持つ入所年月日を返す() {
            assertThat(sut.get入所年月日(), is(ShisetsuNyutaishoEntity.getNyushoYMD()));
        }

        @Test
        public void get退所処理年月日は_entityが持つ退所処理年月日を返す() {
            assertThat(sut.get退所処理年月日(), is(ShisetsuNyutaishoEntity.getTaishoShoriYMD()));
        }

        @Test
        public void get退所年月日は_entityが持つ退所年月日を返す() {
            assertThat(sut.get退所年月日(), is(ShisetsuNyutaishoEntity.getTaishoYMD()));
        }

        @Test
        public void get部屋記号番号は_entityが持つ部屋記号番号を返す() {
            assertThat(sut.get部屋記号番号(), is(ShisetsuNyutaishoEntity.getRoomKigoNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShisetsuNyutaisho sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);

            sut = new ShisetsuNyutaisho(ShisetsuNyutaishoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShisetsuNyutaishoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShisetsuNyutaisho sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);

            sut = new ShisetsuNyutaisho(ShisetsuNyutaishoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShisetsuNyutaisho sut;
        private static ShisetsuNyutaisho result;

        @Before
        public void setUp() {
            ShisetsuNyutaishoEntity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoEntity.setShikibetsuCode(識別コード);
            ShisetsuNyutaishoEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void ShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたShisetsuNyutaishoが返る() {
            sut = TestSupport.setStateShisetsuNyutaisho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたShisetsuNyutaishoが返る() {
            sut = TestSupport.setStateShisetsuNyutaisho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたShisetsuNyutaishoが返る() {
            sut = TestSupport.setStateShisetsuNyutaisho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShisetsuNyutaishoが保持するDbT1004ShisetsuNyutaishoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShisetsuNyutaisho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShisetsuNyutaisho setStateShisetsuNyutaisho(EntityDataState parentState) {
            ShisetsuNyutaishoEntity.setState(parentState);
            return new ShisetsuNyutaisho(ShisetsuNyutaishoEntity);
        }
    }
}
