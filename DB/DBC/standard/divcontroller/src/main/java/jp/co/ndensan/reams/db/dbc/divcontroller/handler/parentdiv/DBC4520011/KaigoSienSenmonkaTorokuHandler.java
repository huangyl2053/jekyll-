/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.DBC4520011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.dgKaigoShienSenmoninIchiran_Row;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManeger;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManegerHolder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManegerIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.basic.CareManegerManager;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護支援専門員登録画面 Handlerクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmonkaTorokuHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString RADIOBUTTON_SELECTKEY = new RString("key0");
    private final KaigoSienSenmonkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     */
    public KaigoSienSenmonkaTorokuHandler(KaigoSienSenmonkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 初期化を処理します。
     */
    public void onLoad() {
        検索条件パネルに項目制御を設定する();
    }

    private void 検索条件パネルに項目制御を設定する() {
        boolean is介護支援専門員番号_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadKaigoSienSenmoninBangoKensaku().getSelectedKey());
        div.getKensakuJoken().getTxtKaigoShienSenmoninBango().setDisabled(!is介護支援専門員番号_SELECT);

        boolean is所属事業者番号_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadShozokuJigyoshaBangoKensaku().getSelectedKey());
        div.getKensakuJoken().getTxtShozokuJigyoshaBango().setDisabled(!is所属事業者番号_SELECT);

        boolean is介護支援専門員氏名検索_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadKaigoShienSenmoninShimeiKensaku().getSelectedKey());
        div.getKensakuJoken().getTxtKanjiShimei().setDisabled(!is介護支援専門員氏名検索_SELECT);
        div.getKensakuJoken().getChkKanjiShimeiZenpoItchi().setDisabled(!is介護支援専門員氏名検索_SELECT);
        div.getKensakuJoken().getTxtkanaShimei().setDisabled(!is介護支援専門員氏名検索_SELECT);
        div.getKensakuJoken().getChkKanaShimeiZenpoItchi().setDisabled(!is介護支援専門員氏名検索_SELECT);

        boolean is有効期間検索_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadYukoKikanKensaku().getSelectedKey());
        div.getKensakuJoken().getTxtYukoKikanKensaku().setDisabled(!is有効期間検索_SELECT);
    }

    /**
     * 介護支援専門員登録画面 RAD選択を処理します。
     */
    public void onClick_radChange() {
        検索条件パネルに項目制御を設定する();
    }

    /**
     * 介護支援専門員登録画面 「条件をクリアする」ボタンを処理します。
     */
    public void onClick_btnClear() {
        検索条件パネルに項目をクリアする();
        検索条件パネルに項目制御を設定する();
    }

    private void 検索条件パネルに項目をクリアする() {
        div.getKensakuJoken().getRadKaigoSienSenmoninBangoKensaku().clearSelectedItem();
        div.getKensakuJoken().getRadShozokuJigyoshaBangoKensaku().clearSelectedItem();
        div.getKensakuJoken().getRadKaigoShienSenmoninShimeiKensaku().clearSelectedItem();
        div.getKensakuJoken().getRadYukoKikanKensaku().clearSelectedItem();

        div.getKensakuJoken().getTxtKaigoShienSenmoninBango().clearValue();
        div.getKensakuJoken().getTxtShozokuJigyoshaBango().clearValue();
        div.getKensakuJoken().getTxtKanjiShimei().clearValue();
        div.getKensakuJoken().getTxtkanaShimei().clearValue();
        div.getKensakuJoken().getChkKanjiShimeiZenpoItchi().setSelectedItemsByKey(new ArrayList<RString>());
        div.getKensakuJoken().getChkKanaShimeiZenpoItchi().setSelectedItemsByKey(new ArrayList<RString>());
        div.getKensakuJoken().getTxtYukoKikanKensaku().clearFromValue();
        div.getKensakuJoken().getTxtYukoKikanKensaku().clearToValue();
        div.getKensakuJoken().getTxtSaidaiHyojiKensu().clearValue();
    }

    /**
     * 「検索する」ボタンを処理します。
     *
     * @param resultList KaigoShienSenmoninJouhouResultのリスト
     */
    public void onClick_btnSearch(List<KaigoShienSenmoninJouhouResult> resultList) {
        複数件該当する場合は介護支援専門員一覧を表示する(resultList);
    }

    /**
     * KaigoShienSenmoninJouhouParameterを返します。
     *
     * @return KaigoShienSenmoninJouhouParameter
     */
    public KaigoShienSenmoninJouhouParameter getParameter() {
        KaigoShienSenmoninJouhouParameter param = new KaigoShienSenmoninJouhouParameter();
        if (RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadKaigoSienSenmoninBangoKensaku().getSelectedKey())
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtKaigoShienSenmoninBango().getValue()))) {
            param.set介護支援専門員番号(div.getKensakuJoken().getTxtKaigoShienSenmoninBango().getValue());
        }

        if (RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadShozokuJigyoshaBangoKensaku().getSelectedKey())
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtShozokuJigyoshaBango().getValue()))) {
            param.set所属事業者番号(div.getKensakuJoken().getTxtShozokuJigyoshaBango().getValue());
        }

        boolean is介護支援専門員氏名検索_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadKaigoShienSenmoninShimeiKensaku().getSelectedKey());
        if (is介護支援専門員氏名検索_SELECT
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtKanjiShimei().getValue()))) {
            param.set漢字氏名(div.getKensakuJoken().getTxtKanjiShimei().getValue());
        }
        param.set漢字氏名の前方一致(is介護支援専門員氏名検索_SELECT
                && RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getChkKanjiShimeiZenpoItchi().getSelectedKeys().isEmpty()
                        ? RString.EMPTY : div.getKensakuJoken().getChkKanjiShimeiZenpoItchi().getSelectedKeys().get(0)));
        if (is介護支援専門員氏名検索_SELECT
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtkanaShimei().getValue()))) {
            param.setカナ氏名(div.getKensakuJoken().getTxtkanaShimei().getValue());
        }
        param.setカナ氏名の前方一致(is介護支援専門員氏名検索_SELECT
                && RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getChkKanaShimeiZenpoItchi().getSelectedKeys().isEmpty()
                        ? RString.EMPTY : div.getKensakuJoken().getChkKanaShimeiZenpoItchi().getSelectedKeys().get(0)));

        boolean is有効期間検索_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadYukoKikanKensaku().getSelectedKey());
        if (is有効期間検索_SELECT) {
            if (null != div.getKensakuJoken().getTxtYukoKikanKensaku().getFromValue()) {
                param.set有効開始年月日(div.getKensakuJoken().getTxtYukoKikanKensaku().getFromValue().toDateString());
            }
            if (null != div.getKensakuJoken().getTxtYukoKikanKensaku().getToValue()) {
                param.set有効終了年月日(div.getKensakuJoken().getTxtYukoKikanKensaku().getToValue().toDateString());
            }
        }

        param.set最大表示件数(RString.isNullOrEmpty(div.getKensakuJoken().getTxtSaidaiHyojiKensu().getText()) ? 0
                : Integer.parseInt(div.getKensakuJoken().getTxtSaidaiHyojiKensu().getValue().toString()));
        return param;
    }

    private void 複数件該当する場合は介護支援専門員一覧を表示する(List<KaigoShienSenmoninJouhouResult> resultList) {
        List<dgKaigoShienSenmoninIchiran_Row> rowList = new ArrayList<>();
        if (null != resultList && (!resultList.isEmpty())) {
            for (KaigoShienSenmoninJouhouResult result : resultList) {
                dgKaigoShienSenmoninIchiran_Row newRow = new dgKaigoShienSenmoninIchiran_Row();
                newRow.setKaigoShienSenmoninNo(result.getCareManeger().get介護支援専門員番号());
                if (null != result.getCareManeger().get介護支援専門員名()) {
                    newRow.setKaigoShienSenmoninMei(result.getCareManeger().get介護支援専門員名().getColumnValue());
                } else {
                    newRow.setKaigoShienSenmoninMei(RString.EMPTY);
                }
                if (null != result.getCareManeger().get介護支援専門員名カナ()) {
                    newRow.setKaigoShienSenmoninMeiKana(result.getCareManeger().get介護支援専門員名カナ().getColumnValue());
                } else {
                    newRow.setKaigoShienSenmoninMeiKana(RString.EMPTY);
                }
                if (!RString.isNullOrEmpty(result.get所属事業者番号())) {
                    newRow.setShozokuJigyoshaNo(result.get所属事業者番号());
                } else {
                    newRow.setShozokuJigyoshaNo(RString.EMPTY);
                }
                if (!RString.isNullOrEmpty(result.get事業者名称())) {
                    newRow.setShozokuJigyoshaMei(result.get事業者名称());
                } else {
                    newRow.setShozokuJigyoshaMei(RString.EMPTY);
                }
                FlexibleDate yukoKaishiDate = result.getCareManeger().get有効開始年月日();
                if (null != yukoKaishiDate && (!FlexibleDate.EMPTY.equals(yukoKaishiDate))) {
                    newRow.getYukoKaishiDate().setValue(new RDate(yukoKaishiDate.toString()));
                }
                FlexibleDate yukoShuryoDate = result.getCareManeger().get有効終了年月日();
                if (null != yukoShuryoDate && (!FlexibleDate.EMPTY.equals(yukoShuryoDate))) {
                    newRow.getYukoShuryoDate().setValue(new RDate(yukoShuryoDate.toString()));
                }
                rowList.add(newRow);
            }
            if ((!rowList.isEmpty()) && 1 < rowList.size()) {
                sortDg介護支援専門員一覧(rowList);
            }
        }
        div.getKaigoShienSenmoninIchiran().getDgKaigoShienSenmoninIchiran().setDataSource(rowList);
    }

    private void sortDg介護支援専門員一覧(List<dgKaigoShienSenmoninIchiran_Row> rowList) {
        Collections.sort(rowList, new Comparator<dgKaigoShienSenmoninIchiran_Row>() {
            @Override
            public int compare(dgKaigoShienSenmoninIchiran_Row row1, dgKaigoShienSenmoninIchiran_Row row2) {
                return row1.getKaigoShienSenmoninNo().compareTo(row2.getKaigoShienSenmoninNo());
            }
        });
    }

    /**
     * 介護支援専門員登録画面 「追加する」ボタンを処理します。
     */
    public void onClick_btnTsuika() {
        div.setOperateState(状態_追加);
        介護支援専門員登録パネルに項目をクリアする();
        介護支援専門員登録パネルに表示制御を設定する();
    }

    private void 介護支援専門員登録パネルに項目をクリアする() {
        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango().clearValue();
        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().clearValue();
        div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().clearValue();
        div.getKaigoSienSenmoninToroku().getTxtYukoKikan().clearFromValue();
        div.getKaigoSienSenmoninToroku().getTxtYukoKikan().clearToValue();
        div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().initialize();
        div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().clear();
    }

    private void 介護支援専門員登録パネルに表示制御を設定する() {
        boolean is追加状態 = 状態_追加.equals(div.getOperateState());
        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango().setDisabled(!is追加状態);
        boolean is削除状態 = 状態_削除.equals(div.getOperateState());
        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().setDisabled(is削除状態);
        div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().setDisabled(is削除状態);
        div.getKaigoSienSenmoninToroku().getTxtYukoKikan().setDisabled(is削除状態);
        div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().setDisabled(is削除状態);
    }

    /**
     * 介護支援専門員登録画面 介護支援専門員一覧DataGrid、「修正」ボタンを処理します。
     */
    public void onClick_btnModify() {
        div.setOperateState(状態_修正);
        介護支援専門員登録パネルに項目を設定する();
        介護支援専門員登録パネルに表示制御を設定する();
    }

    private void 介護支援専門員登録パネルに項目を設定する() {
        dgKaigoShienSenmoninIchiran_Row row = div.getKaigoShienSenmoninIchiran().getDgKaigoShienSenmoninIchiran().getClickedItem();
        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango().setValue(row.getKaigoShienSenmoninNo());
        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().setValue(row.getKaigoShienSenmoninMei());
        div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().setValue(row.getKaigoShienSenmoninMeiKana());
        RDate yukoKaishiDate = row.getYukoKaishiDate().getValue();
        if (null != yukoKaishiDate) {
            div.getKaigoSienSenmoninToroku().getTxtYukoKikan().setFromValue(yukoKaishiDate);
        } else {
            div.getKaigoSienSenmoninToroku().getTxtYukoKikan().clearFromValue();
        }
        RDate yukoShuryoDate = row.getYukoShuryoDate().getValue();
        if (null != yukoShuryoDate) {
            div.getKaigoSienSenmoninToroku().getTxtYukoKikan().setToValue(yukoShuryoDate);
        } else {
            div.getKaigoSienSenmoninToroku().getTxtYukoKikan().clearToValue();
        }
        div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().initialize();
        div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().setNyuryokuShisetsuKodo(row.getShozokuJigyoshaNo());
        div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().setShisetsuMeisho(row.getShozokuJigyoshaMei());
    }

    /**
     * 介護支援専門員登録画面 介護支援専門員一覧DataGrid、「削除」ボタンを処理します。
     */
    public void onClick_btnDelete() {
        div.setOperateState(状態_削除);
        介護支援専門員登録パネルに項目を設定する();
        介護支援専門員登録パネルに表示制御を設定する();
    }

    /**
     * 介護支援専門員登録情報を保存します。
     *
     * @param 介護支援専門員番号 RString
     * @return boolean
     */
    public boolean 介護支援専門員登録情報を保存する(RString 介護支援専門員番号) {
        AtenaMeisho 介護支援専門員名 = new AtenaMeisho(div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().getValue());
        AtenaKanaMeisho 介護支援専門員名カナ
                = RString.isNullOrEmpty(div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().getValue())
                ? AtenaKanaMeisho.EMPTY : new AtenaKanaMeisho(div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().getValue());
        JigyoshaNo 所属事業者番号 = new JigyoshaNo(div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().getNyuryokuShisetsuKodo());
        FlexibleDate 有効開始年月日 = null == div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getFromValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getFromValue().toString());
        FlexibleDate 有効終了年月日 = null == div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getToValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getToValue().toString());
        CareManegerHolder holder = ViewStateHolder.get(ViewStateHolderName.介護支援専門員登録情報, CareManegerHolder.class);
        CareManeger careManeger;
        if (状態_削除.equals(div.getOperateState())) {
            careManeger = holder.getCareManeger(new CareManegerIdentifier(介護支援専門員番号)).deleted();
        } else if (状態_修正.equals(div.getOperateState())) {
            careManeger = holder.getCareManeger(new CareManegerIdentifier(介護支援専門員番号)).createBuilderForEdit()
                    .set介護支援専門員名(介護支援専門員名)
                    .set介護支援専門員名カナ(介護支援専門員名カナ)
                    .set所属事業者番号(所属事業者番号)
                    .set有効開始年月日(有効開始年月日)
                    .set有効終了年月日(有効終了年月日)
                    .build().modified();
        } else {
            careManeger = new CareManeger(介護支援専門員番号).createBuilderForEdit()
                    .set介護支援専門員名(介護支援専門員名)
                    .set介護支援専門員名カナ(介護支援専門員名カナ)
                    .set所属事業者番号(所属事業者番号)
                    .set有効開始年月日(有効開始年月日)
                    .set有効終了年月日(有効終了年月日)
                    .build();
        }
        CareManegerManager manager = new CareManegerManager();
        return manager.save介護支援専門員(careManeger);
    }

    /**
     * 介護完了メッセージパネルを表示します。
     *
     * @param message RString
     * @param 介護支援専門員番号 RString
     * @param 介護支援専門員氏名 RString
     * @param isSuccess boolean
     */
    public void 介護完了メッセージパネルを表示する(RString message, RString 介護支援専門員番号, RString 介護支援専門員氏名, boolean isSuccess) {
        div.getKanryoMessage().getCcdKanryoMessage().setMessage(message, 介護支援専門員番号, 介護支援専門員氏名, isSuccess);
    }

    /**
     * 検索条件パネルにボタンの制御を設定します。
     *
     * @param stateName RString
     */
    public void onState(RString stateName) {
        div.getKensakuJoken().getBtnKensaku().setDisabled(!stateName.equals(DBC4520011StateName.検索画面.getName()));
        div.getKensakuJoken().getBtnKensakuKuria().setDisabled(!stateName.equals(DBC4520011StateName.検索画面.getName()));
    }
}
