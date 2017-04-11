/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5200001;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526001.DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.DBE5200001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaikekkaIchiranInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenShinsakekkaIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会委員事前審査結果登録の画面処理クラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenShinsakekkaToroku {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 事前審査結果 = new RString("事前審査結果を上書きしても");

    private enum ViewStateKeysDBE5200001 {

        ファイルs(ArrayList.class);

        private ViewStateKeysDBE5200001(Class<?> type) {
        }
    }

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData<ShinsakaiJIzenShinsakekkaTorokuDiv> onLoad(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        RString kaisaiNo = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        if (!RString.isNullOrEmpty(kaisaiNo)) {
            getHandler(div).set事前審査会用結果(ShinsakaiJIzenShinsakekkaIchiranFinder.createInstance()
                    .get事前審査会用結果(kaisaiNo).records());
            getHandler(div).set事前審査結果(ShinsakaiJIzenShinsakekkaIchiranFinder.createInstance().
                    get事前審査結果(kaisaiNo).records());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 事前審査結果取込を実行する
     *
     * @param div 画面情報
     * @param fileData ファイルs
     * @return ResponseData
     */
    public ResponseData onclick_btnGetResult(ShinsakaiJIzenShinsakekkaTorokuDiv div, FileData[] fileData) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().replace(事前審査結果.toString()).getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace(事前審査結果.toString()).evaluate());
            ValidationMessageControlPairs vallidation = getValidationHandler(div)
                    .validateUploadedFiles(fileData, ViewStateHolder.get(ViewStateKeys.開催番号, RString.class));
            if (vallidation.existsError()) {
                return ResponseData.of(div).addValidationMessages(vallidation).respond();
            }
            ViewStateHolder.remove(ViewStateKeysDBE5200001.ファイルs);
            ViewStateHolder.put(ViewStateKeysDBE5200001.ファイルs, toFiles(fileData));
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.確認_汎用.getMessage().replace(事前審査結果.toString()).getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<File> files = ViewStateHolder.get(ViewStateKeysDBE5200001.ファイルs, ArrayList.class);
            Map<String, List<ShinsakaikekkaIchiranInputCsvEntity>> parsed = new HashMap<>();
            for (File file : files) {
                parsed.put(file.getName(), モバイルデータ取込(file.getPath()));
            }
            ValidationMessageControlPairs vallidations = getValidationHandler(div).ヌルチェック_btnGetResult(parsed);
            if (vallidations.existsError()) {
                return ResponseData.of(div).addValidationMessages(vallidations).respond();
            }

            boolean notExsitsError = true;
            for (List<ShinsakaikekkaIchiranInputCsvEntity> result : parsed.values()) {
                if (!getHandler(div).onclick_btnGetResult(result)) {
                    notExsitsError = false;
                }
            }
            if (notExsitsError) {
                return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage()
                        .replace("事前審査結果登録")).respond();
            }
        }
        return onLoad(div);
    }

    private static ArrayList<File> toFiles(FileData[] fileData) {
        ArrayList<File> list = new ArrayList<>();
        for (FileData f : fileData) {
            list.add(new File(f.getFilePath().toString()));
        }
        return list;
    }

    private List<ShinsakaikekkaIchiranInputCsvEntity> モバイルデータ取込(String filePath) {
        return readCsvFileBy(new CsvReader.InstanceBuilder(new RString(filePath), ShinsakaikekkaIchiranInputCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEncode(Encode.SJIS)
                .hasHeader(false)
                .setNewLine(NewLine.CRLF)
                .build()
        );
    }

    private List<ShinsakaikekkaIchiranInputCsvEntity> readCsvFileBy(CsvReader<ShinsakaikekkaIchiranInputCsvEntity> csvReader) {
        List<ShinsakaikekkaIchiranInputCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ShinsakaikekkaIchiranInputCsvEntity entity = csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    /**
     * 一覧へ戻る
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onclick_btnBack(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
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
            DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter paramter = new DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter(
                    ViewStateHolder.get(ViewStateKeys.開催番号, RString.class));
            return ResponseData.of(paramter).respond();
        } else {
            DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter paramter = new DBE526001_ShinsakaiJIzenShinsakekkaIchiranParameter(div
                    .getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().getValue());
            return ResponseData.of(paramter).respond();
        }
    }

    private ShinsakaiJIzenShinsakekkaTorokuValidationHandler getValidationHandler(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        return new ShinsakaiJIzenShinsakekkaTorokuValidationHandler(div);
    }

    private ShinsakaiJIzenShinsakekkaTorokuHandler getHandler(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        return new ShinsakaiJIzenShinsakekkaTorokuHandler(div);
    }
}
