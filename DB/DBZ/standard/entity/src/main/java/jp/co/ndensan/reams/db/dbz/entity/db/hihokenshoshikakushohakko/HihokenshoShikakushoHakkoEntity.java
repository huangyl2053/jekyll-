/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証資格証発行情報取得Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshoShikakushoHakkoEntity {

    private RString 要介護認定状態区分コード;
    private FlexibleDate 受給申請年月日;
    private FlexibleDate 認定年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private RString 支給限度単位数;
    private FlexibleDate 支給限度有効開始年月日;
    private FlexibleDate 支給限度有効終了年月日;
    private RString 市町村コード;
    private RString 保険者名称;
    private RString 介護認定審査会意見;
    private ServiceTypeListEntity serviceTypeListEntity;
    private RString 給付制限内容１;
    private RString 制限期間開始１;
    private RString 制限期間終了１;
    private RString 給付制限内容２;
    private RString 制限期間開始２;
    private RString 制限期間終了２;
    private RString 給付制限内容３;
    private RString 制限期間開始３;
    private RString 制限期間終了３;
    private RString 事業者１;
    private FlexibleDate 届出年月日１;
    private FlexibleDate 適用開始年月日１;
    private RString 事業者２;
    private FlexibleDate 届出年月日２;
    private FlexibleDate 適用開始年月日２;
    private RString 事業者３;
    private FlexibleDate 届出年月日３;
    private FlexibleDate 適用開始年月日３;
    private RString 入所施設１;
    private FlexibleDate 入所年月日１;
    private FlexibleDate 退所年月日１;
    private RString 入所施設２;
    private FlexibleDate 入所年月日２;
    private FlexibleDate 退所年月日２;
    private RString 入所施設３;
    private FlexibleDate 入所年月日３;
    private FlexibleDate 退所年月日３;

}
