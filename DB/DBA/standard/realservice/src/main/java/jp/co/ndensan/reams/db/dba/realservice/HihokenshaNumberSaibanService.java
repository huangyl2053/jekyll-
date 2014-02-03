/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
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
    public KaigoHihokenshaNo createNewNumber() {
        return new KaigoHihokenshaNo(getNewCode(new RString("DB"), RDate.MAX, new RString("新規の被保険者")));
    }

    @Override
    public RString getNewCode(RString gyomuCode, RDate nendo, RString yoto) {
        return new RString("新しい被保険者番号");
    }
}
