/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.MobileDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosainBangoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
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

/**
 * 認定調査依頼情報のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTest extends TestBase {

    public static class コンストラクタのテスト {

        private ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("0001"));
        private NinteichosaIraiRirekiNo 認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
        private KaigoJigyoshaNo 認定調査委託先コード = new KaigoJigyoshaNo(new RString("2001"));
        private NinteichosainBangoCode 調査員番号コード = new NinteichosainBangoCode(new RString("3001"));
        private NinteichosaIraiKubun 認定調査依頼区分 = NinteichosaIraiKubun.初回;
        private int 認定調査回数 = 1;
        private RDate 認定調査依頼年月日 = new RDate("19991212");
        private RDate 認定調査期限年月日 = new RDate("20001212");
        private RDate 認定調査出力年月日 = new RDate("20011212");
        private RDate 調査票等出力年月日 = new RDate("20021212");
        private MobileDataShutsuryoku モバイルデータ出力 = MobileDataShutsuryoku.出力済;
        private RDate 認定調査督促年月日 = new RDate("20031212");
        private NinteichosaTokusokuHoho 認定調査督促方法 = NinteichosaTokusokuHoho.電話;
        private int 認定調査督促回数 = 2;
        private RString 認定調査督促メモ = new RString("督促");
        private NinteichosaIrai sut;

        @Test
        public void 必要項目が引数に渡されたとき_インスタンスが生成される() {
            sut = new NinteichosaIrai(申請書管理番号, 認定調査依頼履歴番号, 認定調査委託先コード, 調査員番号コード, 認定調査依頼区分,
                    0, null, null, null, null, null, null, null, 0, null);
            assertThat(sut, is(instanceOf(NinteichosaIrai.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIrai(null, 認定調査依頼履歴番号, 認定調査委託先コード, 調査員番号コード, 認定調査依頼区分,
                    認定調査回数, 認定調査依頼年月日, 認定調査期限年月日, 認定調査出力年月日, 調査票等出力年月日,
                    モバイルデータ出力, 認定調査督促年月日, 認定調査督促方法, 認定調査督促回数, 認定調査督促メモ);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼履歴番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIrai(申請書管理番号, null, 認定調査委託先コード, 調査員番号コード, 認定調査依頼区分,
                    認定調査回数, 認定調査依頼年月日, 認定調査期限年月日, 認定調査出力年月日, 調査票等出力年月日,
                    モバイルデータ出力, 認定調査督促年月日, 認定調査督促方法, 認定調査督促回数, 認定調査督促メモ);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIrai(申請書管理番号, 認定調査依頼履歴番号, null, 調査員番号コード, 認定調査依頼区分,
                    認定調査回数, 認定調査依頼年月日, 認定調査期限年月日, 認定調査出力年月日, 調査票等出力年月日,
                    モバイルデータ出力, 認定調査督促年月日, 認定調査督促方法, 認定調査督促回数, 認定調査督促メモ);
        }

        @Test(expected = NullPointerException.class)
        public void 調査員番号コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIrai(申請書管理番号, 認定調査依頼履歴番号, 認定調査委託先コード, null, 認定調査依頼区分,
                    認定調査回数, 認定調査依頼年月日, 認定調査期限年月日, 認定調査出力年月日, 調査票等出力年月日,
                    モバイルデータ出力, 認定調査督促年月日, 認定調査督促方法, 認定調査督促回数, 認定調査督促メモ);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new NinteichosaIrai(申請書管理番号, 認定調査依頼履歴番号, 認定調査委託先コード, 調査員番号コード, null,
                    認定調査回数, 認定調査依頼年月日, 認定調査期限年月日, 認定調査出力年月日, 調査票等出力年月日,
                    モバイルデータ出力, 認定調査督促年月日, 認定調査督促方法, 認定調査督促回数, 認定調査督促メモ);
        }
    }
}
