/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 介護認定審査対象者一覧表A4のEditorクラスです。
 *
 * @reamsid_L DBE-0150-260 lishengli
 */
public class ShinsakaishiryoA4Editor implements IShinsakaishiryoA4Editor {

    private static final int INT_4 = 4;
    private final JimuShinsakaishiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuShinsakaishiryoBusiness}
     */
    protected ShinsakaishiryoA4Editor(JimuShinsakaishiryoBusiness business) {
        this.business = business;
    }

    /**
     * 介護認定審査対象者一覧表のEditです。
     *
     * @param source 介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA4ReportSource 介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public ShinsakaishiryoA4ReportSource edit(ShinsakaishiryoA4ReportSource source) {
        return editItem(source);
    }

    private ShinsakaishiryoA4ReportSource editItem(ShinsakaishiryoA4ReportSource source) {
        source.shinsakaiNo = get審査会番号(business.get審査会番号());
        source.shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.ShinsainName1 = business.getshinsakaiIinJohoList1();
        source.ShinsainName2 = business.getshinsakaiIinJohoList2();
        source.ShinsainName3 = business.getshinsakaiIinJohoList3();
        source.ShinsainName4 = business.getshinsakaiIinJohoList4();
        source.ShinsainName5 = business.getshinsakaiIinJohoList5();
        source.ShinsainName6 = business.getshinsakaiIinJohoList6();
        source.ShinsainName7 = business.getshinsakaiIinJohoList7();
        source.ShinsainName8 = business.getshinsakaiIinJohoList8();
        source.gogitaiNo = business.get合議体番号();
        source.shinsaTaishoshaCount = business.get審査対象者数();
        source.listShinsei_1 = business.get審査会審査順();
        source.listShinsei_2 = business.get保険者();
        source.listShinsei_3 = business.get被保険者();
        source.listShinsei_4 = business.get氏名();
        source.listShinsei_5 = business.get性別();
        source.listShinsei_6 = business.get年齢();
        source.listShinsei_7 = business.get前回二次();
        source.listShinsei_8 = business.get前回期間();
        source.listShinsei_9 = business.get一次判定();
        source.listShinsei_10 = business.get警告();
        source.listShinsei_11 = business.get基準時間();
        source.listShinsei_12 = RString.EMPTY;
        source.listShinsei_13 = RString.EMPTY;
        if (business.is事務局()) {
            source.shikibetuCode = ShikibetsuCode.EMPTY;
            if (business.get申請書管理番号() != null && !business.get申請書管理番号().isEmpty()) {
                source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), business.get申請書管理番号().getColumnValue());
            }
        }
        return source;
    }

    private RString get審査会番号(RString 審査会番号) {
        if (!RString.isNullOrEmpty(審査会番号)) {
            if (審査会番号.length() <= INT_4) {
                return 審査会番号;
            } else {
                return 審査会番号.substring(審査会番号.length() - INT_4);
            }
        }
        return RString.EMPTY;
    }

}
