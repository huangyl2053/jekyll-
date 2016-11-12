/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収依頼金額明細一覧表出力パラメータクラスです。
 *
 * @reamsid_L DBB-0930-020 xuzhao
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtMeisaiIchiranMyBatisParameter implements IMyBatisParameter {

    private final RString 通知内容コード;
    private final boolean is6月捕捉が04;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 通知内容コード RString
     * @param is6月捕捉が04 boolean
     * @param 出力順 RString
     */
    public PrtMeisaiIchiranMyBatisParameter(RString 通知内容コード, boolean is6月捕捉が04,
            RString 出力順) {
        this.通知内容コード = 通知内容コード;
        this.is6月捕捉が04 = is6月捕捉が04;
        this.出力順 = 出力順;
    }
}
