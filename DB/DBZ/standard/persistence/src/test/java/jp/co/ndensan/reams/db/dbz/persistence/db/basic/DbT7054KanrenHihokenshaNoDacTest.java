/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7054KanrenHihokenshaNoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT7054KanrenHihokenshaNoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7054KanrenHihokenshaNoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7054KanrenHihokenshaNoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7054KanrenHihokenshaNoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 最新被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7054KanrenHihokenshaNoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7054KanrenHihokenshaNoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 関連被保険者番号が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 関連被保険者番号が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 関連被保険者番号エンティティを渡すと_insertは_関連被保険者番号を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
        }

        @Test
        public void 関連被保険者番号エンティティを渡すと_updateは_関連被保険者番号を更新する() {
            DbT7054KanrenHihokenshaNoEntity updateRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7054KanrenHihokenshaNoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
        }

        @Test
        public void 関連被保険者番号エンティティを渡すと_deleteは_関連被保険者番号を削除する() {
            DbT7054KanrenHihokenshaNoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_最新被保険者番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 最新被保険者番号) {
            DbT7054KanrenHihokenshaNoEntity entity = DbT7054KanrenHihokenshaNoEntityGenerator.createDbT7054KanrenHihokenshaNoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setSaishinHihokenshaNo(最新被保険者番号);
            sut.save(entity);
        }
    }
}
