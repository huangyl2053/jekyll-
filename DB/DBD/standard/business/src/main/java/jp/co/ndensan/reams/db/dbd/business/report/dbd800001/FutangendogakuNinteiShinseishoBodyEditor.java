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

    private static final int NUM_40 = 40;
    private static final int NUM_76 = 76;
    private static final int NUM_80 = 80;
    private static final int NUM_152 = 152;
    private static final int NUM_228 = 228;
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
        source.hiho_name_kana_1 = item.getHihokenshaNameKana().substringReturnAsPossible(0, NUM_40);
        if (item.getHihokenshaNameKana().length() > NUM_40) {
            source.hiho_name_kana_2 = item.getHihokenshaNameKana().substringReturnAsPossible(NUM_40, NUM_80);
        }
        source.hiho_name_1 = item.getHihokenshaName().substringReturnAsPossible(0, NUM_40);
        if (item.getHihokenshaName().length() > NUM_40) {
            source.hiho_name_2 = item.getHihokenshaName().substringReturnAsPossible(NUM_40, NUM_80);
        }

        source.seibetsu = item.getSeibetsu();
        source.umare_ymd = item.getBirthYMD();
        source.hiho_tel_no = item.getHihokenshaTelNo();
        source.yubin_no = item.getHihokenshaYubinNo();

        source.hiho_jyusho_1 = item.getHihokenJusho().substringReturnAsPossible(0, NUM_76);
        if (item.getHihokenJusho().length() > NUM_76) {
            source.hiho_jyusho_2 = item.getHihokenJusho().substringReturnAsPossible(NUM_76, NUM_152);
        } else if (item.getHihokenJusho().length() > NUM_152) {
            source.hiho_jyusho_3 = item.getHihokenJusho().substringReturnAsPossible(NUM_152, NUM_228);
        }
        source.PageCnt = new RString("1");
        source.daihyo = item.getNinshoshaYakushokuMei();
        source.hiho_no = item.getHihokenshaNo();
        source.shisetsu_yubin_no = item.getSisetuYubinNo();
        source.shisetsu_tel_no = item.getSisetuTelNo();
        source.shisetsu_jusho1 = item.getSisetuJusho().substringReturnAsPossible(0, NUM_76);
        if (item.getSisetuJusho().length() > NUM_76) {
            source.shisetsu_jusho2 = item.getSisetuJusho().substringReturnAsPossible(NUM_76, NUM_152);
        }
        source.shisetsu_name_1 = item.getSisetuName().substringReturnAsPossible(0, NUM_76);
        if (item.getSisetuName().length() > NUM_76) {
            source.shisetsu_name_2 = item.getSisetuName().substringReturnAsPossible(NUM_76, NUM_152);
        }
        return source;
    }
}
