/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 基準収入額決定通知一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak extends PageBreaker<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> currentSource,
            ReportLineRecord<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> nextSource) {
        boolean flag = false;
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.郵便番号.getフォームフィールド名())) {
            flag = !checkNull(currentSource.getSource().yubinNo).equals(nextSource.getSource().yubinNo);
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.町域コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.getSource().choikiCode).equals(nextSource.getSource().choikiCode);
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.行政区コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.getSource().gyoseikuCode).equals(nextSource.getSource().gyoseikuCode);
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.世帯コード.getフォームフィールド名())
                && nextSource.getSource().listHakkoTaishosha_2 != null && !nextSource.getSource().listHakkoTaishosha_2.isEmpty()) {
            flag = !checkNull(currentSource.getSource().listHakkoTaishosha_2).equals(nextSource.getSource().listHakkoTaishosha_2);
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.市町村コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.getSource().shichosonCode).equals(nextSource.getSource().shichosonCode);
        }
        return flag;
    }

    /**
     * 改頁判断のメソッドです。
     *
     * @param currentSource KijunShunyugakuTekiyoKetteiEntity
     * @param nextSource KijunShunyugakuTekiyoKetteiEntity
     * @return 改頁Flag
     */
    public boolean is改頁(KijunShunyugakuTekiyoKetteiEntity currentSource,
            KijunShunyugakuTekiyoKetteiEntity nextSource) {
        boolean flag = false;
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.郵便番号.getフォームフィールド名())) {
            flag = !checkNull(currentSource.get郵便番号()).equals(nextSource.get郵便番号());
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.町域コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.get町域コード()).equals(nextSource.get町域コード());
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.行政区コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.get行政区コード()).equals(nextSource.get行政区コード());
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.世帯コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.get世帯コード()).equals(nextSource.get世帯コード());
        }
        if (!flag
                && this.breakKeysList.contains(KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.市町村コード.getフォームフィールド名())) {
            flag = !checkNull(currentSource.get市町村コード()).equals(nextSource.get市町村コード());
        }
        return flag;
    }

    private RString checkNull(RString rstring) {
        if (rstring == null) {
            return RString.EMPTY;
        } else {
            return rstring;
        }
    }

    private YubinNo checkNull(YubinNo yubinNo) {
        if (yubinNo == null) {
            return YubinNo.EMPTY;
        } else {
            return yubinNo;
        }
    }

    private ChoikiCode checkNull(ChoikiCode choikiCode) {
        if (choikiCode == null) {
            return ChoikiCode.EMPTY;
        } else {
            return choikiCode;
        }
    }

    private GyoseikuCode checkNull(GyoseikuCode gyoseikuCode) {
        if (gyoseikuCode == null) {
            return GyoseikuCode.EMPTY;
        } else {
            return gyoseikuCode;
        }
    }

    private SetaiCode checkNull(SetaiCode setaiCode) {
        if (setaiCode == null) {
            return SetaiCode.EMPTY;
        } else {
            return setaiCode;
        }
    }

    private LasdecCode checkNull(LasdecCode lasdecCode) {
        if (lasdecCode == null) {
            return LasdecCode.EMPTY;
        } else {
            return lasdecCode;
        }
    }
}
