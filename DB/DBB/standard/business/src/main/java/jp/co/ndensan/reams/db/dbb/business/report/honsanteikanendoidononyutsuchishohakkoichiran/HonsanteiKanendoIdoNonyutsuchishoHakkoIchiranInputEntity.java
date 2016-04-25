/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikanendoidononyutsuchishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendoikkatsuhakko.HonSanteiIdoKanendoIkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 帳票設計_DBBPR45002_保険料納入通知書（本算定過年度異動）発行一覧表 入力Entityです。
 *
 * Sourceは帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0920-050 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranInputEntity {

    private final List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報;
    private final HonSanteiIdoKanendoIkkatsuHakkoBatchParameter バッチパラメータ;
    private final YMDHMS 調定日時;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuのListです
     * @param バッチパラメータ HonSanteiIdoKanendoIkkatsuHakkoBatchParameter
     * @param 調定日時 YMDHMS
     */
    public HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranInputEntity(
            List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            HonSanteiIdoKanendoIkkatsuHakkoBatchParameter バッチパラメータ, YMDHMS 調定日時) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
        this.調定日時 = 調定日時;
    }

}
