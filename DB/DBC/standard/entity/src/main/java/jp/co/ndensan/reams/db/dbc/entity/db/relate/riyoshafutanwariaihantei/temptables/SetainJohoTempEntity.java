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

//被保険者番号
    private HihokenshaNo hihokenshaNo;
//識別コード
    private ShikibetsuCode shikibetsuCode;
//本人識別コード
    private ShikibetsuCode honinShikibetsuCode;
//基準年月日
    private FlexibleDate kijunYMD;
//所得年度
    private FlexibleYear shotokuNendo;
//住所地特例該当
    private boolean jutokuGaitoFlag;
//対象年度
    private FlexibleYear taishoNendo;
//対象月
    private RString taishoTsuki;
//世帯コード
    private SetaiCode setaiCode;
//世帯員所得一時.本人区分
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
