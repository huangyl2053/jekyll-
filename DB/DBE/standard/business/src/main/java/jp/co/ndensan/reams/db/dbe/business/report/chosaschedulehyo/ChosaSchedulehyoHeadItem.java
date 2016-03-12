
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査スケジュール表(事務所)ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoHeadItem {

    private final RString chosaItakusakiNo;
    private final RString chosaItakusakiName;
    private final RString chosaTaishoYM;

    /**
     * インスタンスを生成します。
     *
     * @param chosaItakusakiNo 調査事業所コード
     * @param chosaItakusakiName 調査事業所名
     * @param chosaTaishoYM 対象年月
     */
    public ChosaSchedulehyoHeadItem(
            RString chosaItakusakiNo,
            RString chosaItakusakiName,
            RString chosaTaishoYM) {
        this.chosaItakusakiNo = chosaItakusakiNo;
        this.chosaItakusakiName = chosaItakusakiName;
        this.chosaTaishoYM = chosaTaishoYM;
    }
}
