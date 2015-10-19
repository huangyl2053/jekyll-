/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.codeassigneditem.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個別事項介護資格の情報を照会するインターフェースです。
 *
 * @author N2218 村松 優
 * @jpName 個別事項介護資格インタフェース
 * @bizDomain 介護
 * @category 個別事項
 * @subCategory
 * @mainClass
 * @reference
 */
public interface IKobetsuJikoKaigoShikaku extends Serializable {

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * 資格被保険者区分を取得します。
     *
     * @return 資格被保険者区分
     */
    ShikakuHihokenshaKubun get資格被保険者区分();

    /**
     * 住所地特例者区分を取得します。
     *
     * @return 住所地特例者区分
     */
    JushochiTokureishaKubun get住所地特例者区分();

    /**
     * 資格取得年月日を取得します。
     *
     * @return 資格取得年月日
     */
    RDate get資格取得年月日();

    /**
     * 資格取得事由を取得します。
     *
     * @return 資格取得事由
     */
    ShikakuShutokuJiyu get資格取得事由();

    /**
     * 資格喪失年月日を取得します。
     *
     * @return 資格喪失年月日
     *
     */
    RDate get資格喪失年月日();

    /**
     * 資格喪失事由を取得します。
     *
     * @return 資格喪失事由
     */
    ShikakuSoshitsuJiyu get資格喪失事由();
}
