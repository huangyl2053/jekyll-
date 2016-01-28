/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * ランク情報の識別子です。
 */
@Value
public class RankJohoIdentifier implements Serializable {

    private final FlexibleYear 賦課年度;
    private final RString ランク区分;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     */
    public RankJohoIdentifier(FlexibleYear 賦課年度,
            RString ランク区分) {
        this.賦課年度 = 賦課年度;
        this.ランク区分 = ランク区分;
    }
}
