/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Minashi2GoHihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * みなし2号台帳 のテストです。
 *
 * @author N8211 田辺 紘一
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaDaichoTest {

    private static Minashi2GoshaDaicho sut;

    public static class コントラクタのテスト extends DbeTestBase {

        private LasdecCode 市町村コード;
        private ShikibetsuCode 識別コード;
        private KaigoHihokenshaNo 被保険者番号;
        private int 履歴番号;
        private Minashi2GoHihokenshaKubun 被保険者区分コード;
        private FlexibleDate みなし2号登録年月日;
        private FlexibleDate みなし2号解除年月日;

        @Before
        public void setUp() {
            市町村コード = new LasdecCode("123456");
            識別コード = new ShikibetsuCode("123456789012345");
            被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
            履歴番号 = 1;
            被保険者区分コード = Minashi2GoHihokenshaKubun.みなし2号;
            みなし2号登録年月日 = new FlexibleDate("20140101");
            みなし2号解除年月日 = new FlexibleDate("20140101");
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードにNullが渡された時に_NullPointerExceptionが発生する() {
            sut = new Minashi2GoshaDaicho(null, 識別コード, 被保険者番号, 履歴番号, 被保険者区分コード, みなし2号登録年月日, みなし2号解除年月日);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードにNullが渡された時に_NullPointerExceptionが発生する() {
            sut = new Minashi2GoshaDaicho(市町村コード, null, 被保険者番号, 履歴番号, 被保険者区分コード, みなし2号登録年月日, みなし2号解除年月日);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号にNullが渡された時に_NullPointerExceptionが発生する() {
            sut = new Minashi2GoshaDaicho(市町村コード, 識別コード, null, 履歴番号, 被保険者区分コード, みなし2号登録年月日, みなし2号解除年月日);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者区分コードにNullが渡された時に_NullPointerExceptionが発生する() {
            sut = new Minashi2GoshaDaicho(市町村コード, 識別コード, 被保険者番号, 履歴番号, null, みなし2号登録年月日, みなし2号解除年月日);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void みなし2号登録年月日にNullが渡された時に_NullPointerExceptionが発生する() {
            sut = new Minashi2GoshaDaicho(市町村コード, 識別コード, 被保険者番号, 履歴番号, 被保険者区分コード, null, みなし2号解除年月日);
            fail();
        }
    }
}
