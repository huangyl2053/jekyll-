/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.relate;

import jp.co.ndensan.reams.db.dbx.persistence.db.relate.KaigoJigyoshaRelateDac;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.relate.helper.KaigoJigyoshaRelateEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.persistence.basic.helper.KaigoJigyoshaRelateEntityTestHelper;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaRelateDac}のテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaRelateDacTest extends DbxTestDacBase {

    private static KaigoJigyoshaRelateDac sut;
    private static DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private static DbT7062KaigoJigyoshaDaihyoshaDac 介護事業者代表者Dac;
    private static DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac;

    private static final KaigoJigyoshaNo 事業者番号1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
    private static final KaigoJigyoshaNo 事業者番号2 = new KaigoJigyoshaNo("1234567892");
    private static final FlexibleDate 有効開始日1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    private static final FlexibleDate 有効開始日2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日.plusDay(10);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KaigoJigyoshaRelateDac.class);
        介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        介護事業者代表者Dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        介護事業者指定サービスDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    public static class selectByJigyoshaNoTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insertUrT0518(事業者番号1, 有効開始日1);
            TestSupport.insertUrT0518(事業者番号1, 有効開始日2);
            TestSupport.insertUrT0518(事業者番号2, 有効開始日1);
            TestSupport.insertUrT0518(事業者番号2, 有効開始日2);

            TestSupport.insertUrT0520(事業者番号1, 有効開始日1);
            TestSupport.insertUrT0520(事業者番号1, 有効開始日2);
            TestSupport.insertUrT0520(事業者番号2, 有効開始日1);
            TestSupport.insertUrT0520(事業者番号2, 有効開始日2);

            TestSupport.insertUrT0521(事業者番号1);
            TestSupport.insertUrT0521(事業者番号2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByJigyoshaNo(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護事業者RelateEntity返す() {
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(0).get事業者エンティティ().getJigyoshaNo(), is(事業者番号1));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(0).get事業者エンティティ().getYukoKaishiYMD(), is(有効開始日2));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(0).get事業者代表者エンティティ().getJigyoshaNo(), is(事業者番号1));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(0).get事業者代表者エンティティ().getYukoKaishiYMD(), is(有効開始日2));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(0).get事業者指定サービスエンティティリスト().get(0).getJigyoshaNo(), is(事業者番号1));

            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(1).get事業者エンティティ().getJigyoshaNo(), is(事業者番号1));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(1).get事業者エンティティ().getYukoKaishiYMD(), is(有効開始日1));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(1).get事業者代表者エンティティ().getJigyoshaNo(), is(事業者番号1));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(1).get事業者代表者エンティティ().getYukoKaishiYMD(), is(有効開始日1));
            assertThat(sut.selectByJigyoshaNo(事業者番号1).get(1).get事業者指定サービスエンティティリスト().get(0).getJigyoshaNo(), is(事業者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_emptyを返す() {
            assertThat(sut.selectByJigyoshaNo(new KaigoJigyoshaNo("9999999999")).isEmpty(), is(true));
        }

        @Test
        public void LDNS_データが見つかない検索条件を渡すと_selectByJigyoshaNoは_2件を返す() {
            TestSupport.deleteData();
            TestSupport.insertUrT0518(事業者番号1, 有効開始日1);
            TestSupport.insertUrT0518(事業者番号1, 有効開始日2);
            TestSupport.insertUrT0521(事業者番号1);
            assertThat(sut.selectByJigyoshaNo(事業者番号1).size(), is(2));
        }
    }

    public static class insertTest extends DbxTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なentityを持つKaigoJigyoshaRelateEntityを渡した時_insertは_1を返す() {
            TestSupport.deleteData();
            KaigoJigyoshaRelateEntity entity = KaigoJigyoshaRelateEntityGenerator.createKaigoJigyoshaRelateEntity();

            assertThat(sut.insert(entity), is(1));
        }

        @Test
        public void LDNS_全ての有効なモデルを持つKaigoJigyoshaRelateモデルを渡した時_insertは_0を返す() {
            TestSupport.deleteData();
            assertThat(sut.insert(new KaigoJigyoshaRelateEntity(null, null, null)), is(0));
        }
    }

    public static class updateTest extends DbxTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        @Test
        public void モデルの状態がModifiedの時_updateは_0を返す() {
            TestSupport.deleteData();
            KaigoJigyoshaRelateEntity model = KaigoJigyoshaRelateEntityTestHelper.createModel1();

            sut.insert(model);
            model.get事業者エンティティ().initializeMd5();
            model.get事業者代表者エンティティ().initializeMd5();
            for (DbT7063KaigoJigyoshaShiteiServiceEntity item : model.get事業者指定サービスエンティティリスト()) {
                item.initializeMd5();
            }
            model.get事業者エンティティ().setJigyoKaishiYMD(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業開始日.plusDay(1));

            assertThat(sut.update(model), is(0));
        }

        @Test
        public void LDNS_全ての有効なモデルを持つKaigoJigyoshaRelateモデルを渡した時_updateは_0を返す() {
            TestSupport.deleteData();
            assertThat(sut.update(new KaigoJigyoshaRelateEntity()), is(0));
        }

        @Test
        public void LDNS_介護事業者代表者モデルの状態がdeletedの時_updateは_0を返す() {
            TestSupport.deleteData();
            TestSupport.insertUrT0520(事業者番号1, 有効開始日1);
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaRelateEntity model = new KaigoJigyoshaRelateEntity();
            model.set事業者代表者エンティティ(entity);
            model.get事業者代表者エンティティ().setState(EntityDataState.Deleted);
            assertThat(sut.update(model), is(0));
        }

        @Test
        public void LDNS_介護事業者代表者モデルの状態がinsertの時_updateは_0を返す() {
            TestSupport.deleteData();
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaRelateEntity model = new KaigoJigyoshaRelateEntity();
            model.set事業者代表者エンティティ(entity);
            model.get事業者代表者エンティティ().setState(EntityDataState.Added);
            assertThat(sut.update(model), is(0));
        }

        @Test
        public void LDNS_介護事業者代表者モデルの状態がupdateの時_updateは_0を返す() {
            TestSupport.deleteData();
            TestSupport.insertUrT0520(事業者番号1, 有効開始日1);
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaRelateEntity model = new KaigoJigyoshaRelateEntity();
            model.set事業者代表者エンティティ(entity);
            model.get事業者代表者エンティティ().setState(EntityDataState.Modified);
            assertThat(sut.update(model), is(0));
        }

        @Test
        public void LDNS_介護事業者指定サービスモデルListの状態がinsertの時_updateは_0を返す() {
            TestSupport.deleteData();
            KaigoJigyoshaRelateEntity model = new KaigoJigyoshaRelateEntity();
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
            list.add(entity);
            model.set事業者指定サービスエンティティリスト(list);
            model.get事業者指定サービスエンティティリスト().get(0).setState(EntityDataState.Added);
            assertThat(sut.update(model), is(0));
        }

        @Test
        public void LDNS_介護事業者指定サービスモデルListの状態がupdateの時_updateは_0を返す() {
            TestSupport.deleteData();
            TestSupport.insertUrT0521(事業者番号1);
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaRelateEntity model = new KaigoJigyoshaRelateEntity();
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
            list.add(entity);
            model.set事業者指定サービスエンティティリスト(list);
            model.get事業者指定サービスエンティティリスト().get(0).setState(EntityDataState.Modified);
            assertThat(sut.update(model), is(0));
        }

        @Test
        public void LDNS_介護事業者指定サービスモデルListの状態がdeleteの時_updateは_0を返す() {
            TestSupport.deleteData();
            TestSupport.insertUrT0521(事業者番号1);
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaRelateEntity model = new KaigoJigyoshaRelateEntity();
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
            list.add(entity);
            model.set事業者指定サービスエンティティリスト(list);
            model.get事業者指定サービスエンティティリスト().get(0).setState(EntityDataState.Deleted);
            assertThat(sut.update(model), is(0));
        }
    }

    public static class deleteTest extends DbxTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つKaigoJigyoshaRelateモデルを渡した時_deleteは_0を返す() {
            TestSupport.deleteData();
            KaigoJigyoshaRelateEntity model = KaigoJigyoshaRelateEntityTestHelper.createModel1();
            sut.insert(model);
            assertThat(sut.delete(model), is(0));
        }

        @Test
        public void LDNS_全ての有効なモデルを持つKaigoJigyoshaRelateモデルを渡した時_deleteは_0を返す() {
            TestSupport.deleteData();
            assertThat(sut.delete(new KaigoJigyoshaRelateEntity()), is(0));
        }
    }

    //TODO n3317塚田萌　更新方法が確定したら対応する
