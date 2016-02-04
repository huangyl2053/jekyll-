/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1020011;

import jp.co.ndensan.reams.db.dba.business.nenreitotatsushikakuido.NenreitotatsuJoken;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1020011.NenReiTotatsuSearchConditionDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.neiReiTotatsuSrchConInfo.NenReiTotatsuSrchConInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住基連動登録者のバリデーションチェッククラスです。
 */
public class NenReiTotatsuSearchConditionHandler {

    private static final RString btn名 = new RString("修正する");
    private final NenReiTotatsuSearchConditionDiv div;
    

    /**
     * コンストラクタです。
     *
     * @param div 住基連動登録者Div
     */
    public NenReiTotatsuSearchConditionHandler(NenReiTotatsuSearchConditionDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     * @param nenreitotatsuJoken 年齢到達条件情報の取得するクラスです
     */
    public void load(NenreitotatsuJoken nenreitotatsuJoken) {
        div.getCcdNenReiTotatsuSearchCondition().setMode_DisplayMode(NenReiTotatsuSrchConInfoDiv.DisplayMode.KensakuInput);
        div.getCcdNenReiTotatsuSearchCondition().getBtnKensaku().setVisible(true);
        div.getCcdNenReiTotatsuSearchCondition().getBtnKensaku().setText(btn名);
        div.getCcdNenReiTotatsuSearchCondition().getBtnKensaku().setDisabled(false);
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().setValue(nenreitotatsuJoken.get前回処理期間開始日());
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().setValue(nenreitotatsuJoken.get前回処理期間終了日());
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().setValue(new FlexibleDate(nenreitotatsuJoken.get年齢到達期間開始日()));
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().setValue(new FlexibleDate(nenreitotatsuJoken.get年齢到達期間終了日()));
        set非活性();
    }
    
     private void set非活性() {
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiFrom().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtZenkaiTo().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().setDisabled(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanFrom().setRequired(true);
        div.getCcdNenReiTotatsuSearchCondition().getTxtNenreiTotatsuKikanTo().setRequired(true);
    }
}
