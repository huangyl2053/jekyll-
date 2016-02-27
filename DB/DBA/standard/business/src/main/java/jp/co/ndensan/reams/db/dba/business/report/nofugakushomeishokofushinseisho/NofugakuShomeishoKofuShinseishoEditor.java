/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoReportSource;

/**
 *
 * 介護保険料納付額証明書交付申請書Editorです。
 */
public class NofugakuShomeishoKofuShinseishoEditor implements INofugakuShomeishoKofuShinseishoEditor {

    private final NofugakuShomeishoKofuShinseishoItem joho;

    /**
     * コンストラクタです。
     *
     * @param joho 介護保険料納付額証明書交付申請書Itemです
     */
    public NofugakuShomeishoKofuShinseishoEditor(NofugakuShomeishoKofuShinseishoItem joho) {
        this.joho = joho;
    }

    /**
     * 介護保険料納付額証明書交付申請書editです。
     *
     * @param source 介護保険料納付額証明書交付申請書Source
     * @return 介護保険料納付額証明書交付申請書
     */
    @Override
    public NofugakuShomeishoKofuShinseishoReportSource edit(NofugakuShomeishoKofuShinseishoReportSource source) {
        return editBody(source);
    }

    private NofugakuShomeishoKofuShinseishoReportSource editBody(NofugakuShomeishoKofuShinseishoReportSource source) {
        source.tsuchiBun = joho.getTsuchiBun();
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hihokenshaName = joho.getHihokenshaName();
        source.birthYMD = joho.getBirthYMD();
        source.seibetsu = joho.getSeibetsu();
        source.hihokenshaYubinNo = joho.getHihokenshaYubinNo();
        source.hihokenshaTelNo = joho.getHihokenshaTelNo();
        source.hihokenJusho = joho.getHihokenJusho();
        source.remban = joho.getRemban();
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        return source;
    }

}
