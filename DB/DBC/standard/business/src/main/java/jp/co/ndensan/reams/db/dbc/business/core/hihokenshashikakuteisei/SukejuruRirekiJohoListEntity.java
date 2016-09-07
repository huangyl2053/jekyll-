/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hihokenshashikakuteisei;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;

/**
 * SukejuruRirekiJohoListEntity_国保連連携スケジュール設定のスケジュール履歴情報Entity クラスです。
 *
 * @reamsid_L DBC-2930-030 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SukejuruRirekiJohoListEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<KokuhorenInterfaceKanri> スケジュール履歴情報_送付List;
    private List<KokuhorenInterfaceKanri> スケジュール履歴情報_取込List;
}
