/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.configmaintenance;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author soft863
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ConfigMaintenanceRelateEntity {

    private RString configName;
    private RString configValue;
    private RString configDesc;
}
