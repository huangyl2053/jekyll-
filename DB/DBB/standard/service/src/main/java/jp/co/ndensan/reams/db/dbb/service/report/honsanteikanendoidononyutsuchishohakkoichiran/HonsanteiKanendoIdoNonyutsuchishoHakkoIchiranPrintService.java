/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.honsanteikanendoidononyutsuchishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikanendoidononyutsuchishohakkoichiran.HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikanendoidononyutsuchishohakkoichiran.HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendoikkatsuhakko.HonSanteiIdoKanendoIkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 保険料納入通知書（本算定過年度異動）発行一覧表
 *
 * @reamsid_L DBB-0920-050 zhangrui
 *
 */
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService {

    /**
     * 保険料納入通知書（本算定現年度異動）発行一覧表 printメソッド
     *
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param バッチパラメータ HonSanteiIdoKanendoIkkatsuHakkoBatchParameter
     * @param 調定日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            HonSanteiIdoKanendoIkkatsuHakkoBatchParameter バッチパラメータ, YMDHMS 調定日時) {
        HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty property
                = new HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty();
        return new Printer<NonyuTsuchIchiranSource>().spool(property,
                new HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranReport(編集後本算定通知書共通情報, バッチパラメータ, 調定日時));
    }

}
