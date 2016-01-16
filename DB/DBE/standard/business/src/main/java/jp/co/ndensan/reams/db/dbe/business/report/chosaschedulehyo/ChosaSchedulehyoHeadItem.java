
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査スケジュール登録・認定調査スケジュール表(事務所)ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoHeadItem {

    // TODO QA504仕様にprintTimeStamp1存在しなし。　2016/01/19
    private final RString printTimeStamp1;
    private final RString title;
    private final RString chosaItakusakiNo;
    private final RString chosaItakusakiName;
    // TODO QA504仕様にchosaTaishoYYとchosaTaishoMM存在しなし。　2016/01/19
    private final RString chosaTaishoYY;
    private final RString chosaTaishoMM;
    // TODO QA504帳票レイアウトにprintTimeStamp存在しなし。　2016/01/19
    private final RString printTimeStamp;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp1 印刷日時1
     * @param title タイトル
     * @param chosaItakusakiNo 調査事業所コード
     * @param chosaItakusakiName 調査事業所名
     * @param chosaTaishoYY 対象年
     * @param chosaTaishoMM 対象月
     * @param printTimeStamp 印刷日時
     */
    public ChosaSchedulehyoHeadItem(
            RString printTimeStamp1,
            RString title,
            RString chosaItakusakiNo,
            RString chosaItakusakiName,
            RString chosaTaishoYY,
            RString chosaTaishoMM,
            RString printTimeStamp) {

        this.printTimeStamp1 = printTimeStamp1;
        this.title = title;
        this.chosaItakusakiNo = chosaItakusakiNo;
        this.chosaItakusakiName = chosaItakusakiName;
        this.chosaTaishoYY = chosaTaishoYY;
        this.chosaTaishoMM = chosaTaishoMM;
        this.printTimeStamp = printTimeStamp;
    }
}
