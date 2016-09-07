/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額サービス等支給（不支給）決定通知書情報一時TBLと事業高額決定通知書情報一時TBL情報を取得用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KetteiTsuchishoInfoTempResultEntity implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private int 履歴番号;
    private HokenshaNo 証記載保険者番号;
    private FlexibleDate 受付年月日;
    private RString 支払方法区分コード;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了期間;
    private FlexibleDate 決定年月日;
    private RString 決定通知No;
    private RString 不支給理由;
    private RString 支給結果;
    private Decimal 支払金額;
    private RString 支払金額内訳_利用者分;
    private RString 審査方法区分;
    private Decimal 本人支払額;
    private boolean 自動償還対象フラグ;
    private RString 支給区分コード;
    private Decimal 高額支給額;

    private KinyuKikanCode 金融機関コード;
    private RString 金融機関名称;
    private KinyuKikanShitenCode 支店コード;
    private RString 支店名称;
    private RString 預金種別;
    private RString 預金種別名称;
    private RString 口座番号;
    private ShikibetsuCode 口座名義人漢字;
    private FlexibleDate 口座終了年月日;
    private RString 通帳番号;

    private FlexibleDate 資格喪失年月日;
    private ShikibetsuCode 識別コード;
    private RString 資格喪失事由コード;

    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;

    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
}
