/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KibetsuChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 期割額を計算するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class KiwarigakuCalculatorTest {

    private static KiwarigakuCalculator sut;

    public static class コンストラクタ extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 期割額明細がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KiwarigakuCalculator(null);
        }
    }

    public static class calculate extends DbzTestBase {

        @Test
        public void 特別徴収の期別額がある時_calculateは_特別徴収の期別額合計を返す() {
            sut = new KiwarigakuCalculator(createKiwarigakuModelList());
            assertThat(sut.calculate().get特徴期別額合計(), is(new Decimal(600)));
        }

        @Test
        public void 特別徴収の納付額がある時_calculateは_特別徴収の納付額合計を返す() {
            sut = new KiwarigakuCalculator(createKiwarigakuModelList());
            assertThat(sut.calculate().get特徴納付額合計(), is(new Decimal(6000)));
        }

        @Test
        public void 普通徴収の期別額がある時_calculateは_普通徴収の期別額合計を返す() {
            sut = new KiwarigakuCalculator(createKiwarigakuModelList());
            assertThat(sut.calculate().get普徴期別額合計(), is(new Decimal(1500)));
        }

        @Test
        public void 普通徴収の納付額がある時_calculateは_普通徴収の納付額合計を返す() {
            sut = new KiwarigakuCalculator(createKiwarigakuModelList());
            assertThat(sut.calculate().get普徴納付額合計(), is(new Decimal(15000)));
        }
    }

    private static List<KiwarigakuMeisai> createKiwarigakuModelList() {
        List<KiwarigakuMeisai> list = new ArrayList<>();
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 100, 1000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 200, 2000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.特別徴収, 300, 3000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 400, 4000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 500, 5000));
        list.add(createKiwarigakuModel(ChoshuHohoKibetsu.普通徴収, 600, 6000));
        return list;
    }

    private static KiwarigakuMeisai createKiwarigakuModel(ChoshuHohoKibetsu 徴収方法, int 調定額, int 収入額) {
        Kibetsu kibetsuModel = mock(Kibetsu.class);
//        when(kibetsuModel.get徴収方法()).thenReturn(徴収方法);

        ChoteiKyotsu choteiKyotsuModel = mock(ChoteiKyotsu.class);
        when(choteiKyotsuModel.get調定額()).thenReturn(new Decimal(調定額));

        KibetsuChoteiKyotsu kibetsuChoteiKyotsuModel = mock(KibetsuChoteiKyotsu.class);
//        when(kibetsuChoteiKyotsuModel.get介護期別モデル()).thenReturn(kibetsuModel);
        when(kibetsuChoteiKyotsuModel.get調定共通モデル()).thenReturn(choteiKyotsuModel);

        KiwarigakuMeisai kiwarigakuModel = mock(KiwarigakuMeisai.class);
//        when(kiwarigakuModel.get期別調定共通()).thenReturn(kibetsuChoteiKyotsuModel);
        when(kiwarigakuModel.get収入額()).thenReturn(new Decimal(収入額));

        return kiwarigakuModel;
    }
}
