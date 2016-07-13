/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格不整合データ抽出processParameter
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SelectShikakuFuseigoDataProcessParameter implements IBatchProcessParameter {

    private YMDHMS システム日時;

    /**
     * コンストラクタ
     *
     * @param システム日時 FlexibleYear
     */
    public SelectShikakuFuseigoDataProcessParameter(YMDHMS システム日時) {
        this.システム日時 = システム日時;
    }

}
