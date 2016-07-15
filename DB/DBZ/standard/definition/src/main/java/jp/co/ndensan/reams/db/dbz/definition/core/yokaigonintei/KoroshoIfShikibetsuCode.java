/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 厚労省認定ソフトのバージョンを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KoroshoIfShikibetsuCode {

    /**
     * コード:99A 名称:認定ｿﾌﾄ99 略称:定義なし
     */
    認定ｿﾌﾄ99("99A", "認定ｿﾌﾄ99"),
    /**
     * コード:02A 名称:認定ｿﾌﾄ2002 略称:定義なし
     */
    認定ｿﾌﾄ2002("02A", "認定ｿﾌﾄ2002"),
    /**
     * コード:06A 名称:認定ｿﾌﾄ2006（新要介護認定適用区分が未適用） 略称:定義なし
     */
    認定ｿﾌﾄ2006_新要介護認定適用区分が未適用("06A", "認定ｿﾌﾄ2006（新要介護認定適用区分が未適用）"),
    /**
     * コード:09A 名称:認定ｿﾌﾄ2009 略称:定義なし
     */
    認定ｿﾌﾄ2009("09A", "認定ｿﾌﾄ2009"),
    /**
     * コード:09B 名称:認定ｿﾌﾄ2009（SP3） 略称:定義なし
     */
    認定ｿﾌﾄ2009_SP3("09B", "認定ｿﾌﾄ2009（SP3）");

    private final RString code;
    private final RString fullName;

    private KoroshoIfShikibetsuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 厚労省認定ソフトのバージョンのコードを返します。
     *
     * @return 厚労省認定ソフトのバージョンのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 厚労省認定ソフトのバージョンの名称を返します。
     *
     * @return 厚労省認定ソフトのバージョンの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 厚労省認定ソフトのバージョンのコードと一致する内容を探します。
     *
     * @param code 厚労省認定ソフトのバージョンのコード
     * @return {@code code} に対応する厚労省認定ソフトのバージョン
     */
    public static KoroshoIfShikibetsuCode toValue(RString code) {

        for (KoroshoIfShikibetsuCode koroshoIfShikibetsuCode : KoroshoIfShikibetsuCode.values()) {
            if (koroshoIfShikibetsuCode.code.equals(code)) {
                return koroshoIfShikibetsuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("厚労省認定ソフトのバージョン"));
    }

    /**
     * 指定のコードに対応するオブジェクトが存在する場合{@code true}を返却します。
     *
     * @param code コード
     * @return 指定のコードに対応するオブジェクトが存在する場合{@code true}. しない場合、{@code false}.
     */
    public static boolean existsCode(RString code) {
        for (KoroshoIfShikibetsuCode value : values()) {
            if (Objects.equals(value.code, code)) {
                return true;
            }
        }
        return false;
    }
}
