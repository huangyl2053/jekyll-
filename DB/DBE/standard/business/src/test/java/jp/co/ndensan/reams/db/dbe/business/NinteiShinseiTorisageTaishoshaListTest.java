/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiTorisageTaishoshaListTest extends TestBase {

    public static class get認定申請取下げ対象者のテスト {

        @Test
        public void 申請書管理番号に10を指定したとき_申請書管理番号に10を持つ認定申請取下げ対象者が返る() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo((new RString("10")));
            NinteiShinseiTorisageTaishoshaList sut = new NinteiShinseiTorisageTaishoshaList(create認定申請取下げ対象者List());
            assertThat(sut.get認定申請取下げ対象者(申請書管理番号).get申請書管理No(), is(申請書管理番号));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 申請書管理番号に存在しない値を指定したとき_例外が発生する() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo((new RString("65536")));
            NinteiShinseiTorisageTaishoshaList sut = new NinteiShinseiTorisageTaishoshaList(create認定申請取下げ対象者List());
            sut.get認定申請取下げ対象者(申請書管理番号);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 申請書管理番号にnullを指定したとき_例外が発生する() {
            NinteiShinseiTorisageTaishoshaList sut = new NinteiShinseiTorisageTaishoshaList(create認定申請取下げ対象者List());
            sut.get認定申請取下げ対象者(null);
        }
    }

    public static class sizeのテスト {

        @Test
        public void 引数から6件のリストを渡したとき_Listのサイズに6が返る() {
            NinteiShinseiTorisageTaishoshaList sut = new NinteiShinseiTorisageTaishoshaList(create認定申請取下げ対象者List());
            assertThat(sut.size(), is(6));
        }
    }

    private static List<NinteiShinseiTorisageTaishosha> create認定申請取下げ対象者List() {
        List<NinteiShinseiTorisageTaishosha> taishoshaList = new ArrayList<>();
        taishoshaList.add(create認定申請取下げ対象者(new ShinseishoKanriNo(new RString("1"))));
        taishoshaList.add(create認定申請取下げ対象者(new ShinseishoKanriNo(new RString("4"))));
        taishoshaList.add(create認定申請取下げ対象者(new ShinseishoKanriNo(new RString("10"))));
        taishoshaList.add(create認定申請取下げ対象者(new ShinseishoKanriNo(new RString("19"))));
        taishoshaList.add(create認定申請取下げ対象者(new ShinseishoKanriNo(new RString("33"))));
        taishoshaList.add(create認定申請取下げ対象者(new ShinseishoKanriNo(new RString("48"))));
        return taishoshaList;
    }

    private static NinteiShinseiTorisageTaishosha create認定申請取下げ対象者(ShinseishoKanriNo 申請書管理番号) {
//        ShoKisaiHokenshaNo 証記載保険者番号 = mock(ShoKisaiHokenshaNo.class);
//        KaigoHihokenshaNo 被保険者番号 = mock(KaigoHihokenshaNo.class);
//        FlexibleDate 認定申請年月日 = mock(FlexibleDate.class);
        ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("20205"));
        KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("0000000001"));
        FlexibleDate 認定申請年月日 = new FlexibleDate("00000000");
        NinteiShinseiKubunShinsei 認定申請区分_申請時コード = NinteiShinseiKubunShinsei.新規申請;
//        NinteiShinseiTorisage 認定申請取下げ = mock(NinteiShinseiTorisage.class);

        NinteiShinseiTorisage 認定申請取下げ = new NinteiShinseiTorisage(TorisageKubun.認定申請有効,
                new TorisageRiyu(new RString("取下げ理由")), new FlexibleDate("00000000"), ShinsaKeizokuKubun.継続する);

        return new NinteiShinseiTorisageTaishosha(申請書管理番号, 証記載保険者番号,
                被保険者番号, 認定申請年月日, 認定申請区分_申請時コード, 認定申請取下げ);
    }
}
