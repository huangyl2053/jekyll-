/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;

/**
 * 仮算定特徴開始通知書情報
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariTokuchoKaishiTsuchisyoJoho {
    // TODO 発行日
    private FlexibleDate 発行日;
    // TODO 帳票分類ID
    private ReportId 帳票分類ID;
    // TODO 帳票ID
    private ReportId 帳票ID;
    // TODO EditedKariSanteiTsuchiShoKyotsu
    private EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private IAtesaki 宛先情報;
}
