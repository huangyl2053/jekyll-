/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikushichoson;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 地区市町村の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ChikuShichosonIdentifier implements Serializable {

    private static final long serialVersionUID = 6506378449903942447L;

    private final Code 調査地区コード;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     */
    public ChikuShichosonIdentifier(Code 調査地区コード,
            LasdecCode 市町村コード) {
        this.調査地区コード = 調査地区コード;
        this.市町村コード = 市町村コード;
    }
}
