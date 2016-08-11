/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBC100074_基準収入額適用決定通知書のパラメータクラスです。
 *
 * @reamsid_L DBC-4610-040 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoKetteiTsuchisho {

    private SofubutsuAtesakiSource compSofubutsuAtesakiソース;
    private NinshoshaSource compNinshoshaソース;
    private RString 文書番号;
    private RString タイトル;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private FlexibleYearMonth 適用開始年月;
    private Decimal 算定基準額;
    private HihokenshaNo 被保険者番号１;
    private AtenaKanaMeisho 被保険者名カナ１;
    private AtenaMeisho 被保険者氏名１;
    private ShikibetsuCode 識別コード１;
    private HihokenshaNo 被保険者番号２;
    private AtenaKanaMeisho 被保険者名カナ２;
    private AtenaMeisho 被保険者氏名２;
    private ShikibetsuCode 識別コード２;
    private HihokenshaNo 被保険者番号３;
    private AtenaKanaMeisho 被保険者名カナ３;
    private AtenaMeisho 被保険者氏名３;
    private ShikibetsuCode 識別コード３;
    private RString その他被保険者;
    private RString 通知文１;
    private RString 通知文２;
    private RString 通知文３_大;
    private RString 通知文4_上小;
    private RString 通知文5_下大;
    private RString 通知文6_上大;
    private RString 通知文7_下小;
    private boolean flag;
}
