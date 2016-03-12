/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書打ち分け条件の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TsuchishoUchiwakeJokenIdentifier implements Serializable {

    private final RString 打ち分け条件;
    private final RDateTime 保存日時;
    private final RString 賦課処理区分;

    /**
     * コンストラクタです。
     *
     * @param 打ち分け条件 打ち分け条件
     * @param 保存日時 保存日時
     * @param 賦課処理区分 賦課処理区分
     */
    public TsuchishoUchiwakeJokenIdentifier(RString 打ち分け条件,
            RDateTime 保存日時,
            RString 賦課処理区分) {
        this.打ち分け条件 = 打ち分け条件;
        this.保存日時 = 保存日時;
        this.賦課処理区分 = 賦課処理区分;
    }
}
