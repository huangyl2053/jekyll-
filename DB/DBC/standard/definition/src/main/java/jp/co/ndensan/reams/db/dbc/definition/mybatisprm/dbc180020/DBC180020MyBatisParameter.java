/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBC180020MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC180020MyBatisParameter implements IMyBatisParameter {

    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private RString 判定基準日;
    private RString 判定基準日の月;
    private RString 対象年度;
    private RString 対象年度開始日;
    private RString 対象年度終了日;
    private RString 対象開始日;
    private RString 対象終了日;
    private RString 対象月;

    /**
     * DBC180020MyBatisParameterのコンストラクタです。
     */
    public DBC180020MyBatisParameter() {
    }

    /**
     * DBC180020MyBatisParameterのコンストラクタです。
     *
     * @param 判定基準日 RString
     * @param 対象年度 RString
     * @param 対象月 RString
     */
    public DBC180020MyBatisParameter(RString 判定基準日, RString 対象年度, RString 対象月) {
        this.判定基準日 = 判定基準日;
        this.判定基準日の月 = RString.isNullOrEmpty(判定基準日) ? RString.EMPTY : 判定基準日.substring(NUM4, NUM6);
        this.対象年度 = 対象年度;
        this.対象月 = 対象月;
    }
}
