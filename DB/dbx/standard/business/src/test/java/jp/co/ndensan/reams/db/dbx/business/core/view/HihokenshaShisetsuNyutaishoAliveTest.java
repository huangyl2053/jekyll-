/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbV1004HihokenshaShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
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
 * {@link HihokenshaShisetsuNyutaishoAlive}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaShisetsuNyutaishoAliveTest extends DbxTestBase {

    private static DbV1004HihokenshaShisetsuNyutaishoEntity HihokenshaShisetsuNyutaishoAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static Decimal 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaShisetsuNyutaishoAlive(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HihokenshaShisetsuNyutaishoAlive(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbV1004HihokenshaShisetsuNyutaishoEntityにセットされている() {
            sut = new HihokenshaShisetsuNyutaishoAlive(主キー名1, 主キー名2);
            assertThat(sut.get識別コード(), is(主キー名1));
            assertThat(sut.get履歴番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するHihokenshaShisetsuNyutaishoAliveIdentifierにセットされている() {
            sut = new HihokenshaShisetsuNyutaishoAlive(主キー名1, 主キー名2);
            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HihokenshaShisetsuNyutaishoAlive(null);
        }

        @Test
        public void 指定したDbV1004HihokenshaShisetsuNyutaishoEntityのキー情報を識別子が持つ() {

            sut = new HihokenshaShisetsuNyutaishoAlive(HihokenshaShisetsuNyutaishoAliveEntity);

            assertThat(sut.identifier().get識別コード(), is(主キー名1));
            assertThat(sut.identifier().get履歴番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            sut = new HihokenshaShisetsuNyutaishoAlive(HihokenshaShisetsuNyutaishoAliveEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(HihokenshaShisetsuNyutaishoAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(HihokenshaShisetsuNyutaishoAliveEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(HihokenshaShisetsuNyutaishoAliveEntity.getShichosonCode()));
        }

        @Test
        public void get台帳種別は_entityが持つ台帳種別を返す() {
            assertThat(sut.get台帳種別(), is(HihokenshaShisetsuNyutaishoAliveEntity.getDaichoShubetsu()));
        }

        @Test
        public void get入所施設種類は_entityが持つ入所施設種類を返す() {
            assertThat(sut.get入所施設種類(), is(HihokenshaShisetsuNyutaishoAliveEntity.getNyushoShisetsuShurui()));
        }

        @Test
        public void get入所施設コードは_entityが持つ入所施設コードを返す() {
            assertThat(sut.get入所施設コード(), is(new JigyoshaNo(HihokenshaShisetsuNyutaishoAliveEntity.getNyushoShisetsuCode().getColumnValue())));
        }

        @Test
        public void get入所年月日は_entityが持つ入所年月日を返す() {
            assertThat(sut.get入所年月日(), is(HihokenshaShisetsuNyutaishoAliveEntity.getNyushoYMD()));
        }

        @Test
        public void get退所年月日は_entityが持つ退所年月日を返す() {
            assertThat(sut.get退所年月日(), is(HihokenshaShisetsuNyutaishoAliveEntity.getTaishoYMD()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            sut = new HihokenshaShisetsuNyutaishoAlive(HihokenshaShisetsuNyutaishoAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(HihokenshaShisetsuNyutaishoAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAlive sut;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            sut = new HihokenshaShisetsuNyutaishoAlive(HihokenshaShisetsuNyutaishoAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAlive sut;
        private static HihokenshaShisetsuNyutaishoAlive result;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);
        }

        @Test
        public void HihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりHihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたHihokenshaShisetsuNyutaishoAliveが返る() {
            sut = TestSupport.setStateHihokenshaShisetsuNyutaishoAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりHihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたHihokenshaShisetsuNyutaishoAliveが返る() {
            sut = TestSupport.setStateHihokenshaShisetsuNyutaishoAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりHihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがDeletedに指定されたHihokenshaShisetsuNyutaishoAliveが返る() {
            sut = TestSupport.setStateHihokenshaShisetsuNyutaishoAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void HihokenshaShisetsuNyutaishoAliveが保持するDbV1004HihokenshaShisetsuNyutaishoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateHihokenshaShisetsuNyutaishoAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static HihokenshaShisetsuNyutaishoAlive setStateHihokenshaShisetsuNyutaishoAlive(EntityDataState parentState) {
            HihokenshaShisetsuNyutaishoAliveEntity.setState(parentState);
            return new HihokenshaShisetsuNyutaishoAlive(HihokenshaShisetsuNyutaishoAliveEntity);
        }
    }
}
