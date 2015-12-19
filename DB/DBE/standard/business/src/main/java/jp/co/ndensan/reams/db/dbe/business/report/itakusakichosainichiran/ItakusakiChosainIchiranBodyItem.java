/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査委託先・認定調査員一覧表リスト一覧表情報です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItakusakiChosainIchiranBodyItem {
    
    private final RString shujiiIryokikanCode;
    private final RString iryoKikanMeishoKana;
    private final RString iryoKikanMeisho;
    private final RString daihyoshaNameKana;
    private final RString daihyoshaName;
    private final RString yubinNo;
    private final RString telNo;
    private final RString jusho;
    private final boolean jokyoFlag;
    private final RString shujiiCode;
    private final RString shujiiKana;
    private final RString shujiiName;
    private final RString chosainShikaku;
    private final RString seibetsu;
    private final RString chosainShikakuName;
    private final RString shinryokaName;
    private final boolean shujiiJokyoFlag;
    
    /**
     * インスタンスを生成します。
     * @param shujiiIryokikanCode 調査委託先コード
     * @param iryoKikanMeishoKana 名称(ｶﾅ)
     * @param iryoKikanMeisho 名称
     * @param daihyoshaNameKana 代表者名(ｶﾅ)
     * @param daihyoshaName 代表者名
     * @param yubinNo 郵便番号
     * @param telNo 連絡先
     * @param jusho 住所
     * @param jokyoFlag 有無
     * @param shujiiCode 調査員コード
     * @param shujiiKana 調査員氏名(ｶﾅ)
     * @param shujiiName 調査員氏名
     * @param chosainShikaku 資格
     * @param seibetsu 性別
     * @param chosainShikakuName 資格名
     * @param shinryokaName 所属機関名
     * @param shujiiJokyoFlag 有無
     */
    public ItakusakiChosainIchiranBodyItem(RString shujiiIryokikanCode,
            RString iryoKikanMeishoKana,
            RString daihyoshaNameKana,
            RString yubinNo,
            RString telNo,
            boolean jokyoFlag,
            RString shujiiCode,
            RString shujiiKana,
            RString chosainShikaku,
            RString chosainShikakuName,
            boolean shujiiJokyoFlag,
            RString iryoKikanMeisho,
            RString jusho,
            RString daihyoshaName,
            RString shujiiName,
            RString seibetsu,
            RString shinryokaName
    ) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
        this.iryoKikanMeishoKana = iryoKikanMeishoKana;
        this.iryoKikanMeisho = iryoKikanMeisho;
        this.daihyoshaNameKana = daihyoshaNameKana;
        this.daihyoshaName = daihyoshaName;
        this.yubinNo = yubinNo;
        this.telNo = telNo;
        this.jusho = jusho;
        this.jokyoFlag = jokyoFlag;
        this.shujiiCode = shujiiCode;
        this.shujiiKana = shujiiKana;
        this.shujiiName = shujiiName;
        this.chosainShikaku = chosainShikaku;
        this.seibetsu = seibetsu;
        this.chosainShikakuName = chosainShikakuName;
        this.shinryokaName = shinryokaName;
        this.shujiiJokyoFlag = shujiiJokyoFlag;

    }
    
}
