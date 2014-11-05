/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.helper.YokaigoNinteiShinseiTestHelper;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaItakusakiTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.NinteichosaIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbe.business.helper.KaigoNinteichosainTestHelper;
import jp.co.ndensan.reams.db.dbe.business.helper.KojinTestHelper;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaIraiTestHelper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.ur.urf.realservice.INinteiChosainFinder;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;

/**
 * 認定調査依頼対象者を管理するクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaManagerTest extends DbeTestBase {

    private static NinteichosaIraiTaishoshaManager sut;
    private static NinteichosaIraiTaishoshaDac iraiTaishoshaDac;
    private static IKojinFinder kojinFinder;
    private static NinteichosaIraiManager ninteichosaIraiManager;
    private static NinteichosaItakusakiManager ninteichosaItakusakiManager;
    private static IKaigoJigyoshaFinder kaigoJigyoshaFinder;
    private static KaigoNinteichosainManager kaigoNinteichosainManager;
    private static INinteiChosainFinder ninteiChosainFinder;
    private static YokaigoNinteiProgressManager yokaigoninteiProgressManager;
    private static List<NinteichosaIraiTaishosha> resultList;
    private static final LasdecCode 市町村コード = new LasdecCode(new RString("123456"));
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final RString 支所コード = new RString("1234");

    @BeforeClass
    public static void setUpClass() {
        iraiTaishoshaDac = mock(NinteichosaIraiTaishoshaDac.class);
        kojinFinder = mock(IKojinFinder.class);
        ninteichosaIraiManager = mock(NinteichosaIraiManager.class);
        ninteichosaItakusakiManager = mock(NinteichosaItakusakiManager.class);
        kaigoJigyoshaFinder = mock(IKaigoJigyoshaFinder.class);
        kaigoNinteichosainManager = mock(KaigoNinteichosainManager.class);
        ninteiChosainFinder = mock(INinteiChosainFinder.class);
        yokaigoninteiProgressManager = mock(YokaigoNinteiProgressManager.class);
    }

    public static class get認定調査依頼対象者_市町村コード指定 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get認定調査依頼対象者_市町村コード指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(iraiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査依頼対象者_市町村コード指定で_認定調査依頼対象者が存在しない場合_EMPTY_LISTを返すこと() {
            when(iraiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(市町村コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査依頼対象者_市町村コード指定で_認定調査依頼対象者が1件存在する場合_1件取得すること() {
            when(iraiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者(1));
            IKojin kojin = create個人();
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(kojin);
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(ninteichosaItakusakiManager.get認定調査委託先介護事業者番号指定(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(boolean.class))).thenReturn(create認定調査委託先());
            when(kaigoJigyoshaFinder.get特定の事業者番号の介護事業者(any(RString.class))).thenReturn(mock(IKaigoJigyosha.class));
            when(kaigoNinteichosainManager.get介護認定調査員(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(create介護認定調査員());
            when(ninteiChosainFinder.get認定調査員(any(RString.class))).thenReturn(mock(INinteiChosain.class));
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(市町村コード);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get認定調査依頼対象者_市町村コード_証記載保険者番号指定 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get認定調査依頼対象者_市町村コード_証記載保険者番号指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(iraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査依頼対象者_市町村コード_証記載保険者番号指定で_認定調査依頼対象者が存在しない場合_EMPTY_LISTを返すこと() {
            when(iraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(市町村コード, 証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査依頼対象者_市町村コード_証記載保険者番号指定で_認定調査依頼対象者が1件存在する場合_1件取得すること() {
            when(iraiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(create介護認定処理対象者(1));
            IKojin kojin = create個人();
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(kojin);
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(ninteichosaItakusakiManager.get認定調査委託先介護事業者番号指定(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(boolean.class))).thenReturn(create認定調査委託先());
            when(kaigoJigyoshaFinder.get特定の事業者番号の介護事業者(any(RString.class))).thenReturn(mock(IKaigoJigyosha.class));
            when(kaigoNinteichosainManager.get介護認定調査員(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(create介護認定調査員());
            when(ninteiChosainFinder.get認定調査員(any(RString.class))).thenReturn(mock(INinteiChosain.class));
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(市町村コード, 証記載保険者番号);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get認定調査依頼対象者_市町村コード_証記載保険者番号_支所コード指定 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get認定調査依頼対象者_市町村コード_証記載保険者番号_支所コード指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(iraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(null, null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査依頼対象者_市町村コード_証記載保険者番号_支所コード指定で_認定調査依頼対象者が存在しない場合_EMPTY_LISTを返すこと() {
            when(iraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(市町村コード, 証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査依頼対象者_市町村コード_証記載保険者番号_支所コード指定で_認定調査依頼対象者が1件存在する場合_1件取得すること() {
            when(iraiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(create介護認定処理対象者(1));
            IKojin kojin = create個人();
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(kojin);
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(ninteichosaItakusakiManager.get認定調査委託先介護事業者番号指定(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(boolean.class))).thenReturn(create認定調査委託先());
            when(kaigoJigyoshaFinder.get特定の事業者番号の介護事業者(any(RString.class))).thenReturn(mock(IKaigoJigyosha.class));
            when(kaigoNinteichosainManager.get介護認定調査員(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(create介護認定調査員());
            when(ninteiChosainFinder.get認定調査員(any(RString.class))).thenReturn(mock(INinteiChosain.class));
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査依頼対象者(市町村コード, 証記載保険者番号, 支所コード);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class save認定調査依頼完了年月日 extends DbeTestBase {

        private static final NinteichosaIraiTaishosha 認定調査依頼対象者 = create認定調査依頼対象者();
        private static final FlexibleDate 認定調査依頼完了年月日 = new FlexibleDate(new RString("20140101"));

        @Test
        public void save認定調査依頼完了年月日_saveが成功した時_TRUEを返す() {
            when(yokaigoninteiProgressManager.save(any(YokaigoNinteiProgress.class))).thenReturn(true);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            assertThat(sut.save認定調査依頼完了年月日(認定調査依頼対象者, 認定調査依頼完了年月日), is(true));
        }

        @Test
        public void save認定調査依頼完了年月日_saveが失敗した時_FALSEを返す() {
            when(yokaigoninteiProgressManager.save(any(YokaigoNinteiProgress.class))).thenReturn(false);
            sut = new NinteichosaIraiTaishoshaManager(
                    iraiTaishoshaDac, kojinFinder, ninteichosaIraiManager, ninteichosaItakusakiManager,
                    kaigoJigyoshaFinder, kaigoNinteichosainManager, ninteiChosainFinder, yokaigoninteiProgressManager);
            assertThat(sut.save認定調査依頼完了年月日(認定調査依頼対象者, 認定調査依頼完了年月日), is(false));
        }
    }

    private static List<KaigoNinteiShoriTaishoshaEntity> create介護認定処理対象者(int num) {
        List<KaigoNinteiShoriTaishoshaEntity> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            KaigoNinteiShoriTaishoshaEntity entity = new KaigoNinteiShoriTaishoshaEntity();
            entity.setNinteiShinseiJohoEntity(YokaigoNinteiShinseiTestHelper.create認定申請情報Entity());
            entity.setNinteiShinchokuJohoEntity(NinteiShinchokuJohoEntityMock.create認定進捗情報Entity());
            list.add(entity);
        }
        return list;
    }

    private static NinteichosaIrai create認定調査依頼情報() {
        return NinteichosaIraiTestHelper.create認定調査依頼情報();
    }

    private static NinteichosaItakusaki create認定調査委託先() {
        return NinteichosaItakusakiTestHelper.create認定調査委託先();
    }

    private static KaigoNinteichosain create介護認定調査員() {
        return KaigoNinteichosainTestHelper.create認定調査員();
    }

    private static IKojin create個人() {
        return KojinTestHelper.create個人();
    }

    private static NinteichosaIraiTaishosha create認定調査依頼対象者() {
        return new NinteichosaIraiTaishosha(
                NinteiShinchokuJohoMock.create認定進捗情報(),
                new ShinseishoKanriNo(new RString("1234")),
                new ShoKisaiHokenshaNo(new RString("1234")),
                new KaigoHihokenshaNo(new RString("1234567890")),
                new FlexibleDate(new RString("20140101")),
                new Code(String.valueOf(NinteiShinseiKubunShinsei.新規申請.コード())),
                KojinTestHelper.create個人(),
                new RString("氏名"),
                new RString("住所"),
                NinteichosaItakusakiTestHelper.create認定調査委託先(),
                mock(IKaigoJigyosha.class),
                mock(INinteiChosain.class));
    }
}
