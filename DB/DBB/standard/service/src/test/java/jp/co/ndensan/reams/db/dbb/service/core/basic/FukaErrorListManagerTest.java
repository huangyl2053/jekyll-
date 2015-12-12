/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link FukaErrorListManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class FukaErrorListManagerTest {

    private static DbT2010FukaErrorListDac dac;
    private static FukaErrorListManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2010FukaErrorListDac.class);
        sut = new FukaErrorListManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課エラー一覧 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
            FlexibleYear 主キー3 = DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー4 = DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号;
            sut.get賦課エラー一覧(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
            FlexibleYear 主キー3 = DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー4 = DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号;
            sut.get賦課エラー一覧(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
            RString 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
            TsuchishoNo 主キー4 = DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号;
            sut.get賦課エラー一覧(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            SubGyomuCode 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
            RString 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
            FlexibleYear 主キー3 = DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度;
            sut.get賦課エラー一覧(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(RString.class), any(FlexibleYear.class), any(TsuchishoNo.class))).thenReturn(null);

            SubGyomuCode 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
            RString 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
            FlexibleYear 主キー3 = DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー4 = DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号;
            FukaErrorList result = sut.get賦課エラー一覧(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(RString.class), any(FlexibleYear.class), any(TsuchishoNo.class))).thenReturn(entity);

            SubGyomuCode 主キー1 = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
            RString 主キー2 = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
            FlexibleYear 主キー3 = DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー4 = DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号;
            FukaErrorList result = sut.get賦課エラー一覧(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.getサブ業務コード().value(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get賦課エラー一覧一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<FukaErrorList> result = sut.get賦課エラー一覧一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2010FukaErrorListEntity> entityList = Arrays.asList(DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<FukaErrorList> result = sut.get賦課エラー一覧一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save賦課エラー一覧 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(1);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(0);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(1);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.createBuilderForEdit().setバッチID(new RString("012345")).build();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(0);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.createBuilderForEdit().setバッチID(new RString("012345")).build();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(1);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.deleted();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2010FukaErrorListEntity.class))).thenReturn(0);

            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);
            賦課エラー一覧 = 賦課エラー一覧.deleted();

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.initializeMd5();
            FukaErrorList 賦課エラー一覧 = new FukaErrorList(entity);

            assertThat(sut.save賦課エラー一覧(賦課エラー一覧), is(false));
        }
    }
}
