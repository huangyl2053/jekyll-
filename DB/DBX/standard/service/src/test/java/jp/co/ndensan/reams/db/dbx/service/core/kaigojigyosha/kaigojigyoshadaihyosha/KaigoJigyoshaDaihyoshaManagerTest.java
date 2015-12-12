/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshadaihyosha;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
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
 * {link KaigoJigyoshaDaihyoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaDaihyoshaManagerTest extends DbxTestDacBase {

    private static DbT7062KaigoJigyoshaDaihyoshaDac dac;
    private static KaigoJigyoshaDaihyoshaManager sut;
    public static final KaigoJigyoshaNo DEFAULT_事業者番号 = new KaigoJigyoshaNo("0123400001");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("19900101");

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        sut = new KaigoJigyoshaDaihyoshaManager(dac);
    }

    public static class save介護事業者代表者 extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.clearTable();
        }

        @Test
        public void insertに成功するとtrueが返る() {

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(true));
        }

//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(0);
//
//            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
//            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
//
//            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
//        }
        @Test
        public void updateに成功するとtrueが返る() {

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
            sut.save介護事業者代表者(介護事業者代表者);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity7062 = dac.selectByKey(DEFAULT_事業者番号, DEFAULT_有効開始日);
            KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = new KaigoJigyoshaDaihyosha(entity7062);

            kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyosha.createBuilderForEdit().set代表者住所カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者代表者(kaigoJigyoshaDaihyosha), is(true));
        }

//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(0);
//
//            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
//            entity.initializeMd5();
//            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
//            介護事業者代表者 = 介護事業者代表者.createBuilderForEdit().set代表者住所カナ(new RString("任意項目1を変更")).build();
//
//            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
//        }
        @Test
        public void deleteに成功するとtrueが返る() {
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
            sut.save介護事業者代表者(介護事業者代表者);
            DbT7062KaigoJigyoshaDaihyoshaEntity entity7062 = dac.selectByKey(DEFAULT_事業者番号, DEFAULT_有効開始日);
            entity7062.setState(EntityDataState.Deleted);
            KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = new KaigoJigyoshaDaihyosha(entity7062);
            kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyosha.deleted();

            assertThat(sut.save介護事業者代表者(kaigoJigyoshaDaihyosha), is(true));
        }

//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(0);
//
//            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
//            entity.initializeMd5();
//            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
//            介護事業者代表者 = 介護事業者代表者.deleted();
//
//            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
//            entity.initializeMd5();
//            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
//
//            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
//        }
        @After
        public void after() {
            rollback();
        }
    }

    private static class TestSupport {

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT7062KaigoJigyoshaDaihyoshaEntity.TABLE_NAME.toString());
        }
    }
}
