/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 *
 * @author
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@OnNextSchema("rgdb")
public class TempShinsakaiIinJohoEntity extends DbTableEntityBase<TempShinsakaiIinJohoEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("DBE518002_ShinsakaiIinJohoTemp");

    private RString 介護認定審査会開催番号;
    private RString 介護認定審査会委員コード;
    private RString 介護認定審査会委員氏名;
    private RString 介護認定審査会委員長区分コード;
    private RString 委員出席;
    private RString 介護認定審査員資格;
    private RString 委員出席時間;
    private RString 委員退席時間;
    private RString 委員遅刻有無;
    private RString 委員早退有無;

}
