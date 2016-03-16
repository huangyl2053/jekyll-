/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.hakkogoidotaishoshaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoshaListJoho;
import jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranItem;
import jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * DBBRP32001_通知書発行後異動把握帳票PrintService
 */
public class HakkogoIdoTaishoshaIchiranPrintService {

    private static final RString TITLE = new RString("通知書発行後異動対象者一覧");
    
    /**
     * printメソッド
     *
     * @param 発行後異動者一覧情報 TsuchiShoHakkogoIdoshaListJoho
     * @param 導入団体クラス Association
     * @param 帳票作成日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection print(
            TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報,
            Association 導入団体クラス,
            YMDHMS 帳票作成日時) {
        HakkogoIdoTaishoshaIchiranProperty property = new HakkogoIdoTaishoshaIchiranProperty();
        List<HakkogoIdoTaishoshaIchiranItem> targets = setItems(発行後異動者一覧情報, 導入団体クラス, 帳票作成日時);
        return new Printer<HakkogoIdoTaishoshaIchiranSource>().spool(property, toReports(targets));
    }

    /**
     * toReportsメソッド
     *
     * @param targets List<HakkogoIdoTaishoshaIchiranItem>
     * @return List<HakkogoIdoTaishoshaIchiranReport>
     */
    private static List<HakkogoIdoTaishoshaIchiranReport> toReports(List<HakkogoIdoTaishoshaIchiranItem> targets) {
        List<HakkogoIdoTaishoshaIchiranReport> list = new ArrayList<>();
        list.add(HakkogoIdoTaishoshaIchiranReport.createForm(targets));
        return list;
    }

    /**
     * setItemsメソッド
     *
     * @param 発行後異動者一覧情報 TsuchiShoHakkogoIdoshaListJoho
     * @param 導入団体クラス Association
     * @param 帳票作成日時 YMDHMS
     * @return  List<HakkogoIdoTaishoshaIchiranItem>
     */
    private List<HakkogoIdoTaishoshaIchiranItem> setItems(
            TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報,
            Association 導入団体クラス,
            YMDHMS 帳票作成日時) {
        List<HakkogoIdoTaishoshaIchiranItem> targets = new ArrayList<>();
        if (!発行後異動者一覧情報.get異動者リスト().isEmpty()) {
            for (TsuchiShoHakkoGoIdosha tsuchiShoHakkoGoIdosha : 発行後異動者一覧情報.get異動者リスト()) {
                HakkogoIdoTaishoshaIchiranItem item = new HakkogoIdoTaishoshaIchiranItem();
                item.setHokenshaNo(導入団体クラス.get地方公共団体コード().value());
                item.setHokenshaName(導入団体クラス.get市町村名());
                item.setTsuchishoName(発行後異動者一覧情報.get通知書名());
                RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
                RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                item.setPrintTimeStamp(帳票作成日.concat(" " + 帳票作成時));
                // TODO 賦課年度
                //item.setFukaNendo(発行後異動者一覧情報.get異動者リスト().get(0).);
                RString 通知書発行日 = 発行後異動者一覧情報.get通知書発行日時().getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
                RString 通知書発行時 = 発行後異動者一覧情報.get通知書発行日時().getRDateTime().getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                item.setTsuchishoHakkoTimeStamp(通知書発行日.concat(" " + 通知書発行時));
                RString 最終計算処理日 = 発行後異動者一覧情報.get最終計算処理日時().getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
                RString 最終計算処理時 = 発行後異動者一覧情報.get最終計算処理日時().getRDateTime().getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                item.setLastCalculationTimeStamp(最終計算処理日.concat(" " + 最終計算処理時));
                item.setListIdosha_1(new RString(Integer.valueOf(tsuchiShoHakkoGoIdosha.get該当連番()).toString()));
                item.setListIdosha_2(tsuchiShoHakkoGoIdosha.get被保険者番号().value());
                // TODO 識別コード
                //item.setListIdosha_3(tsuchiShoHakkoGoIdosha.);
                // TODO 通知書番号
                //item.setListIdosha_4(tsuchiShoHakkoGoIdosha.get);
                item.setListIdosha_5(tsuchiShoHakkoGoIdosha.get氏名().getName().value());
                item.setListIdosha_6(tsuchiShoHakkoGoIdosha.get異動日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString());
                // TODO 異動内容
                //item.setListIdosha_7(tsuchiShoHakkoGoIdosha.get);
                item.setTitle(TITLE);
                targets.add(item);
            }
        }
        return targets;
    }
}
