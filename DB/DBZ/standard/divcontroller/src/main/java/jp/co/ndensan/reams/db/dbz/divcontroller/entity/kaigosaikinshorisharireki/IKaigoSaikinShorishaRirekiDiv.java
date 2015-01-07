package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigosaikinshorisharireki;

import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ISaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 介護最近処理者履歴Divのインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKaigoSaikinShorishaRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 最近処理者履歴Divを返します。
     *
     * @return 最近処理者履歴Div
     */
    ISaikinShorishaRirekiDiv getWrappedSaikinShorishaRireki();
}
