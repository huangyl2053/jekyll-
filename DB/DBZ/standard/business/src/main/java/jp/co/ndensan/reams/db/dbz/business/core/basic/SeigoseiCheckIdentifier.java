/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 整合性チェック情報の識別子です。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SeigoseiCheckIdentifier implements Serializable {

    private static final long serialVersionUID = 2303472172915463548L;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     */
    public SeigoseiCheckIdentifier(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }
}
