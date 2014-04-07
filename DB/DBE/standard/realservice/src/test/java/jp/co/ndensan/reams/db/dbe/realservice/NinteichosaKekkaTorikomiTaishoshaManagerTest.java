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
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaIraiTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteichosaIraiMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteichosaKekkaTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.realservice.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
    private static INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;
    private static NinteichosaIraiManager ninteichosaIraiManager;
    private static KaigoNinteichosainManager kaigoNinteichosainManager;
    private static IShikibetsuTaishoFinder shikibetsuTaishoFinder;
    private static ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static RString 支所コード = new RString("0001");
    private static List<NinteichosaKekkaTorikomiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        torikomiTaishoshaDac = mock(INinteichosaKekkaTorikomiTaishoshaDac.class);
        ninteichosaIraiManager = mock(NinteichosaIraiManager.class);
        kaigoNinteichosainManager = mock(KaigoNinteichosainManager.class);
        shikibetsuTaishoFinder = mock(IShikibetsuTaishoFinder.class);
    }

    public static class get認定調査結果取込対象者全件 extends DbeTestBase {

        @Test
        public void get認定調査結果取込対象者全件で_認定調査結果取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, shikibetsuTaishoFinder);
            resultList = sut.get認定調査結果取込対象者全件();
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者全件で_認定調査結果取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者List(1));
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(kaigoNinteichosainManager.get介護認定調査員(any(ShoKisaiHokenshaNo.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(mock(KaigoNinteichosain.class));
            when(shikibetsuTaishoFinder.get識別対象(any(ShikibetsuCode.class))).thenReturn(mock(IShikibetsuTaisho.class));
            when(shikibetsuTaishoFinder.get識別対象(any(ShikibetsuCode.class)).to個人()).thenReturn(mock(IKojin.class));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, shikibetsuTaishoFinder);
            resultList = sut.get認定調査結果取込対象者全件();
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get認定調査結果取込対象者全件_証記載保険者番号 extends DbeTestBase {

        @Test
        public void get認定調査結果取込対象者全件_証記載保険者番号の指定時_認定調査結果取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, shikibetsuTaishoFinder);
            resultList = sut.get認定調査結果取込対象者全件(証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者全件_証記載保険者番号の指定時_認定調査結果取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(create介護認定処理対象者List(1));
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(kaigoNinteichosainManager.get介護認定調査員(any(ShoKisaiHokenshaNo.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(mock(KaigoNinteichosain.class));
            when(shikibetsuTaishoFinder.get識別対象(any(ShikibetsuCode.class))).thenReturn(mock(IShikibetsuTaisho.class));
            when(shikibetsuTaishoFinder.get識別対象(any(ShikibetsuCode.class)).to個人()).thenReturn(mock(IKojin.class));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, shikibetsuTaishoFinder);
            resultList = sut.get認定調査結果取込対象者全件(証記載保険者番号);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get認定調査結果取込対象者全件_証記載保険者番号_支所コード extends DbeTestBase {

        @Test
        public void get認定調査結果取込対象者全件で_証記載保険者番号と支所コードの指定時_認定調査結果取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, shikibetsuTaishoFinder);
            resultList = sut.get認定調査結果取込対象者全件(証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get認定調査結果取込対象者全件で_証記載保険者番号と支所コードの指定時_認定調査結果取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(create介護認定処理対象者List(1));
            when(ninteichosaIraiManager.get認定調査依頼情報(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報());
            when(kaigoNinteichosainManager.get介護認定調査員(any(ShoKisaiHokenshaNo.class), any(KaigoJigyoshaNo.class), any(KaigoNinteichosainNo.class))).thenReturn(mock(KaigoNinteichosain.class));
            when(shikibetsuTaishoFinder.get識別対象(any(ShikibetsuCode.class))).thenReturn(mock(IShikibetsuTaisho.class));
            when(shikibetsuTaishoFinder.get識別対象(any(ShikibetsuCode.class)).to個人()).thenReturn(mock(IKojin.class));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(torikomiTaishoshaDac, ninteichosaIraiManager, kaigoNinteichosainManager, shikibetsuTaishoFinder);
            resultList = sut.get認定調査結果取込対象者全件(証記載保険者番号, 支所コード);
            assertThat(resultList.size(), is(1));
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
            DbT5005NinteiShinchokuJohoEntity shinchokuEntity = NinteiShinchokuJohoMock.create認定進捗情報Entity();
            entity.setNinteiShinchokuJohoEntity(shinchokuEntity);

            DbT5001NinteiShinseiJohoEntity shinseiEntity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
            shinseiEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            shinseiEntity.setShishoCode(支所コード);
            entity.setNinteiShinseiJohoEntity(shinseiEntity);
            list.add(entity);
        }

        return list;
    }
}
