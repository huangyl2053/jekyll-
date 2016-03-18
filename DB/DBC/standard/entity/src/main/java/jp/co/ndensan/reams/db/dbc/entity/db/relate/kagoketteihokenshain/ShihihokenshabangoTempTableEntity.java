/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 新被保険者番号一時テーブルEntity
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShihihokenshabangoTempTableEntity implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("TEMP_TABLE_Shihihokenshabango");

    private LasdecCode shichosonCode;
    private RString shinNo;
    private RString kyuNo;
}
