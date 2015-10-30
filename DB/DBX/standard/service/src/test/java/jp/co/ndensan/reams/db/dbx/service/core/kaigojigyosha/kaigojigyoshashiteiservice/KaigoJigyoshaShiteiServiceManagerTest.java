/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshashiteiservice;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
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
 * {link KaigoJigyoshaShiteiServiceManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceManagerTest {

    private static DbT7063KaigoJigyoshaShiteiServiceDac dac;
    private static KaigoJigyoshaShiteiServiceManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        sut = new KaigoJigyoshaShiteiServiceManager(dac);
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
            介護事業者指定サービス = 介護事業者指定サービス.createBuilderForEdit().set事業者住所カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.initializeMd5();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            介護事業者指定サービス = 介護事業者指定サービス.createBuilderForEdit().set事業者住所カナ(new RString("任意項目1を変更")).build();

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
