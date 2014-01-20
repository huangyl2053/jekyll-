/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice.helper;

import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.business.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dba.business.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dba.business.SaikofuJiyu;
import jp.co.ndensan.reams.db.dba.business.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urf.business._KaigoShikaku;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaMock {

    private HihokenshaMock() {
    }

    public static Hihokensha getSpiedInstance() {

        Hihokensha 被保険者 = new Hihokensha(
                create介護保険資格(), new ShichosonCode(new RString("市町村コード")), ShikakuIdoKubun.資格取得, new HihokenshaKubun(new RString("01"), new RString("資格取得")),
                new ShikakuHenkoJiyu(new RString(""), new RString("")), RDate.MAX, RDate.MAX,
                new JushochitokureiTekiyoJiyu(new RString(""), new RString("")), RDate.MAX, RDate.MAX,
                new JushochitokureiKaijoJiyu(new RString(""), new RString("")), RDate.MAX, RDate.MAX,
                true, true, new ShichosonCode(new RString("住所地特例措置元_市町村コード")), true, new SaikofuJiyu(new RString(""), new RString("")));

        return spy(被保険者);
    }

    private static IKaigoShikaku create介護保険資格() {
        return new _KaigoShikaku(
                ShikibetsuCodeMock.createInstance(new RString("識別コード")),
                HokenShubetsu.介護保険, RDate.MAX, RDate.MAX, RString.EMPTY, RDate.MAX, RDate.MAX, RString.EMPTY, RString.EMPTY, RString.EMPTY, RDate.MAX);
    }
}
