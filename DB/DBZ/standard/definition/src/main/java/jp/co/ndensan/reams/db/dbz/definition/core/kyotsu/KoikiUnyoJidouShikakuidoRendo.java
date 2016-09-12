/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域運用設定_自動資格異動連動区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KoikiUnyoJidouShikakuidoRendo {

    /**
     * コード:0 名称:実施しない 略称:定義なし
     */
    実施しない("0", "実施しない"),
    /**
     * コード:1 名称:実施する 略称:定義なし
     */
    実施する("1", "実施する");

    private final RString code;
    private final RString fullName;

    private KoikiUnyoJidouShikakuidoRendo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域運用設定_自動資格異動連動区分のコードを返します。
     *
     * @return 広域運用設定_自動資格異動連動区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域運用設定_自動資格異動連動区分の名称を返します。
     *
     * @return 広域運用設定_自動資格異動連動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域運用設定_自動資格異動連動区分のコードと一致する内容を探します。
     *
     * @param code 広域運用設定_自動資格異動連動区分のコード
     * @return {@code code} に対応する広域運用設定_自動資格異動連動区分
     */
    public static KoikiUnyoJidouShikakuidoRendo toValue(RString code) {

        for (KoikiUnyoJidouShikakuidoRendo value : KoikiUnyoJidouShikakuidoRendo.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("広域運用設定_自動資格異動連動区分"));
    }
}
