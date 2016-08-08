/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * @author Saku
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariKikanTempEntity extends DbTableEntityBase<FutanWariKikanTempEntity> implements IDbAccessable {

    private FlexibleYear nendo;
    private HihokenshaNo hihokenshaNo;
    private RString futanWariaiKubun1;
    private FlexibleDate yukoKaishiYMD1;
    private FlexibleDate yukoShuryoYMD1;
    private RString shikakuKubun1;
    private RString futanWariaiKubun2;
    private FlexibleDate yukoKaishiYMD2;
    private FlexibleDate yukoShuryoYMD2;
    private RString shikakuKubun2;
}
