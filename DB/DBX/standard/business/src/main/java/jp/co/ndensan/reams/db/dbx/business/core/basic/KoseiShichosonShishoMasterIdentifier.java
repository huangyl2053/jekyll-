/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 構成市町村支所マスタの識別子です。
 *
 * @reamsid_L DBE-9999-021 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KoseiShichosonShishoMasterIdentifier implements Serializable {

    private static final long serialVersionUID = 137787803062746923L;

    private final LasdecCode 市町村コード;
    private final ShishoCode 支所コード;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     */
    public KoseiShichosonShishoMasterIdentifier(LasdecCode 市町村コード,
            ShishoCode 支所コード) {
        this.市町村コード = 市町村コード;
        this.支所コード = 支所コード;
    }
}
