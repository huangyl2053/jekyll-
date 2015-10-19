/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link _KobetsuJikoKaigo}のテストクラスです。
 *
 * @author N2218 村松 優
 */
@RunWith(Enclosed.class)
public class _KobetsuJikoKaigoTest extends DbxTestBase {

    /**
     * コンストラクタのテストです。
     */
    public static class ConstructorTest extends DbxTestBase {

        IKobetsuJikoKaigo sut;
        private IKobetsuJikoKaigoShikaku 介護資格;
        private IKobetsuJikoKaigoJukyu 介護受給;

        public void setUp() {
            介護資格 = new _KaigoShikaku(
                    new ShikibetsuCode(new RString("1234")),
                    HokenShubetsu.介護保険,
                    new RDate("20131213"),
                    new RDate("20131213"),
                    new ShikakuShutokuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY),
                    new RDate("20131215"),
                    new RDate("20131215"),
                    new ShikakuSoshitsuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY),
                    new RString("123456789"),
                    new RString("87654321"),
                    new RDate("20131213"),
                    ShikakuHihokenshaKubun.第１号被保険者,
                    JushochiTokureishaKubun.住所地特例者);
            介護受給 = new _YoKaigoNinteiKekka(
                    new RDate("20131213"),
                    YoKaigoJotaiKubun.要介護1,
                    new Range<>(new RDate("20131213"), new RDate("20151213")),
                    new RString(""),
                    new RDate("20141213"),
                    new RString(""),
                    new RDate("20131213"));
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの介護資格に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new _KobetsuJikoKaigo(null, 介護受給);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの介護受給に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new _KobetsuJikoKaigo(介護資格, null);
        }
    }

    public static class GetterTest extends DbxTestBase {

        IKobetsuJikoKaigo sut;
        private IKobetsuJikoKaigoShikaku 介護資格;
        private IKobetsuJikoKaigoJukyu 介護受給;

        @Before
        public void setUp() {
            介護資格 = new _KaigoShikaku(
                    new ShikibetsuCode(new RString("000000000001234")),
                    HokenShubetsu.介護保険,
                    new RDate("20131213"),
                    new RDate("20131213"),
                    new ShikakuShutokuJiyu(new Code("001"), new RString("決定"), new RString("決")),
                    new RDate("20131215"),
                    new RDate("20131215"),
                    new ShikakuSoshitsuJiyu(new Code("001"), new RString("決定"), new RString("決")),
                    new RString("123456789"),
                    new RString("87654321"),
                    new RDate("20131213"),
                    ShikakuHihokenshaKubun.第１号被保険者,
                    JushochiTokureishaKubun.住所地特例者);
            介護受給 = new _YoKaigoNinteiKekka(
                    new RDate("20131213"),
                    YoKaigoJotaiKubun.要介護1,
                    new Range<>(new RDate("20131213"), new RDate("20151213")),
                    new RString("認定有効期間"),
                    new RDate("20141213"),
                    new RString("特定疾病"),
                    new RDate("20131213"));
            sut = new _KobetsuJikoKaigo(介護資格, 介護受給);
        }

        @Test
        public void LDNS_戻り値の介護資格を指定した場合_get介護資格は_介護資格の資格取得年月日を返す() {
            assertThat(sut.get介護資格().get資格取得年月日(), is(new RDate("20131213")));
        }

        @Test
        public void LDNS_戻り値の介護受給を指定した場合_get介護受給は_介護受給の要介護状態区分を返す() {
            assertThat(sut.get介護受給().get要介護状態区分(), is(YoKaigoJotaiKubun.要介護1));
        }
    }
}
