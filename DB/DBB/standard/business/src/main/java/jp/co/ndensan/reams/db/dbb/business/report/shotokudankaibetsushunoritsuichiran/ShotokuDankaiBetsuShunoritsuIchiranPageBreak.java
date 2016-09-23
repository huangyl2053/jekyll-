/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsushunoritsuichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dankaibetsushunoritsu.ShotokuDankaiBetsuShunoritsuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 保険料段階別収納率一覧表のPageBreakクラスです。
 *
 * @reamsid_L DBB-1630-040 tianshuai
 */
public class ShotokuDankaiBetsuShunoritsuIchiranPageBreak extends PageBreaker<ShotokuDankaiBetsuShunoritsuIchiranSource> {

    private final List<RString> breakKeysList;
    private static final RString 調定年度 = new RString("調定年度");
    private static final RString 賦課年度 = new RString("賦課年度");
    private static final RString 科目コード = new RString("科目コード");
    private static final RString 構成市町村コード = new RString("構成市町村コード");
    private static final RString TEXT_過年度 = new RString("*過年度*");
    private static final RString TEXT_総過年度 = new RString("*総過年度*");

    /**
     *
     * @param breakKeys ページングキー
     */
    public ShotokuDankaiBetsuShunoritsuIchiranPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<ShotokuDankaiBetsuShunoritsuIchiranSource> currentSource,
            ReportLineRecord<ShotokuDankaiBetsuShunoritsuIchiranSource> nextSource) {
        boolean flag = false;
        if (TEXT_過年度.equals(nextSource.getSource().list_1)
                || TEXT_総過年度.equals(nextSource.getSource().list_1)) {
            return true;
        }
        if (!RString.isNullOrEmpty(nextSource.getSource().isPageBreaker)) {
            return flag;
        }
        if ((this.breakKeysList.contains(調定年度) || this.breakKeysList.contains(賦課年度))) {
            if (RString.EMPTY.equals(currentSource.getSource().list_1)
                    && !currentSource.getSource().hdn_list_1.equals(nextSource.getSource().hdn_list_1)) {
                flag = true;
            }
            if (!RString.EMPTY.equals(currentSource.getSource().list_1)
                    && !currentSource.getSource().list_1.equals(nextSource.getSource().list_1)) {
                flag = true;
            }
        } else if (this.breakKeysList.contains(科目コード)
                && !currentSource.getSource().kamokuCode.equals(nextSource.getSource().kamokuCode)) {
            flag = true;
        } else if (this.breakKeysList.contains(構成市町村コード)
                && !currentSource.getSource().shichosonCode.equals(nextSource.getSource().shichosonCode)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 市町村コード改頁判断のメソッドです。
     *
     * @param currentSource DankaibetsuShunoritsuTempEntity
     * @param nextSource DankaibetsuShunoritsuTempEntity
     * @return 市町村コード改頁Flag
     */
    public boolean is市町村コード改頁(DankaibetsuShunoritsuTempEntity currentSource,
            DankaibetsuShunoritsuTempEntity nextSource) {
        return this.breakKeysList.contains(構成市町村コード)
                && !currentSource.getLasdecCode().equals(nextSource.getLasdecCode());
    }

    /**
     * 科目コード改頁判断のメソッドです。
     *
     * @param currentSource DankaibetsuShunoritsuTempEntity
     * @param nextSource DankaibetsuShunoritsuTempEntity
     * @return 科目コード改頁Flag
     */
    public boolean is科目コード改頁(DankaibetsuShunoritsuTempEntity currentSource,
            DankaibetsuShunoritsuTempEntity nextSource) {
        return this.breakKeysList.contains(科目コード)
                && !currentSource.getKamokuCode().equals(nextSource.getKamokuCode());
    }
}
