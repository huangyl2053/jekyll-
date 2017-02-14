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
    @CsvField(order = 20, name = "介護認定審査会委員開始年月日")
    private final RString shinsakaiIinStYMD;
    @CsvField(order = 30, name = "介護認定審査会委員終了年月日")
    private final RString shinsakaiIinEdYMD;
    @CsvField(order = 40, name = "介護認定審査会委員氏名")
    private final RString shisakaiIinShimei;
    @CsvField(order = 50, name = "介護認定審査会委員氏名カナ")
    private final RString shinsakaiIinShimeiKana;
    @CsvField(order = 60, name = "性別")
    private final RString seibetsu;
    @CsvField(order = 70, name = "生年月日")
    private final RString BarthYMD;
    @CsvField(order = 80, name = "介護認定審査員資格コード")
    private final RString shinsainShikakuCode;
    @CsvField(order = 90, name = "介護認定審査員資格")
    private final RString shinsainShikaku;
    @CsvField(order = 100, name = "状況")
    private final RString jokyo;
    @CsvField(order = 110, name = "備考")
    private final RString biko;
    @CsvField(order = 120, name = "金融機関コード")
    private final RString kinyuKikanCode;
    @CsvField(order = 130, name = "金融機関名")
    private final RString kinyuKikanMeisho;
    @CsvField(order = 140, name = "支店コード")
    private final RString kinyuKikanShitenCode;
    @CsvField(order = 150, name = "支店名")
    private final RString kinyuKikanShitenMeisho;
    @CsvField(order = 160, name = "預金種別")
    private final RString yokinShubetsu;
    @CsvField(order = 170, name = "口座番号")
    private final RString kozaNo;
    @CsvField(order = 180, name = "口座名義人")
    private final RString kozaMeigininKana;
    @CsvField(order = 190, name = "漢字名義人")
    private final RString kozaMeiginin;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiIinCode 介護認定審査会委員コード
     * @param shinsakaiIinStYMD 介護認定審査会委員開始年月日
     * @param shinsakaiIinEdYMD 介護認定審査会委員終了年月日
     * @param shisakaiIinShimei 介護認定審査会委員氏名
     * @param shinsakaiIinShimeiKana 介護認定審査会委員氏名カナ
     * @param seibetsu 性別
     * @param BarthYMD 生年月日
     * @param shinsainShikakuCode 介護認定審査員資格コード
     * @param shinsainShikaku 介護認定審査員資格
     * @param jokyo 状況
     * @param biko 備考
     * @param kinyuKikanCode 金融機関コード
     * @param kinyuKikanMeisho 金融機関名
     * @param kinyuKikanShitenCode 支店コード
     * @param kinyuKikanShitenMeisho 支店名
     * @param yokinShubetsu 預金種別
     * @param kozaNo 口座番号
     * @param kozaMeigininKana 口座名義人
     * @param kozaMeiginin 漢字名義人
     */
    public ShinsakaiIinTorokuCsvEntity(
            RString shinsakaiIinCode,
            RString shinsakaiIinStYMD,
            RString shinsakaiIinEdYMD,
            RString shisakaiIinShimei,
            RString shinsakaiIinShimeiKana,
            RString seibetsu,
            RString BarthYMD,
            RString shinsainShikakuCode,
            RString shinsainShikaku,
            RString jokyo,
            RString biko,
            RString kinyuKikanCode,
            RString kinyuKikanMeisho,
            RString kinyuKikanShitenCode,
            RString kinyuKikanShitenMeisho,
            RString yokinShubetsu,
            RString kozaNo,
            RString kozaMeigininKana,
            RString kozaMeiginin) {
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shinsakaiIinStYMD = shinsakaiIinStYMD;
        this.shinsakaiIinEdYMD = shinsakaiIinEdYMD;
        this.shisakaiIinShimei = shisakaiIinShimei;
        this.shinsakaiIinShimeiKana = shinsakaiIinShimeiKana;
        this.seibetsu = seibetsu;
        this.BarthYMD = BarthYMD;
        this.shinsainShikakuCode = shinsainShikakuCode;
        this.shinsainShikaku = shinsainShikaku;
        this.jokyo = jokyo;
        this.biko = biko;
        this.kinyuKikanCode = kinyuKikanCode;
        this.kinyuKikanMeisho = kinyuKikanMeisho;
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
        this.kinyuKikanShitenMeisho = kinyuKikanShitenMeisho;
        this.yokinShubetsu = yokinShubetsu;
        this.kozaNo = kozaNo;
        this.kozaMeigininKana = kozaMeigininKana;
        this.kozaMeiginin = kozaMeiginin;
    }
}
