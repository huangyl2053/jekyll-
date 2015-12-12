/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link HokenryoRankManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class HokenryoRankManagerTest {

    private static DbT2012HokenryoRankDac dac;
    private static HokenryoRankManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2012HokenryoRankDac.class);
        sut = new HokenryoRankManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get保険料ランク extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー2 = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
            sut.get保険料ランク(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
            sut.get保険料ランク(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(LasdecCode.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
            LasdecCode 主キー2 = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
            HokenryoRank result = sut.get保険料ランク(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(LasdecCode.class))).thenReturn(entity);

            FlexibleYear 主キー1 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
            LasdecCode 主キー2 = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
            HokenryoRank result = sut.get保険料ランク(主キー1, 主キー2);

            assertThat(result.get賦課年度().toDateString(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get保険料ランク一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<HokenryoRank> result = sut.get保険料ランク一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2012HokenryoRankEntity> entityList = Arrays.asList(DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<HokenryoRank> result = sut.get保険料ランク一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get賦課年度().toDateString(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    public static class save保険料ランク extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2012HokenryoRankEntity.class))).thenReturn(1);

            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);

            assertThat(sut.save保険料ランク(保険料ランク), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2012HokenryoRankEntity.class))).thenReturn(0);

            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);

            assertThat(sut.save保険料ランク(保険料ランク), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2012HokenryoRankEntity.class))).thenReturn(1);

            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.initializeMd5();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);
            保険料ランク = 保険料ランク.createBuilderForEdit().setランク区分(new RankKubun(new RString("任意項目1を変更"))).build();

            assertThat(sut.save保険料ランク(保険料ランク), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2012HokenryoRankEntity.class))).thenReturn(0);

            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.initializeMd5();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);
            保険料ランク = 保険料ランク.createBuilderForEdit().setランク区分(new RankKubun(new RString("任意項目1を変更"))).build();

            assertThat(sut.save保険料ランク(保険料ランク), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2012HokenryoRankEntity.class))).thenReturn(1);

            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.initializeMd5();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);
            保険料ランク = 保険料ランク.deleted();

            assertThat(sut.save保険料ランク(保険料ランク), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2012HokenryoRankEntity.class))).thenReturn(0);

            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.initializeMd5();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);
            保険料ランク = 保険料ランク.deleted();

            assertThat(sut.save保険料ランク(保険料ランク), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2012HokenryoRankEntity entity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            entity.initializeMd5();
            HokenryoRank 保険料ランク = new HokenryoRank(entity);

            assertThat(sut.save保険料ランク(保険料ランク), is(false));
        }
    }
}
