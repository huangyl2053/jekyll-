/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link HokenryoDankaiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class HokenryoDankaiManagerTest {

    private static DbT2013HokenryoDankaiDac dac;
    private static HokenryoDankaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2013HokenryoDankaiDac.class);
        sut = new HokenryoDankaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get保険料段階 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
            RString 主キー3 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
            sut.get保険料段階(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
            RString 主キー3 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
            sut.get保険料段階(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
            RString 主キー2 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
            sut.get保険料段階(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(RString.class), any(RString.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
            RString 主キー2 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
            RString 主キー3 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
            HokenryoDankai result = sut.get保険料段階(主キー1, 主キー2, 主キー3).get();

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(RString.class), any(RString.class))).thenReturn(entity);
            FlexibleYear 主キー1 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
            RString 主キー2 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
            RString 主キー3 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分;
            HokenryoDankai result = sut.get保険料段階(主キー1, 主キー2, 主キー3).get();

            assertThat(result.get賦課年度().toDateString(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get保険料段階一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<HokenryoDankai> result = sut.get保険料段階一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2013HokenryoDankaiEntity> entityList = Arrays.asList(DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<HokenryoDankai> result = sut.get保険料段階一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get賦課年度().toDateString(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    public static class save保険料段階 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2013HokenryoDankaiEntity.class))).thenReturn(1);

            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);

            assertThat(sut.save保険料段階(保険料段階), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2013HokenryoDankaiEntity.class))).thenReturn(0);

            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);

            assertThat(sut.save保険料段階(保険料段階), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2013HokenryoDankaiEntity.class))).thenReturn(1);

            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            entity.initializeMd5();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);
            保険料段階 = 保険料段階.createBuilderForEdit().setランク区分(new RString("3")).build();

            assertThat(sut.save保険料段階(保険料段階), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2013HokenryoDankaiEntity.class))).thenReturn(0);

            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            entity.initializeMd5();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);
            保険料段階 = 保険料段階.createBuilderForEdit().setランク区分(new RString("3")).build();

            assertThat(sut.save保険料段階(保険料段階), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2013HokenryoDankaiEntity.class))).thenReturn(1);

            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            entity.initializeMd5();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);
            保険料段階 = 保険料段階.deleted();

            assertThat(sut.save保険料段階(保険料段階), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2013HokenryoDankaiEntity.class))).thenReturn(0);

            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            entity.initializeMd5();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);
            保険料段階 = 保険料段階.deleted();

            assertThat(sut.save保険料段階(保険料段階), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2013HokenryoDankaiEntity entity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            entity.initializeMd5();
            HokenryoDankai 保険料段階 = new HokenryoDankai(entity);

            assertThat(sut.save保険料段階(保険料段階), is(false));
        }
    }
}
