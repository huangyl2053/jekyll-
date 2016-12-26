/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 *
 * {@link HokenshaJohoDiv}のHandlerクラスです。
 *
 * @reamsid_L DBA-0180-010 lishengli
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
     * 保険者入力補助の初期化です。
     *
     * @param 保険者番号 保険者番号
     */
    public void intialize(HokenjaNo 保険者番号) {
        if (保険者番号 != null) {
            Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(保険者番号);
            div.getTxtHokenshaNo().setValue(保険者番号.getColumnValue());
            if (hokensha != null) {
                div.getTxtHokenshaMeisho().setValue(hokensha.get保険者名());
            } else {
                div.getTxtHokenshaMeisho().setValue(new RString(""));
            }
        }
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

    /**
     * 保険者番号のコントロールを取得する。
     *
     * @return 保険者番号
     */
    public TextBoxCode getHokenjaNotext() {
        return div.getTxtHokenshaNo();
    }
}
