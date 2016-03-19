/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakuserviceketteishaichiranhyodata;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran.KogakuShikyuFushikyuKetteishaIchiranItem;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInYiLanEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;

/**
 * 高額サービス費支給（不支給）決定者一覧表
 */
public class KogakuServiceKetteishaIchiranhyoData {

    private final RString SPACE = new RString(" ");
    private final RString 固定文字 = new RString("該当データがありません");

    /**
     * 高額介護サービス費支給（不支給）決定者一覧表帳票用データリスト
     *
     * @param 高額サービス費決定情報Entity GaoesabisijuedingEntity
     * @return List<KogakuShikyuFushikyuKetteishaIchiranItem>
     */
    public List<KogakuShikyuFushikyuKetteishaIchiranItem> getKogakuServiceKetteishaIchiranhyoData(
            KogakuKyufuKetteiInEntity 高額サービス費決定情報Entity) {
        List<KogakuKyufuKetteiInYiLanEntity> 高額サービス費決定情報一覧リスト = 高額サービス費決定情報Entity
                .get高額サービス費決定情報一覧EntityList();
        List<KogakuShikyuFushikyuKetteishaIchiranItem> 帳票データList = new ArrayList<>();
        KogakuShikyuFushikyuKetteishaIchiranItem 帳票データ;
        RStringBuilder 印刷日時Builder = new RStringBuilder();
        RDateTime 支印刷時間 = RDate.getNowDateTime();
        RDate 印刷日 = RDate.getNowDate();
        印刷日時Builder.append(印刷日.wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
        印刷日時Builder.append(印刷日).append(SPACE);
        印刷日時Builder.append(String.format("%02d", 支印刷時間.getHour()));
        印刷日時Builder.append(new RString("時"));
        印刷日時Builder.append(String.format("%02d", 支印刷時間.getMinute()));
        印刷日時Builder.append(new RString("分"));
        印刷日時Builder.append(String.format("%02d", 支印刷時間.getSecond()));
        印刷日時Builder.append(new RString("秒"));
        if (高額サービス費決定情報一覧リスト.isEmpty()) {
            帳票データ = new KogakuShikyuFushikyuKetteishaIchiranItem();
            帳票データ.set国保連合会名(固定文字);
            帳票データ.set保険者番号(固定文字);
            帳票データ.set保険者名称(固定文字);
            帳票データ.set出力順１(高額サービス費決定情報Entity.get出力順１());
            帳票データ.set出力順２(高額サービス費決定情報Entity.get出力順2());
            帳票データ.set出力順３(高額サービス費決定情報Entity.get出力順3());
            帳票データ.set出力順４(高額サービス費決定情報Entity.get出力順4());
            帳票データ.set出力順５(高額サービス費決定情報Entity.get出力順5());
            帳票データ.set改頁１(高額サービス費決定情報Entity.get改頁１());
            帳票データ.set改頁２(高額サービス費決定情報Entity.get改頁2());
            帳票データ.set改頁３(高額サービス費決定情報Entity.get改頁3());
            帳票データ.set改頁４(高額サービス費決定情報Entity.get改頁4());
            帳票データ.set改頁５(高額サービス費決定情報Entity.get改頁5());
            帳票データ.set印刷日時(印刷日時Builder.toRString());
            帳票データ.set氏名(固定文字);
            帳票データ.setページ数(new RString("1"));
            帳票データList.add(帳票データ);
        }
        for (KogakuKyufuKetteiInYiLanEntity entity : 高額サービス費決定情報一覧リスト) {
            帳票データ = new KogakuShikyuFushikyuKetteishaIchiranItem();
            帳票データ.set国保連合会名(entity.get国保連合会名());
            帳票データ.set保険者番号(new RString(entity.get保険者番号().toString()));
            帳票データ.set保険者名称(entity.get保険者名());
            帳票データ.set出力順１(高額サービス費決定情報Entity.get出力順１());
            帳票データ.set出力順２(高額サービス費決定情報Entity.get出力順2());
            帳票データ.set出力順３(高額サービス費決定情報Entity.get出力順3());
            帳票データ.set出力順４(高額サービス費決定情報Entity.get出力順4());
            帳票データ.set出力順５(高額サービス費決定情報Entity.get出力順5());
            帳票データ.set改頁１(高額サービス費決定情報Entity.get改頁１());
            帳票データ.set改頁２(高額サービス費決定情報Entity.get改頁2());
            帳票データ.set改頁３(高額サービス費決定情報Entity.get改頁3());
            帳票データ.set改頁４(高額サービス費決定情報Entity.get改頁4());
            帳票データ.set改頁５(高額サービス費決定情報Entity.get改頁5());
            帳票データ.set印刷日時(印刷日時Builder.toRString());
            ReportManager manager = new ReportManager();
//            manager.reportAssembler(new RString(
//                    "DBC200015_KogakuShikyuFushikyuKetteishaIchiran"), SubGyomuCode.DBC介護給付);
//            帳票データ.setページ数(manager.reportAssembler(new RString(
//                    "DBC200015_KogakuShikyuFushikyuKetteishaIchiran"), SubGyomuCode.DBC介護給付)
//                    .create().getPageCount());
            // TODO 共通クラスReportAssemblerのgetPageCountメソッドから取得する。
//            帳票データ.setページ数(1);
            帳票データ.set通知書番号(entity.get通知書番号());
            帳票データ.set被保険者番号(new RString(entity.get被保険者番号().toString()));
            帳票データ.set氏名カナ(new RString(entity.get氏名カナ().toString()));
            帳票データ.set氏名(new RString(entity.get氏名().toString()));
            帳票データ.setサービス提供年月(entity.getサービス提供年月().wareki().toDateString());
            帳票データ.set決定年月(entity.get決定年月().wareki().toDateString());
            帳票データ.set支払可否(entity.get支払可否());
            帳票データ.set支払方法(entity.get支払方法());
            帳票データ.set利用者負担額(new RString(entity.get利用者負担額().toString()));
            帳票データ.set決定支給額(new RString(entity.get決定支給額().toString()));
            帳票データ.set喪失事由(entity.get喪失事由());
            帳票データ.set喪失年月日(entity.get喪失年月日().wareki().toDateString());
            帳票データ.set住所コード(entity.get住所コード());
            帳票データ.set行政区コード(entity.get行政区コード());
            帳票データ.set郵便番号(new RString(entity.get郵便番号().toString()));
            帳票データ.set住所(new RString(entity.get住所().toString()));
            帳票データ.set行政区(entity.get行政区());
            帳票データ.set備考(entity.get備考());
            帳票データList.add(帳票データ);
        }
        return 帳票データList;
    }
}
