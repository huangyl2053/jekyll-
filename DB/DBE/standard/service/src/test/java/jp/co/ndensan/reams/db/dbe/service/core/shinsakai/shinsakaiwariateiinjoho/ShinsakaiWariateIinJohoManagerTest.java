/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho;

import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5594ShinsakaiIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5503ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link ShinsakaiWariateIinJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateIinJohoManagerTest extends DbeTestDacBase {

    private static MapperProvider provider;
    private static DbT5503ShinsakaiWariateIinJohoDac dac;
    private static ShinsakaiWariateIinJohoManager sut;
    private static ShinsakaiIinJohoManager 介護認定審査会委員情報Manager;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5503ShinsakaiWariateIinJohoDac.class);
        介護認定審査会委員情報Manager = InstanceProvider.create(ShinsakaiIinJohoManager.class);
        sut = new ShinsakaiWariateIinJohoManager(provider, dac, 介護認定審査会委員情報Manager);
    }

    public static class createInstanceのテスト extends DbeTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            ShinsakaiWariateIinJohoManager result = ShinsakaiWariateIinJohoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            ShinsakaiWariateIinJohoManager result = ShinsakaiWariateIinJohoManager.createInstance();
            assertThat(result, instanceOf(ShinsakaiWariateIinJohoManager.class));
        }
    }

    public static class get介護認定審査会割当委員情報 extends DbeTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護認定審査会割当委員情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            RString 介護認定審査会開催番号 = new RString("1");
            RString 介護認定審査会委員コード = new RString("1");
            ShinsakaiWariateIinJohoMapperParameter 介護認定審査会割当委員情報検索条件 = ShinsakaiWariateIinJohoMapperParameter.createSelectByKeyParam(介護認定審査会委員コード, 介護認定審査会委員コード);
            ShinsakaiWariateIinJoho result = sut.get介護認定審査会割当委員情報(介護認定審査会割当委員情報検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {

            RString 介護認定審査会開催番号 = new RString("1");
            RString 介護認定審査会委員コード = new RString("1");
            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(介護認定審査会開催番号, 介護認定審査会委員コード);
            sut.save介護認定審査会割当委員情報(介護認定審査会割当委員情報);
            ShinsakaiWariateIinJohoMapperParameter 介護認定審査会割当委員情報検索条件 = ShinsakaiWariateIinJohoMapperParameter.createSelectByKeyParam(介護認定審査会委員コード, 介護認定審査会委員コード);
            ShinsakaiWariateIinJoho result = sut.get介護認定審査会割当委員情報(介護認定審査会割当委員情報検索条件);

            assertThat(result, is(notNullValue()));
        }
    }
//
//    public static class save介護認定審査会割当委員情報  extends DbeTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//            介護認定審査会割当委員情報 = TestSupport.initializeSeishinTecho(介護認定審査会割当委員情報);
//            介護認定審査会割当委員情報 = TestSupport.modifiedShinsakaiWariateIinJoho(介護認定審査会割当委員情報);
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//            介護認定審査会割当委員情報 = TestSupport.initializeSeishinTecho(介護認定審査会割当委員情報);
//            介護認定審査会割当委員情報 = TestSupport.modifiedShinsakaiWariateIinJoho(介護認定審査会割当委員情報);
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//            介護認定審査会割当委員情報 = TestSupport.initializeShinsakaiWariateIinJoho(介護認定審査会割当委員情報);
//            介護認定審査会割当委員情報 = 介護認定審査会割当委員情報.deleted();
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//            介護認定審査会割当委員情報 = TestSupport.initializeShinsakaiWariateIinJoho(介護認定審査会割当委員情報);
//            介護認定審査会割当委員情報 = 介護認定審査会割当委員情報.deleted();
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当委員情報
//            when(dac.save(any(DbT5503ShinsakaiWariateIinJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会委員情報Manager.save介護認定審査会委員情報(any(ShinsakaiIinJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5503ShinsakaiWariateIinJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = TestSupport.createShinsakaiWariateIinJoho(主キー1, 主キー2);
//            介護認定審査会割当委員情報 = TestSupport.initializeShinsakaiWariateIinJoho(介護認定審査会割当委員情報);
//
//            assertThat(sut.save(介護認定審査会割当委員情報), is(false));
//        }
//    }

    private static class TestSupport {

        public static ShinsakaiWariateIinJoho createShinsakaiWariateIinJoho(RString 介護認定審査会開催番号, RString 介護認定審査会委員コード) {
            ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 = new ShinsakaiWariateIinJoho(介護認定審査会開催番号, 介護認定審査会委員コード);
            return 介護認定審査会割当委員情報.createBuilderForEdit()
                    .set介護認定審査会開催年月日(new FlexibleDate("20150402"))
                    .set介護認定審査会議長区分コード(new Code("1"))
                    .set委員出席(true)
                    .set委員遅刻有無(true)
                    .set委員出席時間(new RString("1"))
                    .set委員退席時間(new RString("1"))
                    .set委員早退有無(true)
                    // 介護認定審査会委員情報
                    .setShinsakaiIinJoho(createShinsakaiIinJoho())
                    .build();
        }

// 介護認定審査会委員情報
        private static ShinsakaiIinJoho createShinsakaiIinJoho() {
            return new ShinsakaiIinJoho(DbT5594ShinsakaiIinJohoEntityGenerator.createDbT5594ShinsakaiIinJohoEntity());
        }
//
//        public static ShinsakaiWariateIinJoho initializeShinsakaiWariateIinJoho(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
//
//            DbT5503ShinsakaiWariateIinJohoEntity techoEntity = 介護認定審査会割当委員情報.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<DbT5594ShinsakaiIinJohoEntity> ShinsakaiIinJohoEntityList = new ArrayList<>();
//            List<ShinsakaiIinJoho> 介護認定審査会委員情報リスト = XXX.getShinsakaiIinJohoList();
//            for (ShinsakaiIinJoho 介護認定審査会委員情報 : 介護認定審査会委員情報リスト) {
//                ShinsakaiIinJohoEntityList.add(介護認定審査会委員情報.toEntity());
//            }
//
//            ShinsakaiWariateIinJohoEntity relateEntity = new ShinsakaiWariateIinJohoEntity();
//            relateEntity.set介護認定審査会割当委員情報Entity(techoEntity);
//            relateEntity.set介護認定審査会委員情報Entity(ShinsakaiIinJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 介護認定審査会割当委員情報
//            return new ShinsakaiWariateIinJoho(relateEntity);
//        }
//
//        public static ShinsakaiWariateIinJoho modifiedShinsakaiWariateIinJoho(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
//
//// 介護認定審査会委員情報
//            ShinsakaiIinJohoBuilder ShinsakaiIinJohoBuilder = XXX.getShinsakaiIinJohoList().get(0).createBuilderForEdit();
//            ShinsakaiIinJoho ShinsakaiIinJoho = ShinsakaiIinJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更")) // TODO 任意項目の値を変更してください。
//                    // 介護認定審査会委員情報
//                    .setShinsakaiIinJoho(ShinsakaiIinJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
