/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBDのエラーメッセージ定義列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum DbdErrorMessages implements IMessageGettable {

    受給共通_受給者登録なし(2, "受給者として登録されていないため、この処理はできません。"),
    利用者負担額減額_給付率範囲外(4, "範囲外の給付率の入力はできません。"),
    減免減額_適用期間重複(9, "適用期間が重複している項目があります。重複がないように修正してください。"),
    減免減額_適用日が法施行前(10, "適用日が法施行より前のため登録できません。"),
    減免減額_有効期限が年度外(11, "年度を越えた期間の設定はできません。"),
    減免減額_有効期限が適用日以前(12, "適用日以前の有効期限は設定できません。"),
    減免減額_確認番号が既に存在(13, "入力の確認番号と同一の番号が既に存在しています。別の番号を設定してください。"),
    社会福祉法人減免_減免率_分子が分母より大(14, "分子には、分母以下の値を入力してください。"),
    社会福祉法人減免_減免率_分子は1桁整数(15, "減免率（分子）は1桁の整数値で設定してください。"),
    社会福祉法人減免_減免率_分子は2桁整数(16, "減免率（分子）は2桁の整数値で設定してください。"),
    社会福祉法人減免_減免率_分子は1から99の範囲(17, "減免率（分子）は1.0～99.9の範囲で設定してください。"),
    社会福祉法人減免_減免率_分母は2桁整数(18, "減免率（分母）は2桁の整数値で設定してください。"),
    社会福祉法人減免_減免率_分母は100(19, "減免率（分母）は100を設定してください。"),
    減免減額_給付率範囲外(20, "範囲外の給付率の入力はできません。"),
    支払方法変更_要滞納状況確定(21, "滞納状況を確定させてください。"),
    特別地域加算減免_軽減率範囲外(22, "軽減率は%1～100の範囲で設定してください。"),
    受給共通_受給者_事業対象者登録なし(22, "受給者または総合事業対象者として登録されていないため、この処理はできません。"),
    社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択(24, "「居宅サービス限定」と「旧措置ユニット型個室限定」は同時に選択できません。"),
    利用者負担段階_判定失敗(25, "利用者負担段階_判定失敗"),
    調定年度が_2016_以前(26, "平成28年度以降の事務処理です。平成28年度に年度切替された後に実施してください。"),
    年金保険者入力不正(27, "年金保険者コードを確認してください。"),
    年金入力不正(28, "年金コードを確認してください。"),
    被保険者関連違い(29, "他の被保険者に関連付けされています。（被保険者番号：?）"),
    変更無し(30, "編集されていないため、更新できません。"),
    データ重複チェック(31, "同一年金の?受給の非課税年金情報として、同一作成年月日の情報が登録されています。"
            + "<br>作成年月日が新しいものが、利用者負担段階の判定で優先されます。入力内容を見直してください。"),
    特殊時効起算日(32, "特殊時効起算日と特殊時効起算日事由は、両方設定してください。"),
    年次ファイル相違(33, "指定されたファイルは、非課税年金対象者情報（年次）のファイルと違っています。"),
    月次ファイル相違(34, "指定されたファイルは、非課税年金対象者情報（月次）のファイルと違っています。"),
    アップロードファイル無し(35, "ファイルがアップロードされていません。"),
    処理状態不正(36, "処理状態が?のため、処理できません。"),
    アップロードファイル無し_広域(37, "全構成市町村のファイルがアップロードされていません。"),
    市町村コード相違(38, "指定された市町村コードとアップロードされたファイルの市町村コードが違います。"),
    通知書印刷不可(99, "?は印刷できません。"),
    処理なし(39, "全構成市町村の対象月の取込処理が「処理なし」に設定されています。<br>広域保険者の対象月の取込処理も「処理なし」に設定してください。"),
    複数選択不可(40, "?は複数選択できません。"),
    確認書_証明書発行不可(41, "当該住民に対して、?を発行できません。"),
    _2号医療保険なし(42, "2号被保険者は医療保険情報が必要です。"),
    _2号特定疾病なし(43, "2号被保険者は特定疾病が必要です。"),
    区分変更サービス変更の対象外(44, "選択されたデータは処理対象外のデータです。"),
    特殊処理対象外(45, "選択されたデータは特殊処理対象外のデータです。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBDE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
