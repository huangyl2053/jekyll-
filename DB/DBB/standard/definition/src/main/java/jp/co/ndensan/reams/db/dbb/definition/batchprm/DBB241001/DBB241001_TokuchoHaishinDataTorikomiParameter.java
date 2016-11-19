/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB241001;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * バッチ設計_DBB241001_特徴配信データ取り込みのバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB241001_TokuchoHaishinDataTorikomiParameter extends BatchParameterBase {

    private RString dumy;

    /**
     * コンストラクタです。
     *
     * @param dumy dumy
     */
    public DBB241001_TokuchoHaishinDataTorikomiParameter(RString dumy) {
        this.dumy = dumy;
    }

    /**
     * コンストラクタです。
     *
     */
    public DBB241001_TokuchoHaishinDataTorikomiParameter() {
    }

}
