/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請を行うことができる者（被保険者、みなし2号など）を表すインターフェースです。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 Aチームで方針が決まった後に改修予定。Merge Request #1691:の#41064 UI-リアル・通して実装(認定申請登録)のDiscussion参照 2014年9月末
public interface INinteiShinseiTaishosha {

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    HihokenshaNo get被保険者番号();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    ShikibetsuCode get識別コード();

    /**
     * 被保険者区分を返します。
     *
     * @return 被保険者区分
     */
    HihokenshaKubun get被保険者区分();

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    IName get氏名();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    Gender get性別();

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    IDateOfBirth get生年月日();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    IJusho get住所();

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    SetaiCode get世帯コード();

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    RString get個人番号();

    /**
     * 住民種別を返します。
     *
     * @return 住民種別
     */
    JuminShubetsu get住民種別();
}
