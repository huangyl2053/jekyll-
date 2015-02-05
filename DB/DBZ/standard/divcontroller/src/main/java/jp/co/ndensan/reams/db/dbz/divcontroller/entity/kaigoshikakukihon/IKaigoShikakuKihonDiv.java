package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 介護資格基本情報Divのインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKaigoShikakuKihonDiv extends ICommonChildDivBaseProperties {

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード);

    /**
     * 自身に設定されている被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    HihokenshaNo get被保険者番号();
}
