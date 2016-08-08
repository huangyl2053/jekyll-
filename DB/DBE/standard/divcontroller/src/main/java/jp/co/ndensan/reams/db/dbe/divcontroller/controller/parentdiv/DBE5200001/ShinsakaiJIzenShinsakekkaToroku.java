/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.DBE5200001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaikekkaIchiranInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenShinsakekkaIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会委員事前審査結果登録の画面処理クラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenShinsakekkaToroku {

    private final RString 出力名 = new RString("JizenShinsaKekka");
    private final RString 下線 = new RString("_");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_TAIPU = new RString(".csv");
    private static final int ZERO = 0;
    private boolean 終了フラグ = true;

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiJIzenShinsakekkaTorokuDiv>
     */
    public ResponseData<ShinsakaiJIzenShinsakekkaTorokuDiv> onLoad(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        getHandler(div).set事前審査会用結果(ShinsakaiJIzenShinsakekkaIchiranFinder.createInstance()
                .get事前審査会用結果(ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class)).records());
        getHandler(div).set事前審査結果(ShinsakaiJIzenShinsakekkaIchiranFinder.createInstance().
                get事前審査結果(ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class)).records());
        return ResponseData.of(div).respond();
    }

    /**
     * 事前審査結果取込を実行する
     *
     * @param requestDiv 画面情報
     * @return ResponseData<ShinsakaiJIzenShinsakekkaTorokuDiv>
     */
    public ResponseData onclick_btnGetResult(ShinsakaiJIzenShinsakekkaTorokuDiv requestDiv) {

        List<RString> 審査員 = ShinsakaiJIzenShinsakekkaIchiranFinder.createInstance().
                get審査員(ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class)).records();
        List<RString> fileName = setFileName(ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class), 審査員);
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv)
                .入力チェック_btnGetResult(new RStringBuilder(Path.getTmpDirectoryPath()), fileName);
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (RString name : fileName) {
                List<ShinsakaikekkaIchiranInputCsvEntity> csvEntityList = モバイルデータ取込(name);
                if (csvEntityList.size() == ZERO) {
                    return ResponseData.of(requestDiv).addMessage(UrErrorMessages.対象ファイルが存在しない.getMessage().replace(name.toString())).respond();
                }
                if (!getHandler(requestDiv).onclick_btnGetResult(csvEntityList)) {
                    終了フラグ = false;
                }
            }
            if (終了フラグ) {
                return ResponseData.of(requestDiv).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace("事前審査結果登録")).respond();
            }
        }
        return onLoad(requestDiv);
    }

    /**
     * 一覧へ戻る
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onclick_btnBack(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.審査会開催番号, ViewStateHolder.get(ViewStateKeys.審査会開催番号, RString.class));
        return ResponseData.of(div).forwardWithEventName(DBE5200001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 事前審査結果一覧を実行する
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onclick_btnToBeforeDocument(ShinsakaiJIzenShinsakekkaTorokuDiv div) {

        if (div.getPublicationResult().getDgBeforeShinsakaiResult().getDataSource().isEmpty()) {
            ShinsakaiJizenshinsakekkaIchiranBatchParameter paramter = new ShinsakaiJizenshinsakekkaIchiranBatchParameter(div
                    .getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().getValue());
            return ResponseData.of(paramter).respond();
        } else {
            ShinsakaiJizenshinsakekkaIchiranBatchParameter paramter = new ShinsakaiJizenshinsakekkaIchiranBatchParameter(div
                    .getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().getValue());
            return ResponseData.of(paramter).respond();
        }

    }

    private List<ShinsakaikekkaIchiranInputCsvEntity> モバイルデータ取込(RString fileName) {
        RString pathName = Path.getTmpDirectoryPath();
        RString filePath = Path.combinePath(pathName, fileName);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, ShinsakaikekkaIchiranInputCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).hasHeader(false)
                .setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader);
    }

    private List<ShinsakaikekkaIchiranInputCsvEntity> readCsvFile(CsvReader csvReader) {
        List<ShinsakaikekkaIchiranInputCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ShinsakaikekkaIchiranInputCsvEntity entity = (ShinsakaikekkaIchiranInputCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private List<RString> setFileName(RString 審査会番号, List<RString> 審査会委員コードリスト) {
        List<RString> fileNameList = new ArrayList();
        for (RString 審査会委員コード : 審査会委員コードリスト) {
            fileNameList.add(new RStringBuilder(出力名).append(下線).append(審査会番号).append(下線)
                    .append(審査会委員コード).append(CSV_TAIPU).toRString());
        }
        return fileNameList;
    }

    private ShinsakaiJIzenShinsakekkaTorokuValidationHandler getValidationHandler(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        return new ShinsakaiJIzenShinsakekkaTorokuValidationHandler(div);
    }

    private ShinsakaiJIzenShinsakekkaTorokuHandler getHandler(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        return new ShinsakaiJIzenShinsakekkaTorokuHandler(div);
    }
}
