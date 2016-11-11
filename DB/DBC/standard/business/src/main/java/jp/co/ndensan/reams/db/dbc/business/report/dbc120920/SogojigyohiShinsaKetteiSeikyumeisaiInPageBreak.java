/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120920;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票設計_DBC200084_総合事業費審査決定請求明細表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-2500-032 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInPageBreak extends PageBreaker<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiShinsaKetteiSeikyumeisaiInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> currentSource,
            ReportLineRecord<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.サービス種類コード.get項目ID())
                && !currentSource.getSource().serviceShuruiCode.equals(nextSource.getSource().serviceShuruiCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.サービス提供年月.get項目ID())
                && !currentSource.getSource().listMeisai_3.equals(nextSource.getSource().listMeisai_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.事業者番号.get項目ID())
                && !currentSource.getSource().listMeisai_1.equals(nextSource.getSource().listMeisai_1)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource SogojigyohiShinsaKetteiSeikyumeisaiInEntity
     * @param nextSource SogojigyohiShinsaKetteiSeikyumeisaiInEntity
     * @return 改頁Flag
     */
    public boolean is改頁(SogojigyohiShinsaKetteiSeikyumeisaiInEntity currentSource,
            SogojigyohiShinsaKetteiSeikyumeisaiInEntity nextSource) {
        boolean flag = false;
        if (!currentSource.get審査決定請求合計一時TBL().get証記載保険者番号().equals(nextSource.get審査決定請求合計一時TBL().get証記載保険者番号())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.サービス種類コード.get項目ID())
                && !currentSource.get審査決定請求明細一時TBL().getサービス種類コード()
                .equals(nextSource.get審査決定請求明細一時TBL().getサービス種類コード())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.サービス提供年月.get項目ID())
                && !currentSource.get審査決定請求明細一時TBL().getサービス提供年月()
                .equals(nextSource.get審査決定請求明細一時TBL().getサービス提供年月())) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder.事業者番号.get項目ID())
                && !currentSource.get審査決定請求明細一時TBL().get事業所番号().equals(nextSource.get審査決定請求明細一時TBL().get事業所番号())) {
            flag = true;
        }
        return flag;
    }
}
