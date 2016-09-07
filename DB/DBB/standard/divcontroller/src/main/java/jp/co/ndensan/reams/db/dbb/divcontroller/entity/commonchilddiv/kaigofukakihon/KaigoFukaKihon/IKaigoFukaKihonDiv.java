package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
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

    /**
     * 被保番号を取得しします。
     *
     * @return 被保番号
     */
    HihokenshaNo get被保番号();

    /**
     * 通知書番号を取得しします。
     *
     * @return 通知書番号
     */
    TsuchishoNo get通知書番号();

}
