/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsaHanteiJokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoReport extends Report<ShinsaHanteiJokyoReportSource> {

    private final ShinsaHanteiJokyoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item ShinsaHanteiJokyoEntity
     */
    public ShinsaHanteiJokyoReport(ShinsaHanteiJokyoEntity item) {
        this.item = item;
    }

    /**
     * 介護認定審査会判定状況表を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsaHanteiJokyoReportSource> reportSourceWriter) {
        for (ShisahanteiJokyo entity : getdate(item)) {
            ShinsaHanteiJokyoEditorImpl editor = new ShinsaHanteiJokyoEditorImpl(item);
            ShinsaHanteiJokyoBodyEditor body = new ShinsaHanteiJokyoBodyEditor(entity);
            IShinsaHanteiJokyoBuilder builder = new ShinsaHanteiJokyoBuilderImpl(editor, body);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShisahanteiJokyo> getdate(ShinsaHanteiJokyoEntity entity) {
        List<ShisahanteiJokyo> list = new ArrayList<>();
        list.add(new ShisahanteiJokyo(
                RString.EMPTY,
                entity.get二次判定非該当タイトル(),
                entity.get二次判定要支援1タイトル(),
                entity.get二次判定要支援2タイトル(),
                entity.get二次判定要介護1タイトル(),
                entity.get二次判定要介護2タイトル(),
                entity.get二次判定要介護3タイトル(),
                entity.get二次判定要介護3タイトル(),
                entity.get二次判定要介護5タイトル(),
                entity.get一次判定計タイトル(),
                entity.get一次判定非該当再調査二次保留分(),
                entity.get一次判定非該当判定変更者数(),
                entity.get一次判定非該当軽度変更者数(),
                entity.get一次判定非該当重度変更者数(),
                entity.get一次判定非該当判定変更割合()));
        list.add(new ShisahanteiJokyo(
                entity.get一次判定要支援1タイトル(),
                entity.get一次判定要支援1二次判定非該当(),
                entity.get一次判定非該当二次判定要支援1(),
                entity.get一次判定非該当二次判定要支援2(),
                entity.get一次判定非該当二次判定要介護1(),
                entity.get一次判定非該当二次判定要介護2(),
                entity.get一次判定非該当二次判定要介護3(),
                entity.get一次判定非該当二次判定要介護4(),
                entity.get一次判定非該当二次判定要介護5(),
                entity.get一次判定非該当計(),
                entity.get一次判定非該当再調査二次保留分(),
                entity.get一次判定非該当判定変更者数(),
                entity.get一次判定非該当軽度変更者数(),
                entity.get一次判定非該当重度変更者数(),
                entity.get一次判定非該当判定変更割合()));
        list.add(new ShisahanteiJokyo(
                entity.get一次判定要支援2タイトル(),
                entity.get一次判定要支援2二次判定非該当(),
                entity.get一次判定要支援2二次判定要支援1(),
                entity.get一次判定要支援2二次判定要支援2(),
                entity.get一次判定要支援2二次判定要介護1(),
                entity.get一次判定要支援2二次判定要介護2(),
                entity.get一次判定要支援2二次判定要介護2(),
                entity.get一次判定要支援2二次判定要介護2(),
                entity.get一次判定要支援2二次判定要介護5(),
                entity.get一次判定要支援2計(),
                entity.get一次判定要支援2再調査二次保留分(),
                entity.get一次判定要支援2判定変更者数(),
                entity.get一次判定要支援2軽度変更者数(),
                entity.get一次判定要支援2重度変更者数(),
                entity.get一次判定要支援2判定変更割合()));
        list.add(new ShisahanteiJokyo(
                entity.get一次判定要介護1タイトル(),
                entity.get一次判定要介護1タイトル(),
                entity.get一次判定要介護1二次判定要支援1(),
                entity.get一次判定要介護1二次判定要支援2(),
                entity.get一次判定要介護1二次判定要介護1(),
                entity.get一次判定要介護1二次判定要介護2(),
                entity.get一次判定要介護1二次判定要介護3(),
                entity.get一次判定要介護1二次判定要介護4(),
                entity.get一次判定要介護1二次判定要介護5(),
                entity.get一次判定要介護1計(),
                entity.get一次判定要介護1再調査二次保留分(),
                entity.get一次判定要介護1判定変更者数(),
                entity.get一次判定要介護1軽度変更者数(),
                entity.get一次判定要介護1重度変更者数(),
                entity.get一次判定要介護1判定変更割合()));
        list.add(new ShisahanteiJokyo(
                entity.get一次判定要介護2タイトル(),
                entity.get一次判定要介護2二次判定非該当(),
                entity.get一次判定要介護2二次判定要支援1(),
                entity.get一次判定要介護2二次判定要支援2(),
                entity.get一次判定要介護2二次判定要介護1(),
                entity.get一次判定要介護2二次判定要介護2(),
                entity.get一次判定要介護2二次判定要介護3(),
                entity.get一次判定要介護2二次判定要介護4(),
                entity.get一次判定要介護2二次判定要介護5(),
                entity.get一次判定要介護2計(),
                entity.get一次判定要介護2再調査二次保留分(),
                entity.get一次判定要介護2判定変更者数(),
                entity.get一次判定要介護2軽度変更者数(),
                entity.get一次判定要介護2重度変更者数(),
                entity.get一次判定要介護2判定変更割合()));
        list.add(new ShisahanteiJokyo(
                entity.get一次判定要介護3タイトル(),
                entity.get一次判定要介護3タイトル(),
                entity.get一次判定要介護3二次判定要支援1(),
                entity.get一次判定要介護3二次判定要支援2(),
                entity.get一次判定要介護3二次判定要介護1(),
                entity.get一次判定要介護3二次判定要介護2(),
                entity.get一次判定要介護3二次判定要介護3(),
                entity.get一次判定要介護3二次判定要介護4(),
                entity.get一次判定要介護3二次判定要介護5(),
                entity.get一次判定要介護3計(),
                entity.get一次判定要介護3再調査二次保留分(),
                entity.get一次判定要介護3判定変更者数(),
                entity.get一次判定要介護3軽度変更者数(),
                entity.get一次判定要介護3重度変更者数(),
                entity.get一次判定要介護3判定変更割合()));
        list.add(new ShisahanteiJokyo(entity.get一次判定要介護4タイトル(),
                entity.get一次判定要介護4二次判定非該当(),
                entity.get一次判定要介護4二次判定要支援1(),
                entity.get一次判定要介護4二次判定要支援2(),
                entity.get一次判定要介護4二次判定要介護1(),
                entity.get一次判定要介護4二次判定要介護2(),
                entity.get一次判定要介護4二次判定要介護3(),
                entity.get一次判定要介護4二次判定要介護4(),
                entity.get一次判定要介護4二次判定要介護5(),
                entity.get一次判定要介護4計(),
                entity.get一次判定要介護4再調査二次保留分(),
                entity.get一次判定要介護4判定変更者数(),
                entity.get一次判定要介護4軽度変更者数(),
                entity.get一次判定要介護4重度変更者数(),
                entity.get一次判定要介護4判定変更割合()));
        list.add(new ShisahanteiJokyo(entity.get一次判定要介護5タイトル(),
                entity.get一次判定要介護5二次判定非該当(),
                entity.get一次判定要介護5二次判定要支援1(),
                entity.get一次判定要介護5二次判定要支援2(),
                entity.get一次判定要介護5二次判定要介護1(),
                entity.get一次判定要介護5二次判定要介護2(),
                entity.get一次判定要介護5二次判定要介護3(),
                entity.get一次判定要介護5二次判定要介護4(),
                entity.get一次判定要介護5二次判定要介護5(),
                entity.get一次判定要介護5計(),
                entity.get一次判定要介護5再調査二次保留分(),
                entity.get一次判定要介護5判定変更者数(),
                entity.get一次判定要介護5軽度変更者数(),
                entity.get一次判定要介護5重度変更者数(),
                entity.get一次判定要介護5判定変更割合()));
        set計(list, entity);
        return list;

    }

    private void set計(List<ShisahanteiJokyo> list, ShinsaHanteiJokyoEntity entity) {
        list.add(new ShisahanteiJokyo(entity.get計タイトル(),
                entity.get計二次判定非該当(),
                entity.get計二次判定要支援1(),
                entity.get計二次判定要支援2(),
                entity.get計二次判定要介護1(),
                entity.get計二次判定要介護2(),
                entity.get計二次判定要介護3(),
                entity.get計二次判定要介護4(),
                entity.get計二次判定要介護5(),
                entity.get計計(),
                entity.get計再調査二次保留分(),
                entity.get計判定変更者数(),
                entity.get計軽度変更者数(),
                entity.get計重度変更者数(),
                entity.get計判定変更割合()));
        list.add(new ShisahanteiJokyo(entity.get変更者タイトル(),
                entity.get変更者二次判定非該当(),
                entity.get変更者二次判定要支援1(),
                entity.get変更者二次判定要支援2(),
                entity.get変更者二次判定要介護1(),
                entity.get変更者二次判定要介護2(),
                entity.get変更者二次判定要介護3(),
                entity.get変更者二次判定要介護4(),
                entity.get変更者二次判定要介護5(),
                entity.get変更者計(),
                entity.get変更者再調査二次保留分(),
                entity.get変更者判定変更者数(),
                entity.get変更者軽度変更者数(),
                entity.get変更者重度変更者数(),
                entity.get変更者判定変更割合()));
        list.add(new ShisahanteiJokyo(entity.get割合タイトル(),
                entity.get割合二次判定非該当(),
                entity.get割合二次判定要支援1(),
                entity.get割合二次判定要支援2(),
                entity.get割合二次判定要介護1(),
                entity.get割合二次判定要介護2(),
                entity.get割合二次判定要介護3(),
                entity.get割合二次判定要介護4(),
                entity.get割合二次判定要介護5(),
                entity.get割合計(),
                entity.get割合再調査二次保留分(),
                entity.get割合判定変更者数(),
                entity.get割合軽度変更者数(),
                entity.get割合重度変更者数(),
                entity.get割合判定変更割合()));
    }
}
