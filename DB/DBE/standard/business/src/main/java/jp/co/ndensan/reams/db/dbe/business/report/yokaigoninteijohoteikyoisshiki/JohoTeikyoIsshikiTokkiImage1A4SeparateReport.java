/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供一式特記事項のReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiTokkiImage1A4SeparateReport extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final TokkiText1A4Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public JohoTeikyoIsshikiTokkiImage1A4SeparateReport(TokkiText1A4Entity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        List<RString> list = new ArrayList();
        int count = 0;
        if (entity.get特記事項番号リスト() != null && !entity.get特記事項番号リスト().isEmpty()) {
            for (TokkiTextEntity tokki : entity.get特記事項番号リスト()) {
                list.add(tokki.get特記事項番号());
                list.add(tokki.get特記事項名称());
            }
            count = list.size();
        }
        if (entity.get特記事項イメージリスト() != null && !entity.get特記事項イメージリスト().isEmpty()) {
            for (TokkiTextEntity tokki : entity.get特記事項イメージリスト()) {
                list.add(tokki.get特記事項番号());
                list.add(tokki.get特記事項名称());
            }
            count = list.size();
        }
        if (entity.get特記事項リスト() != null && !entity.get特記事項リスト().isEmpty()) {
            int 最大表示行数 = Integer.parseInt(
                    DbBusinessConfig.get(ConfigNameDBE.特記事項最大表示行数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
            count = entity.get特記事項リスト().size() / 最大表示行数 + 1;
        }
        if (entity.get特記事項全イメージリスト() != null && !entity.get特記事項全イメージリスト().isEmpty()) {
            count = entity.get特記事項全イメージリスト().size();
        }
        for (int index = 0; index < count; index++) {
            JohoTeikyoIsshikiTokkiImage1A4SeparateBuilder buildera = new JohoTeikyoIsshikiTokkiImage1A4SeparateBuilder(entity, list, index);
            reportSourceWriter.writeLine(buildera);
        }
    }
}
