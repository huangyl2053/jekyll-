/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Value;

/**
 * 介護保険医療保険加入状況の識別子です。
 */
@Value
public class IryohokenKanyuJokyoIdentifier implements Serializable {

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

    /**
     * get識別コード
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * get履歴番号
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return 履歴番号;
    }
}
