/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.gennendohonsanteiidou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 月別ランク一時Entityクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuRankuEntity implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private RString rankKubun4Gatsu;
    private RString rankKubun5Gatsu;
    private RString rankKubun6Gatsu;
    private RString rankKubun7Gatsu;
    private RString rankKubun8Gatsu;
    private RString rankKubun9Gatsu;
    private RString rankKubun10Gatsu;
    private RString rankKubun11Gatsu;
    private RString rankKubun12Gatsu;
    private RString rankKubun1Gatsu;
    private RString rankKubun2Gatsu;
    private RString rankKubun3Gatsu;
    private LasdecCode shichosonCode4Gatsu;
    private LasdecCode shichosonCode5Gatsu;
    private LasdecCode shichosonCode6Gatsu;
    private LasdecCode shichosonCode7Gatsu;
    private LasdecCode shichosonCode8Gatsu;
    private LasdecCode shichosonCode9Gatsu;
    private LasdecCode shichosonCode10Gatsu;
    private LasdecCode shichosonCode11Gatsu;
    private LasdecCode shichosonCode12Gatsu;
    private LasdecCode shichosonCode1Gatsu;
    private LasdecCode shichosonCode2Gatsu;
    private LasdecCode shichosonCode3Gatsu;
}
