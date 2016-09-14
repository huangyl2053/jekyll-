/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 基本共同処理一時TBLのEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class DbWT5C31KihonKyoudouShoriEntity extends DbTableEntityBase<DbWT5C31KihonKyoudouShoriEntity> implements IDbAccessable {

    private RString hokenshaNo;
    private RString hokenshaName;
    private RString shikibetsuNo;
    private RString hiHokenshaNo;
    private RString idoYMD;
    private RString idoKubunCode;
    private RString jukyushaIdoJiyu;
    private RString shoKisaiHokenshaNo;
    private RString hiHokenshaName;
    private RString yubinNo;
    private RString ddressKana;
    private RString address;
    private RString telNo;
    private RString chohyoOutputJunjyoCode;
    private RString teiseiKubunCode;
    private RString teiseiYMD;
}
