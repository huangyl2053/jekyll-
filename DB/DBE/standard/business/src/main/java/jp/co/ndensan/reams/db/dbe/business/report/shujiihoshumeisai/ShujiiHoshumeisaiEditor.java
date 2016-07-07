/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai.ShujiiHoshumeisaiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のShujiiHoshumeisaiEditorです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiEditor implements IShujiiHoshumeisaiEditor {

    private final ShujiiHoshumeisaiEntity item;
    private static final LasdecCode LASDEC_CODE = new LasdecCode("000000");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiHoshumeisaiEntity}
     */
    protected ShujiiHoshumeisaiEditor(ShujiiHoshumeisaiEntity item) {
        this.item = item;
    }

    @Override
    public ShujiiHoshumeisaiReportSource edit(ShujiiHoshumeisaiReportSource source) {
        source.title = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬支払明細書, RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                LASDEC_CODE, ConfigNameDBE.主治医意見書作成報酬支払明細書.get名称());
        RString printTimeStampSb = FlexibleDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.taishoKikan = item.get対象期間();
        source.hokenshaName = item.get保険者名();
        source.iryokikanName = item.get医療機関名();
        source.ishiName = item.get医師名();
        source.printTimeStamp = printTimeStampSb;
        return source;
    }

}
