/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc3500011;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国保連情報データ媒体取込のクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaSofuListEntity {

    private RString 取込情報名称;
    private RString ファイル;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth 対象年月;
    private RDateTime 処理日時;
    private RString h一覧表示順;
}
