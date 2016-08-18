/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 依頼情報データ受取（オルカ）のクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraiJohoDataTorikomiCsvData implements Serializable {

    private List<IraiJohoDataTorikomiCsvEntity> csvEntityList;

}
