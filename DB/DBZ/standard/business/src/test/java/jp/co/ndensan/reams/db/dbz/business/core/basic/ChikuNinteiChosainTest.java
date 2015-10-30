/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link ChikuNinteiChosain}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChikuNinteiChosainTest extends DbzTestBase {

    private static DbT5223ChikuNinteiChosainEntity chikuNinteiChosainEntity;
    private static Code 調査地区コード;
    private static RString 認定調査委託先コード;
    private static RString 認定調査員コード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
        認定調査委託先コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
        認定調査員コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
        市町村コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            chikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuNinteiChosain(null, 認定調査委託先コード, 認定調査員コード, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuNinteiChosain(調査地区コード, null, 認定調査員コード, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuNinteiChosain(調査地区コード, 認定調査委託先コード, null, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名4がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChikuNinteiChosain(調査地区コード, 認定調査委託先コード, 認定調査員コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT5223ChikuNinteiChosainEntityにセットされている() {
            sut = new ChikuNinteiChosain(調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
            assertThat(sut.get調査地区コード(), is(調査地区コード));
            assertThat(sut.get認定調査委託先コード(), is(認定調査委託先コード));
            assertThat(sut.get認定調査員コード(), is(認定調査員コード));
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 指定したキーが保持するChikuNinteiChosainIdentifierにセットされている() {
            sut = new ChikuNinteiChosain(調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
            assertThat(sut.identifier().get調査地区コード(), is(調査地区コード));
            assertThat(sut.identifier().get認定調査委託先コード(), is(認定調査委託先コード));
            assertThat(sut.identifier().get認定調査員コード(), is(認定調査員コード));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            chikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChikuNinteiChosain(null);
        }

        @Test
        public void 指定したDbT5223ChikuNinteiChosainEntityのキー情報を識別子が持つ() {

            sut = new ChikuNinteiChosain(chikuNinteiChosainEntity);

            assertThat(sut.identifier().get調査地区コード(), is(調査地区コード));
            assertThat(sut.identifier().get認定調査委託先コード(), is(認定調査委託先コード));
            assertThat(sut.identifier().get認定調査員コード(), is(認定調査員コード));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            chikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

            sut = new ChikuNinteiChosain(chikuNinteiChosainEntity);
        }

        @Test
        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
            assertThat(sut.get調査地区コード(), is(chikuNinteiChosainEntity.getChosaChikuCode()));
        }

        @Test
        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(chikuNinteiChosainEntity.getNinteiChosaItakusakiCode()));
        }

        @Test
        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(chikuNinteiChosainEntity.getNinteiChosainCode()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(chikuNinteiChosainEntity.getShichosonCode()));
        }

        @Test
        public void get優先番号は_entityが持つ優先番号を返す() {
            assertThat(sut.get優先番号(), is(chikuNinteiChosainEntity.getYusenNo()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(chikuNinteiChosainEntity.getBiko()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            chikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

            sut = new ChikuNinteiChosain(chikuNinteiChosainEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(chikuNinteiChosainEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;

        @BeforeClass
        public static void setUpClass() {
            chikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

            sut = new ChikuNinteiChosain(chikuNinteiChosainEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChikuNinteiChosain sut;
        private static ChikuNinteiChosain result;

        @BeforeClass
        public static void setUpClass() {
            chikuNinteiChosainEntity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();

        }

        @Test
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedに指定されたChikuNinteiChosainが返る() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedに指定されたChikuNinteiChosainが返る() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがDeletedに指定されたChikuNinteiChosainが返る() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChikuNinteiChosainが保持するDbT5223ChikuNinteiChosainEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChikuNinteiChosain(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChikuNinteiChosain setStateChikuNinteiChosain(EntityDataState parentState) {
            chikuNinteiChosainEntity.setState(parentState);
            return new ChikuNinteiChosain(chikuNinteiChosainEntity);
        }
    }
}
