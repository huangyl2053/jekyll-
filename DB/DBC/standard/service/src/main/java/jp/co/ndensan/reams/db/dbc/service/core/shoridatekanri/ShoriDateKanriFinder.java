/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shoridatekanri;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 自己負担額証明書作成（括）の前回の実行情報の取得のFinderです。
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
public class ShoriDateKanriFinder {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    ShoriDateKanriFinder() {
        this.dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShoriDateKanriFinder}のインスタンスを返します。
     *
     * @return ShoriDateKanriFinder
     */
    public static ShoriDateKanriFinder createInstance() {
        return InstanceProvider.create(ShoriDateKanriFinder.class);
    }

    /**
     * 前回の実行情報 を取得します。
     *
     * @param 市町村コード LasdecCode
     * @return ShoriDateKanri 検索項目がなしの場合、nullを戻ります。
     */
    public ShoriDateKanri get前回の実行情報(LasdecCode 市町村コード) {
        DbT7022ShoriDateKanriEntity entity = dac.select(
                SubGyomuCode.DBC介護給付,
                市町村コード,
                new RString("自己負担証明書作成_一括"),
                new RString("0001"));
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }
}
