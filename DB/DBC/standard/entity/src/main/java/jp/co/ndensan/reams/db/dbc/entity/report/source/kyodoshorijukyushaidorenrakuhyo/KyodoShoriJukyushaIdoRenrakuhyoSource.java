package jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushaidorenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 共同処理用受給者異動連絡票（紙媒体）Source
 *
 * @reamsid_L DBC-1950-050 chenaoqi
 */
public class KyodoShoriJukyushaIdoRenrakuhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sakuseiMM", length = 2, order = 1)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 2)
    public RString sakuseiDD;
    @ReportItem(name = "sakuseiGG", length = 2, order = 3)
    public RString sakuseiGG;
    @ReportItem(name = "sakuseiYY", length = 2, order = 4)
    public RString sakuseiYY;
    @ReportItem(name = "hokenshaName", length = 20, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "idoKbn1", length = 1, order = 6)
    public RString idoKbn1;
    @ReportItem(name = "idoKbn2", length = 1, order = 7)
    public RString idoKbn2;
    @ReportItem(name = "shoHokenshaNo", length = 6, order = 8)
    public RString shoHokenshaNo;
    @ReportItem(name = "idoGG", length = 2, order = 9)
    public RString idoGG;
    @ReportItem(name = "idoYY", length = 2, order = 10)
    public RString idoYY;
    @ReportItem(name = "idoMM", length = 2, order = 11)
    public RString idoMM;
    @ReportItem(name = "idoDD", length = 2, order = 12)
    public RString idoDD;
    @ReportItem(name = "idoJiyu1", length = 1, order = 13)
    public RString idoJiyu1;
    @ReportItem(name = "idoJiyu2", length = 1, order = 14)
    public RString idoJiyu2;
    @ReportPerson(id = "X")
    @ReportExpandedInfo(id = "hihokenshaNo", code = "0003", name = "被保険者番号")
    @ReportItem(name = "hihokenshaNo", length = 1, order = 15)
    public RString hihokenshaNo;
    @ReportItem(name = "idoJiyu4", length = 1, order = 16)
    public RString idoJiyu4;
    @ReportItem(name = "idoJiyu3", length = 1, order = 17)
    public RString idoJiyu3;
    @ReportItem(name = "hihokenshaName", length = 20, order = 18)
    public RString hihokenshaName;
    @ReportItem(name = "telNo", length = 12, order = 19)
    public RString telNo;
    @ReportItem(name = "yubinNo", length = 8, order = 20)
    public RString yubinNo;
    @ReportItem(name = "jushoKana1", length = 38, order = 21)
    public RString jushoKana1;
    @ReportItem(name = "shutsuryokujunCode", length = 3, order = 22)
    public RString shutsuryokujunCode;
    @ReportItem(name = "jushoKana2", length = 37, order = 23)
    public RString jushoKana2;
    @ReportItem(name = "jusho1", length = 32, order = 24)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 32, order = 25)
    public RString jusho2;
    @ReportItem(name = "kaishiGG", length = 2, order = 26)
    public RString kaishiGG;
    @ReportItem(name = "kaishiYY", length = 2, order = 27)
    public RString kaishiYY;
    @ReportItem(name = "kaishiMM", length = 2, order = 28)
    public RString kaishiMM;
    @ReportItem(name = "kaishiDD", length = 2, order = 29)
    public RString kaishiDD;
    @ReportItem(name = "ichiSashiKbn1", length = 1, order = 30)
    public RString ichiSashiKbn1;
    @ReportItem(name = "ichiSashiKbn2", length = 1, order = 31)
    public RString ichiSashiKbn2;
    @ReportItem(name = "ichiSashiKingaku", length = 9, order = 32)
    public RString ichiSashiKingaku;
    @ReportItem(name = "shuryoGG", length = 2, order = 33)
    public RString shuryoGG;
    @ReportItem(name = "shuryoYY", length = 2, order = 34)
    public RString shuryoYY;
    @ReportItem(name = "shuryoMM", length = 2, order = 35)
    public RString shuryoMM;
    @ReportItem(name = "shuryoDD", length = 2, order = 36)
    public RString shuryoDD;
    @ReportItem(name = "setainushiHihokenshaNo", length = 10, order = 37)
    public RString setainushiHihokenshaNo;
    @ReportItem(name = "setaiShotokuKbn2", length = 1, order = 38)
    public RString setaiShotokuKbn2;
    @ReportItem(name = "setaiShotokuKbn1", length = 1, order = 39)
    public RString setaiShotokuKbn1;
    @ReportItem(name = "setaiShotokuKbn3", length = 1, order = 40)
    public RString setaiShotokuKbn3;
    @ReportItem(name = "setaiShotokuKbn4", length = 1, order = 41)
    public RString setaiShotokuKbn4;
    @ReportItem(name = "shotokuKbn1", length = 1, order = 42)
    public RString shotokuKbn1;
    @ReportItem(name = "riyoshaFutan1", length = 1, order = 43)
    public RString riyoshaFutan1;
    @ReportItem(name = "riyoshaFutan2", length = 1, order = 44)
    public RString riyoshaFutan2;
    @ReportItem(name = "shotokuKbn2", length = 1, order = 45)
    public RString shotokuKbn2;
    @ReportItem(name = "shotokuKbn3", length = 1, order = 46)
    public RString shotokuKbn3;
    @ReportItem(name = "shotokuKbn4", length = 1, order = 47)
    public RString shotokuKbn4;
    @ReportItem(name = "roreiUmu1", length = 1, order = 48)
    public RString roreiUmu1;
    @ReportItem(name = "roreiUmu2", length = 1, order = 49)
    public RString roreiUmu2;
    @ReportItem(name = "shikyuUmu1", length = 1, order = 50)
    public RString shikyuUmu1;
    @ReportItem(name = "shikyuUmu2", length = 1, order = 51)
    public RString shikyuUmu2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
