/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 所得引出コンフィグを取得するためのクラスです。
 */
public class ShotokuHikidashiConfig {

    private final Map<ConfigKeysShotokuHikidashi, RString> configs;

    /**
     * コンストラクタです。
     */
    public ShotokuHikidashiConfig() {
        this.configs = getValue(RDate.getNowDate());
    }

    /**
     * コンストラクタです。指定した有効日でコンフィグを取得します。
     *
     * @param effectiveDate 有効日
     */
    public ShotokuHikidashiConfig(RDate effectiveDate) {
        requireNonNull(effectiveDate, UrSystemErrorMessages.値がnull.getReplacedMessage("適用基準日"));
        this.configs = getValue(effectiveDate);
    }

    /**
     * 所得引出_住民税減免前後表示区分に関する業務コンフィグを取得します。
     *
     * @return RString 所得引出_住民税減免前後表示区分に関する業務コンフィグの値
     */
    public RString get所得引出_住民税減免前後表示区分() {
        return configs.get(ConfigKeysShotokuHikidashi.所得引出_住民税減免前後表示区分);
    }

    /**
     * 所得引出_64歳未満所得金額表示区分に関する業務コンフィグを取得します。
     *
     * @return RString 所得引出_64歳未満所得金額表示区分に関する業務コンフィグの値
     */
    public RString get所得引出_64歳未満所得金額表示区分() {
        return configs.get(ConfigKeysShotokuHikidashi.所得引出_６４歳未満所得金額表示区分);
    }

    private Map<ConfigKeysShotokuHikidashi, RString> getValue(RDate effectiveDate) {
        Map<ConfigKeysShotokuHikidashi, RString> map = new HashMap();
        for (ConfigKeysShotokuHikidashi target : ConfigKeysShotokuHikidashi.values()) {
            map.put(target, BusinessConfig.get(target, effectiveDate, SubGyomuCode.DBB介護賦課));
        }
        return map;
    }

}
