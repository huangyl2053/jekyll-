/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.ShujiiIkenshoEntityMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書の結果を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoResultManagerTest {

    private static final boolean AS_意見書結果あり = true;
    private static final boolean AS_意見書結果なし = false;
    private static final boolean AS_save成功 = true;
    private static final boolean AS_save失敗 = false;
    private static final boolean AS_remove成功 = true;
    private static final boolean AS_remove失敗 = false;

    public static class get主治医意見書結果 {

        @Test
        public void 意見書結果ありの時_get主治医意見書結果は_該当の意見書結果を返す() {
            assertThat(createShujiiIkenshoResultManager(AS_意見書結果あり).get主治医意見書結果(createShinseishoKanriNo(), createShujiiIkenshoRirekiNo()).get基本情報().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 意見書結果なしの時_get主治医意見書結果は_NULLを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_意見書結果なし).get主治医意見書結果(createShinseishoKanriNo(), createShujiiIkenshoRirekiNo()), nullValue());
        }
    }

    public static class save主治医意見書結果 {

        @Test
        public void save成功の時_save主治医意見書結果は_TRUEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_save成功).save主治医意見書結果(createShujiiIkenshoResult()), is(true));
        }

        @Test
        public void savee失敗の時_save主治医意見書結果は_FALSEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_save失敗).save主治医意見書結果(createShujiiIkenshoResult()), is(false));
        }
    }

    public static class remove主治医意見書結果 {

        @Test
        public void remove成功の時_remove主治医意見書結果は_TRUEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_remove成功).remove主治医意見書結果(createShujiiIkenshoResult()), is(true));
        }

        @Test
        public void remove失敗の時_remove主治医意見書結果は_FALSEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_remove失敗).remove主治医意見書結果(createShujiiIkenshoResult()), is(false));
        }
    }

    private static ShujiiIkenshoResultManager createShujiiIkenshoResultManager(boolean flg) {
        return new ShujiiIkenshoResultManager(createShujiiIkenshoDac(flg), createKaigoDoctorManager());
    }

    private static ShujiiIkenshoDac createShujiiIkenshoDac(boolean flg) {
        ShujiiIkenshoDac dac = mock(ShujiiIkenshoDac.class);
        ShujiiIkenshoEntity entity = createShujiiIkenshoEntity(flg);
        when(dac.select(any(ShinseishoKanriNo.class), any(ShujiiIkenshoRirekiNo.class))).thenReturn(entity);
        when(dac.insertOrUpdate(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        when(dac.insert(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        when(dac.update(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        when(dac.delete(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        return dac;
    }

    private static IKaigoDoctorManager createKaigoDoctorManager() {
        IKaigoDoctorManager manager = mock(IKaigoDoctorManager.class);
        KaigoDoctor kaigoDoctor = ShujiiIkenshoResultMock.getSpiedShujiiIkenshoBaseInstance().get主治医();
        when(manager.get介護医師(any(ShichosonCode.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class))).thenReturn(kaigoDoctor);
        return manager;
    }

    private static ShinseishoKanriNo createShinseishoKanriNo() {
        return new ShinseishoKanriNo(new RString("1234567890"));
    }

    private static ShujiiIkenshoRirekiNo createShujiiIkenshoRirekiNo() {
        return new ShujiiIkenshoRirekiNo(0);
    }

    private static ShujiiIkenshoResult createShujiiIkenshoResult() {
        return ShujiiIkenshoResultMock.getSpiedShujiiIkenshoResultInstance();
    }

    private static ShujiiIkenshoEntity createShujiiIkenshoEntity(boolean flg) {
        return flg ? ShujiiIkenshoEntityMock.getSpiedShujiiIkenshoEntityInstance() : null;
    }
}
