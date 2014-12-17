/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.model.ChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.model.KibetsuModel;
import jp.co.ndensan.reams.db.dbz.model.KiwarigakuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 期割額を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KiwarigakuTest {

    private static Kiwarigaku sut;

    public static class コンストラクタ extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 期割額明細がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new Kiwarigaku(null);
        }
    }

    public static class get特徴期別額合計 extends DbzTestBase {

        @Test
        public void 特別徴収の期別額がある時_get特徴期別額合計は_特別徴収の期別額合計を返す() {
            sut = new Kiwarigaku(createKiwarigakuModelList());
            assertThat(sut.get特徴期別額合計(), is(new Decimal(600)));
        }
    }

    public static class get特徴納付額合計 extends DbzTestBase {

        @Test
        public void 特別徴収の納付額がある時_get特徴納付額合計は_特別徴収の納付額合計を返す() {
            sut = new Kiwarigaku(createKiwarigakuModelList());
            assertThat(sut.get特徴納付額合計(), is(new Decimal(6000)));
        }
    }

    public static class get普徴期別額合計 extends DbzTestBase {

        @Test
        public void 普通徴収の期別額がある時_get普徴期別額合計は_普通徴収の期別額合計を返す() {
            sut = new Kiwarigaku(createKiwarigakuModelList());
            assertThat(sut.get普徴期別額合計(), is(new Decimal(1500)));
        }
    }

    public static class get普徴納付額合計 extends DbzTestBase {

        @Test
        public void 普通徴収の納付額がある時_get普徴納付額合計は_普通徴収の納付額合計を返す() {
            sut = new Kiwarigaku(createKiwarigakuModelList());
            assertThat(sut.get普徴納付額合計(), is(new Decimal(15000)));
        }
    }

    private static List<KiwarigakuModel> createKiwarigakuModelList() {
        List<KiwarigakuModel> list = new ArrayList<>();
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 100, 1000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 200, 2000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 300, 3000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 400, 4000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 500, 5000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 600, 6000));
        return list;
    }

    private static KiwarigakuModel createKiwarigakuModel(ChoshuHohoKibetsu 徴収方法, int 調定額, int 収入額) {
        KibetsuModel kibetsuModel = mock(KibetsuModel.class);
        when(kibetsuModel.get徴収方法()).thenReturn(徴収方法.getCode());

        ChoteiKyotsuModel choteiKyotsuModel = mock(ChoteiKyotsuModel.class);
        when(choteiKyotsuModel.get調定額()).thenReturn(new Decimal(調定額));

        KibetsuChoteiKyotsuModel kibetsuChoteiKyotsuModel = mock(KibetsuChoteiKyotsuModel.class);
        when(kibetsuChoteiKyotsuModel.get介護期別モデル()).thenReturn(kibetsuModel);
        when(kibetsuChoteiKyotsuModel.get調定共通モデル()).thenReturn(choteiKyotsuModel);

        KiwarigakuModel kiwarigakuModel = mock(KiwarigakuModel.class);
        when(kiwarigakuModel.get期別調定共通()).thenReturn(kibetsuChoteiKyotsuModel);
        when(kiwarigakuModel.get収入額()).thenReturn(new Decimal(収入額));

        return kiwarigakuModel;
    }
}
