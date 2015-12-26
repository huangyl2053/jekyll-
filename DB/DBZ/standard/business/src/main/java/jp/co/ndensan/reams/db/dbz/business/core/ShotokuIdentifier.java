/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 介護所得の識別子です。
 */
@Value
public class ShotokuIdentifier implements Serializable {

    private final FlexibleYear 所得年度;
    private final ShikibetsuCode 識別コード;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 所得年度 所得年度
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public ShotokuIdentifier(FlexibleYear 所得年度,
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        this.所得年度 = 所得年度;
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }

    /**
     * get所得年度
     *
     * @return 所得年度
     */
    public FlexibleYear get所得年度() {
        return 所得年度;
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
    public Decimal get履歴番号() {
        return 履歴番号;
    }
}
