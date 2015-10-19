/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険の資格に関する情報を保持するインタフェースです。
 * <p>
 * ■関連クラス
 * <ul>
 * <li>{@link IKenkoHokenShikaku}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N8168 岩山 慎吾
 * @jpName 介護資格インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護資格
 * @mainClass ○
 * @reference
 * @deprecated 介護にて再設計します。
 */
public interface IKaigoShikaku extends Serializable {

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * 介護保険広域構成市町村コードを取得します。
     *
     * @return 介護保険広域構成市町村コード
     */
    RString get介護保険広域構成市町村コード();

    /**
     * 一号該当日を取得します。
     *
     * @return 一号該当日
     */
    RDate get一号該当日();
}
