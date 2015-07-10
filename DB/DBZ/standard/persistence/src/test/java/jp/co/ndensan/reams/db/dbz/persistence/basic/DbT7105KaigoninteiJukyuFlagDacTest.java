/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7105KaigoninteiJukyuFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7105KaigoninteiJukyuFlagEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7105KaigoninteiJukyuFlagDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7105KaigoninteiJukyuFlagDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7105KaigoninteiJukyuFlagDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7105KaigoninteiJukyuFlagDac.class);
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護認定受給フラグが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert();
            TestSupport.insert();
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護認定受給フラグが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護認定受給フラグエンティティを渡すと_insertは_介護認定受給フラグを追加する() {
            TestSupport.insert();

            assertThat(sut.selectAll().get(0), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert();
        }

        @Test
        public void 介護認定受給フラグエンティティを渡すと_updateは_介護認定受給フラグを更新する() {
            DbT7105KaigoninteiJukyuFlagEntity updateRecord = DbT7105KaigoninteiJukyuFlagEntityGenerator.createDbT7105KaigoninteiJukyuFlagEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

//            sut.update(updateRecord);
            DbT7105KaigoninteiJukyuFlagEntity updatedRecord = sut.selectAll().get(0);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

//    public static class deleteのテスト extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert();
//        }
//
//        @Test
//        public void 介護認定受給フラグエンティティを渡すと_deleteは_介護認定受給フラグを削除する() {
//            DbT7105KaigoninteiJukyuFlagEntity deleteRecord = DbT7105KaigoninteiJukyuFlagEntityGenerator.createDbT7105KaigoninteiJukyuFlagEntity();
//
//            sut.delete(deleteRecord);
//            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
//        }
//    }
    private static class TestSupport {

        public static void insert() {
            DbT7105KaigoninteiJukyuFlagEntity entity = DbT7105KaigoninteiJukyuFlagEntityGenerator.createDbT7105KaigoninteiJukyuFlagEntity();

            sut.insert(entity);
        }
    }
}
