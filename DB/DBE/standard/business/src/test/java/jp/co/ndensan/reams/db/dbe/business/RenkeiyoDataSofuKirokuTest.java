/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * RenkeiyouDataSoufuKirokuのテストクラスです。
 *
 * @author n8107 千秋雄
 */
@RunWith(Enclosed.class)
public class RenkeiyoDataSofuKirokuTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        RenkeiyoDataSofuKiroku sut;
        private ShinseishoKanriNo 申請書管理番号;
        private YMDHMS 処理日時;
        private HihokenshaNo 被保険者番号;
        private NinteiShinseijiKubun 認定申請時区分;
        private HikiwatashiKubun 引渡し区分;
        private RDateTime 引渡し日時;
        private SaiSoufuKubun 再送付区分;
        private SaiChousaSoufuKubun 再調査送付区分;
        private SaiIkenshoSoufuKubun 再意見書送付区分;

        @Override
        public void setUp() {

            申請書管理番号 = new ShinseishoKanriNo(new RString("1000000000"));
            処理日時 = new YMDHMS(new RString("20140808102030"));
            被保険者番号 = new HihokenshaNo(new RString("H999999999"));
            認定申請時区分 = NinteiShinseijiKubun.toValue(new RString("01"));
            引渡し区分 = HikiwatashiKubun.toValue(new RString("1"));
            引渡し日時 = RDateTime.of(2014, 03, 15, 22, 23, 44);
            再送付区分 = SaiSoufuKubun.toValue(new RString("01"));
            再調査送付区分 = SaiChousaSoufuKubun.toValue(new RString("2"));
            再意見書送付区分 = SaiIkenshoSoufuKubun.toValue(new RString("2"));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの申請書管理番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(null, 処理日時, 被保険者番号, 認定申請時区分, 引渡し区分, 引渡し日時,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの処理日時に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, null, 被保険者番号, 認定申請時区分, 引渡し区分, 引渡し日時,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの被保険者番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, null, 認定申請時区分, 引渡し区分, 引渡し日時,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請時区分に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, 被保険者番号, null, 引渡し区分, 引渡し日時,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引渡し区分に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, 被保険者番号, 認定申請時区分, null, 引渡し日時,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの引渡し日時に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, 被保険者番号, 認定申請時区分, 引渡し区分, null,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの再送付区分に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, 被保険者番号, 認定申請時区分, 引渡し区分, 引渡し日時,
                    null, 再調査送付区分, 再意見書送付区分);
        }

        @Test
        public void コンストラクタの_正常情報を受け取った場合_正常になる() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 処理日時, 被保険者番号, 認定申請時区分, 引渡し区分, 引渡し日時,
                    再送付区分, 再調査送付区分, 再意見書送付区分);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));

        }
    }
}
