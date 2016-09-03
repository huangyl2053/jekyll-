/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 被保台帳生年月日情報処理のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshaDaichoBirthYMDMybatisParameter implements IMyBatisParameter {

    private final YMDHMS syoriNitiji;
    private final FlexibleYearMonth syukeiYM;
    private final Code shukeiNo;

    /**
     * コンストラクタです。
     *
     * @param 処理日時 処理日時
     * @param 集計年月 集計年月
     * @param 集計番号 集計番号
     */
    public HihokenshaDaichoBirthYMDMybatisParameter(YMDHMS 処理日時, FlexibleYearMonth 集計年月, Code 集計番号) {
        this.syoriNitiji = 処理日時;
        this.syukeiYM = 集計年月;
        this.shukeiNo = 集計番号;
    }
}
