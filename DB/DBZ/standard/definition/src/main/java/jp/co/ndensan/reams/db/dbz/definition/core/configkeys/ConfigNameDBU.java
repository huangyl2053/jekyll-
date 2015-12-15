package jp.co.ndensan.reams.db.dbz.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ名称(DBU)を表す列挙型です。
 *
 * @author LDNS
 */
public enum ConfigNameDBU {

    /**
     * コード:無し 名称:保険者情報_保険者構成 略称:定義なし
     */
    保険者情報_保険者構成("保険者情報_保険者構成"),
    /**
     * コード:無し 名称:合併情報管理_合併情報区分 略称:定義なし
     */
    合併情報管理_合併情報区分("合併情報管理_合併情報区分");

    private final RString fullName;

    private ConfigNameDBU(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBU)の名称を返します。
     *
     * @return コンフィグ名称(DBU)の名称
     */
    public RString get名称() {
        return fullName;
    }

}
