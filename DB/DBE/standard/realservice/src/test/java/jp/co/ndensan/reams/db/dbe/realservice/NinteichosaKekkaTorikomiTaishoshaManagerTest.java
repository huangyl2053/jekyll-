/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

//import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
//import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
//import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
//import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
//import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
//import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
//import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoNinteiShoriTaishoshaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteichosaKekkaTorikomiTaishoshaDac;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
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
    private static INinteiChosaIraiJohoDac chosaIraiJohoDac;
    private static INinteichosaKekkaTorikomiTaishoshaDac torikomiTaishoshaDac;
    private static ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
    private static RString 支所コード = new RString("0001");
    private static List<NinteichosaKekkaTorikomiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        chosaIraiJohoDac = mock(INinteiChosaIraiJohoDac.class);
        torikomiTaishoshaDac = mock(INinteichosaKekkaTorikomiTaishoshaDac.class);

    }

    public static class get認定調査結果取込対象者全件 extends DbeTestBase {

        @Test
        public void get認定調査結果取込対象者全件で_認定調査結果取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(chosaIraiJohoDac, torikomiTaishoshaDac);
            resultList = sut.get認定調査結果取込対象者全件();
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    public static class get認定調査結果取込対象者全件_証記載保険者番号 extends DbeTestBase {

        @Test
        public void get認定調査結果取込対象者全件で_証記載保険者番号を指定し_認定調査結果取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号(証記載保険者番号)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(chosaIraiJohoDac, torikomiTaishoshaDac);
            resultList = sut.get認定調査結果取込対象者全件(証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    public static class get認定調査結果取込対象者全件_証記載保険者番号_支所コード extends DbeTestBase {

        @Test
        public void get認定調査結果取込対象者全件で_証記載保険者番号と支所コードを指定し_認定調査結果取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select証記載保険者番号及び支所コード(証記載保険者番号, 支所コード)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(chosaIraiJohoDac, torikomiTaishoshaDac);
            resultList = sut.get認定調査結果取込対象者全件(証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }
    // TODO N8187 久保田英男 対象者が存在する場合の処理の確認は結合試験で確認する。
//
//    public static class get認定調査結果取込対象者全件_対象者が登録されている extends DbeTestBase {
//
//        @Test
//        public void get認定調査結果取込対象者全件で_認定調査結果取込対象者の取得条件に一致するデータが1件登録されているとき_1件の対象者を取得する() {
//            when(torikomiTaishoshaDac.selectAll()).thenReturn(create介護認定処理対象者List(1));
//            when(chosaIraiJohoDac.select(any(RString.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(create認定調査依頼情報Entity());
//            sut = new NinteichosaKekkaTorikomiTaishoshaManager(chosaIraiJohoDac, torikomiTaishoshaDac);
//            resultList = sut.get認定調査結果取込対象者全件();
//            assertThat(resultList.size(), is(1));
//        }
//    }
//
//    private static DbT5006NinteichosaIraiJohoEntity create認定調査依頼情報Entity() {
//        DbT5006NinteichosaIraiJohoEntity entity = new DbT5006NinteichosaIraiJohoEntity();
//        entity.setNinteichosaItakusakiCode(new KaigoJigyoshaNo(new RString("123456")));
//        entity.setChousainCode(new NinteichosainBangoCode(new RString("123")));
//        return entity;
//    }
//
//    private static List<KaigoNinteiShoriTaishoshaEntity> create介護認定処理対象者List(int num) {
//
//        List<KaigoNinteiShoriTaishoshaEntity> list = new ArrayList<>();
//        KaigoNinteiShoriTaishoshaEntity entity;
//        for (int i = 0; i < num; i++) {
//            entity = new KaigoNinteiShoriTaishoshaEntity();
//            DbT5005NinteiShinchokuJohoEntity shinchokuEntity = new DbT5005NinteiShinchokuJohoEntity();
//            shinchokuEntity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("1")));
//            entity.setNinteiShinchokuJohoEntity(shinchokuEntity);
//
//            DbT5001NinteiShinseiJohoEntity shinseiEntity = new DbT5001NinteiShinseiJohoEntity();
//            shinseiEntity.setShoKisaiHokenshaNo(証記載保険者番号);
//            shinseiEntity.setNinteichosaIraiRirekiNo(1);
//            entity.setNinteiShinseiJohoEntity(shinseiEntity);
//            list.add(entity);
//        }
//
//        return list;
//    }
}
