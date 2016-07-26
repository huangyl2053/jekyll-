/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;

/**
 * 賦課情報TempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchFukaJohoResult implements Serializable {

    private FukaJohoRelateEntity 賦課の情報;
    private TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity 平準化計算結果;
}
