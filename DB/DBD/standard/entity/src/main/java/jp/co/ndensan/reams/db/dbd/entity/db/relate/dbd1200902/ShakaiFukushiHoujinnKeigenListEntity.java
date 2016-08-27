/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表発行のSQL結果クラスです。
 *
 * @reamsid_L DBD-3981-030 jinge
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenListEntity {

    private HihokenshaNo hihokenshaNo;
    private boolean ninteishoHakkoZumi;
    private boolean tsuchiHakkoZumi;
    private ShikibetsuCode shikibetsuCode;
    private LasdecCode shichosonCode;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate yukoKigenYMD;
    private RString ketteiKubun;
    private RString keigenritsu;
    private Decimal keigenritsu_Bunshi;
    private Decimal keigenritsu_Bumbo;
    private boolean kyotakuServiceGentei;
    private boolean kyojuhiShokuhiNomi;
    private boolean kyusochishaUnitTypeKoshitsuNomi;
    private RString kakuninNo;
    private FlexibleDate shikakuSoshitsuYMD;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
}
