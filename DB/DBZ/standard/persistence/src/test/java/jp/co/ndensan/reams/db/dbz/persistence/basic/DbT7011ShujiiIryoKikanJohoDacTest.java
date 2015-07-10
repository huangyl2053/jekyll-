/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7011ShujiiIryoKikanJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_介護医療機関コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7011ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード;
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
 * {@link DbT7011ShujiiIryoKikanJohoDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT7011ShujiiIryoKikanJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7011ShujiiIryoKikanJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7011ShujiiIryoKikanJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new LasdecCode(new RString("211211")),
                    DEFAULT_介護医療機関コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_介護医療機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7011ShujiiIryoKikanJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7011ShujiiIryoKikanJohoEntity insertedRecord = sut.selectByKey(
                    new LasdecCode(new RString("205012")),
                    DEFAULT_介護医療機関コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 主治医医療機関情報_継承が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new LasdecCode(new RString("141414")),
                    DEFAULT_介護医療機関コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 主治医医療機関情報_継承が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 主治医医療機関情報_継承エンティティを渡すと_insertは_主治医医療機関情報_継承を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);
        }

        @Test
        public void 主治医医療機関情報_継承エンティティを渡すと_updateは_主治医医療機関情報_継承を更新する() {
            DbT7011ShujiiIryoKikanJohoEntity updateRecord = DbT7011ShujiiIryoKikanJohoEntityGenerator.createDbT7011ShujiiIryoKikanJohoEntity();
            //TODO  主キー以外の項目を変更してください
//updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7011ShujiiIryoKikanJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);

            //TODO  主キー以外の項目を変更してください
//  assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード);
        }

        @Test
        public void 主治医医療機関情報_継承エンティティを渡すと_deleteは_主治医医療機関情報_継承を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_介護医療機関コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 介護医療機関コード) {
            DbT7011ShujiiIryoKikanJohoEntity entity = DbT7011ShujiiIryoKikanJohoEntityGenerator.createDbT7011ShujiiIryoKikanJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setKaigoIryokikanCode(介護医療機関コード);
            sut.insert(entity);
        }
    }
}
