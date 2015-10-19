/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link ShisetsuNyutaishoAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoAliveTest extends DbxTestBase {

    private static DbV1004ShisetsuNyutaishoEntity ShisetsuNyutaishoAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static Decimal 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1004ShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static ShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoAliveEntity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            ShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaishoAlive(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaishoAlive(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbV1004ShisetsuNyutaishoEntityにセットされている() {
            sut = new ShisetsuNyutaishoAlive(主キー名1, 主キー名2);
            assertThat(sut.get識別コード(), is(主キー名1));
            assertThat(sut.get履歴番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShisetsuNyutaishoAliveIdentifierにセットされている() {
            sut = new ShisetsuNyutaishoAlive(主キー名1, 主キー名2);
            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static ShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoAliveEntity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            ShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShisetsuNyutaishoAlive(null);
        }

        @Test
        public void 指定したDbV1004ShisetsuNyutaishoEntityのキー情報を識別子が持つ() {

            sut = new ShisetsuNyutaishoAlive(ShisetsuNyutaishoAliveEntity);

            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static ShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoAliveEntity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            ShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            sut = new ShisetsuNyutaishoAlive(ShisetsuNyutaishoAliveEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(ShisetsuNyutaishoAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShisetsuNyutaishoAliveEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShisetsuNyutaishoAliveEntity.getShichosonCode()));
        }

        @Test
        public void get台帳種別は_entityが持つ台帳種別を返す() {
            assertThat(sut.get台帳種別(), is(ShisetsuNyutaishoAliveEntity.getDaichoShubetsu()));
        }

        @Test
        public void get入所施設種類は_entityが持つ入所施設種類を返す() {
            assertThat(sut.get入所施設種類(), is(ShisetsuNyutaishoAliveEntity.getNyushoShisetsuShurui()));
        }

        @Test
        public void get入所施設コードは_entityが持つ入所施設コードを返す() {
            assertThat(sut.get入所施設コード(), is(new JigyoshaNo(ShisetsuNyutaishoAliveEntity.getNyushoShisetsuCode().getColumnValue())));
        }

        @Test
        public void get入所処理年月日は_entityが持つ入所処理年月日を返す() {
            assertThat(sut.get入所処理年月日(), is(ShisetsuNyutaishoAliveEntity.getNyushoShoriYMD()));
        }

        @Test
        public void get入所年月日は_entityが持つ入所年月日を返す() {
            assertThat(sut.get入所年月日(), is(ShisetsuNyutaishoAliveEntity.getNyushoYMD()));
        }

        @Test
        public void get退所処理年月日は_entityが持つ退所処理年月日を返す() {
            assertThat(sut.get退所処理年月日(), is(ShisetsuNyutaishoAliveEntity.getTaishoShoriYMD()));
        }

        @Test
        public void get退所年月日は_entityが持つ退所年月日を返す() {
            assertThat(sut.get退所年月日(), is(ShisetsuNyutaishoAliveEntity.getTaishoYMD()));
        }

        @Test
        public void get部屋記号番号は_entityが持つ部屋記号番号を返す() {
            assertThat(sut.get部屋記号番号(), is(ShisetsuNyutaishoAliveEntity.getRoomKigoNo()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static ShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoAliveEntity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            ShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            sut = new ShisetsuNyutaishoAlive(ShisetsuNyutaishoAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShisetsuNyutaishoAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static ShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            ShisetsuNyutaishoAliveEntity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            ShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            sut = new ShisetsuNyutaishoAlive(ShisetsuNyutaishoAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static ShisetsuNyutaishoAlive sut;
        private static ShisetsuNyutaishoAlive result;

        @Before
        public void setUp() {
            ShisetsuNyutaishoAliveEntity = DbV1004ShisetsuNyutaishoEntityGenerator.createDbV1004ShisetsuNyutaishoEntity();
            ShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            ShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);
        }

        @Test
        public void ShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたShisetsuNyutaishoAliveが返る() {
            sut = TestSupport.setStateShisetsuNyutaishoAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたShisetsuNyutaishoAliveが返る() {
            sut = TestSupport.setStateShisetsuNyutaishoAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたShisetsuNyutaishoAliveが返る() {
            sut = TestSupport.setStateShisetsuNyutaishoAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShisetsuNyutaishoAliveが保持するDbV1004ShisetsuNyutaishoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShisetsuNyutaishoAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShisetsuNyutaishoAlive setStateShisetsuNyutaishoAlive(EntityDataState parentState) {
            ShisetsuNyutaishoAliveEntity.setState(parentState);
            return new ShisetsuNyutaishoAlive(ShisetsuNyutaishoAliveEntity);
        }
    }
}
