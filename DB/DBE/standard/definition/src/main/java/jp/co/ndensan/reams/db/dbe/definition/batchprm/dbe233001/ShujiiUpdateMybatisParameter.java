/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 主治医意見書督促状発行更新のMybatisパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiUpdateMybatisParameter implements IMyBatisParameter {

    private final RString 申請書管理番号;
    private final RString temp_督促日;
    private final RString temp_督促方法;
    private final RString temp_督促メモ;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param temp_督促日 督促日
     * @param temp_督促方法 督促方法
     * @param temp_督促メモ 督促メモ
     */
    public ShujiiUpdateMybatisParameter(RString 申請書管理番号,
            RString temp_督促日,
            RString temp_督促方法,
            RString temp_督促メモ
    ) {
        this.申請書管理番号 = 申請書管理番号;
        this.temp_督促日 = temp_督促日;
        this.temp_督促方法 = temp_督促方法;
        this.temp_督促メモ = temp_督促メモ;
    }
}
