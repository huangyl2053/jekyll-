/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

/**
 * 主治医意見書作成依頼対象者のリストを扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiTaishoshaListTest extends TestBase {

    public static class get主治医意見書作成依頼処理対象者_申請書管理番号 extends TestBase {

        @Test
        public void 申請書管理番号に10を指定したとき_申請書管理番号に10を持つ主治医意見書作成依頼対象者が返る() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo((new RString("10")));
            ShujiiIkenshoIraiTaishoshaList sut =
                    new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.get主治医意見書作成依頼処理対象者(申請書管理番号).get申請書管理番号().value(), is(申請書管理番号.value()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 申請書管理番号に存在しない値を指定したとき_例外が発生する() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo((new RString("65536")));
            ShujiiIkenshoIraiTaishoshaList sut =
                    new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者(申請書管理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullを指定したとき_例外が発生する() {
            ShujiiIkenshoIraiTaishoshaList sut =
                    new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者((ShinseishoKanriNo.class).cast(null));
        }
    }

    public static class get主治医意見書作成依頼処理対象者_市町村コード extends TestBase {

        @Test
        public void 市町村コードに0001を指定したとき_市町村コードに0001を持つ主治医意見書作成依頼対象者がすべて返る() {
            ShichosonCode 市町村コード = new ShichosonCode((new RString("0001")));
            ShujiiIkenshoIraiTaishoshaList sut =
                    new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.get主治医意見書作成依頼処理対象者(市町村コード).size(), is(6));
        }

        @Test
        public void 市町村コードに存在しない値を指定したとき_空のリストが返る() {
            ShichosonCode 市町村コード = new ShichosonCode((new RString("9999")));
            ShujiiIkenshoIraiTaishoshaList sut =
                    new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.get主治医意見書作成依頼処理対象者(市町村コード).size(), is(0));
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードにnullを指定したとき_例外が発生する() {
            ShujiiIkenshoIraiTaishoshaList sut =
                    new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者((ShichosonCode.class).cast(null));
        }
    }

    private static List<ShujiiIkenshoIraiTaishosha> create主治医意見書作成依頼対象者List() {
        List<ShujiiIkenshoIraiTaishosha> taishoshaList = new ArrayList<>();
        taishoshaList.add(create主治医意見書作成依頼対象者(new ShinseishoKanriNo(new RString("1"))));
        taishoshaList.add(create主治医意見書作成依頼対象者(new ShinseishoKanriNo(new RString("4"))));
        taishoshaList.add(create主治医意見書作成依頼対象者(new ShinseishoKanriNo(new RString("10"))));
        taishoshaList.add(create主治医意見書作成依頼対象者(new ShinseishoKanriNo(new RString("19"))));
        taishoshaList.add(create主治医意見書作成依頼対象者(new ShinseishoKanriNo(new RString("33"))));
        taishoshaList.add(create主治医意見書作成依頼対象者(new ShinseishoKanriNo(new RString("48"))));
        return taishoshaList;
    }

    private static ShujiiIkenshoIraiTaishosha create主治医意見書作成依頼対象者(ShinseishoKanriNo 申請書管理番号) {

        ShichosonCode 市町村コード = new ShichosonCode(new RString("0001"));
        KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("0002"));
        NinteiShinseiDate 認定申請年月日 = new NinteiShinseiDate(new FlexibleDate(new RString("20140101")));
        NinteiShinseiKubunShinsei 認定申請区分 = NinteiShinseiKubunShinsei.新規申請;
        IKojin 個人情報 = mock(IKojin.class);
        RString 氏名 = new RString("あああ");
        RString 住所 = new RString("長野市");
        KaigoIryoKikan 主治医医療機関 = mock(KaigoIryoKikan.class);
        IDoctor 主治医 = mock(IDoctor.class);

        return new ShujiiIkenshoIraiTaishosha(申請書管理番号,
                市町村コード,
                被保険者番号,
                認定申請年月日,
                認定申請区分,
                個人情報,
                氏名,
                住所,
                主治医医療機関,
                主治医);
    }
}
