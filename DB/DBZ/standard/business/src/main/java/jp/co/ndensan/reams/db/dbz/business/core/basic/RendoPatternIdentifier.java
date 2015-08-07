/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 連動パターンの識別子です。
 */
@Value
public class RendoPatternIdentifier implements Serializable {

    private final LasdecCode 処理番号;
    private final LasdecCode 連番;

    /**
     * コンストラクタです。
     *
     * @param 処理番号 処理番号
     * @param 連番 連番
     */
    public RendoPatternIdentifier(LasdecCode 処理番号,
            LasdecCode 連番) {
        this.処理番号 = 処理番号;
        this.連番 = 連番;
    }
}
