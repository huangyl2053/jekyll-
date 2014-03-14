/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dba.definition.valueobject.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者のファクトリークラスです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaFactory {

    private HihokenshaFactory() {
    }

    /**
     * 被保険者のインスタンスを生成します。 <br />
     * 被保険者台帳への新規登録時などで利用することを想定しています。
     *
     * @param 被保険者番号 被保険者番号
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 資格異動区分 資格異動区分
     * @param 被保険者区分 被保険者区分
     * @param 資格取得届出年月日 資格取得届出年月日
     * @param 資格取得年月日 資格取得年月日
     * @param 資格取得事由 資格取得事由
     * @param 一号年齢到達日 一号年齢到達日
     * @return 新しい被保険者
     */
    public static Hihokensha createInstance(KaigoHihokenshaNo 被保険者番号, ShichosonCode 市町村コード, ShikibetsuCode 識別コード,
            ShikakuIdoKubun 資格異動区分, HihokenshaKubun 被保険者区分,
            RDate 資格取得届出年月日, RDate 資格取得年月日, IShikakuShutokuJiyu 資格取得事由, RDate 一号年齢到達日) {

        IKaigoShikaku 介護保険資格 = KaigoShikakuFactory.createInstance(
                識別コード, HokenShubetsu.介護保険,
                資格取得届出年月日, 資格取得年月日, 資格取得事由,
                null, RDate.MAX, createEmpty資格喪失事由(),
                被保険者番号.getValue(), 市町村コード.getValue(), null,
                to資格被保険者区分(被保険者区分), JushochiTokureishaKubun.通常資格者);

        return new Hihokensha(介護保険資格, 市町村コード, 資格異動区分, 被保険者区分,
                null, null, null, null, null, null, null, null, null, false, false, null, false, null);
    }

    /**
     * HihokenshaKubunを共通のShikakuHihokenshaKubunへ変換します。
     *
     * @param 被保険者区分 被保険者区分
     * @return HihokenshaKubunに対応するShikakuHihokenshaKubun
     */
    //TODO n3327 三浦凌 このメソッドは、コードマスタの内容が確定したら実装する。
    private static ShikakuHihokenshaKubun to資格被保険者区分(HihokenshaKubun 被保険者区分) {
        return ShikakuHihokenshaKubun.第１号被保険者;
    }

    private static IShikakuSoshitsuJiyu createEmpty資格喪失事由() {
        return new IShikakuSoshitsuJiyu() {
            @Override
            public RString getCode() {
                return RString.EMPTY;
            }

            @Override
            public RString getName() {
                return RString.EMPTY;
            }

            @Override
            public RString getShortName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
