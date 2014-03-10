/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5011ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.DbT5011ShujiiIkenshoIraiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteiShinseiJohoMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.ShujiiIkenshoSakuseiIraiJohoMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書作成依頼記録を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoSakuseiIraiKirokuManagerTest {

    private static final int AS_情報0件 = 0;
    private static final int AS_情報1件 = 1;
    private static final int AS_情報2件 = 2;
    private static final int AS_save成功 = 1;
    private static final int AS_save失敗 = 0;

    public static class get主治医意見書作成依頼情報 {

        @Test
        public void 該当の主治医意見書作成依頼情報が存在しない時_get主治医意見書作成依頼情報は_NULLを返す() {
            assertThat(createManager(AS_情報0件).get主治医意見書作成依頼情報(createKanriNo(), createRirekiNo()), nullValue());
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が存在する時_get主治医意見書作成依頼情報は_該当の情報を返す() {
            assertThat(createManager(AS_情報1件).get主治医意見書作成依頼情報(createKanriNo(), createRirekiNo()).get申請書管理番号(), is(createKanriNo()));
        }
    }

    public static class get主治医意見書作成依頼情報By申請書管理番号 {

        @Test
        public void 該当の主治医意見書作成依頼情報が0件の時_get主治医意見書作成依頼情報By申請書管理番号は_EMPTYを返す() {
            assertThat(createManager(AS_情報0件).get主治医意見書作成依頼情報By申請書管理番号(createKanriNo()), is(Collections.EMPTY_LIST));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が1件の時_get主治医意見書作成依頼情報By申請書管理番号は_1件の情報を返す() {
            assertThat(createManager(AS_情報1件).get主治医意見書作成依頼情報By申請書管理番号(createKanriNo()).size(), is(1));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が2件の時_get主治医意見書作成依頼情報By申請書管理番号は_2件の情報を返す() {
            assertThat(createManager(AS_情報2件).get主治医意見書作成依頼情報By申請書管理番号(createKanriNo()).size(), is(2));
        }
    }

    public static class get主治医意見書作成依頼情報By依頼年月日 {

        @Test
        public void 該当の主治医意見書作成依頼情報が0件の時_get主治医意見書作成依頼情報By依頼年月日は_EMPTYを返す() {
            assertThat(createManager(AS_情報0件).get主治医意見書作成依頼情報By依頼年月日(FlexibleDate.MAX), is(Collections.EMPTY_LIST));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が1件の時_get主治医意見書作成依頼情報By依頼年月日は_1件の情報を返す() {
            assertThat(createManager(AS_情報1件).get主治医意見書作成依頼情報By依頼年月日(FlexibleDate.MAX).size(), is(1));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が2件の時_get主治医意見書作成依頼情報By依頼年月日は_2件の情報を返す() {
            assertThat(createManager(AS_情報2件).get主治医意見書作成依頼情報By依頼年月日(FlexibleDate.MAX).size(), is(2));
        }
    }

    public static class get主治医意見書作成依頼情報By主治医情報 {

        @Test
        public void 該当の主治医意見書作成依頼情報が0件の時_get主治医意見書作成依頼情報By主治医情報は_EMPTYを返す() {
            assertThat(createManager(AS_情報0件).get主治医意見書作成依頼情報By主治医情報(createKaigoIryoKikanCode(), createKaigoDoctorCode()), is(Collections.EMPTY_LIST));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が1件の時_get主治医意見書作成依頼情報By主治医情報は_1件の情報を返す() {
            assertThat(createManager(AS_情報1件).get主治医意見書作成依頼情報By主治医情報(createKaigoIryoKikanCode(), createKaigoDoctorCode()).size(), is(1));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が2件の時_get主治医意見書作成依頼情報By主治医情報は_2件の情報を返す() {
            assertThat(createManager(AS_情報2件).get主治医意見書作成依頼情報By主治医情報(createKaigoIryoKikanCode(), createKaigoDoctorCode()).size(), is(2));
        }
    }

    public static class get主治医意見書作成依頼情報By督促年月日 {

        @Test
        public void 該当の主治医意見書作成依頼情報が0件の時_get主治医意見書作成依頼情報By督促年月日は_EMPTYを返す() {
            assertThat(createManager(AS_情報0件).get主治医意見書作成依頼情報By督促年月日(FlexibleDate.MAX), is(Collections.EMPTY_LIST));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が1件の時_get主治医意見書作成依頼情報By督促年月日は_1件の情報を返す() {
            assertThat(createManager(AS_情報1件).get主治医意見書作成依頼情報By督促年月日(FlexibleDate.MAX).size(), is(1));
        }

        @Test
        public void 該当の主治医意見書作成依頼情報が2件の時_get主治医意見書作成依頼情報By督促年月日は_2件の情報を返す() {
            assertThat(createManager(AS_情報2件).get主治医意見書作成依頼情報By督促年月日(FlexibleDate.MAX).size(), is(2));
        }
    }

    public static class save_主治医意見書作成依頼情報 {

        @Test
        public void saveが成功した時_saveは_TRUEを返す() {
            assertThat(createManager(AS_save成功).save(createIraiJoho()), is(true));
        }

        @Test
        public void saveが失敗した時_saveは_FALSEを返す() {
            assertThat(createManager(AS_save失敗).save(createIraiJoho()), is(false));
        }
    }

    public static class get認定申請情報 {

        @Test
        public void 該当の認定申請情報が存在しない時_get認定申請情報は_NULLを返す() {
            assertThat(createManager(AS_情報0件).get認定申請情報(createKanriNo()), nullValue());
        }

        @Test
        public void 該当の認定申請情報が存在する時_get認定申請情報は_該当の情報を返す() {
            assertThat(createManager(AS_情報1件).get認定申請情報(createKanriNo()).get申請書管理番号(), is(createKanriNo()));
        }
    }

    public static class save_認定申請情報 {

        @Test
        public void saveが成功した時_saveは_TRUEを返す() {
            assertThat(createManager(AS_save成功).save(createShinseiJoho()), is(true));
        }

        @Test
        public void saveが失敗した時_saveは_FALSEを返す() {
            assertThat(createManager(AS_save失敗).save(createShinseiJoho()), is(false));
        }
    }

    private static ShujiiIkenshoSakuseiIraiKirokuManager createManager(int flg) {
        return new ShujiiIkenshoSakuseiIraiKirokuManager(createIraiDac(flg), createShinseiDac(flg));
    }

    private static IShujiiIkenshoIraiJohoDac createIraiDac(int flg) {
        IShujiiIkenshoIraiJohoDac dac = mock(IShujiiIkenshoIraiJohoDac.class);
        when(dac.select(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(createIraiEntity(flg));
        when(dac.selectBy申請書管理番号(any(ShinseishoKanriNo.class))).thenReturn(createIraiEntityList(flg));
        when(dac.selectBy依頼年月日(any(FlexibleDate.class))).thenReturn(createIraiEntityList(flg));
        when(dac.selectBy主治医情報(any(RString.class), any(RString.class))).thenReturn(createIraiEntityList(flg));
        when(dac.selectBy督促年月日(any(FlexibleDate.class))).thenReturn(createIraiEntityList(flg));
        when(dac.insertOrUpdate(any(DbT5011ShujiiIkenshoIraiJohoEntity.class))).thenReturn(flg);
        when(dac.insert(any(DbT5011ShujiiIkenshoIraiJohoEntity.class))).thenReturn(flg);
        when(dac.update(any(DbT5011ShujiiIkenshoIraiJohoEntity.class))).thenReturn(flg);
        return dac;
    }

    private static INinteiShinseiJohoDac createShinseiDac(int flg) {
        INinteiShinseiJohoDac dac = mock(INinteiShinseiJohoDac.class);
        when(dac.select(any(ShinseishoKanriNo.class))).thenReturn(createShinseiEntity(flg));
        when(dac.update(any(DbT5001NinteiShinseiJohoEntity.class))).thenReturn(flg);
        return dac;
    }

    private static ShujiiIkenshoSakuseiIraiJoho createIraiJoho() {
        return ShujiiIkenshoSakuseiIraiJohoMock.getSpiedInstance();
    }

    private static DbT5011ShujiiIkenshoIraiJohoEntity createIraiEntity(int flg) {
        return flg == 0 ? null : DbT5011ShujiiIkenshoIraiJohoEntityMock.getSpiedInstance();
    }

    private static List<DbT5011ShujiiIkenshoIraiJohoEntity> createIraiEntityList(int size) {
        List<DbT5011ShujiiIkenshoIraiJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(DbT5011ShujiiIkenshoIraiJohoEntityMock.getSpiedInstance());
        }
        return list;
    }

    private static NinteiShinseiJoho createShinseiJoho() {
        return NinteiShinseiJohoMock.getSpiedInstance();
    }

    private static DbT5001NinteiShinseiJohoEntity createShinseiEntity(int flg) {
        return flg == 0 ? null : DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
    }

    private static ShinseishoKanriNo createKanriNo() {
        return new ShinseishoKanriNo(new RString("申請書管理番号"));
    }

    private static IkenshosakuseiIraiRirekiNo createRirekiNo() {
        return new IkenshosakuseiIraiRirekiNo(0);
    }

    private static KaigoIryoKikanCode createKaigoIryoKikanCode() {
        return new KaigoIryoKikanCode(new RString("介護医療機関コード"));
    }

    private static KaigoDoctorCode createKaigoDoctorCode() {
        return new KaigoDoctorCode(new RString("介護医師コード"));
    }
}
