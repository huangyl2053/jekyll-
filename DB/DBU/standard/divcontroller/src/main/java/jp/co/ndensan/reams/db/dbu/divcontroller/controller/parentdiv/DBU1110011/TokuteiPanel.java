/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU1110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.BangoseidoKinoShiyoSeigyo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.BangoseidoShiyoSeigyo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.message.DbuErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011.TokuteiPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011.grdTokuteiJoho_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU1110011.TokuteiPanelHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU1110011.TokuteiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 個人番号関連情報提供クラスです。
 *
 * @reamsid_L DBU-4880-010 linghuhang
 */
public class TokuteiPanel {

    private static final int 版番号カウント件数 = 0;
    private static final RString ボタン名 = new RString("btnJiko");
    private static final RString 現在 = new RString("現在");

    /**
     * 画面初期化を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<TokuteiPanelDiv>
     */
    public ResponseData<TokuteiPanelDiv> onLoad(TokuteiPanelDiv div) {
        // TODO 凌護行 個人番号のアクセス権限については現時点で
//        未確定の部分があるため、実装できません。 QA1704_#100662
        int 版番号カウント = TokuteiKojinJohoTeikyoManager.createInstance().get版番号カウント();
        getHandler(div).onLoad(版番号カウント);
        RDate 基準日 = RDate.getNowDate();
        RString 使用制御 = DbBusinessConfig.get(ConfigNameDBU.番号制度_使用制御, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 提供機能使用制御 = DbBusinessConfig.get(ConfigNameDBU.番号制度_提供機能使用制御, 基準日, SubGyomuCode.DBU介護統計報告);
        RString 利用開始日 = DbBusinessConfig.get(ConfigNameDBU.番号制度_利用開始日, 基準日, SubGyomuCode.DBU介護統計報告);
        RDate 利用日 = new RDate(利用開始日.toString());
        if (BangoseidoShiyoSeigyo.使用しない.getコード().equals(使用制御)) {
            return setメッセージ(現在);
        }
        if (BangoseidoKinoShiyoSeigyo.未稼働.getコード().equals(提供機能使用制御)) {
            return setメッセージ(現在);
        }
        if (BangoseidoKinoShiyoSeigyo.稼働.getコード().equals(提供機能使用制御)
                && 基準日.isBefore(利用日)) {
            return setメッセージ(現在);
        }
        set活性();
        if (版番号カウント != 版番号カウント件数) {
            List<grdTokuteiJoho_Row> list_row = new ArrayList<>();
            List<grdTokuteiJoho_Row> listRow = div.getGrdTokuteiJoho().getDataSource();
            for (grdTokuteiJoho_Row row : listRow) {
                set一覧の設定(row, 基準日);
                list_row.add(row);
            }
            div.getGrdTokuteiJoho().setDataSource(list_row);
        }
        setボタンの制御(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 画面情報
     * @return ResponseData<TokuteiPanelDiv>
     */
    public ResponseData<TokuteiPanelDiv> onClick_btnCheck(TokuteiPanelDiv div) {
        ValidationMessageControlPairs validateForUpdate = getValidationHandler(div).validateForUpdate();
        if (validateForUpdate.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validateForUpdate).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div 画面情報
     * @return ResponseData<DBU080010_TokuteiKojinJohoTeikyoParameter>
     */
    public ResponseData<DBU080010_TokuteiKojinJohoTeikyoParameter> onClick_btnExecute(TokuteiPanelDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnBatchParamSave()).respond();
    }

    private void set活性() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(ボタン名, false);
    }

    private void set一覧の設定(grdTokuteiJoho_Row row, RDate 基準日) {
        RString 特定個人情報名コード = row.getTokuteiKojinJohoNo();
        RString データセット番号 = DataSetNo._0101被保険者情報.getコード();
        List<TokuteiKojinJohoHanKanri> 版管理情報 = TokuteiKojinJohoTeikyoManager.
                createInstance().get版番号(RString.EMPTY, 特定個人情報名コード, データセット番号, FlexibleDate.EMPTY);
        RString 初回提供済区分 = RString.EMPTY;
        if (版管理情報 != null && !版管理情報.isEmpty()) {
            初回提供済区分 = 版管理情報.get(0).get初回提供区分();
        }
        if (ShokaiTeikyoKubun.未提供.getコード().equals(初回提供済区分)) {
            row.getChkSeiGyo().setDisabled(false);
            row.getChkSeiGyo().setValue(true);
        } else if (ShokaiTeikyoKubun.初回提供済み.getコード().equals(初回提供済区分)) {
            row.getChkSeiGyo().setDisabled(true);
            row.getChkSeiGyo().setValue(false);
        }
        RString 版番号 = RString.EMPTY;
        List<TokuteiKojinJohoHanKanri> 版管理 = TokuteiKojinJohoTeikyoManager.
                createInstance().get版番号(ShinkiIdoKubun.当初.getコード(), 特定個人情報名コード,
                        データセット番号, new FlexibleDate(基準日.toDateString()));
        if (版管理 != null && !版管理.isEmpty()) {
            版番号 = 版管理.get(0).get版番号();
        }
        row.setHanBangou(版番号);
    }

    private void setボタンの制御(TokuteiPanelDiv div) {
        boolean isボタンの制御 = false;
        List<grdTokuteiJoho_Row> listRow = div.getGrdTokuteiJoho().getDataSource();
        for (grdTokuteiJoho_Row row : listRow) {
            if (!row.getChkSeiGyo().isDisabled()) {
                isボタンの制御 = true;
                break;
            }
        }
        if (isボタンの制御) {
            set活性();
        } else {
            ErrorMessage message = new ErrorMessage(DbuErrorMessages.特定個人情報保存エラー.getMessage().getCode(),
                    DbuErrorMessages.特定個人情報保存エラー.getMessage().evaluate());
            throw new ApplicationException(message);
        }
    }

    private ResponseData<TokuteiPanelDiv> setメッセージ(RString 内容) {
        ErrorMessage message = new ErrorMessage(DbzErrorMessages.使用不可.getMessage().getCode(),
                DbzErrorMessages.使用不可.getMessage().replace(内容.toString()).evaluate());
        throw new ApplicationException(message);
    }

    private TokuteiPanelHandler getHandler(TokuteiPanelDiv div) {
        return new TokuteiPanelHandler(div);
    }

    private TokuteiPanelValidationHandler getValidationHandler(TokuteiPanelDiv div) {
        return new TokuteiPanelValidationHandler(div);
    }
}
