/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払支給（不支給）決定通知一覧表覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem {

    private final RString printTimeStamp;
    private final RString hokenshaNo;
    private final RString hokenshaName;
    private final RString shutsuryokujun1;
    private final RString shutsuryokujun2;
    private final RString shutsuryokujun3;
    private final RString shutsuryokujun4;
    private final RString shutsuryokujun5;
    private final RString kaipage1;
    private final RString kaipage2;
    private final RString kaipage3;
    private final RString kaipage4;
    private final RString kaipage5;
    private final RString renban;
    private final RString seiriNo;
    private final RString keteiTsuchiNo;
    private final RString hihokenshaNo;
    private final RString hihokenshaName;
    private final RString jusho;
    private final RString yubinBango;
    private final RString teikyo;
    private final RString yoKaigodo;
    private final RString ninteiKaishibi;
    private final RString ninteiShuryobi;
    private final RString uketsukeYMD;
    private final RString keteiYMD;
    private final RString honjinShiharaigaku;
    private final RString shikyugaku;
    private final RString yoshikigotoKingaku;
    private final RString tuika;
    private final RString shurui;
    private final RString keteiKubun;
    private final RString shiharaiHoho;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp 作成日時
     * @param hokenshaNo 市町村コード
     * @param hokenshaName 市町村名称
     * @param shutsuryokujun1 並び順１
     * @param shutsuryokujun2 並び順２
     * @param shutsuryokujun3 並び順３
     * @param shutsuryokujun4 並び順４
     * @param shutsuryokujun5 並び順５
     * @param kaipage1 改頁１
     * @param kaipage2 改頁２
     * @param kaipage3 改頁３
     * @param kaipage4 改頁４
     * @param kaipage5 改頁５
     * @param renban 帳票連番
     * @param seiriNo 整理番号
     * @param keteiTsuchiNo 決定通知No
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaName 被保険者氏名
     * @param jusho 住所
     * @param yubinBango 郵便番号
     * @param teikyo 提供年月
     * @param yoKaigodo 要介護度
     * @param ninteiKaishibi 認定開始日
     * @param ninteiShuryobi 認定終了日
     * @param uketsukeYMD 受付年月日
     * @param keteiYMD 決定年月日
     * @param honjinShiharaigaku 本人支払額
     * @param shikyugaku 支給額
     * @param yoshikigotoKingaku 様式毎の金額
     * @param tuika 追加
     * @param shurui 種類
     * @param keteiKubun 支給（不支給）決定区分
     * @param shiharaiHoho 支払方法
     */
    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem(RString printTimeStamp,
            RString hokenshaNo, RString hokenshaName, RString shutsuryokujun1, RString shutsuryokujun2,
            RString shutsuryokujun3, RString shutsuryokujun4, RString shutsuryokujun5, RString kaipage1,
            RString kaipage2, RString kaipage3, RString kaipage4, RString kaipage5, RString renban, RString seiriNo,
            RString keteiTsuchiNo, RString hihokenshaNo, RString hihokenshaName, RString jusho, RString yubinBango,
            RString teikyo, RString yoKaigodo, RString ninteiKaishibi, RString ninteiShuryobi, RString uketsukeYMD,
            RString keteiYMD, RString honjinShiharaigaku, RString shikyugaku, RString yoshikigotoKingaku, RString tuika,
            RString shurui, RString keteiKubun, RString shiharaiHoho) {
        this.printTimeStamp = printTimeStamp;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaName = hokenshaName;
        this.shutsuryokujun1 = shutsuryokujun1;
        this.shutsuryokujun2 = shutsuryokujun2;
        this.shutsuryokujun3 = shutsuryokujun3;
        this.shutsuryokujun4 = shutsuryokujun4;
        this.shutsuryokujun5 = shutsuryokujun5;
        this.kaipage1 = kaipage1;
        this.kaipage2 = kaipage2;
        this.kaipage3 = kaipage3;
        this.kaipage4 = kaipage4;
        this.kaipage5 = kaipage5;
        this.renban = renban;
        this.seiriNo = seiriNo;
        this.keteiTsuchiNo = keteiTsuchiNo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.jusho = jusho;
        this.yubinBango = yubinBango;
        this.teikyo = teikyo;
        this.yoKaigodo = yoKaigodo;
        this.ninteiKaishibi = ninteiKaishibi;
        this.ninteiShuryobi = ninteiShuryobi;
        this.uketsukeYMD = uketsukeYMD;
        this.keteiYMD = keteiYMD;
        this.honjinShiharaigaku = honjinShiharaigaku;
        this.shikyugaku = shikyugaku;
        this.yoshikigotoKingaku = yoshikigotoKingaku;
        this.tuika = tuika;
        this.shurui = shurui;
        this.keteiKubun = keteiKubun;
        this.shiharaiHoho = shiharaiHoho;
    }

}
