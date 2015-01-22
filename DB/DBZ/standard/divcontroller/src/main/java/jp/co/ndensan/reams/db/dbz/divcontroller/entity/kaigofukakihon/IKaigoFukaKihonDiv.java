package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon;

import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 介護賦課基本情報Divのインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKaigoFukaKihonDiv extends ICommonChildDivBaseProperties {

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param searchKey {@link KaigoFukaKihonSearchKey key}
     */
    void load(KaigoFukaKihonSearchKey searchKey);
}
