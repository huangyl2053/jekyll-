/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5223ChikuNinteiChosainDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5223ChikuNinteiChosainDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT5223ChikuNinteiChosainDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5223ChikuNinteiChosainDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 調査地区コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5223ChikuNinteiChosainEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5223ChikuNinteiChosainEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 地区認定調査員が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 地区認定調査員が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 地区認定調査員エンティティを渡すと_insertは_地区認定調査員を追加する() {
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);

            assertThat(sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 地区認定調査員エンティティを渡すと_updateは_地区認定調査員を更新する() {
            DbT5223ChikuNinteiChosainEntity updateRecord = sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5223ChikuNinteiChosainEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 地区認定調査員エンティティを渡すと_deleteは_地区認定調査員を削除する() {
            DbT5223ChikuNinteiChosainEntity deletedEntity = sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_調査地区コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード,
                    DEFAULT_市町村コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                Code 調査地区コード,
                RString 認定調査委託先コード,
                RString 認定調査員コード,
                LasdecCode 市町村コード) {
            DbT5223ChikuNinteiChosainEntity entity = DbT5223ChikuNinteiChosainEntityGenerator.createDbT5223ChikuNinteiChosainEntity();
            entity.setChosaChikuCode(調査地区コード);
            entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
            entity.setNinteiChosainCode(認定調査員コード);
            entity.setShichosonCode(市町村コード);
            sut.save(entity);
        }
    }
}
