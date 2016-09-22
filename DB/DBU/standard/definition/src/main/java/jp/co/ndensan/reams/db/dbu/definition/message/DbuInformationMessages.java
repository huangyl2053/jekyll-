/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBUのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum DbuInformationMessages implements IMessageGettable {

    得喪逆転(1, "被保台帳生年月日中間ファイル<br>取得届出日＞喪失届出日"),
    年齢算出失敗_65to75集計(2, "年齢算出に失敗したため「６５歳以上７５歳未満」側へ集計します。"),
    日付逆転(3, "被保台帳生年月日中間ファイル<br>直前日付＞現日付"),
    対象旧市町村不明_履歴番号(4, "対象旧市町村不明<br>履歴番号＝%1"),
    対象市町村不明_基準日１(5, "対象市町村不明・基準日１<br>%1"),
    対象市町村不明_基準日２(6, "対象市町村不明・基準日２<br>%1"),
    対象旧市町村不明_基準日１(7, "対象旧市町村不明・基準日１<br>%1"),
    対象旧市町村不明_基準日２(8, "対象旧市町村不明・基準日２<br>%1"),
    対象市町村不明_集計年月月末(9, "対象市町村不明・基準日（集計年月月末）<br>%1"),
    対象旧市町村不明_集計年月月末(10, "対象旧市町村不明・基準日（集計年月月末）<br>%1"),
    サービス種類コード未設定(11, "サービス種類コード設定なし"),
    食費_居住費未設定(12, "食費・居住費の設定なし"),
    利用者負担段階未設定(13, "利用者負担段階設定なし"),
    年齢算出失敗_対象外(14, "年齢算出に失敗したため集計対象に入りません。"),
    年齢算出失敗_１号集計(15, "年齢算出に失敗したため１号被保険者として集計します。"),
    被保台帳取得不可(16, "被保険者台帳が取得できなかったため集計対象に入りません。"),
    要介護度不明(17, "要介護度不明"),
    宛名取得不可(18, "宛名データが取得できなかったため集計対象に入りません。"),
    データ不整合１(19, "データ不整合１<br>給付実績情報作成区分コード＝%1<br>サービス種類コード＝%2"),
    データ不整合２(20, "データ不整合２<br>給付実績情報作成区分コード＝%1<br>サービス種類コード＝%2"),
    要介護度不正(21, "要介護度不正<br>作成区分＝%1<br>要介護度＝%2"),
    サービス項目コード不正(22, "サービス項目コード不正　作成区分＝%1<br>サービス項目コード＝%2"),
    サービス項目コード誤り(23, "サービス項目コード誤り　明細番号＝%1<br>連番＝%2<br>サービス項目コード＝%3"),
    高額申請_支給区分未設定(24, "高額申請管理マスタの支給区分コードが設定されていません。"),
    資格区分取得不可_対象外(25, "資格区分が取得できなかったため集計対象に入りません。"),
    被保険者台帳データなし_基準日_対象計算期間_終了(26, "被保台帳データなし：基準日（対象計算期間（終了））<br>%1"),
    対象旧市町村不明_基準日(27, "対象旧市町村不明・基準日（対象計算期間（終了））<br>%1");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbuInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("DBUI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
