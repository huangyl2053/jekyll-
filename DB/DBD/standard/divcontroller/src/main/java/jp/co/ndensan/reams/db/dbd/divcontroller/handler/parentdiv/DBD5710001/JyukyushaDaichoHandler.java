/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5710001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.outputorderkey.JyukyushaDaichoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD571001.DBD571001_JukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001.JyukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳リスト作成画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1760-010 xuejm
 */
public class JyukyushaDaichoHandler {

    private static final int NOCOUNT_1 = 1;
    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_3 = 3;
    private static final int NOCOUNT_4 = 4;
    private static final int NOCOUNT_5 = 5;
    private static final int NOCOUNT_6 = 6;
    private static final int NOCOUNT_7 = 7;
    private static final int NOCOUNT_8 = 8;
    private static final int NOCOUNT_9 = 9;
    private static final int NOCOUNT_10 = 10;
    private static final int NOCOUNT_11 = 11;

    private static final RString 抽出条件_1 = new RString("1");
    private static final RString 抽出条件_2 = new RString("2");
    private static final RString 抽出条件_3 = new RString("3");
    private static final RString 抽出条件_4 = new RString("4");
    private static final RString 抽出条件_5 = new RString("5");
    private static final RString 抽出条件_6 = new RString("6");
    private static final RString 抽出条件_7 = new RString("7");
    private static final RString 抽出条件_8 = new RString("8");
    private static final RString 抽出条件_9 = new RString("9");
    private static final RString 抽出条件_10 = new RString("10");
    private static final RString 抽出条件_11 = new RString("11");

    private final JyukyushaDaichoDiv div;
    private static final RString 対象者 = new RString("0");
    private static final RString 対象期間 = new RString("1");
    private static final RString 全てのページを印刷する = new RString("0");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private RString 出力順;

