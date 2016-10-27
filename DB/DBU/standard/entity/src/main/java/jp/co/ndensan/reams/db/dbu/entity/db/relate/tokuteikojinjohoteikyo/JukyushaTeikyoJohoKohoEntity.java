/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者基本情報の提供情報(候補)のEntityクラスです。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeikyoJohoKohoEntity {

    private HihokenshaNo hihokenshaNo;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shinseiJokyoKubun;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate jukyuShinseiYMD;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private Code yukoMukoKubun;
    private Decimal shikyuGendoTanisu;
    private RDateTime lastUpdateTimestamp;
    private boolean logicalDeletedFlag;
    private ShinseishoKanriNo ninteiShinseishoKanriNo;
    private RString ninteishinsakaiIkenShurui;
    private RDateTime ninteiLastUpdateTimestamp;
    private boolean ninteiLogicalDeletedFlag;
}
