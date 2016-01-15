/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri;

import jp.co.ndensan.reams.db.dbx.business.config.util.ConfigLoaderByConfigKeys;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 業務コンフィグ「合併情報管理」を扱います。
 */
public class GappeiJohoKanriConfig extends ConfigLoaderByConfigKeys<ConfigKeysGappeiJohoKanri> {

    private GappeiJohoKubun 合併情報区分;

    /**
     * 現時点の業務コンフィグ「合併情報管理」の設定値を持つインスタンスを生成します。
     */
    public GappeiJohoKanriConfig() {
        super(ConfigKeysGappeiJohoKanri.class, RDate.getNowDate());
    }

    /**
     * 合併ありの場合true、合併なしの場合falseを返却します。
     *
     * @return 合併ありの場合true、合併なしの場合false
     */
    public boolean has合併() {
        return this.get合併情報区分().has合併();
    }

    /**
     * 合併情報区分を返します。
     * <p/>
     * 合併情報区部により合併の有無が判断できます。
     *
     * @return 合併情報区分
     */
    public GappeiJohoKubun get合併情報区分() {
        if (this.合併情報区分 == null) {
            this.合併情報区分 = GappeiJohoKubun.toValue(this.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分));
        }
        return this.合併情報区分;
    }
}