    /**
     *
     * @param div JyukyushaDaichoDiv
     */
    public JyukyushaDaichoHandler(JyukyushaDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param shoriDateKanri ShoriDateKanri
     */
    public void onLoad(ShoriDateKanri shoriDateKanri) {
        if (shoriDateKanri != null && shoriDateKanri.get対象開始日時() != null
                && shoriDateKanri.get対象終了日時() != null) {
            div.getTaishouKikan().getTxtZenkaiymdtime().setFromDateValue(shoriDateKanri.get対象開始日時().getDate());
            div.getTaishouKikan().getTxtZenkaiymdtime().setFromTimeValue(shoriDateKanri.get対象開始日時().getRDateTime().getTime());
            div.getTaishouKikan().getTxtZenkaiymdtime().setToDateValue(shoriDateKanri.get対象終了日時().getDate());
            div.getTaishouKikan().getTxtZenkaiymdtime().setToTimeValue(shoriDateKanri.get対象終了日時().getRDateTime().getTime());
        }
        select抽出条件設定(shoriDateKanri);
        List<RString> chkIdouChushutsuTaishou = new ArrayList();
        RString value = DbBusinessConfig.get(ConfigNameDBD.受給者台帳初期値_抽出条件, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (value.substring(0, NOCOUNT_1).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_1);
        }
        if (value.substring(NOCOUNT_1, NOCOUNT_2).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_2);
        }
        if (value.substring(NOCOUNT_2, NOCOUNT_3).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_3);
        }
        if (value.substring(NOCOUNT_3, NOCOUNT_4).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_4);
        }
        if (value.substring(NOCOUNT_4, NOCOUNT_5).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_5);
        }
        if (value.substring(NOCOUNT_5, NOCOUNT_6).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_6);
        }
        if (value.substring(NOCOUNT_6, NOCOUNT_7).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_7);
        }
        if (value.substring(NOCOUNT_7, NOCOUNT_8).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_8);
        }
        if (value.substring(NOCOUNT_8, NOCOUNT_9).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_9);
        }
        if (value.substring(NOCOUNT_9, NOCOUNT_10).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_10);
        }
        if (value.substring(NOCOUNT_10, NOCOUNT_11).equals(抽出条件_1)) {
            chkIdouChushutsuTaishou.add(抽出条件_11);
        }
        div.getTaishouKikan().getChkIdouChushutsuTaishou().setSelectedItemsByKey(chkIdouChushutsuTaishou);
    }

    /**
     * 出力順を取得します。
     *
     * @return 受給者台帳リスト出力順です。
     */
    public RString get画面出力順() {
        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        Long 出力順ID = div.getShutsuryokuSort().getSelected出力順().get出力順ID();
        IOutputOrder chohyoShuturyokujun = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                ReportIdDBD.DBD100026.getReportId(), reamsLoginID, 出力順ID);
        if (chohyoShuturyokujun != null) {
            出力順 = MyBatisOrderByClauseCreator.create(JyukyushaDaichoOrderKey.class, chohyoShuturyokujun);
        }
        return 出力順;
    }

    /**
     * 「抽出条件設定」ラジオボタン
     *
     * @param shoriDateKanri ShoriDateKanri
     */
    public void radChushutsuJyouken_onChange(ShoriDateKanri shoriDateKanri) {

        if (対象者.equals(div.getChushutsuJyouken().getRadChushutsuJyouken().getSelectedKey())) {
            div.getTaishouSha().getHihokenshanoFrom().setDisabled(false);
            div.getTaishouSha().getHihokenshanoTo().setDisabled(false);
            div.getTaishouKikan().getTxtKonkaiymdtime().setDisabled(true);
            div.getTaishouKikan().getTxtKonkaiymdtime().clearFromValue();
            div.getTaishouKikan().getTxtKonkaiymdtime().clearToValue();
        } else if (対象期間.equals(div.getChushutsuJyouken().getRadChushutsuJyouken().getSelectedKey())) {
            set今回抽出日付(shoriDateKanri);
            if (div.getTaishouSha().getHihokenshanoFrom() != null && div.getTaishouSha().getHihokenshanoTo() != null) {
                div.getTaishouSha().getHihokenshanoFrom().clearValue();
                div.getTaishouSha().getHihokenshanoTo().clearValue();
            }
        }
    }

    /**
     * バッチパラメータを設定します。
     *
     * @param div JyukyushaDaichoDiv
     * @param parameter DBD571001Parameter
     * @param shoriDateKanri ShoriDateKanri
     */
    public void onCilck_btnBatchRegister(JyukyushaDaichoDiv div, DBD571001_JukyushaDaichoParameter parameter, ShoriDateKanri shoriDateKanri) {
        if (対象期間.equals(div.getRadChushutsuJyouken().getSelectedKey())) {
            parameter.set抽出条件設定区分(KEY0);
        } else {
            parameter.set抽出条件設定区分(KEY1);
        }
        if (div.getTaishouSha().getHihokenshanoFrom() != null
                && div.getTaishouSha().getHihokenshanoTo() != null) {
            parameter.set被保険者番号_From(div.getTaishouSha().getHihokenshanoFrom().getValue());
            parameter.set被保険者番号_To(div.getTaishouSha().getHihokenshanoTo().getValue());
        }
        parameter.set今回抽出開始年月日(div.getTaishouKikan().getTxtKonkaiymdtime().getFromDateValue());
        parameter.set今回抽出開始時分秒(div.getTaishouKikan().getTxtKonkaiymdtime().getFromTimeValue());
        parameter.set今回抽出終了年月日(div.getTaishouKikan().getTxtKonkaiymdtime().getToDateValue());
        parameter.set今回抽出終了時分秒(div.getTaishouKikan().getTxtKonkaiymdtime().getToTimeValue());
        parameter.set異動抽出対象リスト(setparameter_異動抽出());
        if (div.getRadShutsuryokuOption().getSelectedKey().equals(全てのページを印刷する)) {
            parameter.set出力オプション区分(KEY0);
        } else {
            parameter.set出力オプション区分(KEY1);
        }
        parameter.set出力順設定リスト(get画面出力順());

        if (shoriDateKanri != null) {
            parameter.set市町村コード(shoriDateKanri.get市町村コード().value());
        }
    }

    private void set今回抽出日付(ShoriDateKanri shoriDateKanri) {
        if (shoriDateKanri != null && shoriDateKanri.get対象終了日時() != null) {
            div.getTaishouKikan().getTxtKonkaiymdtime().setFromDateValue(shoriDateKanri.get対象終了日時().getDate());
            div.getTaishouKikan().getTxtKonkaiymdtime().setFromTimeValue(shoriDateKanri.get対象終了日時().getRDateTime().getTime().plusSeconds(1));
        }
        div.getTaishouKikan().getTxtKonkaiymdtime().setToDateValue(RDate.getNowDate());
        div.getTaishouKikan().getTxtKonkaiymdtime().setToTimeValue(RDate.getNowDateTime().getTime());
        div.getTaishouSha().getHihokenshanoFrom().setDisabled(true);
        div.getTaishouSha().getHihokenshanoTo().setDisabled(true);
        div.getTaishouKikan().getTxtKonkaiymdtime().setDisabled(false);
    }

    private List<RString> setparameter_異動抽出() {
        List<RString> list異動 = new ArrayList<>();
        List<RString> 異動抽出list = div.getTaishouKikan().getChkIdouChushutsuTaishou().getSelectedValues();
        for (RString list抽出 : 異動抽出list) {
            list異動.add(list抽出.trim());
        }
        return list異動;
    }

    private void select抽出条件設定(ShoriDateKanri shoriDateKanri) {
        if (対象期間.equals(div.getRadChushutsuJyouken().getSelectedKey())) {
            set今回抽出日付(shoriDateKanri);
            if (div.getTaishouSha().getHihokenshanoFrom() != null && div.getTaishouSha().getHihokenshanoTo() != null) {
                div.getTaishouSha().getHihokenshanoFrom().clearValue();
                div.getTaishouSha().getHihokenshanoTo().clearValue();
            }
        } else {
            div.getTaishouKikan().getTxtKonkaiymdtime().clearFromValue();
            div.getTaishouKikan().getTxtKonkaiymdtime().clearToValue();
            div.getTaishouSha().getHihokenshanoFrom().setDisabled(false);
            div.getTaishouSha().getHihokenshanoTo().setDisabled(false);
            div.getTaishouKikan().getTxtKonkaiymdtime().setDisabled(true);
        }
    }
}
