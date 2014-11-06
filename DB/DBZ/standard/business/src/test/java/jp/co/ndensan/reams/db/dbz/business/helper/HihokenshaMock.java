/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.helper;

import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.ShikakuShutoku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
        YMDHMS shoriTimeStamp = new YMDHMS("20110912012345");
        HihokenshaNo hihokenshaNo = new HihokenshaNo(new RString("12134567890"));
        Hihokensha hihokensha = createHihokensha(lasdecCode, shikibetsuCode, shoriTimeStamp, hihokenshaNo);
        return spy(hihokensha);
    }

    public static Hihokensha createHihokensha(LasdecCode lasdecCode, ShikibetsuCode shikibetsuCode, YMDHMS shoriTimeStamp,
            HihokenshaNo hihokenshaNo) {
        IHihokenshaShikaku shikaku = new HihokenshaShikaku.Builder(lasdecCode, shikibetsuCode, shoriTimeStamp,
                new HihokenshaKubun(new Code("1"), new RString("第1号")), FlexibleDate.MAX, ShikakuShutoku.NOTHING)
                .hihokenshaNo(hihokenshaNo).build();

        IKojin profile = mock(IKojin.class);
        return new Hihokensha(profile, shikaku);
    }
}
