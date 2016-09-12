/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 結果詳細情報画面の出力パラメータ(サービス種類)です。
 *
 * @reamsid_L DBZ-1320-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KekkaShosaiJohoServiceShuri implements Serializable {

    private RString serviceShuriCode;
    private RString serviceShuriName;

    /**
     * コンストラクタです。
     *
     * @param serviceShuriCode サービス種類コード
     * @param serviceShuriName サービス種類名称
     */
    public KekkaShosaiJohoServiceShuri(RString serviceShuriCode, RString serviceShuriName) {
        this.serviceShuriCode = serviceShuriCode;
        this.serviceShuriName = serviceShuriName;
    }
}
