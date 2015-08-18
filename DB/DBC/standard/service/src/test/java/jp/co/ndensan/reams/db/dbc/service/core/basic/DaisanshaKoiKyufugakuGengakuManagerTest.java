/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiKyufugakuGengaku;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3081DaisanshaKoiKyufugakuGengakuDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link DaisanshaKoiKyufugakuGengakuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyufugakuGengakuManagerTest {

    private static DbT3081DaisanshaKoiKyufugakuGengakuDac dac;
    private static DaisanshaKoiKyufugakuGengakuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3081DaisanshaKoiKyufugakuGengakuDac.class);
        sut = new DaisanshaKoiKyufugakuGengakuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護第三者行為給付額減額 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号;
            Decimal 主キー3 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為給付額減額(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号;
            sut.get介護第三者行為給付額減額(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号;
            sut.get介護第三者行為給付額減額(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号;
            Decimal 主キー3 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号;
            DaisanshaKoiKyufugakuGengaku result = sut.get介護第三者行為給付額減額(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号;
            Decimal 主キー3 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号;
            DaisanshaKoiKyufugakuGengaku result = sut.get介護第三者行為給付額減額(主キー1, 主キー2, 主キー3);

            assertThat(result.get主キー1().value(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護第三者行為給付額減額一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<DaisanshaKoiKyufugakuGengaku> result = sut.get介護第三者行為給付額減額一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3081DaisanshaKoiKyufugakuGengakuEntity> entityList = Arrays.asList(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<DaisanshaKoiKyufugakuGengaku> result = sut.get介護第三者行為給付額減額一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save介護第三者行為給付額減額 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3081DaisanshaKoiKyufugakuGengakuEntity.class))).thenReturn(1);

            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3081DaisanshaKoiKyufugakuGengakuEntity.class))).thenReturn(0);

            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3081DaisanshaKoiKyufugakuGengakuEntity.class))).thenReturn(1);

            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            entity.initializeMd5();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);
            介護第三者行為給付額減額 = 介護第三者行為給付額減額.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3081DaisanshaKoiKyufugakuGengakuEntity.class))).thenReturn(0);

            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            entity.initializeMd5();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);
            介護第三者行為給付額減額 = 介護第三者行為給付額減額.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3081DaisanshaKoiKyufugakuGengakuEntity.class))).thenReturn(1);

            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            entity.initializeMd5();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);
            介護第三者行為給付額減額 = 介護第三者行為給付額減額.deleted();

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3081DaisanshaKoiKyufugakuGengakuEntity.class))).thenReturn(0);

            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            entity.initializeMd5();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);
            介護第三者行為給付額減額 = 介護第三者行為給付額減額.deleted();

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.createDbT3081DaisanshaKoiKyufugakuGengakuEntity();
            entity.initializeMd5();
            DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額 = new DaisanshaKoiKyufugakuGengaku(entity);

            assertThat(sut.save介護第三者行為給付額減額(介護第三者行為給付額減額), is(false));
        }
    }
}
