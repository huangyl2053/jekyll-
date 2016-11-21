/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kyufujisseki;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画作成区分コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangjie2
 */
public enum KyotakuServiceKeikakuSakuseiKubunCode {

    /**
     * コード:1 名称:居宅介護支援事業所作成 表示名称:居宅介護支援事業所作成
     */
    居宅介護支援事業所作成("1", "居宅介護支援事業所作成"),
    /**
     * コード:2 名称:自己作成 表示名称:自己作成
     */
    自己作成("2", "自己作成"),
    /**
     * コード:3 名称:介護予防支援事業所・地域包括支援センター作成 表示名称:介護予防支援事業所・地域包括支援センター作成
     */
    介護予防支援事業所_地域包括支援センター作成("3", "介護予防支援事業所・地域包括支援センター作成");

    private final RString code;
    private final RString fullName;

    private KyotakuServiceKeikakuSakuseiKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_受給者異動事由のコードを返します。
     *
     * @return 受給者IF_受給者異動事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_受給者異動事由の名称を返します。
     *
     * @return 受給者IF_受給者異動事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_受給者異動事由のコードと一致する内容を探します。
     *
     * @param code 受給者IF_受給者異動事由のコード
     * @return {@code code} に対応する受給者IF_受給者異動事由
     */
    public static KyotakuServiceKeikakuSakuseiKubunCode toValue(RString code) {

        for (KyotakuServiceKeikakuSakuseiKubunCode kyotaku : KyotakuServiceKeikakuSakuseiKubunCode.values()) {
            if (kyotaku.code.equals(code)) {
                return kyotaku;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("居宅サービス計画作成区分コード"));
    }

}
