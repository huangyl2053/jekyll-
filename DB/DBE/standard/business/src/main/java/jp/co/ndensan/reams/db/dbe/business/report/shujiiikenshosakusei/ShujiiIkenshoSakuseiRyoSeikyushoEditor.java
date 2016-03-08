/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 主治医意見書作成料請求書Editorです。
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoEditor implements IShujiiIkenshoSakuseiRyoSeikyushoEditor {

    private final ShujiiIkenshoSakuseiRyoSeikyushoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkenshoSakuseiRyoSeikyushoItem}
     */
    protected ShujiiIkenshoSakuseiRyoSeikyushoEditor(ShujiiIkenshoSakuseiRyoSeikyushoItem item) {
        this.item = item;
    }

    /**
     * 主治医意見書作成料請求書の編集処理です。
     *
     * @param source 主治医意見書作成料請求書Sourceクラス
     * @return ShujiiIkenshoSakuseiRyoSeikyushoReportSource 主治医意見書作成料請求書Sourceクラス
     */
    @Override
    public ShujiiIkenshoSakuseiRyoSeikyushoReportSource edit(ShujiiIkenshoSakuseiRyoSeikyushoReportSource source) {
        source.gengo = item.getGengo();
        source.atesakiHokenshaName = item.getAtesakiHokenshaName();
        source.shinkiZaitakuKingaku = item.getShinkiZaitakuKingaku();
        source.shinkiShisetsuKingaku = item.getShinkiShisetsuKingaku();
        source.keizokuZaitakuKingaku = item.getKeizokuZaitakuKingaku();
        source.keizokuShisetsuKingaku = item.getKeizokuShisetsuKingaku();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.inkanMark = new RString("印");
        source.hihokenshaName = item.getHihokenshaName();
        source.birthYMD = item.getBirthYMD();
        source.seibetsu = item.getSeibetsu();
// TODO QA629 #75594 「意見書作成料種別_在宅・施設」と「意見書作成料種別_新規・継続」はフィールドではないため、ReportSourceに項目名は生成できない
//        source.ikenshosyubetu1 = item.getIkenshosyubetu1();
//        source.ikenshosyubetu2 = item.getIkenshosyubetu2();
        source.ikenshoSakuseiRyo1 = item.getIkenshoSakuseiRyo1();
        source.ikenshoSakuseiRyo2 = item.getIkenshoSakuseiRyo2();
        source.ikenshoSakuseiRyo3 = item.getIkenshoSakuseiRyo3();
        source.ikenshoSakuseiRyo4 = item.getIkenshoSakuseiRyo4();
        source.seikyugakuIkenshoSakuseiRyo1 = item.getSeikyugakuIkenshoSakuseiRyo1();
        source.seikyugakuIkenshoSakuseiRyo2 = item.getSeikyugakuIkenshoSakuseiRyo2();
        source.seikyugakuIkenshoSakuseiRyo3 = item.getSeikyugakuIkenshoSakuseiRyo3();
        source.seikyugakuIkenshoSakuseiRyo4 = item.getSeikyugakuIkenshoSakuseiRyo4();
        source.iryokikanName = item.getSeikyuIryokikanName();
        source.iryokikanDaihyosha = item.getSeikyuIryokikanDaihyoName();
        source.yubinNo = item.getSeikyuIryokikanYubinNo();
        source.iryokikanJusho = item.getSeikyuIryokikanJusho();
        source.iryokikanTel = item.getSeikyuIryokikanTel();
        source.ikenshoSakuseiYMD = RString.EMPTY;
        return source;
    }
}
