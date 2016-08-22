/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費等審査決定請求明細表のパラメータクラスです。
 *
 * @reamsid_L DBC-2500-030 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiShinsaKetteiSeikyuMeisaihyoEntity {

    private DbWT1611SinsaKetteiSeikyuMeisai 明細テータ;
    private DbWT1612SinsaKetteiSeikyuKogaku 高額テータ;
    private DbWT1613SinsaKetteiSeikyuGokei 合計テータ;
}
