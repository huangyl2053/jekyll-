/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho;

import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5502ShinsakaiWariateJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5503ShinsakaiWariateIinJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5511ShinsakaiKaisaiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
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
 * {link ShinsakaiKaisaiYoteiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiYoteiJohoManagerTest extends DbeTestDacBase {

    private static MapperProvider provider;
    private static DbT5501ShinsakaiKaisaiYoteiJohoDac dac;
    private static ShinsakaiKaisaiYoteiJohoManager sut;
    private static ShinsakaiKaisaiKekkaJohoManager 介護認定審査会開催結果情報Manager;
    private static ShinsakaiOnseiJohoManager 介護認定審査会音声情報Manager;
    private static ShinsakaiWariateIinJohoManager 介護認定審査会割当委員情報Manager;
    private static ShinsakaiWariateJohoManager 介護認定審査会割当情報Manager;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5501ShinsakaiKaisaiYoteiJohoDac.class);
        介護認定審査会開催結果情報Manager = InstanceProvider.create(ShinsakaiKaisaiKekkaJohoManager.class);
        介護認定審査会音声情報Manager = InstanceProvider.create(ShinsakaiOnseiJohoManager.class);
        介護認定審査会割当委員情報Manager = InstanceProvider.create(ShinsakaiWariateIinJohoManager.class);
        介護認定審査会割当情報Manager = InstanceProvider.create(ShinsakaiWariateJohoManager.class);
        sut = new ShinsakaiKaisaiYoteiJohoManager(provider, dac,
                介護認定審査会開催結果情報Manager,
                介護認定審査会音声情報Manager,
                介護認定審査会割当委員情報Manager,
                介護認定審査会割当情報Manager);
    }

    public static class createInstanceのテスト extends DbeTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            ShinsakaiKaisaiYoteiJohoManager result = ShinsakaiKaisaiYoteiJohoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            ShinsakaiKaisaiYoteiJohoManager result = ShinsakaiKaisaiYoteiJohoManager.createInstance();
            assertThat(result, instanceOf(ShinsakaiKaisaiYoteiJohoManager.class));
        }
    }

    public static class get介護認定審査会開催予定情報 extends DbeTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護認定審査会開催予定情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            RString 介護認定審査会開催番号 = new RString("1");

            ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件 = ShinsakaiKaisaiYoteiJohoMapperParameter.createSelectByKeyParam(介護認定審査会開催番号);
            ShinsakaiKaisaiYoteiJoho result = sut.get介護認定審査会開催予定情報(介護認定審査会開催予定情報検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            RString 介護認定審査会開催番号 = new RString("1");
            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(介護認定審査会開催番号);
            sut.save(介護認定審査会開催予定情報);
            ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件 = ShinsakaiKaisaiYoteiJohoMapperParameter.createSelectByKeyParam(介護認定審査会開催番号);
            ShinsakaiKaisaiYoteiJoho result = sut.get介護認定審査会開催予定情報(介護認定審査会開催予定情報検索条件);

            assertThat(result, is(notNullValue()));
        }
    }
