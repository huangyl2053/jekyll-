/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public enum OcrTorikomiMessages {

    /**
     *
     */
    TODO(""),
    /**
     *
     */
    関連データ_取得失敗("証記載保険者番号、被保険者番号、申請日に該当し、かつ、?がなされた要介護認定の申請は見つかりません。"),
    /**
     *
     */
    イメージ保存処理に失敗("保存処理に失敗しました。取込処理をやり直してください。"),
    /**
     *
     */
    カタログデータのみ(""),
    /**
     *
     */
    カタログデータなし(
            "CA3ファイル内に該当するデータが存在しないため保存できません。取込処理をやり直してください。\n"
            + " ※注意点 … 取込処理では、OCR2000iにより作成されたファイルをもれなくすべて指定してください。"
    );

    //<editor-fold defaultstate="collapsed" desc="implements...">
    private final RString theOriginalMessage;

    private OcrTorikomiMessages(String message) {
        this.theOriginalMessage = new RString(message);
    }

    RString originalMessage() {
        return this.theOriginalMessage;
    }

    RString replaced(String... replaces) {
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        String editMessage = theOriginalMessage.toString();
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        for (String replace : replaces) {
            editMessage = editMessage.replaceFirst("\\?", replace);
        }
        return new RString(editMessage);
    }
        //</editor-fold>
}
