/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.csv.shujiijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報出力用CSVBusinessクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiMasterCsvBusiness {

    private final RString shichosonCode;
    private final RString shichosonMeisho;
    private final RString shujiiCode;
    private final RString shujiiShimei;
    private final RString shujiiKanaShimei;
    private final RString shujiiIryoKikanCode;
    private final RString shujiiIryoKikan;
    private final RString shinryoka;
    private final RString shiteii;
    private final RString jokyoFlag;
    private final RString yubinNo;
    private final RString jusho;
    private final RString telNo;
    private final RString faxNo;
    private final RString seibetsu;

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
     * @param shinryoka 診療科
     * @param shiteii 指定医
     * @param jokyoFlag 状況フラグ
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param telNo 電話番号
     * @param faxNo ＦＡＸ番号
     * @param seibetsu 性別
     */
    public ShujiiMasterCsvBusiness(
            RString shichosonCode,
            RString shichosonMeisho,
            RString shujiiCode,
            RString shujiiShimei,
            RString shujiiKanaShimei,
            RString shujiiIryoKikanCode,
            RString shujiiIryoKikan,
            RString shinryoka,
            RString shiteii,
            RString jokyoFlag,
            RString yubinNo,
            RString jusho,
            RString telNo,
            RString faxNo,
            RString seibetsu) {
        this.shichosonCode = shichosonCode;
        this.shichosonMeisho = shichosonMeisho;
        this.shujiiCode = shujiiCode;
        this.shujiiShimei = shujiiShimei;
        this.shujiiKanaShimei = shujiiKanaShimei;
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
        this.shujiiIryoKikan = shujiiIryoKikan;
        this.shinryoka = shinryoka;
        this.shiteii = shiteii;
        this.jokyoFlag = jokyoFlag;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.seibetsu = seibetsu;
    }
}
