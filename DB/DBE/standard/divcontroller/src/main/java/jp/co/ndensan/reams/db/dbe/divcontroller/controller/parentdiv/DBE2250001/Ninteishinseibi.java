/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuGaikyoTokkiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuTokkiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.DBE2250001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakainenkansukejuruhyo.NiTeiCyoSaiChiRanManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class Ninteishinseibi {

    private final NiTeiCyoSaiChiRanManager manager;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 概況調査_基本調査データCSV名 = new RString("出力_概況調査_基本調査データ.csv");
    private static final RString 概況特記データCSV名 = new RString("出力_概況特記データ.csv");
    private static final RString 特記情報データCSV名 = new RString("出力_特記情報データ.csv");

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
        return ResponseData.of(div).setState(DBE2250001StateName.初期表示);
    }

    /**
     * 取込むボタン。
     *
     * @param div NinteishinseibiDiv
     * @param files FileData
     * @return ResponseData
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<NinteishinseibiDiv> onClick_btnUpload(NinteishinseibiDiv div, FileData[] files) {

        RString ファイルパス_基本調査データ = RString.EMPTY;
        RString ファイルパス_概況特記データ = RString.EMPTY;
        RString ファイルパス_特記情報データ = RString.EMPTY;
        for (FileData file : files) {
            if (file.getFileName().equals(概況調査_基本調査データCSV名)) {
                ファイルパス_基本調査データ = file.getFilePath();
            } else if (file.getFileName().equals(概況特記データCSV名)) {
                ファイルパス_概況特記データ = file.getFilePath();
            } else if (file.getFileName().equals(特記情報データCSV名)) {
                ファイルパス_特記情報データ = file.getFilePath();
            } else {
                throw new ApplicationException("誤ったCSVが読み込まれています。下記の名称のCSVを読み込んでください。<br>"
                        + 概況調査_基本調査データCSV名.toString() + "<br>" + 概況特記データCSV名.toString() + "<br>" + 特記情報データCSV名.toString());
            }
        }
        if (ファイルパス_基本調査データ.isEmpty() || ファイルパス_概況特記データ.isEmpty() || ファイルパス_特記情報データ.isEmpty()) {
            throw new ApplicationException("以下の３ファイルを同時に取込んでください。<br>"
                    + 概況調査_基本調査データCSV名.toString() + "<br>" + 概況特記データCSV名.toString() + "<br>" + 特記情報データCSV名.toString());
        }

        List<ChosaKekkaNyuryokuCsvEntity> csvEntityList_基本調査データ = データ取込_基本調査データ(ファイルパス_基本調査データ);
        ValidationMessageControlPairs vallidation = getValidatisonHandler(div).取込対象データチェック(csvEntityList_基本調査データ.isEmpty());
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }

        List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getDataSource();
        List<PersonalData> personalDataList = new ArrayList<>();
        Map<ShinseishoKanriNo, List<NinteichosahyoTokkijiko>> 特記事項Map = new HashMap<>();
        Map<ShinseishoKanriNo, GaikyoTokki> 概況特記事項Map = new HashMap<>();
        for (ChosaKekkaNyuryokuCsvEntity entity : csvEntityList_基本調査データ) {

            List<NinteichosahyoTokkijiko> 特記事項List = get特記事項List(ファイルパス_特記情報データ, entity);
            特記事項Map.put(new ShinseishoKanriNo(entity.get申請書管理番号()), 特記事項List);
            GaikyoTokki 概況特記事項 = get概況特記情報(ファイルパス_概況特記データ, entity);
            概況特記事項Map.put(new ShinseishoKanriNo(entity.get申請書管理番号()), 概況特記事項);

            dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();
            getHandler(div).取込むの編集(row, entity, 特記事項List, 概況特記事項);
            rowList.add(row);
            PersonalData personalData = PersonalData.of(
                    ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), entity.get申請書管理番号()));
            personalDataList.add(personalData);
        }
        AccessLogger.log(AccessLogType.照会, personalDataList);
        div.getTxtNinzu().setValue(new RString(rowList.size()));
        div.getDgNinteiChosaData().setDataSource(rowList);
        div.set特記事項Map(DataPassingConverter.serialize((HashMap) 特記事項Map));
        div.set概況特記事項Map(DataPassingConverter.serialize((HashMap) 概況特記事項Map));
        return ResponseData.of(div).respond();
    }

    private GaikyoTokki get概況特記情報(RString ファイルパス_概況特記データ, ChosaKekkaNyuryokuCsvEntity entity) {
        List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> csvEntityList_概況特記データ = データ取込_概況特記データ(ファイルパス_概況特記データ);
        GaikyoTokki 概況特記事項 = null;
        for (ChosaKekkaNyuryokuGaikyoTokkiCsvEntity 概況特記データ : csvEntityList_概況特記データ) {
            概況特記事項 = new GaikyoTokki(new ShinseishoKanriNo(
                    entity.get申請書管理番号()),
                    Integer.valueOf(entity.get認定調査依頼履歴番号().toString()),
                    entity.get概況特記テキスト_イメージ区分コード(),
                    new Code(GenponMaskKubun.原本.getコード()))
                    .createBuilderForEdit()
                    .set住宅改修(entity.get住宅改修改修箇所())
                    .set市町村特別給付サービス種類名(entity.get市町村特別給付サービス種類名())
                    .set介護保険給付以外の在宅サービス種類名(entity.get介護保険給付以外の在宅サービス種類名())
                    .set概況特記事項_主訴(概況特記データ.get概況特記事項主訴())
                    .set概況特記事項_家族状況(概況特記データ.get概況特記事項家族状況())
                    .set概況特記事項_居住環境(概況特記データ.get概況特記事項居住環境())
                    .set概況特記事項_機器_器械(概況特記データ.get概況特記事項機器_器械())
                    .build();
        }
        return 概況特記事項;
    }

    private List<NinteichosahyoTokkijiko> get特記事項List(RString ファイルパス_特記情報データ, ChosaKekkaNyuryokuCsvEntity entity) {
        List<ChosaKekkaNyuryokuTokkiCsvEntity> csvEntityList_特記情報データ = データ取込_特記情報データ(ファイルパス_特記情報データ);
        List<NinteichosahyoTokkijiko> 特記事項List = new ArrayList<>();
        for (ChosaKekkaNyuryokuTokkiCsvEntity 特記情報データ : csvEntityList_特記情報データ) {
            if (entity.get申請書管理番号().equals(特記情報データ.get申請書管理番号())) {
                特記事項List.add(new NinteichosahyoTokkijiko(
                        new ShinseishoKanriNo(entity.get申請書管理番号()),
                        Integer.valueOf(entity.get認定調査依頼履歴番号().toString()),
                        特記情報データ.get認定調査特記事項番号(),
                        Integer.valueOf(特記情報データ.get認定調査特記事項連番().toString()),
                        entity.get概況特記テキスト_イメージ区分コード(),
                        new Code(GenponMaskKubun.原本.getコード()))
                        .createBuilderForEdit().set特記事項(特記情報データ.get特記事項()).build());
            }
        }
        return 特記事項List;
    }

    /**
     * アップロードが完了した後に実行されます。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onAfterUploaded_btnImport(NinteishinseibiDiv div) {
        return ResponseData.of(div).setState(DBE2250001StateName.検索結果表示);
    }

    /**
     * 保存ボタンの処理。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> btn_save(NinteishinseibiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getDataSource();
            Map<ShinseishoKanriNo, List<NinteichosahyoTokkijiko>> 特記事項Map = DataPassingConverter.deserialize(div.get特記事項Map(), HashMap.class);
            Map<ShinseishoKanriNo, GaikyoTokki> 概況特記事項Map = DataPassingConverter.deserialize(div.get概況特記事項Map(), HashMap.class);

            for (dgNinteiChosaData_Row row : rowList) {

                if (!RString.isNullOrEmpty(row.getJyoutai())) {
                    NinteichosahyoGaikyoChosa 概況調査 = 認定調査票_概況調査の登録処理(row, div); //5202
                    GaikyoTokki 概況特記事項 = 概況特記事項Map.get(new ShinseishoKanriNo(row.getShinseishoKanriNo())); //5206
                    List<NinteichosahyoTokkijiko> 特記事項List = 特記事項Map.get(new ShinseishoKanriNo(row.getShinseishoKanriNo())); //5205
                    NinteichosahyoKihonChosa 基本調査 = 認定調査票_基本調査の登録処理(row, div); //5203
                    List<NinteichosahyoChosaItem> 調査項目List = 認定調査票_基本調査調査項目の登録処理(row); //5211
                    List<NinteichosahyoServiceJokyo> サービス状況List = 認定調査票_概況調査サービスの状況の登録処理(row); //5207
                    List<NinteichosahyoServiceJokyoFlag> サービス状況フラグList = 認定調査票_概況調査サービスの状況フラグの登録処理(row); //5208
                    List<NinteichosahyoKinyuItem> 記入項目List = 認定調査票_概況調査記入項目の登録処理(row); //5209
                    List<NinteichosahyoShisetsuRiyo> 施設利用List = 認定調査票_概況調査施設利用の登録処理(row); //5210

                    manager.認定調査一覧更新処理(
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                            Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                            TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                            new Code(GenponMaskKubun.原本.getコード()),
                            特記事項List,
                            概況調査,
                            概況特記事項,
                            基本調査,
                            Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                            調査項目List,
                            サービス状況List,
                            サービス状況フラグList,
                            記入項目List,
                            施設利用List);
                }
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2250001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private NinteichosahyoGaikyoChosa 認定調査票_概況調査の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = new NinteichosahyoGaikyoChosa(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());

        NinteichosahyoGaikyoChosaBuilder gaikyoChosaBuilder = getHandler(div).認定調査票概況調査の編集(row, ninteichosahyoGaikyoChosa);
        return gaikyoChosaBuilder.build();
    }

    private NinteichosahyoKihonChosa 認定調査票_基本調査の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoKihonChosa ninteichosahyoKihonChosa = new NinteichosahyoKihonChosa(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));

        NinteichosahyoKihonChosaBuilder kihonChosaBuilder = getHandler(div).認定調査票基本調査の編集(row, ninteichosahyoKihonChosa);
        return kihonChosaBuilder.build();
    }

    private Map<RString, RString> create連番Map(List<RString> keyList, List<RString> valueList) {
        if (keyList.size() != valueList.size()) {
            throw new SystemException("連番の数と値の数が一致しません");
        }
        Map<RString, RString> resultMap = new LinkedHashMap<>();
        int index = 0;
        for (RString key : keyList) {
            resultMap.put(key, valueList.get(index));
            index++;
        }
        return resultMap;
    }

    private List<NinteichosahyoChosaItem> 認定調査票_基本調査調査項目の登録処理(dgNinteiChosaData_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString());
        if (row.getRemban().isEmpty()) {
            return new ArrayList<>();
        }
        List<RString> 調査項目連番List = row.getRemban().split(",");
        List<RString> 調査項目List = row.getResearchItem().split(",");

        Map<RString, RString> 調査項目Map = create連番Map(調査項目連番List, 調査項目List);
        List<NinteichosahyoChosaItem> result調査項目List = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : 調査項目Map.entrySet()) {
            result調査項目List.add(new NinteichosahyoChosaItem(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .set調査項目(entry.getValue()).build()
            );
        }
        return result調査項目List;
    }

    private List<NinteichosahyoServiceJokyo> 認定調査票_概況調査サービスの状況の登録処理(dgNinteiChosaData_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString());
        if (row.getServiceJokyoRemban().isEmpty()) {
            return new ArrayList<>();
        }
        List<RString> サービス状況連番List = row.getServiceJokyoRemban().split(",");
        List<RString> 状況List = row.getServiceJokyo().split(",");

        Map<RString, RString> サービス状況Map = create連番Map(サービス状況連番List, 状況List);
        List<NinteichosahyoServiceJokyo> resultサービス状況List = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : サービス状況Map.entrySet()) {
            resultサービス状況List.add(new NinteichosahyoServiceJokyo(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .setサービスの状況(Integer.valueOf(entry.getValue().toString())).build()
            );
        }
        return resultサービス状況List;
    }

    private List<NinteichosahyoServiceJokyoFlag> 認定調査票_概況調査サービスの状況フラグの登録処理(dgNinteiChosaData_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString());
        if (row.getServiceJokyoFlagRemban().isEmpty()) {
            return new ArrayList<>();
        }
        List<RString> サービス状況フラグ連番List = row.getServiceJokyoFlagRemban().split(",");
        List<RString> 状況フラグList = row.getServiceJokyoFlag().split(",");

        Map<RString, RString> サービス状況フラグMap = create連番Map(サービス状況フラグ連番List, 状況フラグList);
        List<NinteichosahyoServiceJokyoFlag> resultサービス状況フラグList = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : サービス状況フラグMap.entrySet()) {
            resultサービス状況フラグList.add(new NinteichosahyoServiceJokyoFlag(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .setサービスの状況フラグ(Boolean.getBoolean(entry.getValue().toString())).build()
            );
        }
        return resultサービス状況フラグList;
    }

    private List<NinteichosahyoKinyuItem> 認定調査票_概況調査記入項目の登録処理(dgNinteiChosaData_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString());
        if (row.getServiceJokyoKinyuRemban().isEmpty()) {
            return new ArrayList<>();
        }
        List<RString> 記入項目連番List = row.getServiceJokyoKinyuRemban().split(",");
        List<RString> 記入項目List = row.getServiceJokyoKinyu().split(",");

        Map<RString, RString> 記入項目Map = create連番Map(記入項目連番List, 記入項目List);
        List<NinteichosahyoKinyuItem> result記入項目List = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : 記入項目Map.entrySet()) {
            result記入項目List.add(new NinteichosahyoKinyuItem(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .setサービスの状況記入(entry.getValue()).build()
            );
        }
        return result記入項目List;
    }

    private List<NinteichosahyoShisetsuRiyo> 認定調査票_概況調査施設利用の登録処理(dgNinteiChosaData_Row row) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString());
        if (row.getShisetsuRiyoFlagRemban().isEmpty()) {
            return new ArrayList<>();
        }
        List<RString> 施設利用連番List = row.getShisetsuRiyoFlagRemban().split(",");
        List<RString> 施設利用List = row.getShisetsuRiyoFlag().split(",");

        Map<RString, RString> 施設利用Map = create連番Map(施設利用連番List, 施設利用List);
        List<NinteichosahyoShisetsuRiyo> result施設利用List = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : 施設利用Map.entrySet()) {
            result施設利用List.add(new NinteichosahyoShisetsuRiyo(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .set施設利用フラグ(Boolean.getBoolean(entry.getValue().toString())).build()
            );
        }
        return result施設利用List;
    }

    private List<ChosaKekkaNyuryokuCsvEntity> データ取込_基本調査データ(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile_基本調査データ(csvReader);
    }

    private List<ChosaKekkaNyuryokuCsvEntity> readCsvFile_基本調査データ(CsvReader csvReader) {
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

    private List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> データ取込_概況特記データ(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuGaikyoTokkiCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile_概況特記データ(csvReader);
    }

    private List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> readCsvFile_概況特記データ(CsvReader csvReader) {
        List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ChosaKekkaNyuryokuGaikyoTokkiCsvEntity entity = (ChosaKekkaNyuryokuGaikyoTokkiCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private List<ChosaKekkaNyuryokuTokkiCsvEntity> データ取込_特記情報データ(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuTokkiCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile_特記情報データ(csvReader);
    }

    private List<ChosaKekkaNyuryokuTokkiCsvEntity> readCsvFile_特記情報データ(CsvReader csvReader) {
        List<ChosaKekkaNyuryokuTokkiCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ChosaKekkaNyuryokuTokkiCsvEntity entity = (ChosaKekkaNyuryokuTokkiCsvEntity) csvReader.readLine();
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
