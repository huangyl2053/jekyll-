/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.model.helper.KibetsuChoteiKyotsuModelTestHelper;
import jp.co.ndensan.reams.db.dbb.model.relate.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbb.persistence.relate.KibetsuChoteiKyotsuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urc.business.IShuno;
import jp.co.ndensan.reams.ur.urc.business.IShunoKingakuComponentSupply;
import jp.co.ndensan.reams.ur.urc.realservice.IShunoManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 期割額を取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KiwarigakuFinderTest extends DbzTestBase {

    private static final FlexibleYear 調定年度 = FlexibleYear.MAX;
    private static final FlexibleYear 賦課年度 = FlexibleYear.MAX;
    private static final TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
    private static final RDateTime 処理日時 = RDateTime.MAX;

    public static class load期割額 {

        @Test
        public void 期割額が0件の時_load期割額は_0件の情報を返す() {
            KiwarigakuFinder sut = createFinder(0);
            assertThat(sut.load期割額(調定年度, 賦課年度, 通知書番号, 処理日時).toList().size(), is(0));
        }

        @Test
        public void 期割額が1件の時_load期割額は_1件の情報を返す() {
            KiwarigakuFinder sut = createFinder(1);
            assertThat(sut.load期割額(調定年度, 賦課年度, 通知書番号, 処理日時).toList().size(), is(1));
        }

        @Test
        public void 期割額が2件の時_load期割額は_2件の情報を返す() {
            KiwarigakuFinder sut = createFinder(2);
            assertThat(sut.load期割額(調定年度, 賦課年度, 通知書番号, 処理日時).toList().size(), is(2));
        }
    }

    private static KiwarigakuFinder createFinder(int count) {
        return new KiwarigakuFinder(createDac(count), createManager());
    }

    private static KibetsuChoteiKyotsuDac createDac(int count) {
        KibetsuChoteiKyotsuDac dac = mock(KibetsuChoteiKyotsuDac.class);
        List<KibetsuChoteiKyotsuModel> list = createChoteigakuList(count);
        when(dac.select介護期別調定共通一覧(any(FlexibleYear.class), any(FlexibleYear.class), any(TsuchishoNo.class), any(RDateTime.class))).thenReturn(list);
        return dac;
    }

    private static IShunoManager createManager() {
        IShunoManager manager = mock(IShunoManager.class);
        IShuno shuno = createShuno();
        when(manager.get収納(any(Long.class))).thenReturn(shuno);
        return manager;
    }

    private static List<KibetsuChoteiKyotsuModel> createChoteigakuList(int count) {
        List<KibetsuChoteiKyotsuModel> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(KibetsuChoteiKyotsuModelTestHelper.createModel());
        }
        return list;
    }

    private static IShuno createShuno() {
        IShunoKingakuComponentSupply supply = mock(IShunoKingakuComponentSupply.class);
        when(supply.get本税()).thenReturn(new Decimal(1234));
        IShuno shuno = mock(IShuno.class);
        when(shuno.get収入合計情報()).thenReturn(supply);
        return shuno;
    }
}
