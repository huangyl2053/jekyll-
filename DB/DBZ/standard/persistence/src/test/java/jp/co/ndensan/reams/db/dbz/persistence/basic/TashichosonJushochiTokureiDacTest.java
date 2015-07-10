/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.TashichosonJushochiTokureiDac;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TashichosonJushochiTokureiDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TashichosonJushochiTokureiDacTest extends DbzTestDacBase {

    private static final LasdecCode OTHER_市町村コード = new LasdecCode("202010");
    private static final ShikibetsuCode OTHER_識別コード = new ShikibetsuCode("000010000101234");
    private static final YMDHMS OTHER_処理日時 = new YMDHMS("20141212012345");
    private static final LasdecCode NONE_市町村コード = new LasdecCode("999999");
    private static final ShikibetsuCode NONE_識別コード = new ShikibetsuCode("999999999999999");
    private static final YMDHMS NONE_処理日時 = new YMDHMS("39991231235959");
    private static TashichosonJushochiTokureiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(TashichosonJushochiTokureiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_識別コード,
                    OTHER_処理日時);
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
            DbT1003TashichosonJushochiTokureiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1003TashichosonJushochiTokureiEntity insertedRecord = sut.selectByKey(
                    NONE_市町村コード,
                    NONE_識別コード,
                    NONE_処理日時);
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
        public void 他市町村住所地特例エンティティを渡すと_updateは_他市町村住所地特例を更新する() {
            DbT1003TashichosonJushochiTokureiEntity updateRecord = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            updateRecord.setTekiyoYMD(new FlexibleDate("20140918"));

            sut.update(updateRecord);

            DbT1003TashichosonJushochiTokureiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_識別コード,
                    DEFAULT_処理日時);

            assertThat(updateRecord.getTekiyoYMD(), is(updatedRecord.getTekiyoYMD()));
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
        public void 他市町村住所地特例エンティティを渡すと_deleteは_他市町村住所地特例を削除する() {
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
            DbT1003TashichosonJushochiTokureiEntity entity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShikibetsuCode(識別コード);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
