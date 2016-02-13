/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.business.config.KaigoToiawasesakiConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KaigoToiawasesakiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoToiawasesakiManagerTest extends DbzTestDacBase {

    private static DbT7069KaigoToiawasesakiDac dac;
    private static DbT7069KaigoToiawasesakiDac dac2;
    private static KaigoToiawasesakiConfig config;
    private static KaigoToiawasesakiManager sut;
    private static KaigoToiawasesakiManager sut2;
    private static final SubGyomuCode 共通サブ業務コード = SubGyomuCode.DBZ介護共通;
    private static final SubGyomuCode DBAサブ業務コード = SubGyomuCode.DBA介護資格;
    private static final ReportId 共通帳票分類ID = new ReportId(new RString("000000000"));
    private static final ReportId ダミー帳票分類ID = new ReportId(new RString("000000001"));

    @BeforeClass
    public static void test() {
        dac = mock(DbT7069KaigoToiawasesakiDac.class);
        dac2 = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
        config = mock(KaigoToiawasesakiConfig.class);
        sut = new KaigoToiawasesakiManager(dac, config);
        sut2 = new KaigoToiawasesakiManager(config);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護問合せ先By主キー extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            sut.get介護問合せ先By主キー(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            sut.get介護問合せ先By主キー(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(null);

            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            KaigoToiawasesaki result = sut.get介護問合せ先By主キー(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(entity);
            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            KaigoToiawasesaki result = sut.get介護問合せ先By主キー(主キー1, 主キー2);

            assertThat(result.getサブ業務コード().value(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class get介護共通問合せ先 extends DbzTestDacBase {

        @Test
        public void 共通問合せ先なしの場合_get介護共通問合せ先は_nullを返す() {
            TestSupport.deleteData();
            KaigoToiawasesaki result = sut2.get介護共通問合せ先();
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 共通問合せ先ありの場合_get介護共通問合せ先は_該当する問合せ先を返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    共通サブ業務コード,
                    共通帳票分類ID);
            KaigoToiawasesaki result = sut2.get介護共通問合せ先();
            assertThat(result, is(notNullValue()));
        }
    }

    public static class getサブ業務共通問合せ先 extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数のサブ業務コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut2.getサブ業務共通問合せ先(null);
        }

        @Test
        public void サブ業務共通問合せ先なしの場合_getサブ業務共通問合せ先は_nullを返す() {
            TestSupport.deleteData();
            KaigoToiawasesaki result = sut2.getサブ業務共通問合せ先(DBAサブ業務コード);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void サブ業務共通問合せ先ありの場合_getサブ業務共通問合せ先は_該当する問合せ先を返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    共通帳票分類ID);
            KaigoToiawasesaki result = sut2.getサブ業務共通問合せ先(DBAサブ業務コード);
            assertThat(result, is(notNullValue()));
        }
    }

    public static class get帳票問合せ先 extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数の帳票分類IDにnullを指定した場合_NullPointerExceptionが発生する() {
            sut2.get帳票問合せ先(null);
        }

        @Test
        public void 帳票分類IDに該当する問合せ先なしの場合_get帳票問合せ先は_nullを返す() {
            TestSupport.deleteData();
            KaigoToiawasesaki result = sut2.get帳票問合せ先(ダミー帳票分類ID);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 帳票分類IDに該当する問合せ先ありの場合_get帳票問合せ先は_該当する問合せ先を返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    ダミー帳票分類ID);
            KaigoToiawasesaki result = sut2.get帳票問合せ先(ダミー帳票分類ID);
            assertThat(result, is(notNullValue()));
        }
    }

    public static class get介護問合せ先 extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数のサブ業務コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut2.get介護問合せ先(null, 共通帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の帳票分類IDにnullを指定した場合_NullPointerExceptionが発生する() {
            sut2.get介護問合せ先(DBAサブ業務コード, null);
        }

        @Test
        public void 帳票分類IDで指定された問合せ先ありの場合_get介護問合せ先は_帳票分類IDの問合せ先を返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    ダミー帳票分類ID);
            KaigoToiawasesaki result = sut2.get介護問合せ先(DBAサブ業務コード, ダミー帳票分類ID);
            assertThat(result.get帳票分類ID().value(), is(ダミー帳票分類ID.value()));
        }

        @Test
        public void 帳票分類IDで指定された問合せ先なし_業務コンフィグ問合せ先管理単位が介護共通_介護共通問合せ先ありの場合_get介護問合せ先は_介護共通の問合せ先を返す() {
            when(config.get問合せ先_管理単位()).thenReturn(new RString("0"));
            TestSupport.deleteData();
            TestSupport.insert(
                    共通サブ業務コード,
                    共通帳票分類ID);
            KaigoToiawasesaki result = sut2.get介護問合せ先(DBAサブ業務コード, ダミー帳票分類ID);
            assertThat(result.getサブ業務コード().value(), is(共通サブ業務コード.value()));
            assertThat(result.get帳票分類ID().value(), is(共通帳票分類ID.value()));
        }

        @Test
        public void 帳票分類IDで指定された問合せ先なし_業務コンフィグ問合せ先管理単位が介護共通_介護共通問合せ先なしの場合_get介護問合せ先は_nullを返す() {
            when(config.get問合せ先_管理単位()).thenReturn(new RString("0"));
            TestSupport.deleteData();
            KaigoToiawasesaki result = sut2.get介護問合せ先(DBAサブ業務コード, ダミー帳票分類ID);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 帳票分類IDで指定された問合せ先なし_業務コンフィグ問合せ先管理単位がサブ業務単位_サブ業務共通問合せ先ありの場合_get介護問合せ先は_サブ業務共通の問合せ先を返す() {
            when(config.get問合せ先_管理単位()).thenReturn(new RString("1"));
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    共通帳票分類ID);
            KaigoToiawasesaki result = sut2.get介護問合せ先(DBAサブ業務コード, ダミー帳票分類ID);
            assertThat(result.getサブ業務コード().value(), is(DBAサブ業務コード.value()));
            assertThat(result.get帳票分類ID().value(), is(共通帳票分類ID.value()));
        }

        @Test
        public void 帳票分類IDで指定された問合せ先なし_業務コンフィグ問合せ先管理単位がサブ業務単位_サブ業務共通問合せ先なしの場合_get介護問合せ先は_nullを返す() {
            when(config.get問合せ先_管理単位()).thenReturn(new RString("1"));
            TestSupport.deleteData();
            KaigoToiawasesaki result = sut2.get介護問合せ先(DBAサブ業務コード, ダミー帳票分類ID);
            assertThat(result, is(nullValue()));
        }

    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護問合せ先一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoToiawasesaki> result = sut.get介護問合せ先一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7069KaigoToiawasesakiEntity> entityList = Arrays.asList(DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoToiawasesaki> result = sut.get介護問合せ先一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save介護問合せ先 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7069KaigoToiawasesakiEntity.class))).thenReturn(1);

            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);

            assertThat(sut.save介護問合せ先(介護問合せ先), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7069KaigoToiawasesakiEntity.class))).thenReturn(0);

            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);

            assertThat(sut.save介護問合せ先(介護問合せ先), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7069KaigoToiawasesakiEntity.class))).thenReturn(1);

            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.initializeMd5();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);
            介護問合せ先 = 介護問合せ先.createBuilderForEdit().set所在地(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護問合せ先(介護問合せ先), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7069KaigoToiawasesakiEntity.class))).thenReturn(0);

            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.initializeMd5();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);
            介護問合せ先 = 介護問合せ先.createBuilderForEdit().set所在地(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護問合せ先(介護問合せ先), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7069KaigoToiawasesakiEntity.class))).thenReturn(1);

            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.initializeMd5();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);
            介護問合せ先 = 介護問合せ先.deleted();

            assertThat(sut.save介護問合せ先(介護問合せ先), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7069KaigoToiawasesakiEntity.class))).thenReturn(0);

            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.initializeMd5();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);
            介護問合せ先 = 介護問合せ先.deleted();

            assertThat(sut.save介護問合せ先(介護問合せ先), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.initializeMd5();
            KaigoToiawasesaki 介護問合せ先 = new KaigoToiawasesaki(entity);

            assertThat(sut.save介護問合せ先(介護問合せ先), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票分類ID) {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setChohyoBunruiID(帳票分類ID);
            dac2.save(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7069KaigoToiawasesakiEntity.TABLE_NAME.toString());
        }
    }
}
