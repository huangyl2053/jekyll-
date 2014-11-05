/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIrai;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.business.helper.KojinTestHelper;
import jp.co.ndensan.reams.db.dbe.business.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.YokaigoNinteiShinseiTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaIraiMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.NinteichosaKekkaTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

/**
 * 認定調査結果取込対象者を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaTorikomiTaishoshaManagerTest extends DbeTestBase {

    private static NinteichosaKekkaTorikomiTaishoshaManager sut;
    private static NinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;
    private static NinteichosaIraiManager ninteichosaIraiManager;
    private static KaigoNinteichosainManager kaigoNinteichosainManager;
    private static IKojinFinder kojinFinder;
    private static YokaigoNinteiProgressManager yokaigoninteiProgressManager;
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static final LasdecCode 市町村コード = new LasdecCode(new RString("000001"));
    private static final ShishoCode 支所コード = new ShishoCode(new RString("0001"));
    private static List<NinteichosaKekkaTorikomiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        torikomiTaishoshaDac = mock(NinteichosaKekkaTorikomiTaishoshaDac.class);
        ninteichosaIraiManager = mock(NinteichosaIraiManager.class);
        kaigoNinteichosainManager = mock(KaigoNinteichosainManager.class);
        kojinFinder = mock(IKojinFinder.class);
        yokaigoninteiProgressManager = mock(YokaigoNinteiProgressManager.class);
    }

    public static class get認定調査結果取込対象者_市町村コード extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get認定調査結果取込対象者_市町村コードの指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者_市町村コードの指定で_認定調査結果取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者_市町村コードの指定で_認定調査結果取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者List(1));
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(kaigoNinteichosainManager.get介護認定調査員(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(mock(KaigoNinteichosain.class));
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(mock(IKojin.class));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get認定調査結果取込対象者_市町村コード_証記載保険者番号 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get認定調査結果取込対象者_市町村コードと証記載保険者番号の指定で_引数の市町村コードがNULLの場合_NullPointerExceptionが発生する() {
            when(torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(null, 証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test(expected = NullPointerException.class)
        public void get認定調査結果取込対象者_市町村コードと証記載保険者番号の指定で_引数の証記載保険者番号がNULLの場合_NullPointerExceptionが発生する() {
            when(torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者_市町村コードと証記載保険者番号の指定で_認定調査結果取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード, 証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者_市町村コードと証記載保険者番号の指定で_認定調査結果取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(create介護認定処理対象者List(1));
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(kaigoNinteichosainManager.get介護認定調査員(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(mock(KaigoNinteichosain.class));
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(mock(IKojin.class));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード, 証記載保険者番号);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get認定調査結果取込対象者_市町村コード_証記載保険者番号_支所コード extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get認定調査結果取込対象者で_市町村コードと証記載保険者番号と支所コードの指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード.value())).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(null, null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者で_市町村コードと証記載保険者番号と支所コードの指定で_認定調査結果取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード.value())).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード, 証記載保険者番号, 支所コード.value());
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者で_市町村コードと証記載保険者番号と支所コードの指定で_認定調査結果取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(create介護認定処理対象者List(1));
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(kaigoNinteichosainManager.get介護認定調査員(any(LasdecCode.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(mock(KaigoNinteichosain.class));
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(mock(IKojin.class));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            resultList = sut.get認定調査結果取込対象者(市町村コード, 証記載保険者番号, 支所コード.value());
            assertThat(resultList.size(), is(1));
        }
    }

    public static class save認定調査完了年月日 extends DbeTestBase {

        private static final NinteichosaKekkaTorikomiTaishosha 認定調査結果取込対象者 = create認定調査結果取込対象者();
        private static final FlexibleDate 認定調査完了年月日 = new FlexibleDate(new RString("20140101"));

        @Test
        public void save認定調査完了年月日_saveが成功した時_TRUEを返す() {
            when(yokaigoninteiProgressManager.save(any(YokaigoNinteiProgress.class))).thenReturn(true);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            assertThat(sut.save認定調査完了年月日(認定調査結果取込対象者, 認定調査完了年月日), is(true));
        }

        @Test
        public void save認定調査完了年月日_saveが失敗した時_FALSEを返す() {
            when(yokaigoninteiProgressManager.save(any(YokaigoNinteiProgress.class))).thenReturn(false);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, kojinFinder, yokaigoninteiProgressManager);
            assertThat(sut.save認定調査完了年月日(認定調査結果取込対象者, 認定調査完了年月日), is(false));
        }
    }

    private static NinteichosaIrai create認定調査依頼情報() {
        return NinteichosaIraiMapper.to認定調査依頼情報(NinteichosaIraiTestHelper.create認定調査依頼情報Entity());
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
            shinseiEntity.setShishoCode(支所コード);
            entity.setNinteiShinseiJohoEntity(shinseiEntity);
            list.add(entity);
        }

        return list;
    }

    private static NinteichosaKekkaTorikomiTaishosha create認定調査結果取込対象者() {
        return new NinteichosaKekkaTorikomiTaishosha(
                NinteiShinchokuJohoMock.create認定進捗情報(),
                mock(YokaigoNinteiShinsei.class),
                mock(NinteichosaIrai.class),
                mock(KaigoNinteichosain.class),
                KojinTestHelper.create個人());
    }
}
