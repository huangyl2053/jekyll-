/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator.*;
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
 * {@link HihokenshaDaichoDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest extends DbzTestDacBase {

    private static final LasdecCode OTHER_市町村コード = new LasdecCode("201010");
    private static final HihokenshaNo OTHER_被保険者番号 = new HihokenshaNo("1234500001");
    private static final YMDHMS OTHER_処理日時 = new YMDHMS("20091104134911");
    private static final LasdecCode NONE_市町村コード = new LasdecCode("999999");
    private static final HihokenshaNo NONE_被保険者番号 = new HihokenshaNo("9999999999");
    private static final YMDHMS NONE_処理日時 = new YMDHMS("39990101235959");
    private static HihokenshaDaichoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_被保険者番号,
                    OTHER_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    NONE_市町村コード,
                    NONE_被保険者番号,
                    NONE_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    //TODO n8178 城間篤人 既にDB上にデータが入っているため、DB上にデータがない前提のこのテストは通らない。対応が決まり次第修正予定 2015年1月
//    public static class selectAllのテスト extends DbzTestDacBase {
//
//        @Test
//        public void 被保険者台帳が存在する場合_selectAllは_全件を返す() {
//            TestSupport.insert(
//                    DEFAULT_市町村コード,
//                    DEFAULT_被保険者番号,
//                    DEFAULT_処理日時);
//            TestSupport.insert(
//                    DEFAULT_市町村コード,
//                    DEFAULT_被保険者番号,
//                    DEFAULT_処理日時);
//            assertThat(sut.selectAll().size(), is(2));
//        }
//
//        @Test
//        public void 被保険者台帳が存在しない場合_selectAllは_空のリストを返す() {
//            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
//        }
//    }
    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 被保険者台帳エンティティを渡すと_insertは_被保険者台帳を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 被保険者台帳エンティティを渡すと_updateは_被保険者台帳を更新する() {
            DbT1001HihokenshaDaichoEntity updateRecord = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            updateRecord.setShikakuShutokuYMD(new FlexibleDate("20091111"));

            sut.update(updateRecord);

            DbT1001HihokenshaDaichoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(updateRecord.getShikakuShutokuYMD(), is(updatedRecord.getShikakuShutokuYMD()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 被保険者台帳エンティティを渡すと_deleteは_被保険者台帳を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                HihokenshaNo 被保険者番号,
                YMDHMS 処理日時) {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
