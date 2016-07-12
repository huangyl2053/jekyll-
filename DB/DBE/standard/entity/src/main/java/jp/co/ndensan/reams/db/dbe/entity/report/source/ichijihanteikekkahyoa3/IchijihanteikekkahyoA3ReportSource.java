package jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 委員用一次判定結果票A3のReportSourceクラスです。
 *
 * @reamsid_L DBE-0150-130 lishengli
 */
public class IchijihanteikekkahyoA3ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shisetsuNameTxit1", order = 1)
    public RString shisetsuNameTxit1;
    @ReportItem(name = "imgShisetsuName1", order = 2)
    public RString imgShisetsuName1;
    @ReportItem(name = "shisetsuAddressTxit1", order = 3)
    public RString shisetsuAddressTxit1;
    @ReportItem(name = "imgShisetsuAddress1", order = 4)
    public RString imgShisetsuAddress1;
    @ReportItem(name = "shisetsuTelTxit1", order = 5)
    public RString shisetsuTelTxit1;
    @ReportItem(name = "imgShisetsuTel1", order = 6)
    public RString imgShisetsuTel1;
    @ReportItem(name = "gogitaiNo", length = 3, order = 7)
    public RString gogitaiNo;
    @ReportItem(name = "chosaJisshiDate2", length = 9, order = 8)
    public RString chosaJisshiDate2;
    @ReportItem(name = "zenZenkaiHanteikekka", length = 8, order = 9)
    public RString zenZenkaiHanteikekka;
    @ReportItem(name = "zenzenkaiYukokikan", length = 4, order = 10)
    public RString zenzenkaiYukokikan;
    @ReportItem(name = "zZenkaiNijiKaishiYMD", length = 9, order = 11)
    public RString zZenkaiNijiKaishiYMD;
    @ReportItem(name = "zZenkaiNijishuryoYMD", length = 9, order = 12)
    public RString zZenkaiNijishuryoYMD;
    @ReportItem(name = "kanriNo", length = 20, order = 13)
    public RString kanriNo;
    @ReportItem(name = "shinseiYMD1", length = 9, order = 14)
    public RString shinseiYMD1;
    @ReportItem(name = "shinseiCount", length = 2, order = 15)
    public RString shinseiCount;
    @ReportItem(name = "shinseiCountGokei", length = 2, order = 16)
    public RString shinseiCountGokei;
    @ReportItem(name = "hihokenshaKubun", length = 7, order = 17)
    public RString hihokenshaKubun;
    @ReportItem(name = "age", length = 5, order = 18)
    public RString age;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 8, order = 19)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenkaiYukokikan", length = 4, order = 20)
    public RString zenkaiYukokikan;
    @ReportItem(name = "zenkaiNijiKaishiYMD", length = 9, order = 21)
    public RString zenkaiNijiKaishiYMD;
    @ReportItem(name = "zenkaiNijiShuryoYMD", length = 9, order = 22)
    public RString zenkaiNijiShuryoYMD;
    @ReportItem(name = "zenkaiNijihanteiDate", length = 9, order = 23)
    public RString zenkaiNijihanteiDate;
    @ReportItem(name = "zenkaiJotaizo", length = 10, order = 24)
    public RString zenkaiJotaizo;
    @ReportItem(name = "shinseiYMD", length = 9, order = 25)
    public RString shinseiYMD;
    @ReportItem(name = "shinsaYMD", length = 9, order = 26)
    public RString shinsaYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 27)
    public RString seibetsu;
    @ReportItem(name = "shinseiKubun", length = 13, order = 28)
    public RString shinseiKubun;
    @ReportItem(name = "ichijiHanteiKekka", length = 12, order = 29)
    public RString ichijiHanteiKekka;
    @ReportItem(name = "kijunGokeiTime", length = 30, order = 30)
    public RString kijunGokeiTime;
    @ReportItem(name = "listFuseigo1_1", length = 1, order = 31)
    public RString listFuseigo1_1;
    @ReportItem(name = "listFuseigo1_2", length = 1, order = 32)
    public RString listFuseigo1_2;
    @ReportItem(name = "listIchigun_1", length = 22, order = 33)
    public RString listIchigun_1;
    @ReportItem(name = "listIchigun_2", length = 1, order = 34)
    public RString listIchigun_2;
    @ReportItem(name = "listIchigun_3", length = 1, order = 35)
    public RString listIchigun_3;
    @ReportItem(name = "listIchigun_4", length = 22, order = 36)
    public RString listIchigun_4;
    @ReportItem(name = "zenkaiKijunGokeiTime", length = 30, order = 37)
    public RString zenkaiKijunGokeiTime;
    @ReportItem(name = "listkijunTime_1", length = 7, order = 38)
    public RString listkijunTime_1;
    @ReportItem(name = "listkijunTime_2", length = 7, order = 39)
    public RString listkijunTime_2;
    @ReportItem(name = "listkijunTime_3", length = 7, order = 40)
    public RString listkijunTime_3;
    @ReportItem(name = "listkijunTime_4", length = 7, order = 41)
    public RString listkijunTime_4;
    @ReportItem(name = "listkijunTime_5", length = 7, order = 42)
    public RString listkijunTime_5;
    @ReportItem(name = "listkijunTime_6", length = 7, order = 43)
    public RString listkijunTime_6;
    @ReportItem(name = "listkijunTime_7", length = 7, order = 44)
    public RString listkijunTime_7;
    @ReportItem(name = "listkijunTime_8", length = 7, order = 45)
    public RString listkijunTime_8;
    @ReportItem(name = "listkijunTime_9", length = 7, order = 46)
    public RString listkijunTime_9;
    @ReportItem(name = "listFuseigo2_1", length = 1, order = 47)
    public RString listFuseigo2_1;
    @ReportItem(name = "listFuseigo2_2", length = 1, order = 48)
    public RString listFuseigo2_2;
    @ReportItem(name = "listNigun_1", length = 22, order = 49)
    public RString listNigun_1;
    @ReportItem(name = "listNigun_2", length = 1, order = 50)
    public RString listNigun_2;
    @ReportItem(name = "listNigun_3", length = 1, order = 51)
    public RString listNigun_3;
    @ReportItem(name = "listNigun_4", length = 22, order = 52)
    public RString listNigun_4;
    @ReportItem(name = "chosaJisshiDate1", length = 9, order = 53)
    public RString chosaJisshiDate1;
    @ReportItem(name = "chosaJisshiBasho", length = 30, order = 54)
    public RString chosaJisshiBasho;
    @ReportItem(name = "tokuteishippeiName", length = 40, order = 55)
    public RString tokuteishippeiName;
    @ReportItem(name = "keikokuNo", length = 120, order = 56)
    public RString keikokuNo;
    @ReportItem(name = "listFuseigo3_1", length = 1, order = 57)
    public RString listFuseigo3_1;
    @ReportItem(name = "listFuseigo3_2", length = 1, order = 58)
    public RString listFuseigo3_2;
    @ReportItem(name = "listSangun_1", length = 22, order = 59)
    public RString listSangun_1;
    @ReportItem(name = "listSangun_2", length = 1, order = 60)
    public RString listSangun_2;
    @ReportItem(name = "listSangun_3", length = 1, order = 61)
    public RString listSangun_3;
    @ReportItem(name = "listSangun_4", length = 22, order = 62)
    public RString listSangun_4;
    @ReportItem(name = "listChukanhyoka_1", length = 5, order = 63)
    public RString listChukanhyoka_1;
    @ReportItem(name = "listChukanhyoka_2", length = 5, order = 64)
    public RString listChukanhyoka_2;
    @ReportItem(name = "listChukanhyoka_3", length = 5, order = 65)
    public RString listChukanhyoka_3;
    @ReportItem(name = "listChukanhyoka_4", length = 5, order = 66)
    public RString listChukanhyoka_4;
    @ReportItem(name = "listChukanhyoka_5", length = 5, order = 67)
    public RString listChukanhyoka_5;
    @ReportItem(name = "ｌistSeikatsujiritsu_1", length = 2, order = 68)
    public RString ｌistSeikatsujiritsu_1;
    @ReportItem(name = "ｌistSeikatsujiritsu_2", length = 1, order = 69)
    public RString ｌistSeikatsujiritsu_2;
    @ReportItem(name = "listFuseigo4_1", length = 1, order = 70)
    public RString listFuseigo4_1;
    @ReportItem(name = "listFuseigo4_2", length = 1, order = 71)
    public RString listFuseigo4_2;
    @ReportItem(name = "listYongun_1", length = 22, order = 72)
    public RString listYongun_1;
    @ReportItem(name = "listYongun_2", length = 1, order = 73)
    public RString listYongun_2;
    @ReportItem(name = "listYongun_3", length = 1, order = 74)
    public RString listYongun_3;
    @ReportItem(name = "listYongun_4", length = 22, order = 75)
    public RString listYongun_4;
    @ReportItem(name = "chosaNinchishoJiritsudo", length = 2, order = 76)
    public RString chosaNinchishoJiritsudo;
    @ReportItem(name = "ikenNinchiJiritsudo", length = 2, order = 77)
    public RString ikenNinchiJiritsudo;
    @ReportItem(name = "manzensei", length = 6, order = 78)
    public RString manzensei;
    @ReportItem(name = "jotainoanteisei", length = 4, order = 79)
    public RString jotainoanteisei;
    @ReportItem(name = "kyufukubun", length = 4, order = 80)
    public RString kyufukubun;
    @ReportItem(name = "sabisuText1", order = 81)
    public RString sabisuText1;
    @ReportItem(name = "sabisuText2", order = 82)
    public RString sabisuText2;
    @ReportItem(name = "listFuseigo5_1", length = 1, order = 83)
    public RString listFuseigo5_1;
    @ReportItem(name = "listFuseigo5_2", length = 1, order = 84)
    public RString listFuseigo5_2;
    @ReportItem(name = "listGogun_1", length = 22, order = 85)
    public RString listGogun_1;
    @ReportItem(name = "listGogun_2", length = 1, order = 86)
    public RString listGogun_2;
    @ReportItem(name = "listGogun_3", length = 1, order = 87)
    public RString listGogun_3;
    @ReportItem(name = "listGogun_4", length = 22, order = 88)
    public RString listGogun_4;
    @ReportItem(name = "listtokubetsunaIryo1_1", length = 2, order = 89)
    public RString listtokubetsunaIryo1_1;
    @ReportItem(name = "listtokubetsunaIryo1_2", length = 1, order = 90)
    public RString listtokubetsunaIryo1_2;
    @ReportItem(name = "listtokubetsunaIryo1_3", length = 1, order = 91)
    public RString listtokubetsunaIryo1_3;
    @ReportItem(name = "listtokubetsunaIryo1_4", length = 1, order = 92)
    public RString listtokubetsunaIryo1_4;
    @ReportItem(name = "listtokubetsunaIryo2_1", length = 2, order = 93)
    public RString listtokubetsunaIryo2_1;
    @ReportItem(name = "listtokubetsunaIryo2_2", length = 1, order = 94)
    public RString listtokubetsunaIryo2_2;
    @ReportItem(name = "listtokubetsunaIryo2_3", length = 1, order = 95)
    public RString listtokubetsunaIryo2_3;
    @ReportItem(name = "listtokubetsunaIryo2_4", length = 1, order = 96)
    public RString listtokubetsunaIryo2_4;
    //なし
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation shinseishoKanriNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shinseiCount,

    }
}
