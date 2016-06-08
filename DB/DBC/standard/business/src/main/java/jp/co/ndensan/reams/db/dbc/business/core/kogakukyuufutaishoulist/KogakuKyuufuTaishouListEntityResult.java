/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntity;

/**
 * ビジネス設計_DBCKD00006_高額給付対象一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-060 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyuufuTaishouListEntityResult {

    private KogakuKyuufuTaishouListEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public KogakuKyuufuTaishouListEntityResult(KogakuKyuufuTaishouListEntity entity) {
        this.entity = entity;
    }

}
