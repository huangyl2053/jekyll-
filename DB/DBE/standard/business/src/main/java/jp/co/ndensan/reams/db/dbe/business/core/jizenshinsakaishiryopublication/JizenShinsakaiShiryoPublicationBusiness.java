/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jizenshinsakaishiryopublication;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaSelectEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public class JizenShinsakaiShiryoPublicationBusiness {

    private final JizenShinsaKekkaSelectEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 介護認定審査会委員事前審査
     */
    public JizenShinsakaiShiryoPublicationBusiness(JizenShinsaKekkaSelectEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会開催予定年月日を取得します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public RString get介護認定審査会開催予定年月日() {
        return entity.get介護認定審査会開催予定年月日();
    }

    /**
     * 介護認定審査会開催場所名称を取得します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return entity.get介護認定審査会開催場所名称();
    }

    /**
     * 介護認定審査会開始予定時刻を取得します。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString get介護認定審査会開始予定時刻() {
        return entity.get介護認定審査会開始予定時刻();
    }

    /**
     * 介護認定審査会資料作成年月日を取得します。
     *
     * @return 介護認定審査会資料作成年月日
     */
    public RString get介護認定審査会資料作成年月日() {
        return entity.get介護認定審査会資料作成年月日();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.get合議体名称();
    }

    /**
     * 介護認定審査会予定定員を取得します。
     *
     * @return 介護認定審査会予定定員
     */
    public RString get介護認定審査会予定定員() {
        return entity.get介護認定審査会予定定員();
    }

    /**
     * 介護認定審査会割当済み人数を取得します。
     *
     * @return 介護認定審査会割当済み人数
     */
    public RString get介護認定審査会割当済み人数() {
        return entity.get介護認定審査会割当済み人数();
    }
}
