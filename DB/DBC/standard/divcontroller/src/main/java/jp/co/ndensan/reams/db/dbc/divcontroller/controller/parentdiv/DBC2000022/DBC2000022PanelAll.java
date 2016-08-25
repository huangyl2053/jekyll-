/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000022;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.FutanWariaiSokujiKouseiHolder;
import jp.co.ndensan.reams.db.dbc.business.core.futanwariai.FutanWariaiSokujiKouseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariai.FutanWariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.DBC2000022PanelAllDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.DBC2000022StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.DBC2000022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.dgFutanWariai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000022.RiyoshaFutanWariaiSokujiKouseiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000022.RiyoshaFutanWariaiSokujiKouseiPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc2000022.FutanWariaiSokujiKouseiServiceData;
import jp.co.ndensan.reams.db.dbc.service.core.futanwariai.RiyoshaFutanWariaiSokujiKouseiFinder;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiKonkyoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担割合即時更正_修正です。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class DBC2000022PanelAll {

    private static final RString RSTONE = new RString("1");
    private static final RString RSTTWO = new RString("2");
    private static final RString DBCUC20021 = new RString("DBCUC20021");
    private static final RString DBCUC20022 = new RString("DBCUC20022");
    private static final RString DBCUC20023 = new RString("DBCUC20023");
    private static final RString 前排他キー = new RString("DBCHihokenshaNo");
    private static final RString 計算結果は破棄されます = new RString("計算結果は破棄されます。");

    /**
     * Handlerクラスを取得する
     *
     * @param div DBC2000022PanelAllDiv
     * @return RiyoshaFutanWariaiSokujiKouseiPanelHandler
     */
    private RiyoshaFutanWariaiSokujiKouseiPanelHandler getHandler(DBC2000022PanelAllDiv div) {
        return new RiyoshaFutanWariaiSokujiKouseiPanelHandler(div);
    }

    /**
     * 画面の初期化です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onLoad(DBC2000022PanelAllDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        div.setHdnGyomuCode(GyomuCode.DB介護保険.getColumnValue());
        div.setHdnShikibetsuCode(資格対象者.get識別コード().getColumnValue());
        RString 処理モード = get処理モード();
        if (DBC2000022StateName.新規.getName().equals(処理モード)) {
            RiyoshaFutanWariaiHanteiManagerResult 判定結果
                    = ViewStateHolder.get(ViewStateKeys.判定結果, RiyoshaFutanWariaiHanteiManagerResult.class);
            ViewStateHolder.put(ViewStateKeys.利用者負担割合, new RiyoshaFutanWariai(判定結果.get利用者負担割合entity()));
            List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細list = new ArrayList<>();
            for (int i = 0; i < 判定結果.get利用者負担割合明細list().size(); i++) {
                RiyoshaFutanWariaiMeisai meisai = new RiyoshaFutanWariaiMeisai(判定結果.get利用者負担割合明細list().get(i));
                RString 資格区分 = 判定結果.get利用者負担割合明細list().get(i).getShikakuKubun();
                if (資格区分 != null) {
                    RiyoshaFutanWariaiMeisaiBuilder meisaiBuilder = meisai.createBuilderForEdit();
                    meisaiBuilder.set資格区分(資格区分.padZeroToLeft(2));
                    meisai = meisaiBuilder.build();
                }
                利用者負担割合明細list.add(meisai);
            }
            ViewStateHolder.put(ViewStateKeys.利用者負担割合明細,
                    new FutanWariaiSokujiKouseiHolder(利用者負担割合明細list));
            getHandler(div).shinkiInitialize(判定結果, 資格対象者);
            if (判定結果.is生活保護受給者判定()) {
                return ResponseData.of(div).addMessage(DbcInformationMessages.生活保護受給者.getMessage()).respond();
            }
            if (RSTTWO.equals(判定結果.get判定区分())) {
                return ResponseData.of(div).addMessage(DbcInformationMessages.負担割合証発行不要.getMessage()).respond();
            }
            return ResponseData.of(div).setState(DBC2000022StateName.新規);
        }
        if (DBC2000022StateName.修正.getName().equals(処理モード)) {
            FutanWariaiSokujiKouseiResult 利用者負担割合情報 = getHandler(div).shuseiInitialize(資格対象者);
            ViewStateHolder.put(ViewStateKeys.利用者負担割合, new RiyoshaFutanWariai(利用者負担割合情報.toEntity()));
            ViewStateHolder.put(ViewStateKeys.利用者負担割合明細,
                    new FutanWariaiSokujiKouseiHolder(利用者負担割合情報.get利用者負担割合明細list()));
            return ResponseData.of(div).setState(DBC2000022StateName.修正);
        }
        if (DBC2000022StateName.照会.getName().equals(処理モード)) {
            FutanWariaiSokujiKouseiResult 利用者負担割合情報 = getHandler(div).shokaiInitialize(資格対象者);
            ViewStateHolder.put(ViewStateKeys.利用者負担割合, new RiyoshaFutanWariai(利用者負担割合情報.toEntity()));
            ViewStateHolder.put(ViewStateKeys.利用者負担割合明細,
                    new FutanWariaiSokujiKouseiHolder(利用者負担割合情報.get利用者負担割合明細list()));
            return ResponseData.of(div).setState(DBC2000022StateName.照会);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * クリア処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnClear(DBC2000022PanelAllDiv div) {
        if (0 == div.getDgFutanWariai().getDataSource().size()) {
            return ResponseData.of(div).respond();
        }
        RString 処理モード = get処理モード();
        if (DBC2000022StateName.修正.getName().equals(処理モード) && データ項目変更判定(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbcQuestionMessages.編集クリア確認.getMessage().getCode(),
                        DbcQuestionMessages.編集クリア確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                getHandler(div).clear(処理モード);
            }
        } else {
            getHandler(div).clear(処理モード);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 年度のonChange処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onChange_nendo(DBC2000022PanelAllDiv div) {
        RString 処理モード = get処理モード();
        if (DBC2000022StateName.照会.getName().equals(処理モード)) {
            getHandler(div).nendoChange();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「表示する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnHyoji(DBC2000022PanelAllDiv div) {
        FutanWariaiSokujiKouseiResult 利用者負担割合情報
                = getHandler(div).onClick_Hyoji(get処理モード());
        ViewStateHolder.put(ViewStateKeys.利用者負担割合, new RiyoshaFutanWariai(利用者負担割合情報.toEntity()));
        ViewStateHolder.put(ViewStateKeys.利用者負担割合明細,
                new FutanWariaiSokujiKouseiHolder(利用者負担割合情報.get利用者負担割合明細list()));
        return ResponseData.of(div).respond();
    }

    /**
     * 【データグリッド】削除ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_dgDelete(DBC2000022PanelAllDiv div) {
        dgFutanWariai_Row deleteRow = div.getDgFutanWariai().getClickedItem();
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);
        RiyoshaFutanWariaiMeisai 明細 = holder.getRiyoshaFutanWariaiMeisai(
                new RiyoshaFutanWariaiMeisaiIdentifier(new FlexibleYear(deleteRow.getNendo()),
                        new HihokenshaNo(div.getCcdKaigoShikakuKihon().get被保険者番号()),
                        Integer.parseInt(deleteRow.getRirekiNo().toString()),
                        Integer.parseInt(deleteRow.getEdaNo().toString())));
        RiyoshaFutanWariaiMeisaiBuilder builder = 明細.createBuilderForEdit();
        if (deleteRow.getLogicalDeletedFlag()) {
            deleteRow.setLogicalDeletedFlag(false);
            builder.set論理削除フラグ(false);
            deleteRow.setRowBgColor(DataGridCellBgColor.bgColorNormal);
        } else {
            deleteRow.setLogicalDeletedFlag(true);
            builder.set論理削除フラグ(true);
            deleteRow.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
        }
        明細 = builder.build();
        holder.addRiyoshaFutanWariaiMeisai(明細);
        ViewStateHolder.put(ViewStateKeys.利用者負担割合明細, holder);
        deleteRow.setRowState(RowState.Modified);
        return ResponseData.of(div).respond();
    }

    /**
     * 「上に追加する」ボタンの処理です。
     *
     * @param div DBC2000022PanelAllDiv
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnAddBefore(DBC2000022PanelAllDiv div) {
        if (行選択チェック(div)) {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
        RiyoshaFutanWariai 利用者負担割合 = ViewStateHolder.get(ViewStateKeys.利用者負担割合, RiyoshaFutanWariai.class);
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);

        int 枝番 = getMax枝番(holder.get利用者負担割合明細()) + 1;
        getHandler(div).onClick_上に追加する(利用者負担割合, 枝番);
        return ResponseData.of(div).respond();
    }

    /**
     * 「下に追加する」ボタンの処理です。
     *
     * @param div DBC2000022PanelAllDiv
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnAddNext(DBC2000022PanelAllDiv div) {
        if (行選択チェック(div)) {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
        RiyoshaFutanWariai 利用者負担割合 = ViewStateHolder.get(ViewStateKeys.利用者負担割合, RiyoshaFutanWariai.class);
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);

        int 枝番 = getMax枝番(holder.get利用者負担割合明細()) + 1;
        getHandler(div).onClick_下に追加する(利用者負担割合, 枝番);
        return ResponseData.of(div).respond();
    }

    /**
     * 「「修正する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnEdit(DBC2000022PanelAllDiv div) {
        getHandler(div).onClick_btnEdit();
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnCancel(DBC2000022PanelAllDiv div) {
        getHandler(div).onClick_btnCancel();
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnKakutei(DBC2000022PanelAllDiv div) {
        dgFutanWariai_Row rowData = div.getDgFutanWariai().getClickedItem();
        ValidationMessageControlPairs validPairs = getCheckHandler(div).入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RiyoshaFutanWariai 利用者負担割合 = ViewStateHolder.get(ViewStateKeys.利用者負担割合, RiyoshaFutanWariai.class);
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);
        getHandler(div).onClick_btnKakutei();
        ValidationMessageControlPairs validPairs2 = getCheckHandler(div).開始終了チェック();
        if (validPairs2.iterator().hasNext()) {
            reset(rowData, div);
            return ResponseData.of(div).addValidationMessages(validPairs2).respond();
        }
        getHandler(div).kakuteiShori(利用者負担割合, holder);
        ViewStateHolder.put(ViewStateKeys.利用者負担割合明細, holder);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnUpdate(DBC2000022PanelAllDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (!MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }

        RiyoshaFutanWariai 利用者負担割合 = ViewStateHolder.get(ViewStateKeys.利用者負担割合, RiyoshaFutanWariai.class);
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);
        RString 処理モード = get処理モード();
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FutanWariaiSokujiKouseiServiceData 引き継ぎデータ = new FutanWariaiSokujiKouseiServiceData();
        if (DBC2000022StateName.新規.getName().equals(処理モード)) {
            RiyoshaFutanWariaiHanteiManagerResult 判定結果
                    = ViewStateHolder.get(ViewStateKeys.判定結果, RiyoshaFutanWariaiHanteiManagerResult.class);
            利用者負担割合 = getHandler(div).update利用者負担割合情報(利用者負担割合, 処理モード);
            List<RiyoshaFutanWariaiKonkyo> 利用者負担割合根拠list = new ArrayList<>();
            for (int i = 0; i < 判定結果.get利用者負担割合根拠list().size(); i++) {
                判定結果.get利用者負担割合根拠list().get(i).setState(EntityDataState.Added);
                RiyoshaFutanWariaiKonkyo 利用者負担割合根拠
                        = new RiyoshaFutanWariaiKonkyo(判定結果.get利用者負担割合根拠list().get(i));
                RiyoshaFutanWariaiKonkyoBuilder 利用者負担割合根拠builder = 利用者負担割合根拠.createBuilderForEdit();
                利用者負担割合根拠builder.set履歴番号(利用者負担割合.get履歴番号());
                利用者負担割合根拠builder.set枝番号(i + 1);
                利用者負担割合根拠 = 利用者負担割合根拠builder.build();
                利用者負担割合根拠list.add(利用者負担割合根拠);
            }

            List<RiyoshaFutanWariaiMeisai> 明細list = new ArrayList<>();
            int 枝番 = 1;
            for (RiyoshaFutanWariaiMeisai 明細 : holder.get利用者負担割合明細()) {
                RiyoshaFutanWariaiMeisaiBuilder builder = 明細.createBuilderForEdit();
                builder.set履歴番号(利用者負担割合.get履歴番号());
                builder.set枝番号(枝番);
                明細 = builder.build();
                明細.added();
                明細list.add(明細);
                枝番 = 枝番 + 1;
            }
            getHandler(div).onClick_btnUpdate(資格対象者.get識別コード(),
                    利用者負担割合,
                    明細list,
                    利用者負担割合根拠list);
        } else {
            利用者負担割合 = getHandler(div).update利用者負担割合情報(利用者負担割合, 処理モード);
            ViewStateHolder.put(ViewStateKeys.利用者負担割合, 利用者負担割合);
            ValidationMessageControlPairs validPairs1 = getCheckHandler(div).枝番間期間チェック();
            if (validPairs1.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs1).respond();
            }
            ValidationMessageControlPairs validPairs2 = getCheckHandler(div).開始終了チェック();
            if (validPairs2.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs2).respond();
            }
            if (データ項目変更判定(div)) {
                getHandler(div).onClick_btnUpdate(資格対象者.get識別コード(),
                        利用者負担割合,
                        holder.get利用者負担割合明細(),
                        null);
            } else {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            }
        }
        FutanWariaiSokujiKouseiResult result = 利用者負担割合情報再検索(div.getDdlNendo().getSelectedKey(),
                div.getCcdKaigoShikakuKihon().get被保険者番号());
        引き継ぎデータ.set利用者負担割合(new RiyoshaFutanWariai(result.toEntity()));
        引き継ぎデータ.set利用者負担割合明細list(result.get利用者負担割合明細list());
        引き継ぎデータ.set漢字氏名(div.getCcdKaigoAtenaInfo().get氏名漢字());
        引き継ぎデータ.set登録結果(true);
        ViewStateHolder.put(ViewStateKeys.引き継ぎデータ, 引き継ぎデータ);
        return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.保存).respond();
    }

    /**
     * 「負担割合証を印刷する」ボタンの処理前のチェック処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnPrintCheck(DBC2000022PanelAllDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).発行日と交付日必須入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    DbcQuestionMessages.負担割合証単票発行確認.getMessage().getCode(),
                    DbcQuestionMessages.負担割合証単票発行確認.getMessage().evaluate(),
                    ButtonSelectPattern.OKCancel);
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「負担割合証を印刷する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnPrint(DBC2000022PanelAllDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);
        SourceDataCollection collection = getHandler(div).onClick_btnPrint(資格対象者, holder.get利用者負担割合明細());
        RiyoshaFutanWariai 利用者負担割合 = ViewStateHolder.get(ViewStateKeys.利用者負担割合, RiyoshaFutanWariai.class);
        getHandler(div).利用者負担割合編集(利用者負担割合);
        ViewStateHolder.put(ViewStateKeys.利用者負担割合, 利用者負担割合);
        getHandler(div).onClick_btnUpdate(資格対象者.get識別コード(),
                利用者負担割合, null, null);
        getHandler(div).insert証交付回収(利用者負担割合);
        return ResponseData.of(collection).respond();
    }

    /**
     * 「再検索」ボタン処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnReSearch(DBC2000022PanelAllDiv div) {
        RString 処理モード = get処理モード();
        if (DBC2000022StateName.新規.getName().equals(処理モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(計算結果は破棄されます.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.再検索).respond();
            }
        }
        if (DBC2000022StateName.修正.getName().equals(処理モード)) {
            if (!データ項目変更判定(div)) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.再検索).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.再検索).respond();
            }
        }
        if (DBC2000022StateName.照会.getName().equals(処理モード)) {
            前排他キーの解除();
            return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.再検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnSearchResult(DBC2000022PanelAllDiv div) {
        RString 処理モード = get処理モード();
        if (DBC2000022StateName.新規.getName().equals(処理モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(計算結果は破棄されます.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.検索結果一覧).respond();
            }
        }
        if (DBC2000022StateName.修正.getName().equals(処理モード)) {
            if (!データ項目変更判定(div)) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.検索結果一覧).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.検索結果一覧).respond();
            }
        }
        if (DBC2000022StateName.照会.getName().equals(処理モード)) {
            前排他キーの解除();
            return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.検索結果一覧).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「新規判定画面に戻る」ボタン処理です。
     *
     * @param div div
     * @return ResponseData<DBC2000022PanelAllDiv>
     */
    public ResponseData<DBC2000022PanelAllDiv> onClick_btnBack(DBC2000022PanelAllDiv div) {
        RString 処理モード = get処理モード();
        if (DBC2000022StateName.新規.getName().equals(処理モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage().replace(計算結果は破棄されます.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.戻る).respond();
            }
        }
        if (DBC2000022StateName.修正.getName().equals(処理モード)) {
            if (!データ項目変更判定(div)) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.戻る).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBC2000022TransitionEventName.戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private int getMax枝番(List<RiyoshaFutanWariaiMeisai> list) {
        int 枝番 = 0;
        if (list != null && !list.isEmpty()) {
            for (RiyoshaFutanWariaiMeisai 明細 : list) {
                if (明細.get枝番号() > 枝番) {
                    枝番 = 明細.get枝番号();
                }
            }
        }
        return 枝番;
    }

    private FutanWariaiSokujiKouseiResult 利用者負担割合情報再検索(RString 年度, RString 被保険者番号) {
        FutanWariaiMybatisParameter mybatisParameter = new FutanWariaiMybatisParameter();
        mybatisParameter.set年度(年度);
        mybatisParameter.set被保険者番号(被保険者番号);
        mybatisParameter.setFlag(RSTONE);
        RiyoshaFutanWariaiSokujiKouseiFinder finder = RiyoshaFutanWariaiSokujiKouseiFinder.createInstance();
        return finder.get利用者負担割合情報(mybatisParameter);
    }

    private boolean データ項目変更判定(DBC2000022PanelAllDiv div) {
        RiyoshaFutanWariai 利用者負担割合 = ViewStateHolder.get(ViewStateKeys.利用者負担割合, RiyoshaFutanWariai.class);
        FutanWariaiSokujiKouseiHolder holder
                = ViewStateHolder.get(ViewStateKeys.利用者負担割合明細, FutanWariaiSokujiKouseiHolder.class);
        if (利用者負担割合 != null && 利用者負担割合.hasChanged()) {
            return true;
        }
        if (holder != null && holder.get利用者負担割合明細().size() != div.getDgFutanWariai().getTotalRecords()) {
            return true;
        }
        if (holder != null && holder.get利用者負担割合明細() != null) {
            for (RiyoshaFutanWariaiMeisai result : holder.get利用者負担割合明細()) {
                if (result.hasChanged()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset(dgFutanWariai_Row rowData, DBC2000022PanelAllDiv div) {
        div.getDgFutanWariai().getClickedItem().setShikakuCode(rowData.getShikakuCode());
        div.getDgFutanWariai().getClickedItem().setFutanWariaiCode(rowData.getFutanWariaiCode());
        div.getDgFutanWariai().getClickedItem().setShikaku(rowData.getShikaku());
        div.getDgFutanWariai().getClickedItem().setFutanWariai(rowData.getFutanWariai());
        div.getDgFutanWariai().getClickedItem().getTekiyoKaishibi().setValue(rowData.getTekiyoKaishibi().getValue());
        div.getDgFutanWariai().getClickedItem().getTekiyoShuryobi().setValue(rowData.getTekiyoShuryobi().getValue());
        div.getDgFutanWariai().getClickedItem().getGokeiShotoku().setValue(rowData.getGokeiShotoku().getValue());
        div.getDgFutanWariai().getClickedItem().getSetaiinsu().setValue(rowData.getSetaiinsu().getValue());
        div.getDgFutanWariai().getClickedItem().getNenkinShunyuGokei().setValue(rowData.getNenkinShunyuGokei().getValue());
        div.getDgFutanWariai().getClickedItem().getSonotaGokeiShotoku().setValue(rowData.getSonotaGokeiShotoku().getValue());
        div.getDgFutanWariai().getClickedItem().setBiko(rowData.getBiko());
        if (!RowState.Added.equals(rowData.getRowState())) {
            div.getDgFutanWariai().getClickedItem().setRowState(RowState.Modified);
        }
    }

    private RiyoshaFutanWariaiSokujiKouseiPanelValidationHandler getCheckHandler(DBC2000022PanelAllDiv div) {
        return new RiyoshaFutanWariaiSokujiKouseiPanelValidationHandler(div);
    }

    private boolean 行選択チェック(DBC2000022PanelAllDiv div) {
        dgFutanWariai_Row rowData = div.getDgFutanWariai().getClickedItem();
        return rowData == null;
    }

    private RString get処理モード() {
        RString containerId = ResponseHolder.getUIContainerId();
        if (DBCUC20021.equals(containerId)) {
            return DBC2000022StateName.新規.getName();
        }
        if (DBCUC20022.equals(containerId)) {
            return DBC2000022StateName.修正.getName();
        }
        if (DBCUC20023.equals(containerId)) {
            return DBC2000022StateName.照会.getName();
        }
        return RString.EMPTY;
    }

    private void 前排他キーの解除() {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        LockingKey 排他キー = new LockingKey(前排他キー.concat(資格対象者.get被保険者番号().getColumnValue()));
        RealInitialLocker.release(排他キー);
    }
}
