/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 介護保険医療保険加入状況の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class IryohokenKanyuJokyoIdentifier implements Serializable {

    private static final long serialVersionUID = -8002449803388674571L;
    private final ShikibetsuCode 識別コード;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public IryohokenKanyuJokyoIdentifier(ShikibetsuCode 識別コード,
            int 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