//    public static class updateTest extends DbxTestDacBase {
//
//        @Test
//        public void nullを渡した時_updateは_0を返す() {
//            assertThat(sut.update(null), is(0));
//        }
//
//        @Test
//        public void モデルの状態がModifiedの時_updateは_1を返す() {
//            TestSupport.deleteData();
//            KaigoJigyoshaRelateModel model = KaigoJigyoshaRelateModelTestHelper.createModel1();
//
//            sut.insert(model);
//            model.get介護事業者モデル().getEntity().initializeMd5();
//            model.get介護事業者代表者モデル().getEntity().initializeMd5();
//            for (KaigoJigyoshaShiteiServiceModel item : model.get介護事業者指定サービスモデルList()) {
//                item.getEntity().initializeMd5();
//            }
//            model.get介護事業者モデル().set事業開始日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業開始日.plusDay(1));
//
//            assertThat(sut.update(model), is(1));
//        }
//    }
//
//    public static class deleteTest extends DbxTestDacBase {
//
//        @Test
//        public void nullを渡した時_deleteは_0を返す() {
//            assertThat(sut.delete(null), is(0));
//        }
//
//        @Test
//        public void 全ての有効なモデルを持つKaigoJigyoshaRelateモデルを渡した時_deleteは_1を返す() {
//            TestSupport.deleteData();
//            KaigoJigyoshaRelateModel model = KaigoJigyoshaRelateModelTestHelper.createModel1();
//            sut.insert(model);
//            assertThat(sut.delete(model), is(1));
//        }
//    }
    private static class TestSupport {

        public static void insertUrT0518(
                KaigoJigyoshaNo 事業者番号,
                FlexibleDate 有効開始日) {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始日);
            介護事業者Dac.save(entity);
        }

        public static void insertUrT0520(
                KaigoJigyoshaNo 事業者番号,
                FlexibleDate 有効開始日) {
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始日);
            介護事業者代表者Dac.save(entity);
        }

        public static void insertUrT0521(
                KaigoJigyoshaNo 事業者番号) {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.setJigyoshaNo(事業者番号);
            介護事業者指定サービスDac.save(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7060KaigoJigyoshaEntity.TABLE_NAME.toString());
            utilForUseSession.clearTable(sqlSession, DbT7062KaigoJigyoshaDaihyoshaEntity.TABLE_NAME.toString());
            utilForUseSession.clearTable(sqlSession, DbT7063KaigoJigyoshaShiteiServiceEntity.TABLE_NAME.toString());
        }
    }
}
