/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBBのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbbErrorMessages implements IMessageGettable {

    比較対象データなし(1, "比較対象のデータがありません。"),
    特徴対象者でないため処理不可(2, "特別徴収の対象者ではないため、当処理は使用できません。"),
    被保険者でないため変更不可(3, "資格喪失しているため、変更できません。"),
    年度切替未処理でバッチ実行不可(4, "年度切替が未処理なので、バッチの実行はできません。"),
    抽出開始年齢大小不整合(5, "抽出開始年齢＞抽出終了年齢です。"),
    抽出開始生年月日大小不整合(6, "抽出開始生年月日＞抽出終了生年月日です。"),
    賦課変更なしで保存不可(7, "更正前、更正後で賦課の内容に変更がありませんので保存できません。"),
    特徴対象者でないため期別金額設定不可(8, "特別徴収?は特別徴収の対象者ではないため、特別徴収の期別金額は設定できません。"),
    年齢65歳未満(9, "指定した年齢が65歳未満です。"),
    特徴対象者同定処理未完了(10, "特別徴収対象者同定処理が完了していません。"),
    賦課処理対象月と通知書出力月の不整合(11, "選択された賦課処理の処理対象月と納入通知書の出力対象期（月）が異なっています。"),
    依頼金額決定済みのため処理不可(12, "該当者は依頼金額が決定済みのため、処理できません。"),
    帳票ID取得不可のため処理不可(13, "帳票IDが取得できないため、処理を継続できません。"),
    前回過年度賦課確定未処理(14, "前回の過年度賦課確定が処理されていません。"),
    銀振5期タイプ仮算定なし(15, "銀振型5期タイプの保険料納入通知書（仮算定）が存在しません。"),
    異動賦課の確定処理が未処理(16, "異動賦課に対応する賦課確定処理が完了していません。"),
    賦課情報なし(17, "賦課情報が存在しないため、処理できません。"),
    徴収方法設定不可(18, "資格が存在しない月に徴収方法の設定はできません。"),
    激変緩和区分対象者不正_非課税区分(19, "激変緩和区分の登録は住民税課税者のみです。"),
    激変緩和区分対象者不正_合計所得(20, "激変緩和区分の登録は合計所得金額125万以下になります。"),
    激変緩和区分対象者不正_年齢(21, "激変緩和区分の登録は平17年1月1日以前に65歳年齢到達した方になります。"),
    処理済み(22, "この機能は処理済です。?"),
    処理不可_関連機能処理済み(23, "?が処理済みのため、?処理を継続できません。"),
    処理不可_関連機能未処理済(24, "?が未処理のため、?処理を継続できません。"),
    所得照会_照会先不正(25, "選択された住民の照会先が異なります。"),
    所得照会_現住所不正(26, "選択された住民の現住所が異なります。"),
    特徴期別額不正_300円以上の差(27, "特徴4期納付額と特徴5期納付額で300円以上の差があります。"),
    特徴期別額不正_大小関係(28, "特徴4期納付額 ＜ 特徴5期納付額の入力はできません。"),
    特徴期別額不正_特徴0円(29, "特徴%期納付額は0円に設定できません。徴収方法修正で徴収方法を普徴に変更後、即時賦課更正を行ってください。"),
    普徴納付額0円(30, "普徴の納付額が0円のため、登録できません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBBE", no), message);
    }

    @Override
    public Message getMessage() {
        return this.message;
    }
}
