/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.meishofuyo;

import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.MeishoFuyoType;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛先の名称に付与する接尾詞型の敬称を表す列挙型です。
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public enum MeishoFuyoTypeEnum {

    /**
     * 「様」を宛先の名称に付与します。
     */
    様("1", MeishoFuyoType.様),
    /**
     * 無し
     */
    無し("0", MeishoFuyoType.無し);
    private final RString code;
    private final MeishoFuyoType meishoFuyoType;

    private MeishoFuyoTypeEnum(String code, MeishoFuyoType meishoFuyoType) {
        this.meishoFuyoType = meishoFuyoType;
        this.code = new RString(code);
    }

    /**
     * Codeを取得
     *
     * @return Code
     */
    public RString getCode() {
        return code;
    }

    /**
     * 宛先の名称に付与する接尾詞型の敬称を返します。
     *
     * @return 宛先の名称に付与する接尾詞型の敬称
     */
    public MeishoFuyoType getMeishoFuyoType() {
        return meishoFuyoType;
    }
}
