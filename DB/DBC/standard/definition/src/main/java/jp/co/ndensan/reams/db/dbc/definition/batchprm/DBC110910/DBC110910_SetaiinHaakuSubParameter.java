/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 2_世帯所得・課税判定（バッチ）のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC110910_SetaiinHaakuSubParameter extends BatchParameterBase {

    private static final String 管理識別コード = "管理識別区分";
    @BatchParameter(key = 管理識別コード, name = "管理識別区分")
    private RString 管理識別区分;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     */
    public DBC110910_SetaiinHaakuSubParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 管理識別区分 管理識別区分
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public DBC110910_SetaiinHaakuSubParameter(RString 管理識別区分, RString psmShikibetsuTaisho) {
        this.管理識別区分 = 管理識別区分;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 2_世帯所得・課税判定（バッチ）のProcess用パラメータを作成します。
     *
     * @return Process用パラメータ
     */
    public SetaiinHaakuSubTempProcessParameter
            toProcessParamter() {
        return new SetaiinHaakuSubTempProcessParameter(管理識別区分, RString.EMPTY, psmShikibetsuTaisho);
    }
}
