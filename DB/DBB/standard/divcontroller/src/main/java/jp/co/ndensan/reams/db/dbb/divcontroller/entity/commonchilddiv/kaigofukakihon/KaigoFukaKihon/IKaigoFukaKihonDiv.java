package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon;

import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoFukaKihonDiv extends ICommonChildDivBaseProperties {

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param searchKey {@link KaigoFukaKihonSearchKey key}
     */
    void load(KaigoFukaKihonSearchKey searchKey);

}
