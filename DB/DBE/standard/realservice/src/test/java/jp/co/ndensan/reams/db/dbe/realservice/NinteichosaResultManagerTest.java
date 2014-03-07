/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosahyoJohoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaKekkaEntityMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
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

    private static final int AS_調査結果情報あり = 1;
    private static final int AS_調査結果情報なし = 0;
    private static final int AS_調査票情報あり = 1;
    private static final int AS_調査票情報なし = 0;
    private static final int AS_調査結果情報save成功 = 1;
    private static final int AS_調査結果情報save失敗 = 0;
    private static final int AS_調査票情報save成功 = 1;
    private static final int AS_調査票情報save失敗 = 0;
    private static final int AS_調査結果情報remove成功 = 1;
    private static final int AS_調査結果情報remove失敗 = 0;
    private static final int AS_調査票情報remove成功 = 1;
    private static final int AS_調査票情報remove失敗 = 0;

    public static class get認定調査結果 {

        @Test
        public void 調査結果情報あり_調査票情報ありの時_get認定調査結果は_該当の認定調査結果を返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報あり, AS_調査票情報あり).get認定調査結果(createShinseishoKanriNo(), 0).get基本調査結果().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 調査結果情報なし_調査票情報ありの時_get認定調査結果は_NULLを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報なし, AS_調査票情報あり).get認定調査結果(createShinseishoKanriNo(), 0), nullValue());
        }

        @Test
        public void 調査結果情報あり_調査票情報なしの時_get認定調査結果は_NULLを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報あり, AS_調査票情報なし).get認定調査結果(createShinseishoKanriNo(), 0), nullValue());
        }
    }

    public static class save認定調査結果 {

        @Test
        public void 調査結果情報save成功_調査票情報save成功の時_save認定調査結果は_TRUEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報save成功, AS_調査票情報save成功).save認定調査結果(createNinteichosaResult()), is(true));
        }

        @Test
        public void 調査結果情報save成功_調査票情報save失敗の時_save認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報save成功, AS_調査票情報save失敗).save認定調査結果(createNinteichosaResult()), is(false));
        }

        @Test
        public void 調査結果情報save失敗_調査票情報save成功の時_save認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報save失敗, AS_調査票情報save成功).save認定調査結果(createNinteichosaResult()), is(false));
        }

        @Test
        public void 調査結果情報save失敗_調査票情報save失敗の時_save認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報save失敗, AS_調査票情報save失敗).save認定調査結果(createNinteichosaResult()), is(false));
        }
    }

    public static class remove認定調査結果 {

        @Test
        public void 調査結果情報remove成功_調査票情報remove成功の時_remove認定調査結果は_TRUEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報remove成功, AS_調査票情報remove成功).remove認定調査結果(createNinteichosaResult()), is(true));
        }

        @Test
        public void 調査結果情報remove成功_調査票情報remove失敗の時_remove認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報remove成功, AS_調査票情報remove失敗).remove認定調査結果(createNinteichosaResult()), is(false));
        }

        @Test
        public void 調査結果情報remove失敗_調査票情報remove成功の時_remove認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報remove失敗, AS_調査票情報remove成功).remove認定調査結果(createNinteichosaResult()), is(false));
        }

        @Test
        public void 調査結果情報remove失敗_調査票情報remove失敗の時_remove認定調査結果は_FALSEを返す() {
            assertThat(createNinteichosaResultManager(AS_調査結果情報remove失敗, AS_調査票情報remove失敗).remove認定調査結果(createNinteichosaResult()), is(false));
        }
    }

    private static NinteichosaResultManager createNinteichosaResultManager(int chosakekkaFlg, int chosahyoFlag) {
        return new NinteichosaResultManager(createNinteichosaKekkaJohoDac(chosakekkaFlg), createNinteichosahyoJohoDac(chosahyoFlag));
    }

    private static INinteichosaKekkaJohoDac createNinteichosaKekkaJohoDac(int flag) {
        INinteichosaKekkaJohoDac dac = mock(INinteichosaKekkaJohoDac.class);
        when(dac.select(any(RString.class), any(int.class))).thenReturn(createDbT5008NinteichosaKekkaJohoEntity(flag));
        when(dac.insertOrUpdate(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        when(dac.insert(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        when(dac.update(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        when(dac.delete(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        return dac;
    }

    private static INinteichosahyoJohoDac createNinteichosahyoJohoDac(int flag) {
        INinteichosahyoJohoDac dac = mock(INinteichosahyoJohoDac.class);
        when(dac.select(any(RString.class), any(int.class))).thenReturn(createDbT5009NinteichosahyoJohoEntity(flag));
        when(dac.insertOrUpdate(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        when(dac.insert(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        when(dac.update(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        when(dac.delete(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        return dac;
    }

    private static ShinseishoKanriNo createShinseishoKanriNo() {
        return new ShinseishoKanriNo(new RString("1234567890"));
    }

    private static NinteichosaResult createNinteichosaResult() {
        return NinteichosaResultMock.getSpiedNinteichosaResultInstance();
    }

    private static DbT5008NinteichosaKekkaJohoEntity createDbT5008NinteichosaKekkaJohoEntity(int flag) {
        return flag == AS_調査結果情報なし ? null : NinteichosaKekkaEntityMock.getSpiedDbT5008NinteichosaKekkaJohoEntityInstance();
    }

    private static DbT5009NinteichosahyoJohoEntity createDbT5009NinteichosahyoJohoEntity(int flag) {
        return flag == AS_調査票情報なし ? null : NinteichosaKekkaEntityMock.getSpiedDbT5009NinteichosahyoJohoEntityInstance();
    }
}
