/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;

/**
 * 編集仮算定通知書共通情報です。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedKariSanteiTsuchiShoKyotsuInfo {

    private KariSanteiTsuchiShoKyotsu 仮算定通知書情報;
    private EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書情報;

}
