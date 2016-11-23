/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KayiSyuuJiyuu;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KouFuJiyuu;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriTitleCreator;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA110010.DBA110010_HihokenshashoHakkoKanriboParameter;
import jp.co.ndensan.reams.db.dba.definition.core.flowparameter.DbaFlowParameterKeys;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.BatchPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.dgKaishuJiyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.dgKoufuJiyu_Row;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 *
 * 被保険者証発行管理簿ハンドラクラスです。
 *
 * @reamsid_L DBA-0600-010 zhangguopeng
 */
public class BatchPanelHandler {

    private final BatchPanelDiv div;
    private static final RString 発行管理リスト = new RString("1");
    private static final RString 未回収者リスト = new RString("2");
    private static final RString 被保険者証発行管理 = new RString("DBAMN72001");
    private static final RString 資格者証発行管理 = new RString("DBAMN72002");
    private static final RString 証発行モード_被保険者 = new RString("001");
    private static final RString 証発行モード_資格者 = new RString("002");
    private static final RString 項目名付加キー = new RString("key1");
    private static final RString 連番付加キー = new RString("key2");
    private static final RString 日付編集キー = new RString("key3");

    private static final RString COMMON_BUTTON_被保険者証発行管理 = new RString("btnJikko");
    private static final RString COMMON_BUTTON_被保険者証未回収者 = new RString("btnJikkoMikaishusha");
    private static final RString COMMON_BUTTON_資格者証発行管理 = new RString("btnJikko_Shikakusha");
    private static final RString COMMON_BUTTON_資格者証未回収者 = new RString("btnJikkoMikaishusha_Shikakusha");

    /**
     * コンストラクタです。
     *
     * @param div 被保険者証発行管理簿Div
     */
    public BatchPanelHandler(BatchPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param koufuJiyuList 交付事由リスト
     * @param kaishuJiyuList 回収事由リスト
     */
    public void initialize(List<KouFuJiyuu> koufuJiyuList, List<KayiSyuuJiyuu> kaishuJiyuList) {
        List<dgKaishuJiyu_Row> dgKaishuJiyuRowList = new ArrayList<>();
        List<dgKoufuJiyu_Row> dgKoufuJiyuRowList = new ArrayList<>();
        for (KouFuJiyuu kouFuJiyuu : koufuJiyuList) {
            dgKoufuJiyu_Row dgKoufuJiyuRow = new dgKoufuJiyu_Row();
            dgKoufuJiyuRow.setTxtKofuJiyuCode(new RString(kouFuJiyuu.getコード().toString()));
            dgKoufuJiyuRow.setTxtKofuJiyu(kouFuJiyuu.getコード名称());
            dgKoufuJiyuRowList.add(dgKoufuJiyuRow);

        }
        for (KayiSyuuJiyuu kayiSyuuJiyuu : kaishuJiyuList) {
            dgKaishuJiyu_Row dgKaishuJiyuRow = new dgKaishuJiyu_Row();
            dgKaishuJiyuRow.setTxtKaishuJiyuCode(new RString(kayiSyuuJiyuu.getコード().toString()));
            dgKaishuJiyuRow.setTxtKaishuJiyu(kayiSyuuJiyuu.getコード名称());
            dgKaishuJiyuRowList.add(dgKaishuJiyuRow);
        }
        div.getDgKaishuJiyu().setDataSource(dgKaishuJiyuRowList);
        div.getDgKoufuJiyu().setDataSource(dgKoufuJiyuRowList);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200004.getReportId());

        initialize出力対象RAD();
        display発行管理リスト発行ボタン();
    }

