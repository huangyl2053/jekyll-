/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 日付のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class HizukeConfig {

    private final Map<ConfigKeysHizuke, RString> configs;
    private static final int JUUNI = 12;

    /**
     * コンストラクタです。
     */
    public HizukeConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysHizuke, RString> createMap() {
        Map<ConfigKeysHizuke, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHizuke target : ConfigKeysHizuke.values()) {
            map.put(target, BusinessConfig.get(target, nowDate, SubGyomuCode.DBB介護賦課));
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

    /**
     * 日付関連_月別テーブル1を返します。
     *
     * @return 日付関連_月別テーブル1
     */
    public RString get月別テーブル1() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル1);
    }

    /**
     * 日付関連_月別テーブル2を返します。
     *
     * @return 日付関連_月別テーブル2
     */
    public RString get月別テーブル2() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル2);
    }

    /**
     * 日付関連_月別テーブル3を返します。
     *
     * @return 日付関連_月別テーブル3
     */
    public RString get月別テーブル3() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル3);
    }

    /**
     * 日付関連_月別テーブル4を返します。
     *
     * @return 日付関連_月別テーブル4
     */
    public RString get月別テーブル4() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル4);
    }

    /**
     * 日付関連_月別テーブル5を返します。
     *
     * @return 日付関連_月別テーブル5
     */
    public RString get月別テーブル5() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル5);
    }

    /**
     * 日付関連_月別テーブル6を返します。
     *
     * @return 日付関連_月別テーブル6
     */
    public RString get月別テーブル6() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル6);
    }

    /**
     * 日付関連_月別テーブル7を返します。
     *
     * @return 日付関連_月別テーブル7
     */
    public RString get月別テーブル7() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル7);
    }

    /**
     * 日付関連_月別テーブル8を返します。
     *
     * @return 日付関連_月別テーブル8
     */
    public RString get月別テーブル8() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル8);
    }

    /**
     * 日付関連_月別テーブル9を返します。
     *
     * @return 日付関連_月別テーブル9
     */
    public RString get月別テーブル9() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル9);
    }

    /**
     * 日付関連_月別テーブル10を返します。
     *
     * @return 日付関連_月別テーブル10
     */
    public RString get月別テーブル10() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル10);
    }

    /**
     * 日付関連_月別テーブル11を返します。
     *
     * @return 日付関連_月別テーブル11
     */
    public RString get月別テーブル11() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル11);
    }

    /**
     * 日付関連_月別テーブル12を返します。
     *
     * @return 日付関連_月別テーブル12
     */
    public RString get月別テーブル12() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル12);
    }

    /**
     * 日付関連_月別テーブル13を返します。
     *
     * @return 日付関連_月別テーブル13
     */
    public RString get月別テーブル13() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル13);
    }

    /**
     * 日付関連_月別テーブル14を返します。
     *
     * @return 日付関連_月別テーブル14
     */
    public RString get月別テーブル14() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル14);
    }

    /**
     * 日付関連_月別テーブルをリストで返します。
     *
     * @return 日付関連_月別テーブル
     */
    public List<RString> get月別テーブル() {
        List<RString> list = new ArrayList<>();
        list.add(get月別テーブル1());
        list.add(get月別テーブル2());
        list.add(get月別テーブル3());
        list.add(get月別テーブル4());
        list.add(get月別テーブル5());
        list.add(get月別テーブル6());
        list.add(get月別テーブル7());
        list.add(get月別テーブル8());
        list.add(get月別テーブル9());
        list.add(get月別テーブル10());
        list.add(get月別テーブル11());

        Integer 月別テーブル12 = Integer.parseInt(get月別テーブル12().toString());
        list.add(get月別テーブル12());

        Integer 月別テーブル13 = Integer.parseInt(get月別テーブル13().toString());
        if (月別テーブル13 > JUUNI) {
            月別テーブル13 = 月別テーブル12 + 1;
            list.add(new RString(String.valueOf(月別テーブル13)));
        } else {
            list.add(get月別テーブル13());
        }

        Integer 月別テーブル14 = Integer.parseInt(get月別テーブル14().toString());
        if (月別テーブル14 > JUUNI) {
            月別テーブル14 = 月別テーブル13 + 1;
            list.add(new RString(String.valueOf(月別テーブル14)));
        } else {
            list.add(get月別テーブル14());
        }
        return list;
    }
}
