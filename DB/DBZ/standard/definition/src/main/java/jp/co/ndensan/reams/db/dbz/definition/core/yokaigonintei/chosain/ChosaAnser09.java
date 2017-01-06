/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容09
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser09 {

    /**
     * コード:1 名称:普通 略称:普通
     */
    普通("1", "普通", "普通"),
    /**
     * コード:2 名称:普通の声がやっと聞き取れる 略称:やっと聞こえる
     */
    普通の声がやっと聞き取れる("2", "普通の声がやっと聞き取れる", "やっと聞こえる"),
    /**
     * コード:3 名称:かなり大きな声なら何とか聞き取れる 略称:大声が聞こえる
     */
    かなり大きな声なら何とか聞き取れる("3", "かなり大きな声なら何とか聞き取れる", "大声が聞こえる"),
    /**
     * コード:4 名称:ほとんど聞こえない 略称:ほとんど聞こえない
     */
    ほとんど聞こえない("4", "ほとんど聞こえない", "ほとんど聞こえず"),
    /**
     * コード:5 名称:聞こえているのか判断不能 略称:判断不能
     */
    聞こえているのか判断不能("5", "聞こえているのか判断不能", "判断不能");
    private final RString code;
    private final RString fullName;
    private final RString ryakusho;

    private ChosaAnser09(String code, String fullname, String ryakusho) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * 認定調査項目内容09のコードを返します。
     *
     * @return 認定調査項目内容09のコード
     */
    public RString getコード() {
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
     * 認定調査項目内容09の略称を返します。
     *
     * @return 認定調査項目内容09の略称
     */
    public RString get略称() {
        return ryakusho;
    }

    /**
     * 認定調査項目内容09のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容09のコード
     * @return {@code code} に対応する認定調査項目内容09
     */
    public static ChosaAnser09 toValue(RString code) {
        for (ChosaAnser09 anser09 : ChosaAnser09.values()) {
            if (anser09.code.equals(code)) {
                return anser09;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容09"));
    }
}
