/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinseiJohoTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoSakuseiIraiMock;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書依頼対象者の情報を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiTaishoshaFinderTest extends DbeTestBase {

    private static ShujiiIkenshoIraiTaishoshaFinder sut;
    private static ShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
    private static IKojinFinder kojinFinder;
    private static ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager;
    private static KaigoIryoKikanFinder kaigoIryoKikanFinder;
    private static ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static RString 支所コード = new RString("0002");
    private static List<ShujiiIkenshoIraiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        shujiiIkenshoIraiTaishoshaDac = mock(ShujiiIkenshoIraiTaishoshaDac.class);
        kojinFinder = mock(IKojinFinder.class);
        shujiiManager = mock(ShujiiIkenshoSakuseiIraiKirokuManager.class);
        kaigoIryoKikanFinder = mock(KaigoIryoKikanFinder.class);
    }

    public static class get主治医意見書作成依頼対象者_引数なし extends DbeTestBase {

        @Test
        public void get主治医意見書作成依頼対象者で_主治医意見書作成依頼対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(shujiiIkenshoIraiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者();
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者で_主治医意見書作成依頼対象者が1件登録されているとき_1件の対象者を取得する() {
            when(shujiiIkenshoIraiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(create個人());
            when(kaigoIryoKikanFinder.get介護医療機関(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者();
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get主治医意見書作成依頼対象者_証記載保険者番号 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書作成依頼対象者_証記載保険者番号の指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者(null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_証記載保険者番号の指定で_主治医意見書作成依頼対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者(証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_証記載保険者番号の指定で_主治医意見書作成依頼対象者が1件登録されているとき_1件の対象者を取得する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(create個人());
            when(kaigoIryoKikanFinder.get介護医療機関(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者(証記載保険者番号);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get主治医意見書作成依頼対象者_証記載保険者番号_支所コード extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書作成依頼対象者_証記載保険者番号と支所コードの指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者(null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_証記載保険者番号と支所コードの指定で_主治医意見書作成依頼対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者(証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_証記載保険者番号と支所コードの指定で_主治医意見書作成依頼対象者が1件登録されているとき_1件の対象者を取得する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(create個人());
            when(kaigoIryoKikanFinder.get介護医療機関(any(ShoKisaiHokenshaNo.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
            sut = new ShujiiIkenshoIraiTaishoshaFinder(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder);
            resultList = sut.get主治医意見書作成依頼対象者(証記載保険者番号, 支所コード);
            assertThat(resultList.size(), is(1));
        }
    }

    private static List<KaigoNinteiShoriTaishoshaEntity> create介護認定処理対象者List(int num) {
        List<KaigoNinteiShoriTaishoshaEntity> list = new ArrayList<>();
        KaigoNinteiShoriTaishoshaEntity entity;
        for (int i = 0; i < num; i++) {
            entity = new KaigoNinteiShoriTaishoshaEntity();
            DbT5005NinteiShinchokuJohoEntity shinchokuEntity = NinteiShinchokuJohoMock.create認定進捗情報Entity();
            entity.setNinteiShinchokuJohoEntity(shinchokuEntity);

            DbT5001NinteiShinseiJohoEntity shinseiEntity = NinteiShinseiJohoTestHelper.create認定申請情報Entity();
            shinseiEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            shinseiEntity.setShishoCode(支所コード);
            entity.setNinteiShinseiJohoEntity(shinseiEntity);
            list.add(entity);
        }

        return list;
    }

    private static ShujiiIkenshoSakuseiIrai create主治医意見書作成依頼() {
        return ShujiiIkenshoSakuseiIraiMock.getSpiedInstance();
    }

    private static IKojin create個人() {
        return KojinTestHelper.create個人();
    }
}
