/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import java.util.List;

/**
 * 給付額減額把握リストEntity
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGengakuHaakuIchiranEntity {

    private HihokenshaJohoEntity 被保険者情報Entity;
    private List<ShunoJohoEntity> 収納情報リスト;
    private List<GengakuTaishoJohoEntity> 減額対象情報リスト;
}
