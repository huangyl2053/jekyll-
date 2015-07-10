/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys;

import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 特別徴収捕捉コンフィグを取得するためのクラスです。
 *
 * @author n3317 塚田 萌
 */
public class TokuchoHosokuConfig {

    private Map<ConfigKeysTokuchoHosoku, RString> configs;

    /**
     * コンストラクタです。
     *
     */
    public TokuchoHosokuConfig() {
        this.configs = getValue(RDate.getNowDate());
    }

    /**
     * 特別徴収捕捉に関する業務コンフィグを取得します。
     *
     * @param key ConfigKeysTokuchoHosoku 特別徴収捕捉コンフィグキー
     * @param effectiveDate RDate 適用基準日
     * @return Rstring 業務コンフィグの値
     * @throws NullPointerException 引数がnullの場合
     */
    public RString get(ConfigKeysTokuchoHosoku key, RDate effectiveDate) throws NullPointerException {
        requireNonNull(key, UrSystemErrorMessages.値がnull.getReplacedMessage("特別徴収捕捉"));
        requireNonNull(effectiveDate, UrSystemErrorMessages.値がnull.getReplacedMessage("適用基準日"));

        this.configs = getValue(effectiveDate);

        return new RString(configs.get(key).toString());
    }

    private Map<ConfigKeysTokuchoHosoku, RString> getValue(RDate effectiveDate) {

        Map<ConfigKeysTokuchoHosoku, RString> map = new HashMap();
        for (ConfigKeysTokuchoHosoku target : ConfigKeysTokuchoHosoku.values()) {
            map.put(target, BusinessConfig.get(target, effectiveDate));
        }

        return map;
    }
}
