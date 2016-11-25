/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.SonoTashiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定情報提供その他資料情報のEditorです。
 *
 * @reamsid_L DBE-0230-050 zhangzhiming
 */
public class SonoTashiryoBodyEditor implements ISonoTashiryoBodyEditor {

    private final SonoTashiryoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected SonoTashiryoBodyEditor(SonoTashiryoEntity item) {
        this.item = item;
    }

    @Override
    public SonoTashiryoReportSource edit(SonoTashiryoReportSource source) {
        return editSource(source);
    }

    private SonoTashiryoReportSource editSource(SonoTashiryoReportSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hihokennshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get被保険者番号());
        source.hihokenshaNo = item.get被保険者番号();
        source.hihokenshaName = item.get被保険者氏名();
        source.shinseiGengo = item.get申請日_元号();
        source.shinseiYY = !RString.isNullOrEmpty(item.get申請日_年()) ? item.get申請日_年().substring(2) : RString.EMPTY;
        source.shinseiMM = item.get申請日_月();
        source.shinseiDD = item.get申請日_日();
        source.sakuseiGengo = item.get作成日_元号();
        source.sakuseiYY = !RString.isNullOrEmpty(item.get作成日_年()) ? item.get作成日_年().substring(2) : RString.EMPTY;
        source.sakuseiMM = item.get作成日_月();
        source.sakuseiDD = item.get作成日_日();
        source.chosaGengo = item.get調査日_元号();
        source.chosaYY = !RString.isNullOrEmpty(item.get調査日_年()) ? item.get調査日_年().substring(2) : RString.EMPTY;
        source.chosaMM = item.get調査日_月();
        source.chosaDD = item.get調査日_日();
        source.shinsaGengo = item.get審査日_元号();
        source.shinsaYY = !RString.isNullOrEmpty(item.get審査日_年()) ? item.get審査日_年().substring(2) : RString.EMPTY;
        source.shinsaMM = item.get審査日_月();
        source.shinsaDD = item.get審査日_日();
        source.imgSonotashiryo = item.getその他資料イメージ();
        return source;
    }
}
