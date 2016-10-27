/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.hanyolist;

import java.util.List;

/**
 * 汎用リスト出力項目Entityのクラスです。
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShutsuryokuKomoku {

    private List<HanyoListShutsuryokuKomokuList> 汎用リスト出力項目リスト;
    private int 項目間スペース数;
}
