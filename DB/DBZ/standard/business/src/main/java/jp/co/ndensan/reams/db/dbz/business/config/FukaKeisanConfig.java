/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigKeysFukaKeisan;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 賦課計算のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class FukaKeisanConfig {

    private final Map<ConfigKeysFukaKeisan, RString> configs;

    private static final RString ランク有り = new RString("1");

    /**
     * コンストラクタです。
     */
    public FukaKeisanConfig() {
        this.configs = getValue(RDate.getNowDate());
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysFukaKeisan key) {
        return configs.get(key);
    }

    /**
     * 激変緩和_開始年度を返します。
     *
     * @return 激変緩和_開始年度
     */
    public FlexibleYear get激変緩和開始年度() {
        return new FlexibleYear(get(ConfigKeysFukaKeisan.激変緩和_開始年度));
    }

    /**
     * 激変緩和_終了年度を返します。
     *
     * @return 激変緩和_終了年度
     */
    public FlexibleYear get激変緩和終了年度() {
        return new FlexibleYear(get(ConfigKeysFukaKeisan.激変緩和_終了年度));
    }

    /**
     * 激変緩和期間を返します。
     *
     * @return 激変緩和期間
     */
    public Range<FlexibleYear> get激変緩和期間() {
        return new Range(get激変緩和開始年度(), get激変緩和終了年度());
    }

    /**
     * ランク管理情報_ランク有無を返します。
     *
     * @return ランク有りの場合はtrue、ランク無しの場合はfalseを返します。
     */
    public boolean isランク有り() {
        return get(ConfigKeysFukaKeisan.ランク管理情報_ランク有無).equals(ランク有り);
    }

    /**
     * ランク管理情報_ランク開始年度を返します。
     *
     * @return ランク管理情報_ランク開始年度
     */
    public FlexibleYear getランク開始年度() {
        return new FlexibleYear(get(ConfigKeysFukaKeisan.ランク管理情報_ランク開始年度));
    }

    /**
     * ランク管理情報_ランク終了年度を返します。
     *
     * @return ランク管理情報_ランク終了年度
     */
    public FlexibleYear getランク終了年度() {
        RString value = get(ConfigKeysFukaKeisan.ランク管理情報_ランク終了年度);
        return !value.isEmpty() ? new FlexibleYear(value) : FlexibleYear.MAX;
    }

    /**
     * ランク管理情報_不均一納期期限を返します。
     *
     * @return ランク管理情報_不均一納期期限
     */
    public RString get不均一納期期限() {
        return get(ConfigKeysFukaKeisan.ランク管理情報_不均一納期期限);
    }

    private Map<ConfigKeysFukaKeisan, RString> getValue(RDate effectiveDate) {
        Map<ConfigKeysFukaKeisan, RString> map = new HashMap();
        for (ConfigKeysFukaKeisan target : ConfigKeysFukaKeisan.values()) {
            map.put(target, BusinessConfig.get(target, effectiveDate, SubGyomuCode.DBB介護賦課));
        }
        return map;
    }
}
