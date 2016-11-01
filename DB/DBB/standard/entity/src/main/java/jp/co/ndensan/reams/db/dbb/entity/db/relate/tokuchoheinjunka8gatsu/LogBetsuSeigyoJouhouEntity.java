/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * ランク別制御情報取得のクラスです。
 *
 * @reamsid_L DBB-0860-030 jiangxiaolong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class LogBetsuSeigyoJouhouEntity {

    private RString dankaiIndex;
    private FlexibleYear fukaNendo;
    private Decimal hokenryoRitsu;
    private RString rankuKubun;

}
