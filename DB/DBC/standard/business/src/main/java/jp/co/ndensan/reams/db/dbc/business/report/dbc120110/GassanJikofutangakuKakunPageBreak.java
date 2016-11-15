/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120110;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120110.GassanJikofutangakuKakuninSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 高額合算自己負担額確認情報取込一覧表PageBreak。
 *
 * @reamsid_L DBC-2650-030 chenjie
 */
public class GassanJikofutangakuKakunPageBreak extends PageBreaker<GassanJikofutangakuKakuninSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public GassanJikofutangakuKakunPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJikofutangakuKakuninSource> currentSource,
            ReportLineRecord<GassanJikofutangakuKakuninSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().list_2.equals(nextSource.getSource().list_2)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.対象年度.get項目ID())
                && !currentSource.getSource().list_5.equals(nextSource.getSource().list_5)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.申請年月日.get項目ID())
                && !currentSource.getSource().list_7.equals(nextSource.getSource().list_7)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.申請書整理番号.get項目ID())
                && !currentSource.getSource().list_4.equals(nextSource.getSource().list_4)) {
            flag = true;
        } else {
            flag = isBreak_1(currentSource, nextSource);
        }
        return flag;

    }

    private boolean isBreak_1(ReportLineRecord<GassanJikofutangakuKakuninSource> currentSource,
            ReportLineRecord<GassanJikofutangakuKakuninSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.郵便番号.get項目ID())
                && !currentSource.getSource().yubinNo.equals(nextSource.getSource().yubinNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.町域コード.get項目ID())
                && !currentSource.getSource().choikiCode.equals(nextSource.getSource().choikiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.行政区コード.get項目ID())
                && !currentSource.getSource().gyoseikuCode.equals(nextSource.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.氏名５０音カナ.get項目ID())
                && !currentSource.getSource().shimei50onKana.equals(nextSource.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.breakKeysList.contains(GassanJikofutangakuKakunOutPutOrder.市町村コード.get項目ID())
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        return flag;
    }
}
