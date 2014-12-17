/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.FukaDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時にメソッドを追加する。
public class FukaShokaiFinder {

    private final FukaDac dac;

    public FukaShokaiFinder() {
        this.dac = InstanceProvider.create(FukaDac.class);
    }

    FukaShokaiFinder(FukaDac dac) {
        this.dac = dac;
    }

    /**
     * 条件に該当する全賦課履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 全賦課履歴
     */
    public IItemList<FukaModel> get全賦課履歴(HihokenshaNo 被保険者番号) {
        return dac.select(被保険者番号);
    }

    /**
     * 条件に該当する全賦課履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 全賦課履歴
     */
    public IItemList<FukaModel> get全賦課履歴(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {
        return dac.select(被保険者番号, 賦課年度);
    }
}
