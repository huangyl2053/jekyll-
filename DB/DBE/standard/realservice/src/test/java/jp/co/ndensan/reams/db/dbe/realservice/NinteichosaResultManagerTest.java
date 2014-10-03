/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaKekkaEntityMock;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.NinteichosaKekkaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.realservice.INinteiChosainFinder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査の調査結果を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaResultManagerTest extends DbeTestBase {

    private static final int AS_調査結果あり = 1;
    private static final int AS_調査結果なし = 0;
    private static final int AS_save成功 = 1;
    private static final int AS_save失敗 = 0;
    private static final int AS_remove成功 = 1;
    private static final int AS_remove失敗 = 0;

    public static class get認定調査結果 extends DbeTestBase {

        @Test
        public void 調査結果ありの時_get認定調査結果は_該当の認定調査結果を返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果あり).get認定調査結果(createShinseishoKanriNo(), createNinteichosaIraiRirekiNo()).get基本調査結果().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 調査結果なしの時_get認定調査結果は_NULLを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果なし).get認定調査結果(createShinseishoKanriNo(), createNinteichosaIraiRirekiNo()), nullValue());
        }
    }

    public static class save認定調査結果 extends DbeTestBase {

        @Test
        public void save成功の時_save認定調査結果は_TRUEを返す() {
            assertThat(createNinteichosaResultManager(AS_save成功).save認定調査結果(createNinteichosaResult()), is(true));
        }

        @Test
        public void savee失敗の時_save認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_save失敗).save認定調査結果(createNinteichosaResult()), is(false));
        }
    }

    public static class remove認定調査結果 extends DbeTestBase {

        @Test
        public void remove成功の時_remove認定調査結果は_TRUEを返す() {
            assertThat(createNinteichosaResultManager(AS_remove成功).remove認定調査結果(createNinteichosaResult()), is(true));
        }

        @Test
        public void remove失敗の時_remove認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_remove失敗).remove認定調査結果(createNinteichosaResult()), is(false));
        }
    }

    private static NinteichosaResultManager createNinteichosaResultManager(int flg) {
        return new NinteichosaResultManager(createNinteichosaKekkaDac(flg), createNinteiChosainFinder());
    }

    private static NinteichosaKekkaDac createNinteichosaKekkaDac(int flg) {
        NinteichosaKekkaDac dac = mock(NinteichosaKekkaDac.class);
        NinteichosaKekkaEntity entity = createNinteichosaKekkaEntity(flg);
        when(dac.select(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(entity);
        when(dac.insertOrUpdate(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        when(dac.insert(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        when(dac.update(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        when(dac.delete(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        return dac;
    }

    private static INinteiChosainFinder createNinteiChosainFinder() {
        INinteiChosainFinder finder = mock(INinteiChosainFinder.class);
        INinteiChosain chosain = NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance().get基本情報().get認定調査員();
        when(finder.get認定調査員(any(RString.class))).thenReturn(chosain);
        return finder;
    }

    private static ShinseishoKanriNo createShinseishoKanriNo() {
        return new ShinseishoKanriNo(new RString("1234567890"));
    }

    private static NinteichosaIraiRirekiNo createNinteichosaIraiRirekiNo() {
        return new NinteichosaIraiRirekiNo(0);
    }

    private static NinteichosaResult createNinteichosaResult() {
        return NinteichosaResultMock.getSpiedNinteichosaResultInstance();
    }

    private static NinteichosaKekkaEntity createNinteichosaKekkaEntity(int flg) {
        return flg != 0 ? NinteichosaKekkaEntityMock.getSpiedNinteichosaKekkaEntityInstance() : null;
    }
}
