/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 世帯員把握テーブルのエンティティクラスです。
 *
 * @reamsid_L DBB-0640-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiHakuEntity implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private RString jushochiTokureiFlag;

}
