/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 共同処理一時TBLのEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class DbWT5C30KyoudouShori extends DbTableEntityBase<DbWT5C30KyoudouShori> implements IDbAccessable {

    private Decimal renban;
    private RString hokenshaNo;
    private RString hokenshaName;
    private RString hiHokenshaNo;
    private RString idoYMD;
    private RString kihon_shikibetsuNo;
    private RString kihon_idoYMD;
    private RString kihon_idoKubunCode;
    private RString kihon_teiseiKubunCode;
    private RString kihon_teiseiYMD;
    private RString kihon_jukyushaIdoJiyu;
    private RString kihon_shoKisaiHokenshaNo;
    private RString kihon_hiHokenshaNo;
    private RString kihon_hiHokenshaName;
    private RString kihon_telNo;
    private RString kihon_yubinNo;
    private RString kihon_ddressKana;
    private RString kihon_address;
    private RString kihon_chohyoOutputJunjyoCode;
    private RString shokan_shikibetsuNo;
    private RString shokan_idoYMD;
    private RString shokan_idoKubunCode;
    private RString shokan_teiseiYMD;
    private RString shokan_teiseiKubunCode;
    private RString shokan_jukyushaIdoJiyu;
    private RString shokan_shoKisaiHokenshaNo;
    private RString shokan_hiHokenshaNo;
    private RString shokan_SashitomeKaishiYMD;
    private RString shokan_SashitomeShuryoYMD;
    private RString shokan_SashitomeKubunCode;
    private RString shokan_SashitomeKingaku;
    private RString kogaku_shikibetsuNo;
    private RString kogaku_idoYMD;
    private RString kogaku_idoKubunCode;
    private RString kogaku_teiseiYMD;
    private RString kogaku_teiseiKubunCode;
    private RString kogaku_jukyushaIdoJiyu;
    private RString kogaku_shoKisaiHokenshaNo;
    private RString kogaku_hiHokenshaNo;
    private RString kogaku_setaiShuyakuNo;
    private RString kogaku_setaiShotokuKubunCode;
    private RString kogaku_shotokuKubunCode;
    private RString kogaku_nenkinJukyuAriFlag;
    private RString kogaku_futan2DankaiAriFlag;
    private RString kogaku_outputAriFlag;

}
