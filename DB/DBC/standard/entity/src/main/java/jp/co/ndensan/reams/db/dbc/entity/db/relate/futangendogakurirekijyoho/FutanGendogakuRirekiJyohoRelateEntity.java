/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futangendogakurirekijyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * IFutanGendogakuRirekiJyohoMapper_負担限度額履歴情報 Entityのクラスです。
 *
 * @reamsid_L DBC-4350-090 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuRirekiJyohoRelateEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 減免_減額種類;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private Decimal 食費負担限度額;
    private Decimal ユニット型個室;
    private Decimal ユニット型準個室;
    private Decimal 従来型個室_特養等;
    private Decimal 従来型個室_老健_療養等;
    private Decimal 多床室;
}
