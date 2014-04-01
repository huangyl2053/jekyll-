/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IIdoRiyu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._AdministrativeBoundary;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._IdoJiyu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._IdoRiyu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.joda.time.LocalDateTime;
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
        private ShoKisaiHokenshaNo 証記載保険者番号;
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
            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("0001"));
            被保険者 = new KaigoHihokenshaNo(new RString("0001"));
            認定申請年月日 = new FlexibleDate("20140101");
            認定申請区分 = NinteiShinseiKubunShinsei.新規申請;
//            個人情報 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市AAAAAAAA");
//            認定調査委託先 = mock(NinteichosaItakusaki.class);
//            事業者情報 = mock(IKaigoJigyosha.class);
//            認定調査員情報 = mock(INinteiChosain.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの申請書管理番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの証記載保険者番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            証記載保険者番号 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの被保険者に_Nullを指定した場合_NullPointerExceptionが発生する() {
            被保険者 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請年月日に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請年月日 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請区分に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請区分 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの個人情報に_Nullを指定した場合_NullPointerExceptionが発生する() {
            個人情報 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの氏名に_Nullを指定した場合_NullPointerExceptionが発生する() {
            氏名 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの住所に_Nullを指定した場合_NullPointerExceptionが発生する() {
            住所 = null;
            sut = new NinteichosaIraiTaishosha(申請書管理番号, 証記載保険者番号, 被保険者,
                    認定申請年月日, 認定申請区分, 個人情報, 氏名, 住所, 認定調査委託先, 事業者情報, 認定調査員情報);
        }
    }
}
