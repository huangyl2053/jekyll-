/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険利用者負担額減額・免除申請書ボディEditorです。
 *
 * @reamsid_L DBA-0540-691 suguangjun
 */
public class RiyoshaFutangakuGengakuMenjyoShinseishoBodyEditor implements IRiyoshaFutangakuGengakuMenjyoShinseishoEditor {

    private final RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険利用者負担額減額・免除申請書情報
     */
    public RiyoshaFutangakuGengakuMenjyoShinseishoBodyEditor(RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem item) {
        this.item = item;
    }

    /**
     * 介護保険被保険者証等再交付申請書ボディEditorです。
     *
     * @param source 介護保険利用者負担額減額・免除申請書Source
     * @return 介護保険利用者負担額減額・免除申請書Source
     */
    @Override
    public RiyoshaFutangakuGengakuMenjyoShinseishoReportSource edit(RiyoshaFutangakuGengakuMenjyoShinseishoReportSource source) {
        return bodyEdit(source);
    }

    private RiyoshaFutangakuGengakuMenjyoShinseishoReportSource bodyEdit(RiyoshaFutangakuGengakuMenjyoShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.title = item.getTitle();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.remban = new RString("1");
        source.hokenshaNo = item.getHokenshaNo();
        return source;
    }
}
