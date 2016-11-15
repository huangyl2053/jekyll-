/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb241001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのprocessパラメーターです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHaishinDataTorikomiProcessParameter implements IBatchProcessParameter {

    private RString fileName;
    private RDateTime shoriYMDHM;

    /**
     * コンストラクタです
     *
     * @param fileName RString
     * @param shoriYMDHM RDateTime
     */
    public TokuchoHaishinDataTorikomiProcessParameter(RString fileName, RDateTime shoriYMDHM) {
        this.fileName = fileName;
        this.shoriYMDHM = shoriYMDHM;
    }
}
