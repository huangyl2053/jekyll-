/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 本算定決定通知書情報です。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonSanteiKetteiTsuchiShoJoho {

    private GennenKanen 現年度_過年度区分;
    private RDate 発行日;
    private ReportId 帳票分類ID;
    private EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private IAtesaki 宛先情報;
    private ReportId 帳票ID;
    private ShoriKubun 処理区分;
    private Association 地方公共団体;
    private boolean has更正前;
}
