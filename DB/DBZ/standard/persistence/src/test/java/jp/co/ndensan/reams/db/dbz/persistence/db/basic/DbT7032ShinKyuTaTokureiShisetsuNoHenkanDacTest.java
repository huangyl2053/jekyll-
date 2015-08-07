/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7032ShinKyuTaTokureiShisetsuNoHenkanDacTest extends DbzTestDacBase {

    private static final RString キー_01 = DEFAULT_キー;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧他特例施設番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 新旧他特例施設番号変換テーブルが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 新旧他特例施設番号変換テーブルが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 新旧他特例施設番号変換テーブルエンティティを渡すと_insertは_新旧他特例施設番号変換テーブルを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
        }

        @Test
        public void 新旧他特例施設番号変換テーブルエンティティを渡すと_updateは_新旧他特例施設番号変換テーブルを更新する() {
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);

            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
        }

        @Test
        public void 新旧他特例施設番号変換テーブルエンティティを渡すと_deleteは_新旧他特例施設番号変換テーブルを削除する() {
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧他特例施設番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 旧他特例施設番号) {
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity = DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.createDbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity();
            entity.setShichosonCode(市町村コード);
            entity.setKyuTaTokureiShisetsuNo(旧他特例施設番号);
            sut.save(entity);
        }
    }
}
