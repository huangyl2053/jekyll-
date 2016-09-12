/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kougakushinseiichiranjohyou;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouEntity;

/**
 * ビジネス設計_DBCKD00005_高額申請一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-050 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuShinseiIchiranJohyouEntityResult {

    private KougakuShinseiIchiranJohyouEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public KougakuShinseiIchiranJohyouEntityResult(KougakuShinseiIchiranJohyouEntity entity) {
        this.entity = entity;
    }

}
