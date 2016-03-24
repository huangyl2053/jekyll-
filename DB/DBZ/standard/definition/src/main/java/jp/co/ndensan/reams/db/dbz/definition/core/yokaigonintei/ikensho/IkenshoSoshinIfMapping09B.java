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
 * 意見書データ送信マッピング09Bを表す列挙型です。
 */
public enum IkenshoSoshinIfMapping09B {

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

    private IkenshoSoshinIfMapping09B(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書データ送信マッピング09Bのコードを返します。
     *
     * @return 意見書データ送信マッピング09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書データ送信マッピング09Bの名称を返します。
     *
     * @return 意見書データ送信マッピング09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書データ送信マッピング09Bのコードと一致する内容を探します。
     *
     * @param code 意見書データ送信マッピング09Bのコード
     * @return {@code code} に対応する意見書データ送信マッピング09B
     */
    public static IkenshoSoshinIfMapping09B toValue(RString code) {
        for (IkenshoSoshinIfMapping09B ikenshoSoshinIfMapping09B : IkenshoSoshinIfMapping09B.values()) {
            if (ikenshoSoshinIfMapping09B.code.equals(code)) {
                return ikenshoSoshinIfMapping09B;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書データ送信マッピング09B"));
    }
}
