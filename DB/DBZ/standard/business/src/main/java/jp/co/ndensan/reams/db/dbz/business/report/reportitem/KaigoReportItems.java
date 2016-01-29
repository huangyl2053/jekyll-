/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.reportitem;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票に出力される項目の内、出力順項目や改頁項目となるものをまとめたものです。
 *
 */
//TODO n8178 城間篤人 IReportItemsは非推奨クラスになっていますが、今後deprecatedが解除される予定なので使用して大丈夫です（UR業務共通の方に確認済）。
//このTODOは、deprecatedが解除された後に削除してください。
public enum KaigoReportItems implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号("0001", "yubinNo", "yubinNo"),
    /**
     * 住所コード
     */
    住所コード("0002", "jushoCode", "jushoCode"),
    /**
     * 番地コード
     */
    番地コード("0003", "banchiCode", "banchiCode"),
    /**
     * 行政区コード
     */
    行政区コード("0004", "gyoseikuCode", "gyoseikuCode"),
    /**
     * 地区１
     */
    地区１("0005", "chiku1", "chiku1"),
    /**
     * 地区２
     */
    地区２("0006", "chiku2", "chiku2"),
    /**
     * 地区３
     */
    地区３("0007", "chiku3", "chiku3"),
    /**
     * 世帯コード
     */
    世帯コード("0008", "setaiCode", "setaiCode"),
    /**
     * 識別コード
     */
    識別コード("0009", "shikibetsuCode", "shikibetsuCode"),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ("0010", "shimei50onKana", "shimei50onKana"),
    /**
     * 生年月日
     */
    生年月日("0012", "seinengappiYMD", "seinengappiYMD"),
    /**
     * 性別
     */
    性別("0013", "gender", "gender"),
    /**
     * 市町村コード
     */
    市町村コード("0016", "shichosonCode", "shichosonCode"),
    /**
     * 被保険者番号
     */
    被保険者番号("0104", "hihokenshaNo", "hihokenshaNo");

    private final RString komokuId;
    private final RString formFieldName;
    private final RString myBatisName;

    /**
     * 帳票出力項目管理の項目ID、帳票フィールド名、DB項目名を指定してクラスを生成します。
     *
     * @param komokuId 帳票出力項目管理の項目ID
     * @param formFieldName 帳票出力項目管理の帳票フィールド名
     * @param myBatisName 帳票出力項目管理のDB項目名
     */
    private KaigoReportItems(String komokuId, String formFieldName, String myBatisName) {
        this.komokuId = new RString(komokuId);
        this.formFieldName = new RString(formFieldName);
        this.myBatisName = new RString(myBatisName);
    }

    @Override
    public RString get項目ID() {
        return komokuId;
    }

    @Override
    public RString getフォームフィールド名() {
        return formFieldName;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatisName;
    }

}
