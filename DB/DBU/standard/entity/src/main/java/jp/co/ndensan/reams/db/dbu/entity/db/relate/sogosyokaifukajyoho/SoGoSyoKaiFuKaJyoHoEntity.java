/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.sogosyokaifukajyoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBU0600041_総合照会_賦課情報Entity
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SoGoSyoKaiFuKaJyoHoEntity {

    private RString choshuHouhou;
    private int ki;
    private Decimal choteiId;
    private Long shunoId;
    private Decimal choteigaku;
}
