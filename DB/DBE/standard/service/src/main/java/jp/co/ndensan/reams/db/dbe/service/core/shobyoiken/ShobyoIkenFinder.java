/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shobyoiken;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5300GeninShikkanDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 傷病の意見入力のFinderクラスです。
 *
 * @reamsid_L DBE-3000-130 zhengshukai
 */
public class ShobyoIkenFinder {

    private final DbT5300GeninShikkanDac dac;

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbT5300GeninShikkanDac
     */
    public ShobyoIkenFinder(DbT5300GeninShikkanDac dac) {
        this.dac = dac;
    }

    ShobyoIkenFinder() {
        this.dac = InstanceProvider.create(DbT5300GeninShikkanDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShobyoIkenFinder}のインスタンスを返します。
     *
     * @return ShobyoIkenFinder
     */
    public static ShobyoIkenFinder createInstance() {
        return InstanceProvider.create(ShobyoIkenFinder.class);
    }

    /**
     * 新規連番を取得します。
     *
     * @param 管理番号 ShinseishoKanriNo
     * @return 連番
     */
    public int get連番(ShinseishoKanriNo 管理番号) {
        return dac.renbanmax(管理番号) + 1;
    }
}
