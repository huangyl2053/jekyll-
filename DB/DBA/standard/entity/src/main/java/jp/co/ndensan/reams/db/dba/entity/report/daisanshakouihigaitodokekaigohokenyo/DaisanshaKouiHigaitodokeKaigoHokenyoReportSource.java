// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dba.entity.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 第三者行為による被害届（介護保険用）のReportSource
 */
public class DaisanshaKouiHigaitodokeKaigoHokenyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaNameKana", order = 1)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 2)
    public RString hihokenshaName;
    @ReportItem(name = "birthYMD", length = 11, order = 3)
    public RString birthYMD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 5)
    public RString hihokenshaNo;
    @ReportItem(name = "yokaigoJotaiKubun", length = 4, order = 6)
    public RString yokaigoJotaiKubun;
    @ReportItem(name = "ninteiYukoKikanKaishiYMD", length = 11, order = 7)
    public RString ninteiYukoKikanKaishiYMD;
    @ReportItem(name = "ninteiYukoKikanShuryoYMD", length = 11, order = 8)
    public RString ninteiYukoKikanShuryoYMD;
    @ReportItem(name = "remban", length = 4, order = 9)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 10)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
