/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjohogogitai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjohogogitai.ShinsakaiIinJohoGoitaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会委員情報Businessです。
 */
public class ShinsakaiIinJohoGoitaiBusiness {

    private final ShinsakaiIinJohoGoitaiEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 介護認定審査会委員情報Entity
     */
    public ShinsakaiIinJohoGoitaiBusiness(ShinsakaiIinJohoGoitaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会委員コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.get介護認定審査会委員コード();
    }

    /**
     * 介護認定審査会委員氏名を取得します。
     *
     * @return 介護認定審査会委員氏名
     */
    public RString get介護認定審査会委員氏名() {
        return entity.get介護認定審査会委員氏名();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
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
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.get住所();
    }
}
