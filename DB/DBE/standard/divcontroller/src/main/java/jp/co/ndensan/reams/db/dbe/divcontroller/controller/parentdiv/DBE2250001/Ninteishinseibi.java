/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran.NiTeiCyoSaiChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran.NinteichosahyoGaikyoChosaRelateBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.niteicyosaichiran.NiTeiCyoSaiChiRanParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.report.shinsakainenkansukejuruhyo.NiTeiCyoSaiChiRanManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokkiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class Ninteishinseibi {

    private final NiTeiCyoSaiChiRanManager manager;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * コンストラクタです。
     *
     */
    public Ninteishinseibi() {
        this.manager = NiTeiCyoSaiChiRanManager.createInstance();
    }

    /**
     * 認定調査データ取込（モバイル）の初期処理を表示します。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onLoad(NinteishinseibiDiv div) {
        getHandler(div).initializtion();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアする。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> btn_clear(NinteishinseibiDiv div) {
        getHandler(div).clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査一覧の検索。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> btn_kenSaKu(NinteishinseibiDiv div) {
        RString イメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RDate 認定申請年月日開始 = div.getTxtNinteishinseibi().getFromValue();
        RDate 認定申請年月日終了 = div.getTxtNinteishinseibi().getToValue();
        RDate 依頼日開始 = div.getTxtiraibi().getFromValue();
        RDate 依頼日終了 = div.getTxtiraibi().getToValue();
        Decimal 検索件数 = div.getTxtMaxKensu().getValue();
        NiTeiCyoSaiChiRanParameter niTeiCyoSaiChiRanParameter = NiTeiCyoSaiChiRanParameter.
                createParameter(
                        ShoriJotaiKubun.通常.getコード(),
                        ShoriJotaiKubun.延期.getコード(),
                        イメージ区分,
                        認定申請年月日開始 == null ? FlexibleDate.EMPTY : new FlexibleDate(認定申請年月日開始.toDateString()),
                        認定申請年月日終了 == null ? FlexibleDate.EMPTY : new FlexibleDate(認定申請年月日終了.toDateString()),
                        依頼日開始 == null ? FlexibleDate.EMPTY : new FlexibleDate(依頼日開始.toDateString()),
                        依頼日終了 == null ? FlexibleDate.EMPTY : new FlexibleDate(依頼日終了.toDateString()),
                        検索件数);
        SearchResult<NiTeiCyoSaiChiRanBusiness> business = manager.get認定調査一覧(niTeiCyoSaiChiRanParameter);
        if (!business.records().isEmpty()) {
            NinteichosahyoGaikyoChosaRelateBusiness 認定調査 = manager.get認定調査(niTeiCyoSaiChiRanParameter).records().get(0);
            ViewStateHolder.put(ViewStateKeys.認定調査票基本調査_調査項目, Models.create(認定調査.get認定調査票基本調査_調査項目Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_概況調査, Models.create(認定調査.get認定調査票_概況調査Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_概況特記, Models.create(認定調査.get認定調査票_概況特記Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_基本調査, Models.create(認定調査.get認定調査票_基本調査Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査_記入項目, Models.create(認定調査.get認定調査票概況調査記入項目Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査サービスの状況, Models.create(認定調査.get認定調査票概況調査サービスの状況Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査サービスの状況フラグ, Models.create(認定調査.get認定調査票概況調査サービスの状況フラグLsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査施設利用, Models.create(認定調査.get認定調査票概況調査施設利用Lsit()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_特記情報, Models.create(認定調査.get認定調査票_特記情報Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.認定調査票基本調査_調査項目, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_概況調査, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_概況特記, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_基本調査, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査_記入項目, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査サービスの状況, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査サービスの状況フラグ, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票概況調査施設利用, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.認定調査票_特記情報, Models.create(new ArrayList()));
        }
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        getHandler(div).検索処理(business.records(), personalData);
        ValidationMessageControlPairs validationMessage = getValidatisonHandler(div).データ空のチェック();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(div).respond();
    }

    /**
     * 取込むボタン。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> btn_toRiKoMi(NinteishinseibiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            List<ChosaKekkaNyuryokuCsvEntity> csvEntityList = データ取込();
            ValidationMessageControlPairs vallidation = getValidatisonHandler(div).取込対象データチェック(csvEntityList.isEmpty());
            if (vallidation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(vallidation).respond();
            }
            List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getDataSource();
            List<RString> shinseishoKanriNoList = new ArrayList<>();
            for (int i = 0; i < rowList.size(); i++) {
                dgNinteiChosaData_Row row = rowList.get(i);
                shinseishoKanriNoList.add(row.getShinseishoKanriNo());
            }
            for (ChosaKekkaNyuryokuCsvEntity entity : csvEntityList) {

                boolean flg = true;
                for (int i = 0; i < rowList.size(); i++) {

                    dgNinteiChosaData_Row row = rowList.get(i);
                    if (entity.getShinseishoKanriNo().equals(row.getShinseishoKanriNo())
                            && getHandler(div).取込むの判定(row, entity)) {
                        getHandler(div).取込むの編集(row, entity);
                        rowList.set(i, row);
                        flg = false;
                        break;
                    }
                }
                if (flg && !shinseishoKanriNoList.contains(entity.getShinseishoKanriNo())) {
                    dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();
                    getHandler(div).取込むの編集(row, entity);
                    rowList.add(row);
                }
            }
            div.getDgNinteiChosaData().setDataSource(rowList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存ボタンの処理。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> btn_save(NinteishinseibiDiv div) {

        ValidationMessageControlPairs validation = getValidatisonHandler(div).認定調査一覧データの行選択チェック();
        if (validation.iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        if (!getHandler(div).選択状態変更の判定() && !ResponseHolder.isReRequest()) {

            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            getHandler(div).保存状態();
            Models<NinteichosahyoGaikyoChosaIdentifier, NinteichosahyoGaikyoChosa> 概況調査Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票_概況調査, Models.class);
            Models<GaikyoTokkiIdentifier, GaikyoTokki> 概況特記Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票_概況特記, Models.class);
            Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> 調査項目Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票基本調査_調査項目, Models.class);
            Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa> 基本調査Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票_基本調査, Models.class);
            Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem> 記入項目Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票概況調査_記入項目, Models.class);
            Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo> サービスの状況Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票概況調査サービスの状況, Models.class);
            Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag> サービスの状況フラグModels
                    = ViewStateHolder.get(ViewStateKeys.認定調査票概況調査サービスの状況フラグ, Models.class);
            Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo> 認定調査票概況調査施設利用Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票概況調査施設利用, Models.class);
            Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko> 特記情報Models
                    = ViewStateHolder.get(ViewStateKeys.認定調査票_特記情報, Models.class);
            List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getSelectedItems();
            for (dgNinteiChosaData_Row row : rowList) {

                if (!RString.isNullOrEmpty(row.getJyoutai())) {

                    NinteichosahyoGaikyoChosa gaikyoChosa = 認定調査票_概況調査の登録処理(row, 概況調査Models, div);
                    GaikyoTokki gaikyoTokki = 認定調査票_概況特記の登録処理(row, 概況特記Models, div);
                    NinteichosahyoTokkijiko yoTokkijiko = 認定調査票_特記情報の登録処理(row, 特記情報Models, div);
                    NinteichosahyoKihonChosa kihonChosa = 認定調査票_基本調査の登録処理(row, 基本調査Models, div);
                    NinteichosahyoChosaItem chosaItem = 認定調査票_基本調査調査項目の登録処理(row, 調査項目Models, div);
                    NinteichosahyoServiceJokyo serviceJokyo = 認定調査票_概況調査サービスの状況の登録処理(row, サービスの状況Models, div);
                    NinteichosahyoServiceJokyoFlag serviceJokyoFlag = 認定調査票_概況調査サービスの状況フラグの登録処理(row, サービスの状況フラグModels, div);
                    NinteichosahyoKinyuItem kinyuItem = 認定調査票_概況調査記入項目の登録処理(row, 記入項目Models, div);
                    NinteichosahyoShisetsuRiyo shisetsuRiyo = 認定調査票_概況調査施設利用の登録処理(row, 認定調査票概況調査施設利用Models, div);
                    manager.認定調査一覧更新処理(
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                            Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                            TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                            row.getNinteichosaTokkijikoNo(),
                            Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()),
                            TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                            new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()),
                            yoTokkijiko,
                            gaikyoChosa,
                            gaikyoTokki,
                            kihonChosa,
                            Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                            Integer.valueOf(row.getRemban().toString()),
                            chosaItem,
                            serviceJokyo,
                            serviceJokyoFlag,
                            kinyuItem,
                            shisetsuRiyo);
                }
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    private NinteichosahyoGaikyoChosa 認定調査票_概況調査の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoGaikyoChosaIdentifier, NinteichosahyoGaikyoChosa> 概況調査Models, NinteishinseibiDiv div) {

        NinteichosahyoGaikyoChosaIdentifier key = new NinteichosahyoGaikyoChosaIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());
        NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = 概況調査Models.get(key);
        if (ninteichosahyoGaikyoChosa == null) {

            ninteichosahyoGaikyoChosa = new NinteichosahyoGaikyoChosa(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());
        }
        NinteichosahyoGaikyoChosaBuilder gaikyoChosaBuilder = getHandler(div).認定調査票概況調査の編集(row, ninteichosahyoGaikyoChosa);
        return gaikyoChosaBuilder.build();
    }

    private NinteichosahyoTokkijiko 認定調査票_特記情報の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoTokkijikoIdentifier, NinteichosahyoTokkijiko> 特記情報Models, NinteishinseibiDiv div) {

        NinteichosahyoTokkijikoIdentifier key = new NinteichosahyoTokkijikoIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                row.getNinteichosaTokkijikoNo(),
                Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()));
        NinteichosahyoTokkijiko ninteichosahyoTokkijiko = 特記情報Models.get(key);
        if (ninteichosahyoTokkijiko == null) {

            ninteichosahyoTokkijiko = new NinteichosahyoTokkijiko(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    row.getNinteichosaTokkijikoNo(),
                    Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()),
                    TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                    new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()));
        }
        NinteichosahyoTokkijikoBuilder ninteichosahyoTokkijikoBuilder = getHandler(div).認定調査票特記情報の編集(row, ninteichosahyoTokkijiko);
        return ninteichosahyoTokkijikoBuilder.build();
    }

    private GaikyoTokki 認定調査票_概況特記の登録処理(dgNinteiChosaData_Row row, Models<GaikyoTokkiIdentifier, GaikyoTokki> 概況特記Models, NinteishinseibiDiv div) {

        GaikyoTokkiIdentifier key = new GaikyoTokkiIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());
        GaikyoTokki gaikyoTokki = 概況特記Models.get(key);
        if (gaikyoTokki == null) {

            gaikyoTokki = new GaikyoTokki(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());
        }
        GaikyoTokkiBuilder gaikyoTokkiBuilder = getHandler(div).認定調査票概況特記の編集(row, gaikyoTokki);
        return gaikyoTokkiBuilder.build();
    }

    private NinteichosahyoKihonChosa 認定調査票_基本調査の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoKihonChosaIdentifier, NinteichosahyoKihonChosa> 基本調査Models, NinteishinseibiDiv div) {

        NinteichosahyoKihonChosaIdentifier key = new NinteichosahyoKihonChosaIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        NinteichosahyoKihonChosa ninteichosahyoKihonChosa = 基本調査Models.get(key);
        if (ninteichosahyoKihonChosa == null) {

            ninteichosahyoKihonChosa = new NinteichosahyoKihonChosa(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        }
        NinteichosahyoKihonChosaBuilder kihonChosaBuilder = getHandler(div).認定調査票基本調査の編集(row, ninteichosahyoKihonChosa);
        return kihonChosaBuilder.build();
    }

    private NinteichosahyoChosaItem 認定調査票_基本調査調査項目の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> 調査項目Models, NinteishinseibiDiv div) {

        NinteichosahyoChosaItemIdentifier key = new NinteichosahyoChosaItemIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getRemban().toString()));
        NinteichosahyoChosaItem ninteichosahyoChosaItem = 調査項目Models.get(key);
        if (ninteichosahyoChosaItem == null) {

            ninteichosahyoChosaItem = new NinteichosahyoChosaItem(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    Integer.valueOf(row.getRemban().toString()));
        }
        NinteichosahyoChosaItemBuilder ninteichosahyoChosaItemBuilder = getHandler(div).
                認定調査票基本調査調査項目の編集(row, ninteichosahyoChosaItem);
        return ninteichosahyoChosaItemBuilder.build();
    }

    private NinteichosahyoServiceJokyo 認定調査票_概況調査サービスの状況の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoServiceJokyoIdentifier, NinteichosahyoServiceJokyo> サービスの状況Models, NinteishinseibiDiv div) {

        NinteichosahyoServiceJokyoIdentifier key = new NinteichosahyoServiceJokyoIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getRemban().toString()));
        NinteichosahyoServiceJokyo ninteichosahyoServiceJokyo = サービスの状況Models.get(key);
        if (ninteichosahyoServiceJokyo == null) {

            ninteichosahyoServiceJokyo = new NinteichosahyoServiceJokyo(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    Integer.valueOf(row.getRemban().toString()));
        }
        NinteichosahyoServiceJokyoBuilder serviceJokyoBuilder = getHandler(div).認定調査票概況調査サービスの状況の編集(row, ninteichosahyoServiceJokyo);
        return serviceJokyoBuilder.build();
    }

    private NinteichosahyoServiceJokyoFlag 認定調査票_概況調査サービスの状況フラグの登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoServiceJokyoFlagIdentifier, NinteichosahyoServiceJokyoFlag> サービスの状況フラグModels, NinteishinseibiDiv div) {

        NinteichosahyoServiceJokyoFlagIdentifier key = new NinteichosahyoServiceJokyoFlagIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getRemban().toString()));
        NinteichosahyoServiceJokyoFlag ninteichosahyoServiceJokyoFlag = サービスの状況フラグModels.get(key);
        if (ninteichosahyoServiceJokyoFlag == null) {

            ninteichosahyoServiceJokyoFlag = new NinteichosahyoServiceJokyoFlag(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    Integer.valueOf(row.getRemban().toString()));
        }
        NinteichosahyoServiceJokyoFlagBuilder serviceJokyoFlagBuilder = getHandler(div).
                認定調査票概況調査サービスの状況フラグの編集(row, ninteichosahyoServiceJokyoFlag);
        return serviceJokyoFlagBuilder.build();
    }

    private NinteichosahyoKinyuItem 認定調査票_概況調査記入項目の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoKinyuItemIdentifier, NinteichosahyoKinyuItem> 記入項目Models, NinteishinseibiDiv div) {

        NinteichosahyoKinyuItemIdentifier key = new NinteichosahyoKinyuItemIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getRemban().toString()));
        NinteichosahyoKinyuItem ninteichosahyoKinyuItem = 記入項目Models.get(key);
        if (ninteichosahyoKinyuItem == null) {
            ninteichosahyoKinyuItem = new NinteichosahyoKinyuItem(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    Integer.valueOf(row.getRemban().toString()));
        }
        NinteichosahyoKinyuItemBuilder ninteichosahyoKinyuItemBuilder = getHandler(div).
                認定調査票概況調査記入項目の編集(row, ninteichosahyoKinyuItem);
        return ninteichosahyoKinyuItemBuilder.build();
    }

    private NinteichosahyoShisetsuRiyo 認定調査票_概況調査施設利用の登録処理(dgNinteiChosaData_Row row,
            Models<NinteichosahyoShisetsuRiyoIdentifier, NinteichosahyoShisetsuRiyo> 施設利用Models, NinteishinseibiDiv div) {

        NinteichosahyoShisetsuRiyoIdentifier key = new NinteichosahyoShisetsuRiyoIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getRemban().toString()));
        NinteichosahyoShisetsuRiyo ninteichosahyoShisetsuRiyo = 施設利用Models.get(key);
        if (ninteichosahyoShisetsuRiyo == null) {

            ninteichosahyoShisetsuRiyo = new NinteichosahyoShisetsuRiyo(
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                    Integer.valueOf(row.getRemban().toString()));
        }
        NinteichosahyoShisetsuRiyoBuilder shisetsuRiyoBuilder = getHandler(div).
                認定調査票概況調査施設利用の編集(row, ninteichosahyoShisetsuRiyo);
        return shisetsuRiyoBuilder.build();
    }

    private List<ChosaKekkaNyuryokuCsvEntity> データ取込() {

        RString 調査取込用データ_モバイル_パス = DbBusinessConfig.get(ConfigNameDBE.調査取込用データ_モバイル_パス, RDate.getNowDate());
        RString 調査取込用データ_モバイル = DbBusinessConfig.get(ConfigNameDBE.調査取込用データ_モバイル, RDate.getNowDate());
        RString filePath = Path.combinePath(調査取込用データ_モバイル_パス, 調査取込用データ_モバイル);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, ChosaKekkaNyuryokuCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader);
    }

    private List<ChosaKekkaNyuryokuCsvEntity> readCsvFile(CsvReader csvReader) {
        List<ChosaKekkaNyuryokuCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ChosaKekkaNyuryokuCsvEntity entity = (ChosaKekkaNyuryokuCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private NinteishinseibiHandler getHandler(NinteishinseibiDiv div) {
        return new NinteishinseibiHandler(div);
    }

    private NinteishinseibiValidatisonHandler getValidatisonHandler(NinteishinseibiDiv div) {
        return new NinteishinseibiValidatisonHandler(div);
    }
}
