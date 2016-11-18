/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録処理戻るの対象でうす。
 *
 * @reamsid_L DBC-1030-180 zhuxj2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ModoruEntity implements Serializable {

    private ShokanHanteiKekka 償還払支給判定結果;
    private ArrayList<ShokanShukei> 償還払請求集計データList;
    private ArrayList<ShokanServicePlan200904> 償還払請求サービス計画200904データList;
    private ArrayList<ShokanServicePlan200604> 償還払請求サービス計画200604データList;
    private ArrayList<ShokanServicePlan200004> 償還払請求サービス計画200004データList;
    private ArrayList<ShokanShokujiHiyo> 償還払請求食事費用データList;
    private ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList;
    private RString 修正前支給区分;

}
