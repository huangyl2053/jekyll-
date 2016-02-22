/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.homonkaigoriyoushafutangakugengakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.homonkaigoriyoushafutangakugengakushinseisho.HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護利用者負担額減額申請書エディターです。
 *
 */
public class HomonkaigoRiyoushaFutangakuGengakuShinseishoEditorImpl implements IHomonkaigoRiyoushaFutangakuGengakuShinseishoEditor {

    private final HomonkaigoRiyoushaFutangakuGengakuShinseishoItem item;

    /**
     * コンストラクタです。
     *
     * @param item HomonkaigoRiyoushaFutangakuGengakuShinseishoItem
     */
    public HomonkaigoRiyoushaFutangakuGengakuShinseishoEditorImpl(HomonkaigoRiyoushaFutangakuGengakuShinseishoItem item) {
        this.item = item;
    }

    /**
     * 訪問介護利用者負担額減額申請書エディターです。
     *
     * @param source 訪問介護利用者負担額減額申請書
     * @return HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource edit(HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource source) {
        return editBody(source);
    }

    private HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource editBody(HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource source) {
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hokenshaNo = item.getHokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.seibetsu = item.getSeibetsu();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaYubinNo = item.getHihokenshaYubinNo();
        source.hihokenshaTelNo = item.getHihokenshaTelNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.tsuchiBun = item.getTsuchiBun();
        source.remban = new RString("1");
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
