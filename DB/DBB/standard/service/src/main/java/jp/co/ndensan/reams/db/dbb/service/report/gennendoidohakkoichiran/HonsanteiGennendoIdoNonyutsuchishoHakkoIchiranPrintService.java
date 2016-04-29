/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.gennendoidohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran.HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran.HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 保険料納入通知書（本算定現年度異動）発行一覧表
 *
 * @reamsid_L DBB-0880-050 zhangrui
 *
 */
public class HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranPrintService {

    /**
     * 保険料納入通知書（本算定現年度異動）発行一覧表 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuのList
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 帳票作成日時 RString
     * @param 市町村名 RString
     * @param 市町村コード RString
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名) {
        HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty property
                = new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty();
        return new Printer<NonyuTsuchIchiranSource>().spool(property,
                new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport(編集後本算定通知書共通情報, バッチパラメータ,
                        帳票作成日時, 市町村コード, 市町村名));
    }

}
