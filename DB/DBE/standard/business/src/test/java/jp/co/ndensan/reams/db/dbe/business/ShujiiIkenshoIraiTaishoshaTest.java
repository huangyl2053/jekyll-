/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 主治医意見書作成依頼対象者のクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiTaishoshaTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        private ShujiiIkenshoIraiTaishosha sut;
        private YokaigoninteiProgress 認定進捗情報;
        private ShinseishoKanriNo 申請書管理番号;
        private ShoKisaiHokenshaNo 証記載保険者番号;
        private KaigoHihokenshaNo 被保険者番号;
        private FlexibleDate 認定申請年月日;
        private NinteiShinseiKubunShinsei 認定申請区分;
        private IKojin 個人情報;
        private RString 氏名;
        private RString 住所;
        private KaigoIryoKikan 主治医医療機関;
        private KaigoDoctor 主治医;

        @Override
        public void setUp() {
            認定進捗情報 = mock(YokaigoninteiProgress.class);
            申請書管理番号 = new ShinseishoKanriNo(new RString("0001"));
            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
            被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
            認定申請年月日 = new FlexibleDate("20140101");
            認定申請区分 = NinteiShinseiKubunShinsei.新規申請;
            個人情報 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市AAAAAAAA");
            主治医医療機関 = mock(KaigoIryoKikan.class);
            主治医 = mock(KaigoDoctor.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定進捗情報に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定進捗情報 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの申請書管理番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの証記載保険者番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            証記載保険者番号 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの被保険者に_Nullを指定した場合_NullPointerExceptionが発生する() {
            被保険者番号 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請年月日に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請年月日 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請区分に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請区分 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの個人情報に_Nullを指定した場合_NullPointerExceptionが発生する() {
            個人情報 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの氏名に_Nullを指定した場合_NullPointerExceptionが発生する() {
            氏名 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの住所に_Nullを指定した場合_NullPointerExceptionが発生する() {
            住所 = null;
            sut = new ShujiiIkenshoIraiTaishosha(認定進捗情報, 申請書管理番号, 証記載保険者番号, 被保険者番号, 認定申請年月日, 認定申請区分,
                    個人情報, 氏名, 住所, 主治医医療機関, 主治医);
        }
    }
}
