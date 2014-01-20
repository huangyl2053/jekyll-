/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dbz.business.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
//TODO N3327 三浦凌 採番管理についてわかったら修正する。採番の方法ごとにクラスを作成する。
public class HihokenshaNumberSaibanService implements IHihokenshaNumberSaibanService {

    /**
     * コンストラクタです。
     */
    public HihokenshaNumberSaibanService() {
        //dac
    }

    @Override
    public KaigoHihokenshaNumber createNewNumber() {
        return new KaigoHihokenshaNumber(new RString("被保険者番号"));
    }

    @Override
    public RString getNewCode(RString gyomuCode, RDate nendo, RString yoto) {
        return new RString("");
    }
}
