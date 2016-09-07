/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 減免減額対象者判定用根拠作成対象者entityクラスです。
 *
 * @reamsid_L DBD-3530-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaTokuteiEntity {

    private HihokenshaNo 被保険者番号;
}
