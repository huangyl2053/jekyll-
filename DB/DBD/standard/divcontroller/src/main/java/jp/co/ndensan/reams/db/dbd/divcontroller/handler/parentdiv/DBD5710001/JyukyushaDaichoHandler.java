/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5710001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001.JyukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.basic.shoridatekanri.ShoriDateKanriService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

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

    private final JyukyushaDaichoDiv div;
    private static final RString 対象者 = new RString("0");
    private static final RString 対象期間 = new RString("NOCOUNT_1");

    /**
     *
     * @param div JyukyushaDaichoDiv
     */
    public JyukyushaDaichoHandler(JyukyushaDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonSecurityJoho != null) {
            LasdecCode 市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
            ShoriDateKanriService shoriDateKanriService = ShoriDateKanriService.createInstance();
            ShoriDateKanri shoriDateKanri = shoriDateKanriService.get一件取得(市町村コード);

            if (shoriDateKanri != null && shoriDateKanri.get対象開始日時() != null) {
                div.getTaishouKikan().getTxtZenkaiymdtime().setFromDateValue(shoriDateKanri.get対象開始日時().getDate());
                div.getTaishouKikan().getTxtZenkaiymdtime().setFromTimeValue(new RTime(shoriDateKanri.get対象開始日時().toDateString()));
            } else if (shoriDateKanri != null && shoriDateKanri.get対象終了日時() != null) {
                div.getTaishouKikan().getTxtZenkaiymdtime().setToDateValue(shoriDateKanri.get対象終了日時().getDate());
                div.getTaishouKikan().getTxtZenkaiymdtime().setToTimeValue(new RTime(shoriDateKanri.get対象終了日時().toDateString()));
                div.getTaishouKikan().getTxtKonkaiymdtime().setFromTimeValue(
                        new RTime(shoriDateKanri.get対象終了日時().toDateString()).plusSeconds(1));
                div.getTaishouKikan().getTxtKonkaiymdtime().setFromDateValue(shoriDateKanri.get対象終了日時().getDate());
                div.getTaishouKikan().getTxtKonkaiymdtime().setToDateValue(RDate.getNowDate());
                div.getTaishouKikan().getTxtKonkaiymdtime().setToTimeValue(RDate.getNowDateTime().getTime());
            } else {
                div.getTaishouKikan().getTxtZenkaiymdtime().clearFromDateValue();
                div.getTaishouKikan().getTxtZenkaiymdtime().clearToDateValue();
            }
        } else {
            div.getTaishouKikan().getTxtZenkaiymdtime().clearFromDateValue();
            div.getTaishouKikan().getTxtZenkaiymdtime().clearToDateValue();
        }
        List<RString> chkIdouChushutsuTaishou = new ArrayList();
        RString value = DbBusinessConfig.get(ConfigNameDBD.受給者台帳初期値_抽出条件, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (value.substring(0, NOCOUNT_1).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_1"));
        }
        if (value.substring(NOCOUNT_1, NOCOUNT_2).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_2"));
        }
        if (value.substring(NOCOUNT_2, NOCOUNT_3).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_3"));
        }
        if (value.substring(NOCOUNT_3, NOCOUNT_4).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_4"));
        }
        if (value.substring(NOCOUNT_4, NOCOUNT_5).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_5"));
        }
        if (value.substring(NOCOUNT_5, NOCOUNT_6).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_6"));
        }
        if (value.substring(NOCOUNT_6, NOCOUNT_7).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_7"));
        }
        if (value.substring(NOCOUNT_7, NOCOUNT_8).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_8"));
        }
        if (value.substring(NOCOUNT_8, NOCOUNT_9).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_9"));
        }
        if (value.substring(NOCOUNT_9, NOCOUNT_10).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_10"));
        }
        if (value.substring(NOCOUNT_10, NOCOUNT_11).equals(new RString("NOCOUNT_1"))) {
            chkIdouChushutsuTaishou.add(new RString("NOCOUNT_11"));
        }
        div.getTaishouKikan().getChkIdouChushutsuTaishou().setSelectedItemsByKey(chkIdouChushutsuTaishou);

        /* div.getShutsuryokuSort().load(サブ業務コード, 帳票ID);
         出力順ID = div.getShutsuryokuSort().get出力順ID();
         IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
         reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();*/
        /* if (div.getShutsuryokuSort().get出力順ID() != null) {
         long 帳票出力順ID = Long.valueOf(div.getShutsuryokuSort().get出力順ID().toString());
         IOutputOrder chohyoShuturyokujun = chohyoShutsuryokujunFinder.get出力順(
         サブ業務コード,
         帳票ID,
         reamsLoginID,
         帳票出力順ID);
         if (chohyoShuturyokujun != null) {
         orderby = MyBatisOrderByClauseCreator.create(DBD5710001JyukyushaDaichoEnum.class, chohyoShuturyokujun);
         }
         }*/
    }

    /**
     * 「抽出条件設定」ラジオボタン
     *
     */
    public void onChange_radChushutsuJyouken() {

        if (対象期間.equals(div.getChushutsuJyouken().getRadChushutsuJyouken().getSelectedKey())) {
            div.getTaishouSha().getTxtHihokenshaBangou().setDisabled(true);
            div.getTaishouKikan().getTxtKonkaiymdtime().setDisabled(false);
        } else if (対象者.equals(div.getChushutsuJyouken().getRadChushutsuJyouken().getSelectedKey())) {
            div.getTaishouSha().getTxtHihokenshaBangou().setDisabled(false);
            div.getTaishouKikan().getTxtKonkaiymdtime().setDisabled(true);
        }
    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @param shoriDateKanri ShoriDateKanri
     * @return
     */
}
