/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事前審査結果のビジネスクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class JizenShinsaKekka {

    private final JizenShinsaKekkaRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 事前審査結果情報
     */
    public JizenShinsaKekka(JizenShinsaKekkaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会委員氏名を取得します。
     *
     * @return 介護認定審査会委員氏名
     */
    public RString getShinsakaiIinShimei() {
        return entity.getShinsakaiIinShimei();
    }

    /**
     * 介護認定審査会議長区分コードを取得します。
     *
     * @return 介護認定審査会議長区分コード
     */
    public RString getKaigoninteiShinsakaiGichoKubunCode() {
        return entity.getKaigoninteiShinsakaiGichoKubunCode();
    }

    /**
     * 介護認定審査会委員コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 介護認定審査会審査順を取得します。
     *
     * @return 介護認定審査会審査順
     */
    public int getShinsakaiOrder() {
        return entity.getShinsakaiOrder();
    }

    /**
     * 二次判定結果コードを取得します。
     *
     * @return 二次判定結果コード
     */
    public RString getNijiHanteiKekkaCode() {
        return entity.getNijiHanteiKekkaCode();
    }
}
