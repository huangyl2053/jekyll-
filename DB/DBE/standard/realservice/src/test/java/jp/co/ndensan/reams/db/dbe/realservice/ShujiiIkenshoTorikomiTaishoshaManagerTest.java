/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinseiJohoTestHelper;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoSakuseiIraiMock;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShujiiIkenshoTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書取込対象者を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoTorikomiTaishoshaManagerTest extends DbeTestBase {

    private static ShujiiIkenshoTorikomiTaishoshaManager sut;
    private static ShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac;
    private static ShujiiIkenshoSakuseiIraiKirokuManager shujiiManager;
    private static IKojinFinder kojinFinder;
    private static ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static RString 支所コード = new RString("0001");
    private static List<ShujiiIkenshoTorikomiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        torikomiTaishoshaDac = mock(ShujiiIkenshoTorikomiTaishoshaDac.class);
        shujiiManager = mock(ShujiiIkenshoSakuseiIraiKirokuManager.class);
        kojinFinder = mock(IKojinFinder.class);
    }

    public static class get主治医意見書取込対象者 extends DbeTestBase {

        @Test
        public void get主治医意見書取込対象者で_主治医意見書取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者();
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書取込対象者で_主治医意見書取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(mock(IKojin.class));
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者();
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get主治医意見書取込対象者_証記載保険者番号 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書取込対象者_証記載保険者番号の指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(torikomiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者(null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書取込対象者_証記載保険者番号の指定で_主治医意見書取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者(証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書取込対象者_証記載保険者番号の指定で_主治医意見書取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.select証記載保険者番号(any(ShoKisaiHokenshaNo.class))).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(mock(IKojin.class));
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者(証記載保険者番号);
            assertThat(resultList.size(), is(1));
        }
    }

    public static class get主治医意見書取込対象者_証記載保険者番号_支所コード extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void get主治医意見書取込対象者_証記載保険者番号と支所コードの指定で_引数がNULLの場合_NullPointerExceptionが発生する() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者(null, null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書取込対象者_証記載保険者番号と支所コードの指定で_主治医意見書取込対象者が登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者(証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void get主治医意見書取込対象者_証記載保険者番号と支所コードの指定で_主治医意見書取込対象者が1件登録されているとき_1件の対象者を取得する() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(create介護認定処理対象者List(1));
            when(shujiiManager.get主治医意見書作成依頼情報(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(create主治医意見書作成依頼());
            when(kojinFinder.get個人(any(ShikibetsuCode.class))).thenReturn(mock(IKojin.class));
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac, shujiiManager, kojinFinder);
            resultList = sut.get主治医意見書取込対象者(証記載保険者番号, 支所コード);
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
}
