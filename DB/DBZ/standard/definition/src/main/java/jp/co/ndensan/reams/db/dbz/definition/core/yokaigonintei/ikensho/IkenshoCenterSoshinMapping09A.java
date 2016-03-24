/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 意見書センター送信マッピング09Aを表す列挙型です。
 */
public enum IkenshoCenterSoshinMapping09A {

    /**
     * コード:32 名称:認知症高齢者の日常生活自立度 略称:定義なし
     */
    認知症高齢者の日常生活自立度("32", "痴呆性老人の日常生活自立度"),
    /**
     * コード:28 名称:短期記憶 略称:定義なし
     */
    短期記憶("28", "短期記憶"),
    /**
     * コード:29 名称:認知能力 略称:定義なし
     */
    認知能力("29", "日常の意思決定を行うための認知能力"),
    /**
     * コード:30 名称:伝達能力 略称:定義なし
     */
    伝達能力("30", "自分の意思の伝達能力"),
    /**
     * コード:31 名称:食事行為 略称:定義なし
     */
    食事行為("31", "食事行為");

    private final RString code;
    private final RString fullName;

    private IkenshoCenterSoshinMapping09A(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書センター送信マッピング09Aのコードを返します。
     *
     * @return 意見書センター送信マッピング09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書センター送信マッピング09Aの名称を返します。
     *
     * @return 意見書センター送信マッピング09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書センター送信マッピング09Aのコードと一致する内容を探します。
     *
     * @param code 意見書センター送信マッピング09Aのコード
     * @return {@code code} に対応する意見書センター送信マッピング09A
     */
    public static IkenshoCenterSoshinMapping09A toValue(RString code) {
        for (IkenshoCenterSoshinMapping09A ikenshoCenterSoshinMapping09A : IkenshoCenterSoshinMapping09A.values()) {
            if (ikenshoCenterSoshinMapping09A.code.equals(code)) {
                return ikenshoCenterSoshinMapping09A;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書センター送信マッピング09A"));
    }
}
