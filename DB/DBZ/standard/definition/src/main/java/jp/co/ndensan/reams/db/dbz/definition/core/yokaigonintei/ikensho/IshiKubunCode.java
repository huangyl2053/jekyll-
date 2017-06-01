/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医師区分コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum IshiKubunCode {

    /**
     * コード:1 名称:主治医 略称:定義なし
     */
    主治医("1", "主治医"),
    /**
     * コード:2 名称:指定医 略称:定義なし
     */
    指定医("2", "指定医");

    private final RString code;
    private final RString fullName;

    private IshiKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 医師区分コードのコードを返します。
     *
     * @return 医師区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 医師区分コードの名称を返します。
     *
     * @return 医師区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 医師区分コードのコードと一致する内容を探します。
     *
     * @param code 医師区分コードのコード
     * @return {@code code} に対応する医師区分コード
     */
    public static IshiKubunCode toValue(RString code) {

        for (IshiKubunCode ishiKubunCode : IshiKubunCode.values()) {
            if (ishiKubunCode.code.equals(code)) {
                return ishiKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("医師区分コード"));
    }

    /**
     * @param code コード
     * @return 指定のコードが存在する場合、{@code true}.
     */
    public static boolean existsCode(RString code) {
        for (IshiKubunCode ishiKubunCode : IshiKubunCode.values()) {
            if (ishiKubunCode.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}
