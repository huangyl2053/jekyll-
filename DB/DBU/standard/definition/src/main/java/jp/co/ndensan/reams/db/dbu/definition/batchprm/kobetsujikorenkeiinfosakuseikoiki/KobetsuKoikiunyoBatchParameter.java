/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki;

import java.util.List;
import lombok.Getter;

/**
 *
 * 介護住民票個別事項連携情報_バッチパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KobetsuKoikiunyoBatchParameter {

    private final List<KobetsuKoikiunyoParameter> parameter;

    /**
     * コンストラクタを作成します。
     *
     * @param parameter parameter
     */
    public KobetsuKoikiunyoBatchParameter(List<KobetsuKoikiunyoParameter> parameter) {
        this.parameter = parameter;
    }
}
