/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

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
    フォーマット不正("取込可能なデータ形式と合致しません。OCR2000iから処理をやりなおしてください。 行番号：?　内容：?"),
    /**
     *
     */
    有効な要介護認定申請なし("当該被保険者には、当該処理の対象となる要介護認定の申請が存在しません。"),
    /**
     *
     */
    同一申請複数存在("?の中に同一の申請が複数存在しています。処理対象を特定できません。OCR2000iから処理をやりなおしてください。"),
    /**
     *
     */
    過去制度での申請("当該申請は過去の制度時の物です。そのため、処理を行いませんでした。"),
    /**
     *
     */
    一次判定済みの申請_エラー("当該申請は一次判定が完了しています。そのため、処理を行いませんでした。"),
    /**
     *
     */
    一次判定済みの申請_警告("当該申請は一次判定が完了しています。"),
    /**
     *
     */
    削除された申請("当該申請は削除されています。そのため、処理を行いませんでした。"),
    /**
     *
     */
    申請日一致なし("この申請日では、当該処理の対象となる申請は見つかりませんでした。"),
    /**
     *
     */
    申請日一致なし_直近申請日提示("この申請日では、当該処理の対象となる申請は見つかりませんでした。 存在する直近の申請日：?"),
    /**
     *
     */
    調査実施日が依頼日より前("調査の実施日が依頼日より前の日付です。 依頼日：? 調査実施日：?"),
    /**
     *
     */
    調査員_不存在("取り込んだ 調査委託先：? 調査員：? は存在しません。"),
    /**
     *
     */
    委託先_不存在("取り込んだ 調査委託先：? は存在しません。"),
    /**
     *
     */
    依頼時と異なる調査員("依頼時と実施時の調査員が異なります。　依頼時={調査委託先：?, 調査員：?}　実施時={調査委託先：?, 調査員：?}"),
    /**
     *
     */
    依頼時と異なる委託先_調査員("依頼時と実施時の調査委託先、調査員が異なります。　依頼時={調査委託先：?, 調査員：?}　実施時={調査委託先：?, 調査員：?}"),
    /**
     *
     */
    存在しないイメージあり("次のファイルがアップロードされていなかったため、登録できませんでした。 ファイル名：?"),
    /**
     *
     */
    イメージ保存処理に失敗("保存処理に失敗しました。取込処理をやり直してください。"),
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
    その他資料_最大数超過("同一申請に対して登録可能な最大数を超えたため、破棄しました。"),
    /**
     *
     */
    警告あり("警告が?件あります。");

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

    public static String toSlashSeparatedSeireki(FlexibleDate fDate) {
        return fDate.seireki().separator(Separator.SLASH).fillType(FillType.NONE).toDateString().toString();
    }

    public static RString cutToLength(int max, RString rstr, RString stringIfConcatAtCut) {
        return rstr.length() < max ? rstr : rstr.substringReturnAsPossible(0, max).concat(stringIfConcatAtCut);
    }

    public static final RString RYAKU = new RString("…(略)");
}
