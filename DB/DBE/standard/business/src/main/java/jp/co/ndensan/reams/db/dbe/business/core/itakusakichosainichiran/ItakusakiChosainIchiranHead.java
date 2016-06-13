/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.itakusakichosainichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 調査委託先・調査員一覧表ヘッダのITEMです。
 *
 * @reamsid_L DBE-0290-020 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItakusakiChosainIchiranHead {

    private final RString iryoKikanCodeFrom;
    private final RString iryoKikanCodeTo;
    private final RString shujiiCodeFrom;
    private final RString shujiiCodeTo;
    private final RString shujiiJokyo;
    private final RString cityCode;
    private final RString cityName;
    private final RString sort;
    private final RString page;
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
     *
     * @param iryoKikanCodeFrom 認定調査委託先コードFrom
     * @param iryoKikanCodeTo 認定調査委託先コードTo
     * @param shujiiCodeFrom 調査員コードFrom
     * @param shujiiCodeTo 調査員コードTo
     * @param shujiiJokyo 調査員の状況判定
     * @param cityCode 市町村コード
     * @param cityName 市町村名
     * @param sort 並び順
     * @param page 改頁
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
    public ItakusakiChosainIchiranHead(RString iryoKikanCodeFrom,
            RString iryoKikanCodeTo,
            RString shujiiCodeFrom,
            RString shujiiCodeTo,
            RString shujiiJokyo,
            RString cityCode,
            RString cityName,
            RString sort,
            RString page,
            RString shujiiIryokikanCode,
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
            RString shinryokaName) {
        this.iryoKikanCodeFrom = iryoKikanCodeFrom;
        this.iryoKikanCodeTo = iryoKikanCodeTo;
        this.shujiiCodeFrom = shujiiCodeFrom;
        this.shujiiCodeTo = shujiiCodeTo;
        this.shujiiJokyo = shujiiJokyo;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.sort = sort;
        this.page = page;
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
