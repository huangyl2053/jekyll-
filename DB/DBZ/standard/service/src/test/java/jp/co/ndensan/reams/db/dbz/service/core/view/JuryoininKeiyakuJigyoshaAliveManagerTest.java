/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.view.JuryoininKeiyakuJigyoshaAlive;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV3077JuryoininKeiyakuJigyoshaAliveDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link JuryoininKeiyakuJigyoshaAliveManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JuryoininKeiyakuJigyoshaAliveManagerTest {

    private static DbV3077JuryoininKeiyakuJigyoshaAliveDac dac;
    private static JuryoininKeiyakuJigyoshaAliveManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbV3077JuryoininKeiyakuJigyoshaAliveDac.class);
        sut = new JuryoininKeiyakuJigyoshaAliveManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受領委任事業者Alive extends DbzTestBase {

        RString 事業者契約番号 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号;
        FlexibleDate 開始年月日 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
        int 履歴番号 = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受領委任事業者Alive(null, 開始年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleDateにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get受領委任事業者Alive(事業者契約番号, null, 履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(FlexibleDate.class), any(int.class))).thenReturn(null);

            JuryoininKeiyakuJigyoshaAlive result = sut.get受領委任事業者Alive(事業者契約番号, 開始年月日, 履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            when(dac.selectByKey(any(RString.class), any(FlexibleDate.class), any(int.class))).thenReturn(entity);

            JuryoininKeiyakuJigyoshaAlive result = sut.get受領委任事業者Alive(事業者契約番号, 開始年月日, 履歴番号);

            assertThat(result.get事業者契約番号().toString(), is(DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号.toString()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受領委任事業者Alive一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JuryoininKeiyakuJigyoshaAlive> result = sut.get受領委任事業者Alive一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbV3077JuryoininKeiyakuJigyoshaEntity> entityList = Arrays.asList(DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JuryoininKeiyakuJigyoshaAlive> result = sut.get受領委任事業者Alive一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者契約番号().toString(), is(DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号.toString()));
        }
    }

    public static class save受領委任事業者Alive extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbV3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);

            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbV3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);

            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbV3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);

            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);
            受領委任事業者Alive = 受領委任事業者Alive.createBuilderForEdit().set事業者契約番号(new RString("事業者契約番号を変更")).build();

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbV3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);

            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);
            受領委任事業者Alive = 受領委任事業者Alive.createBuilderForEdit().set事業者契約番号(new RString("事業者契約番号を変更")).build();

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbV3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);

            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);
            受領委任事業者Alive = 受領委任事業者Alive.deleted();

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbV3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);

            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);
            受領委任事業者Alive = 受領委任事業者Alive.deleted();

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive = new JuryoininKeiyakuJigyoshaAlive(entity);

            assertThat(sut.save受領委任事業者Alive(受領委任事業者Alive), is(false));
        }
    }
}
