/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import jp.co.ndensan.reams.db.dbx.business.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護受給情報を照会するインターフェースです。
 *
 * @author N2218 村松 優
 * @jpName 受給台帳取得インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass ○
 * @reference
 */
public interface IJukyuDaichoFinder {

    /**
     * 識別コード、基準日に紐づく個別事項の介護受給情報を取得します。
     *
     * @param 識別コード 識別コード
     * @param 基準日 基準日
     * @return {@code 基準日}時点の{@code 識別コード}の介護受給情報
     */
    IKobetsuJikoKaigoJukyu get個別事項介護受給(ShikibetsuCode 識別コード, RDate 基準日);
}
