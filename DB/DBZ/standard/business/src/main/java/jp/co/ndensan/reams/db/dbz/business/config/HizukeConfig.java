/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysHizuke;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 日付のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class HizukeConfig {

    private final Map<ConfigKeysHizuke, RString> configs;

    /**
     * コンストラクタです。
     */
    public HizukeConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public HizukeConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysHizuke, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysHizuke, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHizuke target : ConfigKeysHizuke.values()) {
            map.put(target, businessConfig.get(target, nowDate));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysHizuke key) {
        return configs.get(key);
    }

    /**
     * 日付関連_調定年度を返します。
     *
     * @return 日付関連_調定年度
     * @throws SystemException 日付関連_調定年度がnullの場合
     */
    public FlexibleYear get調定年度() throws SystemException {
        RString data = get(ConfigKeysHizuke.日付関連_調定年度);
        if (data == null) {
            throw new SystemException(UrSystemErrorMessages.値がnull.getReplacedMessage("日付関連_調定年度"));
        }
        return new FlexibleYear(data);
    }

    /**
     * 日付関連_所得年度を返します。
     *
     * @return 日付関連_所得年度
     * @throws SystemException 日付関連_所得年度がnullの場合
     */
    public FlexibleYear get所得年度() throws SystemException {
        RString data = get(ConfigKeysHizuke.日付関連_所得年度);
        if (data == null) {
            throw new SystemException(UrSystemErrorMessages.値がnull.getReplacedMessage("日付関連_所得年度"));
        }
        return new FlexibleYear(data);
    }

    /**
     * 日付関連_当初年度を返します。
     *
     * @return 日付関連_当初年度
     * @throws SystemException 日付関連_当初年度がnullの場合
     */
    public FlexibleYear get当初年度() throws SystemException {
        RString data = get(ConfigKeysHizuke.日付関連_当初年度);
        if (data == null) {
            throw new SystemException(UrSystemErrorMessages.値がnull.getReplacedMessage("日付関連_当初年度"));
        }
        return new FlexibleYear(data);
    }

    /**
     * 日付関連_遡及年度を返します。
     *
     * @return 日付関連_遡及年度
     * @throws SystemException 日付関連_遡及年度がnullの場合
     */
    public FlexibleYear get遡及年度() throws SystemException {
        RString data = get(ConfigKeysHizuke.日付関連_遡及年度);
        if (data == null) {
            throw new SystemException(UrSystemErrorMessages.値がnull.getReplacedMessage("日付関連_遡及年度"));
        }
        return new FlexibleYear(data);
    }
}
