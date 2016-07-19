/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBC110065_基準収入額適用申請書_異動分作成するクラスです。
 *
 * @reamsid_L DBC-4640-070 liuxiaoyu
 */
public class TekiyoShinseishoManager {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public TekiyoShinseishoManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return TekiyoShinseishoManager
     * {@link InstanceProvider#create}にて生成した{@link TekiyoShinseishoManager}のインスタンス
     */
    public static TekiyoShinseishoManager createInstance() {
        return InstanceProvider.create(TekiyoShinseishoManager.class);
    }

    /**
     * 年次処理実施判定メソッドです。
     *
     * @param 年度 FlexibleYear
     * @return boolean 判定区分
     */
    public boolean isNenjiExecute(FlexibleYear 年度) {

        if (0 < dac.select処理日付管理マスタ(年度)) {
            return true;
        }
        return false;
    }
}
