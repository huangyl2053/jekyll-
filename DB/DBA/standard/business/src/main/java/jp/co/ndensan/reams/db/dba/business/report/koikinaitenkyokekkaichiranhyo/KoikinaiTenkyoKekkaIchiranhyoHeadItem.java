
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 広域内転居結果一覧表ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoKekkaIchiranhyoHeadItem {

    private final RString 印刷日時;
    private final RString 市町村コード;
    private final RString 市町村名;

    /**
     * インスタンスを生成します。
     *
     * @param 印刷日時 印刷日時
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     *
     */
    public KoikinaiTenkyoKekkaIchiranhyoHeadItem(
            RString 印刷日時,
            RString 市町村コード,
            RString 市町村名) {
        this.印刷日時 = 印刷日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
    }
}
