/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import lombok.Value;

/**
 * 構成市町村支所マスタの識別子です。
 */
@Value
public class KoseiShichosonShishoMasterIdentifier implements Serializable {

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
