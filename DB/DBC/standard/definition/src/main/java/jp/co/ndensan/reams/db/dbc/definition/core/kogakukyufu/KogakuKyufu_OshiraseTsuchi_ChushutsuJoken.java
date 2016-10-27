/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakukyufu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額給付_お知らせ通知_抽出条件を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhujun
 */
public enum KogakuKyufu_OshiraseTsuchi_ChushutsuJoken {

    /**
     * コード:1 名称:審査年月 略称:定義なし
     */
    審査年月("1", "審査年月"),
    /**
     * コード:2 名称:被保険者番号 略称:定義なし
     */
    被保険者番号("2", "被保険者番号"),
    /**
     * コード:3 名称:白紙印刷 略称:定義なし
     */
    白紙("3", "白紙");
    private final RString code;
    private final RString fullName;

    private KogakuKyufu_OshiraseTsuchi_ChushutsuJoken(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額給付_お知らせ通知_抽出条件のコードを返します。
     *
     * @return 高額給付_お知らせ通知_抽出条件のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額給付_お知らせ通知_抽出条件の名称を返します。
     *
     * @return 高額給付_お知らせ通知_抽出条件の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額給付_お知らせ通知_抽出条件のコードと一致する内容を探します。
     *
     * @param code 高額給付_お知らせ通知_抽出条件のコード
     * @return {@code code} に対応する高額給付_お知らせ通知_抽出条件
     */
    public static KogakuKyufu_OshiraseTsuchi_ChushutsuJoken toValue(RString code) {

        for (KogakuKyufu_OshiraseTsuchi_ChushutsuJoken shiharaiHohoKubun : KogakuKyufu_OshiraseTsuchi_ChushutsuJoken.values()) {
            if (shiharaiHohoKubun.code.equals(code)) {
                return shiharaiHohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額給付_お知らせ通知_抽出条件"));
    }
}
