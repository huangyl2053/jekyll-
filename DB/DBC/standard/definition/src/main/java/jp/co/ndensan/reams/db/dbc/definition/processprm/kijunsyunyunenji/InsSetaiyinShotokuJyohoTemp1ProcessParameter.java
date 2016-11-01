/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 基準収入額適用申請書_年次分作成のInsSetaiyinShotokuJyohoTemp1のParameterです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class InsSetaiyinShotokuJyohoTemp1ProcessParameter implements IBatchProcessParameter {

    private RString 抽出条件;
    private FlexibleDate 世帯員把握基準日;
    private ReportId 帳票ID;
    private Long 帳票出力順ID;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 世帯員把握基準日2;

}
