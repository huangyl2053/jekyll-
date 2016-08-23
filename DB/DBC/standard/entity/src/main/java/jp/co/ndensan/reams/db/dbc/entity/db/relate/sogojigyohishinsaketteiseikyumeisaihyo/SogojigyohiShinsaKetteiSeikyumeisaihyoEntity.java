/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhishinsaketteiseikyumeisaihyo.DbWT1611SinsaKetteiSeikyuMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhishinsaketteiseikyumeisaihyo.DbWT1613SinsaKetteiSeikyuGokei;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表帳票Entityクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShinsaKetteiSeikyumeisaihyoEntity {

    private DbWT1611SinsaKetteiSeikyuMeisai 審査決定請求明細;
    private DbWT1613SinsaKetteiSeikyuGokei 審査決定請求合計;

}
