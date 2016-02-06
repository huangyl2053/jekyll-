/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufugengakumenjyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyufugengakumenjyoshinseisho.KyufugengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付額減額免除申請書Editorです。
 */
public class KyufugengakuMenjyoShinseishoEditor implements IKyufugengakuMenjyoShinseishoEditor {

    private final KyufugengakuMenjyoShinseishoItem joho;

    /**
     * コンストラクタです。
     *
     * @param joho 給付額減額免除申請書Itemです
     */
    public KyufugengakuMenjyoShinseishoEditor(KyufugengakuMenjyoShinseishoItem joho) {
        this.joho = joho;
    }

    /**
     * 給付額減額免除申請書editです。
     *
     * @param source 給付額減額免除申請書Source
     * @return 給付額減額免除申請書
     */
    @Override
    public KyufugengakuMenjyoShinseishoReportSource edit(KyufugengakuMenjyoShinseishoReportSource source) {
        return editBody(source);
    }

    private KyufugengakuMenjyoShinseishoReportSource editBody(KyufugengakuMenjyoShinseishoReportSource source) {
        source.hihokenshaNo = joho.getHihokenshaNo();
        source.hihokenshaNameKana = joho.getHihokenshaNameKana();
        source.hihokenshaName = joho.getHihokenshaName();
        source.seibetsu = joho.getSeibetsu();
        source.birthYMD = joho.getBirthYMD();
        source.hihokenshaYubinNo = joho.getHihokenshaYubinNo();
        source.hihokenshaTelNo = joho.getHihokenshaTelNo();
        source.hihokenJusho = joho.getHihokenJusho();
        // TODO 内部：635　Redmine： （連番の設定を不明です。）
        source.remban = new RString("0001");
        source.ninshoshaYakushokuMei = joho.getNinshoshaYakushokuMei();
        return source;
    }

}
