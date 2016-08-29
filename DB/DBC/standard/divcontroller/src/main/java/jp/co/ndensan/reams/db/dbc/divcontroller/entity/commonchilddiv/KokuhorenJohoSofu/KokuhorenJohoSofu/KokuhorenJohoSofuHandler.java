/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 保険者情報送付データ作成_共有子DIVのハンドラクラスです。
 *
 * @reamsid_L DBC-3300-030 wangxingpeng
 */
public class KokuhorenJohoSofuHandler {

    private final KokuhorenJohoSofuDiv div;
    private final RString NUM_1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div KokuhorenJohoSofuDiv
     */
    public KokuhorenJohoSofuHandler(KokuhorenJohoSofuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KokuhorenJohoSofuDiv
     */
    public static KokuhorenJohoSofuHandler of(KokuhorenJohoSofuDiv div) {
        return new KokuhorenJohoSofuHandler(div);
    }

    /**
     * Mode1画面初期化のメソッドます。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 外部ＣＳＶファイル名 RString
     */
    public void onLoadMode1(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名) {
        div.getTxtShoriSaikuruKubun().setVisible(false);
        div.getTxtShoritaishoNengetsu().setValue(new RDate(処理年月.toString()));
        if (再処理区分.equals(NUM_1)) {
            div.getTxtsaishoriKubun().setValue(SaiShoriKubun.toValue(再処理区分).get名称());
        }
        div.getTxtFileName().setValue(外部ＣＳＶファイル名);
        div.getDdlSofuTaishojoho().setVisible(false);
        div.getShoriJikkoMaekakuninJiko().setVisible(false);
    }

    /**
     * Mode2画面初期化のメソッドます。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 外部ＣＳＶファイル名 RString
     */
    public void onLoadMode2(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名) {
        div.getTxtShoriSaikuruKubun().setVisible(false);
        div.getTxtShoritaishoNengetsu().setValue(new RDate(処理年月.toString()));
        if (再処理区分.equals(NUM_1)) {
            div.getTxtsaishoriKubun().setValue(SaiShoriKubun.toValue(再処理区分).get名称());
        }
        div.getTxtFileName().setValue(外部ＣＳＶファイル名);
        RDate 基準日 = RDate.getNowDate();
        RString 同月審査区分 = DbBusinessConfig.get(ConfigNameDBC.過誤取下げ再請求指示_同月審査区分, 基準日, SubGyomuCode.DBC介護給付);
        if (!同月審査区分.equals(NUM_1)) {
            div.getDdlSofuTaishojoho().setVisible(false);
        }
        div.getShoriJikkoMaekakuninJiko().setVisible(false);
    }

    /**
     * Mode3画面初期化のメソッドます。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 外部ＣＳＶファイル名 RString
     * @param サイクル区分 RString
     */
    public void onLoadMode3(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名, RString サイクル区分) {
        div.getTxtShoriSaikuruKubun().setValue(サイクル区分);
        div.getTxtShoritaishoNengetsu().setValue(new RDate(処理年月.toString()));
        if (再処理区分.equals(NUM_1)) {
            div.getTxtsaishoriKubun().setValue(SaiShoriKubun.toValue(再処理区分).get名称());
        }
        div.getTxtFileName().setValue(外部ＣＳＶファイル名);
        RDate 基準日 = RDate.getNowDate();
        RString 同月審査区分 = DbBusinessConfig.get(ConfigNameDBC.過誤取下げ再請求指示_同月審査区分, 基準日, SubGyomuCode.DBC介護給付);
        if (同月審査区分 != NUM_1) {
            div.getDdlSofuTaishojoho().setVisible(false);
        }
        div.getShoriJikkoMaekakuninJiko().setVisible(false);
    }

    /**
     * Mode4画面初期化のメソッドます。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 外部ＣＳＶファイル名 RString
     * @param サイクル区分
     */
    public void onLoadMode4(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名, RString サイクル区分) {
        div.getTxtShoriSaikuruKubun().setValue(サイクル区分);
        div.getTxtShoritaishoNengetsu().setValue(new RDate(処理年月.toString()));
        if (再処理区分.equals(NUM_1)) {
            div.getTxtsaishoriKubun().setValue(SaiShoriKubun.toValue(再処理区分).get名称());
        }
        div.getTxtFileName().setValue(外部ＣＳＶファイル名);
        RDate 基準日 = RDate.getNowDate();
        RString 同月審査区分 = DbBusinessConfig.get(ConfigNameDBC.過誤取下げ再請求指示_同月審査区分, 基準日, SubGyomuCode.DBC介護給付);
        if (同月審査区分 != NUM_1) {
            div.getDdlSofuTaishojoho().setVisible(false);
        }
    }

    /**
     * get送付対象情報のメソッドます。
     *
     * @return RString
     */
    public RString get送付対象情報() {
        return div.getDdlSofuTaishojoho().getSelectedKey();
    }
}
