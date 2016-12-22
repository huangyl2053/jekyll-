/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局審査会対象者一覧A3版Editorです。
 *
 * @reamsid_L DBE-0150-190 lishengli
 */
public class JimuShinsakaishiryoA3Group1Editor implements IJimuShinsakaishiryoA3Editor {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int INT_25 = 25;
    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList {@link JimuShinsakaishiryoBusiness}
     * @param index int
     */
    protected JimuShinsakaishiryoA3Group1Editor(List<JimuShinsakaishiryoBusiness> shinsakaishiryoList, int index) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.index = index;
    }

    /**
     * 介護認定審査対象者一覧表のEditです。
     *
     * @param source 介護認定審査対象者一覧表のReportSourceクラス
     * @return ShinsakaishiryoA3ReportSource 介護認定審査対象者一覧表のReportSourceクラス
     */
    @Override
    public JimuShinsakaishiryoA3ReportSource edit(JimuShinsakaishiryoA3ReportSource source) {
        return editItem(source);
    }

    private JimuShinsakaishiryoA3ReportSource editItem(JimuShinsakaishiryoA3ReportSource source) {

        if (index < shinsakaishiryoList.size()) {
            source.shinsakaiNo = get審査会番号(shinsakaishiryoList.get(index).get審査会番号());
            source.shinsakaiKaisaiYMD = shinsakaishiryoList.get(index).get審査会開催年月日();
            source.gogitaiNo = shinsakaishiryoList.get(index).get合議体番号();
            source.shinsainName1 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList1();
            source.shinsainName2 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList2();
            source.shinsainName3 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList3();
            source.shinsainName4 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList4();
            source.shinsainName5 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList5();
            source.shinsainName6 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList6();
            source.shinsainName7 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList7();
            source.shinsainName8 = shinsakaishiryoList.get(index).getshinsakaiIinJohoList8();
            source.shinsaTaishoshaCount = shinsakaishiryoList.get(index).get審査対象者数();
            source.listShinsei1_1 = shinsakaishiryoList.get(index).get審査会審査順().padZeroToLeft(INT_2);
            source.listShinsei1_2 = shinsakaishiryoList.get(index).get保険者();
            source.listShinsei1_3 = shinsakaishiryoList.get(index).get被保険者();
            source.listShinsei1_4 = shinsakaishiryoList.get(index).get氏名();
            source.listShinsei1_5 = shinsakaishiryoList.get(index).get性別();
            source.listShinsei1_6 = shinsakaishiryoList.get(index).get年齢();
            source.listShinsei1_7 = shinsakaishiryoList.get(index).get前回二次();
            source.listShinsei1_8 = shinsakaishiryoList.get(index).get前回期間();
            source.listShinsei1_9 = shinsakaishiryoList.get(index).get一次判定();
            source.listShinsei1_10 = RString.EMPTY;
            source.listShinsei1_11 = RString.EMPTY;
            source.listZenkaiｙukokikan1_1 = shinsakaishiryoList.get(index).get前回期間_下();
            source.listYukokikan1_1 = RString.EMPTY;
            source.shikibetuCode = new ShikibetsuCode(shinsakaishiryoList.get(index).get識別コード());
            if (shinsakaishiryoList.get(index).is事務局() && shinsakaishiryoList.get(index).get申請書管理番号() != null
                    && !shinsakaishiryoList.get(index).get申請書管理番号().isEmpty()) {
                source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        shinsakaishiryoList.get(index).get申請書管理番号().getColumnValue());
            }
        }
        if ((index + INT_25) < shinsakaishiryoList.size()) {
            source.listShinsei2_1 = shinsakaishiryoList.get(index + INT_25).get審査会審査順().padZeroToLeft(INT_2);
            source.listShinsei2_2 = shinsakaishiryoList.get(index + INT_25).get保険者();
            source.listShinsei2_3 = shinsakaishiryoList.get(index + INT_25).get被保険者();
            source.listShinsei2_4 = shinsakaishiryoList.get(index + INT_25).get氏名();
            source.listShinsei2_5 = shinsakaishiryoList.get(index + INT_25).get性別();
            source.listShinsei2_6 = shinsakaishiryoList.get(index + INT_25).get年齢();
            source.listShinsei2_7 = shinsakaishiryoList.get(index + INT_25).get前回二次();
            source.listShinsei2_8 = shinsakaishiryoList.get(index + INT_25).get前回期間();
            source.listShinsei2_9 = shinsakaishiryoList.get(index + INT_25).get一次判定();
            source.listShinsei2_10 = RString.EMPTY;
            source.listShinsei2_11 = RString.EMPTY;
            source.listZenkaiｙukokikan2_1 = shinsakaishiryoList.get(index + INT_25).get前回期間_下();
            source.listYukokikan2_1 = RString.EMPTY;
        }
        source.layout = INT_1;
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
