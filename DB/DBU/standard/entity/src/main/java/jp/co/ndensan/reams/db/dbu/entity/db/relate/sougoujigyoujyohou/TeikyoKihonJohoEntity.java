/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.sougoujigyoujyohou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 提供基本情報のEntityクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class TeikyoKihonJohoEntity extends DbTableEntityBase<TeikyoKihonJohoEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private RString dataSetRecordKey;
    private RString teikyoKubun;
    private ShikibetsuCode shikibetsuCode;
    private RString kojinnNo;
    private RString tokuteiKojinJohoMeiCode;
    private RString hanNo;
    private RString teikyoNaiyo01;
    private RString misetteiJiyu01;
    private RString teikyoNaiyo02;
    private RString misetteiJiyu02;
    private RString teikyoNaiyo03;
    private RString misetteiJiyu03;
    private RString teikyoNaiyo04;
    private RString misetteiJiyu04;
    private RString teikyoNaiyo05;
    private RString misetteiJiyu05;
    private RString teikyoNaiyo06;
    private RString misetteiJiyu06;
    private RString teikyoNaiyo07;
    private RString misetteiJiyu07;
    private RString teikyoNaiyo08;
    private RString misetteiJiyu08;
    private RString teikyoNaiyo09;
    private RString misetteiJiyu09;
    private RString teikyoNaiyo10;
    private RString misetteiJiyu10;
    private FlexibleDate kokaiYMD;
}
