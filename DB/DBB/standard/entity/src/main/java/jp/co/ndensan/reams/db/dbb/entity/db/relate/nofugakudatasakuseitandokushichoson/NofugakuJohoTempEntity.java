/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 納付額情報一時テーブルEntityのパラメータです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class NofugakuJohoTempEntity extends DbTableEntityBase<NofugakuJohoTempEntity> implements IDbAccessable {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private LasdecCode fukaShichosonCode;
    private Decimal tkSaishutsuKampuGaku;
    private Decimal fuSaishutsuKampuGaku;
    private Decimal tkChoteiGaku01;
    private Decimal tkChoteiGaku02;
    private Decimal tkChoteiGaku03;
    private Decimal tkChoteiGaku04;
    private Decimal tkChoteiGaku05;
    private Decimal tkChoteiGaku06;
    private Decimal fuChoteiGaku01;
    private Decimal fuChoteiGaku02;
    private Decimal fuChoteiGaku03;
    private Decimal fuChoteiGaku04;
    private Decimal fuChoteiGaku05;
    private Decimal fuChoteiGaku06;
    private Decimal fuChoteiGaku07;
    private Decimal fuChoteiGaku08;
    private Decimal fuChoteiGaku09;
    private Decimal fuChoteiGaku10;
    private Decimal fuChoteiGaku11;
    private Decimal fuChoteiGaku12;
    private Decimal fuChoteiGaku13;
    private Decimal fuChoteiGaku14;
    private Decimal tkShunyuGaku01;
    private Decimal tkShunyuGaku02;
    private Decimal tkShunyuGaku03;
    private Decimal tkShunyuGaku04;
    private Decimal tkShunyuGaku05;
    private Decimal tkShunyuGaku06;
    private Decimal fuShunyuGaku01;
    private Decimal fuShunyuGaku02;
    private Decimal fuShunyuGaku03;
    private Decimal fuShunyuGaku04;
    private Decimal fuShunyuGaku05;
    private Decimal fuShunyuGaku06;
    private Decimal fuShunyuGaku07;
    private Decimal fuShunyuGaku08;
    private Decimal fuShunyuGaku09;
    private Decimal fuShunyuGaku10;
    private Decimal fuShunyuGaku11;
    private Decimal fuShunyuGaku12;
    private Decimal fuShunyuGaku13;
    private Decimal fuShunyuGaku14;
    private FlexibleDate tkRyoshuYMD01;
    private FlexibleDate tkRyoshuYMD02;
    private FlexibleDate tkRyoshuYMD03;
    private FlexibleDate tkRyoshuYMD04;
    private FlexibleDate tkRyoshuYMD05;
    private FlexibleDate tkRyoshuYMD06;
    private FlexibleDate fuRyoshuYMD01;
    private FlexibleDate fuRyoshuYMD02;
    private FlexibleDate fuRyoshuYMD03;
    private FlexibleDate fuRyoshuYMD04;
    private FlexibleDate fuRyoshuYMD05;
    private FlexibleDate fuRyoshuYMD06;
    private FlexibleDate fuRyoshuYMD07;
    private FlexibleDate fuRyoshuYMD08;
    private FlexibleDate fuRyoshuYMD09;
    private FlexibleDate fuRyoshuYMD10;
    private FlexibleDate fuRyoshuYMD11;
    private FlexibleDate fuRyoshuYMD12;
    private FlexibleDate fuRyoshuYMD13;
    private FlexibleDate fuRyoshuYMD14;
    private FlexibleDate tkShunyuYMD01;
    private FlexibleDate tkShunyuYMD02;
    private FlexibleDate tkShunyuYMD03;
    private FlexibleDate tkShunyuYMD04;
    private FlexibleDate tkShunyuYMD05;
    private FlexibleDate tkShunyuYMD06;
    private FlexibleDate fuShunyuYMD01;
    private FlexibleDate fuShunyuYMD02;
    private FlexibleDate fuShunyuYMD03;
    private FlexibleDate fuShunyuYMD04;
    private FlexibleDate fuShunyuYMD05;
    private FlexibleDate fuShunyuYMD06;
    private FlexibleDate fuShunyuYMD07;
    private FlexibleDate fuShunyuYMD08;
    private FlexibleDate fuShunyuYMD09;
    private FlexibleDate fuShunyuYMD10;
    private FlexibleDate fuShunyuYMD11;
    private FlexibleDate fuShunyuYMD12;
    private FlexibleDate fuShunyuYMD13;
    private FlexibleDate fuShunyuYMD14;

}
