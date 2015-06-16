/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5911ShujiiIryoKikanJohoDac}のテストです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class DbT5911ShujiiIryoKikanJohoDacTest extends DbdTestDacBase {

    private static DbT5911ShujiiIryoKikanJohoDac sut;
    private static final LasdecCode DEFAULT_市町村コード2 = new LasdecCode("000002");
    private static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード2 = new ShujiiIryokikanCode("0000000002");
    private static final LasdecCode notDEFAULT_市町村コード = new LasdecCode("999999");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            TestSupport.insert(
                    DEFAULT_市町村コード2,
                    DEFAULT_主治医医療機関コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_主治医医療機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5911ShujiiIryoKikanJohoEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_Optionのemptyを返す() {
            Optional<DbT5911ShujiiIryoKikanJohoEntity> empty = Optional.empty();
            Optional<DbT5911ShujiiIryoKikanJohoEntity> insertedRecord = sut.selectByKey(
                    notDEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
            assertThat(insertedRecord, is(empty));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

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
            ItemList<DbT5911ShujiiIryoKikanJohoEntity> empty = ItemList.empty();
            assertThat(sut.selectAll(), is(empty));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

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

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test
        public void 主治医医療機関情報エンティティを渡すと_updateは_主治医医療機関情報を更新する() {
            DbT5911ShujiiIryoKikanJohoEntity updateRecord = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();
            updateRecord.setIryoKikanMeisho(new RString("あいうえお"));

            sut.update(updateRecord);

            Optional<DbT5911ShujiiIryoKikanJohoEntity> updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);

            assertThat(updateRecord.getIryoKikanMeisho(), is(updatedRecord.get().getIryoKikanMeisho()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード);
        }

        @Test
        public void 主治医医療機関情報エンティティを渡すと_deleteは_主治医医療機関情報を削除する() {
            Optional<DbT5911ShujiiIryoKikanJohoEntity> empty = Optional.empty();

            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード).get());
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード), is(empty));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ShujiiIryokikanCode 主治医医療機関コード) {
            DbT5911ShujiiIryoKikanJohoEntity entity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShujiiIryokikanCode(主治医医療機関コード);
            sut.insert(entity);
        }
    }
}
