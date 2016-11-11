/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額計算結果一覧表Entity
 *
 * @reamsid_L DBC-2060-040 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJikofutangakuKeisanKekkaIchiranEntity {

    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 申請書整理番号;
    private FlexibleDate 申請年月日;
    private FlexibleYear 申請対象年度;
    private FlexibleDate 介護加入期間開始;
    private FlexibleDate 介護加入期間終了;
    private Decimal 自己負担額;
    private Decimal 高額支給額;
    private Decimal oneTwo;
    private Decimal 自己負担額内数;
    private RString 備考資格期間不正;
    private RString 備考高額支給額確認データ;
    private RString 識別コード;
    private RString 住民種別コード;
    private RString 一覧用確認区分;
    private RString 一覧用確認区分２;
    private RString yubinNo;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString hokenshaNo;
    private RString shichosonCode;
}
