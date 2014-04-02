/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.helper;

import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.HihokenshashoSaikofu;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.JushochitokureiKaijo;
import jp.co.ndensan.reams.db.dbz.business.JushochitokureiTekiyo;
import jp.co.ndensan.reams.db.dbz.business.ShikakuHenko;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * HihokenshaShikakuのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaShikakuMock {

    private static LasdecCode lasdecCode;
    private static ShikibetsuCode shikibetsuCode;
    private static KaigoHihokenshaNo hihokenshaNo;
    private static RDate ichigoGaitoDate;
    private static IShikakuShutokuJiyu shutokuReason;
    private static IShikakuSoshitsuJiyu soshitsuReason;
    private static IKaigoShikaku kaigoShikaku;

    static {
        lasdecCode = new LasdecCode("123456");
        shikibetsuCode = new ShikibetsuCode("1020304050");
        hihokenshaNo = new KaigoHihokenshaNo(new RString("1234567890"));
        ichigoGaitoDate = new RDate("20140328");
        shutokuReason = createShikakuShutokuJiyu();
        soshitsuReason = createShikakuSoshitsuJiyu();
        kaigoShikaku = createKaigoShikaku();
    }

    public static IHihokenshaShikaku getSpiedInstance() {
        IHihokenshaShikaku shikaku = new HihokenshaShikaku(
                kaigoShikaku,
                new LasdecCode("123456"),
                new ShikibetsuCode("1020304050"),
                RDateTime.of(2014, 4, 2, 15, 47),
                hihokenshaNo,
                ShikakuIdoKubun.資格取得, ShikakuHihokenshaKubun.第１号被保険者,
                new ShikakuHenko(ShikakuHenkoJiyu.なし, FlexibleDate.MAX, FlexibleDate.MAX),
                new JushochitokureiTekiyo(JushochitokureiTekiyoJiyu.なし, FlexibleDate.MAX, FlexibleDate.MAX),
                new JushochitokureiKaijo(JushochitokureiKaijoJiyu.なし, FlexibleDate.MAX, FlexibleDate.MAX),
                JushochiTokureishaKubun.通常資格者, KoikinaiJushochitokureishaKubun.通常資格者, null, null,
                new HihokenshashoSaikofu(HihokenshashoSaikofuKubun.なし, HihokenshashoSaikofuJiyu.なし, null));
        return spy(shikaku);
    }

    private static IKaigoShikaku createKaigoShikaku() {
        return KaigoShikakuFactory.createInstance(shikibetsuCode, HokenShubetsu.介護保険,
                ichigoGaitoDate, ichigoGaitoDate, shutokuReason,
                RDate.MAX, RDate.MAX, soshitsuReason,
                hihokenshaNo.value(), lasdecCode.value(),
                ichigoGaitoDate, ShikakuHihokenshaKubun.第１号被保険者,
                JushochiTokureishaKubun.通常資格者);

    }

    private static IShikakuShutokuJiyu createShikakuShutokuJiyu() {
        final ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.年齢到達;
        return new IShikakuShutokuJiyu() {
            @Override
            public RString getCode() {
                return reason.getCode();
            }

            @Override
            public RString getName() {
                return reason.getName();
            }

            @Override
            public RString getShortName() {
                return reason.getShortName();
            }
        };
    }

    private static IShikakuSoshitsuJiyu createShikakuSoshitsuJiyu() {
        final ShikakuSoshitsuJiyu reason = ShikakuSoshitsuJiyu.なし;
        return new IShikakuSoshitsuJiyu() {
            @Override
            public RString getCode() {
                return reason.getCode();
            }

            @Override
            public RString getName() {
                return reason.getName();
            }

            @Override
            public RString getShortName() {
                return reason.getShortName();
            }
        };
    }
}
