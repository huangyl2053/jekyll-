/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準年月日時点の世帯員（住民）の把握Processのパラメータです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SetaiinHaakuSubTempProcessParameter implements IBatchProcessParameter {

    private final RString 管理識別区分;
    private final RString psmShikibetsuTaisho;
    private final RString 住所地特例該当;

    /**
     * コンストラクタです。
     *
     * @param 管理識別区分 管理識別区分
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 住所地特例該当 住所地特例該当
     */
    public SetaiinHaakuSubTempProcessParameter(RString 管理識別区分, RString 住所地特例該当, RString psmShikibetsuTaisho) {
        this.管理識別区分 = 管理識別区分;
        this.住所地特例該当 = 住所地特例該当;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public SetaiinHaakuSubMybitisParamter toSeigoseiBatchMybitisParamter() {
        return new SetaiinHaakuSubMybitisParamter(管理識別区分, 住所地特例該当, psmShikibetsuTaisho);
    }
}
