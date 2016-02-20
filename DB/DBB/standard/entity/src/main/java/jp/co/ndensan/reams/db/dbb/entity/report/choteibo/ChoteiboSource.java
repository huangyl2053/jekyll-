// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dbb.entity.report.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class ChoteiboSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "midashi", length = 6, order = 2)
    public RString midashi;
    @ReportItem(name = "gengo", length = 2, order = 3)
    public RString gengo;
    @ReportItem(name = "nendo", length = 2, order = 4)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 5)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 14, order = 6)
    public RString hokenshaName;
    @ReportItem(name = "listTokuchoKi_1", length = 4, order = 7)
    public RString listTokuchoKi_1;
    @ReportItem(name = "listTokuchoKi_2", length = 4, order = 8)
    public RString listTokuchoKi_2;
    @ReportItem(name = "listTokuchoKi_3", length = 4, order = 9)
    public RString listTokuchoKi_3;
    @ReportItem(name = "listTokuchoKi_4", length = 4, order = 10)
    public RString listTokuchoKi_4;
    @ReportItem(name = "listTokuchoKi_5", length = 4, order = 11)
    public RString listTokuchoKi_5;
    @ReportItem(name = "listTokuchoKi_6", length = 4, order = 12)
    public RString listTokuchoKi_6;
    @ReportItem(name = "listTokuchoTsuki_1", length = 3, order = 13)
    public RString listTokuchoTsuki_1;
    @ReportItem(name = "listTokuchoTsuki_2", length = 3, order = 14)
    public RString listTokuchoTsuki_2;
    @ReportItem(name = "listTokuchoTsuki_3", length = 3, order = 15)
    public RString listTokuchoTsuki_3;
    @ReportItem(name = "listTokuchoTsuki_4", length = 3, order = 16)
    public RString listTokuchoTsuki_4;
    @ReportItem(name = "listTokuchoTsuki_5", length = 3, order = 17)
    public RString listTokuchoTsuki_5;
    @ReportItem(name = "listTokuchoTsuki_6", length = 3, order = 18)
    public RString listTokuchoTsuki_6;
    @ReportItem(name = "tokuchoNofuGokei", length = 13, order = 19)
    public RString tokuchoNofuGokei;
    @ReportItem(name = "tokuchoSaishutsuKanfuGaku", length = 10, order = 20)
    public RString tokuchoSaishutsuKanfuGaku;
    @ReportItem(name = "tokuchoSaishutsuKanpuSu", length = 6, order = 21)
    public RString tokuchoSaishutsuKanpuSu;
    @ReportItem(name = "listTokuchoNofugaku_1", length = 11, order = 22)
    public RString listTokuchoNofugaku_1;
    @ReportItem(name = "listTokuchoNofugaku_2", length = 11, order = 23)
    public RString listTokuchoNofugaku_2;
    @ReportItem(name = "listTokuchoNofugaku_3", length = 11, order = 24)
    public RString listTokuchoNofugaku_3;
    @ReportItem(name = "listTokuchoNofugaku_4", length = 11, order = 25)
    public RString listTokuchoNofugaku_4;
    @ReportItem(name = "listTokuchoNofugaku_5", length = 11, order = 26)
    public RString listTokuchoNofugaku_5;
    @ReportItem(name = "listTokuchoNofugaku_6", length = 11, order = 27)
    public RString listTokuchoNofugaku_6;
    @ReportItem(name = "fuchoSaishutsuKanpuSu", length = 6, order = 28)
    public RString fuchoSaishutsuKanpuSu;
    @ReportItem(name = "fuchoSaishutsuKanpuGaku", length = 10, order = 29)
    public RString fuchoSaishutsuKanpuGaku;
    @ReportItem(name = "listZuiji_1", length = 1, order = 30)
    public RString listZuiji_1;
    @ReportItem(name = "listZuiji_2", length = 1, order = 31)
    public RString listZuiji_2;
    @ReportItem(name = "listZuiji_3", length = 1, order = 32)
    public RString listZuiji_3;
    @ReportItem(name = "listZuiji_4", length = 1, order = 33)
    public RString listZuiji_4;
    @ReportItem(name = "listZuiji_5", length = 1, order = 34)
    public RString listZuiji_5;
    @ReportItem(name = "listZuiji_6", length = 1, order = 35)
    public RString listZuiji_6;
    @ReportItem(name = "listZuiji_7", length = 1, order = 36)
    public RString listZuiji_7;
    @ReportItem(name = "listZuiji_8", length = 1, order = 37)
    public RString listZuiji_8;
    @ReportItem(name = "listZuiji_9", length = 1, order = 38)
    public RString listZuiji_9;
    @ReportItem(name = "listZuiji_10", length = 1, order = 39)
    public RString listZuiji_10;
    @ReportItem(name = "listZuiji_11", length = 1, order = 40)
    public RString listZuiji_11;
    @ReportItem(name = "listZuiji_12", length = 1, order = 41)
    public RString listZuiji_12;
    @ReportItem(name = "listZuiji_13", length = 1, order = 42)
    public RString listZuiji_13;
    @ReportItem(name = "listZuiji_14", length = 1, order = 43)
    public RString listZuiji_14;
    @ReportItem(name = "listFuchoKi_1", length = 4, order = 44)
    public RString listFuchoKi_1;
    @ReportItem(name = "listFuchoKi_2", length = 4, order = 45)
    public RString listFuchoKi_2;
    @ReportItem(name = "listFuchoKi_3", length = 4, order = 46)
    public RString listFuchoKi_3;
    @ReportItem(name = "listFuchoKi_4", length = 4, order = 47)
    public RString listFuchoKi_4;
    @ReportItem(name = "listFuchoKi_5", length = 4, order = 48)
    public RString listFuchoKi_5;
    @ReportItem(name = "listFuchoKi_6", length = 4, order = 49)
    public RString listFuchoKi_6;
    @ReportItem(name = "listFuchoKi_7", length = 4, order = 50)
    public RString listFuchoKi_7;
    @ReportItem(name = "listFuchoKi_8", length = 4, order = 51)
    public RString listFuchoKi_8;
    @ReportItem(name = "listFuchoKi_9", length = 4, order = 52)
    public RString listFuchoKi_9;
    @ReportItem(name = "listFuchoKi_10", length = 4, order = 53)
    public RString listFuchoKi_10;
    @ReportItem(name = "listFuchoKi_11", length = 4, order = 54)
    public RString listFuchoKi_11;
    @ReportItem(name = "listFuchoKi_12", length = 4, order = 55)
    public RString listFuchoKi_12;
    @ReportItem(name = "listFuchoKi_13", length = 4, order = 56)
    public RString listFuchoKi_13;
    @ReportItem(name = "listFuchoKi_14", length = 4, order = 57)
    public RString listFuchoKi_14;
    @ReportItem(name = "listFuchoTsuki_1", length = 3, order = 58)
    public RString listFuchoTsuki_1;
    @ReportItem(name = "listFuchoTsuki_2", length = 3, order = 59)
    public RString listFuchoTsuki_2;
    @ReportItem(name = "listFuchoTsuki_3", length = 3, order = 60)
    public RString listFuchoTsuki_3;
    @ReportItem(name = "listFuchoTsuki_4", length = 3, order = 61)
    public RString listFuchoTsuki_4;
    @ReportItem(name = "listFuchoTsuki_5", length = 3, order = 62)
    public RString listFuchoTsuki_5;
    @ReportItem(name = "listFuchoTsuki_6", length = 3, order = 63)
    public RString listFuchoTsuki_6;
    @ReportItem(name = "listFuchoTsuki_7", length = 3, order = 64)
    public RString listFuchoTsuki_7;
    @ReportItem(name = "listFuchoTsuki_8", length = 3, order = 65)
    public RString listFuchoTsuki_8;
    @ReportItem(name = "listFuchoTsuki_9", length = 3, order = 66)
    public RString listFuchoTsuki_9;
    @ReportItem(name = "listFuchoTsuki_10", length = 3, order = 67)
    public RString listFuchoTsuki_10;
    @ReportItem(name = "listFuchoTsuki_11", length = 3, order = 68)
    public RString listFuchoTsuki_11;
    @ReportItem(name = "listFuchoTsuki_12", length = 3, order = 69)
    public RString listFuchoTsuki_12;
    @ReportItem(name = "listFuchoTsuki_13", length = 3, order = 70)
    public RString listFuchoTsuki_13;
    @ReportItem(name = "listFuchoTsuki_14", length = 3, order = 71)
    public RString listFuchoTsuki_14;
    @ReportItem(name = "listFuchoNofugaku_1", length = 11, order = 72)
    public RString listFuchoNofugaku_1;
    @ReportItem(name = "listFuchoNofugaku_2", length = 11, order = 73)
    public RString listFuchoNofugaku_2;
    @ReportItem(name = "listFuchoNofugaku_3", length = 11, order = 74)
    public RString listFuchoNofugaku_3;
    @ReportItem(name = "listFuchoNofugaku_4", length = 11, order = 75)
    public RString listFuchoNofugaku_4;
    @ReportItem(name = "listFuchoNofugaku_5", length = 11, order = 76)
    public RString listFuchoNofugaku_5;
    @ReportItem(name = "listFuchoNofugaku_6", length = 11, order = 77)
    public RString listFuchoNofugaku_6;
    @ReportItem(name = "listFuchoNofugaku_7", length = 11, order = 78)
    public RString listFuchoNofugaku_7;
    @ReportItem(name = "listFuchoNofugaku_8", length = 11, order = 79)
    public RString listFuchoNofugaku_8;
    @ReportItem(name = "listFuchoNofugaku_9", length = 11, order = 80)
    public RString listFuchoNofugaku_9;
    @ReportItem(name = "listFuchoNofugaku_10", length = 11, order = 81)
    public RString listFuchoNofugaku_10;
    @ReportItem(name = "listFuchoNofugaku_11", length = 11, order = 82)
    public RString listFuchoNofugaku_11;
    @ReportItem(name = "listFuchoNofugaku_12", length = 11, order = 83)
    public RString listFuchoNofugaku_12;
    @ReportItem(name = "listFuchoNofugaku_13", length = 11, order = 84)
    public RString listFuchoNofugaku_13;
    @ReportItem(name = "listFuchoNofugaku_14", length = 11, order = 85)
    public RString listFuchoNofugaku_14;
    @ReportItem(name = "fuchichoNofuGokei", length = 13, order = 86)
    public RString fuchichoNofuGokei;
    @ReportItem(name = "genmenSu", length = 8, order = 87)
    public RString genmenSu;
    @ReportItem(name = "genmenGaku", length = 11, order = 88)
    public RString genmenGaku;
    @ReportItem(name = "nofuGakuSokei", length = 13, order = 89)
    public RString nofuGakuSokei;
    @ReportItem(name = "listTokuchoDankaiBetsu_1", length = 5, order = 90)
    public RString listTokuchoDankaiBetsu_1;
    @ReportItem(name = "listTokuchoDankaiBetsu_2", length = 8, order = 91)
    public RString listTokuchoDankaiBetsu_2;
    @ReportItem(name = "listTokuchoDankaiBetsu_3", length = 11, order = 92)
    public RString listTokuchoDankaiBetsu_3;
    @ReportItem(name = "listTokuchoDankaiBetsu_4", length = 8, order = 93)
    public RString listTokuchoDankaiBetsu_4;
    @ReportItem(name = "listTokuchoDankaiBetsu_5", length = 11, order = 94)
    public RString listTokuchoDankaiBetsu_5;
    @ReportItem(name = "listTokuchoDankaiBetsu_6", length = 8, order = 95)
    public RString listTokuchoDankaiBetsu_6;
    @ReportItem(name = "listTokuchoDankaiBetsu_7", length = 11, order = 96)
    public RString listTokuchoDankaiBetsu_7;
    @ReportItem(name = "listTokuchoDankaiBetsu_8", length = 8, order = 97)
    public RString listTokuchoDankaiBetsu_8;
    @ReportItem(name = "listTokuchoDankaiBetsu_9", length = 11, order = 98)
    public RString listTokuchoDankaiBetsu_9;
    @ReportItem(name = "listFuchoDankaiBetsu_1", length = 5, order = 99)
    public RString listFuchoDankaiBetsu_1;
    @ReportItem(name = "listFuchoDankaiBetsu_2", length = 8, order = 100)
    public RString listFuchoDankaiBetsu_2;
    @ReportItem(name = "listFuchoDankaiBetsu_3", length = 11, order = 101)
    public RString listFuchoDankaiBetsu_3;
    @ReportItem(name = "listFuchoDankaiBetsu_4", length = 8, order = 102)
    public RString listFuchoDankaiBetsu_4;
    @ReportItem(name = "listFuchoDankaiBetsu_5", length = 11, order = 103)
    public RString listFuchoDankaiBetsu_5;
    @ReportItem(name = "listFuchoDankaiBetsu_6", length = 8, order = 104)
    public RString listFuchoDankaiBetsu_6;
    @ReportItem(name = "listFuchoDankaiBetsu_7", length = 11, order = 105)
    public RString listFuchoDankaiBetsu_7;
    @ReportItem(name = "listFuchoDankaiBetsu_8", length = 8, order = 106)
    public RString listFuchoDankaiBetsu_8;
    @ReportItem(name = "listFuchoDankaiBetsu_9", length = 11, order = 107)
    public RString listFuchoDankaiBetsu_9;
    @ReportItem(name = "listDankaiBetsu_1", length = 5, order = 108)
    public RString listDankaiBetsu_1;
    @ReportItem(name = "listDankaiBetsu_2", length = 9, order = 109)
    public RString listDankaiBetsu_2;
    @ReportItem(name = "listDankaiBetsu_3", length = 9, order = 110)
    public RString listDankaiBetsu_3;
    @ReportItem(name = "listDankaiBetsu_4", length = 9, order = 111)
    public RString listDankaiBetsu_4;
    @ReportItem(name = "nendoTitle", length = 4, order = 112)
    public RString nendoTitle;
    @ReportItem(name = "tokuchoTogetsuSuKome", length = 1, order = 113)
    public RString tokuchoTogetsuSuKome;
    @ReportItem(name = "tokuchoTogetsuGakuKome", length = 1, order = 114)
    public RString tokuchoTogetsuGakuKome;
    @ReportItem(name = "fuchoTogetsuSuKome", length = 1, order = 115)
    public RString fuchoTogetsuSuKome;
    @ReportItem(name = "fuchoTogetsuGakuKome", length = 1, order = 116)
    public RString fuchoTogetsuGakuKome;
    @ReportItem(name = "tokuchoshaShaSuKome", length = 1, order = 117)
    public RString tokuchoshaShaSuKome;
    @ReportItem(name = "fuchoShaSuKome", length = 1, order = 118)
    public RString fuchoShaSuKome;
    @ReportItem(name = "HeichoShaSuKome", length = 1, order = 119)
    public RString HeichoShaSuKome;
    @ReportItem(name = "listTokuchoGokei_1", length = 2, order = 120)
    public RString listTokuchoGokei_1;
    @ReportItem(name = "listTokuchoGokei_2", length = 8, order = 121)
    public RString listTokuchoGokei_2;
    @ReportItem(name = "listTokuchoGokei_3", length = 11, order = 122)
    public RString listTokuchoGokei_3;
    @ReportItem(name = "listTokuchoGokei_4", length = 8, order = 123)
    public RString listTokuchoGokei_4;
    @ReportItem(name = "listTokuchoGokei_5", length = 11, order = 124)
    public RString listTokuchoGokei_5;
    @ReportItem(name = "listTokuchoGokei_6", length = 8, order = 125)
    public RString listTokuchoGokei_6;
    @ReportItem(name = "listTokuchoGokei_7", length = 11, order = 126)
    public RString listTokuchoGokei_7;
    @ReportItem(name = "listTokuchoGokei_8", length = 8, order = 127)
    public RString listTokuchoGokei_8;
    @ReportItem(name = "listTokuchoGokei_9", length = 11, order = 128)
    public RString listTokuchoGokei_9;
    @ReportItem(name = "listFuchoGokei_1", length = 2, order = 129)
    public RString listFuchoGokei_1;
    @ReportItem(name = "listFuchoGokei_2", length = 8, order = 130)
    public RString listFuchoGokei_2;
    @ReportItem(name = "listFuchoGokei_3", length = 11, order = 131)
    public RString listFuchoGokei_3;
    @ReportItem(name = "listFuchoGokei_4", length = 8, order = 132)
    public RString listFuchoGokei_4;
    @ReportItem(name = "listFuchoGokei_5", length = 11, order = 133)
    public RString listFuchoGokei_5;
    @ReportItem(name = "listFuchoGokei_6", length = 8, order = 134)
    public RString listFuchoGokei_6;
    @ReportItem(name = "listFuchoGokei_7", length = 11, order = 135)
    public RString listFuchoGokei_7;
    @ReportItem(name = "listFuchoGokei_8", length = 8, order = 136)
    public RString listFuchoGokei_8;
    @ReportItem(name = "listFuchoGokei_9", length = 11, order = 137)
    public RString listFuchoGokei_9;
    @ReportItem(name = "listDankaiBetsuGokei_1", length = 2, order = 138)
    public RString listDankaiBetsuGokei_1;
    @ReportItem(name = "listDankaiBetsuGokei_2", length = 9, order = 139)
    public RString listDankaiBetsuGokei_2;
    @ReportItem(name = "listDankaiBetsuGokei_3", length = 9, order = 140)
    public RString listDankaiBetsuGokei_3;
    @ReportItem(name = "listDankaiBetsuGokei_4", length = 9, order = 141)
    public RString listDankaiBetsuGokei_4;
    @ReportItem(name = "mongon", length = 200, order = 142)
    public RString mongon;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
