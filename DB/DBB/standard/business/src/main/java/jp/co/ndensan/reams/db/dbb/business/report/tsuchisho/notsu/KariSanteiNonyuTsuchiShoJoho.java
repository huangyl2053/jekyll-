/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 仮算定納入通知書情報です。
 *
 * @reamsid_L DBB-9110-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiNonyuTsuchiShoJoho {

    private FlexibleDate 発行日;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private ShoriKubun 処理区分;
    private EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private SanteiNoKiso 算定の基礎;
    private Association 地方公共団体;
    private NofuShoKyotsu 納付書共通;
    private List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private List<Kitsuki> 出力期リスト;
    private HenshuHaniKubun 編集範囲区分;
    private int 連番;

}
