/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB213001;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB213001_特徴送付情報連携のバッチパラメタークラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB213001_TokuchoSofuJohoRenkeiParameter extends BatchParameterBase {

    private RString dumy;

    /**
     * コンストラクタです。
     *
     * @param dumy dumy
     */
    public DBB213001_TokuchoSofuJohoRenkeiParameter(RString dumy) {
        this.dumy = dumy;
    }
}
