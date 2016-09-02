/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）の給付実績一覧検索クラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoMoshitateCollect implements Serializable {

    private List<KaigoKyufuhiKagoMositateTourokuResult> 給付実績情報List;
}
