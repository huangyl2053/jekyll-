/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiiryokikanjohomaster;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報出力用CSVBusinessクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiShujiiIryoKikanMasterCSV {

    private final RString shichosonCode;
    private final RString shichosonMeisho;
    private final RString shujiiIryokikanCode;
    private final RString iryokikanCode;
    private final RString iryoKikanMeisho;
    private final RString iryoKikanMeishoKana;
    private final RString yubinNo;
    private final RString jusho;
    private final RString telNo;
    private final RString faxNo;
    private final RString daihyoshaName;
    private final RString daihyoshaNameKana;
    private final RString jokyoFlag;

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
     */
    public KoseiShujiiIryoKikanMasterCSV(
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
            RString jokyoFlag
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
    }
}
