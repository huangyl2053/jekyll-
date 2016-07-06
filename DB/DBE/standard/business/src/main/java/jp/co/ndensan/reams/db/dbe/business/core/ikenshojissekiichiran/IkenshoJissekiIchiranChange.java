/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成実績集計表の帳票のパラメータを作成します。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
public final class IkenshoJissekiIchiranChange {

    private IkenshoJissekiIchiranChange() {
    }

    private static final RString MARU = new RString("○");

    /**
     * 主治医意見書作成実績集計表の帳票のパラメータを作成します。
     *
     * @param entity 主治医意見書作成実績集計表情報
     * @return 主治医意見書作成実績集計表の帳票のパラメータ
     */
    public static IkenshoJissekiIchiranEntity createSyohyoData(IkenshoJissekiIchiranRelateEntity entity) {
        RString 在宅_新 = RString.EMPTY;
        RString 在宅_継 = RString.EMPTY;
        RString 施設_新 = RString.EMPTY;
        RString 施設_継 = RString.EMPTY;
        if (ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅_施設区分())) {
            if (IkenshoIraiKubun.初回依頼.getコード().equals(entity.get主治医意見書依頼区分())) {
                在宅_新 = MARU;
            }
            if (IkenshoIraiKubun.再依頼.getコード().equals(entity.get主治医意見書依頼区分())
                    || IkenshoIraiKubun.再意見書.getコード().equals(entity.get主治医意見書依頼区分())) {
                在宅_継 = MARU;
            }
        }
        if (ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅_施設区分())) {
            if (IkenshoIraiKubun.初回依頼.getコード().equals(entity.get主治医意見書依頼区分())) {
                施設_新 = MARU;
            }
            if (IkenshoIraiKubun.再依頼.getコード().equals(entity.get主治医意見書依頼区分())
                    || IkenshoIraiKubun.再意見書.getコード().equals(entity.get主治医意見書依頼区分())) {
                施設_継 = MARU;
            }
        }
        IkenshoJissekiIchiranEntity data = new IkenshoJissekiIchiranEntity(entity.get証記載保険者番号(),
                entity.get医療機関コード(),
                entity.get医療機関名称(),
                entity.get主治医氏名(),
                entity.get被保険者番号(),
                entity.get申請者氏名(),
                dateFormat(entity.get記入日()),
                dateFormat(entity.get入手日()),
                在宅_新,
                在宅_継,
                施設_新,
                施設_継,
                entity.get医師区分コード());
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