//
//    public static class save介護認定審査会開催予定情報 extends DbeTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//            介護認定審査会開催予定情報 = TestSupport.initializeSeishinTecho(介護認定審査会開催予定情報);
//            介護認定審査会開催予定情報 = TestSupport.modifiedShinsakaiKaisaiYoteiJoho(介護認定審査会開催予定情報);
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//            介護認定審査会開催予定情報 = TestSupport.initializeSeishinTecho(介護認定審査会開催予定情報);
//            介護認定審査会開催予定情報 = TestSupport.modifiedShinsakaiKaisaiYoteiJoho(介護認定審査会開催予定情報);
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//            介護認定審査会開催予定情報 = TestSupport.initializeShinsakaiKaisaiYoteiJoho(介護認定審査会開催予定情報);
//            介護認定審査会開催予定情報 = 介護認定審査会開催予定情報.deleted();
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//            介護認定審査会開催予定情報 = TestSupport.initializeShinsakaiKaisaiYoteiJoho(介護認定審査会開催予定情報);
//            介護認定審査会開催予定情報 = 介護認定審査会開催予定情報.deleted();
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会開催予定情報
//            when(dac.save(any(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class))).thenReturn(1);
//            when(介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(any(ShinsakaiKaisaiKekkaJoho.class))).thenReturn(1);
//            when(介護認定審査会音声情報Manager.save介護認定審査会音声情報(any(ShinsakaiOnseiJoho.class))).thenReturn(1);
//            when(介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(any(ShinsakaiWariateIinJoho.class))).thenReturn(1);
//            when(介護認定審査会割当情報Manager.save介護認定審査会割当情報(any(ShinsakaiWariateJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = TestSupport.createShinsakaiKaisaiYoteiJoho(主キー1, 主キー2);
//            介護認定審査会開催予定情報 = TestSupport.initializeShinsakaiKaisaiYoteiJoho(介護認定審査会開催予定情報);
//
//            assertThat(sut.save(介護認定審査会開催予定情報), is(false));
//        }
//    }

    private static class TestSupport {

        public static ShinsakaiKaisaiYoteiJoho createShinsakaiKaisaiYoteiJoho(RString 介護認定審査会開催番号) {
            ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報 = new ShinsakaiKaisaiYoteiJoho(介護認定審査会開催番号);
            return 介護認定審査会開催予定情報.createBuilderForEdit()
                    .set介護認定審査会開催予定年月日(new FlexibleDate("20150402"))
                    .set介護認定審査会開始予定時刻(new RString("1"))
                    .set介護認定審査会終了予定時刻(new RString("1"))
                    .set介護認定審査会開催予定場所コード(new RString("1"))
                    .set合議体番号(2)
                    .set介護認定審査会予定定員(3)
                    .set介護認定審査会最大定員(4)
                    .set介護認定審査会委員定員(5)
                    .set介護認定審査会進捗状況(new Code("1"))
                    .set介護認定審査会割当済み人数(6)
                    // 介護認定審査会開催結果情報
                    .setShinsakaiKaisaiKekkaJoho(createShinsakaiKaisaiKekkaJoho())
                    // 介護認定審査会音声情報
                    .setShinsakaiOnseiJoho(createShinsakaiOnseiJoho())
                    // 介護認定審査会割当委員情報
                    .setShinsakaiWariateIinJoho(createShinsakaiWariateIinJoho())
                    // 介護認定審査会割当情報
                    .setShinsakaiWariateJoho(createShinsakaiWariateJoho())
                    .build();
        }

// 介護認定審査会開催結果情報
        private static ShinsakaiKaisaiKekkaJoho createShinsakaiKaisaiKekkaJoho() {
            return new ShinsakaiKaisaiKekkaJoho(DbT5511ShinsakaiKaisaiKekkaJohoEntityGenerator.createDbT5511ShinsakaiKaisaiKekkaJohoEntity());
        }
// 介護認定審査会音声情報

        private static ShinsakaiOnseiJoho createShinsakaiOnseiJoho() {
            return new ShinsakaiOnseiJoho(DbT5512ShinsakaiOnseiJohoEntityGenerator.createDbT5512ShinsakaiOnseiJohoEntity());
        }
// 介護認定審査会割当委員情報

        private static ShinsakaiWariateIinJoho createShinsakaiWariateIinJoho() {
            ShinsakaiWariateIinJohoRelateEntity entity = new ShinsakaiWariateIinJohoRelateEntity();
            entity.set介護認定審査会割当委員情報Entity(DbT5503ShinsakaiWariateIinJohoEntityGenerator.createDbT5503ShinsakaiWariateIinJohoEntity());
            return new ShinsakaiWariateIinJoho(entity);
        }
// 介護認定審査会割当情報

        private static ShinsakaiWariateJoho createShinsakaiWariateJoho() {
            ShinsakaiWariateJohoRelateEntity entity = new ShinsakaiWariateJohoRelateEntity();
            entity.set介護認定審査会割当情報Entity(DbT5502ShinsakaiWariateJohoEntityGenerator.createDbT5502ShinsakaiWariateJohoEntity());
            return new ShinsakaiWariateJoho(entity);
        }
//
//        public static ShinsakaiKaisaiYoteiJoho initializeShinsakaiKaisaiYoteiJoho(ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報) {
//
//            DbT5501ShinsakaiKaisaiYoteiJohoEntity techoEntity = 介護認定審査会開催予定情報.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<DbT5511ShinsakaiKaisaiKekkaJohoEntity> ShinsakaiKaisaiKekkaJohoEntityList = new ArrayList<>();
//            List<ShinsakaiKaisaiKekkaJoho> 介護認定審査会開催結果情報リスト = XXX.getShinsakaiKaisaiKekkaJohoList();
//            for (ShinsakaiKaisaiKekkaJoho 介護認定審査会開催結果情報 : 介護認定審査会開催結果情報リスト) {
//                ShinsakaiKaisaiKekkaJohoEntityList.add(介護認定審査会開催結果情報.toEntity());
//            }
//            List<DbT5512ShinsakaiOnseiJohoEntity> ShinsakaiOnseiJohoEntityList = new ArrayList<>();
//            List<ShinsakaiOnseiJoho> 介護認定審査会音声情報リスト = XXX.getShinsakaiOnseiJohoList();
//            for (ShinsakaiOnseiJoho 介護認定審査会音声情報 : 介護認定審査会音声情報リスト) {
//                ShinsakaiOnseiJohoEntityList.add(介護認定審査会音声情報.toEntity());
//            }
//            List<ShinsakaiWariateIinJohoEntity> ShinsakaiWariateIinJohoEntityList = new ArrayList<>();
//            List<ShinsakaiWariateIinJoho> 介護認定審査会割当委員情報リスト = XXX.getShinsakaiWariateIinJohoList();
//            for (ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 : 介護認定審査会割当委員情報リスト) {
//                ShinsakaiWariateIinJohoEntityList.add(介護認定審査会割当委員情報.toEntity());
//            }
//            List<ShinsakaiWariateJohoEntity> ShinsakaiWariateJohoEntityList = new ArrayList<>();
//            List<ShinsakaiWariateJoho> 介護認定審査会割当情報リスト = XXX.getShinsakaiWariateJohoList();
//            for (ShinsakaiWariateJoho 介護認定審査会割当情報 : 介護認定審査会割当情報リスト) {
//                ShinsakaiWariateJohoEntityList.add(介護認定審査会割当情報.toEntity());
//            }
//
//            ShinsakaiKaisaiYoteiJohoEntity relateEntity = new ShinsakaiKaisaiYoteiJohoEntity();
//            relateEntity.set介護認定審査会開催予定情報Entity(techoEntity);
//            relateEntity.set介護認定審査会開催結果情報Entity(ShinsakaiKaisaiKekkaJohoEntityList);
//            relateEntity.set介護認定審査会音声情報Entity(ShinsakaiOnseiJohoEntityList);
//            relateEntity.set介護認定審査会割当委員情報Entity(ShinsakaiWariateIinJohoEntityList);
//            relateEntity.set介護認定審査会割当情報Entity(ShinsakaiWariateJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 介護認定審査会開催予定情報
//            return new ShinsakaiKaisaiYoteiJoho(relateEntity);
//        }
//
//        public static ShinsakaiKaisaiYoteiJoho modifiedShinsakaiKaisaiYoteiJoho(ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報) {
//
//// 介護認定審査会開催結果情報
//            ShinsakaiKaisaiKekkaJohoBuilder ShinsakaiKaisaiKekkaJohoBuilder = XXX.getShinsakaiKaisaiKekkaJohoList().get(0).createBuilderForEdit();
//            ShinsakaiKaisaiKekkaJoho ShinsakaiKaisaiKekkaJoho = ShinsakaiKaisaiKekkaJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// 介護認定審査会音声情報
//            ShinsakaiOnseiJohoBuilder ShinsakaiOnseiJohoBuilder = XXX.getShinsakaiOnseiJohoList().get(0).createBuilderForEdit();
//            ShinsakaiOnseiJoho ShinsakaiOnseiJoho = ShinsakaiOnseiJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// 介護認定審査会割当委員情報
//            ShinsakaiWariateIinJohoBuilder ShinsakaiWariateIinJohoBuilder = XXX.getShinsakaiWariateIinJohoList().get(0).createBuilderForEdit();
//            ShinsakaiWariateIinJoho ShinsakaiWariateIinJoho = ShinsakaiWariateIinJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// 介護認定審査会割当情報
//            ShinsakaiWariateJohoBuilder ShinsakaiWariateJohoBuilder = XXX.getShinsakaiWariateJohoList().get(0).createBuilderForEdit();
//            ShinsakaiWariateJoho ShinsakaiWariateJoho = ShinsakaiWariateJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更")) // TODO 任意項目の値を変更してください。
//                    // 介護認定審査会開催結果情報
//                    .setShinsakaiKaisaiKekkaJoho(ShinsakaiKaisaiKekkaJoho)
//                    // 介護認定審査会音声情報
//                    .setShinsakaiOnseiJoho(ShinsakaiOnseiJoho)
//                    // 介護認定審査会割当委員情報
//                    .setShinsakaiWariateIinJoho(ShinsakaiWariateIinJoho)
//                    // 介護認定審査会割当情報
//                    .setShinsakaiWariateJoho(ShinsakaiWariateJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
