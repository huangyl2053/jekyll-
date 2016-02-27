
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 広域内住所地特例者一覧表ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochitokureishaIchiranhyoHeadItem {

    private final RString 印刷日時;
    // TODO 袁献輝 rseファイルにninshoshaShimeiを存在しない　2016/02/26。
//    private final RString ページ数;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RString 並び順１;
    private final RString 並び順２;
    private final RString 並び順３;
    private final RString 並び順４;
    private final RString 並び順５;
    private final RString 改頁１;
    private final RString 改頁２;
    private final RString 改頁３;
    private final RString 改頁４;
    private final RString 改頁５;

    /**
     * インスタンスを生成します。
     *
     * @param 印刷日時 印刷日時
     * @param ページ数 ページ数
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 並び順１ 並び順１
     * @param 並び順２ 並び順２
     * @param 並び順３ 並び順３
     * @param 並び順４ 並び順４
     * @param 並び順５ 並び順５
     * @param 改頁１ 改頁１
     * @param 改頁２ 改頁２
     * @param 改頁３ 改頁３
     * @param 改頁４ 改頁４
     * @param 改頁５ 改頁５
     *
     */
    public KoikinaiJushochitokureishaIchiranhyoHeadItem(
            RString 印刷日時,
            // TODO 袁献輝 rseファイルにninshoshaShimeiを存在しない　2016/02/26。
            //            RString ページ数,
            RString 市町村コード,
            RString 市町村名,
            RString 並び順１,
            RString 並び順２,
            RString 並び順３,
            RString 並び順４,
            RString 並び順５,
            RString 改頁１,
            RString 改頁２,
            RString 改頁３,
            RString 改頁４,
            RString 改頁５) {

        this.印刷日時 = 印刷日時;
        // TODO 袁献輝 rseファイルにninshoshaShimeiを存在しない　2016/02/26。
//        this.ページ数 = ページ数;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.並び順１ = 並び順１;
        this.並び順２ = 並び順２;
        this.並び順３ = 並び順３;
        this.並び順４ = 並び順４;
        this.並び順５ = 並び順５;
        this.改頁１ = 改頁１;
        this.改頁２ = 改頁２;
        this.改頁３ = 改頁３;
        this.改頁４ = 改頁４;
        this.改頁５ = 改頁５;
    }
}
