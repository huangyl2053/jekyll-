/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBDのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbdErrorMessages implements IMessageGettable {

    受給共通_被保データなし(1, "該当の被保データが存在しません。"),
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
    減免減額_給付率範囲外(20, "範囲外の給付率の入力はできません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("E", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
