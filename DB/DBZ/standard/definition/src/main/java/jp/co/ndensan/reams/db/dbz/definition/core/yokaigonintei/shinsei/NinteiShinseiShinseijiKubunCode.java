/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分（申請時）コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum NinteiShinseiShinseijiKubunCode {

    /**
     * コード:1 名称:新規申請 略称:新規
     */
    新規申請("1", "新規申請", "新規"),
    /**
     * コード:2 名称:更新申請 略称:更新
     */
    更新申請("2", "更新申請", "更新"),
    /**
     * コード:3 名称:区分変更申請 略称:区変
     */
    区分変更申請("3", "区分変更申請", "区変"),
    /**
     * コード:4 名称:職権 略称:職権
     */
    職権("4", "職権", "職権"),
    /**
     * コード:5 名称:転入申請 略称:転入
     */
    転入申請("5", "転入申請", "転入"),
    /**
     * コード:6 名称:資格喪失（死亡） 略称:喪失
     */
    資格喪失_死亡("6", "資格喪失（死亡）", "喪失"),
    /**
     * コード:A 名称:新規申請（事前） 略称:定義なし
     */
    新規申請_事前("A", "新規申請（事前）", ""),
    /**
     * コード:B 名称:更新申請（事前） 略称:定義なし
     */
    更新申請_事前("B", "更新申請（事前）", "");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private NinteiShinseiShinseijiKubunCode(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 申請区分（申請時）コードを返します。
     *
     * @return 申請区分（申請時）コード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請区分（申請時）コードの名称を返します。
     *
     * @return 申請区分（申請時）コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請区分（申請時）コードの略称を返します。
     *
     * @return 申請区分（申請時）コードの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 申請区分（申請時）コードと一致する内容を探します。
     *
     * @param code 申請区分（申請時）コード
     * @return {@code code} に対応する申請区分（申請時）コード
     */
    public static NinteiShinseiShinseijiKubunCode toValue(RString code) {
        NinteiShinseiShinseijiKubunCode value = toValueOrNull(code);
        if (value == null) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分（申請時）コード"));
        }
        return value;
    }

    private static NinteiShinseiShinseijiKubunCode toValueOrNull(RString code) {
        for (NinteiShinseiShinseijiKubunCode kubunCode : NinteiShinseiShinseijiKubunCode.values()) {
            if (kubunCode.code.equals(code)) {
                return kubunCode;
            }
        }
        return null;
    }
    
    /**
     * 申請区分（申請時）名称と一致する内容の検索。
     * 
     * @param name 申請区分（申請時）名称
     * @return {@name name} に対応する申請区分（申請時）コード
     */
    public static NinteiShinseiShinseijiKubunCode toName(String name) {
        NinteiShinseiShinseijiKubunCode value = toNameOrNull(name);
        if (value == null) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分（申請時）名称"));
        }
        return value;
    }
    
    private static NinteiShinseiShinseijiKubunCode toNameOrNull(String name) {
        for (NinteiShinseiShinseijiKubunCode kubunCode : NinteiShinseiShinseijiKubunCode.values()) {
            if (kubunCode.fullName.equals(new RString(name))) {
                return kubunCode;
            }
        }
        return null;
    }

    /**
     * 第1引数のコードから名称を取得して返却します。
     * コードに対応する要素が無い場合は、第2引数の値を返します。
     *
     * @param code コード
     * @param defaultValue コードに該当する要素が存在しなかった場合のデフォルト値
     * @return コードに該当する要素の名称.もしくは、デフォルト値.
     */
    public static RString to名称OrDefault(RString code, RString defaultValue) {
        NinteiShinseiShinseijiKubunCode value = toValueOrNull(code);
        return value == null ? defaultValue : value.get名称();
    }
}
