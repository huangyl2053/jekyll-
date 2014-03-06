/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 認定調査依頼対象者のクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        NinteichosaIraiTaishosha sut;
        private ShinseishoKanriNo 申請書管理番号;
        private ShichosonCode 市町村コード;
        private KaigoHihokenshaNo 被保険者;
        private FlexibleDate 認定申請年月日;
        private NinteiShinseiKubunShinsei 認定申請区分;
        private IKojin 個人情報;
        private RString 氏名;
        private RString 住所;
        private NinteichosaItakusaki 認定調査委託先;
        private IKaigoJigyosha 事業者情報;
        private INinteiChosain 認定調査員情報;

        @Override
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("0001"));
            市町村コード = new ShichosonCode(new RString("0001"));
            被保険者 = new KaigoHihokenshaNo(new RString("0001"));
            認定申請年月日 = new FlexibleDate("20140101");
            認定申請区分 = NinteiShinseiKubunShinsei.新規申請;
            個人情報 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市AAAAAAAA");
            認定調査委託先 = mock(NinteichosaItakusaki.class);
            事業者情報 = mock(IKaigoJigyosha.class);
            認定調査員情報 = mock(INinteiChosain.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの申請書管理番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの市町村コードに_Nullを指定した場合_NullPointerExceptionが発生する() {
            市町村コード = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの被保険者に_Nullを指定した場合_NullPointerExceptionが発生する() {
            被保険者 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請年月日に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請年月日 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請区分に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請区分 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの個人情報に_Nullを指定した場合_NullPointerExceptionが発生する() {
            個人情報 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの氏名に_Nullを指定した場合_NullPointerExceptionが発生する() {
            氏名 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの住所に_Nullを指定した場合_NullPointerExceptionが発生する() {
            住所 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 市町村コード, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }
    }
}
