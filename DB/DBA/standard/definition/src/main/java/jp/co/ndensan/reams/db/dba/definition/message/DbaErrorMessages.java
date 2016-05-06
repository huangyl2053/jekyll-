/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBAのエラーメッセージ定義列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum DbaErrorMessages implements IMessageGettable {

    最新資格情報追加不可(1, "最新の資格情報として追加することはできません。"),
    最新住所地特例情報追加不可(2, "最新の住所地特例情報として追加することはできません。"),
    最新資格変更情報追加不可(3, "最新の資格変更情報として追加することはできません。"),
    住所地特例適用対象者でない(4, "住所地特例の適用対象者ではありません"),
    住所地特例として適用済(5, "住所地特例として適用されています。"),
    住所地特例として未適用(6, "住所地特例として適用されていません。"),
    年齢到達取得異動未登録(9, "年齢到達による異動登録が行われていません。"),
    変更日移行新資格異動有り(10, "変更日より新しい資格異動情報が存在します。"),
    _１号被保険者対象外資格変更事由(11, "1号被保険者であるため該当の資格変更事由での登録はできません。"),
    変更日１号年齢到達日以前(12, "変更日が1号年齢到達日より前であるため、登録できません。"),
    年齢到達変更異動未登録(13, "1号被保険者到達による異動登録が行われていません。"),
    変更日１号年齢到達日不一致(14, "変更日が1号年齢到達日ではありません。"),
    広域内住所地特例者でない(15, "広域内住所地特例者ではないため、該当の資格変更事由は登録できません。"),
    住所地特例解除異動が未登録(18, "住所地特例解除異動前に住所地特例適用異動が入力されています。"),
    住所地特例適用異動が未登録(19, "住所地特例適用異動前に住所地特例解除異動が入力されています。"),
    資格取得日１号年齢到達日不一致(20, "取得日が１号年齢到達日ではありません。"),
    資格取得日時点２号被保険者年齢未到達(21, "取得日時点で２号被保険者年齢に到達していません。"),
    資格取得日時点１号被保険者年齢でない(22, "取得日時点で１号被保険者ではありません。"),
    資格取得日時点２号被保険者年齢でない(23, "取得日時点で２号被保険者ではありません。"),
    住特者のため広住特適用登録不可(24, "住所地特例適用中のため、広域内住所地特例適用異動は登録できません。"),
    該当資格異動情報なし(25, "該当データが存在しないため、資格訂正登録はできません。"),
    広域構成市町村からの補正処理(26, "広域構成市町村からの補正処理は行えません。"),
    該当報告年度の集計データは既に存在(27, "該当報告年度の集計データは既に存在しているため、追加はできません。"),
    記載解除_減額_低減適用のいずれか1つ以上選択(28, "記載解除、減額、低減適用のいずれか１つ以上を選択してください"),
    適用する項目を設定(29, "適用する?を設定してください。"),
    資格喪失登録不可(30, "資格取得者ではないため資格喪失登録はできません。"),
    開始日が制度改正前のため減額措置登録不可(31, "開始日が制度改正前であるため、?に対する減額措置登録は行えません。"),
    開始日が制度改正後のため減額措置登録不可(32, "開始日が制度改正後であるため、?に対する減額措置登録は行えません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbaErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBAE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
