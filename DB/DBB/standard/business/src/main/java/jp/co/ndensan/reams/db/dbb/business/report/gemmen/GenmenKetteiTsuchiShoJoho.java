/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免決定通知書情報 介護保険料減免決定情報を格納
 *
 * @reamsid_L DBB-0740-030 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GenmenKetteiTsuchiShoJoho {

    private FukaShojoho 賦課の情報更正前;
    private GemmenShojoho 減免の情報更正後;
    private IKojin 宛名;
    private IAtesaki 宛先;
    private Association 地方公共団体;
    private CaFt703FindNokumiEntity 納組情報;
    private ChohyoSeigyoKyotsu 帳票制御共通;
}
