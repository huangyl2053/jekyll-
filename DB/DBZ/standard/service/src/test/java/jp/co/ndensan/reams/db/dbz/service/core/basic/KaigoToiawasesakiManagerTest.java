/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
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
public class KaigoToiawasesakiManagerTest {

    private static DbT7069KaigoToiawasesakiDac dac;
    private static KaigoToiawasesakiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7069KaigoToiawasesakiDac.class);
        sut = new KaigoToiawasesakiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護問合せ先 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            sut.get介護問合せ先(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            sut.get介護問合せ先(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(null);

            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            KaigoToiawasesaki result = sut.get介護問合せ先(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(entity);
            SubGyomuCode 主キー1 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
            KaigoToiawasesaki result = sut.get介護問合せ先(主キー1, 主キー2);

            assertThat(result.getサブ業務コード().value(), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード.value()));
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
}
