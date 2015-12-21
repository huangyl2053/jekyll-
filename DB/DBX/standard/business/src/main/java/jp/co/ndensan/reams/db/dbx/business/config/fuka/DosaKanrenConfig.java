/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.fuka;

import jp.co.ndensan.reams.db.dbx.business.config.util.ConfigLoader;
import jp.co.ndensan.reams.db.dbx.business.config.util.Configs;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 業務コンフィグ「動作関連」を扱います。
 */
public class DosaKanrenConfig extends ConfigLoader<ConfigKeysDosaKanren> {

    private TokuchoBumpaiShuyakuSystem 特徴分配集約システム;

    /**
     * 現在有効な業務コンフィグ「動作関連」を扱うインスタンスを生成します。
     */
    public DosaKanrenConfig() {
        super(Configs.loadConfigsByEnum(ConfigKeysDosaKanren.class, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
    }

    /**
     * 特徴分配集約システムを返します。
     *
     * @return 特徴分配集約システム
     */
    public TokuchoBumpaiShuyakuSystem get特徴分配集約システム() {
        if (this.特徴分配集約システム == null) {
            this.特徴分配集約システム = TokuchoBumpaiShuyakuSystem.toValue(this.get(ConfigKeysDosaKanren.動作関連_特徴分配集約システム));
        }
        return this.特徴分配集約システム;
    }
}
