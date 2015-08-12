/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link KyodoShoriyoJukyushaIdoShokanSofuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoShokanSofuManagerTest {

    private static DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac dac;
    private static KyodoShoriyoJukyushaIdoShokanSofuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3003KyodoShoriyoJukyushaIdoShokanSofuDac.class);
        sut = new KyodoShoriyoJukyushaIdoShokanSofuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get共同処理用受給者異動償還送付 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー2;
            sut.get共同処理用受給者異動償還送付(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー1;
            sut.get共同処理用受給者異動償還送付(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー2;
            KyodoShoriyoJukyushaIdoShokanSofu result = sut.get共同処理用受給者異動償還送付(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー2;
            KyodoShoriyoJukyushaIdoShokanSofu result = sut.get共同処理用受給者異動償還送付(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get共同処理用受給者異動償還送付一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyodoShoriyoJukyushaIdoShokanSofu> result = sut.get共同処理用受給者異動償還送付一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> entityList = Arrays.asList(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyodoShoriyoJukyushaIdoShokanSofu> result = sut.get共同処理用受給者異動償還送付一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save共同処理用受給者異動償還送付 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class))).thenReturn(1);

            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class))).thenReturn(0);

            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class))).thenReturn(1);

            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            entity.initializeMd5();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);
            共同処理用受給者異動償還送付 = 共同処理用受給者異動償還送付.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class))).thenReturn(0);

            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            entity.initializeMd5();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);
            共同処理用受給者異動償還送付 = 共同処理用受給者異動償還送付.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class))).thenReturn(1);

            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            entity.initializeMd5();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);
            共同処理用受給者異動償還送付 = 共同処理用受給者異動償還送付.deleted();

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity.class))).thenReturn(0);

            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            entity.initializeMd5();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);
            共同処理用受給者異動償還送付 = 共同処理用受給者異動償還送付.deleted();

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator.createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
            entity.initializeMd5();
            KyodoShoriyoJukyushaIdoShokanSofu 共同処理用受給者異動償還送付 = new KyodoShoriyoJukyushaIdoShokanSofu(entity);

            assertThat(sut.save共同処理用受給者異動償還送付(共同処理用受給者異動償還送付), is(false));
        }
    }
}
