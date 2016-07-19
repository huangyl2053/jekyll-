/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800001.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険負担限度額認定申請書ボディEditorです。
 *
 * @reamsid_L DBA-0540-690 suguangjun
 */
public class FutangendogakuNinteiShinseishoBodyEditor implements IFutangendogakuNinteiShinseishoEditor {

    private final FutangendogakuNinteiShinseishoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険負担限度額認定申請書情報
     */
    public FutangendogakuNinteiShinseishoBodyEditor(FutangendogakuNinteiShinseishoBodyItem item) {
        this.item = item;
    }

    /**
     * 介護保険負担限度額認定申請書ボディEditorです。
     *
     * @param source 介護保険負担限度額認定申請書Source
     * @return 介護保険負担限度額認定申請書Source
     */
    @Override
    public FutangendogakuNinteiShinseishoReportSource edit(FutangendogakuNinteiShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private FutangendogakuNinteiShinseishoReportSource bodyEdit(FutangendogakuNinteiShinseishoReportSource source) {
        source.shiseibun = item.getShiseibun();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.seibetsu = item.getSeibetsu();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.chuibun = item.getChuibun();
        source.remban = new RString("1");
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.hihokenshaNo = item.getHihokenshaNo();
        return source;
    }
}
