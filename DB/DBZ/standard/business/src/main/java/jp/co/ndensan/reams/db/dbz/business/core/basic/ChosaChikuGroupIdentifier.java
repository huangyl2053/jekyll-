/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 調査地区グループマスタの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ChosaChikuGroupIdentifier implements Serializable {

    private final Code 調査地区グループコード;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 調査地区グループコード 調査地区グループコード
     * @param 市町村コード 市町村コード
     */
    public ChosaChikuGroupIdentifier(Code 調査地区グループコード,
            LasdecCode 市町村コード) {
        this.調査地区グループコード = 調査地区グループコード;
        this.市町村コード = 市町村コード;
    }
}
