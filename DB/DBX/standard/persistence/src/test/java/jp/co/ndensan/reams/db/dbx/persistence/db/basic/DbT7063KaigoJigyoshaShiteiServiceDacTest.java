/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT7063KaigoJigyoshaShiteiServiceDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7063KaigoJigyoshaShiteiServiceDacTest extends DbxTestDacBase {

    private static final JigyoshaNo キー_01 = new JigyoshaNo("00001");
    private static final JigyoshaNo キー_02 = new JigyoshaNo("00002");
    private static final JigyoshaNo キー_03 = new JigyoshaNo("00003");
    private static DbT7063KaigoJigyoshaShiteiServiceDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            TestSupport.insert(
                    キー_01,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者番号,
                    null,
                    DEFAULT_有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7063KaigoJigyoshaShiteiServiceEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7063KaigoJigyoshaShiteiServiceEntity insertedRecord = sut.selectByKey(
                    キー_02,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護事業者指定サービスが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護事業者指定サービスが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護事業者指定サービスエンティティを渡すと_insertは_介護事業者指定サービスを追加する() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
        }

        @Test
        public void 介護事業者指定サービスエンティティを渡すと_updateは_介護事業者指定サービスを更新する() {
            DbT7063KaigoJigyoshaShiteiServiceEntity updateRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            updateRecord.setIdoJiyu(new RString("じゆう"));

            sut.save(updateRecord);

            DbT7063KaigoJigyoshaShiteiServiceEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);

            assertThat(updateRecord.getIdoJiyu(), is(updatedRecord.getIdoJiyu()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
        }

        @Test
        public void 介護事業者指定サービスエンティティを渡すと_deleteは_介護事業者指定サービスを削除する() {
            DbT7063KaigoJigyoshaShiteiServiceEntity deletedEntity = sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者番号,
                    DEFAULT_サービス種類コード,
                    DEFAULT_有効開始日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                JigyoshaNo 事業者番号,
                ServiceShuruiCode サービス種類コード,
                FlexibleDate 有効開始日) {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.setJigyoshaNo(事業者番号);
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setYukoKaishiYMD(有効開始日);
            sut.save(entity);
        }
    }
}
