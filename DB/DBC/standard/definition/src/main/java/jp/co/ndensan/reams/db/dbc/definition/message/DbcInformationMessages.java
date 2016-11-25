/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBCのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBB-9999-013 wangchao
 */
public enum DbcInformationMessages implements IMessageGettable {

    限度額チェック前(1, "画面のデータを変更するため、限度額をチェックしてください。"),
    自己負担額データなし(2, "自己負担額情報が1件も存在しないため、処理できません。"),
    被保険者でないデータ(3, "被保険者として登録されていないため、処理できません。"),
    生活保護受給者(4, "生活保護受給者です。"),
    負担割合証発行不要(5, "所得や世帯構成の変更がありましたが、負担割合の変更がありませんでした。負担割合証の発行は不要です。"),
    日付_土曜日(6, "?が土曜日です。処理実行できません。"),
    日付_日曜日(7, "?が日曜日です。処理実行できません。"),
    日付_祝日(8, "?が祭日です。処理実行できません。"),
    被保険者または事業対象者でないデータ(9, "被保険者または事業対象者として登録されていないため、処理はできません。"),
    負担割合_職権データ(10, "職権修正データのため、負担割合情報を変更していません。"),
    負担割合_期間なし(11, "受給者の認定期間または事業対象者の適用期間が無くなったため、画面から利用者負担割合更正を行ってください。"),
    支給決定情報補正判定Msg1(13, "指定対象年度の給付実績情報が存在しないため、処理できません。<br>新規登録する場合は、給付実績取込後に行ってください。"),
    支給決定情報補正判定Msg2(14, "この高額合算支給決定情報に対する給付実績情報が存在しません。<br>口座修正処理となります。<br>（口座情報以外を修正する場合は給付実績取込後に行ってください）"),
    支給決定情報補正判定Msg3(15, "この高額合算支給決定情報に対する給付実績情報が存在しません。<br>照会処理となります。<br>（削除する場合は給付実績取込後に行ってください）"),
    支給決定情報補正判定Msg4(16, "指定対象年度の計算結果連絡票情報が存在しないため、処理できません。<br>新規登録する場合は、計算結果連絡票情報取込後に行ってください。"),
    支給決定情報補正判定Msg5(16, "この高額合算支給決定情報に対する計算結果連絡票情報が存在しません。<br>口座修正処理となります。<br>（口座情報以外を修正する場合は計算結果連絡票情報取込後に行ってください）"),
    支給決定情報補正判定Msg6(16, "この高額合算支給決定情報に対する計算結果連絡票情報が存在しません。<br>照会処理となります。<br>（削除する場合は計算結果連絡票情報取込後に行ってください）");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbcInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("DBCI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
