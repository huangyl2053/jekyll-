/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用申請書
 *
 * @reamsid_L DBC-4640-040 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoShinseishoEntity {

    private SofubutsuAtesakiSource atesakiSource;
    private NinshoshaSource ninshoshaSource;
    private RString 文書番号;
    private RString タイトル;
    private RString その他被保険者;
    private RString 申請先;
    private RString 被保険者名カナ１;
    private RString 被保険者氏名１;
    private FlexibleDate 被保険者生年月日１;
    private RString 被保険者番号１;
    private RString 被保険者性別１;
    private ShikibetsuCode 識別コード１;
    private RString 被保険者名カナ２;
    private RString 被保険者氏名２;
    private FlexibleDate 被保険者生年月日２;
    private RString 被保険者番号２;
    private RString 被保険者性別２;
    private ShikibetsuCode 識別コード２;
    private RString 被保険者名カナ３;
    private RString 被保険者氏名３;
    private FlexibleDate 被保険者生年月日３;
    private RString 被保険者番号３;
    private RString 被保険者性別３;
    private RString 収入元号;
    private RString 収入年;
    private ShikibetsuCode 識別コード３;
    private RString 住所１;
    private RString 住所２;
    private RString 連絡先;
    private RString 通知文１;
    private RString 通知文２;
    private RString 通知文３;
    private RString 通知文4;
    private RString 通知文5;
    private RString 通知文6;
    private RString 通知文7;
    private RString 通知文８;
    private RString 通知文９;
    private RString 通知文１０;
    private RString 通知文１１;
    private RString 通知文１２;
    private RString 通知文１３;
    private RString 通知文１４;
    private RString 通知文１５;
    private RString 通知文１６;
    private RString 通知文１７;
    private RString 通知文１８;
    private RString 通知文１９;
    private RString 通知文２０;
    private RString 通知文２１;
    private RString 通知文２２;
    private RString 通知文２３;
    private RString 通知文２４;
    private RString 通知文２５;
    private RString 通知文２６;
    private RString 通知文２７;
    private RString 通知文２８;
    private RString 通知文２９;

}
