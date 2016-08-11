/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.futanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合判定区分す列挙型です。
 *
 * @reamsid_L DBC-4990-031 pengxingyi
 */
public enum FutanWariaiHanteiKubun {

    /**
     * コード:1 名称:年次判定
     */
    年次判定("1", "年次判定"),
    /**
     * コード:2 名称:異動分判定
     */
    異動分判定("2", "異動分判定"),
    /**
     * コード:3 名称:過年度分判定
     */
    過年度分判定("3", "過年度分判定"),
    /**
     * コード:4 名称:即時更正
     */
    即時更正("4", "即時更正");

    private final RString code;
    private final RString fullName;

    private FutanWariaiHanteiKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 負担割合判定区分のコードを返します。
     *
     * @return 事業高額合算_証明書用データ区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 負担割合判定区分の名称を返します。
     *
     * @return 事業高額合算_証明書用データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 負担割合判定区分のコードと一致する内容を探します。
     *
     * @param code 住宅改修契約のコード
     * @return {@code code} に対応する住宅改修契約
     */
    public static FutanWariaiHanteiKubun toValue(RString code) {
        for (FutanWariaiHanteiKubun shoumeishoyoudatakubun : FutanWariaiHanteiKubun.values()) {
            if (shoumeishoyoudatakubun.code.equals(code)) {
                return shoumeishoyoudatakubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合判定区分"));
    }
}
