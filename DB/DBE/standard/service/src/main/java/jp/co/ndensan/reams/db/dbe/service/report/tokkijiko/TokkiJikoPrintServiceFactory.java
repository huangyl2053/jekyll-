/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.tokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;

/**
 * 特記事項のPrinterのファクトリークラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class TokkiJikoPrintServiceFactory {

    private static final RString すべて = new RString("1");

    private TokkiJikoPrintServiceFactory() {
    }

    /**
     * 特記事項のPrinterクラスを生成します。
     *
     * @param entity YokaigoNinteiJohoTeikyoEntity
     * @param 特記事項区分List 特記事項区分List
     * @param reportManager ReportManager
     * @return ITokkiJikoPrintService
     */
    public static ITokkiJikoPrintService create(YokaigoNinteiJohoTeikyoEntity entity, List<RString> 特記事項区分List, ReportManager reportManager) {
        if (特記事項区分List.contains(TokkijikoTextImageKubun.イメージ.getコード())) {
            FlexibleDate 特記事項判定日 = new FlexibleDate(DbBusinessConfig
                    .get(ConfigNameDBE.特記事項判定日, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
            if (entity.get認定申請年月日().isBeforeOrEquals(特記事項判定日)) {
                return new NinteiChosaTokkiImagePrintService(reportManager);
            } else {
                return new NinteiChosaTokkiImage1A4SeparatePrintService(reportManager);
            }
        } else if (特記事項区分List.contains(TokkijikoTextImageKubun.テキスト.getコード())) {
            RString 情報提供資料の特記事項編集パターン
                    = DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項編集パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (すべて.equals(情報提供資料の特記事項編集パターン)) {
                return new TokkiText1A4AllPrintService(reportManager);
            } else {
                return new TokkiText1A4SeparatePrintService(reportManager);
            }
        }
        return null;
    }
}
