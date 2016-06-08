/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3100NijiYoboJigyoTaishoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3100NijiYoboJigyoTaishoshaDac;
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
 * {link NijiYoboJigyoTaishoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NijiYoboJigyoTaishoshaManagerTest {

    private static DbT3100NijiYoboJigyoTaishoshaDac dac;
    private static NijiYoboJigyoTaishoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3100NijiYoboJigyoTaishoshaDac.class);
        sut = new NijiYoboJigyoTaishoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防事業対象者 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防事業対象者(主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー3 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防事業対象者(null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class))).thenReturn(null);
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            NijiYoboJigyoTaishosha result = sut.get二次予防事業対象者(主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class))).thenReturn(entity);
            HihokenshaNo 主キー2 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_履歴番号;
            NijiYoboJigyoTaishosha result = sut.get二次予防事業対象者(主キー2, 主キー3);

            assertThat(result.get受付年月日(), is(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_受付年月日));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防事業対象者一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NijiYoboJigyoTaishosha> result = sut.get二次予防事業対象者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3100NijiYoboJigyoTaishoshaEntity> entityList = Arrays.asList(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NijiYoboJigyoTaishosha> result = sut.get二次予防事業対象者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get受付年月日(), is(DbT3100NijiYoboJigyoTaishoshaEntityGenerator.DEFAULT_受付年月日));
        }
    }

    public static class save二次予防事業対象者 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);

            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(0);

            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);

            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            entity.initializeMd5();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);
            二次予防事業対象者 = 二次予防事業対象者.createBuilderForEdit().set履歴番号(1).build();

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(0);

            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            entity.initializeMd5();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);
            二次予防事業対象者 = 二次予防事業対象者.createBuilderForEdit().set履歴番号(0).build();

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(1);

            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            entity.initializeMd5();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);
            二次予防事業対象者 = 二次予防事業対象者.deleted();

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3100NijiYoboJigyoTaishoshaEntity.class))).thenReturn(0);

            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            entity.initializeMd5();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);
            二次予防事業対象者 = 二次予防事業対象者.deleted();

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3100NijiYoboJigyoTaishoshaEntity entity = DbT3100NijiYoboJigyoTaishoshaEntityGenerator.createDbT3100NijiYoboJigyoTaishoshaEntity();
            entity.initializeMd5();
            NijiYoboJigyoTaishosha 二次予防事業対象者 = new NijiYoboJigyoTaishosha(entity);

            assertThat(sut.save二次予防事業対象者(二次予防事業対象者), is(false));
        }
    }
}
