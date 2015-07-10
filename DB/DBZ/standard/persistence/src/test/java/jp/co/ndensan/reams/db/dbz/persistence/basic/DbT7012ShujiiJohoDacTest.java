/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7012ShujiiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7012ShujiiJohoEntityGenerator.DEFAULT_介護医師コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7012ShujiiJohoEntityGenerator.DEFAULT_介護医療機関コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7012ShujiiJohoEntityGenerator.DEFAULT_市町村コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT7012ShujiiJohoDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT7012ShujiiJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7012ShujiiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7012ShujiiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new LasdecCode(new RString("124546")),
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_介護医師コード);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医師コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7012ShujiiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7012ShujiiJohoEntity insertedRecord = sut.selectByKey(
                    new LasdecCode("201524"),
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 主治医情報_継承が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new LasdecCode("789456"),
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 主治医情報_継承が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 主治医情報_継承エンティティを渡すと_insertは_主治医情報_継承を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
        }

        @Test
        public void 主治医情報_継承エンティティを渡すと_updateは_主治医情報_継承を更新する() {
            DbT7012ShujiiJohoEntity updateRecord = DbT7012ShujiiJohoEntityGenerator.createDbT7012ShujiiJohoEntity();
            //TODO  主キー以外の項目を変更してください
//  updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7012ShujiiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);

            //TODO  主キー以外の項目を変更してください
//   assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード);
        }

        @Test
        public void 主治医情報_継承エンティティを渡すと_deleteは_主治医情報_継承を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード,
                    DEFAULT_介護医師コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 介護医療機関コード,
                RString 介護医師コード) {
            DbT7012ShujiiJohoEntity entity = DbT7012ShujiiJohoEntityGenerator.createDbT7012ShujiiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setKaigoIryokikanCode(介護医療機関コード);
            entity.setKaigoIshiCode(介護医師コード);
            sut.insert(entity);
        }
    }
}
