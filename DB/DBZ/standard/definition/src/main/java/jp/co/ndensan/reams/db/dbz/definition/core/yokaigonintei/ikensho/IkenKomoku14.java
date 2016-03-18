/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容14を表す列挙型です。
 *
 *
 */
public enum IkenKomoku14 {

    /**
     * コード:1 名称:自立ないし何とか自分で食べられる 略称:定義なし
     */
    自立ないし何とか自分で食べられる("1", "自立ないし何とか自分で食べられる"),
    /**
     * コード:2 名称:全面介助 略称:定義なし
     */
    全面介助("2", "全面介助"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku14(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容14のコードを返します。
     *
     * @return 意見書項目内容14のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容14の名称を返します。
     *
     * @return 意見書項目内容14の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容14のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容14のコード
     * @return {@code code} に対応する意見書項目内容14
     */
    public static IkenKomoku14 toValue(RString code) {
        for (IkenKomoku14 ikenKomoku14 : IkenKomoku14.values()) {
            if (ikenKomoku14.code.equals(code)) {
                return ikenKomoku14;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容14"));
    }
}
