/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8150001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC815001.DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakukaigotaishoumainpanel.KougakuKaigotaiShouMainPanelMapperParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001.DBC8150001StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001.KougakuKaigotaiShoushachuuShutsuMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8150001.KougakuKaigotaiShoushachuuShutsuMainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8150001.KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.dbc5100011mainpanel.DBC5100011MainPanelFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 画面設計_DBCMN41003_高額介護対象者抽出（遡及分）のクラスです。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
public class KougakuKaigotaiShoushachuuShutsuMainPanel {

    private static final RString 交換情報識別番号 = new RString("37J");
    private static final RString 処理状態区分 = new RString("3");
    private static final RString 終了 = new RString("3");
    private static final RString 処理枝番 = new RString("0000");
    private static final RString 年度 = new RString("0000");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 実行 = new RString("btnBatchRegister");

    /**
     * 初期化状態です。
     *
     * @param div div
     * @return ResponseData<KougakuKaigotaiShoushachuuShutsuMainPanelDiv>
     */
    public ResponseData<KougakuKaigotaiShoushachuuShutsuMainPanelDiv> onLoad(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200100.getReportId());
        set処理日付管理(div);
        set国保連管理(div);
        RString 年月範囲 = DbBusinessConfig.get(ConfigNameDBC.高額対象者抽出再計算_年月範囲, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        getHandler(div).set計算対象期間パネル(年月範囲);
        List<KokuhorenInterfaceKanri> 国保連インターフェース管理 = DBC5100011MainPanelFinder.createInstance()
                .get処理番号(交換情報識別番号, 処理状態区分).records();
        if (国保連インターフェース管理 == null || 国保連インターフェース管理.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidatisonHandler(div).国保連インターフェース管理テーブルチェック();
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, true);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 今回日時チェック。
     *
     * @param div div
     * @return ResponseData<KougakuKaigotaiShoushachuuShutsuMainPanelDiv>
     */
    public ResponseData<KougakuKaigotaiShoushachuuShutsuMainPanelDiv> btn_BeforeDialog(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        boolean validPairs = getValidatisonHandler(div).今回日時チェック();
        if (!ResponseHolder.isReRequest() && validPairs) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage()
                    .replace("終了日時に処理日時以降の日付が設定されていますが、実行して")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).setState(DBC8150001StateName.NoChange);
    }

    /**
     * 高額介護対象者抽出の実行です。
     *
     * @param div div
     * @return ResponseData<DBC815001_KogakuKaigoTaishoshaChushutsuSokyubun>
     */
    public ResponseData<DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter>
            onClick_btnBatchRegister(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
        IOutputOrder 出力順 = div.getCcdChohyoShutsuryokujun().getSelected出力順();
        manager.save前回出力順(出力順);
        return ResponseData.of(getHandler(div).onClick_実行ボタン()).respond();
    }

    private void set処理日付管理(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        RString サブ業務コード = SubGyomuCode.DBC介護給付.getColumnValue();
        LasdecCode temp_市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        RString 処理名 = ShoriName.高額介護対象者抽出_遡及分.get名称();
        List<ShoriDateKanri> shoriDateKanri = DBC5100011MainPanelFinder.createInstance().
                get処理日付管理(KougakuKaigotaiShouMainPanelMapperParameter.createSelectListParam(サブ業務コード,
                                temp_市町村コード.value(), 処理名, 年度, 年度内連番, 処理枝番, null, null)).records();
        if (shoriDateKanri == null || shoriDateKanri.isEmpty()) {
            getHandler(div).set処理日付管理();
            getHandler(div).set抽出期間_今回();
        } else {
            for (ShoriDateKanri shoriDateKanriEntity : shoriDateKanri) {
                getHandler(div).set処理日付管理(shoriDateKanriEntity);
                getHandler(div).set抽出期間_今回(shoriDateKanriEntity);
            }
        }
    }

    private void set国保連管理(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        RString 連絡票情報 = ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報.getコード();
        RString 識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_高額合算自己負担額確認情報_交換情報識別番号,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付, 連絡票情報);
        List<KokuhorenInterfaceKanri> kokuhorenInterfaceKanri = DBC5100011MainPanelFinder.createInstance().
                get国保連インターフェース管理(KougakuKaigotaiShouMainPanelMapperParameter.createSelectListParam(null,
                                null, null, null, null, null, 終了, 識別番号)).records();
        if (kokuhorenInterfaceKanri == null || kokuhorenInterfaceKanri.isEmpty()) {
            getHandler(div).set国保連インターフェース管理();
        } else {
            for (KokuhorenInterfaceKanri kokuhorenInterfaceKanriEntity : kokuhorenInterfaceKanri) {
                getHandler(div).set国保連インターフェース管理(kokuhorenInterfaceKanriEntity);
            }
        }
    }

    private KougakuKaigotaiShoushachuuShutsuMainPanelHandler getHandler(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        return new KougakuKaigotaiShoushachuuShutsuMainPanelHandler(div);
    }

    private KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler getValidatisonHandler(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        return new KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler(div);
    }
}
