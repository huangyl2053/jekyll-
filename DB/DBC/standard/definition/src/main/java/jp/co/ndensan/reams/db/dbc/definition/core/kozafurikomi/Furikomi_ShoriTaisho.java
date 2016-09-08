/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込_処理対象を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum Furikomi_ShoriTaisho {

    /**
     * コード:1 名称:償還・高額データ 略称:定義なし
     */
    償還高額("1", "償還・高額データ"),
    /**
     * コード:2 名称:償還データ 略称:定義なし
     */
    償還("2", "償還データ"),
    /**
     * コード:3 名称:高額データ 略称:定義なし
     */
    高額("3", "高額データ");

    private final RString code;
    private final RString fullName;

    private Furikomi_ShoriTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込_処理対象のコードを返します。
     *
     * @return 振込_処理対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込_処理対象の名称を返します。
     *
     * @return 振込_処理対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込_処理対象のコードと一致する内容を探します。
     *
     * @param code 振込_処理対象のコード
     * @return {@code code} に対応する振込_処理対象名称
     */
    public static Furikomi_ShoriTaisho toValue(RString code) {

        for (Furikomi_ShoriTaisho furikomi_ShoriTaisho : Furikomi_ShoriTaisho.values()) {
            if (furikomi_ShoriTaisho.code.equals(code)) {
                return furikomi_ShoriTaisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込_処理対象"));
    }
}
