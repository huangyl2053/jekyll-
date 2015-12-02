/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link NinteiChosaScheduleMemo}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteiChosaScheduleMemoTest extends DbzTestBase {

    private static DbT5222NinteiChosaScheduleMemoEntity NinteiChosaScheduleMemoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static Code 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ年月日;
        主キー名2 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ区分;
        主キー名3 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteiChosaScheduleMemo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiChosaScheduleMemoEntity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteiChosaScheduleMemo(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteiChosaScheduleMemo(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT5222NinteiChosaScheduleMemoEntityにセットされている() {
            sut = new NinteiChosaScheduleMemo(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.getメモ年月日(), is(主キー名1));
            assertThat(sut.get調査地区コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNinteiChosaScheduleMemoIdentifierにセットされている() {
            sut = new NinteiChosaScheduleMemo(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().getメモ年月日(), is(主キー名1));
            assertThat(sut.identifier().getメモ区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteiChosaScheduleMemo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiChosaScheduleMemoEntity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteiChosaScheduleMemo(null);
        }

        @Test
        public void 指定したDbT5222NinteiChosaScheduleMemoEntityのキー情報を識別子が持つ() {

            sut = new NinteiChosaScheduleMemo(NinteiChosaScheduleMemoEntity);

            assertThat(sut.identifier().getメモ年月日(), is(主キー名1));
            assertThat(sut.identifier().getメモ区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteiChosaScheduleMemo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiChosaScheduleMemoEntity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();

            sut = new NinteiChosaScheduleMemo(NinteiChosaScheduleMemoEntity);
        }

        @Test
        public void getメモ年月日は_entityが持つメモ年月日を返す() {
            assertThat(sut.getメモ年月日(), is(NinteiChosaScheduleMemoEntity.getMemoYMD()));
        }

        @Test
        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
            assertThat(sut.get調査地区コード(), is(NinteiChosaScheduleMemoEntity.getChosachikucode()));
        }

        @Test
        public void getメモ区分は_entityが持つメモ区分を返す() {
            assertThat(sut.getメモ区分(), is(NinteiChosaScheduleMemoEntity.getMemoKubun()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(NinteiChosaScheduleMemoEntity.getRemban()));
        }

        @Test
        public void getメモ指定調査地区コードは_entityが持つメモ指定調査地区コードを返す() {
            assertThat(sut.getメモ指定調査地区コード(), is(NinteiChosaScheduleMemoEntity.getMemoShiteiChosaChikuCode()));
        }

        @Test
        public void get作成者は_entityが持つ作成者を返す() {
            assertThat(sut.get作成者(), is(NinteiChosaScheduleMemoEntity.getSakuseisha()));
        }

        @Test
        public void getメモ重要度は_entityが持つメモ重要度を返す() {
            assertThat(sut.getメモ重要度(), is(NinteiChosaScheduleMemoEntity.getMemoPriority()));
        }

        @Test
        public void getメモ内容は_entityが持つメモ内容を返す() {
            assertThat(sut.getメモ内容(), is(NinteiChosaScheduleMemoEntity.getMemoNaiyo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteiChosaScheduleMemo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiChosaScheduleMemoEntity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();

            sut = new NinteiChosaScheduleMemo(NinteiChosaScheduleMemoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteiChosaScheduleMemoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteiChosaScheduleMemo sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiChosaScheduleMemoEntity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();

            sut = new NinteiChosaScheduleMemo(NinteiChosaScheduleMemoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteiChosaScheduleMemo sut;
        private static NinteiChosaScheduleMemo result;

        @BeforeClass
        public static void setUpClass() {
            NinteiChosaScheduleMemoEntity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();

        }

        @Test
        public void NinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがDeletedに指定されたNinteiChosaScheduleMemoが返る() {
            sut = TestSupport.setStateNinteiChosaScheduleMemo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがDeletedに指定されたNinteiChosaScheduleMemoが返る() {
            sut = TestSupport.setStateNinteiChosaScheduleMemo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがDeletedに指定されたNinteiChosaScheduleMemoが返る() {
            sut = TestSupport.setStateNinteiChosaScheduleMemo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteiChosaScheduleMemoが保持するDbT5222NinteiChosaScheduleMemoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteiChosaScheduleMemo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteiChosaScheduleMemo setStateNinteiChosaScheduleMemo(EntityDataState parentState) {
            NinteiChosaScheduleMemoEntity.setState(parentState);
            return new NinteiChosaScheduleMemo(NinteiChosaScheduleMemoEntity);
        }
    }
}
