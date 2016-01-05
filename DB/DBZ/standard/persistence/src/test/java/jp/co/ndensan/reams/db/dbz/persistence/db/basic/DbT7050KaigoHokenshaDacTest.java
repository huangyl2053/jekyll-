/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7050KaigoHokenshaDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7050KaigoHokenshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7050KaigoHokenshaDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7050KaigoHokenshaDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7050KaigoHokenshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7050KaigoHokenshaDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 広域保険者市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_広域保険者市町村コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7050KaigoHokenshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_広域保険者市町村コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7050KaigoHokenshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_広域保険者市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護保険者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険者エンティティを渡すと_insertは_介護保険者を追加する() {
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);

            assertThat(sut.selectByKey(
                    DEFAULT_広域保険者市町村コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);
        }

        @Test
        public void 介護保険者エンティティを渡すと_updateは_介護保険者を更新する() {
            DbT7050KaigoHokenshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_広域保険者市町村コード);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7050KaigoHokenshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_広域保険者市町村コード);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_広域保険者市町村コード);
        }

        @Test
        public void 介護保険者エンティティを渡すと_deleteは_介護保険者を削除する() {
            DbT7050KaigoHokenshaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_広域保険者市町村コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_広域保険者市町村コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 広域保険者市町村コード) {
            DbT7050KaigoHokenshaEntity entity = DbT7050KaigoHokenshaEntityGenerator.createDbT7050KaigoHokenshaEntity();
            entity.setKoikiHokenshaShichosonCode(広域保険者市町村コード);
            sut.save(entity);
        }
    }
}
