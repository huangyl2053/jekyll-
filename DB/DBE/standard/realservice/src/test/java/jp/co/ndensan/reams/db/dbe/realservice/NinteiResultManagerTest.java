/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5002NinteiKekkaJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteiResultMock;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.db.dbx.business.IKaigoService;
import jp.co.ndensan.reams.db.dbx.business.IKaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.realservice.IKaigoServiceManager;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 要介護認定結果を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteiResultManagerTest extends DbeTestBase {

    private static final int AS_認定結果あり = 1;
    private static final int AS_認定結果なし = 0;
    private static final int AS_save成功 = 1;
    private static final int AS_save失敗 = 0;
    private static final int AS_remove成功 = 1;
    private static final int AS_remove失敗 = 0;

    public static class get認定結果 extends DbeTestBase {

        @Test
        public void 認定結果ありの時_get認定結果は_該当の認定結果を返す() {
            assertThat(createNinteiResultManager(AS_認定結果あり).get認定結果(createShinseishoKanriNo()).get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 認定結果なしの時_get認定結果は_NULLを返す() {
            assertThat(createNinteiResultManager(AS_認定結果なし).get認定結果(createShinseishoKanriNo()), nullValue());
        }
    }

    public static class save認定結果 extends DbeTestBase {

        @Test
        public void save成功の時_save認定結果は_TRUEを返す() {
            assertThat(createNinteiResultManager(AS_save成功).save認定結果(createNinteiResult()), is(true));
        }

        @Test
        public void save失敗の時_save認定結果は_FALSEを返す() {
            assertThat(createNinteiResultManager(AS_save失敗).save認定結果(createNinteiResult()), is(false));
        }
    }

    public static class remove認定結果 extends DbeTestBase {

        @Test
        public void remove成功の時_remove認定結果は_TRUEを返す() {
            assertThat(createNinteiResultManager(AS_remove成功).remove認定結果(createNinteiResult()), is(true));
        }

        @Test
        public void remove失敗の時_remove認定結果は_FALSEを返す() {
            assertThat(createNinteiResultManager(AS_remove失敗).remove認定結果(createNinteiResult()), is(false));
        }
    }

    private static NinteiResultManager createNinteiResultManager(int flg) {
        return new NinteiResultManager(createNinteiKekkaJohoDac(flg), createKaigoServiceManager());
    }

    private static NinteiKekkaJohoDac createNinteiKekkaJohoDac(int flg) {
        NinteiKekkaJohoDac dac = mock(NinteiKekkaJohoDac.class);
        DbT5002NinteiKekkaJohoEntity entity = createDbT5002NinteiKekkaJohoEntity(flg);
        when(dac.select(any(ShinseishoKanriNo.class))).thenReturn(entity);
        when(dac.insert(any(DbT5002NinteiKekkaJohoEntity.class))).thenReturn(flg);
        when(dac.delete(any(DbT5002NinteiKekkaJohoEntity.class))).thenReturn(flg);
        return dac;
    }

    private static IKaigoServiceManager createKaigoServiceManager() {
        IKaigoService service = createKaigoService();
        IKaigoServiceManager manager = mock(IKaigoServiceManager.class);
        when(manager.get介護サービス(any(FlexibleYearMonth.class), any(KaigoServiceShuruiCode.class))).thenReturn(service);
        return manager;
    }

    private static IKaigoService createKaigoService() {
        IKaigoServiceShurui shurui = createNinteiResult().get介護サービス種類０１();
        IKaigoService service = mock(IKaigoService.class);
        when(service.get介護サービス種類()).thenReturn(shurui);
        return service;
    }

    private static ShinseishoKanriNo createShinseishoKanriNo() {
        return new ShinseishoKanriNo(new RString("1234567890"));
    }

    private static NinteiResult createNinteiResult() {
        return NinteiResultMock.getSpiedInstance();
    }

    private static DbT5002NinteiKekkaJohoEntity createDbT5002NinteiKekkaJohoEntity(int flg) {
        return flg == 1 ? DbT5002NinteiKekkaJohoEntityMock.getSpiedInstance() : null;
    }
}
