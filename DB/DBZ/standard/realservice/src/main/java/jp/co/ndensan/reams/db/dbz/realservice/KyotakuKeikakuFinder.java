/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.relate.KyotakuKeikakuRelateModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画関連情報を取得するManagerクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuFinder {

    private final KyotakuKeikakuDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuFinder() {
        dac = InstanceProvider.create(KyotakuKeikakuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    KyotakuKeikakuFinder(KyotakuKeikakuDac dac) {
        this.dac = dac;
    }

    /**
     * 検索条件に合致する居宅給付計画履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<KyotakuKeikakuRelateModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuRelateModel> find居宅計画履歴一覧(HihokenshaNo 被保険者番号) {

        return dac.select居宅計画履歴一覧By被保険者番号(被保険者番号);
    }

}
