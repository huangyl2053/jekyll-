/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1171011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanShomeisho_Insho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1171011.ShomeishoSakuseiParameterDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 自己負担額証明書作成（括）Handlerクラスです。
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
public class ShomeishoSakuseiParameterHandler {

    private static final RString 平成20年7月1日 = new RString("20080701");

    private static final RString HIKISUU_文書番号共有子DIV = new RString("DBC100050_JikoFutangakushomeisho");
    private static final RString TYOUHYOUID_帳票出力順共有子DIV = new RString("DBC200035_GassanJikofutangakushomeishoHakkoIchiran");
    private static final RString KEY_自己負担額計算括からの情報を元に作成RAD = new RString("jikoFutangaku");
    private static final RString KEY_国保連からの情報を元に作成RAD = new RString("kokuhoren");
    private static final RString KEY_未発行分のみ = new RString("3");
    private final ShomeishoSakuseiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShomeishoSakuseiParameterDiv
     */
    public ShomeishoSakuseiParameterHandler(ShomeishoSakuseiParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面 初期化を処理します。
     *
     * @param 前回の実行情報 ShoriDateKanri
     * @param 実行された最新のデータ KokuhorenInterfaceKanri
     */
    public void onLoad(ShoriDateKanri 前回の実行情報, KokuhorenInterfaceKanri 実行された最新のデータ) {
        initialize();

        if (前回の実行情報 != null) {
            if (null != 前回の実行情報.get対象開始年月日() || (!FlexibleDate.EMPTY.equals(前回の実行情報.get対象開始年月日()))) {
                div.getJikoFutanShomeishoSakusei().getTxtZenkaiTaishoDate().setFromValue(
                        new RDate(前回の実行情報.get対象開始年月日().toString()));
            }
            if (null != 前回の実行情報.get対象終了年月日() || (!FlexibleDate.EMPTY.equals(前回の実行情報.get対象終了年月日()))) {
                div.getJikoFutanShomeishoSakusei().getTxtZenkaiTaishoDate().setToValue(
                        new RDate(前回の実行情報.get対象終了年月日().toString()));
                div.getJikoFutanShomeishoSakusei().getTxtShinseiDate().setFromValue(
                        new RDate(前回の実行情報.get対象終了年月日().plusDay(1).toString()));
            } else {
                div.getJikoFutanShomeishoSakusei().getTxtShinseiDate().setFromValue(new RDate(平成20年7月1日.toString()));
            }
        } else {
            div.getJikoFutanShomeishoSakusei().getTxtShinseiDate().setFromValue(new RDate(平成20年7月1日.toString()));
        }
        div.getJikoFutanShomeishoSakusei().getTxtShinseiDate().setToValue(RDate.getNowDate());

        if (実行された最新のデータ != null) {
            if (!FlexibleYearMonth.EMPTY.equals(実行された最新のデータ.get処理年月())) {
                div.getJikoFutanShomeishoSakusei().getTxtUketoriDate().setValue(new RDate(実行された最新のデータ.get処理年月().toString()));
            }
        }

        div.getJikoFutanShomeishoSakuseiPrint().getTxtHakkoDate().setValue(FlexibleDate.getNowDate());

        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        for (KaigoGassan_JikoFutanShomeisho_Insho insho : KaigoGassan_JikoFutanShomeisho_Insho.values()) {
            keyValueList.add(new KeyValueDataSource(insho.getコード(), insho.get名称()));
        }
        div.getDdlInsho().setDataSource(keyValueList);
        div.getDdlInsho().setSelectedKey(KEY_未発行分のみ);
        onLoad状態を設定する();
    }

    private void initialize() {
        div.getJikoFutanShomeishoSakuseiPrint().getCcdBunshoBango().initialize(new ReportId(HIKISUU_文書番号共有子DIV));
        div.getJikoFutanShomeishoSakuseiPrint().getCcdChohyoShutsuryokujun().load(
                SubGyomuCode.DBC介護給付, new ReportId(TYOUHYOUID_帳票出力順共有子DIV));
    }

    private void onLoad状態を設定する() {
        div.getRadJikoFutangaku().setSelectedKey(KEY_自己負担額計算括からの情報を元に作成RAD);
        div.getRadKokuhoren().clearSelectedItem();
        onChange();
    }

    /**
     * 自己負担額計算（括）からの情報を元に作成RADと国保連からの情報を元に作成RADの選択を処理します。
     */
    public void onChange() {
        if ((!RString.isNullOrEmpty(div.getRadJikoFutangaku().getSelectedKey()))
                && KEY_自己負担額計算括からの情報を元に作成RAD.equals(div.getRadJikoFutangaku().getSelectedKey())) {
            div.getTxtShinseiDate().setDisabled(false);
            div.getTxtUketoriDate().setDisabled(true);
        }
        if ((!RString.isNullOrEmpty(div.getRadKokuhoren().getSelectedKey()))
                && KEY_国保連からの情報を元に作成RAD.equals(div.getRadKokuhoren().getSelectedKey())) {
            div.getTxtShinseiDate().setDisabled(true);
            div.getTxtUketoriDate().setDisabled(false);
        }
    }
}
