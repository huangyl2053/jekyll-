/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitatesho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立書送付対象区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 wangxingpeng
 */
public enum KagomoshitateshoSofutaishoKubun {

    /**
     * コード:1 名称:1:同月過誤分過誤申立書 略称:同月過誤分
     */
    同月過誤分過誤申立書("1", "同月審査分過誤申立書", "同月過誤分"),
    /**
     * コード:2 名称:2:通常分過誤申立書 略称:通常分
     */
    通常分過誤申立書("2", "通常分過誤申立書", "通常分");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KagomoshitateshoSofutaishoKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 過誤申立書送付対象区分のコードを返します。
     *
     * @return 過誤申立書送付対象区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過誤申立書送付対象区分の名称を返します。
     *
     * @return 過誤申立書送付対象区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過誤申立書送付対象区分の略称を返します。
     *
     * @return 過誤申立書送付対象区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 過誤申立書送付対象区分のコードと一致する内容を探します。
     *
     * @param code 過誤申立書送付対象区分のコード
     * @return {@code code} に対応する過誤申立書送付対象区分
     */
    public static KagomoshitateshoSofutaishoKubun toValue(RString code) {

        for (KagomoshitateshoSofutaishoKubun insho : KagomoshitateshoSofutaishoKubun.values()) {
            if (insho.code.equals(code)) {
                return insho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立書送付対象区分"));
    }
}
