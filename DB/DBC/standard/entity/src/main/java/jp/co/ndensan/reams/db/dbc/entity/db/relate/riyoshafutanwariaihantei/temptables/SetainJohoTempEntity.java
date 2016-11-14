/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 世帯員情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetainJohoTempEntity implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private RString taishoTsuki;
    @PrimaryKey
    private SetaiCode setaiCode;
    private ShikibetsuCode honinShikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private boolean jutokuGaitoFlag;
    private RString setaiShotokuHonninKubun;

    /**
     * SetainJohoTempEntityのコンストラクタです。
     */
    public SetainJohoTempEntity() {
        hihokenshaNo = HihokenshaNo.EMPTY;
        shikibetsuCode = ShikibetsuCode.EMPTY;
        taishoNendo = FlexibleYear.EMPTY;
        taishoTsuki = RString.EMPTY;
        setaiCode = SetaiCode.EMPTY;
    }
}
