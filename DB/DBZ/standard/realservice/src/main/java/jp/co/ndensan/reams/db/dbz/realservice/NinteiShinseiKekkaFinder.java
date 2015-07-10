/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.relate.NinteiShinseiKekkaModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.NinteiShinseiKekkaDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請結果を取得するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiKekkaFinder {

    private final NinteiShinseiKekkaDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiShinseiKekkaFinder() {
        dac = InstanceProvider.create(NinteiShinseiKekkaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    NinteiShinseiKekkaFinder(NinteiShinseiKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 被保険者番号に合致する要介護認定申請結果の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return NinteiShinseiKekkaModel
     */
    @Transaction
    public IItemList<NinteiShinseiKekkaModel> find要介護認定申請結果(HihokenshaNo 被保険者番号) {

        return dac.select要介護認定申請結果履歴By被保険者番号(被保険者番号);
    }

}
