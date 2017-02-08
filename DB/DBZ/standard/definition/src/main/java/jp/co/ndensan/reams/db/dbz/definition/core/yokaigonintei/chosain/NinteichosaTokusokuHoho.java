/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促方法を現す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum NinteichosaTokusokuHoho {

    /**
     * 督促状郵送。
     */
    督促状郵送("0", "督促状郵送"),
    /**
     * 督促状ＦＡＸ。
     */
    督促状ＦＡＸ("1", "督促状ＦＡＸ"),
    /**
     * 電話。
     */
    電話("2", "電話"),
    /**
     * その他。
     */
    その他("3", "その他");
    private final RString 督促方法コード;
    private final RString fullName;

    private NinteichosaTokusokuHoho(String 督促方法コード, String fullname) {
        this.督促方法コード = new RString(督促方法コード);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査督促方法を現すコードを返します。
     *
     * @return 督促方法コード
     */
    public RString getCode() {
        return 督促方法コード;
    }

    /**
     * 認定調査督促方法を現すコードの名称を返します。
     *
     * @return 認定調査督促方法コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 引数から渡されたコードに対応した、認定調査督促方法を返します。
     *
     * @param 督促方法コード 認定調査督促方法を現すコード
     * @return 対応した認定調査督促方法
     * @throws IllegalArgumentException 対応する認定調査督促方法が存在しなかったとき
     */
    public static NinteichosaTokusokuHoho toValue(RString 督促方法コード) throws IllegalArgumentException {
        for (NinteichosaTokusokuHoho hoho : values()) {
            if (hoho.getCode().equals(督促方法コード)) {
                return hoho;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定調査督促方法").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定調査督促方法").getMessage());
    }
}
