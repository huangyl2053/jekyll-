/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.ur.urz.business.core.Association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 介護資格の情報を保持するクラスのテストクラスです。
 *
 * @author n8168 岩山 慎吾
 *
 */
public class _KaigoShikakuTest extends DbxTestBase {

    private _KaigoShikaku kaigoShikakuTest;

    @Test
    public void 基準日が資格喪失年月日以前で資格取得年月日以降でない場合is資格はFALSEが返却される() {
        kaigoShikakuTest = create介護資格();
        assertThat(kaigoShikakuTest.is資格あり(new RDate("20131212")), is(false));
        assertThat(kaigoShikakuTest.is資格あり(new RDate("20131216")), is(false));
    }

    @Test
    public void 基準日が資格喪失年月日以前で資格取得年月日以降の場合is資格はTRUEが返却される() {
        kaigoShikakuTest = create介護資格();
        assertThat(kaigoShikakuTest.is資格あり(new RDate("20131213")), is(true));
        assertThat(kaigoShikakuTest.is資格あり(new RDate("20131214")), is(true));
        assertThat(kaigoShikakuTest.is資格あり(new RDate("20131215")), is(true));
    }

    @Test
    public void thisがI健康保険資格_引数が_KaigoShikakuの場合isWapperForはTRUEが返却される() {
        kaigoShikakuTest = create介護資格();
        assertThat(kaigoShikakuTest.isWapperFor(_KaigoShikaku.class), is(true));
    }

    @Test
    public void thisがI健康保険資格_引数が_KaigoShikaku以外の場合isWapperForはFALSEが返却される() {
        kaigoShikakuTest = create介護資格();
        assertThat(kaigoShikakuTest.isWapperFor(Association.class), is(false));
    }

    @Test
    public void thisがI健康保険資格_引数が_KaigoShikaku被保険者番号が1234の場合unwrap_get被保険者番号は123456789が返却される() {
        kaigoShikakuTest = create介護資格();
        assertThat(kaigoShikakuTest.unwrap(_KaigoShikaku.class).get被保険者番号(), is(new RString("123456789")));
    }

    @Test
    public void LDNS_住所地特例者区分が住所地特例者の場合_住所地特例者区分は_住所地特例者を返す() {
        kaigoShikakuTest = create介護資格();
        assertThat(kaigoShikakuTest.get住所地特例者区分(), is(JushochiTokureishaKubun.住所地特例者));
    }

    @Test
    public void LDNS_資格取得事由がnullの場合_資格取得事由は_KaigoShikakuを返す() {
        kaigoShikakuTest = new _KaigoShikaku(ShikibetsuCode.EMPTY, HokenShubetsu.介護保険, RDate.MAX, RDate.MAX, null, RDate.MAX, RDate.MAX, null, RString.EMPTY, RString.EMPTY, RDate.MAX, ShikakuHihokenshaKubun.第１号被保険者, JushochiTokureishaKubun.住所地特例者);
        assertThat(kaigoShikakuTest.get資格取得事由(), is(new ShikakuShutokuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY)));
    }

    @Test
    public void LDNS_資格喪失事由がnullの場合_資格喪失事由は_KaigoShikakuを返す() {
        kaigoShikakuTest = new _KaigoShikaku(ShikibetsuCode.EMPTY, HokenShubetsu.介護保険, RDate.MAX, RDate.MAX, null, RDate.MAX, RDate.MAX, null, RString.EMPTY, RString.EMPTY, RDate.MAX, ShikakuHihokenshaKubun.第１号被保険者, JushochiTokureishaKubun.住所地特例者);
        assertThat(kaigoShikakuTest.get資格喪失事由(), is(new ShikakuSoshitsuJiyu(Code.EMPTY, RString.EMPTY, RString.EMPTY)));
    }

    private _KaigoShikaku create介護資格() {
        return new _KaigoShikaku(
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
    }
}
