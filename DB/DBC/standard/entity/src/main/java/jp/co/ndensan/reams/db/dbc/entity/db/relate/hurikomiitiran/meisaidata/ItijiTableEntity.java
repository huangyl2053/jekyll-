/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiDataKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細一時TBLEntity
 *
 * @reamsid_L DBC-2180-050 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItijiTableEntity {

    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private RString 履歴番号;
    private RString 郵便番号;
    private RString 氏名漢字;
    private ShiharaiHohoKubun 支払方法区分コード;
    private RString 金融機関コード;
    private RString 支店コード;
    private RString 金融機関名称;
    private RString 預金種別名称;
    private RString 口座番号;
    private RString 決定通知番号;
    private RString 申請区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private Decimal 振込金額;
    private RString 前回支払金額;
    private RString 住所;
    private RString 支店名称;
    private RString 口座名義人;
    private boolean 申請データフラグ;
    private RString 要介護認定状態区分コード;
    private Furikomi_MeisaiDataKubun データ区分;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RTime 支払窓口開始時間;
    private RTime 支払窓口終了時間;

}
