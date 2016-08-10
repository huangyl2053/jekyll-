/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者同定結果情報一時テーブルクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity extends DbTableEntityBase<HikazeNenkinTaishoshaDouteiResultJohoTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("HikazeNenkinTaishoshaDouteiResultJohoTempTable");
}
