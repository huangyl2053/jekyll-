/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モバイルデータ出力フラグを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum MobileDataShutsuryokuFlag {

    /**
     * コード:0 名称:未出力 略称:定義なし
     */
    未出力(false, "未出力"),
    /**
     * コード:1 名称:出力済 略称:定義なし
     */
    出力済(true, "出力済");

    private final boolean code;
    private final RString fullName;

    private MobileDataShutsuryokuFlag(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * モバイルデータ出力フラグのコードを返します。
     *
     * @return モバイルデータ出力フラグのコード
     */
    public boolean isモバイルデータ出力() {
        return code;
    }

    /**
     * モバイルデータ出力フラグの名称を返します。
     *
     * @return モバイルデータ出力フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * モバイルデータ出力フラグのコードと一致する内容を探します。
     *
     * @param code モバイルデータ出力フラグのコード
     * @return {@code code} に対応するモバイルデータ出力フラグ
     */
    public static MobileDataShutsuryokuFlag toValue(boolean code) {

        for (MobileDataShutsuryokuFlag mobileDataShutsuryokuFlag : MobileDataShutsuryokuFlag.values()) {
            if (mobileDataShutsuryokuFlag.code == code) {
                return mobileDataShutsuryokuFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("モバイルデータ出力フラグ"));
    }
}
