/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukyufuketteiin;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費決定情報取込みのパラメータ
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public class KogakuKyufuKetteiInBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "処理年月", name = "処理年月")
    private RString shoriYM;

    @BatchParameter(key = "出力順", name = "出力順")
    private Long shutsuryokujun;

    /**
     * @return the shoriYM
     */
    public RString getShoriYM() {
        return shoriYM;
    }

    /**
     * @param shoriYM the shoriYM to set
     */
    public void setShoriYM(RString shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * @return the shutsuryokujun
     */
    public Long getShutsuryokujun() {
        return shutsuryokujun;
    }

    /**
     * @param shutsuryokujun the shutsuryokujun to set
     */
    public void setShutsuryokujun(Long shutsuryokujun) {
        this.shutsuryokujun = shutsuryokujun;
    }
}
