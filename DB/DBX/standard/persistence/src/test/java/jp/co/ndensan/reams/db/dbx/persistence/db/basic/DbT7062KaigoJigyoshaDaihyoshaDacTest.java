/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7062KaigoJigyoshaDaihyoshaDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7062KaigoJigyoshaDaihyoshaDacTest extends DbxTestDacBase {

    private static final KaigoJigyoshaNo キー_01 = new KaigoJigyoshaNo("00001");
    private static final KaigoJigyoshaNo キー_02 = new KaigoJigyoshaNo("00002");
    private static final KaigoJigyoshaNo キー_03 = new KaigoJigyoshaNo("00003");
    private static DbT7062KaigoJigyoshaDaihyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            TestSupport.insert(
                    キー_01,
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7062KaigoJigyoshaDaihyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7062KaigoJigyoshaDaihyoshaEntity insertedRecord = sut.selectByKey(
                    キー_02,
                    DEFAULT_有効開始日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護事業者代表者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_有効開始日);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_有効開始日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護事業者代表者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護事業者代表者エンティティを渡すと_insertは_介護事業者代表者を追加する() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
        }

        @Test
        public void 介護事業者代表者エンティティを渡すと_updateは_介護事業者代表者を更新する() {
            DbT7062KaigoJigyoshaDaihyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            updateRecord.setKaisetsushaShimei(new AtenaMeisho("開設者"));

            sut.save(updateRecord);

            DbT7062KaigoJigyoshaDaihyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);

            assertThat(updateRecord.getKaisetsushaShimei(), is(updatedRecord.getKaisetsushaShimei()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
        }

        @Test
        public void 介護事業者代表者エンティティを渡すと_deleteは_介護事業者代表者を削除する() {
            DbT7062KaigoJigyoshaDaihyoshaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KaigoJigyoshaNo 事業者番号,
                FlexibleDate 有効開始日) {
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始日);
            sut.save(entity);
        }
    }
}
