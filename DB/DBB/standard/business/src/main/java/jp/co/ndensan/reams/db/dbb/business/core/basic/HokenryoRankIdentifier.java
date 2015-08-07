/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 保険料ランクの識別子です。
 */
@Value
public class HokenryoRankIdentifier implements Serializable {

    private final FlexibleYear 賦課年度;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     */
    public HokenryoRankIdentifier(FlexibleYear 賦課年度,
LasdecCode 市町村コード) {
        this.賦課年度 = 賦課年度;
        this.市町村コード = 市町村コード;
    }
}
