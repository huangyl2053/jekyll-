/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険受給資格証明書交付申請書のEditorです。
 */
    public class JukyuShikakuShomeishokoufuShinseishoEditor implements IJukyuShikakuShomeishokoufuShinseishoEditor {
    
    private final JukyuShikakuShomeishokoufuShinseishoItem joho;
    
    /**
     * コンストラクタです。
     * @param joho 介護保険受給資格証明書交付申請書のEntityです
     */
    public JukyuShikakuShomeishokoufuShinseishoEditor(JukyuShikakuShomeishokoufuShinseishoItem joho) {
        this.joho = joho;
    }

    /**
     * 介護保険受給資格証明書交付申請書のedit処理です。
     * @param source 介護保険受給資格証明書交付申請書の帳票項目
     * @return 介護保険受給資格証明書交付申請書
     */
    @Override
    public JukyuShikakuShomeishokoufuShinseishoReportSource edit(JukyuShikakuShomeishokoufuShinseishoReportSource source) {
        return editBody(source);
    }
    
    private JukyuShikakuShomeishokoufuShinseishoReportSource editBody(JukyuShikakuShomeishokoufuShinseishoReportSource source) {
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hihokenshaName = joho.getHihokenshaName();
        source.birthYMD = joho.getBirthYMD();
        source.seibetsuMan = joho.getSeibetsu();
        source.hihokenshaYubinNo = joho.getHihokenshaYubinNo();
        source.hihokenshaTelNo = joho.getHihokenshaTelNo();
        source.hihokenJusho = joho.getHihokenJusho();
        source.tenshutsuMaeYubinNo = joho.getTenshutsuMaeYubinNo();
        source.tenshutsuMaeTelNo = joho.getTenshutsuMaeTelNo();
        source.tenshutsuMaeJusho = joho.getTenshutsuMaeJusho();
        source.genjushoYubinNo = joho.getGenjushoYubinNo();
        source.genjushoTelNo = joho.getGenjushoTelNo();
        source.genjusho = joho.getGenjusho();
        source.remban = new RString("1");
        return source;
    }
    
}
