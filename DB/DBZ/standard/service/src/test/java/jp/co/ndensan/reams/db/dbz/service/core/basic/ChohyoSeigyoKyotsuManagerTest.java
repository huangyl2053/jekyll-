/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7065ChohyoSeigyoKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
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
 * {link ChohyoSeigyoKyotsuManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuManagerTest {

    private static DbT7065ChohyoSeigyoKyotsuDac dac;
    private static ChohyoSeigyoKyotsuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7065ChohyoSeigyoKyotsuDac.class);
        sut = new ChohyoSeigyoKyotsuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票制御共通 extends DbzTestBase {

        SubGyomuCode サブ業務コード = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
        ReportId 帳票分類ID = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get帳票制御共通(null, 帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get帳票制御共通(サブ業務コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(null);

            ChohyoSeigyoKyotsu result = sut.get帳票制御共通(サブ業務コード, 帳票分類ID);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            when(dac.selectByKey(any(SubGyomuCode.class), any(ReportId.class))).thenReturn(entity);

            ChohyoSeigyoKyotsu result = sut.get帳票制御共通(サブ業務コード, 帳票分類ID);

            assertThat(result.getサブ業務コード().value(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票制御共通一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChohyoSeigyoKyotsu> result = sut.get帳票制御共通一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7065ChohyoSeigyoKyotsuEntity> entityList = Arrays.asList(DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChohyoSeigyoKyotsu> result = sut.get帳票制御共通一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save帳票制御共通 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);

            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);

            assertThat(sut.save帳票制御共通(帳票制御共通), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(0);

            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);

            assertThat(sut.save帳票制御共通(帳票制御共通), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);

            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);
            帳票制御共通 = 帳票制御共通.createBuilderForEdit().set帳票分類名称(new RString("帳票分類名称を変更")).build();

            assertThat(sut.save帳票制御共通(帳票制御共通), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(0);

            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);
            帳票制御共通 = 帳票制御共通.createBuilderForEdit().set帳票分類名称(new RString("帳票分類名称を変更")).build();

            assertThat(sut.save帳票制御共通(帳票制御共通), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);

            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);
            帳票制御共通 = 帳票制御共通.deleted();

            assertThat(sut.save帳票制御共通(帳票制御共通), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(0);

            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);
            帳票制御共通 = 帳票制御共通.deleted();

            assertThat(sut.save帳票制御共通(帳票制御共通), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            entity.initializeMd5();
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(entity);

            assertThat(sut.save帳票制御共通(帳票制御共通), is(false));
        }
    }
}
