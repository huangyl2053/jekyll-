/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util;

import jp.co.ndensan.reams.db.dbz.divcontroller.util.*;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例異動において、適用・解除・訂正のうち、何の処理を実行しようとしているのか判断するための処理区分です<br/>
 *
 * @author n8178 城間篤人
 */
public enum JushochiTokureiExecutionStatus {

    /**
     * 適用処理を示します。
     */
    Tekiyo("Tekiyo"),
    /**
     * 解除処理を示します。
     */
    Kaijo("Kaijo"),
    /**
     * 訂正処理を示します。
     */
    Teisei("Teisei"),
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
    private JushochiTokureiExecutionStatus(String value) {
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
    public static JushochiTokureiExecutionStatus toValue(RString value) throws IllegalArgumentException {
        for (JushochiTokureiExecutionStatus status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("画面処理ステータス"));
    }
}
