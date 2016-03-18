/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容09
 */
public enum ChosaAnser09 {

    /**
     * コード:1 名称:普通 略称:普通
     */
    普通("1", "普通"),
    /**
     * コード:2 名称:普通の声がやっと聞き取れる 略称:普通の声がやっと聞き取れる
     */
    普通の声がやっと聞き取れる("2", "普通の声がやっと聞き取れる"),
    /**
     * コード:3 名称:かなり大きな声なら何とか聞き取れる 略称:かなり大きな声なら何とか聞き取れる
     */
    かなり大きな声なら何とか聞き取れる("3", "かなり大きな声なら何とか聞き取れる"),
    /**
     * コード:4 名称:ほとんど聞こえない 略称:ほとんど聞こえない
     */
    ほとんど聞こえない("4", "ほとんど聞こえない"),
    /**
     * コード:5 名称:聞こえているのか判断不能 略称:聞こえているのか判断不能
     */
    聞こえているのか判断不能("5", "聞こえているのか判断不能");
    private final Code code;
    private final RString fullName;

    private ChosaAnser09(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容09のコードを返します。
     *
     * @return 認定調査項目内容09のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容09の名称を返します。
     *
     * @return 認定調査項目内容09の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容09のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容09のコード
     * @return {@code code} に対応する認定調査項目内容09
     */
    public static ChosaAnser09 toValue(Code code) {
        for (ChosaAnser09 anser01 : ChosaAnser09.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容09"));
    }
}
