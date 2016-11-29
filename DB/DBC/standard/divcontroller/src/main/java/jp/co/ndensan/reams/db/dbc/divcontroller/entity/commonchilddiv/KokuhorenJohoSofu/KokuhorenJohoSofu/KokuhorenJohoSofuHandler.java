/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitatesho.KagomoshitateshoSofutaishoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 保険者情報送付データ作成_共有子DIVのハンドラクラスです。
 *
 * @reamsid_L DBC-3300-030 wangxingpeng
 */
public class KokuhorenJohoSofuHandler {

    private final KokuhorenJohoSofuDiv div;
    private final RString NUM_0 = new RString("0");
    private final RString NUM_1 = new RString("1");
    private final RString NUM_2 = new RString("2");

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
        List<KeyValueDataSource> dateSourceList = new ArrayList<>();
        KeyValueDataSource keyValueData1 = new KeyValueDataSource(NUM_0, RString.EMPTY);
        dateSourceList.add(keyValueData1);
        KeyValueDataSource keyValueData2 = new KeyValueDataSource(NUM_1, KagomoshitateshoSofutaishoKubun.toValue(NUM_1).get名称());
        dateSourceList.add(keyValueData2);
        KeyValueDataSource keyValueData3 = new KeyValueDataSource(NUM_2, KagomoshitateshoSofutaishoKubun.toValue(NUM_2).get名称());
        dateSourceList.add(keyValueData3);
        div.getDdlSofuTaishojoho().setDataSource(dateSourceList);
        if (!同月審査区分.equals(NUM_1)) {
            div.getDdlSofuTaishojoho().setSelectedKey(NUM_0);
            div.getDdlSofuTaishojoho().setDisplayNone(true);
        } else {
            div.getDdlSofuTaishojoho().setDisplayNone(false);
            div.getDdlSofuTaishojoho().setSelectedKey(NUM_2);
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
        div.getDdlSofuTaishojoho().setVisible(false);
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
        div.getDdlSofuTaishojoho().setVisible(false);
    }

    /**
     * get送付対象情報のkeyのメソッドます。
     *
     * @return RString
     */
    public RString get送付対象情報のkey() {
        return div.getDdlSofuTaishojoho().getSelectedKey();
    }

    /**
     * get送付対象情報のValueのメソッドます。
     *
     * @return RString
     */
    public RString get送付対象情報のValue() {
        return div.getDdlSofuTaishojoho().getSelectedValue();
    }

    /**
     * get処理年月のValueのメソッドます。
     *
     * @return RDate
     */
    public RDate get処理年月のValue() {
        return div.getTxtShoritaishoNengetsu().getValue();
    }

    /**
     * get再処理区分のValueのメソッドます。
     *
     * @return RString
     */
    public RString get再処理区分のValue() {
        return div.getTxtsaishoriKubun().getValue();
    }
}
