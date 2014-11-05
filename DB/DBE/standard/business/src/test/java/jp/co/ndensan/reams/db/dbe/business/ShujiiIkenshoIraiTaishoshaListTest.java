/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

    private static ShujiiIkenshoIraiTaishoshaList sut;
    private static final YokaigoNinteiProgress 認定進捗情報 = mock(YokaigoNinteiProgress.class);
    private static final ShinseishoKanriNo 申請書管理番号登録あり1 = new ShinseishoKanriNo((new RString("11")));
    private static final ShinseishoKanriNo 申請書管理番号登録あり2 = new ShinseishoKanriNo((new RString("12")));
    private static final ShinseishoKanriNo 申請書管理番号登録あり3 = new ShinseishoKanriNo((new RString("13")));
    private static final ShinseishoKanriNo 申請書管理番号登録なし = new ShinseishoKanriNo((new RString("99999")));
    private static final ShoKisaiHokenshaNo 証記載保険者番号登録あり = new ShoKisaiHokenshaNo((new RString("123456")));
    private static final ShoKisaiHokenshaNo 証記載保険者番号登録なし = new ShoKisaiHokenshaNo(new RString("999999"));
    private static final KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
    private static final FlexibleDate 認定申請年月日 = new FlexibleDate(new RString("20140101"));
    private static final Code 認定申請区分 = new Code(String.valueOf(NinteiShinseiKubunShinsei.新規申請.コード()));
    private static final IKojin 個人情報 = mock(IKojin.class);
    private static final RString 氏名 = new RString("あああ");
    private static final RString 住所 = new RString("長野市");
    private static final KaigoIryoKikan 主治医医療機関 = mock(KaigoIryoKikan.class);
    private static final KaigoDoctor 主治医 = mock(KaigoDoctor.class);

    public static class get主治医意見書作成依頼処理対象者 extends DbeTestBase {

        public static void setUp() {
        }

        @Test(expected = NullPointerException.class)
        public void get主治医意見書作成依頼処理対象者_申請書管理番号にnullを指定したとき_例外が発生する() {
            sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者(null);
        }

        @Test
        public void get主治医意見書作成依頼処理対象者_引数に存在する申請書管理番号を指定したとき_主治医意見書作成依頼対象者が返る() {
            sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.get主治医意見書作成依頼処理対象者(申請書管理番号登録あり1).get申請書管理番号().value(), is(申請書管理番号登録あり1.value()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void get主治医意見書作成依頼処理対象者_引数に存在しない申請書管理番号を指定したとき_例外が発生する() {
            sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.get主治医意見書作成依頼処理対象者(申請書管理番号登録なし);
        }
    }

    public static class sub主治医意見書作成依頼処理対象者List extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void sub主治医意見書作成依頼処理対象者List_引数にnullを指定したとき_例外が発生する() {
            sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            sut.sub主治医意見書作成依頼処理対象者List(null);
        }

        @Test
        public void sub主治医意見書作成依頼処理対象者List_引数に存在する証記載保険者番号を指定したとき_主治医意見書作成依頼対象者が返る() {
            sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.sub主治医意見書作成依頼処理対象者List(証記載保険者番号登録あり).size(), is(3));
        }

        @Test
        public void sub主治医意見書作成依頼処理対象者List_引数に存在しない証記載保険者番号を指定したとき_空のリストが返る() {
            sut = new ShujiiIkenshoIraiTaishoshaList(create主治医意見書作成依頼対象者List());
            assertThat(sut.sub主治医意見書作成依頼処理対象者List(証記載保険者番号登録なし).size(), is(0));
        }
    }

    private static List<ShujiiIkenshoIraiTaishosha> create主治医意見書作成依頼対象者List() {
        List<ShujiiIkenshoIraiTaishosha> taishoshaList = new ArrayList<>();
        taishoshaList.add(create主治医意見書作成依頼対象者(申請書管理番号登録あり1));
        taishoshaList.add(create主治医意見書作成依頼対象者(申請書管理番号登録あり2));
        taishoshaList.add(create主治医意見書作成依頼対象者(申請書管理番号登録あり3));
        return taishoshaList;
    }

    private static ShujiiIkenshoIraiTaishosha create主治医意見書作成依頼対象者(ShinseishoKanriNo 申請書管理番号) {

        return new ShujiiIkenshoIraiTaishosha(
                認定進捗情報,
                申請書管理番号,
                証記載保険者番号登録あり,
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
