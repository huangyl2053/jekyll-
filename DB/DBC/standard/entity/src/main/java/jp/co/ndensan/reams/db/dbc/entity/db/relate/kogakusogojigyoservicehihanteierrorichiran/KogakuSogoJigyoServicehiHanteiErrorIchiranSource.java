/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBCMN41002_高額総合事業サービス費判定エラーリストのReportSourceクラスです。
 *
 * @reamsid_L DBC-2010-130 sunhui
 */
public class KogakuSogoJigyoServicehiHanteiErrorIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYMKaishi", length = 8, order = 2)
    public RString shinsaYMKaishi;
    @ReportItem(name = "shinsaYMShuryo", length = 8, order = 3)
    public RString shinsaYMShuryo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 6)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 7)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 8)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 9)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 10)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 11)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 12)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 13)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 14)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 15)
    public RString kaipage5;
    @ReportItem(name = "listHanteiError_1", length = 4, order = 16)
    public RString listHanteiError_1;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "listHanteiError_2", length = 10, order = 17)
    public RString listHanteiError_2;
    @ReportItem(name = "listHanteiError_3", length = 6, order = 18)
    public RString listHanteiError_3;
    @ReportItem(name = "listHanteiError_4", length = 18, order = 19)
    public RString listHanteiError_4;
    @ReportItem(name = "listHanteiError_5", length = 15, order = 20)
    public RString listHanteiError_5;
    @ReportItem(name = "listHanteiError_6", length = 15, order = 21)
    public RString listHanteiError_6;
    @ReportItem(name = "listHanteiError_7", length = 60, order = 22)
    public RString listHanteiError_7;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 60, order = 23)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * KogakuSogoJigyoServicehiHanteiErrorIchiranSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        shinsaYMKaishi,
        shinsaYMShuryo,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listHanteiError_1,
        listHanteiError_2,
        listHanteiError_3,
        listHanteiError_4,
        listHanteiError_5,
        listHanteiError_6,
        listHanteiError_7,
        shikibetsuCode
    }
}
