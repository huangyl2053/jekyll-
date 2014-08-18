/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
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
    public KaigoHihokenshaNo get被保険者番号();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード();

    /**
     * 被保険者区分を返します。
     *
     * @return 被保険者区分
     */
    public HihokenshaKubun get被保険者区分();

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public IName get氏名();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Gender get性別();

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public IDateOfBirth get生年月日();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public IJusho get住所();

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード();

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
