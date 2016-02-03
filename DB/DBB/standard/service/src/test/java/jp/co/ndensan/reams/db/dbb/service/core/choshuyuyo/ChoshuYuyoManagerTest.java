/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.ChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.KibetsuChoshuYuyoBuilder;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link ChoshuYuyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoManagerTest extends DbbTestDacBase {

    private static DbT2006ChoshuYuyoDac dac;
    private static ChoshuYuyoManager sut;
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void test() {

        dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
        調定年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class get介護賦課徴収猶予 extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = ChoshuYuyoManager.createInstance();
            TestSupport.clearTable();
            TestSupport.insertDbT2006(賦課年度, 通知書番号, 履歴番号, 調定年度);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護賦課徴収猶予(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createParam(調定年度, 賦課年度, new TsuchishoNo(new RString("2")), 履歴番号);
            ChoshuYuyo result = sut.get介護賦課徴収猶予(介護賦課徴収猶予検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            ChoshuYuyoEntity entity = new ChoshuYuyoEntity();
            entity.set介護賦課徴収猶予Entity(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity());

            ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件 = ChoshuYuyoMapperParameter.createParam(調定年度, 賦課年度, 通知書番号, 履歴番号);
            ChoshuYuyo result = sut.get介護賦課徴収猶予(介護賦課徴収猶予検索条件);

            assertThat(result.get調定年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }
    }

//    public static class save介護賦課徴収猶予 extends DbbTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//
//            assertThat(sut.save(介護賦課徴収猶予), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//
//            assertThat(sut.save(介護賦課徴収猶予), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
//            介護賦課徴収猶予 = TestSupport.modifiedChoshuYuyo(介護賦課徴収猶予);
//
//            assertThat(sut.save(介護賦課徴収猶予), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
//            介護賦課徴収猶予 = TestSupport.modifiedChoshuYuyo(介護賦課徴収猶予);
//
//            assertThat(sut.save(介護賦課徴収猶予), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
//            介護賦課徴収猶予 = 介護賦課徴収猶予.deleted();
//
//            assertThat(sut.save(介護賦課徴収猶予), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
//            介護賦課徴収猶予 = 介護賦課徴収猶予.deleted();
//
//            assertThat(sut.save(介護賦課徴収猶予), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//            ChoshuYuyo 介護賦課徴収猶予 = TestSupport.createChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
//            介護賦課徴収猶予 = TestSupport.initializeChoshuYuyo(介護賦課徴収猶予);
//
//            assertThat(sut.save(介護賦課徴収猶予), is(false));
//        }
//    }
    private static class TestSupport {

        public static ChoshuYuyo createChoshuYuyo(FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                Decimal 履歴番号,
                RString 徴収方法,
                int 期) {
            ChoshuYuyo 介護賦課徴収猶予 = new ChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号);
            return 介護賦課徴収猶予.createBuilderForEdit()
                    .setKibetsuChoshuYuyo(createKibetsuChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期))
                    .build();
        }

        private static KibetsuChoshuYuyo createKibetsuChoshuYuyo(FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                Decimal 履歴番号,
                RString 徴収方法,
                int 期) {
            return new KibetsuChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
        }

        public static ChoshuYuyo initializeChoshuYuyo(ChoshuYuyo 介護賦課徴収猶予) {

            DbT2006ChoshuYuyoEntity techoEntity = 介護賦課徴収猶予.toEntity();

            List<DbT2007KibetsuChoshuYuyoEntity> KibetsuChoshuYuyoEntityList = new ArrayList<>();
            List<KibetsuChoshuYuyo> 介護期別徴収猶予リスト = 介護賦課徴収猶予.getKibetsuChoshuYuyoList();
            for (KibetsuChoshuYuyo 介護期別徴収猶予 : 介護期別徴収猶予リスト) {
                KibetsuChoshuYuyoEntityList.add(介護期別徴収猶予.toEntity());
            }

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(techoEntity);
            relateEntity.set介護期別徴収猶予Entity(KibetsuChoshuYuyoEntityList);
            relateEntity.initializeMd5ToEntities();

            return new ChoshuYuyo(relateEntity);
        }

        public static ChoshuYuyo modifiedChoshuYuyo(ChoshuYuyo 介護賦課徴収猶予) {

            KibetsuChoshuYuyoBuilder KibetsuChoshuYuyoBuilder = 介護賦課徴収猶予.getKibetsuChoshuYuyoList().get(0).createBuilderForEdit();
            KibetsuChoshuYuyo KibetsuChoshuYuyo = KibetsuChoshuYuyoBuilder.set徴収猶予終了日(new FlexibleDate("20151010")).build();
            介護賦課徴収猶予 = 介護賦課徴収猶予.createBuilderForEdit()
                    .set徴収猶予事由(new RString("交付備考を変更"))
                    .setKibetsuChoshuYuyo(KibetsuChoshuYuyo)
                    .build();
            return 介護賦課徴収猶予.modifiedModel();
        }

        public static void insertDbT2006(
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                Decimal 履歴番号,
                FlexibleYear 調定年度) {
            DbT2006ChoshuYuyoEntity entity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setRirekiNo(履歴番号);
            entity.setChoteiNendo(調定年度);
            entity.setState(EntityDataState.Added);
            dac.save(entity);
        }

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT2006ChoshuYuyoEntity.TABLE_NAME.toString());
        }
    }
}
