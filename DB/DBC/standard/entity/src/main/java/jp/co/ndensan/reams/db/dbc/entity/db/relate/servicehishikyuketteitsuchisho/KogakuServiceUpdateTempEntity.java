/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス種類名称情報を取得用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServiceUpdateTempEntity implements Serializable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshaNo;
    private ServiceShuruiCode serviceShuruiCode;
    private int rirekiNo;
    private Decimal serviceHiyoGokeiGaku;
    private Decimal riyoshaFutanGaku;
    private RString kogakuKyufuKonkyo;
    private FlexibleYearMonth taishoshaUketoriYM;
    private KetteiTsuchishoInfoTempEntity 一時Entity;
    private DbT7130KaigoServiceShuruiEntity 介護サービス種類Entity;

}
