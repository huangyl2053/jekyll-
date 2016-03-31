/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dbz.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * {@link HokenshaJohoDiv}のHandlerクラスです。
 */
public class HokenshaJohoHandler {

    private final HokenshaJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public HokenshaJohoHandler(HokenshaJohoDiv div) {
        this.div = div;
    }

    /**
     * 保険者名の設定します。
     *
     * @param hokensha 保険者
     */
    public void onBlur_txtHokenshaNo(Hokensha hokensha) {
        if (hokensha != null) {
            div.getTxtHokenshaMeisho().setValue(hokensha.get保険者名());
        } else {
            div.getTxtHokenshaMeisho().setValue(new RString(""));
        }
    }

    /**
     * 保険者情報をクリアする。
     *
     */
    public void clear() {
        div.getTxtHokenshaNo().clearValue();
        div.getTxtHokenshaMeisho().clearValue();
    }

    /**
     * 保険者番号を取得する。
     *
     * @return 保険者番号
     */
    public RString getHokenjaNo() {
        return div.getTxtHokenshaNo().getValue();
    }

    /**
     * 保険者名を取得する。
     *
     * @return 保険者名
     */
    public RString getHokenjaName() {
        return div.getTxtHokenshaMeisho().getValue();
    }

    /**
     * 保険者番号を設定する。
     *
     * @param 保険者番号 HokenjaNo
     */
    public void setHokenjaNo(RString 保険者番号) {
        div.getTxtHokenshaNo().setValue(保険者番号);
    }

    /**
     * 保険者名を設定する。
     *
     * @param 保険者名 HokenjaName
     */
    public void setHokenjaName(RString 保険者名) {
        div.getTxtHokenshaMeisho().setValue(保険者名);
    }
}
