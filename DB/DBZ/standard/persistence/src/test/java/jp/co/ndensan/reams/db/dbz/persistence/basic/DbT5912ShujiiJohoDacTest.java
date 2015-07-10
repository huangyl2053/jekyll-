/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5912ShujiiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
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
 * {@link DbT5912ShujiiJohoDac}のテストです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class DbT5912ShujiiJohoDacTest extends DbdTestDacBase {

    private static DbT5912ShujiiJohoDac sut;

    private static final LasdecCode DEFAULT_市町村コード1 = new LasdecCode("000001");
    private static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード1 = new ShujiiIryokikanCode("0000000001");
    private static final ShujiiCode DEFAULT_主治医コード1 = new ShujiiCode("00000001");
    private static final LasdecCode DEFAULT_市町村コード2 = new LasdecCode("000002");
    private static final ShujiiIryokikanCode DEFAULT_主治医医療機関コード2 = new ShujiiIryokikanCode("0000000002");
    private static final ShujiiCode DEFAULT_主治医コード2 = new ShujiiCode("00000002");
    private static final LasdecCode notDEFAULT_市町村コード = new LasdecCode("999999");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5912ShujiiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
            TestSupport.insert(
                    DEFAULT_市町村コード2,
                    DEFAULT_主治医医療機関コード2,
                    DEFAULT_主治医コード2);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード1,
                    null,
                    DEFAULT_主治医コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT5912ShujiiJohoEntity> insertedRecord = sut.selectByKey(
                    notDEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_Optionのemptyを返す() {
            Optional<DbT5912ShujiiJohoEntity> empty = Optional.empty();
            Optional<DbT5912ShujiiJohoEntity> insertedRecord = sut.selectByKey(
                    notDEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
            assertThat(insertedRecord, is(empty));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 主治医情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
            TestSupport.insert(
                    DEFAULT_市町村コード2,
                    DEFAULT_主治医医療機関コード2,
                    DEFAULT_主治医コード2);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 主治医情報が存在しない場合_selectAllは_空のリストを返す() {
            ItemList<DbT5912ShujiiJohoEntity> empty = ItemList.empty();
            assertThat(sut.selectAll(), is(empty));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 主治医情報エンティティを渡すと_insertは_主治医情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
        }

        @Test
        public void 主治医情報エンティティを渡すと_updateは_主治医情報を更新する() {
            DbT5912ShujiiJohoEntity updateRecord = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();
            updateRecord.setShinryokaName(new RString("あいうえお"));

            sut.update(updateRecord);

            Optional<DbT5912ShujiiJohoEntity> updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);

            assertThat(updateRecord.getShujiiName(), is(updatedRecord.get().getShujiiName()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1);
        }

        @Test
        public void 主治医情報エンティティを渡すと_deleteは_主治医情報を削除する() {
            Optional<DbT5912ShujiiJohoEntity> empty = Optional.empty();

            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1).get());
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード1,
                    DEFAULT_主治医医療機関コード1,
                    DEFAULT_主治医コード1), is(empty));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ShujiiIryokikanCode 主治医医療機関コード,
                ShujiiCode 主治医コード) {
            DbT5912ShujiiJohoEntity entity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShujiiIryokikanCode(主治医医療機関コード);
            entity.setShujiiCode(主治医コード);
            sut.insert(entity);
        }
    }
}
