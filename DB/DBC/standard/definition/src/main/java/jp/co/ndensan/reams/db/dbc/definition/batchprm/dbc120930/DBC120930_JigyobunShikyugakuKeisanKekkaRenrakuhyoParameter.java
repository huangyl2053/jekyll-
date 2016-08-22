/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc120930;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNN2002_事業高額合算・事業分支給額計算結果連絡票（単）のバッチパラメータです。
 *
 * @reamsid_L DBC-4840-040 liuyang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120930_JigyobunShikyugakuKeisanKekkaRenrakuhyoParameter extends BatchParameterBase {

    @BatchParameter(key = "処理日時", name = "処理日時")
    private RDateTime 処理日時;
    @BatchParameter(key = "被保険者番号", name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @BatchParameter(key = "対象年度", name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = "連絡票整理番号", name = "連絡票整理番号")
    private RString 連絡票整理番号;
    @BatchParameter(key = "証記載保険者番号", name = "証記載保険者番号")
    private RString 証記載保険者番号;
}
