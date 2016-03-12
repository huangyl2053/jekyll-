/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteishinseirenrakusakikihon;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5150RenrakusakiJohoDac;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 認定申請連絡先のクラスです。
 */
public class NinteiShinseiRenrakusakiKihonFinder {

    private final DbT5150RenrakusakiJohoDac dbT5150Dac;

    /**
     * コンストラクタ。
     *
     */
    public NinteiShinseiRenrakusakiKihonFinder() {

        this.dbT5150Dac = InstanceProvider.create(DbT5150RenrakusakiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT5150Dac DbT5150RenrakusakiJohoDac
     */
    NinteiShinseiRenrakusakiKihonFinder(DbT5150RenrakusakiJohoDac dbT5150Dac) {
        this.dbT5150Dac = dbT5150Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiRenrakusakiKihonFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShinseiRenrakusakiKihonFinder}のインスタンス
     */
    public static NinteiShinseiRenrakusakiKihonFinder createInstance() {
        return InstanceProvider.create(NinteiShinseiRenrakusakiKihonFinder.class);
    }

    /**
     * 介護連絡先情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteiShinseiRenrakusakiKihon> 介護連絡先
     */
    @Transaction
    public SearchResult<NinteiShinseiRenrakusakiKihon> getNinteiShinseiRenrakusakiKihon(ShinseishoKanriNo shinseishoKanriNo) {
        List<NinteiShinseiRenrakusakiKihon> renrakusakiJohoList = new ArrayList<>();
        DbT5150RenrakusakiJohoEntity dbT5150Entity = dbT5150Dac.selectByShinseishoKanriNo(shinseishoKanriNo);
        if (dbT5150Entity != null) {
            renrakusakiJohoList.add(new NinteiShinseiRenrakusakiKihon(dbT5150Entity));
        }
        return SearchResult.of(renrakusakiJohoList, 0, false);
    }
}
