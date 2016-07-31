/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsu;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域運用抽出期間情報のエンティティクラスです。
 *
 * @reamsid_L DBU-0550-040 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigojuminhyokobetsuEntity {

    private RString shichosonShokibetsuID;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private YMDHMS taishoKaishiTimestamp;
    private YMDHMS taishoShuryoTimestamp;
}
