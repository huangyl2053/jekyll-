/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kanendoidohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidohakkoichiran.HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kanendoidohakkoichiran.HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 保険料納入通知書（本算定過年度異動）発行一覧表
 *
 * @reamsid_L DBB-0920-050 zhangrui
 *
 */
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService {

    private static final RString 漢字_作成 = new RString("作成");

    /**
     * 保険料納入通知書（本算定現年度異動）発行一覧表 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuのList
     * @param 調定年度 RString
     * @param 出力期 RString
     * @param 調定日時 RString
     * @param 出力順ID RString
     * @param 納入対象賦課年度List List<RString>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            RString 調定年度, RString 出力期, YMDHMS 調定日時, RString 出力順ID, List<RString> 納入対象賦課年度List) {
        RString 年月日 = 調定日時.getRDateTime().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時刻 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RString 作成日時 = new RString(年月日.concat(RString.HALF_SPACE).concat(時刻).concat(RString.HALF_SPACE).concat(漢字_作成).toString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        RString 市町村名 = association.get市町村名();
        HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty property
                = new HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranProperty();
        return new Printer<NonyuTsuchIchiranSource>().spool(property,
                new HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranReport(編集後本算定通知書共通情報, 調定年度, 出力期,
                        作成日時, 出力順ID, 地方公共団体コード, 市町村名, 納入対象賦課年度List));
    }

}
