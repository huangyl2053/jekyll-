/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link KibetsuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KibetsuManagerTest {

    private static DbT2003KibetsuDac dac;
    private static KibetsuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2003KibetsuDac.class);
        sut = new KibetsuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護期別 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
            int 主キー4 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
            RString 主キー5 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
            sut.get介護期別(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
            TsuchishoNo 主キー3 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
            int 主キー4 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
            RString 主キー5 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
            sut.get介護期別(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
            int 主キー4 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
            RString 主キー5 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
            sut.get介護期別(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
//            FlexibleYear 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
//            FlexibleYear 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
//            TsuchishoNo 主キー3 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
//            RString 主キー5 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
//            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
//            sut.get介護期別(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6);
//        }
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
            int 主キー4 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
            sut.get介護期別(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class),
                    any(int.class), any(RString.class), any(int.class))).thenReturn(null);

            FlexibleYear 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
            int 主キー4 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
            RString 主キー5 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
            Kibetsu result = sut.get介護期別(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            when(dac.selectByKey(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class),
                    any(int.class), any(RString.class), any(int.class))).thenReturn(entity);

            FlexibleYear 主キー1 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
            FlexibleYear 主キー2 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
            TsuchishoNo 主キー3 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
            int 主キー4 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
            RString 主キー5 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
            int 主キー6 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
            Kibetsu result = sut.get介護期別(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6);

            assertThat(result.get調定年度().toDateString(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定年度.toDateString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護期別一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<Kibetsu> result = sut.get介護期別一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2003KibetsuEntity> entityList = Arrays.asList(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<Kibetsu> result = sut.get介護期別一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調定年度().toDateString(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定年度.toDateString()));
        }
    }

    public static class save介護期別 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.createBuilderForEdit().set調定ID(new Decimal(123)).build();

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.createBuilderForEdit().set調定ID(new Decimal(123)).build();

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.deleted();

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.deleted();

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(false));
        }
    }
}
