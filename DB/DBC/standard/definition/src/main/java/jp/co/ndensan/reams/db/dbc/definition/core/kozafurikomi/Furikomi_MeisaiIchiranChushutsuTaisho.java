/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込_明細一覧抽出対象を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum Furikomi_MeisaiIchiranChushutsuTaisho {

    /**
     * コード:1 名称:振込データ作成済を除く 略称:定義なし
     */
    振込データ作成済を除く("1", "振込データ作成済を除く"),
    /**
     * コード:2 名称:振込データ作成済のみ 略称:定義なし
     */
    振込データ作成済のみ("2", "振込データ作成済のみ"),
    /**
     * コード:2 名称:全て 略称:定義なし
     */
    全て("0", "全て");

    private final RString code;
    private final RString fullName;

    private Furikomi_MeisaiIchiranChushutsuTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込_明細一覧抽出対象のコードを返します。
     *
     * @return 振込_明細一覧抽出対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込_明細一覧抽出対象の名称を返します。
     *
     * @return 振込_明細一覧抽出対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込_明細一覧抽出対象のコードと一致する内容を探します。
     *
     * @param code 振込_明細一覧抽出対象のコード
     * @return {@code code} に対応する振込_明細一覧抽出対象名称
     */
    public static Furikomi_MeisaiIchiranChushutsuTaisho toValue(RString code) {

        for (Furikomi_MeisaiIchiranChushutsuTaisho meisaiIchiranChushutsuTaisho : Furikomi_MeisaiIchiranChushutsuTaisho.values()) {
            if (meisaiIchiranChushutsuTaisho.code.equals(code)) {
                return meisaiIchiranChushutsuTaisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込_明細一覧抽出対象"));
    }
}
