/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 調定簿作成帳票ヘッダ
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteiboHeaderItem {

    /**
     * 見出し
     */
    private final RString midashi;
    /**
     * 元号
     */
    private final RString gengo;
    /**
     * 年度
     */
    private final RString nendo;
    /**
     * 作成日時
     */
    private final RString printTimeStamp;
    /**
     *
     */
    private final RString hokenshaName;
    /**
     * 保険者番号
     */
    private final RString hokenshaNo;

    /**
     * コンストラクタです
     *
     * @param 作成日時 作成日時
     * @param 見出し 見出し
     * @param 元号 元号
     * @param 年度 年度
     * @param 保険者番号 保険者番号
     * @param 保険者名 保険者名
     */
    public ChoteiboHeaderItem(
            RString 作成日時,
            RString 見出し,
            RString 元号,
            RString 年度,
            RString 保険者番号,
            RString 保険者名) {
        this.printTimeStamp = 作成日時;
        this.gengo = 元号;
        this.midashi = 見出し;
        this.nendo = 年度;
        this.hokenshaName = 保険者名;
        this.hokenshaNo = 保険者番号;
    }
}
