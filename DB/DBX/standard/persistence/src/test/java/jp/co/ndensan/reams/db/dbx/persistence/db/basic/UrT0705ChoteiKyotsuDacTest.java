/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.UrT0705ChoteiKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.UrT0705ChoteiKyotsuEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;

/**
 * {@link UrT0705ChoteiKyotsuDac}のテストです。
 *
 * @author N8156 宮本 康
 */
@Ignore
@RunWith(Enclosed.class)
public class UrT0705ChoteiKyotsuDacTest extends DbxTestDacBase {

    private static UrT0705ChoteiKyotsuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(DEFAULT_調定ID);
            TestSupport.insert(DEFAULT_調定ID + 1);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            UrT0705ChoteiKyotsuEntity insertedRecord = sut.selectByKey(DEFAULT_調定ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            UrT0705ChoteiKyotsuEntity insertedRecord = sut.selectByKey(99L);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 調定共通が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(DEFAULT_調定ID);
            TestSupport.insert(DEFAULT_調定ID + 1);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 調定共通が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 調定共通エンティティを渡すと_insertは_調定共通を追加する() {
            TestSupport.insert(DEFAULT_調定ID);

            assertThat(sut.selectByKey(DEFAULT_調定ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(DEFAULT_調定ID);
        }

        @Test
        public void 調定共通エンティティを渡すと_updateは_調定共通を更新する() {
            UrT0705ChoteiKyotsuEntity updateRecord = UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity();
            updateRecord.setChoteigaku(new Decimal(9999));

            sut.update(updateRecord);

            UrT0705ChoteiKyotsuEntity updatedRecord = sut.selectByKey(DEFAULT_調定ID);

            assertThat(updateRecord.getChoteigaku(), is(updatedRecord.getChoteigaku()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(DEFAULT_調定ID);
        }

        @Test
        public void 調定共通エンティティを渡すと_deleteは_調定共通を削除する() {
            sut.delete(sut.selectByKey(DEFAULT_調定ID));
            assertThat(sut.selectByKey(DEFAULT_調定ID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(Long 調定ID) {
            UrT0705ChoteiKyotsuEntity entity = UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity();
            entity.setChoteiId(調定ID);
            sut.insert(entity);
        }
    }
}
