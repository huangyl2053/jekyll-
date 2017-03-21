/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei;

import jp.co.ndensan.reams.db.dbz.entity.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 主治医意見書作成料請求書Editorです。
 *
 * @reamsid_L DBE-0050-040 sunhaidi
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
     * @return ShujiiIkenshoSakuseiRyoSeikyushoReportSource
     * 主治医意見書作成料請求書Sourceクラス
     */
    @Override
    public ShujiiIkenshoSakuseiRyoSeikyushoReportSource edit(ShujiiIkenshoSakuseiRyoSeikyushoReportSource source) {
        if (item.getGengo() != null) {
            source.gengo = new RDate(item.getGengo().toString()).wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        source.atesakiHokenshaName = item.getAtesakiHokenshaName();
        source.shinkiZaitakuKingaku = new Decimal(item.getShinkiZaitakuKingaku().toString());
        source.shinkiShisetsuKingaku = new Decimal(item.getShinkiShisetsuKingaku().toString());
        source.keizokuZaitakuKingaku = new Decimal(item.getKeizokuZaitakuKingaku().toString());
        source.keizokuShisetsuKingaku = new Decimal(item.getKeizokuShisetsuKingaku().toString());
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
        source.shubetsuZaitaku = item.getShubetsuZaitaku();
        source.shubetsuShisetsu = item.getShubetsuShisetsu();
        source.shubetsuShinki = item.getShubetsuShinki();
        source.shubetsuKeizoku = item.getShubetsuKeizoku();
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
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.shokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), getHokenshaNo());
        return source;
    }

    private RString getHokenshaNo() {
        RStringBuilder hokenshaNo = new RStringBuilder();
        hokenshaNo.append(item.getHihokenshaNo1());
        hokenshaNo.append(item.getHihokenshaNo2());
        hokenshaNo.append(item.getHihokenshaNo3());
        hokenshaNo.append(item.getHihokenshaNo4());
        hokenshaNo.append(item.getHihokenshaNo5());
        hokenshaNo.append(item.getHihokenshaNo6());
        hokenshaNo.append(item.getHihokenshaNo7());
        hokenshaNo.append(item.getHihokenshaNo8());
        hokenshaNo.append(item.getHihokenshaNo9());
        hokenshaNo.append(item.getHihokenshaNo10());
        return hokenshaNo.toRString();
    }

}
