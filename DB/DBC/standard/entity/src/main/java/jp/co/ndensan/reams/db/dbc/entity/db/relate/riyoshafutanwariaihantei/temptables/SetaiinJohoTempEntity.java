/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

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
public class SetaiinJohoTempEntity implements IDbAccessable {

//被保険者番号
    private RString hihokenshaNo;
//基準年月日
    private RString kijunDate;
//所得年度
    private RString shotokuNendo;
//住所地特例該当
    private boolean jutokuGaitoFlag;
//対象年度
    private RString taishoNendo;
//対象月
    private RString taishoGetsu;
//世帯コード
    private RString setaiCode;
//識別コード
    private RString shikibetshuCode;
//本人識別コード
    private RString honinShikibetsuCode;

}
