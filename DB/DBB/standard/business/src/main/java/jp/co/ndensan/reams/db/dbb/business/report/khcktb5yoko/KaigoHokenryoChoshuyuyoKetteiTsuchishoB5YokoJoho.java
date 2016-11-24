/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険料徴収猶予決定通知書_徴収猶予決定通知書情報を格納
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho {

    private ChoshuYuyoJoho 徴収猶予の情報;
    private IKojin 宛名;
    private IAtesaki 宛先;
    private Association 地方公共団体;
    private CaFt703FindNokumiEntity 納組情報;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private GennenKanen 年度区分;
}
