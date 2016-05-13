/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo08;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo08.ShinsakaiShukeihyo08;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo08.ShinsakaiShukeihyo08Body;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo08.ShinsakaiShukeihyo08ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（申請区分別）のReportです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class Shinsakaishukeihyo08Report extends Report<ShinsakaiShukeihyo08ReportSource> {

    private final ShinsakaiShukeihyo08 data;

    /**
     * インスタンスを生成します。
     *
     * @param data 介護認定審査会集計表（申請区分別）のdataList
     */
    public Shinsakaishukeihyo08Report(ShinsakaiShukeihyo08 data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiShukeihyo08ReportSource> reportSourceWriter) {
        for (ShinsakaiShukeihyo08Body dataBody : getBodyData(data)) {
            IShinsakaishukeihyo08Editor editor = new Shinsakaishukeihyo08Editor(data);
            IShinsakaishukeihyo08BodyEditor bodyEditor = new Shinsakaishukeihyo08BodyEditor(dataBody);
            IShinsakaishukeihyo08Builder builder = new Shinsakaishukeihyo08Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShinsakaiShukeihyo08Body> getBodyData(ShinsakaiShukeihyo08 data) {
        List<ShinsakaiShukeihyo08Body> dataBodyList = new ArrayList<>();
        dataBodyList.add(new ShinsakaiShukeihyo08Body(data.get申_新規申請_受付数(),
                data.get申_新規申請_調査数(),
                data.get申_新規申請_意見書数(),
                data.get申_新規申請_審査会数(),
                data.get申_新規申請_二次判定数(),
                data.get法_新規申請_受付数(),
                data.get法_新規申請_調査数(),
                data.get法_新規申請_意見書数(),
                data.get法_新規申請_審査会数(),
                data.get法_新規申請_二次判定数(),
                data.get法_新規申請_申_新規申請(),
                data.get法_新規申請_申_更新申請(),
                data.get法_新規申請_申_区分変更申請()));
        dataBodyList.add(new ShinsakaiShukeihyo08Body(data.get申_更新申請_受付数(),
                data.get申_更新申請_調査数(),
                data.get申_更新申請_意見書数(),
                data.get申_更新申請_審査会数(),
                data.get申_更新申請_二次判定数(),
                data.get法_更新申請_受付数(),
                data.get法_更新申請_調査数(),
                data.get法_更新申請_意見書数(),
                data.get法_更新申請_審査会数(),
                data.get法_更新申請_二次判定数(),
                data.get法_更新申請_申_新規申請(),
                data.get法_更新申請_申_更新申請(),
                data.get法_更新申請_申_区分変更申請()));
        dataBodyList.add(new ShinsakaiShukeihyo08Body(data.get申_区分変更申請_受付数(),
                data.get申_区分変更申請_調査数(),
                data.get申_区分変更申請_意見書数(),
                data.get申_区分変更申請_審査会数(),
                data.get申_区分変更申請_二次判定数(),
                data.get法_区分変更申請_受付数(),
                data.get法_区分変更申請_調査数(),
                data.get法_区分変更申請_意見書数(),
                data.get法_区分変更申請_審査会数(),
                data.get法_区分変更申請_二次判定数(),
                data.get法_区分変更申請_申_新規申請(),
                data.get法_区分変更申請_申_更新申請(),
                data.get法_区分変更申請_申_区分変更申請()));
        dataBodyList.add(new ShinsakaiShukeihyo08Body(data.get申_転入_受付数(),
                data.get申_転入_調査数(),
                data.get申_転入_意見書数(),
                data.get申_転入_審査会数(),
                data.get申_転入_二次判定数(),
                data.get法_転入_受付数(),
                data.get法_転入_調査数(),
                data.get法_転入_意見書数(),
                data.get法_転入_審査会数(),
                data.get法_転入_二次判定数(),
                data.get法_区変却下_申_新規申請(),
                data.get法_区変却下_申_更新申請(),
                data.get法_区変却下_申_区分変更申請()));
        dataBodyList.add(new ShinsakaiShukeihyo08Body(data.get申_合計_受付数(),
                data.get申_合計_調査数(),
                data.get申_合計_意見書数(),
                data.get申_合計_審査会数(),
                data.get申_合計_二次判定数(),
                data.get法_合計_受付数(),
                data.get法_合計_調査数(),
                data.get法_合計_意見書数(),
                data.get法_合計_審査会数(),
                data.get法_合計_二次判定数(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        return dataBodyList;
    }
}
