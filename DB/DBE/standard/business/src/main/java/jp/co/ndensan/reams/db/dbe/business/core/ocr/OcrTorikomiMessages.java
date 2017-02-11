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
 * OCR取込結果の表示用いるメッセージを管理します。
 */
public enum OcrTorikomiMessages {

    /**
     * ※※仮実装用項目※※　今後、本格的な実装が必要な箇所に定義します。
     */
    @Deprecated
    TODO(""),
    /**
     * データレコードのフォーマットが不正である場合のメッセージ
     *
     * 引数1: 行の番号, 引数2: レコードの内容
     */
    フォーマット不正("取込可能なデータ形式と合致しません。OCR2000iから処理をやりなおしてください。　行番号：?　内容：?"),
    /**
     * 取込結果の保険者番号、被保険者番号で、申請情報を検索しても見つからない場合のメッセージ
     */
    有効な要介護認定申請なし("当該被保険者には、当該処理の対象となる要介護認定の申請が存在しません。"),
    /**
     * 取込結果の中に同じ申請が複数存在し、どの値を使ってDBを更新するべきか判断できない場合のメッセージ
     *
     * 引数1: 現象のあったファイル名
     */
    同一申請複数存在("?の中に同一の申請が複数存在しています。処理対象を特定できません。OCR2000iから処理をやりなおしてください。"),
    /**
     * 取込結果の申請情報が、過去の制度時の物（古い厚労省IF識別コード）である場合のメッセージ
     */
    過去制度での申請("当該申請は過去の制度時の物です。そのため、処理を行いませんでした。"),
    /**
     * 取込結果の申請情報が、一次判定済みである場合のメッセージ（エラーとする場合）
     */
    一次判定済みの申請_エラー("当該申請は一次判定が完了しています。そのため、処理を行いませんでした。"),
    /**
     * 取込結果の申請情報が、一次判定済みである場合のメッセージ（エラーとしない場合）
     */
    一次判定済みの申請_警告("当該申請は一次判定が完了しています。"),
    /**
     * 取込結果の申請情報が、論理削除済みの場合のメッセージ
     */
    削除された申請("当該申請は削除されています。そのため、処理を行いませんでした。"),
    /**
     * 取込結果が持つ申請日では、申請情報が見つからなかった場合のメッセージ
     */
    申請日一致なし("この申請日では、当該処理の対象となる申請は見つかりませんでした。"),
    /**
     * 取込結果が持つ申請日では、申請情報が見つからなかった場合のメッセージ（見つかった場合は、申請日を提示）
     *
     * 引数1: 実在する申請日
     */
    申請日一致なし_直近申請日提示("この申請日では、当該処理の対象となる申請は見つかりませんでした。　存在する直近の申請日：?"),
    /**
     * 取込結果の実施日が、認定調査の依頼日より前の場合のメッセージ
     *
     * 引数1: 依頼日, 引数2: 実施日
     */
    調査実施日が依頼日より前("調査の実施日が依頼日より前の日付です。　依頼日：?　実施日：?"),
    /**
     * 取込結果の調査委託先は存在するが、調査員がマスタ上に存在しない場合のメッセージ
     *
     * 引数1: 取込結果の調査委託先コード, 引数2: 取込結果の調査員コード
     */
    調査員_不存在("取り込んだ 調査委託先：? 調査員：? は存在しません。"),
    /**
     * 取込結果の調査委託先が存在しない場合のメッセージ
     *
     * 引数1: 取込結果の調査委託先コード
     */
    委託先_不存在("取り込んだ 調査委託先：? は存在しません。"),
    /**
     * 調査依頼時の調査員と、取込結果の内容が異なる場合のメッセージ
     *
     * 引数1: 依頼時の調査委託先コード, 引数2: 依頼時の調査員コード, 引数3: 取込結果の調査委託先コード, 引数4: 取込結果の調査員コード
     */
    依頼時と異なる調査員("依頼時と実施時の調査員が異なります。　依頼時={調査委託先：?, 調査員：?}　実施時={調査委託先：?, 調査員：?}"),
    /**
     * 調査依頼時の調査委託先と調査員とが、取込結果の内容が異なる場合のメッセージ
     *
     * 引数1: 依頼時の調査委託先コード, 引数2: 依頼時の調査員コード, 引数3: 取込結果の調査委託先コード, 引数4: 取込結果の調査員コード
     */
    依頼時と異なる委託先_調査員("依頼時と実施時の調査委託先、調査員が異なります。　依頼時={調査委託先：?, 調査員：?}　実施時={調査委託先：?, 調査員：?}"),
    /**
     * 取込結果の記入日が、意見書の依頼日よりも前の場合のメッセージ
     *
     * 引数1: 依頼日, 引数2: 取込結果の記入日
     */
    意見書記入日が依頼日より前("意見書の記入日が依頼日より前の日付です。　依頼日：?　記入日：?"),
    /**
     * カタログファイルにはイメージファイル名の記載があるが、処理実施時にアップロードされたファイルの中にそのイメージファイルが存在しない場合のメッセージ
     *
     * 引数1: 存在しないイメージファイル名
     */
    存在しないイメージあり("次のファイルがアップロードされていなかったため、登録できませんでした。：?"),
    /**
     * 何らかの不具合でイメージの共有ファイルへの登録が失敗した場合のメッセージ
     */
    イメージ保存処理に失敗("保存処理に失敗しました。取込処理をやり直してください。"),
    /**
     * カタログファイル内に情報が存在しない場合のメッセージ
     */
    カタログデータなし("ca3ファイル内に該当するデータが存在しないため保存できません。"),
    /**
     * 以前の取込結果と重複する連番を取り込んだ際に「上書き」した場合のメッセージ
     *
     * 引数1: 更新しなかった特記事項番号と連番の列挙
     */
    特記事項_連番重複_上書き("次の特記事項を上書きしました。：?"),
    /**
     * 以前の取込結果と重複する連番を取り込んだ際に「上書き」しなかった場合のメッセージ
     *
     * 引数1: 更新しなかった特記事項番号と連番の列挙
     */
    特記事項_連番重複_更新取りやめ("次の特記事項の更新は取りやめました。：?"),
    /**
     * 特記事項の連番を登録用に振りなおした際に表示するメッセージ
     *
     * 引数1: 変更した連番（変更前後）の列挙
     */
    特記事項_連番再付番("次の特記事項は連番を振り直しました。　凡例)変更前→変更後 ：?"),
    /**
     * その他資料の取込枚数が、対象の申請の累計で、最大値を超えた場合のメッセージ
     */
    その他資料_最大数超過("この申請に対して登録された資料の数が、保存可能な最大数(6)を超えています。そのため、次のファイルは保存せずに破棄しました。：?"),
    /**
     * 取込結果に警告がある場合のメッセージ
     *
     * 引数1: 警告の件数
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

    /**
     * 指定の日付をスラッシュ区切りで返します。
     *
     * @param fDate 日付
     * @return 編集結果の文字列
     */
    public static String toSlashSeparatedSeireki(FlexibleDate fDate) {
        return fDate.seireki().separator(Separator.SLASH).fillType(FillType.NONE).toDateString().toString();
    }

    /**
     * 指定の長さで文字列をカットします。対象の文字列が指定の最大長（{@code max}）よりも長い場合は、{@code appendTailIfCut}で指定する文字列を末尾に付与します。
     *
     * @param max 最大長
     * @param rstr 対象文字列
     * @param appendTailIfCut 最大長超過時、末尾に付与する文字列
     * @return 編集結果の文字列
     */
    public static RString cutToLength(int max, RString rstr, RString appendTailIfCut) {
        return rstr.length() < max ? rstr : rstr.substringReturnAsPossible(0, max).concat(appendTailIfCut);
    }

    /**
     * 省略を表す文字列
     */
    public static final RString RYAKU;

    static {
        RYAKU = new RString("…(略)");
    }
}
