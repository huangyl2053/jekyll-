/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka8batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaHachiTempEntity;

/**
 * 賦課情報TempEntity
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchFukaJohoHachiResult implements Serializable {

    private FukaJohoTmpHachiEntity 賦課の情報;
    private TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaHachiTempEntity 平準化計算結果;
}
