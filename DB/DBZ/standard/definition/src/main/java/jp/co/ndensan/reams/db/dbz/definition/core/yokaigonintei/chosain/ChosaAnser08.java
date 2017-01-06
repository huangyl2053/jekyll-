/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容08
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser08 {

    /**
     * コード:1 名称:普通（日常生活に支障がない） 略称:普通_日常生活に支障がない
     */
    普通_日常生活に支障がない("1", "普通（日常生活に支障がない）", "普通（日常生活に支障がない）"),
    /**
     * コード:2 名称:約1ｍ離れた視力確認表の図が見える 略称:１ｍ先が見える
     */
    約1ｍ離れた視力確認表の図が見える("2", "約1ｍ離れた視力確認表の図が見える", "１ｍ先が見える"),
    /**
     * コード:3 名称:目の前に置いた視力確認表の図が見える 略称:目の前が見える
     */
    目の前に置いた視力確認表の図が見える("3", "目の前に置いた視力確認表の図が見える", "目の前が見える"),
    /**
     * コード:4 名称:ほとんど見えない 略称:ほとんど見えず
     */
    ほとんど見えない("4", "ほとんど見えない", "ほとんど見えず"),
    /**
     * コード:5 名称:見えているのか判断不能 略称:判断不能
     */
    見えているのか判断不能("5", "見えているのか判断不能", "判断不能");
    private final RString code;
    private final RString fullName;
    private final RString ryakusho;

    private ChosaAnser08(String code, String fullname, String ryakusho) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * 認定調査項目内容08のコードを返します。
     *
     * @return 認定調査項目内容08のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容08の名称を返します。
     *
     * @return 認定調査項目内容08の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容08の略称を返します。
     *
     * @return 認定調査項目内容08の略称
     */
    public RString get略称() {
        return ryakusho;
    }

    /**
     * 認定調査項目内容08のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容08のコード
     * @return {@code code} に対応する認定調査項目内容08
     */
    public static ChosaAnser08 toValue(RString code) {
        for (ChosaAnser08 anser08 : ChosaAnser08.values()) {
            if (anser08.code.equals(code)) {
                return anser08;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容08"));
    }
}
