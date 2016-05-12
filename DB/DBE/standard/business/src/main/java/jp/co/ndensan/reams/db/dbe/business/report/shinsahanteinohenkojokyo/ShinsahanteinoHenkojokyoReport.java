/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyo;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 審査判定の変更状況のReportです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsahanteinoHenkojokyoReport extends Report<ShinsahanteinoHenkojokyoReportSource> {

    private final ShinsahanteinoHenkojokyo data;

    /**
     * インスタンスを生成します。
     *
     * @param data 審査判定の変更状況のdataList
     */
    public ShinsahanteinoHenkojokyoReport(ShinsahanteinoHenkojokyo data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsahanteinoHenkojokyoReportSource> reportSourceWriter) {
        for (ShinsahanteinoHenkojokyoBody dataBody : getBodyData(data)) {
            IShinsahanteinoHenkojokyoEditor editor = new ShinsahanteinoHenkojokyoEditor(data);
            IShinsahanteinoHenkojokyoBodyEditor bodyEditor = new ShinsahanteinoHenkojokyoBodyEditor(dataBody);
            IShinsahanteinoHenkojokyoBuilder builder = new ShinsahanteinoHenkojokyoBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShinsahanteinoHenkojokyoBody> getBodyData(ShinsahanteinoHenkojokyo data) {
        List<ShinsahanteinoHenkojokyoBody> dataBodyList = new ArrayList<>();
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(data.get更新申請_二次判定非該当(),
                data.get更新申請_二次判定要支援1(),
                data.get更新申請_二次判定要支援2(),
                data.get更新申請_二次判定要介護1(),
                data.get更新申請_二次判定要介護2(),
                data.get更新申請_二次判定要介護3(),
                data.get更新申請_二次判定要介護4(),
                data.get更新申請_二次判定要介護5(),
                data.get更新申請_計(),
                data.get新規申請_二次判定非該当(),
                data.get新規申請_二次判定要支援1(),
                data.get新規申請_二次判定要支援2(),
                data.get新規申請_二次判定要介護1(),
                data.get新規申請_二次判定要介護2(),
                data.get新規申請_二次判定要介護3(),
                data.get新規申請_二次判定要介護4(),
                data.get新規申請_二次判定要介護5(),
                data.get新規申請_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                data.get更新_認定有効期間延長件数_二次判定要支援1(),
                data.get更新_認定有効期間延長件数_二次判定要支援2(),
                data.get更新_認定有効期間延長件数_二次判定要介護1(),
                data.get更新_認定有効期間延長件数_二次判定要介護2(),
                data.get更新_認定有効期間延長件数_二次判定要介護3(),
                data.get更新_認定有効期間延長件数_二次判定要介護4(),
                data.get更新_認定有効期間延長件数_二次判定要介護5(),
                data.get更新_認定有効期間延長件数_計(),
                data.get新規_区分変更申請_二次判定非該当(),
                data.get新規_区分変更申請_二次判定要支援1(),
                data.get新規_区分変更申請_二次判定要支援2(),
                data.get新規_区分変更申請_二次判定要介護1(),
                data.get新規_区分変更申請_二次判定要介護2(),
                data.get新規_区分変更申請_二次判定要介護3(),
                data.get新規_区分変更申請_二次判定要介護4(),
                data.get新規_区分変更申請_二次判定要介護5(),
                data.get新規_区分変更申請_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                data.get更新_３ヶ月_二次判定要支援1(),
                data.get更新_３ヶ月_二次判定要支援2(),
                data.get更新_３ヶ月_二次判定要介護1(),
                data.get更新_３ヶ月_二次判定要介護2(),
                data.get更新_３ヶ月_二次判定要介護3(),
                data.get更新_３ヶ月_二次判定要介護4(),
                data.get更新_３ヶ月_二次判定要介護5(),
                data.get更新_３ヶ月_計(),
                RString.EMPTY,
                data.get新規_認定有効期間延長件数_二次判定要支援1(),
                data.get新規_認定有効期間延長件数_二次判定要支援2(),
                data.get新規_認定有効期間延長件数_二次判定要介護1(),
                data.get新規_認定有効期間延長件数_二次判定要介護2(),
                data.get新規_認定有効期間延長件数_二次判定要介護3(),
                data.get新規_認定有効期間延長件数_二次判定要介護4(),
                data.get新規_認定有効期間延長件数_二次判定要介護5(),
                data.get新規_認定有効期間延長件数_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                data.get更新_６ヶ月_二次判定要支援1(),
                data.get更新_６ヶ月_二次判定要支援2(),
                data.get更新_６ヶ月_二次判定要介護1(),
                data.get更新_６ヶ月_二次判定要介護2(),
                data.get更新_６ヶ月_二次判定要介護3(),
                data.get更新_６ヶ月_二次判定要介護4(),
                data.get更新_６ヶ月_二次判定要介護5(),
                data.get更新_６ヶ月_計(),
                RString.EMPTY,
                data.get新規_３ヶ月_二次判定要支援1(),
                data.get新規_３ヶ月_二次判定要支援2(),
                data.get新規_３ヶ月_二次判定要介護1(),
                data.get新規_３ヶ月_二次判定要介護2(),
                data.get新規_３ヶ月_二次判定要介護3(),
                data.get新規_３ヶ月_二次判定要介護4(),
                data.get新規_３ヶ月_二次判定要介護5(),
                data.get新規_３ヶ月_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                data.get更新_１２ヶ月_二次判定要支援1(),
                data.get更新_１２ヶ月_二次判定要支援2(),
                data.get更新_１２ヶ月_二次判定要介護1(),
                data.get更新_１２ヶ月_二次判定要介護2(),
                data.get更新_１２ヶ月_二次判定要介護3(),
                data.get更新_１２ヶ月_二次判定要介護4(),
                data.get更新_１２ヶ月_二次判定要介護5(),
                data.get更新_１２ヶ月_計(),
                RString.EMPTY,
                data.get新規_６ヶ月_二次判定要支援1(),
                data.get新規_６ヶ月_二次判定要支援2(),
                data.get新規_６ヶ月_二次判定要介護1(),
                data.get新規_６ヶ月_二次判定要介護2(),
                data.get新規_６ヶ月_二次判定要介護3(),
                data.get新規_６ヶ月_二次判定要介護4(),
                data.get新規_６ヶ月_二次判定要介護5(),
                data.get新規_６ヶ月_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                data.get更新_２４ヶ月_二次判定要支援1(),
                data.get更新_２４ヶ月_二次判定要支援2(),
                data.get更新_２４ヶ月_二次判定要介護1(),
                data.get更新_２４ヶ月_二次判定要介護2(),
                data.get更新_２４ヶ月_二次判定要介護3(),
                data.get更新_２４ヶ月_二次判定要介護4(),
                data.get更新_２４ヶ月_二次判定要介護5(),
                data.get更新_２４ヶ月_計(),
                RString.EMPTY,
                data.get新規_１２ヶ月_二次判定要支援1(),
                data.get新規_１２ヶ月_二次判定要支援2(),
                data.get新規_１２ヶ月_二次判定要介護1(),
                data.get新規_１２ヶ月_二次判定要介護2(),
                data.get新規_１２ヶ月_二次判定要介護3(),
                data.get新規_１２ヶ月_二次判定要介護4(),
                data.get新規_１２ヶ月_二次判定要介護5(),
                data.get新規_１２ヶ月_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                data.get更新_その他_二次判定要支援1(),
                data.get更新_その他_二次判定要支援2(),
                data.get更新_その他_二次判定要介護1(),
                data.get更新_その他_二次判定要介護2(),
                data.get更新_その他_二次判定要介護3(),
                data.get更新_その他_二次判定要介護4(),
                data.get更新_その他_二次判定要介護5(),
                data.get更新_その他_計(),
                RString.EMPTY,
                data.get新規_２４ヶ月_二次判定要支援1(),
                data.get新規_２４ヶ月_二次判定要支援2(),
                data.get新規_２４ヶ月_二次判定要介護1(),
                data.get新規_２４ヶ月_二次判定要介護2(),
                data.get新規_２４ヶ月_二次判定要介護3(),
                data.get新規_２４ヶ月_二次判定要介護4(),
                data.get新規_２４ヶ月_二次判定要介護5(),
                data.get新規_２４ヶ月_計()));
        dataBodyList.add(new ShinsahanteinoHenkojokyoBody(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                data.get新規_その他_二次判定要支援1(),
                data.get新規_その他_二次判定要支援2(),
                data.get新規_その他_二次判定要介護1(),
                data.get新規_その他_二次判定要介護2(),
                data.get新規_その他_二次判定要介護3(),
                data.get新規_その他_二次判定要介護4(),
                data.get新規_その他_二次判定要介護5(),
                data.get新規_その他_計()));
        return dataBodyList;
    }
}
