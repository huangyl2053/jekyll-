/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・審査会結果登録のコントローラです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
public class ShinsaKaiKekkaTorokuHandler {

    private final ShinsaKaiKekkaTorokuDiv div;
    private final RString 二次判定モード = new RString("二次判定モード");
    private final RString 使用 = new RString("1");

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
        div.getCcdTaskList().initialize(二次判定モード);
        活性非活性の設定();
    }

    /**
     * 要介護認定完了情報の更新処理する。
     *
     * @param models models
     */
    public void 要介護認定完了更新(Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models) {
        FlexibleDate 割当完了年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<dgNinteiTaskList_Row> 選択データ = div.getCcdTaskList().getCheckbox();
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
        RDate 適用基準日 = RDate.getNowDate();
        RString モバイル審査会使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル審査会使用有無, 適用基準日, SubGyomuCode.DBE認定支援);
        RString 審査会結果OCR使用有無 = DbBusinessConfig.get(ConfigNameDBE.審査会結果OCR使用有無, 適用基準日, SubGyomuCode.DBE認定支援);
        if (使用.equals(モバイル審査会使用有無)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnMobileToroku"), false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnMobileToroku"), true);
        }
        if (使用.equals(審査会結果OCR使用有無)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnOCRToroku"), false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnOCRToroku"), true);
        }
    }
}
