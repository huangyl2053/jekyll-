/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 介護給付費等審査決定請求明細表のPageBreakクラスです。
 *
 * @reamsid_L DBC-2500-030 jiangxiaolong
 */
public class KyufuhiShinsaKetteiSeikyuMeisaihyoPageBreak extends PageBreaker<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KyufuhiShinsaKetteiSeikyuMeisaihyoPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> currentSource,
            ReportLineRecord<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> nextSource) {
        boolean flag = false;
        if (!currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder.事業者番号.get項目ID())
                && !currentSource.getSource().listMeisai_1.equals(nextSource.getSource().listMeisai_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder.サービス提供年月.get項目ID())
                && !currentSource.getSource().listMeisai_3.equals(nextSource.getSource().listMeisai_3)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource KyufuhiShinsaKetteiSeikyuMeisaihyoSource
     * @param nextSource KyufuhiShinsaKetteiSeikyuMeisaihyoSource
     * @return 改頁Flag
     */
    public boolean is改頁(KyufuhiShinsaKetteiSeikyuMeisaihyoSource currentSource,
            KyufuhiShinsaKetteiSeikyuMeisaihyoSource nextSource) {
        boolean flag = false;
        if (!currentSource.shoKisaiHokenshaNo.equals(nextSource.shoKisaiHokenshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder.事業者番号.get項目ID())
                && !currentSource.listMeisai_1.equals(nextSource.listMeisai_1)) {
            flag = true;
        } else if (this.breakKeysList.contains(KyufuhiShinsaKetteiSeikyuMeisaihyoOutPutOrder.サービス提供年月.get項目ID())
                && !currentSource.listMeisai_3.equals(nextSource.listMeisai_3)) {
            flag = true;
        }
        return flag;
    }
}
