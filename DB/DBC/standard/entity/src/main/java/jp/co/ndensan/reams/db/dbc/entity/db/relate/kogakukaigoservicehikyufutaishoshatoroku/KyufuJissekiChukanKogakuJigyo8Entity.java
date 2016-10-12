/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;

/**
 * 給付実績中間高額一時8Insert用Entityです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiChukanKogakuJigyo8Entity implements Serializable {

    private TempKyufujissekiTyukannJigyoEntity 給付実績基本情報事業高額一時;
    private DbT3116KijunShunyugakuTekiyoKanriEntity 基準収入額適用管理一時;
    private TempSetaiinShotokuHanteiEntity 世帯員所得判定明細事業高額一時１;
    private TempSetaiinShotokuHanteiEntity 世帯員所得判定明細事業高額一時３;
}
