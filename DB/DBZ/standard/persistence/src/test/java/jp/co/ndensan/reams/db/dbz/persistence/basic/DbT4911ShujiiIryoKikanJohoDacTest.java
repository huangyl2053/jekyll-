/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4911ShujiiIryoKikanJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4911ShujiiIryoKikanJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT4911ShujiiIryoKikanJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT4911ShujiiIryoKikanJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT4911ShujiiIryoKikanJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4911ShujiiIryoKikanJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4911ShujiiIryoKikanJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4911ShujiiIryoKikanJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 主治医医療機関情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 主治医医療機関情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 主治医医療機関情報エンティティを渡すと_insertは_主治医医療機関情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test
        public void 主治医医療機関情報エンティティを渡すと_updateは_主治医医療機関情報を更新する() {
            DbT4911ShujiiIryoKikanJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT4911ShujiiIryoKikanJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test
        public void 主治医医療機関情報エンティティを渡すと_deleteは_主治医医療機関情報を削除する() {
            DbT4911ShujiiIryoKikanJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ShujiiIryokikanCode 主治医医療機関コード) {
            DbT4911ShujiiIryoKikanJohoEntity entity = DbT4911ShujiiIryoKikanJohoEntityGenerator.createDbT4911ShujiiIryoKikanJohoEntity();

            sut.save(entity);
        }
    }
}
