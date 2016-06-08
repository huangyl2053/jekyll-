/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuControl;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7066ChohyoSeigyoKyotsuControlEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7066ChohyoSeigyoKyotsuControlDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ChohyoSeigyoKyotsuControlManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuControlManagerTest {

    private static DbT7066ChohyoSeigyoKyotsuControlDac dac;
    private static ChohyoSeigyoKyotsuControlManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7066ChohyoSeigyoKyotsuControlDac.class);
        sut = new ChohyoSeigyoKyotsuControlManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票制御共通コントロール extends DbzTestBase {

        SubGyomuCode サブ業務コード = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_サブ業務コード;
        ReportId 帳票分類ID = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票分類ID;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get帳票制御共通コントロール(null, 帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get帳票制御共通コントロール(サブ業務コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(null);

            ChohyoSeigyoKyotsuControl result = sut.get帳票制御共通コントロール(サブ業務コード, 帳票分類ID);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(entity);

            ChohyoSeigyoKyotsuControl result = sut.get帳票制御共通コントロール(サブ業務コード, 帳票分類ID);

            assertThat(result.getサブ業務コード().value(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票制御共通コントロール一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChohyoSeigyoKyotsuControl> result = sut.get帳票制御共通コントロール一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7066ChohyoSeigyoKyotsuControlEntity> entityList = Arrays.asList(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChohyoSeigyoKyotsuControl> result = sut.get帳票制御共通コントロール一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save帳票制御共通コントロール extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7066ChohyoSeigyoKyotsuControlEntity.class))).thenReturn(1);

            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7066ChohyoSeigyoKyotsuControlEntity.class))).thenReturn(0);

            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7066ChohyoSeigyoKyotsuControlEntity.class))).thenReturn(1);

            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);
            帳票制御共通コントロール = 帳票制御共通コントロール.createBuilderForEdit().set文書番号使用区分(new RString("文書番号使用区分を変更")).build();

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7066ChohyoSeigyoKyotsuControlEntity.class))).thenReturn(0);

            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);
            帳票制御共通コントロール = 帳票制御共通コントロール.createBuilderForEdit().set文書番号使用区分(new RString("文書番号使用区分を変更")).build();

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7066ChohyoSeigyoKyotsuControlEntity.class))).thenReturn(1);

            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);
            帳票制御共通コントロール = 帳票制御共通コントロール.deleted();

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7066ChohyoSeigyoKyotsuControlEntity.class))).thenReturn(0);

            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);
            帳票制御共通コントロール = 帳票制御共通コントロール.deleted();

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsuControl 帳票制御共通コントロール = new ChohyoSeigyoKyotsuControl(entity);

            assertThat(sut.save帳票制御共通コントロール(帳票制御共通コントロール), is(false));
        }
    }
}
