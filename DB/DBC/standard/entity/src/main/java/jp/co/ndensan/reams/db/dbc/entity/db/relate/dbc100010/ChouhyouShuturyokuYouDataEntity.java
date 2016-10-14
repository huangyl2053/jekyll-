/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成取得Entity
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChouhyouShuturyokuYouDataEntity {

    private JigyoshaNo 介護住宅改修理由書作成事業者番号;
    private Decimal 介護住宅改修理由書作成請求金額;
    private Decimal 介護住宅改修理由書作成単価;
    private int 介護住宅改修理由書作成件数;
    private RString 介護住宅改修事業者名称;
    private FlexibleDate 介護住宅改修理由書作成年月日;
    private HihokenshaNo 被保険者番号;
    private RString 改修対象住宅住所;
    private RString 改修内容箇所及び規模;
    private RString 介護住宅改修理由書作成者名;
    private RString 名称;
    private ShikibetsuCode 識別コード;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private AtenaKanaMeisho 事業者名;
    private TelNo 電話番号;
    private AtenaMeisho 代表者名;
}
