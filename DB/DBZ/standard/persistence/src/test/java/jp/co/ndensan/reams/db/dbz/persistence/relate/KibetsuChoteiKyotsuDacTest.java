/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.UrT0705ChoteiKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.model.ChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.model.KibetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.UrT0705ChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * {@link KibetsuChoteiKyotsuDac}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KibetsuChoteiKyotsuDacTest {

    private static KibetsuChoteiKyotsuDac sut;
    private static DbT2003KibetsuDac 介護期別Dac;
    private static UrT0705ChoteiKyotsuDac 調定共通Dac;

    private static final FlexibleYear 調定年度 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
    private static final FlexibleYear 賦課年度 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
    private static final TsuchishoNo 通知書番号 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
    private static final RDateTime 処理日時 = DbT2003KibetsuEntityGenerator.DEFAULT_処理日時;
    private static final RString 徴収方法 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
    private static final int 期 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
    private static final Long 調定ID = UrT0705ChoteiKyotsuEntityGenerator.DEFAULT_調定ID;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KibetsuChoteiKyotsuDac.class);
        介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
        調定共通Dac = InstanceProvider.create(UrT0705ChoteiKyotsuDac.class);
    }

    public static class select介護期別調定共通ByKeyTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            for (int i = 0; i < 4; i++) {
                TestSupport.insertDbT2003(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期 + i);
                TestSupport.insertUrT0705(調定ID + i);
            }
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通ByKey(null, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通ByKey(調定年度, null, 通知書番号, 処理日時, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通ByKey(調定年度, 賦課年度, null, 処理日時, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, null, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の徴収方法にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, 処理日時, null, 期);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護期別調定共通モデル返す() {
            assertThat(sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期).get介護期別モデル().get期(), is(期));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 99), is(nullValue()));
        }
    }

    public static class select介護期別調定共通一覧Test extends DbbTestDacBase {

        @Before
        public void setUp() {
            for (int i = 0; i < 4; i++) {
                TestSupport.insertDbT2003(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期 + i);
                TestSupport.insertUrT0705(調定ID + i);
            }
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通一覧(null, 賦課年度, 通知書番号, 処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通一覧(調定年度, null, 通知書番号, 処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通一覧(調定年度, 賦課年度, null, 処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護期別調定共通一覧(調定年度, 賦課年度, 通知書番号, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_介護期別調定共通リストを返す() {
            List<KibetsuChoteiKyotsuModel> modelList = sut.select介護期別調定共通一覧(調定年度, 賦課年度, 通知書番号, 処理日時);
            assertThat(modelList.size(), is(4));
            assertThat(modelList.get(0).get介護期別モデル().get期(), is(期));
            assertThat(modelList.get(1).get介護期別モデル().get期(), is(期 + 1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select介護期別調定共通一覧(調定年度, 賦課年度, 通知書番号, 処理日時.minusYears(10)).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbbTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 介護期別調定共通モデルを渡すと_insertは_介護期別調定共通を追加する() {
            KibetsuChoteiKyotsuModel model = new KibetsuChoteiKyotsuModel(
                    new KibetsuModel(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity()),
                    new ChoteiKyotsuModel(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity()));
            sut.insert(model);
            assertThat(sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期).get介護期別モデル().get期(), is(期));
        }
    }

    public static class updateTest extends DbbTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        @Test
        public void 介護期別調定共通モデルを渡すと_updateは_介護期別調定共通を更新する() {
            KibetsuChoteiKyotsuModel model = new KibetsuChoteiKyotsuModel(
                    new KibetsuModel(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity()),
                    new ChoteiKyotsuModel(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity()));
            sut.insert(model);
            model.get介護期別モデル().getEntity().initializeMd5();
            model.get調定共通モデル().getEntity().initializeMd5();
            model.get介護期別モデル().set調定ID(調定ID + 1);
            model.get調定共通モデル().set調定額(new Decimal(9999));
            sut.update(model);
            assertThat(sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期).get介護期別モデル().get調定ID(), is(調定ID + 1));
        }
    }

    public static class deleteTest extends DbbTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 介護期別調定共通モデルを渡すと_deleteは_介護期別調定共通を削除する() {

            KibetsuChoteiKyotsuModel model = new KibetsuChoteiKyotsuModel(
                    new KibetsuModel(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity()),
                    new ChoteiKyotsuModel(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity()));
            sut.insert(model);
            sut.delete(model);
            assertThat(sut.select介護期別調定共通ByKey(調定年度, 賦課年度, 通知書番号, 処理日時, 徴収方法, 期), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insertDbT2003(
                FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                RDateTime 処理日時,
                RString 徴収方法,
                int 期) {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            entity.setChoshuHoho(徴収方法);
            entity.setKi(期);
            介護期別Dac.insert(entity);
        }

        public static void insertUrT0705(Long 調定ID) {
            UrT0705ChoteiKyotsuEntity entity = UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity();
            entity.setChoteiId(調定ID);
            調定共通Dac.insert(entity);
        }
    }

}
