/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiiiryokikanjoho;

import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5912ShujiiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiijoho.ShujiiJohoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {link ShujiiIryoKikanJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanJohoManagerTest extends DbeTestDacBase {

    private static MapperProvider provider;
    private static DbT5911ShujiiIryoKikanJohoDac dac;
    private static ShujiiIryoKikanJohoManager sut;
    private static ShujiiJohoManager 主治医情報Manager;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        主治医情報Manager = InstanceProvider.create(ShujiiJohoManager.class);
        sut = new ShujiiIryoKikanJohoManager(provider, dac, 主治医情報Manager);
    }

    public static class createInstanceのテスト extends DbeTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            ShujiiIryoKikanJohoManager result = ShujiiIryoKikanJohoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            ShujiiIryoKikanJohoManager result = ShujiiIryoKikanJohoManager.createInstance();
            assertThat(result, instanceOf(ShujiiIryoKikanJohoManager.class));
        }
    }

    public static class get主治医医療機関情報 extends DbeTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get主治医医療機関情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            LasdecCode 市町村コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード;
            RString 主治医医療機関コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード;
            ShujiiIryoKikanJohoMapperParameter 主治医医療機関情報検索条件 = ShujiiIryoKikanJohoMapperParameter.createSelectByKeyParam(市町村コード, 主治医医療機関コード);

            ShujiiIryoKikanJoho result = sut.get主治医医療機関情報(主治医医療機関情報検索条件);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {

            LasdecCode 市町村コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード;
            RString 主治医医療機関コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード;

            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(市町村コード, 主治医医療機関コード);
            sut.save(主治医医療機関情報);

            ShujiiIryoKikanJohoMapperParameter 主治医医療機関情報検索条件 = ShujiiIryoKikanJohoMapperParameter.createSelectByKeyParam(市町村コード, 主治医医療機関コード);

            ShujiiIryoKikanJoho result = sut.get主治医医療機関情報(主治医医療機関情報検索条件);

            assertThat(result, is(notNullValue()));
        }
    }
//
//    public static class save主治医医療機関情報  extends DbeTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(主治医医療機関情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(主治医医療機関情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//            主治医医療機関情報 = TestSupport.initializeSeishinTecho(主治医医療機関情報);
//            主治医医療機関情報 = TestSupport.modifiedShujiiIryoKikanJoho(主治医医療機関情報);
//
//            assertThat(sut.save(主治医医療機関情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//            主治医医療機関情報 = TestSupport.initializeSeishinTecho(主治医医療機関情報);
//            主治医医療機関情報 = TestSupport.modifiedShujiiIryoKikanJoho(主治医医療機関情報);
//
//            assertThat(sut.save(主治医医療機関情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//            主治医医療機関情報 = TestSupport.initializeShujiiIryoKikanJoho(主治医医療機関情報);
//            主治医医療機関情報 = 主治医医療機関情報.deleted();
//
//            assertThat(sut.save(主治医医療機関情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//            主治医医療機関情報 = TestSupport.initializeShujiiIryoKikanJoho(主治医医療機関情報);
//            主治医医療機関情報 = 主治医医療機関情報.deleted();
//
//            assertThat(sut.save(主治医医療機関情報), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 主治医医療機関情報
//            when(dac.save(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
//            when(主治医情報Manager.save主治医情報(any(ShujiiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主キー2;
//            ShujiiIryoKikanJoho 主治医医療機関情報 = TestSupport.createShujiiIryoKikanJoho(主キー1, 主キー2);
//            主治医医療機関情報 = TestSupport.initializeShujiiIryoKikanJoho(主治医医療機関情報);
//
//            assertThat(sut.save(主治医医療機関情報), is(false));
//        }
//    }

    private static class TestSupport {

        public static ShujiiIryoKikanJoho createShujiiIryoKikanJoho(LasdecCode 市町村コード,
                RString 主治医医療機関コード) {
            ShujiiIryoKikanJoho 主治医医療機関情報 = new ShujiiIryoKikanJoho(市町村コード, 主治医医療機関コード);
            return 主治医医療機関情報.createBuilderForEdit()
                    // 主治医情報
                    .setShujiiJoho(createShujiiJoho())
                    .build();
        }

// 主治医情報
        private static ShujiiJoho createShujiiJoho() {
            return new ShujiiJoho(DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity());
        }
//
//        public static ShujiiIryoKikanJoho initializeShujiiIryoKikanJoho(ShujiiIryoKikanJoho 主治医医療機関情報) {
//
//            DbT5911ShujiiIryoKikanJohoEntity techoEntity = 主治医医療機関情報.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<DbT5912ShujiiJohoEntity> ShujiiJohoEntityList = new ArrayList<>();
//            List<ShujiiJoho> 主治医情報リスト = XXX.getShujiiJohoList();
//            for (ShujiiJoho 主治医情報 : 主治医情報リスト) {
//                ShujiiJohoEntityList.add(主治医情報.toEntity());
//            }
//
//            ShujiiIryoKikanJohoEntity relateEntity = new ShujiiIryoKikanJohoEntity();
//            relateEntity.set主治医医療機関情報Entity(techoEntity);
//            relateEntity.set主治医情報Entity(ShujiiJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 主治医医療機関情報
//            return new ShujiiIryoKikanJoho(relateEntity);
//        }
//
//        public static ShujiiIryoKikanJoho modifiedShujiiIryoKikanJoho(ShujiiIryoKikanJoho 主治医医療機関情報) {
//
//// 主治医情報
//            ShujiiJohoBuilder ShujiiJohoBuilder = XXX.getShujiiJohoList().get(0).createBuilderForEdit();
//            ShujiiJoho ShujiiJoho = ShujiiJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更")) // TODO 任意項目の値を変更してください。
//                    // 主治医情報
//                    .setShujiiJoho(ShujiiJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
