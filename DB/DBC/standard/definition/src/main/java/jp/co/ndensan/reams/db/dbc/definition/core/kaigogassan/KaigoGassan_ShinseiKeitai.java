/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_支給申請形態を表す列挙型です。
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public enum KaigoGassan_ShinseiKeitai {

    /**
     * コード:1 名称:計算期間末日以降申請　（期間中死亡・生保適用・海外移住者なし） 略称:期間中死亡・生保適用・海外移住者なし
     */
    計算期間末日以降申請期間中死亡生保適用海外移住者なし("1", "計算期間末日以降申請　（期間中死亡・生保適用・海外移住者なし）", "期間中死亡・生保適用・海外移住者なし"),
    /**
     * コード:2 名称:計算期間末日以降申請　（期間中死亡者あり） 略称:期間中死亡者あり
     */
    計算期間末日以降申請期間中死亡者あり("2", "計算期間末日以降申請　（期間中死亡者あり）", "期間中死亡者あり"),
    /**
     * コード:3 名称:計算期間末日以降申請　（期間中生保適用・海外移住者あり） 略称:期間中生保適用・海外移住者あり
     */
    計算期間末日以降申請期間中生保適用海外移住者あり("3", "計算期間末日以降申請　（期間中生保適用・海外移住者あり）", "期間中生保適用・海外移住者あり"),
    /**
     * コード:4 名称:期間中生保適用・海外移住者あり 略称:期間中生保適用・海外移住者あり
     */
    期間中生保適用海外移住者あり("4", "期間中生保適用・海外移住者あり", "期間中生保適用・海外移住者あり");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KaigoGassan_ShinseiKeitai(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 介護合算_支給申請形態のコードを返します。
     *
     * @return 介護合算_支給申請形態のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_支給申請形態の名称を返します。
     *
     * @return 介護合算_支給申請形態の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_支給申請形態の略称を返します。
     *
     * @return 介護合算_支給申請形態の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 介護合算_支給申請形態のコードと一致する内容を探します。
     *
     * @param code 介護合算_支給申請形態のコード
     * @return {@code code} に対応する介護合算_支給申請形態
     */
    public static KaigoGassan_ShinseiKeitai toValue(RString code) {
        for (KaigoGassan_ShinseiKeitai kaigogassanidokubun : KaigoGassan_ShinseiKeitai.values()) {
            if (kaigogassanidokubun.code.equals(code)) {
                return kaigogassanidokubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_支給申請形態"));
    }
}
