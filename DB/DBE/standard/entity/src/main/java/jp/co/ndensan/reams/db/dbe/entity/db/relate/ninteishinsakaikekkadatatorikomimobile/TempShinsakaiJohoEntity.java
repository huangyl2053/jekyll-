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
public class TempShinsakaiJohoEntity extends DbTableEntityBase<TempShinsakaiJohoEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("DBE518002_ShinsakaiJohoTemp");

    private RString 介護認定審査会開催番号;
    private RString 介護認定審査会開催年月日;
    private RString 介護認定審査会開始時刻;
    private RString 介護認定審査会終了時刻;
    private RString 合議体番号;

}
