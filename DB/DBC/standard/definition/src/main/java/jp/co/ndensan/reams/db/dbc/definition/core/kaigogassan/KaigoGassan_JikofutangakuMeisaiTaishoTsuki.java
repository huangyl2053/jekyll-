/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_自己負担額明細対象月を表す列挙型です。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public enum KaigoGassan_JikofutangakuMeisaiTaishoTsuki {

    /**
     * コード:004 名称:対象年度4月 略称:対象年度4月
     */
    対象年度4月("004", "対象年度4月", "対象年度4月"),
    /**
     * コード:005 名称:対象年度5月 略称:対象年度5月
     */
    対象年度5月("005", "対象年度5月", "対象年度5月"),
    /**
     * コード:006 名称:対象年度6月 略称:対象年度6月
     */
    対象年度6月("006", "対象年度6月", "対象年度6月"),
    /**
     * コード:007 名称:対象年度7月 略称:対象年度7月
     */
    対象年度7月("007", "対象年度7月", "対象年度7月"),
    /**
     * コード:008 名称:対象年度8月 略称:対象年度8月
     */
    対象年度8月("008", "対象年度8月", "対象年度8月"),
    /**
     * コード:009 名称:対象年度9月 略称:対象年度9月
     */
    対象年度9月("009", "対象年度9月", "対象年度9月"),
    /**
     * コード:010 名称:対象年度10月 略称:対象年度10月
     */
    対象年度10月("010", "対象年度10月", "対象年度10月"),
    /**
     * コード:011 名称:対象年度11月 略称:対象年度11月
     */
    対象年度11月("011", "対象年度11月", "対象年度11月"),
    /**
     * コード:012 名称:対象年度12月 略称:対象年度12月
     */
    対象年度12月("012", "対象年度12月", "対象年度12月"),
    /**
     * コード:101 名称:対象年度翌年1月 略称:対象年度翌年1月
     */
    対象年度翌年1月("101", "対象年度翌年1月", "対象年度翌年1月"),
    /**
     * コード:102 名称:対象年度翌年2月 略称:対象年度翌年2月
     */
    対象年度翌年2月("102", "対象年度翌年2月", "対象年度翌年2月"),
    /**
     * コード:103 名称:対象年度翌年3月 略称:対象年度翌年3月
     */
    対象年度翌年3月("103", "対象年度翌年3月", "対象年度翌年3月"),
    /**
     * コード:104 名称:対象年度翌年4月 略称:対象年度翌年4月
     */
    対象年度翌年4月("104", "対象年度翌年4月", "対象年度翌年4月"),
    /**
     * コード:105 名称:対象年度翌年5月 略称:対象年度翌年5月
     */
    対象年度翌年5月("105", "対象年度翌年5月", "対象年度翌年5月"),
    /**
     * コード:106 名称:対象年度翌年6月 略称:対象年度翌年6月
     */
    対象年度翌年6月("106", "対象年度翌年6月", "対象年度翌年6月"),
    /**
     * コード:107 名称:対象年度翌年7月 略称:対象年度翌年7月
     */
    対象年度翌年7月("107", "対象年度翌年7月", "対象年度翌年7月");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private KaigoGassan_JikofutangakuMeisaiTaishoTsuki(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 介護合算_自己負担額明細対象月のコードを返します。
     *
     * @return 介護合算_自己負担額明細対象月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_自己負担額明細対象月の名称を返します。
     *
     * @return 介護合算_自己負担額明細対象月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_自己負担額明細対象月の名称を返します。
     *
     * @return 介護合算_自己負担額明細対象月の名称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 介護合算_自己負担額明細対象月のコードと一致する内容を探します。
     *
     * @param code 介護合算_自己負担額明細対象月のコード
     * @return {@code code} に対応する介護合算_自己負担額明細対象月
     */
    public static KaigoGassan_JikofutangakuMeisaiTaishoTsuki toValue(RString code) {

        for (KaigoGassan_JikofutangakuMeisaiTaishoTsuki dataSaisoFlag : KaigoGassan_JikofutangakuMeisaiTaishoTsuki.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_自己負担額明細対象月"));
    }
}
