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
    対象の償還決定データが存在しません(98, "受給者または総合事業対象者として登録されていないため、この処理はできません。"),
    償還決定データなし(99, "対象の償還決定データが存在しません。");

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
