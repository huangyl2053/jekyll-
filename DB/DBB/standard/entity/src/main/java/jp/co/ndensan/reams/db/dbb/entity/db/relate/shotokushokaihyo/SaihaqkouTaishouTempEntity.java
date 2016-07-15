/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再発行対象者Temp
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaihaqkouTaishouTempEntity {

    private ShikibetsuCode 識別コード;
    private LasdecCode 照会先地方公共団体コード;
    private SetaiCode 世帯コード;
    private YMDHMS 作成日時;
    private RString 課税区分減免前;
    private RString 課税区分減免後;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private Decimal 公的年金所得額;
    private Decimal 課税所得額;
    private RString 登録業務;
}
