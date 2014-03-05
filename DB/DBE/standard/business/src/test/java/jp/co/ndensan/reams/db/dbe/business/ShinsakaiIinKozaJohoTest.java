/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;

/**
 * 審査会委員口座情報のテストです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinKozaJohoTest {

    public static class コンストラクタのテスト extends DbeTestBase {

        private static KinyuKikanCode 金融機関コード;
        private static KinyuKikanShitenCode 金融機関支店コード;
        private static RString 口座種別;
        private static RString 口座名義人;
        private static RString 口座名義人カナ;
        private static RString 口座番号;

        @Before
        public void setUp() {
            金融機関コード = new KinyuKikanCode(new RString("01"));
            金融機関支店コード = new KinyuKikanShitenCode(new RString("011"));
            口座種別 = new RString("普通");
            口座名義人 = new RString("次郎");
            口座名義人カナ = new RString("ジロウ");
            口座番号 = new RString("1237890");
        }

        @Test(expected = NullPointerException.class)
        public void 金融機関コードにnullが渡されたとき_NullPointerExceptionが返る() {
            new ShinsakaiIinKozaJoho(null, 金融機関支店コード, 口座種別, 口座名義人, 口座名義人カナ, 口座番号);
        }

        @Test(expected = NullPointerException.class)
        public void 金融機関支店コードにnullが渡されたとき_NullPointerExceptionが返る() {
            new ShinsakaiIinKozaJoho(金融機関コード, null, 口座種別, 口座名義人, 口座名義人カナ, 口座番号);
        }

        @Test(expected = NullPointerException.class)
        public void 口座種別にnullが渡されたとき_NullPointerExceptionが返る() {
            new ShinsakaiIinKozaJoho(金融機関コード, 金融機関支店コード, null, 口座名義人, 口座名義人カナ, 口座番号);
        }

        @Test(expected = NullPointerException.class)
        public void 口座名義人にnullが渡されたとき_NullPointerExceptionが返る() {
            new ShinsakaiIinKozaJoho(金融機関コード, 金融機関支店コード, 口座種別, null, 口座名義人カナ, 口座番号);
        }

        @Test(expected = NullPointerException.class)
        public void 口座名義人カナにnullが渡されたとき_NullPointerExceptionが返る() {
            new ShinsakaiIinKozaJoho(金融機関コード, 金融機関支店コード, 口座種別, 口座名義人, null, 口座番号);
        }

        @Test(expected = NullPointerException.class)
        public void 口座番号にnullが渡されたとき_NullPointerExceptionが返る() {
            new ShinsakaiIinKozaJoho(金融機関コード, 金融機関支店コード, 口座種別, 口座名義人, 口座名義人カナ, null);
        }
    }
}
