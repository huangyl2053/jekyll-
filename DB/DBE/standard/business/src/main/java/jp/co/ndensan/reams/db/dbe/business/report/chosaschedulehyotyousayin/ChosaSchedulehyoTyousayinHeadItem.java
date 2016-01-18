/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査スケジュール表(調査員)ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoTyousayinHeadItem {

    private final RString chosaItakusakiNo;
    private final RString chosaItakusakiName;

    /**
     * インスタンスを生成します。
     *
     * @param chosaItakusakiNo 調査事業所コード
     * @param chosaItakusakiName 調査事業所名
     */
    public ChosaSchedulehyoTyousayinHeadItem(
            RString chosaItakusakiNo,
            RString chosaItakusakiName) {
        this.chosaItakusakiNo = chosaItakusakiNo;
        this.chosaItakusakiName = chosaItakusakiName;
    }
}
