/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表のPageBreakクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public class SogojigyohiShinsaKetteiSeikyumeisaihyoPageBreak extends PageBreaker<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> {

    private final List<RString> breakKeysList;

    /**
     * breakKeysの構造方法です
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiShinsaKetteiSeikyumeisaihyoPageBreak(List<RString> breakKeys) {
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
        if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder.事業者番号.get項目ID())
                && !currentSource.getSource().listMeisai_1.equals(nextSource.getSource().listMeisai_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder.サービス提供年月.get項目ID())
                && !currentSource.getSource().listMeisai_3.equals(nextSource.getSource().listMeisai_3)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder.サービス種類コード.get項目ID())
                && !currentSource.getSource().listMeisai_11.equals(nextSource.getSource().listMeisai_11)) {
            flag = true;
        }
        return flag;
    }
}
