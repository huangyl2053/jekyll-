/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療費控除内容を表す列挙型です。
 * 
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public enum IryoHiKojoNaiyo {
    
    /**
     * コード:1 名称:おむつ使用証明書 略称:定義なし
     */
    おむつ使用証明書("1", "おむつ使用証明書"),
    
    /**
     * コード:2 名称:主治医意見書確認書 略称:定義なし
     */
    主治医意見書確認書("2", "主治医意見書確認書");
    
    private final RString code;
    private final RString fullName;

    private IryoHiKojoNaiyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 医療費控除内容のコードを返します。
     *
     * @return 医療費控除内容のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 医療費控除内容の名称を返します。
     *
     * @return 医療費控除内容の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 医療費控除内容のコードと一致する内容を探します。
     *
     * @param code 医療費控除内容のコード
     * @return {@code code} に対応する対象リスト
     */
    public static IryoHiKojoNaiyo toValue(RString code) {
        for (IryoHiKojoNaiyo iryoHiKojoNaiyo : IryoHiKojoNaiyo.values()) {
            if (iryoHiKojoNaiyo.code.equals(code)) {
                return iryoHiKojoNaiyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("医療費控除内容"));
    }
}
