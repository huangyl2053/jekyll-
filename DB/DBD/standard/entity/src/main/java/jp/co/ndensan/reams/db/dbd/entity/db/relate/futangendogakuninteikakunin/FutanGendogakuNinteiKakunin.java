/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定（一括）確認リストEntityクラスです。
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class FutanGendogakuNinteiKakunin {

    private HihokenshaNo 被保番号;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 要介護認定状態区分コード;
    private RString 厚労省IF識別コード;
    private boolean 旧措置フラグ;
    private RString 利用軽減;
    private RString 社福軽減;
    private RString 訪問減額;
    private RString 特地減免;
    private boolean 生活保護受給者;
    private boolean 老齢福祉年金受給者;
    private Decimal 合計所得金額;
    private SetaiKazeiKubun 世帯課税;
    private FlexibleDate 住民となった日;
    private Decimal 預貯金額;
    private Decimal 有価証券評価概算額;
    private Decimal その他金額;
    private KonkaiNinteiKekka 今回認定結果;
    private ZenkaiNinteiKekka 前回認定結果;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
