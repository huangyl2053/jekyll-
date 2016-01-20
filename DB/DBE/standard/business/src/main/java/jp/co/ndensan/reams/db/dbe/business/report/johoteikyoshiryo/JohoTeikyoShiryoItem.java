/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定結果情報提供票（主治医）のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JohoTeikyoShiryoItem {

    private final RDate hakkoYMD;
    private final RString hokenshaName1;
    private final RString hokenshaName2;
    private final RString tsuchibun1;
    private final RString title;
    private final RString hihokenshaName;
    private final RString jusho;
    private final RDate infoNijiDate;
    private final RString ninteiKekka;
    private final RDate yokaigoNiteiKaishoYMD;
    private final RDate yokaigoNinteiShuryoYMD;
    private final RString shinsakaiIken;
    private final RString tsuchibun2;
    private final RString tsuchibun3;
    private final RString tsuchibun4;
    private final RString tsuchibun5;
    private final RString tsuchibun6;
    private final RString tsuchibun7;
    private final RString tsuchibun8;
    private final RString tsuchibun9;
    private final RString tsuchibun10;

    /**
     * インスタンスを生成します。
     *
     * @param hakkoYMD 発行日
     * @param hokenshaName1 保険者名称１
     * @param hokenshaName2 保険者名称２
     * @param title 帳票名
     * @param tsuchibun1 通知文１
     * @param hihokenshaName 氏名
     * @param jusho 住所
     * @param infoNijiDate 認定年月日
     * @param ninteiKekka 認定結果
     * @param yokaigoNiteiKaishoYMD 認定有効期間From
     * @param yokaigoNinteiShuryoYMD 認定有効期間To
     * @param shinsakaiIken 審査会意見
     * @param tsuchibun2 通知文２
     * @param tsuchibun3 通知文３
     * @param tsuchibun4 通知文４
     * @param tsuchibun5 通知文５
     * @param tsuchibun6 通知文６
     * @param tsuchibun7 通知文７
     * @param tsuchibun8 通知文８
     * @param tsuchibun9 通知文９
     * @param tsuchibun10 通知文１０
     */
    public JohoTeikyoShiryoItem(RDate hakkoYMD, RString hokenshaName1, RString hokenshaName2,RString title, 
            RString tsuchibun1, RString hihokenshaName, RString jusho, RDate infoNijiDate,
            RString ninteiKekka, RDate yokaigoNiteiKaishoYMD, RDate yokaigoNinteiShuryoYMD,
            RString shinsakaiIken, RString tsuchibun2, RString tsuchibun3, RString tsuchibun4,
            RString tsuchibun5, RString tsuchibun6, RString tsuchibun7, RString tsuchibun8,
            RString tsuchibun9, RString tsuchibun10) {
        this.hakkoYMD = hakkoYMD;
        this.hokenshaName1 = hokenshaName1;
        this.hokenshaName2 = hokenshaName2;
        this.title = title;
        this.tsuchibun1 = tsuchibun1;
        this.hihokenshaName = hihokenshaName;
        this.jusho = jusho;
        this.infoNijiDate = infoNijiDate;
        this.ninteiKekka = ninteiKekka;
        this.yokaigoNiteiKaishoYMD = yokaigoNiteiKaishoYMD;
        this.yokaigoNinteiShuryoYMD = yokaigoNinteiShuryoYMD;
        this.shinsakaiIken = shinsakaiIken;
        this.tsuchibun2 = tsuchibun2;
        this.tsuchibun3 = tsuchibun3;
        this.tsuchibun4 = tsuchibun4;
        this.tsuchibun5 = tsuchibun5;
        this.tsuchibun6 = tsuchibun6;
        this.tsuchibun7 = tsuchibun7;
        this.tsuchibun8 = tsuchibun8;
        this.tsuchibun9 = tsuchibun9;
        this.tsuchibun10 = tsuchibun10;
    }
}
