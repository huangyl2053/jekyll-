/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KanrenHihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7054KanrenHihokenshaNoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {link KanrenHihokenshaNoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KanrenHihokenshaNoManagerTest {

    private static DbT7054KanrenHihokenshaNoDac dac;
    private static KanrenHihokenshaNoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7054KanrenHihokenshaNoDac.class);
        sut = new KanrenHihokenshaNoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get関連被保険者番号 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号;
            sut.get関連被保険者番号(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShoKisaiHokenshaNo 主キー1 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号;
            sut.get関連被保険者番号(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(HihokenshaNo.class))).thenReturn(null);
            ShoKisaiHokenshaNo 主キー1 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号;
            KanrenHihokenshaNo result = sut.get関連被保険者番号(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(HihokenshaNo.class))).thenReturn(entity);
            ShoKisaiHokenshaNo 主キー1 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー2 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号;
            KanrenHihokenshaNo result = sut.get関連被保険者番号(主キー1, 主キー2);

            assertThat(result.get証記載保険者番号().value(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get関連被保険者番号一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KanrenHihokenshaNo> result = sut.get関連被保険者番号一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7054KanrenHihokenshaNoEntity> entityList = Arrays.asList(DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KanrenHihokenshaNo> result = sut.get関連被保険者番号一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class save関連被保険者番号 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7054KanrenHihokenshaNoEntity.class))).thenReturn(1);

            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7054KanrenHihokenshaNoEntity.class))).thenReturn(0);

            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7054KanrenHihokenshaNoEntity.class))).thenReturn(1);

            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            entity.initializeMd5();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);
            関連被保険者番号 = 関連被保険者番号.createBuilderForEdit().set識別コード(new ShikibetsuCode("1235678")).build();

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7054KanrenHihokenshaNoEntity.class))).thenReturn(0);

            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            entity.initializeMd5();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);
            関連被保険者番号 = 関連被保険者番号.createBuilderForEdit().set識別コード(new ShikibetsuCode("1235678")).build();

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7054KanrenHihokenshaNoEntity.class))).thenReturn(1);

            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            entity.initializeMd5();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);
            関連被保険者番号 = 関連被保険者番号.deleted();

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7054KanrenHihokenshaNoEntity.class))).thenReturn(0);

            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            entity.initializeMd5();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);
            関連被保険者番号 = 関連被保険者番号.deleted();

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            entity.initializeMd5();
            KanrenHihokenshaNo 関連被保険者番号 = new KanrenHihokenshaNo(entity);

            assertThat(sut.save関連被保険者番号(関連被保険者番号), is(false));
        }
    }
}
