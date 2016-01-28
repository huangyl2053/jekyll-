/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV7901ShikakuSearchEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShikakuSearchAlive}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShikakuSearchAliveTest extends DbzTestBase {

    private static DbV7901ShikakuSearchEntity ShikakuSearchAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShikakuSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShikakuSearchAliveEntity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            被保険者番号 = null;
            sut = new ShikakuSearchAlive(被保険者番号);
        }

        @Test
        public void 指定したキーが保持するDbV7901ShikakuSearchEntityにセットされている() {
            sut = new ShikakuSearchAlive(被保険者番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 指定したキーが保持するShikakuSearchAliveIdentifierにセットされている() {
            sut = new ShikakuSearchAlive(被保険者番号);
            // TODO
            //assertThat(sut.identifier().getXXX(), is(被保険者番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShikakuSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShikakuSearchAliveEntity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            被保険者番号 = null;
            sut = new ShikakuSearchAlive(被保険者番号);
        }

        @Test
        public void 指定したDbV7901ShikakuSearchEntityのキー情報を識別子が持つ() {

            sut = new ShikakuSearchAlive(ShikakuSearchAliveEntity);

            //TODO
            //assertThat(sut.identifier().getXXX(), is(被保険者番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShikakuSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShikakuSearchAliveEntity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();

            sut = new ShikakuSearchAlive(ShikakuSearchAliveEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShikakuSearchAliveEntity.getHihokenshaNo()));
        }

        @Test
        public void get資格取得事由コードは_entityが持つ資格取得事由コードを返す() {
            assertThat(sut.get資格取得事由コード(), is(ShikakuSearchAliveEntity.getShikakuShutokuJiyuCode()));
        }

        @Test
        public void get資格取得年月日は_entityが持つ資格取得年月日を返す() {
            assertThat(sut.get資格取得年月日(), is(ShikakuSearchAliveEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get被保険者区分コードは_entityが持つ被保険者区分コードを返す() {
            assertThat(sut.get被保険者区分コード(), is(ShikakuSearchAliveEntity.getHihokennshaKubunCode()));
        }

        @Test
        public void get資格喪失事由コードは_entityが持つ資格喪失事由コードを返す() {
            assertThat(sut.get資格喪失事由コード(), is(ShikakuSearchAliveEntity.getShikakuSoshitsuJiyuCode()));
        }

        @Test
        public void get資格喪失年月日は_entityが持つ資格喪失年月日を返す() {
            assertThat(sut.get資格喪失年月日(), is(ShikakuSearchAliveEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get住所地特例フラグは_entityが持つ住所地特例フラグを返す() {
            assertThat(sut.get住所地特例フラグ(), is(ShikakuSearchAliveEntity.getJushochiTokureiFlag()));
        }

        @Test
        public void get資格変更事由コードは_entityが持つ資格変更事由コードを返す() {
            assertThat(sut.get資格変更事由コード(), is(ShikakuSearchAliveEntity.getShikakuHenkoJiyuCode()));
        }

        @Test
        public void get資格変更年月日は_entityが持つ資格変更年月日を返す() {
            assertThat(sut.get資格変更年月日(), is(ShikakuSearchAliveEntity.getShikakuHenkoYMD()));
        }

        @Test
        public void get住所地特例適用事由コードは_entityが持つ住所地特例適用事由コードを返す() {
            assertThat(sut.get住所地特例適用事由コード(), is(ShikakuSearchAliveEntity.getJushochitokureiTekiyoJiyuCode()));
        }

        @Test
        public void get住所地特例適用年月日は_entityが持つ住所地特例適用年月日を返す() {
            assertThat(sut.get住所地特例適用年月日(), is(ShikakuSearchAliveEntity.getJushochitokureiTekiyoYMD()));
        }

        @Test
        public void get住所地特例解除事由コードは_entityが持つ住所地特例解除事由コードを返す() {
            assertThat(sut.get住所地特例解除事由コード(), is(ShikakuSearchAliveEntity.getJushochitokureiKaijoJiyuCode()));
        }

        @Test
        public void get住所地特例解除年月日は_entityが持つ住所地特例解除年月日を返す() {
            assertThat(sut.get住所地特例解除年月日(), is(ShikakuSearchAliveEntity.getJushochitokureiKaijoYMD()));
        }

        @Test
        public void get広域内住所地特例フラグは_entityが持つ広域内住所地特例フラグを返す() {
            assertThat(sut.get広域内住所地特例フラグ(), is(ShikakuSearchAliveEntity.getKoikinaiJushochiTokureiFlag()));
        }

        @Test
        public void get広住特措置元市町村コードは_entityが持つ広住特措置元市町村コードを返す() {
            assertThat(sut.get広住特措置元市町村コード(), is(ShikakuSearchAliveEntity.getKoikinaiTokureiSochimotoShichosonCode()));
        }

        @Test
        public void get適用除外適用事由コードは_entityが持つ適用除外適用事由コードを返す() {
            assertThat(sut.get適用除外適用事由コード(), is(ShikakuSearchAliveEntity.getTekiyoJogaiTekiyoJiyuCode()));
        }

        @Test
        public void get適用除外適用年月日は_entityが持つ適用除外適用年月日を返す() {
            assertThat(sut.get適用除外適用年月日(), is(ShikakuSearchAliveEntity.getTekiyoJogaiTekiyoYMD()));
        }

        @Test
        public void get適用除外解除事由コードは_entityが持つ適用除外解除事由コードを返す() {
            assertThat(sut.get適用除外解除事由コード(), is(ShikakuSearchAliveEntity.getTekiyoJogaikaijokaijoJiyuCode()));
        }

        @Test
        public void get適用除外解除年月日は_entityが持つ適用除外解除年月日を返す() {
            assertThat(sut.get適用除外解除年月日(), is(ShikakuSearchAliveEntity.getTekiyoJogaiKaijoYMD()));
        }

        @Test
        public void get他市町村住所地特例適用事由コードは_entityが持つ他市町村住所地特例適用事由コードを返す() {
            assertThat(sut.get他市町村住所地特例適用事由コード(), is(ShikakuSearchAliveEntity.getTatokureiTekiyoJiyuCode()));
        }

        @Test
        public void get他市町村住所地特例適用年月日は_entityが持つ他市町村住所地特例適用年月日を返す() {
            assertThat(sut.get他市町村住所地特例適用年月日(), is(ShikakuSearchAliveEntity.getTatokureiTekiyoYMD()));
        }

        @Test
        public void get他市町村住所地特例解除事由コードは_entityが持つ他市町村住所地特例解除事由コードを返す() {
            assertThat(sut.get他市町村住所地特例解除事由コード(), is(ShikakuSearchAliveEntity.getTatokureiKaijoJiyuCode()));
        }

        @Test
        public void get他市町村住所地特例解除年月日は_entityが他市町村住所地特例解除年月日を返す() {
            assertThat(sut.get他市町村住所地特例解除年月日(), is(ShikakuSearchAliveEntity.getTatokureiKaijoYMD()));
        }

        @Test
        public void get受給者台帳被保険者番号は_entityが持つ受給者台帳被保険者番号を返す() {
            assertThat(sut.get受給者台帳被保険者番号(), is(ShikakuSearchAliveEntity.getJukyushaDaichoHihokenshaNo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShikakuSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShikakuSearchAliveEntity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();

            sut = new ShikakuSearchAlive(ShikakuSearchAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShikakuSearchAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShikakuSearchAlive sut;

        @BeforeClass
        public static void setUpClass() {
            ShikakuSearchAliveEntity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();

            sut = new ShikakuSearchAlive(ShikakuSearchAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShikakuSearchAlive sut;
        private static ShikakuSearchAlive result;

        @BeforeClass
        public static void setUpClass() {
            ShikakuSearchAliveEntity = DbV7901ShikakuSearchEntityGenerator.createDbV7901ShikakuSearchEntity();

        }

        @Test
        public void ShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがDeletedに指定されたShikakuSearchAliveが返る() {
            sut = TestSupport.setStateShikakuSearchAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがDeletedに指定されたShikakuSearchAliveが返る() {
            sut = TestSupport.setStateShikakuSearchAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがDeletedに指定されたShikakuSearchAliveが返る() {
            sut = TestSupport.setStateShikakuSearchAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShikakuSearchAliveが保持するDbV7901ShikakuSearchEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShikakuSearchAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShikakuSearchAlive setStateShikakuSearchAlive(EntityDataState parentState) {
            ShikakuSearchAliveEntity.setState(parentState);
            return new ShikakuSearchAlive(ShikakuSearchAliveEntity);
        }
    }
}
