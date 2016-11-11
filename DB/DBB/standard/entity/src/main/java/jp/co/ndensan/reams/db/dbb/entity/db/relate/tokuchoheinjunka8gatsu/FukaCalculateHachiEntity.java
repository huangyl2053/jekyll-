/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka8batch.TokuchoHeijunkaHachiBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算中間Tempのクラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaCalculateHachiEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private FlexibleDate kijunYMD;
    private TokuchoHeijunkaHachiBatchTaishogaiTempEntity 賦課の情報;
    private DbT1001HihokenshaDaichoEntity 資格の情報;
    private KuBunnGaTsurakuTempEntity 月別ランク;
    private DbT2001ChoshuHohoEntity 徴収方法の情報;
    private TokuteiKozaRelateEntity 特定口座;
    private SetaiShotokuEntity 世帯員所得情報;

}
