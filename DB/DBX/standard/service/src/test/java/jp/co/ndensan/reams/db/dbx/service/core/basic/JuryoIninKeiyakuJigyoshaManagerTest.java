/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.JuryoIninKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7061JuryoIninJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link JuryoIninKeiyakuJigyoshaManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class JuryoIninKeiyakuJigyoshaManagerTest {

    private static DbT7061JuryoIninJigyoshaDac dac;
    private static JuryoIninKeiyakuJigyoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7061JuryoIninJigyoshaDac.class);
        sut = new JuryoIninKeiyakuJigyoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受領委任契約事業者 extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のJigyoshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
            sut.get受領委任契約事業者(null, 主キー2, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleDateにnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
            sut.get受領委任契約事業者(主キー1, null, RString.EMPTY);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(JigyoshaNo.class), any(FlexibleDate.class), any(RString.class))).thenReturn(null);

            JigyoshaNo 主キー1 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
            FlexibleDate 主キー2 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
            JuryoIninKeiyakuJigyosha result = sut.get受領委任契約事業者(主キー1, 主キー2, RString.EMPTY);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            when(dac.selectByKey(any(JigyoshaNo.class), any(FlexibleDate.class), any(RString.class))).thenReturn(entity);

            JigyoshaNo 主キー1 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
            FlexibleDate 主キー2 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
            JuryoIninKeiyakuJigyosha result = sut.get受領委任契約事業者(主キー1, 主キー2, RString.EMPTY);

            assertThat(result.get受領委任契約事業者番号().value(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get受領委任契約事業者一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JuryoIninKeiyakuJigyosha> result = sut.get受領委任契約事業者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7061JuryoIninJigyoshaEntity> entityList = Arrays.asList(DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JuryoIninKeiyakuJigyosha> result = sut.get受領委任契約事業者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get受領委任契約事業者番号().value(), is(DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号.value()));
        }
    }

    public static class save受領委任契約事業者 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7061JuryoIninJigyoshaEntity.class))).thenReturn(1);

            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7061JuryoIninJigyoshaEntity.class))).thenReturn(0);

            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7061JuryoIninJigyoshaEntity.class))).thenReturn(1);

            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            entity.initializeMd5();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);
            受領委任契約事業者 = 受領委任契約事業者.createBuilderForEdit().set契約サービス種別(new RString("1")).build();

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7061JuryoIninJigyoshaEntity.class))).thenReturn(0);

            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            entity.initializeMd5();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);
            受領委任契約事業者 = 受領委任契約事業者.createBuilderForEdit().set契約サービス種別(new RString("1")).build();

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7061JuryoIninJigyoshaEntity.class))).thenReturn(1);

            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            entity.initializeMd5();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);
            受領委任契約事業者 = 受領委任契約事業者.deleted();

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7061JuryoIninJigyoshaEntity.class))).thenReturn(0);

            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            entity.initializeMd5();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);
            受領委任契約事業者 = 受領委任契約事業者.deleted();

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7061JuryoIninJigyoshaEntity entity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            entity.initializeMd5();
            JuryoIninKeiyakuJigyosha 受領委任契約事業者 = new JuryoIninKeiyakuJigyosha(entity);

            assertThat(sut.save受領委任契約事業者(受領委任契約事業者), is(false));
        }
    }
}
