/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * {@link ChohyoBunruiKanri}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoBunruiKanriTest extends DbzTestBase {

    private static DbT7068ChohyoBunruiKanriEntity chohyoBunruiKanriEntity;
    private static SubGyomuCode サブ業務コード;
    private static ReportId 帳票ID;

    @BeforeClass
    public static void setUpClass() {
        サブ業務コード = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
        帳票ID = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoBunruiKanri(null, 帳票ID);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票IDがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoBunruiKanri(サブ業務コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7068ChohyoBunruiKanriEntityにセットされている() {
            sut = new ChohyoBunruiKanri(サブ業務コード, 帳票ID);
            assertThat(sut.getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.get帳票ID(), is(帳票ID));
        }

        @Test
        public void 指定したキーが保持するChohyoBunruiKanriIdentifierにセットされている() {
            sut = new ChohyoBunruiKanri(サブ業務コード, 帳票ID);
//            assertThat(sut.identifier().getXXX(), is(サブ業務コード));
//            assertThat(sut.identifier().getXXX(), is(帳票ID));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChohyoBunruiKanri(null);
        }

        @Test
        public void 指定したDbT7068ChohyoBunruiKanriEntityのキー情報を識別子が持つ() {

            sut = new ChohyoBunruiKanri(chohyoBunruiKanriEntity);

//            assertThat(sut.identifier().getXXX(), is(サブ業務コード));
//            assertThat(sut.identifier().getXXX(), is(帳票ID));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);

            sut = new ChohyoBunruiKanri(chohyoBunruiKanriEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(chohyoBunruiKanriEntity.getSubGyomuCode()));
        }

        @Test
        public void get帳票IDは_entityが持つ帳票IDを返す() {
            assertThat(sut.get帳票ID(), is(chohyoBunruiKanriEntity.getReportID()));
        }

        @Test
        public void get帳票分類IDは_entityが持つ帳票分類IDを返す() {
            assertThat(sut.get帳票分類ID(), is(chohyoBunruiKanriEntity.getChohyoBunruiID()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);

            sut = new ChohyoBunruiKanri(chohyoBunruiKanriEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(chohyoBunruiKanriEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);

            sut = new ChohyoBunruiKanri(chohyoBunruiKanriEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChohyoBunruiKanri sut;
        private static ChohyoBunruiKanri result;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);

        }

        @Test
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedに指定されたChohyoBunruiKanriが返る() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedに指定されたChohyoBunruiKanriが返る() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがDeletedに指定されたChohyoBunruiKanriが返る() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChohyoBunruiKanriが保持するDbT7068ChohyoBunruiKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChohyoBunruiKanri(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChohyoBunruiKanri setStateChohyoBunruiKanri(EntityDataState parentState) {
            chohyoBunruiKanriEntity.setState(parentState);
            return new ChohyoBunruiKanri(chohyoBunruiKanriEntity);
        }
    }
}
