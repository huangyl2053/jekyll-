/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link KogakuJuryoininKeiyakuJigyoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuJuryoininKeiyakuJigyoshaManagerTest {

    private static DbT3076KogakuJuryoininKeiyakuJigyoshaDac dac;
    private static KogakuJuryoininKeiyakuJigyoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3076KogakuJuryoininKeiyakuJigyoshaDac.class);
        sut = new KogakuJuryoininKeiyakuJigyoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額受領委任契約事業者 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主キー3 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get高額受領委任契約事業者(null, 主キー3);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            KogakuJuryoininKeiyakuJigyosha result = sut.get高額受領委任契約事業者(主キー1, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(int.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号;
            int 主キー3 = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
            KogakuJuryoininKeiyakuJigyosha result = sut.get高額受領委任契約事業者(主キー1, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get高額受領委任契約事業者一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KogakuJuryoininKeiyakuJigyosha> result = sut.get高額受領委任契約事業者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3076KogakuJuryoininKeiyakuJigyoshaEntity> entityList = Arrays.asList(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KogakuJuryoininKeiyakuJigyosha> result = sut.get高額受領委任契約事業者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save高額受領委任契約事業者 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);
            高額受領委任契約事業者 = 高額受領委任契約事業者.createBuilderForEdit().set不承認理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);
            高額受領委任契約事業者 = 高額受領委任契約事業者.createBuilderForEdit().set不承認理由(new RString("任意項目1を変更")).build();

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class))).thenReturn(1);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);
            高額受領委任契約事業者 = 高額受領委任契約事業者.deleted();

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class))).thenReturn(0);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);
            高額受領委任契約事業者 = 高額受領委任契約事業者.deleted();

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            entity.initializeMd5();
            KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者 = new KogakuJuryoininKeiyakuJigyosha(entity);

            assertThat(sut.save高額受領委任契約事業者(高額受領委任契約事業者), is(false));
        }
    }
}
