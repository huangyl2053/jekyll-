/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshanotsukiban;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * 被保険者番号のパラメータクラスです。
 */
public class HihokenshanotsukibanParameter {

    private final ShikibetsuCode shikibetsuCode;

    private HihokenshanotsukibanParameter(
            ShikibetsuCode shikibetsuCode
    ) {
        this.shikibetsuCode = shikibetsuCode;
    }

    public static HihokenshanotsukibanParameter createHihokenshanotsukibanParameter(
            ShikibetsuCode shikibetsuCode
    ) {
        return new HihokenshanotsukibanParameter(shikibetsuCode);
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }
}
