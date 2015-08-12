/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
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
 * {@link ShoriDateKanri}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoriDateKanriTest extends DbzTestBase {

    private static DbT7022ShoriDateKanriEntity ShoriDateKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShoriDateKanri sut;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setXXX(主キー名1);
            ShoriDateKanriEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShoriDateKanri(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShoriDateKanri(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7022ShoriDateKanriEntityにセットされている() {
            sut = new ShoriDateKanri(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShoriDateKanriIdentifierにセットされている() {
            sut = new ShoriDateKanri(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShoriDateKanri sut;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setXXX(主キー名1);
            ShoriDateKanriEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShoriDateKanri(null);
        }

        @Test
        public void 指定したDbT7022ShoriDateKanriEntityのキー情報を識別子が持つ() {

            sut = new ShoriDateKanri(ShoriDateKanriEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShoriDateKanri sut;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setXXX(主キー名1);
            ShoriDateKanriEntity.setXXX(主キー名2);

            sut = new ShoriDateKanri(ShoriDateKanriEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(ShoriDateKanriEntity.getSubGyomuCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShoriDateKanriEntity.getShichosonCode()));
        }

        @Test
        public void get処理名は_entityが持つ処理名を返す() {
            assertThat(sut.get処理名(), is(ShoriDateKanriEntity.getShoriName()));
        }

        @Test
        public void get処理枝番は_entityが持つ処理枝番を返す() {
            assertThat(sut.get処理枝番(), is(ShoriDateKanriEntity.getShoriEdaban()));
        }

        @Test
        public void get年度は_entityが持つ年度を返す() {
            assertThat(sut.get年度(), is(ShoriDateKanriEntity.getNendo()));
        }

        @Test
        public void get年度内連番は_entityが持つ年度内連番を返す() {
            assertThat(sut.get年度内連番(), is(ShoriDateKanriEntity.getNendoNaiRenban()));
        }

        @Test
        public void get基準年月日は_entityが持つ基準年月日を返す() {
            assertThat(sut.get基準年月日(), is(ShoriDateKanriEntity.getKijunYMD()));
        }

        @Test
        public void get基準日時は_entityが持つ基準日時を返す() {
            assertThat(sut.get基準日時(), is(ShoriDateKanriEntity.getKijunTimestamp()));
        }

        @Test
        public void get対象開始年月日は_entityが持つ対象開始年月日を返す() {
            assertThat(sut.get対象開始年月日(), is(ShoriDateKanriEntity.getTaishoKaishiYMD()));
        }

        @Test
        public void get対象終了年月日は_entityが持つ対象終了年月日を返す() {
            assertThat(sut.get対象終了年月日(), is(ShoriDateKanriEntity.getTaishoShuryoYMD()));
        }

        @Test
        public void get対象開始日時は_entityが持つ対象開始日時を返す() {
            assertThat(sut.get対象開始日時(), is(ShoriDateKanriEntity.getTaishoKaishiTimestamp()));
        }

        @Test
        public void get対象終了日時は_entityが持つ対象終了日時を返す() {
            assertThat(sut.get対象終了日時(), is(ShoriDateKanriEntity.getTaishoShuryoTimestamp()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShoriDateKanri sut;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setXXX(主キー名1);
            ShoriDateKanriEntity.setXXX(主キー名2);

            sut = new ShoriDateKanri(ShoriDateKanriEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShoriDateKanriEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShoriDateKanri sut;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setXXX(主キー名1);
            ShoriDateKanriEntity.setXXX(主キー名2);

            sut = new ShoriDateKanri(ShoriDateKanriEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShoriDateKanri sut;
        private static ShoriDateKanri result;

        @Before
        public void setUp() {
            ShoriDateKanriEntity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            ShoriDateKanriEntity.setXXX(主キー名1);
            ShoriDateKanriEntity.setXXX(主キー名2);

        }

        @Test
        public void ShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがDeletedに指定されたShoriDateKanriが返る() {
            sut = TestSupport.setStateShoriDateKanri(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがDeletedに指定されたShoriDateKanriが返る() {
            sut = TestSupport.setStateShoriDateKanri(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがDeletedに指定されたShoriDateKanriが返る() {
            sut = TestSupport.setStateShoriDateKanri(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShoriDateKanriが保持するDbT7022ShoriDateKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShoriDateKanri(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShoriDateKanri setStateShoriDateKanri(EntityDataState parentState) {
            ShoriDateKanriEntity.setState(parentState);
            return new ShoriDateKanri(ShoriDateKanriEntity);
        }
    }
}
