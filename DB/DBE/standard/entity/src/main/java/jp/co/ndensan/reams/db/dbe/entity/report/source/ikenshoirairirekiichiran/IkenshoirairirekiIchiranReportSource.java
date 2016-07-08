/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書作成依頼履歴一覧表のReportSourceです。
 *
 * @reamsid_L DBE-1590-032 zuotao
 */
public class IkenshoirairirekiIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "listChokkinKubun_1", length = 2, order = 2)
    public RString listChokkinKubun_1;
    @ReportItem(name = "listHihokenshaNo_1", length = 10, order = 3)
    public RString listHihokenshaNo_1;
    @ReportItem(name = "listHihokenshaKana_1", length = 30, order = 4)
    public RString listHihokenshaKana_1;
    @ReportItem(name = "listHihokenshaJusho_1", length = 50, order = 5)
    public RString listHihokenshaJusho_1;
    @ReportItem(name = "listIryokikanName_1", length = 30, order = 6)
    public RString listIryokikanName_1;
    @ReportItem(name = "listIkenshoiraiYMD_1", length = 9, order = 7)
    public RString listIkenshoiraiYMD_1;
    @ReportItem(name = "listShinseiKubun_1", length = 2, order = 8)
    public RString listShinseiKubun_1;
    @ReportItem(name = "listHihokenshaName_1", length = 20, order = 9)
    public RString listHihokenshaName_1;
    @ReportItem(name = "listIshiName_1", length = 30, order = 10)
    public RString listIshiName_1;
    @ReportItem(name = "listKeizokukubun_1", length = 2, order = 11)
    public RString listKeizokukubun_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;
}
