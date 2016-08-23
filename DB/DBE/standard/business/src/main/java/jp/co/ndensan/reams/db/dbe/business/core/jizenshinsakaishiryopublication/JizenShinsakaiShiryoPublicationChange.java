/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jizenshinsakaishiryopublication;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaSelectEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public class JizenShinsakaiShiryoPublicationChange {

    private JizenShinsakaiShiryoPublicationChange() {
    }

    /**
     * 介護認定審査会委員事前審査のパラメータを作成します。
     *
     * @param entity 帳票出力用認定調査実績集計表情報
     * @return 帳票出力用認定調査実績集計表の帳票のパラメータ
     */
    public JizenShinsaKekkaEntity creatChange(JizenShinsaKekkaSelectEntity entity) {
        JizenShinsaKekkaEntity data = new JizenShinsaKekkaEntity(dateFormat(entity.get介護認定審査会開催予定年月日()),
                entity.get介護認定審査会開催場所名称(),
                entity.get介護認定審査会開始予定時刻(),
                dateFormat(entity.get介護認定審査会資料作成年月日()),
                entity.get合議体番号(),
                entity.get合議体名称(),
                entity.get介護認定審査会予定定員(),
                entity.get介護認定審査会割当済み人数());
        return data;
    }

    private FlexibleDate dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date.wareki().toDateString());
    }
}
