/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * ケアマネージャの振る舞いを定義します。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャインタフェース
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
public interface ICareManager {

    /**
     * 介護支援専門員番号を返します。
     *
     * @return 介護支援専門員番号
     */
    RString get介護支援専門員番号();

    /**
     * ケアマネージャ氏名を返します。
     *
     * @return ケアマネージャ氏名
     */
    IName get氏名();

    /**
     * 所属事業者を返します。
     *
     * @return 所属事業者
     */
    IKaigoJigyosha get所属事業者();

    /**
     * 有効開年月日と有効終了年月日を返します。
     *
     * @return 有効年月日範囲
     */
    Range<FlexibleDate> get有効年月日();
}
