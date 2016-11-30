package jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho;

import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免取消通知書情報 減免取消通知書情報を格納クラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenTorikesiTsuchiShoJoho {

    private FukaJoho 賦課の情報更正前;
    private GemmenJoho 減免の情報更正後;
    private IKojin 宛名;
    private IAtesaki 宛先;
    private Association 地方公共団体;
    private CaFt703FindNokumiEntity 納組情報;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private GennenKanen 年度区分;
}
