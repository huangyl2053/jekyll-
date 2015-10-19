/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
 * {@link DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV1005KaigoJogaiTokureiTaishoShisetsuAliveDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 他市町村住所地特例者台帳管理Aliveが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 他市町村住所地特例者台帳管理Aliveが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 他市町村住所地特例者台帳管理Aliveエンティティを渡すと_insertは_他市町村住所地特例者台帳管理Aliveを追加する() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test
        public void 他市町村住所地特例者台帳管理Aliveエンティティを渡すと_updateは_他市町村住所地特例者台帳管理Aliveを更新する() {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity updateRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            updateRecord.setBiko(new RString("びこー"));

            sut.save(updateRecord);

            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);

            assertThat(updateRecord.getBiko(), is(updatedRecord.getBiko()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test
        public void 他市町村住所地特例者台帳管理Aliveエンティティを渡すと_deleteは_他市町村住所地特例者台帳管理Aliveを削除する() {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 事業者種別,
                RString 事業者番号,
                FlexibleDate 有効開始年月日) {
            DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.setJigyoshaShubetsu(事業者種別);
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始年月日);
            sut.save(entity);
        }
    }
}
