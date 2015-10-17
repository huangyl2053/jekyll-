/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link KaigoJigyoshaShiteiServiceManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceManagerTest {

    private static DbT7063KaigoJigyoshaShiteiServiceDac dac;
    private static KaigoJigyoshaShiteiServiceManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        sut = new KaigoJigyoshaShiteiServiceManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者指定サービス extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のKaigoJigyoshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoServiceShuruiCode 主キー2 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
            sut.get介護事業者指定サービス(null, 主キー2, FlexibleDate.MAX);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のKaigoServiceShuruiCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoJigyoshaNo 主キー1 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
            sut.get介護事業者指定サービス(主キー1, null, FlexibleDate.MAX);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KaigoJigyoshaNo.class), any(KaigoServiceShuruiCode.class), any(FlexibleDate.class))).thenReturn(null);

            KaigoJigyoshaNo 主キー1 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
            KaigoServiceShuruiCode 主キー2 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
            KaigoJigyoshaShiteiService result = sut.get介護事業者指定サービス(主キー1, 主キー2, FlexibleDate.MAX);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            when(dac.selectByKey(any(KaigoJigyoshaNo.class), any(KaigoServiceShuruiCode.class), any(FlexibleDate.class))).thenReturn(entity);

            KaigoJigyoshaNo 主キー1 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
            KaigoServiceShuruiCode 主キー2 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
            KaigoJigyoshaShiteiService result = sut.get介護事業者指定サービス(主キー1, 主キー2, FlexibleDate.MAX);

            assertThat(result.getサービス種類コード().value(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護事業者指定サービス一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoJigyoshaShiteiService> result = sut.get介護事業者指定サービス一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> entityList = Arrays.asList(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoJigyoshaShiteiService> result = sut.get介護事業者指定サービス一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者番号().value(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号.value()));
        }
    }

    public static class save介護事業者指定サービス extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(1);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(1);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.initializeMd5();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            介護事業者指定サービス = 介護事業者指定サービス.createBuilderForEdit().set事業者名称(new AtenaMeisho("meisho")).build();

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.initializeMd5();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            介護事業者指定サービス = 介護事業者指定サービス.createBuilderForEdit().set事業者名称(new AtenaMeisho("atenameisho")).build();

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(1);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.initializeMd5();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            介護事業者指定サービス = 介護事業者指定サービス.deleted();

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.initializeMd5();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            介護事業者指定サービス = 介護事業者指定サービス.deleted();

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.initializeMd5();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
        }
    }
}
