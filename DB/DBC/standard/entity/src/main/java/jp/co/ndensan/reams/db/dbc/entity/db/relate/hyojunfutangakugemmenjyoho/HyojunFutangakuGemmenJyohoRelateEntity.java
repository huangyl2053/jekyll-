/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hyojunfutangakugemmenjyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * IHyojunFutangakuGemmenJyohoMapper_標準負担額減免履歴情報 Entityのクラスです。
 *
 * @reamsid_L DBC-4350-090 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HyojunFutangakuGemmenJyohoRelateEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 減免_減額種類;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private Decimal 負担額;
}
