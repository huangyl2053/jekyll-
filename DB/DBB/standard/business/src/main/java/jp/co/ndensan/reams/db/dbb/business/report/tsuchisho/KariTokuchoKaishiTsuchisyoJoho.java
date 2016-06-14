/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定特徴開始通知書情報
 *
 * @reamsid_L DBB-0790-060 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariTokuchoKaishiTsuchisyoJoho {

    private FlexibleDate 発行日;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private IAtesaki 宛先情報;
    private ShoriKubun 処理区分;
    private Association 地方公共団体;
    private RString 特徴捕捉月;

}
