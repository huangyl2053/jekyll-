/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN63003_高額合算支給決定通知書（単）のパラメータ。
 *
 * @reamsid_L DBC-2310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuKetteiTsuchiParameter {

    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private ReportId 帳票ID;
    private FlexibleYear 対象年度;
    private RString 連絡票整理番号;
    private int 履歴番号;
    private RString 文書番号;
    private FlexibleDate 発行日;
    private FlexibleDate 支払予定日;
    private long 口座ID;
}
