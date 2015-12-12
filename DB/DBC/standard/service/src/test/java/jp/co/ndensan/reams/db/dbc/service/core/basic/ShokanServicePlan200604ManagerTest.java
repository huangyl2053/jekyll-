/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3046ShokanServicePlan200604EntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShokanServicePlan200604Manager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanServicePlan200604ManagerTest {

    private static DbT3046ShokanServicePlan200604Dac dac;
    private static ShokanServicePlan200604Manager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3046ShokanServicePlan200604Dac.class);
        sut = new ShokanServicePlan200604Manager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求サービス計画200604 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey()).thenReturn(null);
            ShokanServicePlan200604 result = sut.get償還払請求サービス計画200604();

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            when(dac.selectByKey()).thenReturn(entity);
            ShokanServicePlan200604 result = sut.get償還払請求サービス計画200604();

            assertThat(result.get被保険者番号().value(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還払請求サービス計画200604一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanServicePlan200604> result = sut.get償還払請求サービス計画200604一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3046ShokanServicePlan200604Entity> entityList = Arrays.asList(DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanServicePlan200604> result = sut.get償還払請求サービス計画200604一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3046ShokanServicePlan200604EntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還払請求サービス計画200604 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3046ShokanServicePlan200604Entity.class))).thenReturn(1);

            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3046ShokanServicePlan200604Entity.class))).thenReturn(0);

            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3046ShokanServicePlan200604Entity.class))).thenReturn(1);

            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            entity.initializeMd5();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);
            償還払請求サービス計画200604 = 償還払請求サービス計画200604.createBuilderForEdit().set不支給理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3046ShokanServicePlan200604Entity.class))).thenReturn(0);

            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            entity.initializeMd5();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);
            償還払請求サービス計画200604 = 償還払請求サービス計画200604.createBuilderForEdit().set不支給理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3046ShokanServicePlan200604Entity.class))).thenReturn(1);

            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            entity.initializeMd5();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);
            償還払請求サービス計画200604 = 償還払請求サービス計画200604.deleted();

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3046ShokanServicePlan200604Entity.class))).thenReturn(0);

            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            entity.initializeMd5();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);
            償還払請求サービス計画200604 = 償還払請求サービス計画200604.deleted();

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3046ShokanServicePlan200604Entity entity = DbT3046ShokanServicePlan200604EntityGenerator.createDbT3046ShokanServicePlan200604Entity();
            entity.initializeMd5();
            ShokanServicePlan200604 償還払請求サービス計画200604 = new ShokanServicePlan200604(entity);

            assertThat(sut.save償還払請求サービス計画200604(償還払請求サービス計画200604), is(false));
        }
    }
}
