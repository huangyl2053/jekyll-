/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo.TokubetsuChoshuIraiJohoKensuhyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のEntity
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class TokubetsuChoshuIraiJohoKensuhyoParameter {

    private TokubetsuChoshuIraiJohoKensuhyoEntity entity;
    private RDateTime 作成日時;
    private RString 該当件数の件数の合計;
    private RString 金額1の金額の合計;
    private RString 金額2の金額の合計;
}
