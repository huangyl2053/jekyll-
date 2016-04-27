/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請理由区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ShinseiRiyuKubun {

    /**
     * コード:01 名称:世帯非課税８０万以下 略称:なし
     */
    世帯非課税８０万以下("01", "世帯非課税８０万以下"),
    /**
     * コード:02 名称:世帯非課税８０万超　略称:なし
     */
    世帯非課税８０万超("02", "世帯非課税８０万超　"),
    /**
     * コード:03 名称:生保 略称:なし
     */
    生保("03", "生保"),
    /**
     * コード:04 名称:世帯非課税 略称:なし
     */
    世帯非課税("04", "世帯非課税"),
    /**
     * コード:05 名称:老齢 略称:なし
     */
    老齢("05", "老齢"),
    /**
     * コード:06 名称:特例減額措置 略称:なし
     */
    特例減額措置("06", "特例減額措置"),
    /**
     * コード:99 名称:その他 略称:なし
     */
    その他("99", "その他");

    private final RString fullName;
    private final RString code;

    private ShinseiRiyuKubun(String code, String fullname) {
        this.fullName = new RString(fullname);
        this.code = new RString(code);
    }

    /**
     * 申請理由区分の名称を返します。
     *
     * @return 申請理由区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請理由区分のコードを返します。
     *
     * @return 申請理由区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請理由区分のコードと一致する内容を探します。
     *
     * @param code 申請理由区分のコード
     * @return {@code code} に対応する申請理由区分
     */
    public static ShinseiRiyuKubun toValue(RString code) {
        for (ShinseiRiyuKubun shinseiRiyuKubun : ShinseiRiyuKubun.values()) {
            if (shinseiRiyuKubun.code.equals(code)) {
                return shinseiRiyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請理由区分"));
    }
}
