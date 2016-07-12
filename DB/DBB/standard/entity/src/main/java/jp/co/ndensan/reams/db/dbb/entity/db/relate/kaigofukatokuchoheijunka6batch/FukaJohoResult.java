/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TmpHeijunkaKeisanKekaTempEntity;
import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;

/**
 * 対象者データTempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FukaJohoResult implements Cloneable, Serializable {

    private FukaJohoRelateEntity 賦課の情報;
    private TmpHeijunkaKeisanKekaTempEntity 平準化計算結果;

    /**
     * コンストラクタです。
     */
    public FukaJohoResult() {
    }

    /**
     * コンストラクタです。
     *
     * @param 賦課の情報 FukaJohoRelateEntity
     * @param 平準化計算結果 TmpHeijunkaKeisanKekaTempEntity
     */
    public FukaJohoResult(FukaJohoRelateEntity 賦課の情報, TmpHeijunkaKeisanKekaTempEntity 平準化計算結果) {
        this.賦課の情報 = 賦課の情報;
        this.平準化計算結果 = 平準化計算結果;
    }
}
