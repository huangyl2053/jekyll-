package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
     * @param 通知書番号 通知書番号
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    void load(TsuchishoNo 通知書番号, FlexibleYear 賦課年度, LasdecCode 市町村コード, ShikibetsuCode 識別コード);
}
