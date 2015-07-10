/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの支払方法変更の終了分記載区分の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ShiharaiHohoHenkoShuryobunKisaiKubun {

    /**
     * 支払方法変更の終了分記載区分が「終了後は記載しない」であることを表します。<br />
     * コード : 0
     */
    終了後は記載しない("0"),
    /**
     * 支払方法変更の終了分記載区分が「終了後も記載する」であることを表します。<br />
     * コード : 1
     */
    終了後も記載する("1");

    private final RString theCode;

    private ShiharaiHohoHenkoShuryobunKisaiKubun(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return 終了分記載区分
     */
    public RString code() {
        return theCode;
    }

    /**
     * 引数のコードに対応する{@link ShiharaiHohoHenkoShuryobunKisaiKubun}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link ShiharaiHohoHenkoShuryobunKisaiKubun}
     * @throws IllegalArgumentException
     * コードに対応する{@link ShiharaiHohoHenkoShuryobunKisaiKubun}が無い時
     */
    public static ShiharaiHohoHenkoShuryobunKisaiKubun toValue(RString code) {
        for (ShiharaiHohoHenkoShuryobunKisaiKubun data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(HihokenshashoItakudaikoHyoji.class.getSimpleName()));
    }

}
