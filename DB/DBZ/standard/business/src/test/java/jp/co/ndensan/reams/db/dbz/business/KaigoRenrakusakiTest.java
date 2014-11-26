/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RenrakusakiKubunNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 介護連絡先情報を表すクラスのテストクラスです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class KaigoRenrakusakiTest extends DbzTestBase {

    private static KaigoRenrakusaki sut;
    private static AtenaMeisho 氏名;
    private static AtenaKanaMeisho 氏名カナ;
    private static TelNo 電話番号;
    private static TelNo 携帯番号;
    private static YubinNo 郵便番号;
    private static AtenaJusho 住所;
    private static RString 続柄;
    private static RenrakusakiKubunNo 連絡先区分番号;
    private static ShoKisaiHokenshaNo 保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static RString 支所コード;

    @BeforeClass
    public static void setUp() {
        氏名 = mock(AtenaMeisho.class);
        氏名カナ = mock(AtenaKanaMeisho.class);
        電話番号 = mock(TelNo.class);
        携帯番号 = mock(TelNo.class);
        郵便番号 = mock(YubinNo.class);
        住所 = mock(AtenaJusho.class);
        続柄 = new RString("父");
        連絡先区分番号 = new RenrakusakiKubunNo("1");
        保険者番号 = new ShoKisaiHokenshaNo("123456");
        被保険者番号 = new HihokenshaNo("1234567890");
        支所コード = new RString("01");
    }

    public static class Constructor extends DbzTestBase {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new KaigoRenrakusaki(氏名, 氏名カナ, 電話番号, 携帯番号,
                    郵便番号, 住所, 続柄, 連絡先区分番号, 保険者番号, 被保険者番号, 支所コード);
            assertThat(sut, is(instanceOf(KaigoRenrakusaki.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 氏名がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoRenrakusaki(null, 氏名カナ, 電話番号, 携帯番号,
                    郵便番号, 住所, 続柄, 連絡先区分番号, 保険者番号, 被保険者番号, 支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 氏名カナがnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoRenrakusaki(氏名, null, 電話番号, 携帯番号,
                    郵便番号, 住所, 続柄, 連絡先区分番号, 保険者番号, 被保険者番号, 支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 続柄がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoRenrakusaki(氏名, 氏名カナ, 電話番号, 携帯番号,
                    郵便番号, 住所, null, 連絡先区分番号, 保険者番号, 被保険者番号, 支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 連絡先区分番号がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoRenrakusaki(氏名, 氏名カナ, 電話番号, 携帯番号,
                    郵便番号, 住所, 続柄, null, 保険者番号, 被保険者番号, 支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 保険者番号がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoRenrakusaki(氏名, 氏名カナ, 電話番号, 携帯番号,
                    郵便番号, 住所, 続柄, 連絡先区分番号, null, 被保険者番号, 支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの時_NullPointerExceptionが発生する() {
            sut = new KaigoRenrakusaki(氏名, 氏名カナ, 電話番号, 携帯番号,
                    郵便番号, 住所, 続柄, 連絡先区分番号, 保険者番号, null, 支所コード);
        }
    }
}
