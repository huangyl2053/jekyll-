/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.ServiceShuruiShikyuGendoGakuModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7111ServiceShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ServiceShuruiShikyuGendoGakuDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ServiceShuruiShikyuGendoGakuDacTest {

    private static ServiceShuruiShikyuGendoGakuDac sut;
    private static DbT7111ServiceShuruiShikyuGendoGakuDac サービス種類支給限度額Dac;

    private static final ServiceShuruiCode サービス種類コード1 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
    private static final ServiceShuruiCode サービス種類コード2 = new ServiceShuruiCode(new RString("11"));
    private static final YokaigoJotaiKubun09 要介護状態区分1 = YokaigoJotaiKubun09.toValue(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分);
    private static final YokaigoJotaiKubun09 要介護状態区分2 = YokaigoJotaiKubun09.toValue(new RString("12"));
    private static final FlexibleYearMonth 適用開始年月1 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用終了年月;
    private static final FlexibleYearMonth 適用開始年月2 = new FlexibleYearMonth(new RString("201501"));
    private static final YMDHMS 処理日時1 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = new YMDHMS(new RString("20140415102040"));
    private static final FlexibleDate 基準日 = new FlexibleDate(new RString("20150101"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ServiceShuruiShikyuGendoGakuDac.class);
        サービス種類支給限度額Dac = InstanceProvider.create(DbT7111ServiceShuruiShikyuGendoGakuDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT7111(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のサービス種類コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 要介護状態区分1, 適用開始年月1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の要介護状態区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(サービス種類コード1, null, 適用開始年月1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の適用開始年月にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(サービス種類コード1, 要介護状態区分1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(サービス種類コード1, 要介護状態区分1, 適用開始年月1, null);
        }

        // TODO 見つかる場合、サービス種類支給限度額モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_サービス種類支給限度額モデル返す() {
            assertThat(sut.selectByKey(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1).get().getサービス種類コード(), is(サービス種類コード1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.selectByKey(サービス種類コード2, 要介護状態区分1, 適用開始年月1, 処理日時1).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT7111(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1);
            IItemList<ServiceShuruiShikyuGendoGakuModel> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getサービス種類コード(), is(サービス種類コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class selectサービス種類支給限度額リスト基準日ありTest extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数の要介護状態区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectサービス種類支給限度額リスト(null, FlexibleDate.MAX);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の基準日にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectサービス種類支給限度額リスト(要介護状態区分1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT7111(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1);
            IItemList<ServiceShuruiShikyuGendoGakuModel> modelList = sut.selectサービス種類支給限度額リスト(要介護状態区分1, 基準日);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getサービス種類コード(), is(サービス種類コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            TestSupport.insertDbT7111(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1);
            assertThat(sut.selectサービス種類支給限度額リスト(要介護状態区分2, 基準日).isEmpty(), is(true));
        }
    }

    public static class selectサービス種類支給限度額リスト基準日無しTest extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数の要介護状態区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectサービス種類支給限度額リスト(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT7111(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1);
            IItemList<ServiceShuruiShikyuGendoGakuModel> modelList = sut.selectサービス種類支給限度額リスト(要介護状態区分1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getサービス種類コード(), is(サービス種類コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            TestSupport.insertDbT7111(サービス種類コード1, 要介護状態区分1, 適用開始年月1, 処理日時1);
            assertThat(sut.selectサービス種類支給限度額リスト(要介護状態区分2).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO ServiceShuruiShikyuGendoGakuModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つServiceShuruiShikyuGendoGakuRelateモデルを渡した時_insertは_1を返す() {
            ServiceShuruiShikyuGendoGakuModel model = new ServiceShuruiShikyuGendoGakuModel(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity());

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO ServiceShuruiShikyuGendoGakuModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            ServiceShuruiShikyuGendoGakuModel model = new ServiceShuruiShikyuGendoGakuModel(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.set支給限度単位数(Decimal.TEN);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO ServiceShuruiShikyuGendoGakuModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つServiceShuruiShikyuGendoGakuRelateモデルを渡した時_deleteは_1を返す() {
            ServiceShuruiShikyuGendoGakuModel model = new ServiceShuruiShikyuGendoGakuModel(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity());

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO ServiceShuruiShikyuGendoGakuModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つServiceShuruiShikyuGendoGakuRelateモデルを渡した時_deletePhysicalは_1を返す() {
            ServiceShuruiShikyuGendoGakuModel model = new ServiceShuruiShikyuGendoGakuModel(DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7111(
                ServiceShuruiCode サービス種類コード,
                IYokaigoJotaiKubun 要介護状態区分,
                FlexibleYearMonth 適用開始年月,
                YMDHMS 処理日時) {
            DbT7111ServiceShuruiShikyuGendoGakuEntity entity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            entity.setServiceShuruiCode(サービス種類コード);
            entity.setYoKaigoJotaiKubun(要介護状態区分.getCode());
            entity.setTekiyoKaishuYM(適用開始年月);
            entity.setShoriTimestamp(処理日時);
            サービス種類支給限度額Dac.insert(entity);
        }
    }

}
