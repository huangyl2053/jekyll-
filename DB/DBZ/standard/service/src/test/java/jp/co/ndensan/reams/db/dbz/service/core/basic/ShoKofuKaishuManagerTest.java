/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7037ShoKofuKaishuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link ShoKofuKaishuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoKofuKaishuManagerTest {

    private static DbT7037ShoKofuKaishuDac dac;
    private static ShoKofuKaishuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7037ShoKofuKaishuDac.class);
        sut = new ShoKofuKaishuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get証交付回収 extends DbzTestBase {

        HihokenshaNo 被保険者番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号;
        RString 交付証種類 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類;
        int 履歴番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_履歴番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get証交付回収(null, 交付証種類, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の交付証種類にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get証交付回収(被保険者番号, null, 履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(int.class))).thenReturn(null);

            HihokenshaNo 被保険者番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号;
            RString 交付証種類 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類;
            ShoKofuKaishu result = sut.get証交付回収(被保険者番号, 交付証種類, 履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(int.class))).thenReturn(entity);

            HihokenshaNo 被保険者番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号;
            RString 交付証種類 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類;
            ShoKofuKaishu result = sut.get証交付回収(被保険者番号, 交付証種類, 履歴番号);

            assertThat(result.get被保険者番号().value(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get証交付回収一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShoKofuKaishu> result = sut.get証交付回収一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7037ShoKofuKaishuEntity> entityList = Arrays.asList(DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShoKofuKaishu> result = sut.get証交付回収一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save証交付回収 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7037ShoKofuKaishuEntity.class))).thenReturn(1);

            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);

            assertThat(sut.save証交付回収(証交付回収), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7037ShoKofuKaishuEntity.class))).thenReturn(0);

            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);

            assertThat(sut.save証交付回収(証交付回収), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7037ShoKofuKaishuEntity.class))).thenReturn(1);

            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            entity.initializeMd5();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);
            証交付回収 = 証交付回収.createBuilderForEdit().set交付証種類(new RString("交付証種類を変更")).build();

            assertThat(sut.save証交付回収(証交付回収), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7037ShoKofuKaishuEntity.class))).thenReturn(0);

            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            entity.initializeMd5();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);
            証交付回収 = 証交付回収.createBuilderForEdit().set交付証種類(new RString("交付証種類を変更")).build();

            assertThat(sut.save証交付回収(証交付回収), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7037ShoKofuKaishuEntity.class))).thenReturn(1);

            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            entity.initializeMd5();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);
            証交付回収 = 証交付回収.deleted();

            assertThat(sut.save証交付回収(証交付回収), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7037ShoKofuKaishuEntity.class))).thenReturn(0);

            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            entity.initializeMd5();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);
            証交付回収 = 証交付回収.deleted();

            assertThat(sut.save証交付回収(証交付回収), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7037ShoKofuKaishuEntity entity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            entity.initializeMd5();
            ShoKofuKaishu 証交付回収 = new ShoKofuKaishu(entity);

            assertThat(sut.save証交付回収(証交付回収), is(false));
        }
    }
}
