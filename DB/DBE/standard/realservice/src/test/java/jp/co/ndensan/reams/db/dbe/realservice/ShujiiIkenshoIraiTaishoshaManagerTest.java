/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.business.helper.KojinTestHelper;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.YokaigoNinteiShinseiTestHelper;
import jp.co.ndensan.reams.db.dbe.business.helper.ShujiiIkenshoSakuseiIraiMock;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class ShujiiIkenshoIraiTaishoshaManagerTest extends DbeTestBase {

    private static ShujiiIkenshoIraiTaishoshaManager sut;
    private static ShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
    private static IKojinFinder kojinFinder;
    private static ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager;
    private static KaigoIryoKikanFinder kaigoIryoKikanFinder;
    private static YokaigoNinteiProgressManager yokaigoninteiProgressManager;
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final LasdecCode 市町村コード = new LasdecCode(new RString("000001"));
    private static final RString 支所コード = new RString("0002");
    private static List<ShujiiIkenshoIraiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        shujiiIkenshoIraiTaishoshaDac = mock(ShujiiIkenshoIraiTaishoshaDac.class);
        kojinFinder = mock(IKojinFinder.class);
        shujiiManager = mock(ShujiiIkenshoSakuseiIraiKirokuManager.class);
        kaigoIryoKikanFinder = mock(KaigoIryoKikanFinder.class);
        yokaigoninteiProgressManager = mock(YokaigoNinteiProgressManager.class);
    }

    public static class get主治医意見書作成依頼対象者_市町村コード extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書作成依頼対象者_市町村コードの指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(shujiiIkenshoIraiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_市町村コードの指定で_主治医意見書作成依頼対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(shujiiIkenshoIraiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(市町村コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_市町村コードの指定で_主治医意見書作成依頼対象者が1件登録されているとき_1件の対象者を取得する() {
            when(shujiiIkenshoIraiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(
                    any(LasdecCode.class), any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            IKojin kojin = create個人();
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(kojin);
            when(kaigoIryoKikanFinder.get介護医療機関(any(LasdecCode.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(市町村コード);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号の指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号の指定で_主治医意見書作成依頼対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(市町村コード, 証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号の指定で_主治医意見書作成依頼対象者が1件登録されているとき_1件の対象者を取得する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(
                    any(LasdecCode.class), any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            IKojin kojin = create個人();
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(kojin);
            when(kaigoIryoKikanFinder.get介護医療機関(any(LasdecCode.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(市町村コード, 証記載保険者番号);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号_支所コード extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号と支所コードの指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(null, null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号と支所コードの指定で_主治医意見書作成依頼対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(市町村コード, 証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書作成依頼対象者_市町村コード_証記載保険者番号と支所コードの指定で_主治医意見書作成依頼対象者が1件登録されているとき_1件の対象者を取得する() {
            when(shujiiIkenshoIraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(
                    any(LasdecCode.class), any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            IKojin kojin = create個人();
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(kojin);
            when(kaigoIryoKikanFinder.get介護医療機関(any(LasdecCode.class), any(KaigoIryoKikanCode.class))).thenReturn(mock(KaigoIryoKikan.class));
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            resultList = sut.get主治医意見書作成依頼対象者(市町村コード, 証記載保険者番号, 支所コード);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class save主治医意見書作成依頼完了年月日 extends DbeTestBase {

        private static final ShujiiIkenshoIraiTaishosha 主治医意見書作成依頼対象者 = create主治医意見書作成依頼対象者();
        private static final FlexibleDate 主治医意見書作成依頼完了年月日 = new FlexibleDate(new RString("20140101"));

        @Test
        public void save主治医意見書作成依頼完了年月日_saveが成功した時_TRUEを返す() {
            when(yokaigoninteiProgressManager.save(any(YokaigoNinteiProgress.class))).thenReturn(true);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            assertThat(sut.save主治医意見書作成依頼完了年月日(主治医意見書作成依頼対象者, 主治医意見書作成依頼完了年月日), is(true));
        }

        @Test
        public void save主治医意見書作成依頼完了年月日_saveが失敗した時_FALSEを返す() {
            when(yokaigoninteiProgressManager.save(any(YokaigoNinteiProgress.class))).thenReturn(false);
            sut = new ShujiiIkenshoIraiTaishoshaManager(shujiiIkenshoIraiTaishoshaDac, kojinFinder, shujiiManager, kaigoIryoKikanFinder, yokaigoninteiProgressManager);
            assertThat(sut.save主治医意見書作成依頼完了年月日(主治医意見書作成依頼対象者, 主治医意見書作成依頼完了年月日), is(false));
        }
    }

    private static List<KaigoNinteiShoriTaishoshaEntity> create介護認定処理対象者List(int num) {
        List<KaigoNinteiShoriTaishoshaEntity> list = new ArrayList<>();
        KaigoNinteiShoriTaishoshaEntity entity;
        for (int i = 0; i < num; i++) {
            entity = new KaigoNinteiShoriTaishoshaEntity();
            DbT5005NinteiShinchokuJohoEntity shinchokuEntity = NinteiShinchokuJohoEntityMock.create認定進捗情報Entity();
            entity.setNinteiShinchokuJohoEntity(shinchokuEntity);

            DbT5001NinteiShinseiJohoEntity shinseiEntity = YokaigoNinteiShinseiTestHelper.create認定申請情報Entity();
            shinseiEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            shinseiEntity.setShishoCode(new ShishoCode(支所コード));
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

    private static ShujiiIkenshoIraiTaishosha create主治医意見書作成依頼対象者() {
        return new ShujiiIkenshoIraiTaishosha(
                NinteiShinchokuJohoMock.create認定進捗情報(),
                new ShinseishoKanriNo(new RString("1234")),
                new ShoKisaiHokenshaNo(new RString("1234")),
                new KaigoHihokenshaNo(new RString("1234567890")),
                new FlexibleDate(new RString("20140101")),
                new Code(String.valueOf(NinteiShinseiKubunShinsei.更新申請.コード())),
                KojinTestHelper.create個人(),
                new RString("氏名"),
                new RString("住所"),
                mock(KaigoIryoKikan.class),
                mock(KaigoDoctor.class));
    }
}