    /**
     * 発行対象の帳票（被保険者証～ or 資格者証～）に合わせて、親画面に設定するべきタイトルを返します。
     *
     * @return タイトルに設定する文字列
     */
    public RString get画面名() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        return HihokenshashoHakkoKanriTitleCreator.create画面タイトル(menuID);
    }

    /**
     * 発行対象の帳票（被保険者証～ or 資格者証～）に合わせて、画面上のラジオボタンに表示する文字列を設定します。
     */
    private void initialize出力対象RAD() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();

        List<KeyValueDataSource> list = new ArrayList<>();

        KeyValueDataSource item1 = new KeyValueDataSource(発行管理リスト,
                HihokenshashoHakkoKanriTitleCreator.create画面表示用文字列(menuID, 発行管理リスト));
        list.add(item1);
        KeyValueDataSource item2 = new KeyValueDataSource(未回収者リスト,
                HihokenshashoHakkoKanriTitleCreator.create画面表示用文字列(menuID, 未回収者リスト));
        list.add(item2);
        div.getRadShutsuTaisho().setDataSource(list);
        div.getRadShutsuTaisho().setSelectedKey(発行管理リスト);
    }

    /**
     * 選択した対象帳票（発行管理リスト or 未回収者リスト）に合わせて、画面の表示を変更します。
     */
    public void onChange_radShutsuTaisho() {
        if (未回収者リスト.equals(div.getRadShutsuTaisho().getSelectedKey())) {
            div.getTxtKoufubiRange().clearFromValue();
            div.getTxtKoufubiRange().clearToValue();
            div.getTxtKaishubiRange().clearFromValue();
            div.getTxtKaishubiRange().clearToValue();
            List<RString> selectedKey = new ArrayList<>();
            div.getChkSaishinJoho().setSelectedItemsByKey(selectedKey);
            div.getTxtKaishubiRange().setReadOnly(true);
            div.getChkSaishinJoho().setReadOnly(true);
            div.getDgKaishuJiyu().setDisabled(true);
            display未回収者リスト発行ボタン();
        } else {
            div.getTxtKoufubiRange().clearFromValue();
            div.getTxtKoufubiRange().clearToValue();
            div.getTxtKaishubiRange().clearFromValue();
            div.getTxtKaishubiRange().clearToValue();
            div.getTxtKaishubiRange().setReadOnly(false);
            div.getChkSaishinJoho().setReadOnly(false);
            div.getDgKaishuJiyu().setDisabled(false);
            display発行管理リスト発行ボタン();
        }
    }

    private void default発行ボタン() {
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_被保険者証発行管理, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_資格者証発行管理, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_被保険者証未回収者, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_資格者証未回収者, true);
    }

    private void display発行管理リスト発行ボタン() {
        default発行ボタン();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (被保険者証発行管理.equals(menuID)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_被保険者証発行管理, false);
        } else if (資格者証発行管理.equals(menuID)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_資格者証発行管理, false);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_被保険者証未回収者, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_資格者証未回収者, true);
    }

    private void display未回収者リスト発行ボタン() {
        default発行ボタン();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (被保険者証発行管理.equals(menuID)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_被保険者証未回収者, false);
        } else if (資格者証発行管理.equals(menuID)) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_資格者証未回収者, false);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_被保険者証発行管理, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_資格者証発行管理, true);
    }

    /**
     * バッチパラメータを作成します
     *
     * @param koufuJiyuList 交付事由リスト
     * @param kaishuJiyuList 回収事由リスト
     * @param menuID 処理メニューID
     * @return DBA110010_HihokenshashoHakkoKanriboParameter
     * 被保険者証発行管理簿_バッチ用のパラメータ
     */
    public DBA110010_HihokenshashoHakkoKanriboParameter batchParameter(List<dgKoufuJiyu_Row> koufuJiyuList,
            List<dgKaishuJiyu_Row> kaishuJiyuList, RString menuID) {
        DBA110010_HihokenshashoHakkoKanriboParameter parameter = new DBA110010_HihokenshashoHakkoKanriboParameter();
        if (被保険者証発行管理.equals(menuID)) {
            parameter.setAkasihakoumod(証発行モード_被保険者);
        } else if (資格者証発行管理.equals(menuID)) {
            parameter.setAkasihakoumod(証発行モード_資格者);
        }

        RString 出力対象;

        if (未回収者リスト.equals(div.getRadShutsuTaisho().getSelectedKey())) {
            出力対象 = 未回収者リスト;
            parameter.setSiyuturiyokudaysyou(未回収者リスト);
            parameter.setKoufukayisihi(new FlexibleDate(div.getTxtKoufubiRange().getFromValue().toDateString()));
            parameter.setKoufusiuryouhi(new FlexibleDate(div.getTxtKoufubiRange().getToValue().toDateString()));
            parameter.setKasyuukayisihi(FlexibleDate.EMPTY);
            parameter.setKasyuusiuryouhi(FlexibleDate.EMPTY);
            parameter.setSeyisinjyohoflg(false);
        } else {
            出力対象 = 発行管理リスト;
            parameter.setSiyuturiyokudaysyou(発行管理リスト);
            parameter.setKoufukayisihi(div.getTxtKoufubiRange().getFromValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtKoufubiRange().getFromValue().toDateString()));
            parameter.setKoufusiuryouhi(div.getTxtKoufubiRange().getToValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtKoufubiRange().getToValue().toDateString()));
            parameter.setKasyuukayisihi(div.getTxtKaishubiRange().getFromValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtKaishubiRange().getFromValue().toDateString()));
            parameter.setKasyuusiuryouhi(div.getTxtKaishubiRange().getToValue() == null
                    ? FlexibleDate.EMPTY : new FlexibleDate(div.getTxtKaishubiRange().getToValue().toDateString()));
            if (div.getChkSaishinJoho().getSelectedItems().size() > 0) {
                parameter.setSeyisinjyohoflg(true);
            } else {
                parameter.setSeyisinjyohoflg(false);
            }
        }
        List<RString> henshuHoho = div.getChkHenshuHoho().getSelectedKeys();
        if (henshuHoho.contains(項目名付加キー)) {
            parameter.setKoumukumeyifukaflg(true);
        } else {
            parameter.setKoumukumeyifukaflg(false);
        }
        if (henshuHoho.contains(連番付加キー)) {
            parameter.setRenbanfukaflg(true);
        } else {
            parameter.setRenbanfukaflg(false);
        }
        if (henshuHoho.contains(日付編集キー)) {
            parameter.setHizikehensyuuflg(true);
        } else {
            parameter.setHizikehensyuuflg(false);
        }
        List<RString> 交付事由コード = new ArrayList<>();
        for (dgKoufuJiyu_Row koufuJiyu : koufuJiyuList) {
            交付事由コード.add(koufuJiyu.getTxtKofuJiyuCode());
        }
        parameter.setKayuujiyuulist(交付事由コード);
        List<RString> 回収事由コード = new ArrayList<>();
        for (dgKaishuJiyu_Row kaishuJiyu : kaishuJiyuList) {
            回収事由コード.add(kaishuJiyu.getTxtKaishuJiyuCode());
        }
        parameter.setKasyuujiyuulist(回収事由コード);
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() != null) {
            parameter.setSyuturyokujunid(div.getCcdChohyoShutsuryokujun().get出力順ID());
        }

        setFlowParameter(出力対象);

        return parameter;
    }

    private void setFlowParameter(RString 出力対象) {
        FlowParameters fp = FlowParameters.of(
                DbaFlowParameterKeys.被保険者_資格者証発行管理リスト_対象切替.getフローパラメータ名(), 出力対象);
        FlowParameterAccessor.merge(fp);
    }
}
