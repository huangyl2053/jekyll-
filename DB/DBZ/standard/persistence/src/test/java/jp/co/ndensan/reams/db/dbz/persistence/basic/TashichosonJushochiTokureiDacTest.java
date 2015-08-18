/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_枝番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_異動日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link TashichosonJushochiTokureiDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiDacTest extends DbzTestDacBase {

    private static final ShikibetsuCode OTHER_識別コード = new ShikibetsuCode("000010000101234");
    private static final FlexibleDate OTHER_異動日 = new FlexibleDate("20150808");
    private static final RString OTHER_枝番 = new RString("001");
    private static final ShikibetsuCode NONE_識別コード = new ShikibetsuCode("999999999999999");
    private static final FlexibleDate NONE_異動日 = new FlexibleDate("99999999");
    private static final RString NONE_枝番 = new RString("999");
    private static TashichosonJushochiTokureiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(TashichosonJushochiTokureiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            TestSupport.insert(
                    OTHER_識別コード,
                    OTHER_異動日,
                    OTHER_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    null,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1003TashichosonJushochiTokureiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1003TashichosonJushochiTokureiEntity insertedRecord = sut.selectByKey(
                    NONE_識別コード,
                    NONE_異動日,
                    NONE_枝番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }
//TODO n8178 城間篤人 既にDB上にデータが入っているため、DB上にデータがない前提のこのテストは通らない。対応が決まり次第修正予定 2015年1月
//    public static class selectAllのテスト extends DbzTestDacBase {
//
//        @Test
//        public void 他市町村住所地特例が存在する場合_selectAllは_全件を返す() {
//            TestSupport.insert(
//                    DEFAULT_市町村コード,
//                    DEFAULT_識別コード,
//                    DEFAULT_処理日時);
//            TestSupport.insert(
//                    DEFAULT_市町村コード,
//                    DEFAULT_識別コード,
//                    DEFAULT_処理日時);
//            assertThat(sut.selectAll().size(), is(2));
//        }
//
//        @Test
//        public void 他市町村住所地特例が存在しない場合_selectAllは_空のリストを返す() {
//            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
//        }
//    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 他市町村住所地特例エンティティを渡すと_insertは_他市町村住所地特例を追加する() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 他市町村住所地特例エンティティを渡すと_updateは_他市町村住所地特例を更新する() {
            DbT1003TashichosonJushochiTokureiEntity updateRecord = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            updateRecord.setTekiyoYMD(new FlexibleDate("20140918"));

            sut.update(updateRecord);

            DbT1003TashichosonJushochiTokureiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番);

            assertThat(updateRecord.getTekiyoYMD(), is(updatedRecord.getTekiyoYMD()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 他市町村住所地特例エンティティを渡すと_deleteは_他市町村住所地特例を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番));
            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_異動日,
                    DEFAULT_枝番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(ShikibetsuCode 識別コード,
                FlexibleDate 異動日,
                RString 枝番) {
            DbT1003TashichosonJushochiTokureiEntity entity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setIdoYMD(異動日);
            entity.setEdaNo(枝番);
            sut.insert(entity);
        }
    }
}
