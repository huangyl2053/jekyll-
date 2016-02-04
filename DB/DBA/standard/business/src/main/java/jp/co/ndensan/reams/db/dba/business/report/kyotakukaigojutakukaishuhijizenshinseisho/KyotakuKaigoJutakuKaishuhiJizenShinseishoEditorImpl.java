/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyotakukaigojutakukaishuhijizenshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyotakukaigojutakukaishuhijizenshinseisho.JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource;

/**
 * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書エディターです。
 *
 */
public class KyotakuKaigoJutakuKaishuhiJizenShinseishoEditorImpl implements IKyotakuKaigoJutakuKaishuhiJizenShinseishoEditor {

    private final KyotakuKaigoJutakuKaishuhiJizenShinseishoItem item;

    /**
     * コンストラクタです。
     *
     * @param item KyotakuKaigoJutakuKaishuhiJizenShinseishoItem
     */
    public KyotakuKaigoJutakuKaishuhiJizenShinseishoEditorImpl(KyotakuKaigoJutakuKaishuhiJizenShinseishoItem item) {
        this.item = item;
    }

    /**
     * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書エディターです。
     *
     * @param source 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書
     * @return JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource
     */
    @Override
    public JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource edit(JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource source) {
        return editBody(source);
    }

    private JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource editBody(JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource source) {
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hokenshaNo = item.getHokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.hihokenshaNo = item.getHokenshaNo();
        source.birthYMD = item.getBirthYMD();
        source.yubinNo = item.getYubinNo();
        source.telNo = item.getTelNo();
        source.hihokenJusho = item.getHihokenJusho();
        source.shiseiBun = item.getShiseiBun();
        source.douiBun = item.getDouiBun();
        source.remban = item.getRemban();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
