/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 徴収方法クラスです。
 *
 * @reamsid_L DBB-9999-022 zhaowei
 */
public enum ChoshuHoho {

    /**
     * コード:1 名称:全て 略称:定義なし
     */
    全て("1", "全て"),
    /**
     * コード:2 名称:特徴のみ 略称:定義なし
     */
    特徴のみ("2", "特徴のみ"),
    /**
     * コード:3 名称:普徴のみ 略称:定義なし
     */
    普徴のみ("3", "普徴のみ"),
    /**
     * コード:4 名称:併徴者のみ 略称:定義なし
     */
    併徴者のみ("4", "併徴者のみ"),
    /**
     * コード:5 名称:前半普徴・後半特徴 略称:定義なし
     */
    前半普後半特("5", "前半普徴・後半特徴");

    private final RString code;
    private final RString fullName;

    private ChoshuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 徴収方法のコードを返します。
     *
     * @return 徴収方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 徴収方法の名称を返します。
     *
     * @return 徴収方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 徴収方法のコードと一致する内容を探します。
     *
     * @param code 徴収方法のコード
     * @return {@code code} に対応する徴収方法
     */
    public static ChoshuHoho toValue(RString code) {
        for (ChoshuHoho choshuHoho : ChoshuHoho.values()) {
            if (choshuHoho.code.equals(code)) {
                return choshuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("徴収方法"));
    }
}
