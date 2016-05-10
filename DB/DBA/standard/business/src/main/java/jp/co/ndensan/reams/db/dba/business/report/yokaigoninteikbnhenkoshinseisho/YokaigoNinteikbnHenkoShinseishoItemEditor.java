/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定区分変更申請書のITEMのEditorです。
 *
 * @reamsid_L DBA-0540-713 lishengli
 */
public class YokaigoNinteikbnHenkoShinseishoItemEditor
        implements IYokaigoNinteikbnHenkoShinseishoEditor {

    private final YokaigoNinteikbnHenkoShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link YokaigoNinteikbnHenkoShinseishoItem}
     */
    protected YokaigoNinteikbnHenkoShinseishoItemEditor(YokaigoNinteikbnHenkoShinseishoItem item) {
        this.item = item;
    }

    /**
     * 要介護認定区分変更申請書のITEMのedit
     *
     * @param source 要介護認定区分変更申請書のReportSource
     * @return 要介護認定区分変更申請書のITEMのEditor
     */
    @Override
    public YokaigoNinteikbnHenkoShinseishoReportSource edit(
            YokaigoNinteikbnHenkoShinseishoReportSource source) {
        return editSource(source);
    }

    private YokaigoNinteikbnHenkoShinseishoReportSource editSource(
            YokaigoNinteikbnHenkoShinseishoReportSource source) {
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hishokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.getHihokenshaNo());
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaName = item.getHihokenshaName();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.yokaigoKbn = item.getYokaigoKbn();
        source.yoshienKbn = item.getYoshienKbn();
        source.yokoKikanSTYMD = item.getYokoKikanSTYMD();
        source.yokoKikanEDYMD = item.getYokoKikanEDYMD();
        source.tsuchiBun = item.getTsuchiBun();
        source.remban = item.getRemban();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
