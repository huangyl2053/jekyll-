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
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
     * @param 賦課年度 RString
     * @param 出力期 RString
     * @param 帳票作成日時 RString
     * @param 出力順ID RString
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            RString 賦課年度, RString 出力期,
            RString 帳票作成日時, RString 出力順ID) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty property
                = new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranProperty();
        return new Printer<NonyuTsuchIchiranSource>().spool(property,
                new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport(編集後本算定通知書共通情報, 賦課年度, 出力期,
                        帳票作成日時, 出力順ID, 地方公共団体コード, 市町村名));
    }

}
