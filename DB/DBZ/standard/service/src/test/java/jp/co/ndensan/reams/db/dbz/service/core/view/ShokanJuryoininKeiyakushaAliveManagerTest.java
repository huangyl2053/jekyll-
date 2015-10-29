/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.ShokanJuryoininKeiyakushaAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3078ShokanJuryoininKeiyakushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV3078ShokanJuryoininKeiyakushaAliveDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link ShokanJuryoininKeiyakushaAliveManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShokanJuryoininKeiyakushaAliveManagerTest {

    private static DbV3078ShokanJuryoininKeiyakushaAliveDac dac;
    private static ShokanJuryoininKeiyakushaAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV3078ShokanJuryoininKeiyakushaAliveDac.class);
        sut = new ShokanJuryoininKeiyakushaAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get還受領委任契約者Alive extends DbzTestBase {

        HihokenshaNo 被保険者番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
        ShoKisaiHokenshaNo 証記載保険者番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
        FlexibleDate 受付年月日 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
        int 履歴番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get還受領委任契約者Alive(null, 証記載保険者番号, 受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get還受領委任契約者Alive(被保険者番号, null, 受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get還受領委任契約者Alive(被保険者番号, 証記載保険者番号, null, 履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(ShoKisaiHokenshaNo.class), any(FlexibleDate.class), any(int.class))).thenReturn(null);

            ShokanJuryoininKeiyakushaAlive result = sut.get還受領委任契約者Alive(被保険者番号, 証記載保険者番号, 受付年月日, 履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(ShoKisaiHokenshaNo.class), any(FlexibleDate.class), any(int.class))).thenReturn(entity);

            ShokanJuryoininKeiyakushaAlive result = sut.get還受領委任契約者Alive(被保険者番号, 証記載保険者番号, 受付年月日, 履歴番号);

            assertThat(result.get被保険者番号().value(), is(DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get還受領委任契約者Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanJuryoininKeiyakushaAlive> result = sut.get還受領委任契約者Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV3078ShokanJuryoininKeiyakushaEntity> entityList = Arrays.asList(DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanJuryoininKeiyakushaAlive> result = sut.get還受領委任契約者Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save還受領委任契約者Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(1);

            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(0);

            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(1);

            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);
            還受領委任契約者Alive = 還受領委任契約者Alive.createBuilderForEdit().set被保険者番号(new HihokenshaNo("000001")).build();

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(0);

            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);
            還受領委任契約者Alive = 還受領委任契約者Alive.createBuilderForEdit().set被保険者番号(new HihokenshaNo("000001")).build();

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(1);

            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);
            還受領委任契約者Alive = 還受領委任契約者Alive.deleted();

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(0);

            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);
            還受領委任契約者Alive = 還受領委任契約者Alive.deleted();

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV3078ShokanJuryoininKeiyakushaEntity entity = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.createDbV3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive = new ShokanJuryoininKeiyakushaAlive(entity);

            assertThat(sut.save還受領委任契約者Alive(還受領委任契約者Alive), is(false));
        }
    }
}
