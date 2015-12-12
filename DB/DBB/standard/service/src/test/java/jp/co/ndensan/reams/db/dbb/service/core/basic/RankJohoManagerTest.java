/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RankJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2011RankJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
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
 * {link RankJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class RankJohoManagerTest {

    private static DbT2011RankJohoDac dac;
    private static RankJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2011RankJohoDac.class);
        sut = new RankJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getランク情報 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RankKubun 主キー2 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
            sut.getランク情報(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
            sut.getランク情報(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(RankKubun.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
            RankKubun 主キー2 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
            RankJoho result = sut.getランク情報(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(RankKubun.class))).thenReturn(entity);

            FlexibleYear 主キー1 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
            RankKubun 主キー2 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
            RankJoho result = sut.getランク情報(主キー1, 主キー2);

            assertThat(result.get賦課年度().toDateString(), is(DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getランク情報一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RankJoho> result = sut.getランク情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2011RankJohoEntity> entityList = Arrays.asList(DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RankJoho> result = sut.getランク情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get賦課年度().toDateString(), is(DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度.toDateString()));
        }
    }

    public static class saveランク情報 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2011RankJohoEntity.class))).thenReturn(1);

            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJoho ランク情報 = new RankJoho(entity);

            assertThat(sut.saveランク情報(ランク情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2011RankJohoEntity.class))).thenReturn(0);

            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJoho ランク情報 = new RankJoho(entity);

            assertThat(sut.saveランク情報(ランク情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2011RankJohoEntity.class))).thenReturn(1);

            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.initializeMd5();
            RankJoho ランク情報 = new RankJoho(entity);
            ランク情報 = ランク情報.createBuilderForEdit().setランク名称(new RString("任意項目1を変更")).build();

            assertThat(sut.saveランク情報(ランク情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2011RankJohoEntity.class))).thenReturn(0);

            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.initializeMd5();
            RankJoho ランク情報 = new RankJoho(entity);
            ランク情報 = ランク情報.createBuilderForEdit().setランク名称(new RString("任意項目1を変更")).build();

            assertThat(sut.saveランク情報(ランク情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2011RankJohoEntity.class))).thenReturn(1);

            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.initializeMd5();
            RankJoho ランク情報 = new RankJoho(entity);
            ランク情報 = ランク情報.deleted();

            assertThat(sut.saveランク情報(ランク情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2011RankJohoEntity.class))).thenReturn(0);

            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.initializeMd5();
            RankJoho ランク情報 = new RankJoho(entity);
            ランク情報 = ランク情報.deleted();

            assertThat(sut.saveランク情報(ランク情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2011RankJohoEntity entity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            entity.initializeMd5();
            RankJoho ランク情報 = new RankJoho(entity);

            assertThat(sut.saveランク情報(ランク情報), is(false));
        }
    }
}
