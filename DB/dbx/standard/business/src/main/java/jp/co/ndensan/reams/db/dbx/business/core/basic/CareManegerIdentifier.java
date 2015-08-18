/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 介護支援専門員の識別子です。
 */
@Value
public class CareManegerIdentifier implements Serializable {

    private final RString 介護支援専門員番号;

    /**
     * コンストラクタです。
     *
     * @param 介護支援専門員番号 介護支援専門員番号
     */
    public CareManegerIdentifier(RString 介護支援専門員番号) {
        this.介護支援専門員番号 = 介護支援専門員番号;
    }
}
