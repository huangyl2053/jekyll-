/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容12を表す列挙型です。
 *
 *
 */
public enum IkenKomoku12 {

    /**
     * コード:1 名称:用いていない 略称:定義なし
     */
    用いていない("1", "用いていない"),
    /**
     * コード:2 名称:主に自分で操作している 略称:定義なし
     */
    主に自分で操作している("2", "主に自分で操作している"),
    /**
     * コード:3 名称:主に他人が操作している 略称:定義なし
     */
    主に他人が操作している("3", "主に他人が操作している"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku12(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容12のコードを返します。
     *
     * @return 意見書項目内容12のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容12の名称を返します。
     *
     * @return 意見書項目内容12の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容12のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容12のコード
     * @return {@code code} に対応する意見書項目内容12
     */
    public static IkenKomoku12 toValue(RString code) {
        for (IkenKomoku12 ikenKomoku12 : IkenKomoku12.values()) {
            if (ikenKomoku12.code.equals(code)) {
                return ikenKomoku12;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容12"));
    }
}
