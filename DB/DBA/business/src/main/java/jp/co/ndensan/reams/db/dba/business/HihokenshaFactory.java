/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
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
    public static Hihokensha createInstance(KaigoHihokenshaNumber 被保険者番号, ShichosonCode 市町村コード, IShikibetsuCode 識別コード,
            ShikakuIdoKubun 資格異動区分, HihokenshaKubun 被保険者区分,
            RDate 資格取得届出年月日, RDate 資格取得年月日, ShikakuShutokuJiyu 資格取得事由, RDate 一号年齢到達日) {

        IKaigoShikaku 介護保険資格 = KaigoShikakuFactory.createInstance(
                識別コード, HokenShubetsu.介護保険,
                資格取得届出年月日, 資格取得年月日, 資格取得事由.getName(),
                null, RDate.MAX, RString.EMPTY,
                被保険者番号.getValue(), 市町村コード.getValue(), null);

        return new Hihokensha(介護保険資格, 市町村コード, 資格異動区分, 被保険者区分,
                null, null, null, null, null, null, null, null, null, false, false, null, false, null);
    }
}
