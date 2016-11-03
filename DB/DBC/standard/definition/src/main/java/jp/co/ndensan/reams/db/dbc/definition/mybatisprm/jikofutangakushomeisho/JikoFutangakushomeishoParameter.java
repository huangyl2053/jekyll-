/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMN63001_自己負担証明書作成
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikoFutangakushomeishoParameter {

    private HihokenshaNo 被保険者番号;
    private RString 保険者番号;
    private FlexibleYear 対象年度;
    private RString 支給申請書整理番号;
    private RString メニューID;
    private RString 申請状況区分;
    private RString 支給申請区分;

}
