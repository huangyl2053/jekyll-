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
    /**
     * ※※仮実装用項目※※　今後、本格的な実装が必要な箇所に定義します。
     */
    @Deprecated
    TODO(""),
    /**
     *
     */
    フォーマット不正("フォーマットが不正です。取込可能なデータ形式と合致しません。OCR2000iから処理をやりなおしてください。"),
    /**
     *
     */
    有効な要介護認定申請なし("当該被保険者には、要介護認定の申請が存在しません。"),
    /**
     *
     */
    同一申請複数存在("?の中に同一の申請が複数存在しています。処理対象を特定できません。OCR2000iから処理をやりなおしてください。"),
    /**
     *
     */
    過去制度での申請("当該申請は過去の制度時の物であるため、処理を行いませんでした。"),
    /**
     *
     */
    一次判定済みの申請_エラー("当該申請は一次判定が完了しているため、処理を行いませんでした。"),
    /**
     *
     */
    一次判定済みの申請_警告("当該申請は一次判定が完了しています。"),
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
    調査員_不存在("取り込んだ 調査委託先（所属期間）：? 調査員：? は存在しません。"),
    /**
     *
     */
    委託先_不存在("取り込んだ 調査委託先（所属期間）：?  は存在しません。"),
    /**
     *
     */
    依頼時と異なる調査員("依頼時の調査員と異なります。 調査委託先（所属期間）：? 調査員：? → ?"),
    /**
     *
     */
    依頼時と異なる委託先_調査員("依頼時の調査員と異なります。 調査委託先（所属期間）：?→? 調査員：?→?"),
    /**
     *
     */
    イメージ保存処理に失敗("保存処理に失敗しました。取込処理をやり直してください。"),
    /**
     *
     */
    @Deprecated
    カタログデータのみ(""),
    /**
     *
     */
    カタログデータなし("CA3ファイル内に該当するデータが存在しないため保存できません。"),
    /**
     *
     */
    特記事項_連番重複_上書き("左記の特記事項は上書きされました：?"),
    /**
     *
     */
    特記事項_連番重複_更新取りやめ("左記の特記事項の更新は取りやめました。：?"),
    /**
     *
     */
    その他資料_最大数超過("同一申請に対して登録可能な最大数を超えたため、破棄しました。");

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
