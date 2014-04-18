/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定結果Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaDacTest {

    private static IchijiHanteiKekkaDac sut;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(IchijiHanteiKekkaDac.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(IchijiHanteiTestEntityCreator.create一次判定結果Entity("A000000001"));
        }

        @Test
        public void DB上のデータを取得できる() {
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A000000001"))));
        }

        @Test
        public void 存在しないデータを取得しようとした場合_nullが返る() {
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("B000000001")));
            assertThat(result, is(nullValue()));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void insertできる() {
            sut.insert(IchijiHanteiTestEntityCreator.create一次判定結果Entity("A000000001"));
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A000000001"))));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void updateできる() {
            sut.insert(IchijiHanteiTestEntityCreator.create一次判定結果Entity("A000000001", true));
            sut.update(IchijiHanteiTestEntityCreator.create一次判定結果Entity("A000000001", false));
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result.getKariIchijiHanteiKubun(), is(false));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void deleteできる() {
            sut.insert(IchijiHanteiTestEntityCreator.create一次判定結果Entity("A000000001"));
            sut.delete(IchijiHanteiTestEntityCreator.create一次判定結果Entity("A000000001"));
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result, is(nullValue()));
        }
    }
    //TODO n8178 城間篤人 insertとupdateの判別方法が決定した後にテスト作成予定 2014年3月
//    public static class insertOrUpdateのテスト extends DbeTestDacBase{
//
//    }
}
