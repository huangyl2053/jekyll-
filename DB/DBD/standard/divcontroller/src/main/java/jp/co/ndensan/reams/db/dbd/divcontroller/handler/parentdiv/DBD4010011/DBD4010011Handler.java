/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4010011;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd4010011.ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011.DBD4010011Div;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 障がい者控除対象者认定のハンドラクラスです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
public class DBD4010011Handler {

    private final DBD4010011Div dBD4010011Div;

    /**
     * コンストラクタです。
     *
     * @param div 障がい者控除対象者认定のコントロールdiv
     */
    public DBD4010011Handler(DBD4010011Div dBD4010011Div) {
        this.dBD4010011Div = dBD4010011Div;
    }

    /**
     * バッチ用パラメータを作成します。
     *
     * @return ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter 障がい者控除対象者认定_バッチ用のパラメータです。
     */
    public ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter getParameter() {
        ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter parameter = new ShogaishaKojoTaishoshaHaakuKekkaIchiranParameter();

        RDate 対象年度 = dBD4010011Div.getShogaishaKojoNinteiJoho().getTaishoNendo().getValue();
        RDate 申請年月日 = dBD4010011Div.getShogaishaKojoNinteiJoho().getSinseiNengabi().getValue();
        RDate 決定年月日 = dBD4010011Div.getShogaishaKojoNinteiJoho().getKeteiNengabi().getValue();
        boolean 基準日より後に資格喪失した者 = dBD4010011Div.getShogaishaKojoTaishoshaHaakuJoken().getChkJogaiJoken().getSelectedKeys().contains(new RString("removeSoshitsusha"));
        boolean 前回把握時の非該当者 = dBD4010011Div.getShogaishaKojoTaishoshaHaakuJoken().getChkJogaiJoken().getSelectedKeys().contains(new RString("includeHigaishosha"));
        parameter.set基準日(dBD4010011Div.getShogaishaKojoTaishoshaHaakuJoken().getTxtKijunYMD().getValue());
        parameter.set対象年度(new FlexibleYear(対象年度.toDateString()));
        parameter.set申請年月日(new FlexibleDate(申請年月日.toDateString()));
        parameter.set決定年月日(new FlexibleDate(決定年月日.toDateString()));
        parameter.set基準日より後に資格喪失した者(基準日より後に資格喪失した者);
        parameter.set前回把握時の非該当者(前回把握時の非該当者);

        return parameter;
    }

    private TextBoxDate ToTextBoxDate(RDate rDate) {
        TextBoxDate date = new TextBoxDate();
        date.setValue(rDate);
        return date;
    }
}
