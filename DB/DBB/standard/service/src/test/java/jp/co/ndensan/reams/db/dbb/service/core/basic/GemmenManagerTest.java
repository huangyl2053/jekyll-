/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link GemmenManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class GemmenManagerTest {

    private static DbT2004GemmenDac dac;
    private static GemmenManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2004GemmenDac.class);
        sut = new GemmenManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護賦課減免 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
            Decimal 主キー4 = DbT2004GemmenEntityGenerator.DEFAULT_履歴番号;
            sut.get介護賦課減免(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
            TsuchishoNo 主キー3 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
            Decimal 主キー4 = DbT2004GemmenEntityGenerator.DEFAULT_履歴番号;
            sut.get介護賦課減免(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
            Decimal 主キー4 = DbT2004GemmenEntityGenerator.DEFAULT_履歴番号;
            sut.get介護賦課減免(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
            sut.get介護賦課減免(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(Decimal.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
            Decimal 主キー4 = DbT2004GemmenEntityGenerator.DEFAULT_履歴番号;
            Gemmen result = sut.get介護賦課減免(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(Decimal.class))).thenReturn(entity);

            FlexibleYear 主キー1 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
            Decimal 主キー4 = DbT2004GemmenEntityGenerator.DEFAULT_履歴番号;
            Gemmen result = sut.get介護賦課減免(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get調定年度().toDateString(), is(DbT2004GemmenEntityGenerator.DEFAULT_調定年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護賦課減免一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<Gemmen> result = sut.get介護賦課減免一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2004GemmenEntity> entityList = Arrays.asList(DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<Gemmen> result = sut.get介護賦課減免一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調定年度().toDateString(), is(DbT2004GemmenEntityGenerator.DEFAULT_調定年度.toDateString()));
        }
    }

    public static class save介護賦課減免 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2004GemmenEntity.class))).thenReturn(1);

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            Gemmen 介護賦課減免 = new Gemmen(entity);

            assertThat(sut.save介護賦課減免(介護賦課減免), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2004GemmenEntity.class))).thenReturn(0);

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            Gemmen 介護賦課減免 = new Gemmen(entity);

            assertThat(sut.save介護賦課減免(介護賦課減免), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2004GemmenEntity.class))).thenReturn(1);

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.initializeMd5();
            Gemmen 介護賦課減免 = new Gemmen(entity);
            介護賦課減免 = 介護賦課減免.createBuilderForEdit().set申請事由(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護賦課減免(介護賦課減免), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2004GemmenEntity.class))).thenReturn(0);

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.initializeMd5();
            Gemmen 介護賦課減免 = new Gemmen(entity);
            介護賦課減免 = 介護賦課減免.createBuilderForEdit().set申請事由(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護賦課減免(介護賦課減免), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2004GemmenEntity.class))).thenReturn(1);

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.initializeMd5();
            Gemmen 介護賦課減免 = new Gemmen(entity);
            介護賦課減免 = 介護賦課減免.deleted();

            assertThat(sut.save介護賦課減免(介護賦課減免), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2004GemmenEntity.class))).thenReturn(0);

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.initializeMd5();
            Gemmen 介護賦課減免 = new Gemmen(entity);
            介護賦課減免 = 介護賦課減免.deleted();

            assertThat(sut.save介護賦課減免(介護賦課減免), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.initializeMd5();
            Gemmen 介護賦課減免 = new Gemmen(entity);

            assertThat(sut.save介護賦課減免(介護賦課減免), is(false));
        }
    }
}
