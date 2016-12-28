/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaikekka.ShinsakaiKekkaTorokuFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.NiJiHanTeiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・審査会結果登録のコントローラです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
public class ShinsaKaiKekkaTorokuHandler {

    private final ShinsaKaiKekkaTorokuDiv div;
    private final RString 使用 = new RString("1");
    private final String 状態 = "jotai";
    private static final RString 未処理 = new RString("未");
    private static final RString 完了可能 = new RString("可");
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");

    private static final Code 認定ｿﾌﾄ99 = new Code(new RString("99A"));
    private static final Code 認定ｿﾌﾄ2002 = new Code(new RString("02A"));
    private static final Code 認定ｿﾌﾄ2006 = new Code(new RString("06A"));
    private static final Code 認定ｿﾌﾄ2009_A = new Code(new RString("09A"));
    private static final Code 認定ｿﾌﾄ2009_B = new Code(new RString("09B"));

    /**
     * コンストラクタです。
     *
     * @param div 審査会結果登録Div
     */
    public ShinsaKaiKekkaTorokuHandler(ShinsaKaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・審査会結果登録の初期化を設定します。
     *
     */
    public void onLoad() {
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.get(
                ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxLength(Integer.toString(div.getTxtMaxKensu().getMaxValue().intValue()).length());
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(
                ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
//        RString key = div.getRadTaishosyaJotai().getSelectedKey();
//        RString 状態区分 = new RString("");
//
//        if (KEY0.equals(key)) {
//            状態区分 = new RString("1");
//            div.getTxtMishoriCount().setDisplayNone(false);
//            div.getTxtCompleteCount().setDisplayNone(true);
//            div.getTxtTotalCount().setDisplayNone(true);
//        } else if (KEY1.equals(key)) {
//            状態区分 = new RString("2");
//            div.getTxtMishoriCount().setDisplayNone(true);
//            div.getTxtCompleteCount().setDisplayNone(false);
//            div.getTxtTotalCount().setDisplayNone(true);
//        } else {
//            div.getTxtMishoriCount().setDisplayNone(false);
//            div.getTxtCompleteCount().setDisplayNone(false);
//            div.getTxtTotalCount().setDisplayNone(false);
//        }

//        List<NiJiHanTeiBusiness> 二次判定List = ShinsakaiKekkaTorokuFinder.createInstance().
//                get二次判定モード(YokaigoNinteiTaskListParameter.
//                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分)).records();
//        if (!二次判定List.isEmpty()) {
//            ShinSaKaiBusiness 前二次判定Model = ShinsakaiKekkaTorokuFinder.createInstance().
//                    get前二次判定(YokaigoNinteiTaskListParameter.
//                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分));
//            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前二次判定Model.get要介護認定完了情報Lsit()));
//        } else {
//            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
//        }
        二次判定モード();

        活性非活性の設定();
    }

    /**
     * 対象者状態ラジオボタンの表示処理です。
     */
    public void setJyotaiKubun() {
        二次判定モード();
    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param models models
     */
    public void 要介護認定完了更新(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models) {
        FlexibleDate 割当完了年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<dgNinteiTaskList_Row> 選択データ = div.getDgNinteiTaskList().getSelectedItems();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(データ.getShinseishoKanriNo());
            NinteiKanryoJohoIdentifier 要介護認定完了識別子 = new NinteiKanryoJohoIdentifier(申請書管理番号);
            NinteiKanryoJoho 要介護認定完了
                    = models.get(要介護認定完了識別子).createBuilderForEdit().set認定審査会完了年月日(割当完了年月日).build();
            ShinsakaiTorokuManager.createInstance().要介護認定完了更新(要介護認定完了.toEntity());
        }
    }

    /**
     * CSVファイルのデータをDBへ更新する。
     *
     * @param csvEntityList List<ShinsaKaiKekkaInputCsvEntity>
     */
    public void onClick_btnCyosakekkaInput(List<ShinsaKaiKekkaInputCsvEntity> csvEntityList) {
        saveCsvDataInput(csvEntityList);
    }

    private void saveCsvDataInput(List<ShinsaKaiKekkaInputCsvEntity> csvEntityList) {
        for (ShinsaKaiKekkaInputCsvEntity csvEntity : csvEntityList) {
            NinteiKekkaJoho 要介護認定結果情報 = set要介護認定結果情報(csvEntity);
            IchiGojiHanteiKekkaJoho 要介護認定1_5次判定結果情報 = set次判定結果情報(csvEntity);
            ShinsakaiTorokuManager.createInstance().saveCsvDataInput(要介護認定結果情報, 要介護認定1_5次判定結果情報);
        }
    }

    private NinteiKekkaJoho set要介護認定結果情報(ShinsaKaiKekkaInputCsvEntity csvEntity) {
        NinteiKekkaJoho 要介護認定結果情報 = new NinteiKekkaJoho(new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()));
        NinteiKekkaJohoBuilder 認定結果情報 = 要介護認定結果情報.createBuilderForEdit();
        FlexibleDate 審査会資料作成年月日 = ShinsakaiTorokuManager.createInstance().
                get審査会資料作成年月日(csvEntity.getShinsakaiKaisaiNo(), new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()));
        if (審査会資料作成年月日 != null && !審査会資料作成年月日.isEmpty()) {
            認定結果情報.set介護認定審査会資料作成年月日(審査会資料作成年月日);
        }
        return 認定結果情報.
                set二次判定年月日(new FlexibleDate(new RDate(csvEntity.getNijiHanteiYMD().toString()).toDateString()))
                .set二次判定要介護状態区分コード(new Code(csvEntity.getNijiHanteiYokaigoJotaiKubunCode()))
                .set二次判定認定有効期間(Integer.parseInt(csvEntity.getNijiHanteiNinteiYukoKikan().toString()))
                .set二次判定認定有効開始年月日(new FlexibleDate(new RDate(csvEntity.getNijiHanteiNinteiYukoKaishiYMD().toString()).toDateString()))
                .set二次判定認定有効終了年月日(new FlexibleDate(new RDate(csvEntity.getNijiHanteiNinteiYukoShuryoYMD().toString()).toDateString()))
                .set介護認定審査会開催番号(csvEntity.getShinsakaiKaisaiNo())
                .set介護認定審査会意見(csvEntity.getShinsakaiIken())
                .set一次判定結果変更理由(csvEntity.getIchijiHanteiKekkaHenkoRiyu())
                .set要介護状態像例コード(new Code(csvEntity.getYokaigoJotaizoReiCode()))
                .set認定審査会意見種類(csvEntity.getNinteishinsakaiIkenShurui())
                .set審査会メモ(csvEntity.getShinsakaiMemo())
                .set二次判定結果入力方法(new Code(csvEntity.getNijiHanteiKekkaInputHoho()))
                .set二次判定結果入力年月日(new FlexibleDate(new RDate(csvEntity.getNijiHanteiKekkaInputYMD().toString()).toDateString()))
                .build();
    }

    private IchiGojiHanteiKekkaJoho set次判定結果情報(ShinsaKaiKekkaInputCsvEntity csvEntity) {
        IchiGojiHanteiKekkaJoho 要介護認定1_5次判定結果情報 = new IchiGojiHanteiKekkaJoho(new ShinseishoKanriNo(csvEntity.getShinseishoKanriNo()));
        return 要介護認定1_5次判定結果情報.createBuilderForEdit().
                set要介護認定1_5次判定年月日(new FlexibleDate(new RDate(csvEntity.getIchiGojiHanteiYMD().toString()).toDateString()))
                .set要介護認定1_5次判定結果コード(new Code(csvEntity.getIchiGojiHanteiKekkaCode()))
                .set要介護認定1_5次判定結果コード_認知症加算_(new Code(csvEntity.getIchiGojiHanteiKekkaNinchishoKasanCode()))
                .set要介護認定等基準時間(Integer.parseInt(csvEntity.getKijunJikan().toString()))
                .set要介護認定等基準時間_食事_(Integer.parseInt(csvEntity.getKijunJikanShokuji().toString()))
                .set要介護認定等基準時間_排泄_(Integer.parseInt(csvEntity.getKijunJikanHaisetsu().toString()))
                .set要介護認定等基準時間_移動_(Integer.parseInt(csvEntity.getKijunJikanIdo().toString()))
                .set要介護認定等基準時間_清潔保持_(Integer.parseInt(csvEntity.getKijunJikanSeiketsuHoji().toString()))
                .set要介護認定等基準時間_間接ケア_(Integer.parseInt(csvEntity.getKijunJikanKansetsuCare().toString()))
                .set要介護認定等基準時間_BPSD関連_(Integer.parseInt(csvEntity.getKijunJikanBPSDKanren().toString()))
                .set要介護認定等基準時間_機能訓練_(Integer.parseInt(csvEntity.getKijunJikanKinoKunren().toString()))
                .set要介護認定等基準時間_医療関連_(Integer.parseInt(csvEntity.getKijunJikanIryoKanren().toString()))
                .set要介護認定等基準時間_認知症加算_(Integer.parseInt(csvEntity.getKijunJikanNinchishoKasan().toString()))
                .set中間評価項目得点第1群(Integer.parseInt(csvEntity.getChukanHyokaKomoku1gun().toString()))
                .set中間評価項目得点第2群(Integer.parseInt(csvEntity.getChukanHyokaKomoku2gun().toString()))
                .set中間評価項目得点第3群(Integer.parseInt(csvEntity.getChukanHyokaKomoku3gun().toString()))
                .set中間評価項目得点第4群(Integer.parseInt(csvEntity.getChukanHyokaKomoku4gun().toString()))
                .set中間評価項目得点第5群(Integer.parseInt(csvEntity.getChukanHyokaKomoku5gun().toString()))
                .set要介護認定1_5次判定警告コード(new Code(csvEntity.getIchiGojiHnateiKeikokuCode()))
                .set要介護認定状態の安定性コード(new Code(csvEntity.getJotaiAnteiseiCode()))
                .set認知症自立度Ⅱ以上の蓋然性(new Decimal(csvEntity.getNinchishoJiritsudoIIijoNoGaizensei().toString()))
                .set認知機能及び状態安定性から推定される給付区分コード(new Code(csvEntity.getSuiteiKyufuKubunCode()))
                .build();

    }

    private void 活性非活性の設定() {
        div.getBtnShinsakaikanryooutput().setDisplayNone(false);
        RDate 適用基準日 = RDate.getNowDate();
        RString 審査会結果OCR使用有無 = DbBusinessConfig.get(ConfigNameDBE.審査会結果OCR使用有無, 適用基準日, SubGyomuCode.DBE認定支援);
        if (使用.equals(審査会結果OCR使用有無)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnOCRToroku"), false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnOCRToroku"), true);
        }
    }

    public void 二次判定モード() {
        RString key = div.getRadTaishosyaJotai().getSelectedKey();
        RString 状態区分 = new RString("");

        if (KEY0.equals(key)) {
            状態区分 = new RString("1");
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(true);
            div.getTxtTotalCount().setDisplayNone(true);
        } else if (KEY1.equals(key)) {
            状態区分 = new RString("2");
            div.getTxtMishoriCount().setDisplayNone(true);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(true);
        } else {
            div.getTxtMishoriCount().setDisplayNone(false);
            div.getTxtCompleteCount().setDisplayNone(false);
            div.getTxtTotalCount().setDisplayNone(false);
        }

        List<NiJiHanTeiBusiness> 二次判定List = ShinsakaiKekkaTorokuFinder.createInstance().
                get二次判定モード(YokaigoNinteiTaskListParameter.
                        createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分)).records();
        if (!二次判定List.isEmpty()) {
            ShinSaKaiBusiness 前二次判定Model = ShinsakaiKekkaTorokuFinder.createInstance().
                    get前二次判定(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分));
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前二次判定Model.get要介護認定完了情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
        Decimal 最大件数 = div.getTxtMaxKensu().getValue();
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        int notCount = 0;
        int i = 0;
        for (NiJiHanTeiBusiness business : 二次判定List) {
            if (i < div.getTxtMaxKensu().getValue().intValue()) {
                dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();

                if (business.get二次判定結果入力年月日() == null) {
                    row.setJotai(未処理);
                    row.setCellBgColor(状態, DataGridCellBgColor.bgColorRed);
                    notCount++;
                } else {
                    row.setJotai(完了可能);
                    completeCount++;
                }

                row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
                if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                    row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
                }
                row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
                row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
                row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                        ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
                row.setShinseiKubunHorei(business.get認定申請区分法令コード() == null
                        ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード().getKey()).get名称());
                if (business.get二次判定結果入力年月日() != null && !business.get二次判定結果入力年月日().isEmpty()) {
                    row.getNijihanteiKekkaToroku().setValue(new RDate(business.get二次判定結果入力年月日().toString()));
                }
                row.setNyuryokuHoho(business.get二次判定結果入力方法() == null ? RString.EMPTY
                        : NijiHanteiKekkaInputHoho.toValue(business.get二次判定結果入力方法().getKey()).get名称());
                row.setNijihanteiKekka(二次判定結果の名称を取得する(business.get厚労省IF識別コード(), business.get二次判定要介護状態区分コード()));
                row.setNijihanteiYukoKikan(new RString(String.valueOf(business.get二次判定認定有効期間())).concat(new RString("ヶ月")));
                if (business.get介護認定審査会開催年月日() != null && !business.get介護認定審査会開催年月日().isEmpty()) {
                    row.getNijihanteiShinsakaiKaisaiDay().setValue(new RDate(business.get介護認定審査会開催年月日().toString()));
                }
                row.setNijihanteiKaisaiNumber(business.get介護認定審査会開催番号() == null ? RString.EMPTY : edit審査会名称(business.get介護認定審査会開催番号()));
                row.setNijiHanteiYokaigoJotaiKubunCode(business.get二次判定要介護状態区分コード() == null
                        ? RString.EMPTY : business.get二次判定要介護状態区分コード().value());
                row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード() == null ? RString.EMPTY : business.get厚労省IF識別コード().value());
                row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
                row.getHiddenYukoKikan().setValue(new Decimal(business.get二次判定認定有効期間()));
                rowList.add(row);
                i++;
            }
        }
        div.getTxtMishoriCount().setValue(new Decimal(notCount));
        div.getTxtCompleteCount().setValue(new Decimal(completeCount));
        div.getTxtTotalCount().setValue(new Decimal(notCount + completeCount));
        div.getDgNinteiTaskList().setDataSource(rowList);
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(二次判定List.size());
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(最大件数.intValue());

    }
    
    private RString edit審査会名称(RString 審査会開催番号) {
        return new RString("第").concat(審査会開催番号).concat("回審査");
    }

    private RString 二次判定結果の名称を取得する(Code 厚労省IF識別コード, Code 二次判定結果コード) {
        if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        }
        return RString.EMPTY;
    }

}
