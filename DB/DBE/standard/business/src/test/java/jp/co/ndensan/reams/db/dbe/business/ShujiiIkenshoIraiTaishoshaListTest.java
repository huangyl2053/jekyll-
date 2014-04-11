/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.IWorker;
import jp.co.ndensan.reams.ur.urz.business._DateOfBirth;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.ITsuzukigaraList;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Kojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class ShujiiIkenshoIraiTaishoshaListTest extends DbeTestBase {

    public static class get主治医意見書作成依頼処理対象者 extends DbeTestBase {

        public static void setUp() {
        }

        @Test
        public void 申請書管理番号に10を指定したとき_申請書管理番号に10を持つ主治医意見書作成依頼対象者が返る() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo((new RString("10")));
            ShujiiIkenshoIraiTaishoshaList sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.get主治医意見書作成依頼処理対象者(申請書管理番号).get申請書管理番号().value(), is(申請書管理番号.value()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 申請書管理番号に存在しない値を指定したとき_例外が発生する() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo((new RString("65536")));
            ShujiiIkenshoIraiTaishoshaList sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者(申請書管理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullを指定したとき_例外が発生する() {
            ShujiiIkenshoIraiTaishoshaList sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者((ShinseishoKanriNo.class).cast(null));
        }
    }

    public static class sub主治医意見書作成依頼処理対象者List extends DbeTestBase {

        @Test
        public void 証記載保険者番号に000001を指定したとき_証記載保険者番号に0001を持つ主治医意見書作成依頼対象者がすべて返る() {
            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo((new RString("000001")));
            ShujiiIkenshoIraiTaishoshaList sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.sub主治医意見書作成依頼処理対象者List(証記載保険者番号).size(), is(6));
        }

        @Test
        public void 証記載保険者番号に存在しない値を指定したとき_空のリストが返る() {
            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo((new RString("999999")));
            ShujiiIkenshoIraiTaishoshaList sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.sub主治医意見書作成依頼処理対象者List(証記載保険者番号).size(), is(0));
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号にnullを指定したとき_例外が発生する() {
            ShujiiIkenshoIraiTaishoshaList sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.sub主治医意見書作成依頼処理対象者List((ShoKisaiHokenshaNo.class).cast(null));
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

        ITsuzukigaraList 続柄 = null;
//        IShikibetsuTaisho 識別対象 = mock(IShikibetsuTaisho.class);
        IShikibetsuTaisho 識別対象 = new _ShikibetsuTaisho(new ShikibetsuCode("0000000001"), null, 0, true, null, FlexibleDate.MAX, FlexibleDate.EMPTY,
                new SetaiCode("00001"), null, null, JuminShubetsu.日本人, null, null, null, null, 0);
        ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("000001"));
        KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("0000000002"));
        FlexibleDate 認定申請年月日 = new FlexibleDate(new RString("20140101"));
        NinteiShinseiKubunShinsei 認定申請区分 = NinteiShinseiKubunShinsei.新規申請;
        RString 氏名 = new RString("あああ");
        RString 住所 = new RString("長野市");
//        IWorker 就労者 = mock(IWorker.class);
        IWorker 就労者 = null;
        IDateOfBirth 生年月日 = new _DateOfBirth(new RDate(19660401));
//        IKojin 個人情報 = new _Kojin(識別対象, 就労者, new RString("旧性"), 生年月日, Gender.FEMALE,
//                続柄, JuminJotai.住民, new FlexibleDate("00000000"), new FlexibleDate("00000000"),
//                new RString("異動事由コード"), JuminShubetsu.日本人, new RString("家族番号"), 1);
        IKojin 個人情報 = mock(IKojin.class);
//        KaigoIryoKikan 主治医医療機関 = mock(KaigoIryoKikan.class);
//        IDoctor 主治医 = mock(IDoctor.class);
        KaigoIryoKikan 主治医医療機関 = null;
        IDoctor 主治医 = null;

        return new ShujiiIkenshoIraiTaishosha(申請書管理番号,
                証記載保険者番号,
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
