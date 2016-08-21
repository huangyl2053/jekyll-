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

/**
 * 世帯員情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetainJohoTempEntity implements IDbAccessable {

    private static final RString ONE = new RString("1");

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private ShikibetsuCode honinShikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private boolean jutokuGaitoFlag;
    private FlexibleYear taishoNendo;
    private RString taishoTsuki;
    private SetaiCode setaiCode;
    private RString setaiShotokuHonninKubun;

    /**
     * 本人識別コード初期化のメソッドです。
     */
    public void 本人識別コード初期化() {
        if (ONE.equals(setaiShotokuHonninKubun)) {
            this.setHoninShikibetsuCode(shikibetsuCode);
        }
    }
}
