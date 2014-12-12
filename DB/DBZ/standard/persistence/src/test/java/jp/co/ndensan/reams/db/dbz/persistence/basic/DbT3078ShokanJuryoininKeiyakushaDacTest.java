/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT3078ShokanJuryoininKeiyakushaDac}のテストです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class DbT3078ShokanJuryoininKeiyakushaDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3078ShokanJuryoininKeiyakushaDac sut;
    private static final HihokenshaNo 被保険者番号_1 = new HihokenshaNo(new RString("3"));
    private static final HihokenshaNo 被保険者番号_2 = new HihokenshaNo(new RString("4"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3078ShokanJuryoininKeiyakushaDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    被保険者番号_1,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 受付年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3078ShokanJuryoininKeiyakushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3078ShokanJuryoininKeiyakushaEntity insertedRecord = sut.selectByKey(
                    被保険者番号_2,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 償還受領委任契約者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    被保険者番号_1,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 償還受領委任契約者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 償還受領委任契約者エンティティを渡すと_insertは_償還受領委任契約者を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
        }

        @Test
        public void 償還受領委任契約者エンティティを渡すと_updateは_償還受領委任契約者を更新する() {
            DbT3078ShokanJuryoininKeiyakushaEntity updateRecord = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3078ShokanJuryoininKeiyakushaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時);
        }

        @Test
        public void 償還受領委任契約者エンティティを渡すと_deleteは_償還受領委任契約者を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_受付年月日,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                ShoKisaiHokenshaNo 証記載保険者番号,
                FlexibleDate 受付年月日,
                YMDHMS 処理日時) {
            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setUketsukeYMD(受付年月日);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
