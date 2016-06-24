/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoshaListJoho;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 通知書発行後異動把握帳票HeaderEditor
 *
 * @reamsid_L DBB-0690-030 surun
 */
public class HakkogoIdoTaishoshaIchiranHeaderEditor implements IHakkogoIdoTaishoshaIchiranEditor {

    private static final RString NENDO = new RString("年度");
    private final TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報;
    private final Association 導入団体クラス;
    private final YMDHMS 帳票作成日時;

    /**
     * コンストラクタです
     *
     * @param 発行後異動者一覧情報 TsuchiShoHakkogoIdoshaListJoho
     * @param 導入団体クラス Association
     * @param 帳票作成日時 YMDHMS
     */
    public HakkogoIdoTaishoshaIchiranHeaderEditor(TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報,
            Association 導入団体クラス, YMDHMS 帳票作成日時) {
        this.発行後異動者一覧情報 = 発行後異動者一覧情報;
        this.導入団体クラス = 導入団体クラス;
        this.帳票作成日時 = 帳票作成日時;
    }

    @Override
    public HakkogoIdoTaishoshaIchiranSource edit(HakkogoIdoTaishoshaIchiranSource source) {
        source.title = ReportIdDBB.DBB200028.getReportName();
        if (導入団体クラス != null && 導入団体クラス.get地方公共団体コード() != null) {
            source.hokenshaNo = 導入団体クラス.get地方公共団体コード().value();
        }
        if (導入団体クラス != null) {
            source.hokenshaName = 導入団体クラス.get市町村名();
        }
        if (帳票作成日時 != null) {
            RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成日.concat(" " + 帳票作成時);
        }
        if (発行後異動者一覧情報 != null && !発行後異動者一覧情報.get異動者リスト().isEmpty()
                && 発行後異動者一覧情報.get異動者リスト().get(0).get賦課年度() != null) {
            source.fukaNendo = 発行後異動者一覧情報.get異動者リスト().get(0).get賦課年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).toDateString().concat(NENDO);
        }
        if (発行後異動者一覧情報 != null) {
            source.tsuchishoName = 発行後異動者一覧情報.get通知書名();
        }
        if (発行後異動者一覧情報 != null && 発行後異動者一覧情報.get通知書発行日時() != null) {
            RString 通知書発行日 = 発行後異動者一覧情報.get通知書発行日時().getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            RString 通知書発行時 = 発行後異動者一覧情報.get通知書発行日時().getRDateTime().getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.tsuchishoHakkoTimeStamp = 通知書発行日.concat(" " + 通知書発行時);
        }
        if (発行後異動者一覧情報 != null && 発行後異動者一覧情報.get最終計算処理日時() != null) {
            RString 最終計算処理日 = 発行後異動者一覧情報.get最終計算処理日時().getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            RString 最終計算処理時 = 発行後異動者一覧情報.get最終計算処理日時().getRDateTime().getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.lastCalculationTimeStamp = 最終計算処理日.concat(" " + 最終計算処理時);
        }
        return source;
    }

}
