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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.DBE2250001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosadatatorikomi.NinteiChosaDataTorikomiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileSystem;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class Ninteishinseibi {

    private static final RString 概況調査_基本調査データCSV名 = new RString("出力_概況調査_基本調査データ.csv");
    private static final RString 概況特記データCSV名 = new RString("出力_概況特記データ.csv");
    private static final RString 特記情報データCSV名 = new RString("出力_特記情報データ.csv");
    private static final RString 状態_変更 = new RString("変更");
    private static final RString 状態_警告 = new RString("警告");
    private static final RString 必須調査票_パターン2 = new RString("2");
    private static final RString 必須調査票_パターン3 = new RString("3");
    private static final RString WORKFOLDERNAME = new RString("ninteishosaDataTorikomiWork");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * ページロードイベントです。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onLoad(NinteishinseibiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードボタンクリックイベントです。
     *
     * @param div NinteishinseibiDiv
     * @param files FileData
     * @return ResponseData
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<NinteishinseibiDiv> onClick_btnUpload(NinteishinseibiDiv div, FileData[] files) {
        RString outputPath = Directory.createWorkDirectory(WORKFOLDERNAME.toString());
        RString filePath_基本調査データ = RString.EMPTY;
        RString filePath_概況特記データ = RString.EMPTY;
        RString filePath_特記情報データ = RString.EMPTY;
        for (FileData file : files) {
            if (file.getFileName().endsWith(new RString(".zip"))
                    || file.getFileName().endsWith(new RString(".ZIP"))) {
                ZipUtil.extractAllFiles(file.getFilePath(), outputPath);
                filePath_基本調査データ = new RString(FileSystem.searchFilePath(outputPath.toString(), 概況調査_基本調査データCSV名.toString()));
                filePath_概況特記データ = new RString(FileSystem.searchFilePath(outputPath.toString(), 概況特記データCSV名.toString()));
                filePath_特記情報データ = new RString(FileSystem.searchFilePath(outputPath.toString(), 特記情報データCSV名.toString()));
            } else if (file.getFileName().equals(概況調査_基本調査データCSV名)) {
                filePath_基本調査データ = file.getFilePath();
            } else if (file.getFileName().equals(概況特記データCSV名)) {
                filePath_概況特記データ = file.getFilePath();
            } else if (file.getFileName().equals(特記情報データCSV名)) {
                filePath_特記情報データ = file.getFilePath();
            } else {
                Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
                throw new ApplicationException("誤ったCSVが読み込まれています。下記の名称のCSVを読み込んでください。<br>"
                        + 概況調査_基本調査データCSV名.toString() + "<br>" + 概況特記データCSV名.toString() + "<br>" + 特記情報データCSV名.toString());
            }
        }

        RString 認定調査結果入手_必須調査票
                = DbBusinessConfig.get(ConfigNameDBE.認定調査結果入手_必須調査票, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        check必要なCSV取込(filePath_基本調査データ, filePath_概況特記データ, filePath_特記情報データ, 認定調査結果入手_必須調査票);

        List<ChosaKekkaNyuryokuCsvEntity> 基本調査データCsvEntityList = get基本調査データ(filePath_基本調査データ);
        if (基本調査データCsvEntityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("基本調査データ"));
        }

        getHandler(div).set認定調査一覧データグリッド(基本調査データCsvEntityList,
                filePath_概況特記データ, filePath_特記情報データ, 認定調査結果入手_必須調査票);
        Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードの後処理です。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onAfterUploaded(NinteishinseibiDiv div) {
        return ResponseData.of(div).setState(DBE2250001StateName.検索結果表示);
    }

    /**
     * 保存するボタンクリックイベントです。。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onClick_btnSave(NinteishinseibiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message;
            if (getHandler(div).existNGデータ()) {
                message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                        UrQuestionMessages.確認_汎用.getMessage()
                        .replace("状態がNGのデータはエラーの修正を行ってから取り込んでください。<br>NG以外のデータを保存します。")
                        .evaluate());
            } else {
                message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
            }
            return ResponseData.of(div).addMessage(message).respond();

        }

        if ((new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<dgNinteiChosaData_Row> dataSource = div.getDgNinteiChosaData().getDataSource();
            Map<ShinseishoKanriNo, List<NinteichosahyoTokkijiko>> 特記事項Map = DataPassingConverter.deserialize(div.get特記事項Map(), HashMap.class);
            Map<ShinseishoKanriNo, GaikyoTokki> 概況特記事項Map = DataPassingConverter.deserialize(div.get概況特記事項Map(), HashMap.class);
            ShinseishoKanriNo 申請書管理番号;
            int 認定調査依頼履歴番号;
            for (dgNinteiChosaData_Row row : dataSource) {
                if (状態_変更.equals(row.getJyotai()) || 状態_警告.equals(row.getJyotai())) {
                    申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                    認定調査依頼履歴番号 = row.getNinteichosaIraiRirekiNo().getValue().intValue();
                    NinteiChosaDataTorikomiManager.createInstance().save認定調査データ(
                            申請書管理番号,
                            認定調査依頼履歴番号,
                            row.getGaikyoTokkiTextImageKubun(),
                            new Code(GenponMaskKubun.原本.getコード()),
                            特記事項Map.get(申請書管理番号),
                            get概況調査(row, 認定調査依頼履歴番号),
                            概況特記事項Map.get(申請書管理番号),
                            get基本調査(row, div, 認定調査依頼履歴番号),
                            get基本調査調査項目(row, 認定調査依頼履歴番号),
                            get概況調査サービスの状況の登録処理(row, 認定調査依頼履歴番号),
                            get概況調査サービスの状況フラグの登録処理(row, 認定調査依頼履歴番号),
                            get概況調査記入項目の登録処理(row, 認定調査依頼履歴番号),
                            get概況調査施設利用の登録処理(row, 認定調査依頼履歴番号));
                }
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2250001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 取込前に戻るボタンクリックイベントです。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onClick_btnBackInport(NinteishinseibiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBE2250001StateName.初期表示);
    }

    private NinteichosahyoGaikyoChosa get概況調査(dgNinteiChosaData_Row row, int 認定調査依頼履歴番号) {
        NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = new NinteichosahyoGaikyoChosa(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()), 認定調査依頼履歴番号, row.getGaikyoTokkiTextImageKubun());
        NinteichosahyoGaikyoChosaBuilder builder = ninteichosahyoGaikyoChosa.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set認定調査依頼履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set概況調査テキストイメージ区分(TokkijikoTextImageKubun.valueOf(row.
                getGaikyoTokkiTextImageKubun().toString()).getコード());
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set認定調査依頼区分コード(new Code(row.getNinteichousaIraiKubunCode()));
        if (!RString.isNullOrEmpty(row.getNinteichosaIraiKaisu())) {
            builder.set認定調査回数(Integer.valueOf(row.getNinteichosaIraiKaisu().toString()));
        } else {
            builder.set認定調査回数(0);
        }
        builder.set認定調査実施年月日(row.getNinteichosaJisshiYMD().getValue());
        builder.set認定調査受領年月日(row.getNinteichosaJuryoYMD().getValue());
        if (!RString.isNullOrEmpty(row.getNinteiChosaKubunCode())) {
            builder.set認定調査区分コード(new Code(row.getNinteiChosaKubunCode()));
        } else {
            builder.set認定調査区分コード(Code.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getNinteiChosaItakusakiCode())) {
            builder.set認定調査委託先コード(new JigyoshaNo(row.getNinteiChosaItakusakiCode()));
        } else {
            builder.set認定調査委託先コード(JigyoshaNo.EMPTY);
        }
        builder.set認定調査員コード(row.getNinteiChosainCode());
        if (!RString.isNullOrEmpty(row.getChosaJisshiBashoCode())) {
            builder.set認定調査実施場所コード(new Code(row.getChosaJisshiBashoCode()));
        } else {
            builder.set認定調査実施場所コード(Code.EMPTY);
        }
        builder.set認定調査実施場所名称(row.getChosaJisshiBashoMeisho());
        builder.set認定調査_サービス区分コード(new Code(row.getServiceKubunCode()));
        builder.set利用施設名(row.getRiyoShisetsuShimei());
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuJusho())) {
            builder.set利用施設住所(new AtenaJusho(row.getRiyoShisetsuJusho()));
        } else {
            builder.set利用施設住所(AtenaJusho.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuTelNo())) {
            builder.set利用施設電話番号(new TelNo(row.getRiyoShisetsuTelNo()));
        } else {
            builder.set利用施設電話番号(TelNo.EMPTY);
        }
        if (!RString.isNullOrEmpty(row.getRiyoShisetsuYubinNo())) {
            builder.set利用施設郵便番号(new YubinNo(row.getRiyoShisetsuYubinNo()));
        } else {
            builder.set利用施設郵便番号(YubinNo.EMPTY);
        }
        builder.set特記(row.getTokki());
        builder.set認定調査特記事項受付年月日(row.getTokkijikoUketsukeYMD().getValue());
        builder.set認定調査特記事項受領年月日(row.getTokkijikoJuryoYMD().getValue());
        return builder.build();
    }

    private NinteichosahyoKihonChosa get基本調査(dgNinteiChosaData_Row row, NinteishinseibiDiv div, int 認定調査依頼履歴番号) {
        NinteichosahyoKihonChosa ninteichosahyoKihonChosa
                = new NinteichosahyoKihonChosa(new ShinseishoKanriNo(row.getShinseishoKanriNo()), 認定調査依頼履歴番号);
        NinteichosahyoKihonChosaBuilder builder = ninteichosahyoKihonChosa.createBuilderForEdit();
        builder.set申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set要介護認定調査履歴番号(Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set認定調査_認知症高齢者の日常生活自立度コード(new Code(row.getNinchishoNichijoSeikatsuJiritsudoCode()));
        builder.set認定調査_障害高齢者の日常生活自立度コード(new Code(row.getShogaiNichijoSeikatsuJiritsudoCode()));
        return builder.build();
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

    private List<NinteichosahyoChosaItem> get基本調査調査項目(dgNinteiChosaData_Row row, int 認定調査依頼履歴番号) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        List<RString> 調査項目連番List = row.getRemban().split(",");
        List<RString> 調査項目List = row.getResearchItem().split(",");
        if (調査項目連番List.contains(RString.EMPTY)) {
            throw new ApplicationException("調査項目連番に空白が存在します。");
        }

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

    private List<NinteichosahyoServiceJokyo> get概況調査サービスの状況の登録処理(dgNinteiChosaData_Row row, int 認定調査依頼履歴番号) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        List<RString> サービス状況連番List = row.getServiceJokyoRemban().split(",");
        List<RString> 状況List = row.getServiceJokyo().split(",");
        if (サービス状況連番List.contains(RString.EMPTY)) {
            throw new ApplicationException("サービス状況連番に空白が存在します。");
        }

        Map<RString, RString> サービス状況Map = create連番Map(サービス状況連番List, 状況List);
        List<NinteichosahyoServiceJokyo> resultサービス状況List = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : サービス状況Map.entrySet()) {
            int サービスの状況;
            if (RString.isNullOrEmpty(entry.getValue())) {
                サービスの状況 = 0;
            } else {
                サービスの状況 = Integer.valueOf(entry.getValue().toString());
            }
            resultサービス状況List.add(new NinteichosahyoServiceJokyo(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .setサービスの状況(サービスの状況).build()
            );
        }
        return resultサービス状況List;
    }

    private List<NinteichosahyoServiceJokyoFlag> get概況調査サービスの状況フラグの登録処理(dgNinteiChosaData_Row row, int 認定調査依頼履歴番号) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        List<RString> サービス状況フラグ連番List = row.getServiceJokyoFlagRemban().split(",");
        List<RString> 状況フラグList = row.getServiceJokyoFlag().split(",");
        if (サービス状況フラグ連番List.contains(RString.EMPTY)) {
            throw new ApplicationException("サービス状況フラグ連番に空白が存在します。");
        }

        Map<RString, RString> サービス状況フラグMap = create連番Map(サービス状況フラグ連番List, 状況フラグList);
        List<NinteichosahyoServiceJokyoFlag> resultサービス状況フラグList = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : サービス状況フラグMap.entrySet()) {
            boolean サービス状況フラグ;
            if (RString.isNullOrEmpty(entry.getValue())) {
                サービス状況フラグ = false;
            } else {
                サービス状況フラグ = Boolean.parseBoolean(entry.getValue().toString());
            }
            resultサービス状況フラグList.add(new NinteichosahyoServiceJokyoFlag(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .setサービスの状況フラグ(サービス状況フラグ).build()
            );
        }
        return resultサービス状況フラグList;
    }

    private List<NinteichosahyoKinyuItem> get概況調査記入項目の登録処理(dgNinteiChosaData_Row row, int 認定調査依頼履歴番号) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        List<RString> 記入項目連番List = row.getServiceJokyoKinyuRemban().split(",");
        List<RString> 記入項目List = row.getServiceJokyoKinyu().split(",");
        if (記入項目連番List.contains(RString.EMPTY)) {
            throw new ApplicationException("記入項目連番に空白が存在します。");
        }

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

    private List<NinteichosahyoShisetsuRiyo> get概況調査施設利用の登録処理(dgNinteiChosaData_Row row, int 認定調査依頼履歴番号) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
        List<RString> 施設利用連番List = row.getShisetsuRiyoFlagRemban().split(",");
        List<RString> 施設利用List = row.getShisetsuRiyoFlag().split(",");
        if (施設利用連番List.contains(RString.EMPTY)) {
            throw new ApplicationException("施設利用連番に空白が存在します。");
        }

        Map<RString, RString> 施設利用Map = create連番Map(施設利用連番List, 施設利用List);
        List<NinteichosahyoShisetsuRiyo> result施設利用List = new ArrayList<>();
        for (Map.Entry<RString, RString> entry : 施設利用Map.entrySet()) {
            boolean 施設利用フラグ;
            if (RString.isNullOrEmpty(entry.getValue())) {
                施設利用フラグ = false;
            } else {
                施設利用フラグ = Boolean.getBoolean(entry.getValue().toString());
            }
            result施設利用List.add(new NinteichosahyoShisetsuRiyo(
                    申請書管理番号,
                    認定調査依頼履歴番号,
                    Integer.valueOf(entry.getKey().toString()))
                    .createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                    .set施設利用フラグ(施設利用フラグ).build()
            );
        }
        return result施設利用List;
    }

    private List<ChosaKekkaNyuryokuCsvEntity> get基本調査データ(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEncode(Encode.SJIS)
                .hasHeader(false)
                .setNewLine(NewLine.CRLF)
                .build();
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

    private void check必要なCSV取込(RString filePath_基本調査データ, RString filePath_概況特記データ,
            RString filePath_特記情報データ, RString 認定調査結果入手_必須調査票) {
        if (必須調査票_パターン2.equals(認定調査結果入手_必須調査票)) {
            if (filePath_基本調査データ.isEmpty() || filePath_特記情報データ.isEmpty()) {
                Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
                throw new ApplicationException("以下の２ファイルを同時に取込んでください。<br>"
                        + 概況調査_基本調査データCSV名.toString() + "<br>" + 特記情報データCSV名.toString());
            }
        } else if (必須調査票_パターン3.equals(認定調査結果入手_必須調査票)) {
            if (filePath_基本調査データ.isEmpty() || filePath_概況特記データ.isEmpty() || filePath_特記情報データ.isEmpty()) {
                Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
                throw new ApplicationException("以下の３ファイルを同時に取込んでください。<br>"
                        + 概況調査_基本調査データCSV名.toString() + "<br>" + 概況特記データCSV名.toString() + "<br>" + 特記情報データCSV名.toString());
            }
        } else {
            if (filePath_基本調査データ.isEmpty()) {
                Directory.deleteWorkDirectory(WORKFOLDERNAME.toString());
                throw new ApplicationException(概況調査_基本調査データCSV名.toString() + "を取込んでください。");
            }
        }
    }

    private NinteishinseibiHandler getHandler(NinteishinseibiDiv div) {
        return new NinteishinseibiHandler(div);
    }
}
