/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証発行管理リストの帳票出力順に対応する項目を定義します。
 *
 * @author n8178
 */
public enum HihokenshashoHakkoKanriIchiranhyoItems implements IReportItems {

    //TODO n8178 城間篤人 市町村コード、被保険者番号、隠し改行項目 以外の項目は使用不能。出力順管理.xlsxに記載された項目を元にしているが、
    //参考資料に記載されている項目がDBの構造などに則していない状態になっているので、台帳・本クラスともに修正が必要。
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
    市町村コード("0016", "listLower_1", "\"shoKofuKaishu_shichosonCode\""),
    /**
     * 被保険者番号
     */
    被保険者番号("0104", "hihokenshaNo", "\"shoKofuKaishu_hihokenshaNo\""),
    /**
     * 隠し改行項目（被保険者証発行管理リストは、最終ページに抽出項目を設定する。その際に改頁し、帳票の先頭から値を設定していく）
     */
    隠し改行項目("9999", "hiddenPageBreaker", "hiddenPageBreaker");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HihokenshashoHakkoKanriIchiranhyoItems(String 項目ID, String フォームフィールド名, String myBatis項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.myBatis項目名 = new RString(myBatis項目名);
    }

    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;
    }

}
