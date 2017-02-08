/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitext1a4.TokkiTextEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項ののReportです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText1A4Report extends Report<TokkiText1ReportSource> {

    private final TokkiText1A4Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public TokkiText1A4Report(TokkiText1A4Entity entity) {
        this.entity = entity;
    }

    /**
     * 特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText1ReportSource> reportSourceWriter) {
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
            int 最大表示行数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.特記事項最大表示行数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
            count = entity.get特記事項リスト().size() / 最大表示行数 + 1;
        }
        if (entity.get特記事項全イメージリスト() != null && !entity.get特記事項全イメージリスト().isEmpty()) {
            count = entity.get特記事項全イメージリスト().size();
        }
        for (int index = 0; index < count; index++) {
            ITokkiText1A4Builder buildera = new TokkiText1A4Builder(entity, list, index);
            reportSourceWriter.writeLine(buildera);
        }
    }
}
