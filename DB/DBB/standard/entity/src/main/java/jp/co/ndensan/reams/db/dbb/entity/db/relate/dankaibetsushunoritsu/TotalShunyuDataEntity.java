/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu;

import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaV0702SaishinShunyuEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaV0704SaishinShunyuNiniFutaikinEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.SaikinShunyugakuUchiwakeRelateEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.ShunoKeyRelateEntity;

/**
 * 収納宛名データを取得Entityクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TotalShunyuDataEntity {

    private ShunoKeyRelateEntity 収納キーRelateEntity;
    private CaV0702SaishinShunyuEntity 最新収入Entity;
    private SaikinShunyugakuUchiwakeRelateEntity 最新収入額内訳RelateEntity;
    private CaV0704SaishinShunyuNiniFutaikinEntity 最新収入任意附帯金Entity;
}
