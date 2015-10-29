/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
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
 * {link KaigoJigyoshaManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJigyoshaManagerTest {

    private static DbT7060KaigoJigyoshaDac dac;
    private static KaigoJigyoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7060KaigoJigyoshaDac.class);
        sut = new KaigoJigyoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者 extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のKaigoJigyoshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            sut.get介護事業者(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleDateにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            sut.get介護事業者(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KaigoJigyoshaNo.class), any(FlexibleDate.class))).thenReturn(null);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha result = sut.get介護事業者(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            when(dac.selectByKey(any(KaigoJigyoshaNo.class), any(FlexibleDate.class))).thenReturn(entity);

            KaigoJigyoshaNo 主キー1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
            KaigoJigyosha result = sut.get介護事業者(主キー1, 主キー2);

            assertThat(result.get事業者番号().value(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoJigyosha> result = sut.get介護事業者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7060KaigoJigyoshaEntity> entityList = Arrays.asList(DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoJigyosha> result = sut.get介護事業者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者番号().value(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    public static class save介護事業者 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);

            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);

            assertThat(sut.save介護事業者(介護事業者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);

            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);

            assertThat(sut.save介護事業者(介護事業者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);

            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.initializeMd5();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);
            介護事業者 = 介護事業者.createBuilderForEdit().set備考(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者(介護事業者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);

            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.initializeMd5();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);
            介護事業者 = 介護事業者.createBuilderForEdit().set備考(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者(介護事業者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(1);

            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.initializeMd5();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save介護事業者(介護事業者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7060KaigoJigyoshaEntity.class))).thenReturn(0);

            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.initializeMd5();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);
            介護事業者 = 介護事業者.deleted();

            assertThat(sut.save介護事業者(介護事業者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.initializeMd5();
            KaigoJigyosha 介護事業者 = new KaigoJigyosha(entity);

            assertThat(sut.save介護事業者(介護事業者), is(false));
        }
    }
}
