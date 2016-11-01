/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合のEntityクラスです。
 *
 * @reamsid_L DBU-4880-060 zhaoyao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanwariaiRelateEntity {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleYear nendo;
    private int rirekiNo;
    private int edaNo;
    private RString futanWariaiKubun;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private RString dataSetRecordKey;
}
