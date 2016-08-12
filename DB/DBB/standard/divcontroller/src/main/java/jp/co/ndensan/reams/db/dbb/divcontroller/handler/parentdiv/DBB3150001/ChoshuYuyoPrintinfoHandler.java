/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TsuchiSho;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukachoshuyuyo.KaigoFukaChoshuYuyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM62001_1_更新結果確認 のhandlerです。
 *
 * @reamsid_L DBB-1680-050 lihang
 */
public class ChoshuYuyoPrintinfoHandler {

    private final ChoshuYuyoJuminKihonDiv div;

    private static final RString 申請 = new RString("0");
    private static final RString 承認 = new RString("1");
    private static final RString 不承認 = new RString("2");
    private static final RString 取消 = new RString("3");
    private static final RString 訂正 = new RString("4");
    private static final RString 徴収猶予決定通知書 = new RString("徴収猶予決定通知書");
    private static final RString 徴収猶予取消通知書 = new RString("徴収猶予取消通知書");

    /**
     *
     * @param div JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelDiv
     *
     */
    public ChoshuYuyoPrintinfoHandler(ChoshuYuyoJuminKihonDiv div) {
        this.div = div;
    }

    /**
     * initializeのメソッドます。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     */
    public void initialize(FlexibleYear 賦課年度, FlexibleYear 調定年度, TsuchishoNo 通知書番号) {

        ChoshuYuyoJoho 徴収猶予情報 = KaigoFukaChoshuYuyo.createInstance().getChoshuYuyoJoho(調定年度, 賦課年度, 通知書番号);
        RString 徴収猶予状態区分 = 徴収猶予情報.get徴収猶予状態区分();
        RString 徴収猶予作成区分 = 徴収猶予情報.get徴収猶予作成区分();
        if ((申請.equals(徴収猶予状態区分) && 申請.equals(徴収猶予作成区分))
                || 申請.equals(徴収猶予状態区分) && 取消.equals(徴収猶予作成区分)) {
            div.getChoshuYuyoPrintinfo().getPritPublish2().setVisible(false);
        }
        if ((承認.equals(徴収猶予状態区分) && 承認.equals(徴収猶予作成区分))
                || (不承認.equals(徴収猶予状態区分) && 不承認.equals(徴収猶予作成区分))
                || (承認.equals(徴収猶予状態区分) && 訂正.equals(徴収猶予作成区分))
                || (不承認.equals(徴収猶予状態区分) && 訂正.equals(徴収猶予作成区分))) {
            div.getChoshuYuyoPrintinfo().getPritPublish2().setVisible(true);
            div.getChoshuYuyoPrintinfo().getPritPublish2().setTitle(徴収猶予決定通知書);
        }
        if (承認.equals(徴収猶予状態区分) && 取消.equals(徴収猶予作成区分)) {
            div.getChoshuYuyoPrintinfo().getPritPublish2().setVisible(true);
            div.getChoshuYuyoPrintinfo().getPritPublish2().setTitle(徴収猶予取消通知書);
        }
    }

    /**
     * 「発行する」ボタンのンメソッドます。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     */
    public void onClick発行する(FlexibleYear 賦課年度, FlexibleYear 調定年度, TsuchishoNo 通知書番号) {

        FukaJoho 賦課情報 = KaigoFukaChoshuYuyo.createInstance().getFukaJoho(調定年度, 賦課年度, 通知書番号);
        KakushuTsuchishoParameter pama = new KakushuTsuchishoParameter();
        if (徴収猶予決定通知書.equals(div.getChoshuYuyoPrintinfo().getPritPublish2().getTitle())) {
            List<RString> list = new ArrayList<>();
            list.add(TsuchiSho.介護保険料徴収猶予決定通知書.get名称());
            pama.set発行する帳票List(list);
        } else if (徴収猶予取消通知書.equals(div.getChoshuYuyoPrintinfo().getPritPublish2().getTitle())) {
            List<RString> list = new ArrayList<>();
            list.add(TsuchiSho.介護保険料徴収猶予取消通知書.get名称());
            pama.set発行する帳票List(list);
        }
        pama.set賦課の情報_更正前(new FukaJoho(null));
        pama.set賦課の情報_更正後(賦課情報);
        pama.set徴収猶予通知書_発行日(new FlexibleDate(div.getChoshuYuyoPrintinfo().getPritPublish2().getComdiv1().getIssueDate().toDateString()));
//        pama.set徴収猶予通知書_文書番号();
        pama.set変更通知書_文書番号(RString.EMPTY);
        pama.set変更通知書_発行日(FlexibleDate.EMPTY);
        pama.set決定通知書_文書番号(RString.EMPTY);
        pama.set決定通知書_発行日(FlexibleDate.EMPTY);
        pama.set減免通知書_文書番号(RString.EMPTY);
        pama.set減免通知書_発行日(FlexibleDate.EMPTY);
        pama.set特徴開始通知書_発行日(FlexibleDate.EMPTY);
        pama.set納入通知書_出力形式(RString.EMPTY);
        pama.set納入通知書_出力期(RString.EMPTY);
        pama.set納入通知書_発行日(FlexibleDate.EMPTY);
        pama.set調定事由List(null);
        pama.set郵振納付書_出力期(RString.EMPTY);

        KaigoFukaChoshuYuyo.createInstance().publish(pama);
    }
}
