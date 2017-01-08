/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅/施設区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ZaitakuShisetsuKubun {

    /**
     * コード:1 名称:在宅 略称:定義なし
     */
    在宅("1", "在宅"),
    /**
     * コード:2 名称:施設 略称:定義なし
     */
    施設("2", "施設");

    private final RString codeValue;
    private final Code code;
    private final RString fullName;

    private ZaitakuShisetsuKubun(String code, String fullname) {
        this.codeValue = new RString(code);
        this.fullName = new RString(fullname);
        this.code = new Code(code);
    }

    /**
     * 在宅/施設区分のコードを返します。
     *
     * @return 在宅/施設区分のコード
     */
    public RString getコード() {
        return codeValue;
    }

    /**
     * 在宅/施設区分のコードを{@link Code}型で返します。
     *
     * @return 在宅/施設区分のコード（{@link Code}型）
     */
    public Code getCode() {
        return code;
    }

    /**
     * 在宅/施設区分の名称を返します。
     *
     * @return 在宅/施設区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅/施設区分のコードと一致する内容を探します。
     *
     * @param code 在宅/施設区分のコード
     * @return {@code code} に対応する在宅/施設区分
     */
    public static ZaitakuShisetsuKubun toValue(RString code) {

        for (ZaitakuShisetsuKubun zaitakuShisetsuKubun : ZaitakuShisetsuKubun.values()) {
            if (zaitakuShisetsuKubun.codeValue.equals(code)) {
                return zaitakuShisetsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅/施設区分"));
    }
}
