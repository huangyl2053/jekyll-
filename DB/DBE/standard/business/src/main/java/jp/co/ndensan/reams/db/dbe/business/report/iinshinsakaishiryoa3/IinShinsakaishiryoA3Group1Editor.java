/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査対象者一覧表（A3版）のEditorです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3Group1Editor implements IIinShinsakaishiryoA3Editor {

    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int INT_25 = 25;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList {@link List<JimuShinsakaishiryoBusiness>}
     * @param index int
     */
    protected IinShinsakaishiryoA3Group1Editor(List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            int index) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.index = index;
    }

    /**
     * 介護認定審査対象者一覧表（A3版）Editorです。
     *
     * @param source 委員審査会資料組み合わせ一覧A3のReportSource
     * @return IinShinsakaishiryoA3ReportSource 委員審査会資料組み合わせ一覧A3のReportSource
     */
    @Override
    public IinShinsakaishiryoA3ReportSource edit(IinShinsakaishiryoA3ReportSource source) {
        return editItem(source);
    }

    private IinShinsakaishiryoA3ReportSource editItem(IinShinsakaishiryoA3ReportSource source) {
        if (index < shinsakaishiryoList.size()) {
            source.one_shinsakaiNo = get審査会番号(shinsakaishiryoList.get(index).get審査会番号());
            source.one_shinsakaiKaisaiYMD = shinsakaishiryoList.get(index).get審査会開催年月日();
            source.one_gogitaiNo = shinsakaishiryoList.get(index).get合議体番号();
            source.one_ShinsainName1 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList1();
            source.one_ShinsainName2 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList2();
            source.one_ShinsainName3 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList3();
            source.one_ShinsainName4 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList4();
            source.one_ShinsainName5 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList5();
            source.one_ShinsainName6 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList6();
            source.one_ShinsainName7 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList7();
            source.one_ShinsainName8 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList8();
            source.one_shinsaTaishoshaCount = shinsakaishiryoList.get(index).get審査対象者数();
            source.one_listShinsei1_1 = shinsakaishiryoList.get(index).get審査会審査順().padZeroToLeft(INT_2);
            source.one_listShinsei1_2 = shinsakaishiryoList.get(index).get保険者();
            source.one_listShinsei1_3 = shinsakaishiryoList.get(index).get被保険者();
            source.one_listShinsei1_4 = shinsakaishiryoList.get(index).get氏名();
            source.one_listShinsei1_5 = shinsakaishiryoList.get(index).get性別();
            source.one_listShinsei1_6 = shinsakaishiryoList.get(index).get年齢();
            source.one_listShinsei1_7 = shinsakaishiryoList.get(index).get前回二次();
            source.one_listShinsei1_8 = shinsakaishiryoList.get(index).get前回期間();
            source.one_listShinsei1_9 = shinsakaishiryoList.get(index).get一次判定();
            source.one_listShinsei1_10 = RString.EMPTY;
            source.one_listShinsei1_11 = RString.EMPTY;
            source.one_listZenkaiｙukokikan1_1 = shinsakaishiryoList.get(index).get前回期間_下();
            source.one_listYukokikan1_1 = RString.EMPTY;
        }
        if ((index + INT_25) < shinsakaishiryoList.size()) {
            source.one_listShinsei2_1 = shinsakaishiryoList.get(index + INT_25).get審査会審査順().padZeroToLeft(INT_2);
            source.one_listShinsei2_2 = shinsakaishiryoList.get(index + INT_25).get保険者();
            source.one_listShinsei2_3 = shinsakaishiryoList.get(index + INT_25).get被保険者();
            source.one_listShinsei2_4 = shinsakaishiryoList.get(index + INT_25).get氏名();
            source.one_listShinsei2_5 = shinsakaishiryoList.get(index + INT_25).get性別();
            source.one_listShinsei2_6 = shinsakaishiryoList.get(index + INT_25).get年齢();
            source.one_listShinsei2_7 = shinsakaishiryoList.get(index + INT_25).get前回二次();
            source.one_listShinsei2_8 = shinsakaishiryoList.get(index + INT_25).get前回期間();
            source.one_listShinsei2_9 = shinsakaishiryoList.get(index + INT_25).get一次判定();
            source.one_listShinsei2_10 = RString.EMPTY;
            source.one_listShinsei2_11 = RString.EMPTY;
            source.one_listZenkaiｙukokikan2_1 = shinsakaishiryoList.get(index + INT_25).get前回期間_下();
            source.one_listYukokikan2_1 = RString.EMPTY;
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
