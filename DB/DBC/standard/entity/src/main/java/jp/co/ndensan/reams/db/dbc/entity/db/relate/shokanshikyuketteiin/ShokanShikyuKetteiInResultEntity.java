/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給不支給決定情報取込共通処理（DB登録）のresultEntity
 *
 * @reamsid_L DBC-0980-331 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiInResultEntity {

    private Decimal dbWT3036_連番;
    private ShoKisaiHokenshaNo dbWT3036_証記載保険者番号;
    private RString dbWT3036_証記載保険者名;
    private FlexibleDate dbWT3036_作成年月日;
    private RString dbWT3036_国保連合会名;
    private RString dbWT3036_No;
    private RString dbWT3036_整理番号;
    private FlexibleYearMonth dbWT3036_サービス提供年月;
    private JigyoshaNo dbWT3036_事業所番号;
    private RString dbWT3036_事業所名;
    private ServiceShuruiCode dbWT3036_サービス種類コード;
    private RString dbWT3036_サービス種類名;
    private Decimal dbWT3036_単位数;
    private Decimal dbWT3036_支払金額;
    private Decimal dbWT3036_増減単位数;
    private RString dbWT3036_支払方法区分コード;
    private RString dbWT3036_備考1;
    private RString dbWT3036_備考2;
    private RString dbWT3036_更新DB有無;
    private JigyoshaNo dbWT3036_ワーク事業所番号;
    private Decimal dbWT0001_連番;
    private ShoKisaiHokenshaNo dbWT0001_証記載保険者番号;
    private HihokenshaNo dbWT0001_被保険者番号;
    private FlexibleDate dbWT0001_サービス提供年月末日;
    private RString dbWT0001_被保険者カナ氏名;
    private RString dbWT0001_被保険者氏名;
    private LasdecCode dbWT0001_旧市町村コード;
    private HihokenshaNo dbWT0001_変換被保険者番号;
    private HihokenshaNo dbWT0001_登録被保険者番号;
    private LasdecCode dbWT0001_市町村コード;
    private RString dbWT0001_管内管外区分;
    private RString dbWT0001_郵便番号;
    private RString dbWT0001_町域コード;
    private RString dbWT0001_行政区コード;
    private RString dbWT0001_行政区名;
    private RString dbWT0001_住所;
    private RString dbWT0001_番地;
    private RString dbWT0001_方書;
    private RString dbWT0001_宛名カナ名称;
    private RString dbWT0001_宛名名称;
    private RString dbWT0001_氏名50音カナ;
    private ShikibetsuCode dbWT0001_識別コード;
    private FlexibleDate dbWT0001_資格取得日;
    private RString dbWT0001_資格取得事由コード;
    private FlexibleDate dbWT0001_資格喪失日;
    private RString dbWT0001_資格喪失事由コード;
    private HihokenshaNo dbWT0001_世帯集約番号;
    private List<DbT3048ShokanFukushiYoguHanbaihiEntity> 福祉用具List;
    private List<DbT3049ShokanJutakuKaishuEntity> 請求住宅改修List;

}
