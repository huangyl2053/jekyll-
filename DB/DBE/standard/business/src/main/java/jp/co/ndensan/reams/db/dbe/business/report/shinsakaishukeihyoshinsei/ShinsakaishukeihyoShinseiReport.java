/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinsei;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（申請区分別）のReportです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class ShinsakaishukeihyoShinseiReport extends Report<ShinsakaiShukeihyoShinseiReportSource> {

    private final ShinsakaiShukeihyoShinsei data;

    /**
     * インスタンスを生成します。
     *
     * @param data 介護認定審査会集計表（申請区分別）のdataList
     */
    public ShinsakaishukeihyoShinseiReport(ShinsakaiShukeihyoShinsei data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiShukeihyoShinseiReportSource> reportSourceWriter) {
        for (ShinsakaiShukeihyoShinseiBody dataBody : getBodyData(data)) {
            IShinsakaishukeihyoShinseiEditor editor = new ShinsakaishukeihyoShinseiEditor(data);
            IShinsakaishukeihyoShinseiBodyEditor bodyEditor = new ShinsakaishukeihyoShinseiBodyEditor(dataBody);
            IShinsakaishukeihyoShinseiBuilder builder = new ShinsakaishukeihyoShinseiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShinsakaiShukeihyoShinseiBody> getBodyData(ShinsakaiShukeihyoShinsei data) {
        List<ShinsakaiShukeihyoShinseiBody> dataBodyList = new ArrayList<>();
        dataBodyList.add(new ShinsakaiShukeihyoShinseiBody(getZERO(data.get申_新規申請_受付数()),
                getZERO(data.get申_新規申請_調査数()),
                getZERO(data.get申_新規申請_意見書数()),
                getZERO(data.get申_新規申請_審査会数()),
                getZERO(data.get申_新規申請_二次判定数()),
                getZERO(data.get法_新規申請_受付数()),
                getZERO(data.get法_新規申請_調査数()),
                getZERO(data.get法_新規申請_意見書数()),
                getZERO(data.get法_新規申請_審査会数()),
                getZERO(data.get法_新規申請_二次判定数()),
                getZERO(data.get法_新規申請_申_新規申請()),
                getZERO(data.get法_新規申請_申_更新申請()),
                getZERO(data.get法_新規申請_申_区分変更申請())));
        dataBodyList.add(new ShinsakaiShukeihyoShinseiBody(getZERO(data.get申_更新申請_受付数()),
                getZERO(data.get申_更新申請_調査数()),
                getZERO(data.get申_更新申請_意見書数()),
                getZERO(data.get申_更新申請_審査会数()),
                getZERO(data.get申_更新申請_二次判定数()),
                getZERO(data.get法_更新申請_受付数()),
                getZERO(data.get法_更新申請_調査数()),
                getZERO(data.get法_更新申請_意見書数()),
                getZERO(data.get法_更新申請_審査会数()),
                getZERO(data.get法_更新申請_二次判定数()),
                getZERO(data.get法_更新申請_申_新規申請()),
                getZERO(data.get法_更新申請_申_更新申請()),
                getZERO(data.get法_更新申請_申_区分変更申請())));
        dataBodyList.add(new ShinsakaiShukeihyoShinseiBody(getZERO(data.get申_区分変更申請_受付数()),
                getZERO(data.get申_区分変更申請_調査数()),
                getZERO(data.get申_区分変更申請_意見書数()),
                getZERO(data.get申_区分変更申請_審査会数()),
                getZERO(data.get申_区分変更申請_二次判定数()),
                getZERO(data.get法_区分変更申請_受付数()),
                getZERO(data.get法_区分変更申請_調査数()),
                getZERO(data.get法_区分変更申請_意見書数()),
                getZERO(data.get法_区分変更申請_審査会数()),
                getZERO(data.get法_区分変更申請_二次判定数()),
                getZERO(data.get法_区分変更申請_申_新規申請()),
                getZERO(data.get法_区分変更申請_申_更新申請()),
                getZERO(data.get法_区分変更申請_申_区分変更申請())));
        dataBodyList.add(new ShinsakaiShukeihyoShinseiBody(getZERO(data.get申_転入_受付数()),
                getZERO(data.get申_転入_調査数()),
                getZERO(data.get申_転入_意見書数()),
                getZERO(data.get申_転入_審査会数()),
                getZERO(data.get申_転入_二次判定数()),
                getZERO(data.get法_転入_受付数()),
                getZERO(data.get法_転入_調査数()),
                getZERO(data.get法_転入_意見書数()),
                getZERO(data.get法_転入_審査会数()),
                getZERO(data.get法_転入_二次判定数()),
                getZERO(data.get法_区変却下_申_新規申請()),
                getZERO(data.get法_区変却下_申_更新申請()),
                getZERO(data.get法_区変却下_申_区分変更申請())));
        dataBodyList.add(new ShinsakaiShukeihyoShinseiBody(getZERO(data.get申_合計_受付数()),
                getZERO(data.get申_合計_調査数()),
                getZERO(data.get申_合計_意見書数()),
                getZERO(data.get申_合計_審査会数()),
                getZERO(data.get申_合計_二次判定数()),
                getZERO(data.get法_合計_受付数()),
                getZERO(data.get法_合計_調査数()),
                getZERO(data.get法_合計_意見書数()),
                getZERO(data.get法_合計_審査会数()),
                getZERO(data.get法_合計_二次判定数()),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        return dataBodyList;
    }
    
    private RString getZERO(RString data) {
        if (RString.isNullOrEmpty(data)) {
            return new RString("0");
        }
        return data;
    }
}
