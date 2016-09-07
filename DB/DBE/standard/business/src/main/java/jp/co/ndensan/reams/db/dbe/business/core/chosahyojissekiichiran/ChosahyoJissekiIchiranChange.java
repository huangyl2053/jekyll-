/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用認定調査実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
public final class ChosahyoJissekiIchiranChange {

    private ChosahyoJissekiIchiranChange() {
    }

    /**
     * 帳票出力用認定調査実績集計表の帳票のパラメータを作成します。
     *
     * @param entity 帳票出力用認定調査実績集計表情報
     * @return 帳票出力用認定調査実績集計表の帳票のパラメータ
     */
    public static ChosahyoJissekiIchiranEntity createSyohyoData(ChosahyoJissekiIchiranRelateEntity entity) {
        ChosahyoJissekiIchiranEntity data = new ChosahyoJissekiIchiranEntity(entity.get証記載保険者番号(),
                entity.get調査委託先コード(),
                entity.get事業者名称(),
                entity.get調査員氏名(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                dateFormat(entity.get認定調査実施年月日()),
                entity.get認定調査区分コード(),
                entity.get認定調査依頼区分コード());
        return data;
    }

    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }
}
