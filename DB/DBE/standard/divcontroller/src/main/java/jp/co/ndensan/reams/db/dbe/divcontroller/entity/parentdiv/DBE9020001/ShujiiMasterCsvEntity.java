/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0250-010 suguangjun
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiMasterCsvEntity {

    @CsvField(order = 10, name = "市町村コード")
    private final RString shichosonCode;
    @CsvField(order = 20, name = "市町村")
    private final RString shichosonMeisho;
    @CsvField(order = 30, name = "主治医コード")
    private final RString shujiiCode;
    @CsvField(order = 40, name = "主治医氏名")
    private final RString shujiiShimei;
    @CsvField(order = 50, name = "主治医カナ")
    private final RString shujiiKanaShimei;
    @CsvField(order = 60, name = "主治医医療機関コード")
    private final RString shujiiIryoKikanCode;
    @CsvField(order = 70, name = "主治医医療機関名称")
    private final RString shujiiIryoKikan;
    @CsvField(order = 80, name = "性別コード")
    private final RString seibetsuCode;
    @CsvField(order = 90, name = "性別")
    private final RString seibetsu;
    @CsvField(order = 100, name = "診療科")
    private final RString shinryoka;
    @CsvField(order = 110, name = "指定医")
    private final RString shiteii;
    @CsvField(order = 120, name = "主治医の状況")
    private final RString jokyoFlag;
    @CsvField(order = 130, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 140, name = "住所")
    private final RString jusho;
    @CsvField(order = 150, name = "電話番号")
    private final RString telNo;
    @CsvField(order = 160, name = "ＦＡＸ番号")
    private final RString faxNo;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode 市町村コード
     * @param shichosonMeisho 市町村
     * @param shujiiCode 主治医コード
     * @param shujiiShimei 主治医氏名
     * @param shujiiKanaShimei 主治医カナ
     * @param shujiiIryoKikanCode 主治医医療機関コード
     * @param shujiiIryoKikan 主治医医療機関名称
     * @param seibetsuCode 性別コード
     * @param seibetsu 性別
     * @param shinryoka 診療科
     * @param jokyoFlag 状況フラグ
     * @param shiteii 指定医
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo ＦＡＸ番号
     */
    public ShujiiMasterCsvEntity(
            RString shichosonCode,
            RString shichosonMeisho,
            RString shujiiCode,
            RString shujiiShimei,
            RString shujiiKanaShimei,
            RString shujiiIryoKikanCode,
            RString shujiiIryoKikan,
            RString seibetsuCode,
            RString seibetsu,
            RString shinryoka,
            RString shiteii,
            RString jokyoFlag,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.shujiiCode = shujiiCode;
        this.shujiiShimei = shujiiShimei;
        this.shujiiKanaShimei = shujiiKanaShimei;
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
        this.shujiiIryoKikan = shujiiIryoKikan;
        this.seibetsuCode = seibetsuCode;
        this.seibetsu = seibetsu;
        this.shinryoka = shinryoka;
        this.shiteii = shiteii;
        this.jokyoFlag = jokyoFlag;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
    }
}
