/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険所得Temp
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShotokuTempEntity {

    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private AtenaKanaMeisho カナ名称;
    private AtenaMeisho 名称;
    private FlexibleYear 所得年度;
    private FlexibleDate 生年月日;
    private int 年齢;
    private RString 性別コード;
    private RString 住民種別コード;
    private RString 課税区分減免前;
    private RString 課税区分減免後;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private Decimal 公的年金所得額;
    private Decimal 課税所得額;
    private RString 登録業務;
}
