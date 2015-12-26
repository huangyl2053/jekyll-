/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshashiteiservice;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link KaigoJigyoshaShiteiServiceManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceManagerTest extends DbxTestDacBase {

    private static DbT7063KaigoJigyoshaShiteiServiceDac dac;
    private static KaigoJigyoshaShiteiServiceManager sut;
    public static final KaigoJigyoshaNo DEFAULT_事業者番号 = new KaigoJigyoshaNo("0123400001");
    public static final KaigoServiceShuruiCode DEFAULT_サービス種類コード = new KaigoServiceShuruiCode("01");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("20141216");

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        sut = new KaigoJigyoshaShiteiServiceManager(dac);
    }

    public static class save介護事業者指定サービス extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.clearTable();
        }

        @Test
        public void insertに成功するとtrueが返る() {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);

            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(true));
        }

//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);
//
//            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
//            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
//
//            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
//        }
        @Test
        public void updateに成功するとtrueが返る() {

            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            sut.save介護事業者指定サービス(介護事業者指定サービス);
            DbT7063KaigoJigyoshaShiteiServiceEntity entity7063
                    = dac.selectByKey(DEFAULT_事業者番号, DEFAULT_サービス種類コード, DEFAULT_有効開始日);

            entity.initializeMd5();
            KaigoJigyoshaShiteiService kaigoJigyoshaShiteiService = new KaigoJigyoshaShiteiService(entity7063);
            kaigoJigyoshaShiteiService = kaigoJigyoshaShiteiService.createBuilderForEdit().set事業者住所カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者指定サービス(kaigoJigyoshaShiteiService), is(true));
        }

//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);
//
//            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
//            entity.initializeMd5();
//            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
//            介護事業者指定サービス = 介護事業者指定サービス.createBuilderForEdit().set事業者住所カナ(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
//        }
        @Test
        public void deleteに成功するとtrueが返る() {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
            sut.save介護事業者指定サービス(介護事業者指定サービス);
            DbT7063KaigoJigyoshaShiteiServiceEntity entity7063
                    = dac.selectByKey(DEFAULT_事業者番号, DEFAULT_サービス種類コード, DEFAULT_有効開始日);
            entity7063.setState(EntityDataState.Deleted);
            KaigoJigyoshaShiteiService kaigoJigyoshaShiteiService = new KaigoJigyoshaShiteiService(entity7063);
            kaigoJigyoshaShiteiService = kaigoJigyoshaShiteiService.deleted();

            assertThat(sut.save介護事業者指定サービス(kaigoJigyoshaShiteiService), is(true));
        }

//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7063KaigoJigyoshaShiteiServiceEntity.class))).thenReturn(0);
//
//            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
//            entity.initializeMd5();
//            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
//            介護事業者指定サービス = 介護事業者指定サービス.deleted();
//
//            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
//        }
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
//            entity.initializeMd5();
//            KaigoJigyoshaShiteiService 介護事業者指定サービス = new KaigoJigyoshaShiteiService(entity);
//
//            assertThat(sut.save介護事業者指定サービス(介護事業者指定サービス), is(false));
//        }
        @After
        public void after() {
            rollback();
        }
    }

    private static class TestSupport {

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7063KaigoJigyoshaShiteiServiceEntity.TABLE_NAME.toString());
        }
    }
}
