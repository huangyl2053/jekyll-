/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.report.dbd501001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定申請書のReportSource
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public class YokaigoNinteiShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNo1", length = 1, order = 1)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 2)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 3)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 4)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 5)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 6)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 7)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 8)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 9)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 10)
    @ReportExpandedInfo(code = "0003", name = "被保険者番号")
    public RString hihokenshaNo10;
    @ReportItem(name = "birthGengoMeiji", length = 1, order = 11)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 1, order = 12)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 1, order = 13)
    public RString birthGengoShowa;
    @ReportItem(name = "hihokenshaNameKana", order = 14)
    public RString hihokenshaNameKana;
    @ReportItem(name = "birthYYYY", length = 4, order = 15)
    public RString birthYYYY;
    @ReportItem(name = "birthMM", length = 2, order = 16)
    public RString birthMM;
    @ReportItem(name = "birthDD", length = 2, order = 17)
    public RString birthDD;
    @ReportItem(name = "umareYy", length = 2, order = 18)
    public RString umareYy;
    @ReportItem(name = "hihokenshaName", order = 19)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsuMan", length = 1, order = 20)
    public RString seibetsuMan;
    @ReportItem(name = "seibetsuWoman", length = 1, order = 21)
    public RString seibetsuWoman;
    @ReportItem(name = "telNo", length = 18, order = 22)
    public RString telNo;
    @ReportItem(name = "yubinNo", length = 8, order = 23)
    public RString yubinNo;
    @ReportItem(name = "jusho", order = 24)
    public RString jusho;
    @ReportItem(name = "yokaigoJotaiKubun1", length = 1, order = 25)
    public RString yokaigoJotaiKubun1;
    @ReportItem(name = "yokaigoJotaiKubun2", length = 1, order = 26)
    public RString yokaigoJotaiKubun2;
    @ReportItem(name = "yokaigoJotaiKubun3", length = 1, order = 27)
    public RString yokaigoJotaiKubun3;
    @ReportItem(name = "yokaigoJotaiKubun4", length = 1, order = 28)
    public RString yokaigoJotaiKubun4;
    @ReportItem(name = "yokaigoJotaiKubun5", length = 1, order = 29)
    public RString yokaigoJotaiKubun5;
    @ReportItem(name = "yoshienJotaiKubun1", length = 1, order = 30)
    public RString yoshienJotaiKubun1;
    @ReportItem(name = "yoshienJotaiKubun2", length = 1, order = 31)
    public RString yoshienJotaiKubun2;
    @ReportItem(name = "yukoKaishiYYYY", length = 4, order = 32)
    public RString yukoKaishiYYYY;
    @ReportItem(name = "yukoKaishiMM", length = 2, order = 33)
    public RString yukoKaishiMM;
    @ReportItem(name = "yukoKaishiDD", length = 2, order = 34)
    public RString yukoKaishiDD;
    @ReportItem(name = "yukoShuryoYYYY", length = 4, order = 35)
    public RString yukoShuryoYYYY;
    @ReportItem(name = "yukoShuryoMM", length = 2, order = 36)
    public RString yukoShuryoMM;
    @ReportItem(name = "yukoShuryoDD", length = 2, order = 37)
    public RString yukoShuryoDD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 38)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
