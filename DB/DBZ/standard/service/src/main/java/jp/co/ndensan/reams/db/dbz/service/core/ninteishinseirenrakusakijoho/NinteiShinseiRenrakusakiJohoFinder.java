/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.ninteishinseirenrakusakijoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4150RenrakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5150RenrakusakiJohoDac;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定申請連絡先情報のサービス処理です。
 */
public class NinteiShinseiRenrakusakiJohoFinder {
    
    private final DbT5150RenrakusakiJohoDac dbt5150Dac;
    private final DbT4150RenrakusakiJohoDac dbt4150Dac;
    
    /**
     * コンストラクタです。
     */
    NinteiShinseiRenrakusakiJohoFinder() {
        dbt5150Dac = InstanceProvider.create(DbT5150RenrakusakiJohoDac.class);
        dbt4150Dac = InstanceProvider.create(DbT4150RenrakusakiJohoDac.class);
    }
    
    /**
     * テスト用コンストラクタです。
     *
     * @param dbt5150Dac {@link DbT5150RenrakusakiJohoDac}
     * @param dbt4150Dac {@link DbT4150RenrakusakiJohoDac}
     */
    public NinteiShinseiRenrakusakiJohoFinder(DbT5150RenrakusakiJohoDac dbt5150Dac,
            DbT4150RenrakusakiJohoDac dbt4150Dac) {
        this.dbt5150Dac = dbt5150Dac;
        this.dbt4150Dac = dbt4150Dac;
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiRenrakusakiJohoFinder}のインスタンスを返します。
     *
     * @return NinteiChosaIraiShokaiManager
     *
     */
    public static NinteiShinseiRenrakusakiJohoFinder createInstance() {
        return InstanceProvider.create(NinteiShinseiRenrakusakiJohoFinder.class);
    }
    
    /**
     * 介護連絡先情報（認定）を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteiShinseiRenrakusakiKihon>
     */
    public SearchResult<NinteiShinseiRenrakusakiKihon> getShinsakaiNinteiShinseiJoho(ShinseishoKanriNo shinseishoKanriNo) {
        List<DbT5150RenrakusakiJohoEntity> dbt5150Entity = dbt5150Dac.getShinsakaiNinteiShinseiJoho(shinseishoKanriNo);
        List<NinteiShinseiRenrakusakiKihon> ninteiShinseiRenrakusakiKihon = new ArrayList<>();
        for (DbT5150RenrakusakiJohoEntity entity : dbt5150Entity) {
            ninteiShinseiRenrakusakiKihon.add(new NinteiShinseiRenrakusakiKihon(entity));
        }
        return SearchResult.of(ninteiShinseiRenrakusakiKihon, 0, false);
    }
    
    /**
     * 介護連絡先情報（受給）を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<RenrakusakiJoho>
     */
    public SearchResult<RenrakusakiJoho> getHokenshaNinteiShinseiJoho(ShinseishoKanriNo shinseishoKanriNo) {
        List<DbT4150RenrakusakiJohoEntity> dbt4150Entity = dbt4150Dac.getHokenshaNinteiShinseiJoho(shinseishoKanriNo);
        List<RenrakusakiJoho> renrakusakiJoho = new ArrayList<>();
        for (DbT4150RenrakusakiJohoEntity entity : dbt4150Entity) {
            renrakusakiJoho.add(new RenrakusakiJoho(entity));
        }
        return SearchResult.of(renrakusakiJoho, 0, false);
    }
    
}
