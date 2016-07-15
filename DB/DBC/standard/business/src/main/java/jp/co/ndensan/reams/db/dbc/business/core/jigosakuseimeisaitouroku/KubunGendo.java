/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBC0120031_サービス利用票情報 区分限度額統計処理
 *
 * @reamsid_L DBC-1930-060 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KubunGendo {

    private Decimal 区分支給限度額;
    private FlexibleDate 管理期間開始日;
    private FlexibleDate 管理期間終了日;
}
