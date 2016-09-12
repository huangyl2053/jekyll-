package jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定主治医意見書記入用紙のReportSourceです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaKana", length = 30, order = 1)
    public RString hihokenshaKana;
    @ReportItem(name = "yubinNo", length = 8, order = 2)
    public RString yubinNo;
    @ReportItem(name = "seibetsuMan", length = 2, order = 3)
    public RString seibetsuMan;
    @ReportItem(name = "jusho", length = 70, order = 4)
    public RString jusho;
    @ReportItem(name = "hihokenshaName", length = 30, order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "seibetsuWoman", length = 2, order = 6)
    public RString seibetsuWoman;
    @ReportItem(name = "hihokenshaTel", length = 13, order = 7)
    public RString hihokenshaTel;
    @ReportItem(name = "birthGengoMeiji", length = 2, order = 8)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 2, order = 9)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 2, order = 10)
    public RString birthGengoShowa;
    @ReportItem(name = "age", length = 3, order = 11)
    public RString age;
    @ReportItem(name = "birthYY", length = 2, order = 12)
    public RString birthYY;
    @ReportItem(name = "birthMM", length = 2, order = 13)
    public RString birthMM;
    @ReportItem(name = "birthDD", length = 2, order = 14)
    public RString birthDD;
    @ReportItem(name = "shujiiName", length = 30, order = 15)
    public RString shujiiName;
    @ReportItem(name = "iryokikanName", length = 40, order = 16)
    public RString iryokikanName;
    @ReportItem(name = "iryokikanNameTel", length = 13, order = 17)
    public RString iryokikanNameTel;
    @ReportItem(name = "iryokikanFax", length = 13, order = 18)
    public RString iryokikanFax;
    @ReportItem(name = "iryokikanAdress", length = 50, order = 19)
    public RString iryokikanAdress;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 21)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 22)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 23)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 24)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 25)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 26)
    public RString hokenshaNo6;
    @ReportItem(name = "shinseiYMDNo1", length = 2, order = 27)
    public RString shinseiYMDNo1;
    @ReportItem(name = "shinseiYMDNo2", length = 2, order = 28)
    public RString shinseiYMDNo2;
    @ReportItem(name = "shinseiYMDNo3", length = 2, order = 29)
    public RString shinseiYMDNo3;
    @ReportItem(name = "shinseiYMDNo4", length = 2, order = 30)
    public RString shinseiYMDNo4;
    @ReportItem(name = "shinseiYMDNo5", length = 2, order = 31)
    public RString shinseiYMDNo5;
    @ReportItem(name = "shinseiYMDNo6", length = 2, order = 32)
    public RString shinseiYMDNo6;
    @ReportItem(name = "hihokenshaNo1", length = 2, order = 33)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 2, order = 34)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 2, order = 35)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 2, order = 36)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 2, order = 37)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 2, order = 38)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 2, order = 39)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 2, order = 40)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 2, order = 41)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 2, order = 42)
    public RString hihokenshaNo10;
    @ReportItem(name = "shinseiYY1", length = 2, order = 51)
    public RString oCR2_shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 52)
    public RString oCR2_shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 53)
    public RString oCR2_shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 54)
    public RString oCR2_shinseiMM2;
    @ReportItem(name = "shinseiD1", length = 2, order = 55)
    public RString oCR2_shinseiD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 56)
    public RString oCR2_shinseiDD2;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 57)
    public RString oCR2_hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 58)
    public RString oCR2_hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 59)
    public RString oCR2_hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 60)
    public RString oCR2_hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 61)
    public RString oCR2_hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 62)
    public RString oCR2_hokenshaNo6;
    @ReportItem(name = "hihokenshaNo1", length = 2, order = 63)
    public RString oCR2_hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 2, order = 64)
    public RString oCR2_hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 2, order = 65)
    public RString oCR2_hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 2, order = 66)
    public RString oCR2_hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 2, order = 67)
    public RString oCR2_hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 2, order = 68)
    public RString oCR2_hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 2, order = 69)
    public RString oCR2_hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 2, order = 70)
    public RString oCR2_hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 2, order = 71)
    public RString oCR2_hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 2, order = 72)
    public RString oCR2_hihokenshaNo10;
    @ReportItem(name = "shinseishaNameKana", length = 30, order = 73)
    public RString oCR2_shinseishaNameKana;
    @ReportItem(name = "shinseishaYubinNo", length = 8, order = 74)
    public RString oCR2_shinseishaYubinNo;
    @ReportItem(name = "shinseishaTelNo", length = 13, order = 75)
    public RString oCR2_shinseishaTelNo;
    @ReportItem(name = "seibetsuMan", length = 2, order = 76)
    public RString oCR2_seibetsuMan;
    @ReportItem(name = "shinseishaName", length = 35, order = 77)
    public RString oCR2_shinseishaName;
    @ReportItem(name = "shinseishaJusho", length = 60, order = 78)
    public RString oCR2_shinseishaJusho;
    @ReportItem(name = "seibetsuWoman", length = 2, order = 79)
    public RString oCR2_seibetsuWoman;
    @ReportItem(name = "meiji", length = 2, order = 80)
    public RString oCR2_meiji;
    @ReportItem(name = "taisho", length = 2, order = 81)
    public RString oCR2_taisho;
    @ReportItem(name = "showa", length = 2, order = 82)
    public RString oCR2_showa;
    @ReportItem(name = "birthDD", length = 2, order = 83)
    public RString oCR2_birthDD;
    @ReportItem(name = "birthMM", length = 2, order = 84)
    public RString oCR2_birthMM;
    @ReportItem(name = "birthYY", length = 2, order = 85)
    public RString oCR2_birthYY;
    @ReportItem(name = "age", length = 3, order = 86)
    public RString oCR2_age;
    @ReportItem(name = "shujiiName", length = 20, order = 87)
    public RString oCR2_shujiiName;
    @ReportItem(name = "iryokikanName", length = 55, order = 88)
    public RString oCR2_iryokikanName;
    @ReportItem(name = "iryokikanTelNo", length = 13, order = 89)
    public RString oCR2_iryokikanTelNo;
    @ReportItem(name = "iryokikanJusho", length = 55, order = 90)
    public RString oCR2_iryokikanJusho;
    @ReportItem(name = "iryokikanFaxNo", length = 13, order = 91)
    public RString oCR2_iryokikanFaxNo;
    @ReportItem(name = "shinseiYY1", length = 2, order = 101)
    public RString oCR4_shinseiYY1;
    @ReportItem(name = "shinseiYY2", length = 2, order = 102)
    public RString oCR4_shinseiYY2;
    @ReportItem(name = "shinseiMM1", length = 2, order = 103)
    public RString oCR4_shinseiMM1;
    @ReportItem(name = "shinseiMM2", length = 2, order = 104)
    public RString oCR4_shinseiMM2;
    @ReportItem(name = "shinseiDD1", length = 2, order = 105)
    public RString oCR4_shinseiDD1;
    @ReportItem(name = "shinseiDD2", length = 2, order = 106)
    public RString oCR4_shinseiDD2;
    @ReportItem(name = "hokenshaNo1", length = 2, order = 107)
    public RString oCR4_hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 2, order = 108)
    public RString oCR4_hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 2, order = 109)
    public RString oCR4_hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 2, order = 110)
    public RString oCR4_hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 2, order = 111)
    public RString oCR4_hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 2, order = 112)
    public RString oCR4_hokenshaNo6;
    @ReportItem(name = "hihokenshaNo1", length = 2, order = 113)
    public RString oCR4_hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 2, order = 114)
    public RString oCR4_hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 2, order = 115)
    public RString oCR4_hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 2, order = 116)
    public RString oCR4_hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 2, order = 117)
    public RString oCR4_hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 2, order = 118)
    public RString oCR4_hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 2, order = 119)
    public RString oCR4_hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 2, order = 120)
    public RString oCR4_hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 2, order = 121)
    public RString oCR4_hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 2, order = 122)
    public RString oCR4_hihokenshaNo10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
