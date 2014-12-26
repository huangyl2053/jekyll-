/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * {@link DbT1008IryohokenKanyuJokyoDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT1008IryohokenKanyuJokyoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final LasdecCode 市町村コード202012 = new LasdecCode("202012");
    private static final LasdecCode 市町村コード202013 = new LasdecCode("202013");
    private static DbT1008IryohokenKanyuJokyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    市町村コード202012,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1008IryohokenKanyuJokyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1008IryohokenKanyuJokyoEntity insertedRecord = sut.selectByKey(
                    市町村コード202013,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険医療保険加入状況が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    市町村コード202012,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護保険医療保険加入状況が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護保険医療保険加入状況エンティティを渡すと_insertは_介護保険医療保険加入状況を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護保険医療保険加入状況エンティティを渡すと_updateは_介護保険医療保険加入状況を更新する() {
            DbT1008IryohokenKanyuJokyoEntity updateRecord = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT1008IryohokenKanyuJokyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護保険医療保険加入状況エンティティを渡すと_deleteは_介護保険医療保険加入状況を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ShikibetsuCode 識別コード,
                YMDHMS 処理日時) {
            DbT1008IryohokenKanyuJokyoEntity entity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShikibetsuCode(識別コード);
            entity.setShoriTimeStamp(処理日時);
            sut.insert(entity);
        }
    }
}
