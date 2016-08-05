/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1171011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shomeishosakusei.JikofutanShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanShomeisho_Insho;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1171011.ShomeishoSakuseiParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1171011.ShomeishoSakuseiParameterHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbc.service.core.shoridatekanri.ShoriDateKanriFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自己負担額証明書作成（括）divcontrollerクラスです。
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
public class ShomeishoSakuseiParameter {

    private static final RString KEY_自己負担額計算括からの情報を元に作成RAD = new RString("jikoFutangaku");
    private static final RString KEY_国保連からの情報を元に作成RAD = new RString("kokuhoren");

    private ShomeishoSakuseiParameterHandler getHandler(ShomeishoSakuseiParameterDiv div) {
        return new ShomeishoSakuseiParameterHandler(div);
    }

    /**
     * 自己負担額証明書作成（括）画面 初期化を処理します。
     *
     * @param div ShomeishoSakuseiParameterDiv
     * @return 画面
     */
    public ResponseData<ShomeishoSakuseiParameterDiv> onLoad(ShomeishoSakuseiParameterDiv div) {
        ShoriDateKanriFinder finder = ShoriDateKanriFinder.createInstance();
        ShoriDateKanri 前回の実行情報 = finder.get前回の実行情報(new LasdecCode(
                DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        KokuhorenInterfaceKanriManager manager = new KokuhorenInterfaceKanriManager();
        KokuhorenInterfaceKanri 実行された最新のデータ = manager.get実行された最新のデータ(
                DbBusinessConfig.get(ConfigNameDBC.国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号,
                        RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        getHandler(div).onLoad(前回の実行情報, 実行された最新のデータ);
        return ResponseData.of(div).respond();
    }

    /**
     * 自己負担額計算（括）からの情報を元に作成RADと国保連からの情報を元に作成RADの選択を処理します。
     *
     * @param div ShomeishoSakuseiParameterDiv
     * @return 画面
     */
    public ResponseData<ShomeishoSakuseiParameterDiv> onChange(ShomeishoSakuseiParameterDiv div) {
        getHandler(div).onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチを起動します。
     *
     * @param div ShomeishoSakuseiParameterDiv
     * @return ResponseData<JikofutanShomeishoParameter>
     */
    public ResponseData<JikofutanShomeishoParameter> onClick_batch(ShomeishoSakuseiParameterDiv div) {
        JikofutanShomeishoParameter param = new JikofutanShomeishoParameter();
        param.set開始申請年月日(RString.isNullOrEmpty(div.getTxtShinseiDate().getFromValue().wareki().toDateString())
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtShinseiDate().getFromValue().toString()));
        param.set終了申請年月日(RString.isNullOrEmpty(div.getTxtShinseiDate().getToValue().wareki().toDateString())
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtShinseiDate().getToValue().toString()));
        param.set受取年月(RString.isNullOrEmpty(div.getTxtUketoriDate().getValue().wareki().toDateString())
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtUketoriDate().getValue().toString()));
        param.set印書(KaigoGassan_JikoFutanShomeisho_Insho.toValue(div.getDdlInsho().getSelectedKey()));
        param.set発行日(RString.isNullOrEmpty(div.getTxtHakkoDate().getValue().wareki().toDateString())
                ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtHakkoDate().getValue().toString()));
        param.set出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        param.set文書情報(div.getCcdBunshoBango().get文書番号());
        if ((!RString.isNullOrEmpty(div.getRadJikoFutangaku().getSelectedKey()))
                && KEY_自己負担額計算括からの情報を元に作成RAD.equals(div.getRadJikoFutangaku().getSelectedKey())) {
            param.set抽出対象(KaigoGassan_DataSakuseiKubun.自己負担額確認情報括);
        }
        if ((!RString.isNullOrEmpty(div.getRadJikoFutangaku().getSelectedKey()))
                && KEY_国保連からの情報を元に作成RAD.equals(div.getRadJikoFutangaku().getSelectedKey())) {
            param.set抽出対象(KaigoGassan_DataSakuseiKubun.国保連);
        }
        return ResponseData.of(param).respond();
    }
}
