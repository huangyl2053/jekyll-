/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.NinteichosaResult;

import jp.co.ndensan.reams.db.dbe.business.core.NinteichosahyoKaitoHairetsuCode;
import jp.co.ndensan.reams.db.dbe.definition.core.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定に使用する認定調査票結果クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosahyoResultTest {

    private static NinteichosahyoKaitoHairetsuCode sut;

    public static class コンストラクタのテスト {

        private RString 調査項目回答;
        private ShinseishoKanriNo 申請書管理番号;
        private NinteichosaIraiRirekiNo 要介護認定調査履歴番号;
        private KoroshoIFKubun 厚労省IF区分;

        @Before
        public void setUp() {
            調査項目回答 = new RString("0001122341212234333332110001223300012");
            申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
            要介護認定調査履歴番号 = new NinteichosaIraiRirekiNo(1);
            厚労省IF区分 = KoroshoIFKubun.V09B;
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目回答にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKaitoHairetsuCode(null, 申請書管理番号, 要介護認定調査履歴番号, 厚労省IF区分);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKaitoHairetsuCode(調査項目回答, null, 要介護認定調査履歴番号, 厚労省IF区分);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定調査履歴番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKaitoHairetsuCode(調査項目回答, 申請書管理番号, null, 厚労省IF区分);
        }

        @Test(expected = NullPointerException.class)
        public void 厚労省IF区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosahyoKaitoHairetsuCode(調査項目回答, 申請書管理番号, 要介護認定調査履歴番号, null);
        }

        @Test
        public void 引数のいずれにもnullが渡されていないとき_インスタンスが生成される() {
            sut = new NinteichosahyoKaitoHairetsuCode(調査項目回答, 申請書管理番号, 要介護認定調査履歴番号, 厚労省IF区分);
            assertThat(sut, is(instanceOf(NinteichosahyoKaitoHairetsuCode.class)));
        }
    }
}
