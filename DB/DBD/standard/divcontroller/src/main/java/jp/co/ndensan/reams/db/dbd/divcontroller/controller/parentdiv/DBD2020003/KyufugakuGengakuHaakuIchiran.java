
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2020003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209011.DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020003.ChishutsuJokenParameterDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額管理リスト（画面）クラスです．
 *
 * @reamsid_L DBD-3610-040 x_lilh
 */
public class KyufugakuGengakuHaakuIchiran {

    private static final RString SELECTED_VALUE = new RString("0");
    private static final RString UN_SELECTED_VALUE = new RString("1");
    private static final ReportId REPORTID = ReportIdDBD.DBD200008.getReportId();

    /**
     * コンストラクタです。
     */
    public KyufugakuGengakuHaakuIchiran() {
    }

    /**
     * 給付額減額滞納者把握パラメターを取得します．
     *
     * @param div div
     * @return 給付額減額滞納者把握パラメター
     */
    public DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter createKyufuGengakuHaakuIchiranParameter(ChishutsuJokenParameterDiv div) {
        DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter parameter = new DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter();

        parameter.set基準日(div.getChishutsuJoken().getTxtKijunbi().getValue());
        parameter.set時効起算日登録者の選択(isRadCheckedValue(div.getRadJikoKisanbiTorokushaNomi().getSelectedKey()));
        parameter.set被保険者全員の選択(isRadCheckedValue(div.getRadHihokenshaZenin().getSelectedKey()));
        parameter.set受給者全員の選択(isCheckedValue(div.getChkJukyushaZenin().getSelectedValues()));
        parameter.set受給認定申請中者の選択(isCheckedValue(div.getChkJukyuNinteiShinseityusha().getSelectedValues()));
        parameter.set受給認定日抽出(isCheckedValue(div.getChkJukyuNinteibiChushutsu().getSelectedValues()));
        parameter.set受給認定日抽出の開始(div.getTxtJukyuNinteibiKaishi().getValue());
        parameter.set受給認定日抽出の終了(div.getTxtJukyuNinteibiShuryo().getValue());
        parameter.set認定有効終了日抽出(isCheckedValue(div.getChkNinteiYukoShuryobiChushutsu().getSelectedValues()));
        parameter.set認定有効終了日抽出の開始(div.getTxtNinteiYukoShuryobiKaishi().getValue());
        parameter.set認定有効終了日抽出の終了(div.getTxtNinteiYukoShuryobiShuryo().getValue());
        parameter.set保険料完納者も出力(isCheckedValue(div.getChishutsuJoken().getChkHokenKannoshaShutsuryoku().getSelectedValues()));
        parameter.set改頁出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.set帳票ID(REPORTID);

        return parameter;
    }

    private RString isCheckedValue(List<RString> isSelectedList) {
        if (isSelectedList != null && !isSelectedList.isEmpty()) {
            return SELECTED_VALUE;
        }
        return UN_SELECTED_VALUE;
    }

    private RString isRadCheckedValue(RString selectedValue) {
        if (!selectedValue.isNullOrEmpty()) {
            return UN_SELECTED_VALUE;
        }
        return SELECTED_VALUE;
    }
}
