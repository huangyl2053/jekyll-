/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始通知書(本算定）の発行クラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKaishiTsuchishoInfo {

    private HonSanteiTsuchiShoKyotsu 本算定通知書情報;
    private RString 生活保護区分;
    private RString 特徴10月開始者区分;
    private EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
}
