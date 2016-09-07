/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.KibetsuBuilder;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link FukaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaManagerTest extends DbbTestDacBase {

    private static DbT2002FukaDac dac;
    private static FukaManager sut;

    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(DbT2002FukaDac.class);
        sut = FukaManager.createInstance();
        調定年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class get介護賦課 extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = FukaManager.createInstance();
            TestSupport.clearTable();
            TestSupport.insertDbT2002(賦課年度, 通知書番号, 履歴番号, 調定年度);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get介護賦課(null);
//        }
//
//        @Test
//        public void 検索結果がnullの場合() {
//
//            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createParam(調定年度, 賦課年度, new TsuchishoNo(new RString("2")), 履歴番号);
//            Fuka result = sut.get介護賦課(介護賦課検索条件);
//
//            assertThat(result, is(nullValue()));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            FukaEntity entity = new FukaEntity();
//            entity.set介護賦課Entity(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());
//            FukaMapperParameter 介護賦課検索条件 = FukaMapperParameter.createParam(調定年度, 賦課年度, 通知書番号, 履歴番号);
//            Fuka result = sut.get介護賦課(介護賦課検索条件);
//
//            assertThat(result.get調定年度(), is(DbT2002FukaEntityGenerator.DEFAULT_調定年度));
//        }
    }

//    public static class save介護賦課 extends DbbTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//
//            assertThat(sut.save(介護賦課), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//
//            assertThat(sut.save(介護賦課), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//
//            when(dac.save(any(DbT2002FukaEntity.class))).thenReturn(1);
//            when(介護期別Manager.save介護期別(any(Kibetsu.class))).thenReturn(true);
//
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課 = TestSupport.initializeFuka(介護賦課);
//            介護賦課 = TestSupport.modifiedFuka(介護賦課);
//
//            assertThat(sut.save(介護賦課), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課 = TestSupport.initializeFuka(介護賦課);
//            介護賦課 = TestSupport.modifiedFuka(介護賦課);
//
//            assertThat(sut.save(介護賦課), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課 = TestSupport.initializeFuka(介護賦課);
//            介護賦課 = 介護賦課.deleted();
//
//            assertThat(sut.save(介護賦課), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課 = TestSupport.initializeFuka(介護賦課);
//            介護賦課 = 介護賦課.deleted();
//
//            assertThat(sut.save(介護賦課), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//
//            Fuka 介護賦課 = TestSupport.createFuka(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課 = TestSupport.initializeFuka(介護賦課);
//
//            assertThat(sut.save(介護賦課), is(false));
//        }
//    }
    private static class TestSupport {

        public static Fuka createFuka(FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                int 履歴番号,
                RString 徴収方法,
                int 期) {
            Fuka 介護賦課 = new Fuka(調定年度, 賦課年度, 通知書番号, 履歴番号);
            return 介護賦課.createBuilderForEdit()
                    .setKibetsu(createKibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期))
                    .build();
        }

        private static Kibetsu createKibetsu(FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                int 履歴番号,
                RString 徴収方法,
                int 期) {
            return new Kibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
        }

        public static Fuka initializeFuka(Fuka 介護賦課) {

            DbT2002FukaEntity techoEntity = 介護賦課.toEntity();

            List<DbT2003KibetsuEntity> KibetsuEntityList = new ArrayList<>();
            List<Kibetsu> 介護期別リスト = 介護賦課.getKibetsuList();
            for (Kibetsu 介護期別 : 介護期別リスト) {
                KibetsuEntityList.add(介護期別.toEntity());
            }

            FukaEntity relateEntity = new FukaEntity();
            relateEntity.set介護賦課Entity(techoEntity);
            relateEntity.set介護期別Entity(KibetsuEntityList);
            relateEntity.initializeMd5ToEntities();

            return new Fuka(relateEntity);
        }

        public static Fuka modifiedFuka(Fuka 介護賦課) {

            KibetsuBuilder KibetsuBuilder = 介護賦課.getKibetsuList().get(0).createBuilderForEdit();
            Kibetsu Kibetsu = KibetsuBuilder.set調定ID(new Decimal("2")).build();
            介護賦課 = 介護賦課.createBuilderForEdit()
                    .set保険料段階(new RString("2"))
                    .setKibetsu(Kibetsu)
                    .build();
            return 介護賦課.modifiedModel();
        }

        public static void insertDbT2002(
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                int 履歴番号,
                FlexibleYear 調定年度) {
            DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setRirekiNo(履歴番号);
            entity.setChoteiNendo(調定年度);
            entity.setState(EntityDataState.Added);
            dac.save(entity);
        }

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT2002FukaEntity.TABLE_NAME.toString());
        }
    }
}
