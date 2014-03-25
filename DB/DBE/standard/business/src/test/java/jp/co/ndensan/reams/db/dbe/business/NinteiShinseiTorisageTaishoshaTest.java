/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
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
 * 要介護認定申請取下げ対象者クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiTorisageTaishoshaTest extends TestBase {

    public static class コンストラクタのテスト {

//        private ShinseishoKanriNo 申請書管理No = mock(ShinseishoKanriNo.class);
//        private ShichosonCode 市町村コード = mock(ShichosonCode.class);
//        private KaigoHihokenshaNo 被保険者番号 = mock(KaigoHihokenshaNo.class);
//        private FlexibleDate 認定申請年月日 = mock(FlexibleDate.class);
        private ShinseishoKanriNo 申請書管理No = new ShinseishoKanriNo(new RString("0000000001"));
        private ShichosonCode 市町村コード = new ShichosonCode(new RString("20205"));
        private KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("0000000001"));
        private FlexibleDate 認定申請年月日 = new FlexibleDate("00000000");
        private NinteiShinseiKubunShinsei 認定申請区分_申請時コード = NinteiShinseiKubunShinsei.新規申請;
//        private NinteiShinseiTorisage 認定申請取下げ = mock(NinteiShinseiTorisage.class);
        private NinteiShinseiTorisage 認定申請取下げ = new NinteiShinseiTorisage(TorisageKubun.認定申請有効,
                new RString("取下げ理由"), new FlexibleDate("00000000"), ShinsaKeizokuKubun.継続する);

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(申請書管理No, 市町村コード,
                    被保険者番号, 認定申請年月日, 認定申請区分_申請時コード, 認定申請取下げ);
            assertThat(sut, instanceOf(NinteiShinseiTorisageTaishosha.class));
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理Noにnullが渡されたとき_NullPointerExceptionが発生する() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(null, 市町村コード,
                    被保険者番号, 認定申請年月日, 認定申請区分_申請時コード, 認定申請取下げ);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(申請書管理No, null,
                    被保険者番号, 認定申請年月日, 認定申請区分_申請時コード, 認定申請取下げ);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(申請書管理No, 市町村コード,
                    null, 認定申請年月日, 認定申請区分_申請時コード, 認定申請取下げ);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請年月日にnullが渡されたとき_NullPointerExceptionが発生する() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(申請書管理No, 市町村コード,
                    被保険者番号, null, 認定申請区分_申請時コード, 認定申請取下げ);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請区分_申請時コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(申請書管理No, 市町村コード,
                    被保険者番号, 認定申請年月日, null, 認定申請取下げ);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請取下げにnullが渡されたとき_NullPointerExceptionが発生する() {
            NinteiShinseiTorisageTaishosha sut = new NinteiShinseiTorisageTaishosha(申請書管理No, 市町村コード,
                    被保険者番号, 認定申請年月日, 認定申請区分_申請時コード, null);
        }
    }
}
