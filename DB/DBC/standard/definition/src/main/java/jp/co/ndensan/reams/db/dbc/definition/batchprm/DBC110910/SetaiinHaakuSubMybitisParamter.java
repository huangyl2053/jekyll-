/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * [2_世帯所得・課税判定（バッチ）]のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class SetaiinHaakuSubMybitisParamter implements IMyBatisParameter {

    private final RString 管理識別区分;
    private final RString 住所地特例該当;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param 管理識別区分 管理識別区分
     * @param 住所地特例該当 住所地特例該当
     * @param psmShikibetsuTaisho 宛名
     */
    public SetaiinHaakuSubMybitisParamter(RString 管理識別区分, RString 住所地特例該当, RString psmShikibetsuTaisho) {
        this.住所地特例該当 = 住所地特例該当;
        this.管理識別区分 = 管理識別区分;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * MyBatis用パラメータです。
     *
     * @param 管理識別区分 管理識別区分
     * @param 住所地特例該当 住所地特例該当
     * @param psmShikibetsuTaisho 宛名
     *
     * @return パラメータ
     */
    public SetaiinHaakuSubMybitisParamter createParam(RString 管理識別区分, RString 住所地特例該当, RString psmShikibetsuTaisho) {
        return new SetaiinHaakuSubMybitisParamter(管理識別区分, 住所地特例該当, psmShikibetsuTaisho);
    }
}
