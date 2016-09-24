/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者台帳と宛名情報SQL検索結果クラスです．
 *
 * @reamsid_L DBC-2180-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaAtenaResultEntity {

    private LasdecCode 市町村コード;
    private RString 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;

}
