/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面から処理を実行する際に、現在何の処理を実行しようとしているのかを判断するために使用する、共通的な区分です<br/>
 * 一つの画面で追加・修正・削除を行う場合や、共有子Divが持つグリッドに対して操作を行うときの分岐条件として利用します。
 *
 * @author n8178 城間篤人
 */
public enum ViewExecutionStatus {

    /**
     * 追加状態を表します。
     */
    Add("Add"),
    /**
     * 修正状態を表します。
     */
    Modify("Modify"),
    /**
     * 削除状態を表します。
     */
    Delete("Delete"),
    /**
     * 初期状態、もしくはいずれの操作も行っていない状態を表します。
     */
    None("None");
    private final RString statusValue;

    /**
     * 各項目が持つ初期値を設定するプライベートコンストラクタです。
     *
     * @param value
     */
    private ViewExecutionStatus(String value) {
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
    public static ViewExecutionStatus toValue(RString value) throws IllegalArgumentException {
        for (ViewExecutionStatus status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("画面処理ステータス"));
    }
}
