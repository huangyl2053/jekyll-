/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報のMyBatisParameterです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaisaiYoteiJohoMyBatisParameter implements IMyBatisParameter {

    private RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public KaisaiYoteiJohoMyBatisParameter(RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }
}
