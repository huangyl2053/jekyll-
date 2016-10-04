/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票タイプDBD511001を表す列挙型です。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public enum ChohyoSeigyoHanyoKeysDBD511001 {

    /**
     * コード:なし 名称:帳票タイトル 略称:定義なし
     */
    帳票タイトル("帳票タイトル"),
    /**
     * コード:なし 名称:首長名印字有無 略称:定義なし
     */
    首長名印字有無("首長名印字有無"),
    /**
     * コード:なし 名称:発行日印字有無 略称:定義なし
     */
    発行日印字有無("発行日印字有無");

    private final RString fullName;

    private ChohyoSeigyoHanyoKeysDBD511001(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票制御汎用キーDBD511001の名称を返します。
     *
     * @return 帳票制御汎用キーDBD511001の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票制御汎用キーDBD511001の名称と一致する内容を探します。
     *
     * @param fullName 帳票制御汎用キーDBD511001の名称
     * @return {@code fullName} に対応する帳票制御汎用キーDBD511001
     */
    public static ChohyoSeigyoHanyoKeysDBD511001 toValue(RString fullName) {
        for (ChohyoSeigyoHanyoKeysDBD511001 value : ChohyoSeigyoHanyoKeysDBD511001.values()) {
            if (value.get名称().equals(fullName)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票制御汎用キーDBD511001"));
    }

}
