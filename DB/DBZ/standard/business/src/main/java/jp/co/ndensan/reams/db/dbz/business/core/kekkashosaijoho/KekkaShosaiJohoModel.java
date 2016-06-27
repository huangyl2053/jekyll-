/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 結果詳細情報画面のパラメータです。
 *
 * @reamsid_L DBZ-1320-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KekkaShosaiJohoModel implements Serializable {

    private RString mode;
    private NinteiInputDataPassModel dataPassModel;
    private RString idoJiyuCode;
    private RString sakujoJiyuCode;
    private RString riyu;
    private FlexibleDate soshitsuDay;
    private FlexibleDate torisageDay;
    private FlexibleDate toshoNinteiKikanFrom;
    private FlexibleDate toshoNinteiKikanTo;
    private FlexibleDate jukyuShikakuHakkoDay1;
    private FlexibleDate jukyuShikakuHakkoDay2;
    private RString shinseiKubunShinsei;
    private RString shinseiKubunLaw;
}
