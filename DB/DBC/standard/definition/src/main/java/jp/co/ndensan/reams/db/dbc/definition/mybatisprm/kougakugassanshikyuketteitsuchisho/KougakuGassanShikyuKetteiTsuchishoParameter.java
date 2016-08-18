/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のパラメータ。
 *
 * @reamsid_L DBC-4850-040 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuGassanShikyuKetteiTsuchishoParameter implements IMyBatisParameter {

    private long 口座ID;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private RString 連絡票整理番号;
    private int 履歴番号;
}
