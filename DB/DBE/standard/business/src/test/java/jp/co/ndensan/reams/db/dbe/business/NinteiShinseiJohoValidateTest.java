/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiShinseiKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author N2006 立野 啓子
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoValidateTest extends DbeTestBase {    
    private static NinteiShinseiJohoValidate sut;

    public static void setUp() {
        sut = new NinteiShinseiJohoValidate();
    }
    
    public static class ShinseiKbn {
        @Before
        public void setUp() {
            NinteiShinseiJohoValidateTest.setUp();
        }

        @Test
        public void 申請区分が新規申請のとき_validateShinseiKbnは_Falseを返す() {
            assertThat(sut.validateShinseiKbn(YokaigoNinteiShinseiKubun.新規申請.getCode() ,new RDate("20140720"),RString.EMPTY),is(false));
        }
        
        @Test
        public void 申請区分が更新申請で_前回認定期間終了日がEmptyのとき_validateShinseiKbnは_Trueを返す() {
            assertThat(sut.validateShinseiKbn(YokaigoNinteiShinseiKubun.更新申請.getCode() ,new RDate("20140720"),RString.EMPTY),is(true));
        }
        @Test
        public void 申請区分が更新申請で_申請日が前回認定期間終了日の59日前のとき_validateShinseiKbnは_Falseを返す() {
            assertThat(sut.validateShinseiKbn(YokaigoNinteiShinseiKubun.更新申請.getCode() ,new RDate("20140522") ,new RString("20140720")),is(false));
        }
        @Test
        public void 申請区分が更新申請で_申請日が前回認定期間終了日の60日前のとき_validateShinseiKbnは_Falseを返す() {
            assertThat(sut.validateShinseiKbn(YokaigoNinteiShinseiKubun.更新申請.getCode() ,new RDate("20140521") ,new RString("20140720")),is(false));
        }
        @Test
        public void 申請区分が更新申請で_申請日が前回認定期間終了日の61日前のとき_validateShinseiKbnは_Trueを返す() {
            assertThat(sut.validateShinseiKbn(YokaigoNinteiShinseiKubun.更新申請.getCode() ,new RDate("20140520") ,new RString("20140720")),is(true));
        }
        
        @Test
        public void 申請区分が区分変更申請のとき_validateShinseiKbnは_Falseを返す() {
            assertThat(sut.validateShinseiKbn(YokaigoNinteiShinseiKubun.区分変更申請.getCode() ,new RDate("20140720"),RString.EMPTY),is(false));
        }

    }
    
    public static class Jigyosha {
        @Before
        public void setUp() {
            NinteiShinseiJohoValidateTest.setUp();
        }
        @Test
        public void 事業者コードと事業者名がEmptyのとき_validateJigyoshaは_Falseを返す() {
            assertThat(sut.validateJigyosha(RString.EMPTY,RString.EMPTY),is(false));
        }
        @Test
        public void 事業者コードがEmptyでなく_事業者名がEmptyのとき_validateJigyoshaは_Trueを返す() {
            assertThat(sut.validateJigyosha(new RString("事業者コード"),RString.EMPTY),is(true));
        }
    }
    
    public static class Iryokikan {
        @Before
        public void setUp() {
            NinteiShinseiJohoValidateTest.setUp();
        }

        @Test
        public void 医療機関コードと医療機関名がEmptyのとき_validateJigyoshaは_Falseを返す() {
            assertThat(sut.validateIryokikan(RString.EMPTY,RString.EMPTY),is(false));
        }
        @Test
        public void 医療機関コードがEmptyでなく_医療機関名がEmptyのとき_validateJigyoshaは_Trueを返す() {
            assertThat(sut.validateIryokikan(new RString("医療機関コード"),RString.EMPTY),is(true));
        }
    }
    
    public static class Shujii {
        @Before
        public void setUp() {
            NinteiShinseiJohoValidateTest.setUp();
        }

        @Test
        public void 主治医コードと主治医名がEmptyのとき_validateShujiiは_Falseを返す() {
            assertThat(sut.validateShujii(RString.EMPTY,RString.EMPTY),is(false));
        }
        @Test
        public void 主治医コードがEmptyでなく_主治医名がEmptyのとき_validateShujiiは_Trueを返す() {
            assertThat(sut.validateShujii(new RString("医療機関コード"),RString.EMPTY),is(true));
        }
    }
    
    
}
