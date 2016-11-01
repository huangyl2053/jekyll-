/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.ChohyoResult;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収依頼金額明細一覧表出力用パラメータのクラスです。
 *
 * @reamsid_L DBB-0930-010 xuzhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtMeisaiIchiranProcessParameter implements IBatchProcessParameter {

    private ChohyoResult 出力帳票一覧;
    private RDateTime 調定日時;
}
