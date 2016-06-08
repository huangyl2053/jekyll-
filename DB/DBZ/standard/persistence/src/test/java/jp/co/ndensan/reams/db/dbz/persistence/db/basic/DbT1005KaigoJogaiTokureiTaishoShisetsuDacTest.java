/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT1005KaigoJogaiTokureiTaishoShisetsuDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT1005KaigoJogaiTokureiTaishoShisetsuDacTest extends DbzTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT1005KaigoJogaiTokureiTaishoShisetsuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

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
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護除外住所地特例対象施設が存在する場合_selectAllは_全件を返す() {
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
        public void 介護除外住所地特例対象施設が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護除外住所地特例対象施設エンティティを渡すと_insertは_介護除外住所地特例対象施設を追加する() {
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

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test
        public void 介護除外住所地特例対象施設エンティティを渡すと_updateは_介護除外住所地特例対象施設を更新する() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity updateRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
            updateRecord.setJigyoshaNo(new RString("11"));

            sut.save(updateRecord);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);

            assertThat(updateRecord.getJigyoshaNo(), is(updatedRecord.getJigyoshaNo()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者種別,
                    DEFAULT_事業者番号,
                    DEFAULT_有効開始年月日);
        }

        @Test
        public void 介護除外住所地特例対象施設エンティティを渡すと_deleteは_介護除外住所地特例対象施設を削除する() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity deletedEntity = sut.selectByKey(
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
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.setJigyoshaShubetsu(事業者種別);
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始年月日);
            sut.save(entity);
        }
    }
}
