/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3068KogakuGassanShinseishoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3068KogakuGassanShinseishoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link KogakuGassanShinseishoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShinseishoManagerTest {

    private static DbT3068KogakuGassanShinseishoDac dac;
    private static KogakuGassanShinseishoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3068KogakuGassanShinseishoDac.class);
        sut = new KogakuGassanShinseishoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算申請書 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYear 主キー2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算申請書(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
            HokenshaNo 主キー3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算申請書(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
            RString 主キー4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算申請書(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
            Decimal 主キー5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
            sut.get高額合算申請書(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
            sut.get高額合算申請書(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShinseisho result = sut.get高額合算申請書(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleYear.class), any(HokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYear 主キー2 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_対象年度;
            HokenshaNo 主キー3 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_保険者番号;
            RString 主キー4 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_整理番号;
            Decimal 主キー5 = DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_履歴番号;
            KogakuGassanShinseisho result = sut.get高額合算申請書(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get主キー1().value(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額合算申請書一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuGassanShinseisho> result = sut.get高額合算申請書一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3068KogakuGassanShinseishoEntity> entityList = Arrays.asList(DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuGassanShinseisho> result = sut.get高額合算申請書一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3068KogakuGassanShinseishoEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額合算申請書 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3068KogakuGassanShinseishoEntity.class))).thenReturn(1);

            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);

            assertThat(sut.save高額合算申請書(高額合算申請書), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3068KogakuGassanShinseishoEntity.class))).thenReturn(0);

            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);

            assertThat(sut.save高額合算申請書(高額合算申請書), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3068KogakuGassanShinseishoEntity.class))).thenReturn(1);

            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            entity.initializeMd5();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);
            高額合算申請書 = 高額合算申請書.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算申請書(高額合算申請書), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3068KogakuGassanShinseishoEntity.class))).thenReturn(0);

            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            entity.initializeMd5();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);
            高額合算申請書 = 高額合算申請書.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額合算申請書(高額合算申請書), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3068KogakuGassanShinseishoEntity.class))).thenReturn(1);

            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            entity.initializeMd5();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);
            高額合算申請書 = 高額合算申請書.deleted();

            assertThat(sut.save高額合算申請書(高額合算申請書), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3068KogakuGassanShinseishoEntity.class))).thenReturn(0);

            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            entity.initializeMd5();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);
            高額合算申請書 = 高額合算申請書.deleted();

            assertThat(sut.save高額合算申請書(高額合算申請書), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3068KogakuGassanShinseishoEntity entity = DbT3068KogakuGassanShinseishoEntityGenerator.createDbT3068KogakuGassanShinseishoEntity();
            entity.initializeMd5();
            KogakuGassanShinseisho 高額合算申請書 = new KogakuGassanShinseisho(entity);

            assertThat(sut.save高額合算申請書(高額合算申請書), is(false));
        }
    }
}
