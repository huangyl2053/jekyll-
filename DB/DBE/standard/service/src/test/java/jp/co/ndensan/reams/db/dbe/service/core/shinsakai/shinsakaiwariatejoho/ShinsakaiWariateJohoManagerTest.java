/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho;

import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariatejoho.ShinsakaiWariateJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5502ShinsakaiWariateJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
 * {link ShinsakaiWariateJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateJohoManagerTest extends DbeTestDacBase {

    private static MapperProvider provider;
    private static DbT5502ShinsakaiWariateJohoDac dac;
    private static ShinsakaiWariateJohoManager sut;
    private static NinteiShinseiJohoManager 要介護認定申請情報Manager;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
        要介護認定申請情報Manager = InstanceProvider.create(NinteiShinseiJohoManager.class);
        sut = new ShinsakaiWariateJohoManager(provider, dac, 要介護認定申請情報Manager);
    }

    public static class createInstanceのテスト extends DbeTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            ShinsakaiWariateJohoManager result = ShinsakaiWariateJohoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            ShinsakaiWariateJohoManager result = ShinsakaiWariateJohoManager.createInstance();
            assertThat(result, instanceOf(ShinsakaiWariateJohoManager.class));
        }
    }

    public static class get介護認定審査会割当情報 extends DbeTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護認定審査会割当情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            RString 介護認定審査会開催番号 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
            ShinseishoKanriNo 申請書管理番号 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_申請書管理番号;

            ShinsakaiWariateJohoMapperParameter 介護認定審査会割当情報検索条件 = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(介護認定審査会開催番号, 申請書管理番号);
            ShinsakaiWariateJoho result = sut.get介護認定審査会割当情報(介護認定審査会割当情報検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {

            RString 介護認定審査会開催番号 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
            ShinseishoKanriNo 申請書管理番号 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_申請書管理番号;
            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(介護認定審査会開催番号, 申請書管理番号);

            sut.save介護認定審査会割当情報(介護認定審査会割当情報);

            ShinsakaiWariateJohoMapperParameter 介護認定審査会割当情報検索条件 = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(介護認定審査会開催番号, 申請書管理番号);
            ShinsakaiWariateJoho result = sut.get介護認定審査会割当情報(介護認定審査会割当情報検索条件);

            assertThat(result, is(notNullValue()));
        }
    }
//
//    public static class save介護認定審査会割当情報 extends DbeTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(介護認定審査会割当情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(介護認定審査会割当情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//            介護認定審査会割当情報 = TestSupport.initializeSeishinTecho(介護認定審査会割当情報);
//            介護認定審査会割当情報 = TestSupport.modifiedShinsakaiWariateJoho(介護認定審査会割当情報);
//
//            assertThat(sut.save(介護認定審査会割当情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//            介護認定審査会割当情報 = TestSupport.initializeSeishinTecho(介護認定審査会割当情報);
//            介護認定審査会割当情報 = TestSupport.modifiedShinsakaiWariateJoho(介護認定審査会割当情報);
//
//            assertThat(sut.save(介護認定審査会割当情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//            介護認定審査会割当情報 = TestSupport.initializeShinsakaiWariateJoho(介護認定審査会割当情報);
//            介護認定審査会割当情報 = 介護認定審査会割当情報.deleted();
//
//            assertThat(sut.save(介護認定審査会割当情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//            介護認定審査会割当情報 = TestSupport.initializeShinsakaiWariateJoho(介護認定審査会割当情報);
//            介護認定審査会割当情報 = 介護認定審査会割当情報.deleted();
//
//            assertThat(sut.save(介護認定審査会割当情報), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 介護認定審査会割当情報
//            when(dac.save(any(DbT5502ShinsakaiWariateJohoEntity.class))).thenReturn(1);
//            when(要介護認定申請情報Manager.save要介護認定申請情報(any(NinteiShinseiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5502ShinsakaiWariateJohoEntityGenerator.DEFAULT_主キー2;
//            ShinsakaiWariateJoho 介護認定審査会割当情報 = TestSupport.createShinsakaiWariateJoho(主キー1, 主キー2);
//            介護認定審査会割当情報 = TestSupport.initializeShinsakaiWariateJoho(介護認定審査会割当情報);
//
//            assertThat(sut.save(介護認定審査会割当情報), is(false));
//        }
//    }
//

    private static class TestSupport {

        public static ShinsakaiWariateJoho createShinsakaiWariateJoho(RString 介護認定審査会開催番号, ShinseishoKanriNo 申請書管理番号) {
            ShinsakaiWariateJoho 介護認定審査会割当情報 = new ShinsakaiWariateJoho(介護認定審査会開催番号, 申請書管理番号);
            return 介護認定審査会割当情報.createBuilderForEdit()
                    .set介護認定審査会開催年月日(new FlexibleDate("20150402"))
                    .set介護認定審査会割当年月日(new FlexibleDate("20150402"))
                    .set介護認定審査会審査順(1)
                    .set介護認定審査会審査順確定フラグ(true)
                    .set審査会自動割付フラグ(true)
                    // 要介護認定申請情報
                    .setNinteiShinseiJoho(createNinteiShinseiJoho())
                    .build();
        }

// 要介護認定申請情報
        private static NinteiShinseiJoho createNinteiShinseiJoho() {
            return new NinteiShinseiJoho(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());
        }
//
//        public static ShinsakaiWariateJoho initializeShinsakaiWariateJoho(ShinsakaiWariateJoho 介護認定審査会割当情報) {
//
//            DbT5502ShinsakaiWariateJohoEntity techoEntity = 介護認定審査会割当情報.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<DbT5101NinteiShinseiJohoEntity> NinteiShinseiJohoEntityList = new ArrayList<>();
//            List<NinteiShinseiJoho> 要介護認定申請情報リスト = XXX.getNinteiShinseiJohoList();
//            for (NinteiShinseiJoho 要介護認定申請情報 : 要介護認定申請情報リスト) {
//                NinteiShinseiJohoEntityList.add(要介護認定申請情報.toEntity());
//            }
//
//            ShinsakaiWariateJohoEntity relateEntity = new ShinsakaiWariateJohoEntity();
//            relateEntity.set介護認定審査会割当情報Entity(techoEntity);
//            relateEntity.set要介護認定申請情報Entity(NinteiShinseiJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 介護認定審査会割当情報
//            return new ShinsakaiWariateJoho(relateEntity);
//        }
//
//        public static ShinsakaiWariateJoho modifiedShinsakaiWariateJoho(ShinsakaiWariateJoho 介護認定審査会割当情報) {
//
//// 要介護認定申請情報
//            NinteiShinseiJohoBuilder NinteiShinseiJohoBuilder = XXX.getNinteiShinseiJohoList().get(0).createBuilderForEdit();
//            NinteiShinseiJoho NinteiShinseiJoho = NinteiShinseiJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更")) // TODO 任意項目の値を変更してください。
//                    // 要介護認定申請情報
//                    .setNinteiShinseiJoho(NinteiShinseiJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
