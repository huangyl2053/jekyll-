/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5223ChikuNinteiChosainDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ChikuNinteiChosainManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuNinteiChosainManagerTest {

    private static DbT5223ChikuNinteiChosainDac dac;
    private static ChikuNinteiChosainManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5223ChikuNinteiChosainDac.class);
        sut = new ChikuNinteiChosainManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get地区認定調査員 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
            RString 主キー3 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
            LasdecCode 主キー4 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
            sut.get地区認定調査員(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
            RString 主キー3 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
            LasdecCode 主キー4 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
            sut.get地区認定調査員(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
            RString 主キー2 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
            LasdecCode 主キー4 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
            sut.get地区認定調査員(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
            RString 主キー2 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
            RString 主キー3 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
            sut.get地区認定調査員(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(Code.class), any(RString.class), any(RString.class), any(LasdecCode.class))).thenReturn(null);
            Code 主キー1 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
            RString 主キー2 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
            RString 主キー3 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
            LasdecCode 主キー4 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
            ChikuNinteiChosain result = sut.get地区認定調査員(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            when(dac.selectByKey(any(Code.class), any(RString.class), any(RString.class), any(LasdecCode.class))).thenReturn(entity);
            Code 主キー1 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
            RString 主キー2 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
            RString 主キー3 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
            LasdecCode 主キー4 = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
            ChikuNinteiChosain result = sut.get地区認定調査員(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get調査地区コード().value(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get地区認定調査員一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChikuNinteiChosain> result = sut.get地区認定調査員一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5223ChikuNinteiChosainEntity> entityList = Arrays.asList(DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChikuNinteiChosain> result = sut.get地区認定調査員一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調査地区コード().value(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード.value()));
        }
    }

    public static class save地区認定調査員 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5223ChikuNinteiChosainEntity.class))).thenReturn(1);

            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);

            assertThat(sut.save地区認定調査員(地区認定調査員), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5223ChikuNinteiChosainEntity.class))).thenReturn(0);

            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);

            assertThat(sut.save地区認定調査員(地区認定調査員), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5223ChikuNinteiChosainEntity.class))).thenReturn(1);

            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            entity.initializeMd5();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);
            地区認定調査員 = 地区認定調査員.createBuilderForEdit().set備考(new RString("任意項目1を変更")).build();

            assertThat(sut.save地区認定調査員(地区認定調査員), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5223ChikuNinteiChosainEntity.class))).thenReturn(0);

            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            entity.initializeMd5();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);
            地区認定調査員 = 地区認定調査員.createBuilderForEdit().set備考(new RString("任意項目1を変更")).build();

            assertThat(sut.save地区認定調査員(地区認定調査員), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5223ChikuNinteiChosainEntity.class))).thenReturn(1);

            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            entity.initializeMd5();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);
            地区認定調査員 = 地区認定調査員.deleted();

            assertThat(sut.save地区認定調査員(地区認定調査員), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5223ChikuNinteiChosainEntity.class))).thenReturn(0);

            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            entity.initializeMd5();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);
            地区認定調査員 = 地区認定調査員.deleted();

            assertThat(sut.save地区認定調査員(地区認定調査員), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            entity.initializeMd5();
            ChikuNinteiChosain 地区認定調査員 = new ChikuNinteiChosain(entity);

            assertThat(sut.save地区認定調査員(地区認定調査員), is(false));
        }
    }
}
