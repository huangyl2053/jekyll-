/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekkaTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IKaigoNinteichosainDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteiShinseiJohoMock;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IKaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IKojinDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 認定調査結果取込対象者を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaTorikomiTaishoshaManagerTest extends TestBase {

    private static NinteichosaKekkaTorikomiTaishoshaManager sut;
    private static INinteiShinchokuJohoDac shinchokuJohoDac;
    private static INinteiShinseiJohoDac shinseiJohoDac;
    private static INinteiChosaIraiJohoDac chosaIraiJohoDac;
    private static IKaigoNinteichosainDac ninteichosainDac;
    private static INinteichosaItakusakiDac ninteichosaItakusakiDac;
    private static IKaigoJigyoshaDac kaigoJigyoshaDac;
    private static IKojinDac kojinDac;
    private static RString 支所コード = new RString("0001");
    private static RString 初期支所コード = new RString("0");
    private static List<NinteichosaKekkaTorikomiTaishosha> resultList;

    public static class get認定調査結果取込対象者全件 extends TestBase {

        @Override
        protected void setUp() {
            shinchokuJohoDac = mock(INinteiShinchokuJohoDac.class);
            shinseiJohoDac = mock(INinteiShinseiJohoDac.class);
            chosaIraiJohoDac = mock(INinteiChosaIraiJohoDac.class);
            ninteichosainDac = mock(IKaigoNinteichosainDac.class);
            ninteichosaItakusakiDac = mock(INinteichosaItakusakiDac.class);
            kaigoJigyoshaDac = mock(IKaigoJigyoshaDac.class);
            kojinDac = mock(IKojinDac.class);
        }

        @Test
        public void 認定調査結果取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONI_EMPTYを返す() {
            when(shinchokuJohoDac.select依頼済認定調査未完了()).thenReturn(create認定進捗情報EntityList(0));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(shinchokuJohoDac, shinseiJohoDac, chosaIraiJohoDac, ninteichosainDac, ninteichosaItakusakiDac, kaigoJigyoshaDac, kojinDac);
            resultList = sut.get認定調査結果取込対象者全件(支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 認定調査結果取込対象者の取得条件に一致するデータが登録されているが_支所コードが一致しないとき_COLLECTIONI_EMPTYを返す() {
            when(shinchokuJohoDac.select依頼済認定調査未完了()).thenReturn(create認定進捗情報EntityList(1));
            when(shinseiJohoDac.select(new ShinseishoKanriNo(new RString("1")))).thenReturn(create認定申請情報(1, 初期支所コード));
            sut = new NinteichosaKekkaTorikomiTaishoshaManager(shinchokuJohoDac, shinseiJohoDac, chosaIraiJohoDac, ninteichosainDac, ninteichosaItakusakiDac, kaigoJigyoshaDac, kojinDac);
            resultList = sut.get認定調査結果取込対象者全件(支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    private static List<DbT5005NinteiShinchokuJohoEntity> create認定進捗情報EntityList(int flg) {
        List<DbT5005NinteiShinchokuJohoEntity> list = new ArrayList<>();
        if (flg == 0) {
            list = Collections.EMPTY_LIST;
        } else {
            for (int i = 0; i < flg; i++) {
                list.add(create認定進捗情報(flg));
            }
        }
        return list;
    }

    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報(int flg) {
        DbT5005NinteiShinchokuJohoEntity entity = NinteiShinchokuJohoMock.create認定進捗情報Entity();
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString(Integer.toString(flg)));
        entity.setShinseishoKanriNo(申請書管理番号);
        return entity;
    }

    private static DbT5001NinteiShinseiJohoEntity create認定申請情報(int flg, RString 支所コード) {
        DbT5001NinteiShinseiJohoEntity entity = NinteiShinseiJohoMock.create認定申請情報Entity();
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString(Integer.toString(flg)));
        entity.setShinseishoKanriNo(申請書管理番号);
        entity.setShishoCode(支所コード);
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0002")));
        return entity;
    }
}
