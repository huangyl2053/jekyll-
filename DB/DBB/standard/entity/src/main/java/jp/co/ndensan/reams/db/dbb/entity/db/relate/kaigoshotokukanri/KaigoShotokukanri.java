/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshotokukanri;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護所得管理情報のEntity
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoShotokukanri {

    private LasdecCode 市町村コード;
    private RString 市町村識別ID;
    private FlexibleYear 所得年度;
    private ShikibetsuCode 識別コード;
    private RString 履歴番号;
    private RString 課税区分_住民税減免前;
    private RString 課税区分_住民税減免後;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private Decimal 公的年金所得額;
    private Decimal 課税所得額;
    private RString 激変緩和措置区分;
    private RString 優先区分;
    private YMDHMS 処理日時;

}
