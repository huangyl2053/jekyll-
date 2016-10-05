/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 処理日付管理マスタを管理するクラスです。
 *
 * @reamsid_L DBB-9999-022 xuxin
 */
public class ShoriDateKanriManager {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public ShoriDateKanriManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7022ShoriDateKanriDac}
     */
    ShoriDateKanriManager(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShoriDateKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShoriDateKanriManager}のインスタンス
     */
    public static ShoriDateKanriManager createInstance() {
        return InstanceProvider.create(ShoriDateKanriManager.class);
    }

    /**
     * 最大基準日時の取得です。
     *
     * @param 賦課年度 FlexibleYear
     * @return ShoriDateKanri
     */
    public ShoriDateKanri get最大基準日時(FlexibleYear 賦課年度) {

        DbT7022ShoriDateKanriEntity entity = dac.get最大基準日時(賦課年度);
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }

}
