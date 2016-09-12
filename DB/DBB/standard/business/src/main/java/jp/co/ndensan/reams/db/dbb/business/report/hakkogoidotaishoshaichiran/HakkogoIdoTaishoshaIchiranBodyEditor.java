/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 通知書発行後異動把握帳票BodyEditor
 *
 * @reamsid_L DBB-0690-030 surun
 */
public class HakkogoIdoTaishoshaIchiranBodyEditor implements IHakkogoIdoTaishoshaIchiranEditor {

    private final TsuchiShoHakkoGoIdosha 異動者;

    /**
     * コンストラクタです
     *
     * @param 異動者 TsuchiShoHakkoGoIdosha
     */
    public HakkogoIdoTaishoshaIchiranBodyEditor(TsuchiShoHakkoGoIdosha 異動者) {
        this.異動者 = 異動者;
    }

    @Override
    public HakkogoIdoTaishoshaIchiranSource edit(HakkogoIdoTaishoshaIchiranSource source) {
        if (異動者 != null) {
            source.listIdosha_1 = new RString(Integer.valueOf(異動者.get該当連番()).toString());
        }
        if (異動者 != null && 異動者.get被保険者番号() != null) {
            source.listIdosha_2 = 異動者.get被保険者番号().value();
        }
        if (異動者 != null && 異動者.get識別コード() != null) {
            source.listIdosha_3 = 異動者.get識別コード().value();
        }
        if (異動者 != null && 異動者.get通知書番号() != null) {
            source.listIdosha_4 = 異動者.get通知書番号().value();
        }
        if (異動者 != null && 異動者.get氏名() != null) {
            source.listIdosha_5 = 異動者.get氏名().getName().value();
        }
        if (異動者 != null && 異動者.get異動日() != null) {
            source.listIdosha_6 = 異動者.get異動日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        if (異動者 != null && 異動者.get異動内容() != null) {
            source.listIdosha_7 = 異動者.get異動内容().get名称();
        }
        return source;
    }
}
