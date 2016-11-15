/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa4.JimuShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 介護認定審査対象者一覧表Editorです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaishiryoA4Group1Editor implements IJimuShinsakaishiryoA4Editor {

    private static final int INT_4 = 4;
    private final JimuShinsakaishiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link JimuShinsakaishiryoBusiness}
     */
    protected JimuShinsakaishiryoA4Group1Editor(JimuShinsakaishiryoBusiness business) {
        this.business = business;
    }

    /**
     * 介護認定審査対象者一覧表のEditです。
     *
     * @param source 事務局審査会資料組み合わせ一覧A4のReportSource
     * @return JimuShinsakaishiryoA4ReportSource 事務局審査会資料組み合わせ一覧A4のReportSource
     */
    @Override
    public JimuShinsakaishiryoA4ReportSource edit(JimuShinsakaishiryoA4ReportSource source) {
        return editItem(source);
    }

    private JimuShinsakaishiryoA4ReportSource editItem(JimuShinsakaishiryoA4ReportSource source) {
        source.one_shinsakaiNo = get審査会番号(business.get審査会番号());
        source.one_shinsakaiKaisaiYMD = business.get審査会開催年月日();
        source.one_shinsainName1 = business.getshinsakaiIinJohoList1();
        source.one_shinsainName2 = business.getshinsakaiIinJohoList2();
        source.one_shinsainName3 = business.getshinsakaiIinJohoList3();
        source.one_shinsainName4 = business.getshinsakaiIinJohoList4();
        source.one_shinsainName5 = business.getshinsakaiIinJohoList5();
        source.one_shinsainName6 = business.getshinsakaiIinJohoList6();
        source.one_shinsainName7 = business.getshinsakaiIinJohoList7();
        source.one_shinsainName8 = business.getshinsakaiIinJohoList8();
        source.one_gogitaiNo = business.get合議体番号();
        source.one_shinsaTaishoshaCount = business.get審査対象者数();
        source.one_listShinsei_1 = business.get審査会審査順();
        source.one_listShinsei_2 = business.get保険者();
        source.one_listShinsei_3 = business.get被保険者();
        source.one_listShinsei_4 = business.get氏名();
        source.one_listShinsei_5 = business.get性別();
        source.one_listShinsei_6 = business.get年齢();
        source.one_listShinsei_7 = business.get前回二次();
        source.one_listShinsei_8 = business.get前回期間();
        source.one_listShinsei_9 = business.get一次判定();
        source.one_listShinsei_10 = business.get警告();
        source.one_listShinsei_11 = business.get基準時間();
        source.one_listShinsei_12 = RString.EMPTY;
        source.one_listShinsei_13 = RString.EMPTY;
        if (business.is事務局()) {
            source.shikibetuCode = new ShikibetsuCode(business.get識別コード());
            if (business.get申請書管理番号() != null && !business.get申請書管理番号().isEmpty()) {
                source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), business.get申請書管理番号().getColumnValue());
            }
        }
        source.layout = Layouts.鑑;
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
