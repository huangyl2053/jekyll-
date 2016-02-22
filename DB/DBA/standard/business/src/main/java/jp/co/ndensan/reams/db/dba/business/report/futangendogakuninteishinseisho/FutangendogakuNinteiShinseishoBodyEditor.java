/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.futangendogakuninteishinseisho.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険負担限度額認定申請書ボディEditorです。
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
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.shiseibun = item.getShiseibun();
        source.chuibun = item.getChuibun();
        source.remban = new RString("1");
        return source;
    }
}
