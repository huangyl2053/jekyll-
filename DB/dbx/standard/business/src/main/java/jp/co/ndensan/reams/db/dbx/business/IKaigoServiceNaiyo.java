/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護サービス内容のインターフェースです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス内容インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IKaigoServiceNaiyo extends Serializable {

    /**
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    IKaigoServiceCode getサービスコード();

    /**
     * 適用年月を返します。
     *
     * @return 適用年月
     */
    Range<FlexibleYearMonth> get適用年月();

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    int get履歴番号();

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    RString getサービス名称();

    /**
     * サービス略称を返します。
     *
     * @return サービス略称
     */
    RString getサービス略称();

    /**
     * 介護サービス単位を返します。
     *
     * @return 介護サービス単位
     */
    IKaigoServiceTani get介護サービス単位();
}
