/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT82001_特徴送付情報作成の（特徴依頼）年金特徴対象者情報の登録のProcessParameterです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKaigohokenNenkinTaishosha1ProcessParameter implements IBatchProcessParameter {

    private YMDHMS システム日時;

    /**
     * コンストラクタです。
     *
     * @param システム日時 YMDHMS
     */
    public InsKaigohokenNenkinTaishosha1ProcessParameter(YMDHMS システム日時) {
        this.システム日時 = システム日時;
    }

}
