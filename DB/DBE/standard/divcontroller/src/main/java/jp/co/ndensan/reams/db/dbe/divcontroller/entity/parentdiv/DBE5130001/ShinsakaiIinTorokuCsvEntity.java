/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員登録出力用CSVEntityクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiIinTorokuCsvEntity {

    @CsvField(order = 10, name = "介護認定審査会委員コード")
    private final RString shinsakaiIinCode;
    @CsvField(order = 20, name = "介護認定審査会委員氏名")
    private final RString shisakaiIinShimei;
    @CsvField(order = 30, name = "介護認定審査会委員氏名カナ")
    private final RString shinsakaiIinShimeiKana;
    @CsvField(order = 40, name = "介護認定審査員資格コード")
    private final RString shinsainShikakuCode;
    @CsvField(order = 50, name = "担当地区コード")
    private final RString tantoChikuCode;
    @CsvField(order = 60, name = "介護認定審査会委員開始年月日")
    private final RString shinsakaiIinStYMD;
    @CsvField(order = 70, name = "介護認定審査会委員終了年月日")
    private final RString shinsakaiIinEdYMD;
    @CsvField(order = 80, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 90, name = "住所")
    private final RString jusho;
    @CsvField(order = 100, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 110, name = "ＦＡＸ番号")
    private final RString faxNo;
    @CsvField(order = 120, name = "廃止年月日")
    private final RString haishiYMD;
    @CsvField(order = 130, name = "金融機関コード")
    private final RString kinyuKikanCode;
    @CsvField(order = 140, name = "支店コード")
    private final RString kinyuKikanShitenCode;
    @CsvField(order = 150, name = "預金種別")
    private final RString yokinShubetsu;
    @CsvField(order = 160, name = "口座番号")
    private final RString kozaNo;
    @CsvField(order = 170, name = "口座名義人")
    private final RString kozaMeigininKana;
    @CsvField(order = 180, name = "漢字名義人")
    private final RString kozaMeiginin;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiIinCode 介護認定審査会委員コード
     * @param shisakaiIinShimei 介護認定審査会委員氏名
     * @param shinsakaiIinShimeiKana 介護認定審査会委員氏名カナ
     * @param shinsainShikakuCode 介護認定審査員資格コード
     * @param tantoChikuCode 担当地区コード
     * @param shinsakaiIinStYMD 介護認定審査会委員開始年月日
     * @param shinsakaiIinEdYMD 介護認定審査会委員終了年月日
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo ＦＡＸ番号
     * @param haishiYMD 廃止年月日
     * @param kinyuKikanCode 金融機関コード
     * @param kinyuKikanShitenCode 支店コード
     * @param yokinShubetsu 預金種別
     * @param kozaNo 口座番号
     * @param kozaMeigininKana 口座名義人
     * @param kozaMeiginin 漢字名義人
     */
    public ShinsakaiIinTorokuCsvEntity(
            RString shinsakaiIinCode,
            RString shisakaiIinShimei,
            RString shinsakaiIinShimeiKana,
            RString shinsainShikakuCode,
            RString tantoChikuCode,
            RString shinsakaiIinStYMD,
            RString shinsakaiIinEdYMD,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo,
            RString haishiYMD,
            RString kinyuKikanCode,
            RString kinyuKikanShitenCode,
            RString yokinShubetsu,
            RString kozaNo,
            RString kozaMeigininKana,
            RString kozaMeiginin) {
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shisakaiIinShimei = shisakaiIinShimei;
        this.shinsakaiIinShimeiKana = shinsakaiIinShimeiKana;
        this.shinsainShikakuCode = shinsainShikakuCode;
        this.tantoChikuCode = tantoChikuCode;
        this.shinsakaiIinStYMD = shinsakaiIinStYMD;
        this.shinsakaiIinEdYMD = shinsakaiIinEdYMD;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.haishiYMD = haishiYMD;
        this.kinyuKikanCode = kinyuKikanCode;
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
        this.yokinShubetsu = yokinShubetsu;
        this.kozaNo = kozaNo;
        this.kozaMeigininKana = kozaMeigininKana;
        this.kozaMeiginin = kozaMeiginin;
    }
}
