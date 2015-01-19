/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.util;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格変更履歴のステータスを泡和す列挙クラスです。
 *
 * @author N8235 船山 洋介
 */
public enum ShikakuHenkoExecutionStatus {

    /**
     * 解除処理を示します。
     */
    Tsuika("Tsuika"),
    /**
     * 修正処理を示します。
     */
    Shusei("Shusei"),
    /**
     * 照会処理を示します。
     */
    Shokai("Shokai");
    private final RString statusValue;

    /**
     * 各項目が持つ初期値を設定するプライベートコンストラクタです。
     *
     * @param value
     */
    private ShikakuHenkoExecutionStatus(String value) {
        this.statusValue = new RString(value);
    }

    /**
     * 各ステータスが持つ、ステータスを表す文字列を返します。
     *
     * @return 各ステータスを表す文字列
     */
    public RString getValue() {
        return statusValue;
    }

    /**
     * ステータスを表す文字列を受け取る、対応したステータスに変換して返します。
     *
     * @param value ステータスを表す文字列
     * @return 画面処理ステータス
     * @throws IllegalArgumentException 対応するステータスが存在しない文字列を渡した場合
     */
    public static ShikakuHenkoExecutionStatus toValue(RString value) throws IllegalArgumentException {
        for (ShikakuHenkoExecutionStatus status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("画面処理ステータス"));
    }
}
