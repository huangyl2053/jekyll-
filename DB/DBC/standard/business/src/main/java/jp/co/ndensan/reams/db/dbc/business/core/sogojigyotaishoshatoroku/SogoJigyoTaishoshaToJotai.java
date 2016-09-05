/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sogojigyotaishoshatoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業対象の情報と状態を管理するクラスです。
 *
 * @reamsid_L DBC-4900-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoJigyoTaishoshaToJotai implements Serializable {

    private RString 状態;
    private SogoJigyoTaishosha 総合事業対象;

    /**
     * コンストラクタです。<br/>
     * 総合事業対象の情報の新規作成時に使用します。
     *
     * @param 総合事業対象 総合事業対象
     * @param 状態 状態
     */
    public SogoJigyoTaishoshaToJotai(RString 状態, SogoJigyoTaishosha 総合事業対象) {
        this.状態 = 状態;
        this.総合事業対象 = 総合事業対象;
    }

}
