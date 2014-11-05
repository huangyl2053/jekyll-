/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.ShujiiIkenshoEntityMock;
import jp.co.ndensan.reams.db.dbe.business.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.db.dbe.business.helper.ShujiiIkenshoSakuseiIraiMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
public class ShujiiIkenshoResultManagerTest extends DbeTestBase {

    private static final int AS_意見書結果あり = 1;
    private static final int AS_意見書結果なし = 0;
    private static final int AS_save成功 = 1;
    private static final int AS_save失敗 = 0;
    private static final int AS_remove成功 = 1;
    private static final int AS_remove失敗 = 0;
    private static final LasdecCode 市町村コード = new LasdecCode(new RString("000001"));

    public static class get主治医意見書結果 extends DbeTestBase {

        @Test
        public void 意見書結果ありの時_get主治医意見書結果は_該当の意見書結果を返す() {
            assertThat(createShujiiIkenshoResultManager(AS_意見書結果あり).get主治医意見書結果(
                    市町村コード, createShinseishoKanriNo(), createRirekiNo()).get基本情報().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 意見書結果なしの時_get主治医意見書結果は_NULLを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_意見書結果なし).get主治医意見書結果(
                    市町村コード, createShinseishoKanriNo(), createRirekiNo()), nullValue());
        }
    }

    public static class save主治医意見書結果 extends DbeTestBase {

        @Test
        public void save成功の時_save主治医意見書結果は_TRUEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_save成功).save主治医意見書結果(createShujiiIkenshoResult()), is(true));
        }

        @Test
        public void savee失敗の時_save主治医意見書結果は_FALSEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_save失敗).save主治医意見書結果(createShujiiIkenshoResult()), is(false));
        }
    }

    public static class remove主治医意見書結果 extends DbeTestBase {

        @Test
        public void remove成功の時_remove主治医意見書結果は_TRUEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_remove成功).remove主治医意見書結果(createShujiiIkenshoResult()), is(true));
        }

        @Test
        public void remove失敗の時_remove主治医意見書結果は_FALSEを返す() {
            assertThat(createShujiiIkenshoResultManager(AS_remove失敗).remove主治医意見書結果(createShujiiIkenshoResult()), is(false));
        }
    }

    private static ShujiiIkenshoResultManager createShujiiIkenshoResultManager(int flg) {
        return new ShujiiIkenshoResultManager(createShujiiIkenshoDac(flg), createShujiiIkenshoSakuseiIraiKirokuManager());
    }

    private static ShujiiIkenshoDac createShujiiIkenshoDac(int flg) {
        ShujiiIkenshoDac dac = mock(ShujiiIkenshoDac.class);
        ShujiiIkenshoEntity entity = createShujiiIkenshoEntity(flg);
        when(dac.select(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(entity);
        when(dac.insertOrUpdate(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        when(dac.insert(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        when(dac.update(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        when(dac.delete(any(ShujiiIkenshoEntity.class))).thenReturn(flg);
        return dac;
    }

    private static ShujiiIkenshoSakuseiIraiKirokuManager createShujiiIkenshoSakuseiIraiKirokuManager() {
        ShujiiIkenshoSakuseiIraiKirokuManager manager = mock(ShujiiIkenshoSakuseiIraiKirokuManager.class);
        ShujiiIkenshoSakuseiIrai sakuseiIrai = ShujiiIkenshoSakuseiIraiMock.getSpiedInstance();
        when(manager.get主治医意見書作成依頼情報(
                any(LasdecCode.class), any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(sakuseiIrai);
        return manager;
    }

    private static ShinseishoKanriNo createShinseishoKanriNo() {
        return new ShinseishoKanriNo(new RString("1234567890"));
    }

    private static IkenshosakuseiIraiRirekiNo createRirekiNo() {
        return new IkenshosakuseiIraiRirekiNo(0);
    }

    private static ShujiiIkenshoResult createShujiiIkenshoResult() {
        return ShujiiIkenshoResultMock.getSpiedShujiiIkenshoResultInstance();
    }

    private static ShujiiIkenshoEntity createShujiiIkenshoEntity(int flg) {
        return flg != 0 ? ShujiiIkenshoEntityMock.getSpiedShujiiIkenshoEntityInstance() : null;
    }
}
