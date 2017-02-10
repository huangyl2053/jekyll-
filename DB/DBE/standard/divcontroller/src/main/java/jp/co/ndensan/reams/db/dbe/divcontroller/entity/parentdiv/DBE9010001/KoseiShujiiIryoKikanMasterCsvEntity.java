/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0240-010 dongyabin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiShujiiIryoKikanMasterCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private final RString shichosonCode;
    @CsvField(order = 2, name = "市町村")
    private final RString shichosonMeisho;
    @CsvField(order = 3, name = "主治医医療機関コード")
    private final RString shujiiIryokikanCode;
    @CsvField(order = 4, name = "医療機関コード")
    private final RString iryokikanCode;
    @CsvField(order = 5, name = "医療機関名称")
    private final RString iryoKikanMeisho;
    @CsvField(order = 6, name = "医療機関名称カナ")
    private final RString iryoKikanMeishoKana;
    @CsvField(order = 7, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 8, name = "住所")
    private final RString jusho;
    @CsvField(order = 9, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 10, name = "FAX番号")
    private final RString faxNo;
    @CsvField(order = 11, name = "代表者名")
    private final RString daihyoshaName;
    @CsvField(order = 12, name = "代表者名カナ")
    private final RString daihyoshaNameKana;
    @CsvField(order = 13, name = "機関の状況")
    private final RString jokyoFlag;
    @CsvField(order = 14, name = "金融機関コード")
    private final RString kinyuKikanCode;
    @CsvField(order = 15, name = "金融機関")
    private final RString kinyuKikan;
    @CsvField(order = 16, name = "支店コード")
    private final RString kinyuKikanShitenCode;
    @CsvField(order = 17, name = "支店")
    private final RString kinyuKikanShiten;
    @CsvField(order = 18, name = "預金種別コード")
    private final RString yokinShubetsuCode;
    @CsvField(order = 19, name = "預金種別")
    private final RString yokinShubetsu;
    @CsvField(order = 20, name = "口座番号")
    private final RString kozaNo;
    @CsvField(order = 21, name = "口座名義人")
    private final RString kozaMeigininKana;
    @CsvField(order = 22, name = "漢字名義人")
    private final RString kozaMeiginin;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村
     * @param shujiiIryokikanCode 主治医医療機関コード
     * @param iryokikanCode 医療機関コード
     * @param iryoKikanMeisho 医療機関名称
     * @param iryoKikanMeishoKana 医療機関名称カナ
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo FAX番号
     * @param daihyoshaName 代表者名
     * @param daihyoshaNameKana 代表者名カナ
     * @param jokyoFlag 状況フラグ
     * @param kinyuKikanCode 金融機関コード
     * @param kinyuKikan 金融機関名称
     * @param kinyuKikanShitenCode 支店コード
     * @param kinyuKikanShiten 支店
     * @param yokinShubetsuCode 預金種別コード
     * @param yokinShubetsu 預金種別
     * @param kozaNo 口座番号
     * @param kozaMeigininKana 口座名義人
     * @param kozaMeiginin 漢字名義人
     */
    public KoseiShujiiIryoKikanMasterCsvEntity(
            RString shichosonCode,
            RString shichosonMeisho,
            RString shujiiIryokikanCode,
            RString iryokikanCode,
            RString iryoKikanMeisho,
            RString iryoKikanMeishoKana,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo,
            RString daihyoshaName,
            RString daihyoshaNameKana,
            RString jokyoFlag,
            RString kinyuKikanCode,
            RString kinyuKikan,
            RString kinyuKikanShitenCode,
            RString kinyuKikanShiten,
            RString yokinShubetsuCode,
            RString yokinShubetsu,
            RString kozaNo,
            RString kozaMeigininKana,
            RString kozaMeiginin
    ) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
        this.iryokikanCode = iryokikanCode;
        this.iryoKikanMeisho = iryoKikanMeisho;
        this.iryoKikanMeishoKana = iryoKikanMeishoKana;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.daihyoshaName = daihyoshaName;
        this.daihyoshaNameKana = daihyoshaNameKana;
        this.jokyoFlag = jokyoFlag;
        this.kinyuKikanCode = kinyuKikanCode;
        this.kinyuKikan = kinyuKikan;
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
        this.kinyuKikanShiten = kinyuKikanShiten;
        this.yokinShubetsuCode = yokinShubetsuCode;
        this.yokinShubetsu = yokinShubetsu;
        this.kozaNo = kozaNo;
        this.kozaMeigininKana = kozaMeigininKana;
        this.kozaMeiginin = kozaMeiginin;
    }
}
