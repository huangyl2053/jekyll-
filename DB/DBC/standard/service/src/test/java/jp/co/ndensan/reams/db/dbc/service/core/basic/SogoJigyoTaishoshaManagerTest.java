/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3105SogoJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {link SogoJigyoTaishoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SogoJigyoTaishoshaManagerTest {

    private static DbT3105SogoJigyoTaishoshaDac dac;
    private static SogoJigyoTaishoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3105SogoJigyoTaishoshaDac.class);
        sut = new SogoJigyoTaishoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get総合事業対象者 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {

            int 主キー3 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get総合事業対象者(null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class))).thenReturn(null);

            HihokenshaNo 主キー2 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            SogoJigyoTaishosha result = sut.get総合事業対象者(主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class))).thenReturn(entity);

            HihokenshaNo 主キー2 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            SogoJigyoTaishosha result = sut.get総合事業対象者(主キー2, 主キー3);

            assertThat(result.get受付年月日(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_受付年月日));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get総合事業対象者一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<SogoJigyoTaishosha> result = sut.get総合事業対象者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3105SogoJigyoTaishoshaEntity> entityList = Arrays.asList(DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<SogoJigyoTaishosha> result = sut.get総合事業対象者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get受付年月日(), is(DbT3105SogoJigyoTaishoshaEntityGenerator.DEFAULT_受付年月日));
        }
    }

    public static class save総合事業対象者 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3105SogoJigyoTaishoshaEntity.class))).thenReturn(1);

            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);

            assertThat(sut.save総合事業対象者(総合事業対象者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3105SogoJigyoTaishoshaEntity.class))).thenReturn(0);

            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);

            assertThat(sut.save総合事業対象者(総合事業対象者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3105SogoJigyoTaishoshaEntity.class))).thenReturn(1);

            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            entity.initializeMd5();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);
            総合事業対象者 = 総合事業対象者.createBuilderForEdit().set履歴番号(1).build();

            assertThat(sut.save総合事業対象者(総合事業対象者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3105SogoJigyoTaishoshaEntity.class))).thenReturn(0);

            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            entity.initializeMd5();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);
            総合事業対象者 = 総合事業対象者.createBuilderForEdit().set履歴番号(0).build();

            assertThat(sut.save総合事業対象者(総合事業対象者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3105SogoJigyoTaishoshaEntity.class))).thenReturn(1);

            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            entity.initializeMd5();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);
            総合事業対象者 = 総合事業対象者.deleted();

            assertThat(sut.save総合事業対象者(総合事業対象者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3105SogoJigyoTaishoshaEntity.class))).thenReturn(0);

            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            entity.initializeMd5();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);
            総合事業対象者 = 総合事業対象者.deleted();

            assertThat(sut.save総合事業対象者(総合事業対象者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3105SogoJigyoTaishoshaEntity entity = DbT3105SogoJigyoTaishoshaEntityGenerator.createDbT3105SogoJigyoTaishoshaEntity();
            entity.initializeMd5();
            SogoJigyoTaishosha 総合事業対象者 = new SogoJigyoTaishosha(entity);

            assertThat(sut.save総合事業対象者(総合事業対象者), is(false));
        }
    }
}
