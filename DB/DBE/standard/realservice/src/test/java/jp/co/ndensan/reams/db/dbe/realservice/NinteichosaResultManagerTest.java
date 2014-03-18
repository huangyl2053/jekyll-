/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaKekkaEntityMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteichosaKekkaDac;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.realservice.INinteiChosainFinder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
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
public class NinteichosaResultManagerTest {

    private static final boolean AS_調査結果あり = true;
    private static final boolean AS_調査結果なし = false;
    private static final boolean AS_save成功 = true;
    private static final boolean AS_save失敗 = false;
    private static final boolean AS_remove成功 = true;
    private static final boolean AS_remove失敗 = false;

    public static class get認定調査結果 {

        @Test
        public void 調査結果ありの時_get認定調査結果は_該当の認定調査結果を返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果あり).get認定調査結果(createShinseishoKanriNo(), createNinteichosaIraiRirekiNo()).get基本調査結果().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 調査結果なしの時_get認定調査結果は_NULLを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果なし).get認定調査結果(createShinseishoKanriNo(), createNinteichosaIraiRirekiNo()), nullValue());
        }
    }

    public static class save認定調査結果 {

        @Test
        public void save成功の時_save認定調査結果は_TRUEを返す() {
            assertThat(createNinteichosaResultManager(AS_save成功).save認定調査結果(createNinteichosaResult()), is(true));
        }

        @Test
        public void savee失敗の時_save認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_save失敗).save認定調査結果(createNinteichosaResult()), is(false));
        }
    }

    public static class remove認定調査結果 {

        @Test
        public void remove成功の時_remove認定調査結果は_TRUEを返す() {
            assertThat(createNinteichosaResultManager(AS_remove成功).remove認定調査結果(createNinteichosaResult()), is(true));
        }

        @Test
        public void remove失敗の時_remove認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_remove失敗).remove認定調査結果(createNinteichosaResult()), is(false));
        }
    }

    private static NinteichosaResultManager createNinteichosaResultManager(boolean flg) {
        return new NinteichosaResultManager(createNinteichosaKekkaDac(flg), createNinteiChosainFinder());
    }

    private static INinteichosaKekkaDac createNinteichosaKekkaDac(boolean flg) {
        INinteichosaKekkaDac dac = mock(INinteichosaKekkaDac.class);
        when(dac.select(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(createNinteichosaKekkaEntity(flg));
        when(dac.insertOrUpdate(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        when(dac.insert(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        when(dac.update(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        when(dac.delete(any(NinteichosaKekkaEntity.class))).thenReturn(flg);
        return dac;
    }

    private static INinteiChosainFinder createNinteiChosainFinder() {
        INinteiChosainFinder finder = mock(INinteiChosainFinder.class);
        INinteiChosain chosain = NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance().get概況調査結果基本情報().get認定調査員();
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

    private static NinteichosaKekkaEntity createNinteichosaKekkaEntity(boolean flg) {
        return flg ? NinteichosaKekkaEntityMock.getSpiedNinteichosaKekkaEntityInstance() : null;
    }
}
