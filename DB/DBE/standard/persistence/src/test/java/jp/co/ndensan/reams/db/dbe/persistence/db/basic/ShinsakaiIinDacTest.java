/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

//import jp.co.ndensan.reams.db.dbe.persistence.db.relate.helper.ShinsakaiIinDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
@Ignore
public class ShinsakaiIinDacTest {

    private static ShinsakaiIinDac shinsakaiIinDac;
//    private static ShinsakaiIinDacMock shinsakaiIinDacMock;

    @BeforeClass
    public static void setUpBeforeClass() {
        shinsakaiIinDac = InstanceProvider.create(ShinsakaiIinDac.class);
//        shinsakaiIinDacMock = InstanceProvider.create(ShinsakaiIinDacMock.class);
    }

    public static class select審査会委員_引数に審査会委員コードを渡した場合のテスト extends DbeTestDacBase {

        @Test
        public void noTest() {
            //TODO n8178 城間篤人 審査会委員の本実装の際にテストを作成予定 2014年9月末
        }
    }

    public static class select審査会委員_引数に審査会委員コードListを渡した場合のテスト extends DbeTestDacBase {

        @Test
        public void noTest() {
            //TODO n8178 城間篤人 審査会委員の本実装の際にテストを作成予定 2014年9月末
        }
    }

    public static class select有効審査会委員のテスト extends DbeTestDacBase {

        //TODO n8178 城間篤人 画面動作のテストのために、DBに項目を追加した影響を受けテストが意図した動作をしない。対応方法不明 2014年9月
//        @Before
//        public void setUp() {
//            shinsakaiIinDacMock.insert(ShinsakaiMockEntityCreator.create審査会委員Entity("00000001", true));
//            shinsakaiIinDacMock.insert(ShinsakaiMockEntityCreator.create審査会委員Entity("00000002", false));
//            shinsakaiIinDacMock.insert(ShinsakaiMockEntityCreator.create審査会委員Entity("00000003", true));
//            shinsakaiIinDacMock.insert(ShinsakaiMockEntityCreator.create審査会委員Entity("00000004", false));
//            shinsakaiIinDacMock.insert(ShinsakaiMockEntityCreator.create審査会委員Entity("00000005", false));
//        }
//
//        @Test
//        public void DB上に5件のデータが存在し_内2件の情報について委員状況がtrueの場合_2件のリストが返る() {
//            List<DbT5102ShinsakaiIinJohoEntity> sut = shinsakaiIinDac.select有効審査会委員List();
//            assertThat(sut.size(), is(2));
//        }
        @Test
        public void noTest() {

        }
    }

}
