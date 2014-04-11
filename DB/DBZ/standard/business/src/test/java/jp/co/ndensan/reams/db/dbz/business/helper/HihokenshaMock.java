/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.helper;

import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.ShikakuShutoku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * HihokenshaのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaMock {

    public static Hihokensha getSpiedInstance() {
        LasdecCode lasdecCode = new LasdecCode("123456");
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode("1234567890");
        RDateTime registerDateTime = RDateTime.now();
        KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(new RString("12134567890"));
        Hihokensha hihokensha = createHihokensha(lasdecCode, shikibetsuCode, registerDateTime, hihokenshaNo);
        return spy(hihokensha);
    }

    public static Hihokensha createHihokensha(LasdecCode lasdecCode, ShikibetsuCode shikibetsuCode, RDateTime registerDateTime, KaigoHihokenshaNo hihokenshaNo) {
        IHihokenshaShikaku shikaku = new HihokenshaShikaku.Builder(lasdecCode, shikibetsuCode, registerDateTime,
                ShikakuHihokenshaKubun.第１号被保険者, FlexibleDate.MAX, ShikakuShutoku.NOTHING)
                .hihokenshaNo(hihokenshaNo).build();

        IKojin profile = mock(IKojin.class);
        return new Hihokensha(profile, shikaku);
    }
}
