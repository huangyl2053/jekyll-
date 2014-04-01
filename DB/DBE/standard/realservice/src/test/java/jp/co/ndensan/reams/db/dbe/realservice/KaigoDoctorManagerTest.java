/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.KaigoDoctorDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.KaigoDoctorEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.realservice.IDoctorManager;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 介護医師情報を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KaigoDoctorManagerTest {

    public static class get介護医師_証記載保険者番号_介護医療機関コード_介護医師コード {

        @Test
        public void 介護医師情報が存在する時_get介護医師は_介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class)), instanceOf(KaigoDoctor.class));
        }

        @Test
        public void 介護医師情報が存在しない時_get介護医師は_NULLを返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class)), is(nullValue()));
        }
    }

    public static class get介護医師_証記載保険者番号_介護医療機関コード_介護医師コード_医師の状況 {

        @Test
        public void 介護医師情報が存在する時_get介護医師は_介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class), any(IshiJokyo.class)), instanceOf(KaigoDoctor.class));
        }

        @Test
        public void 介護医師情報が存在しない時_get介護医師は_NULLを返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class), any(IshiJokyo.class)), is(nullValue()));
        }
    }

    public static class get介護医師リストOf_証記載保険者番号_介護医療機関コード {

        @Test
        public void 介護医師情報が0件の時_get介護医師は_0件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class)).size(), is(0));
        }

        @Test
        public void 介護医師情報が1件の時_get介護医師は_1件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class)).size(), is(1));
        }

        @Test
        public void 介護医師情報が2件の時_get介護医師は_2件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(2).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class)).size(), is(2));
        }
    }

    public static class get介護医師リストOf_証記載保険者番号_介護医療機関コード_医師の状況 {

        @Test
        public void 介護医師情報が0件の時_get介護医師は_0件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(IshiJokyo.class)).size(), is(0));
        }

        @Test
        public void 介護医師情報が1件の時_get介護医師は_1件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(IshiJokyo.class)).size(), is(1));
        }

        @Test
        public void 介護医師情報が2件の時_get介護医師は_2件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(2).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(IshiJokyo.class)).size(), is(2));
        }
    }

    public static class get介護医師リストOf_証記載保険者番号 {

        @Test
        public void 介護医師情報が0件の時_get介護医師は_0件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師リストOf(any(ShoKisaiHokenshaNo.class)).size(), is(0));
        }

        @Test
        public void 介護医師情報が1件の時_get介護医師は_1件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師リストOf(any(ShoKisaiHokenshaNo.class)).size(), is(1));
        }

        @Test
        public void 介護医師情報が2件の時_get介護医師は_2件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(2).get介護医師リストOf(any(ShoKisaiHokenshaNo.class)).size(), is(2));
        }
    }

    public static class get介護医師リストOf_証記載保険者番号_医師の状況 {

        @Test
        public void 介護医師情報が0件の時_get介護医師は_0件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(IshiJokyo.class)).size(), is(0));
        }

        @Test
        public void 介護医師情報が1件の時_get介護医師は_1件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(IshiJokyo.class)).size(), is(1));
        }

        @Test
        public void 介護医師情報が2件の時_get介護医師は_2件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(2).get介護医師リストOf(any(ShoKisaiHokenshaNo.class), any(IshiJokyo.class)).size(), is(2));
        }
    }

    public static class get介護医師リストOf_検索条件 {

        @Test
        public void 介護医師情報が0件の時_get介護医師は_0件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(0).get介護医師リストOf(mock(ISearchCondition.class)).size(), is(0));
        }

        @Test
        public void 介護医師情報が1件の時_get介護医師は_1件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(1).get介護医師リストOf(mock(ISearchCondition.class)).size(), is(1));
        }

        @Test
        public void 介護医師情報が2件の時_get介護医師は_2件の介護医師情報を返す() {
            assertThat(createKaigoDoctorManager(2).get介護医師リストOf(mock(ISearchCondition.class)).size(), is(2));
        }
    }

    private static KaigoDoctorManager createKaigoDoctorManager(int flg) {
        return new KaigoDoctorManager(createKaigoDoctorDac(flg), createDoctorManager(flg), createShujiiManager(flg), createKaigoIryoKikanFinder(flg));
    }

    public static class save {

        @Test
        public void 介護医師情報の保存が成功した時_saveは_TRUEを返す() {
            assertThat(createKaigoDoctorManager(1).save(createKaigoDoctor()), is(true));
        }

        @Test
        public void 介護医師情報の保存が失敗した時_saveは_FALSEを返す() {
            assertThat(createKaigoDoctorManager(0).save(createKaigoDoctor()), is(false));
        }
    }

    public static class remove {

        @Test
        public void 介護医師情報の保存が成功した時_saveは_TRUEを返す() {
            assertThat(createKaigoDoctorManager(1).remove(createKaigoDoctor()), is(true));
        }

        @Test
        public void 介護医師情報の保存が失敗した時_saveは_FALSEを返す() {
            assertThat(createKaigoDoctorManager(0).remove(createKaigoDoctor()), is(false));
        }
    }

    private static KaigoDoctorDac createKaigoDoctorDac(int flg) {
        KaigoDoctorDac dac = mock(KaigoDoctorDac.class);
        when(dac.select(any(ITrueFalseCriteria.class))).thenReturn(createKaigoDoctorEntityList(flg));
        when(dac.select(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class))).thenReturn(createKaigoDoctorEntity(flg));
        when(dac.select(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(KaigoDoctorCode.class), any(IshiJokyo.class))).thenReturn(createKaigoDoctorEntity(flg));
        when(dac.select(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class))).thenReturn(createKaigoDoctorEntityList(flg));
        when(dac.select(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class), any(IshiJokyo.class))).thenReturn(createKaigoDoctorEntityList(flg));
        when(dac.select(any(ShoKisaiHokenshaNo.class))).thenReturn(createKaigoDoctorEntityList(flg));
        when(dac.select(any(ShoKisaiHokenshaNo.class), any(IshiJokyo.class))).thenReturn(createKaigoDoctorEntityList(flg));
        return dac;
    }

    private static IDoctorManager createDoctorManager(int flg) {
        IDoctorManager manager = mock(IDoctorManager.class);
        when(manager.save(any(IDoctor.class))).thenReturn(flg != 0);
        when(manager.remove(any(IDoctor.class))).thenReturn(flg != 0);
        return manager;
    }

    private static IShujiiManager createShujiiManager(int flg) {
        IShujiiManager manager = mock(IShujiiManager.class);
        when(manager.save(any(IShujii.class))).thenReturn(flg != 0);
        when(manager.remove(any(IShujii.class))).thenReturn(flg != 0);
        return manager;
    }

    private static IKaigoIryoKikanFinder createKaigoIryoKikanFinder(int flg) {
        IKaigoIryoKikanFinder finder = mock(IKaigoIryoKikanFinder.class);
        when(finder.get介護医療機関(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
        return finder;
    }

    private static List<KaigoDoctorEntity> createKaigoDoctorEntityList(int flg) {
        List<KaigoDoctorEntity> list = new ArrayList<>();
        for (int count = 0; count < flg; count++) {
            list.add(createKaigoDoctorEntity(flg));
        }
        return list;
    }

    private static KaigoDoctorEntity createKaigoDoctorEntity(int flg) {
        return flg != 0 ? KaigoDoctorEntityMock.getSpiedInstance() : null;
    }

    private static KaigoDoctor createKaigoDoctor() {
        return new KaigoDoctor(mock(IDoctor.class), mock(IShujii.class), mock(KaigoIryoKikan.class));
    }
}
