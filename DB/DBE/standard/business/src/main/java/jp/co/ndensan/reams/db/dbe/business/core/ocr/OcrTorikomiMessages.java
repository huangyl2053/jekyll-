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
     * ※※仮実装用項目※※　今後、本格的な実装が必要な箇所に定義します。
     */
    @Deprecated
    TODO(""),
    /**
     *
     */
    @Deprecated
    関連データ_取得失敗("当該被保険者には、要介護認定の申請が存在しません。"),
    /**
     *
     */
    有効な要介護認定申請なし("当該被保険者には、要介護認定の申請が存在しません。"),
    /**
     *
     */
    過去制度での申請("当該申請は過去の制度時の物であるため、処理を行いませんでした。"),
    /**
     *
     */
    削除された申請("当該申請は削除されています。"),
    /**
     *
     */
    申請日一致なし("この申請日での申請は見つかりませんでした。"),
    /**
     *
     */
    申請日一致なし_直近申請日提示("この申請日での申請は見つかりませんでした。 存在する直近の申請日：?"),
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
            "CA3ファイル内に該当するデータが存在しないため保存できません。"
    );

    //<editor-fold defaultstate="collapsed" desc="implements...">
    private final RString theOriginalMessage;

    private OcrTorikomiMessages(String message) {
        this.theOriginalMessage = new RString(message);
    }

    /**
     * @return 未編集のメッセージ
     */
    public RString originalMessage() {
        return this.theOriginalMessage;
    }

    /**
     * @param replaces 置き換え文字
     * @return 指定された内容でリプレイス箇所を置き換えたメッセージ
     */
    public RString replaced(String... replaces) {
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
