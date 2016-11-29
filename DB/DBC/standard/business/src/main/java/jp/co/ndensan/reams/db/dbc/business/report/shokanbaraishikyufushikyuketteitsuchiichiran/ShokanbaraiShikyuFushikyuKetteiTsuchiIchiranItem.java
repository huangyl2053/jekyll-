/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給（不支給）決定通知一覧表覧表のITEMです。
 *
 * @reamsid_L DBC-1000-150 hezhenzhen
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem {

    private RString printTimeStamp;
    private RString hokenshaNo;
    private RString hokenshaName;
    private RString shutsuryokujun1;
    private RString shutsuryokujun2;
    private RString shutsuryokujun3;
    private RString shutsuryokujun4;
    private RString shutsuryokujun5;
    private RString kaipage1;
    private RString kaipage2;
    private RString kaipage3;
    private RString kaipage4;
    private RString kaipage5;
    private RString renban;
    private RString seiriNo;
    private RString keteiTsuchiNo;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString jusho;
    private RString yubinBango;
    private RString teikyo;
    private RString yoKaigodo;
    private RString ninteiKaishibi;
    private RString ninteiShuryobi;
    private RString uketsukeYMD;
    private RString keteiYMD;
    private RString honjinShiharaigaku;
    private RString shikyugaku;
    private RString yoshikigotoKingaku;
    private RString kingaku;
    private RString tuika;
    private RString shurui;
    private RString shurui1;
    private RString shurui2;
    private RString keteiKubun;
    private RString shiharaiHoho;

    private RString choikiCode;
    private RString gyoseikuCode;
    private RString kanaMeisho;
    private RString shoKisaiHokenshaNo;
    private RString ketteiTsuchiNo;
    private RString shinseishaKubun;
    private boolean breakKeyFlg;

    /**
     * インスタンスを生成します。
     *
     */
    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem() {
    }

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
     * @param yoshikigotoKingaku 様式名称
     * @param kingaku 様式毎の金額
     * @param tuika 追加
     * @param shurui 種類
     * @param shurui1 種類
     * @param shurui2 種類
     * @param keteiKubun 支給（不支給）決定区分
     * @param shiharaiHoho 支払方法
     * @param choikiCode 町域コード
     * @param gyoseikuCode 行政区コード
     * @param kanaMeisho 氏名５０音カナ
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param ketteiTsuchiNo 決定通知番号
     * @param shinseishaKubun 申請者区分
     */
    public ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem(RString printTimeStamp,
            RString hokenshaNo, RString hokenshaName, RString shutsuryokujun1, RString shutsuryokujun2,
            RString shutsuryokujun3, RString shutsuryokujun4, RString shutsuryokujun5, RString kaipage1,
            RString kaipage2, RString kaipage3, RString kaipage4, RString kaipage5, RString renban, RString seiriNo,
            RString keteiTsuchiNo, RString hihokenshaNo, RString hihokenshaName, RString jusho, RString yubinBango,
            RString teikyo, RString yoKaigodo, RString ninteiKaishibi, RString ninteiShuryobi, RString uketsukeYMD,
            RString keteiYMD, RString honjinShiharaigaku, RString shikyugaku, RString yoshikigotoKingaku, RString kingaku, RString tuika,
            RString shurui, RString shurui1, RString shurui2, RString keteiKubun, 
            RString shiharaiHoho, RString choikiCode, RString gyoseikuCode, RString kanaMeisho,
            RString shoKisaiHokenshaNo, RString ketteiTsuchiNo, RString shinseishaKubun) {
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
        this.kingaku = kingaku;
        this.tuika = tuika;
        this.shurui = shurui;
        this.shurui1 = shurui1;
        this.shurui2 = shurui2;
        this.keteiKubun = keteiKubun;
        this.shiharaiHoho = shiharaiHoho;
        this.choikiCode = choikiCode;
        this.gyoseikuCode = gyoseikuCode;
        this.kanaMeisho = kanaMeisho;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.ketteiTsuchiNo = ketteiTsuchiNo;
        this.shinseishaKubun = shinseishaKubun;
    }
}
