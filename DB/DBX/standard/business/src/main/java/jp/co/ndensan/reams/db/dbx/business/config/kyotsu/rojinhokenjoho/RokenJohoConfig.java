/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.rojinhokenjoho;

import jp.co.ndensan.reams.db.dbx.business.config.util.ConfigLoaderByConfigKeys;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグ「老人保健情報」を扱います。
 */
public class RokenJohoConfig extends ConfigLoaderByConfigKeys<ConfigKeysRokenJoho> {

    /**
     * 現在有効な「老人保健情報」をあつかうインスタンスを生成します。
     */
    public RokenJohoConfig() {
        super(ConfigKeysRokenJoho.class, RDate.getNowDate());
    }

    /**
     * 市町村番号を返します。
     *
     * @return 市町村番号
     */
    public RString get市町村番号() {
        return this.get(ConfigKeysRokenJoho.老人保健情報_市町村番号);
    }

    /**
     * 管理体系を返します。
     *
     * @return 管理体系
     */
    public RojinHokenKanriTaikei get管理体系() {
        return RojinHokenKanriTaikei.toValue(this.get(ConfigKeysRokenJoho.老人保健情報_管理体系));
    }
}
