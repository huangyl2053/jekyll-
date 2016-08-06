/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2260001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.DBE2260001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.ImageinputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.TorokuData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.TorokuDataCollection;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.dgshinseishaichiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001.ImageinputHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001.ImageinputValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class Imageinput {

    private static final RString 初期状態_メニューから = new RString("DBEMN32003");
    private static final RString チェックOK = new RString("OK");
    private static final RString チェックNG = new RString("NG");
    private static final RString ファイル名 = new RString("OCRIKEN.CSV");
    private static final int CSV項目数 = 140;

    /**
     * 画面の初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<ImageinputDiv>
     */
    public ResponseData<ImageinputDiv> onLoad(ImageinputDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (初期状態_メニューから.equals(menuID)) {
            return ResponseData.of(div).setState(DBE2260001StateName.初期状態_メニューから);
        } else {
            return ResponseData.of(div).setState(DBE2260001StateName.初期状態_完了処理から);
        }

    }

    /**
     * 「意見書OCRを取込」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ImageinputDiv>
     */
    public ResponseData<ImageinputDiv> onClick_Ikensho(ImageinputDiv div) {
        csvCheck処理(getHandler(div).onClick_Ikensho(), div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ImageinputDiv>
     */
    public ResponseData<ImageinputDiv> onClick_BtnSave(ImageinputDiv div) {
        boolean 選択Flag = false;
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (dgshinseishaichiran_Row row : div.getDgshinseishaichiran().getDataSource()) {
                if (row.getSelected()) {
                    選択Flag = true;
                }
                if (row.getSelected() && チェックNG.equals(row.getOkNg())) {
                    ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                    validationMessages.add(getValidationHandler().check対象を選択());
                    return ResponseData.of(div).addValidationMessages(validationMessages).respond();
                }
            }
            if (!選択Flag) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(getValidationHandler().check一覧対象未選択());
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            db更新(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンを押します。
     *
     * @param div 画面情報
     * @param files ファイル
     * @return ResponseData<ImageinputDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ImageinputDiv> onclick_BtnUpload(ImageinputDiv div, FileData[] files) {
        boolean 選択Flag = false;
        for (dgshinseishaichiran_Row row : div.getDgshinseishaichiran().getDataSource()) {
            if (row.getSelected()) {
                選択Flag = true;
            }
        }
        if (!選択Flag) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(getValidationHandler().check一覧対象未選択());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        for (FileData file : files) {
            save共有フォルダ(div, new FilesystemPath(file.getFilePath()));
        }
        return ResponseData.of(div).respond();
    }

    private void save共有フォルダ(ImageinputDiv div, FilesystemPath path) {
        List<TorokuData> dataList = ViewStateHolder.get(ViewStateKeys.イメージ取込み, TorokuDataCollection.class).getDataList();
        for (TorokuData data : dataList) {
            for (dgshinseishaichiran_Row row : div.getDgshinseishaichiran().getDataSource()) {
                if (row.getHihokenshano().equals(data.get被保険者番号())
                        && row.getNinteishinseiymd().equals(dateFormat(data.get申請日()))
                        && row.getShoKisaiHokenshaNo().equals(data.get保険者番号())
                        && row.getSelected()) {
                    if (data.getT5115_イメージ共有ファイルID() == null) {
                        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName
                                .fromString(data.getT5101_証記載保険者番号().concat(data.getT5101_被保険者番号())));
                        sfd = SharedFile.defineSharedFile(sfd);
                        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
                        SharedFileEntryDescriptor entity = SharedFile.copyToSharedFile(sfd, path, opts);
                        updateDbT5115(new ShinseishoKanriNo(data.getT5101_申請書管理番号()), entity.getSharedFileId());
                    } else {
                        ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                                .fromString(data.getT5101_証記載保険者番号().concat(data.getT5101_被保険者番号())), data.getT5115_イメージ共有ファイルID());
                        SharedFile.appendNewFile(or_sfd, path, "");
                    }
                }
            }
        }
    }

    private void updateDbT5115(ShinseishoKanriNo 申請書管理番号, RDateTime イメージ共有ファイルID) {
        ImageManager mannger = new ImageManager();
        Image image = mannger.getイメージ情報(申請書管理番号);
        if (image == null) {
            image = new Image(申請書管理番号);
            image = image.createBuilderForEdit().setイメージ共有ファイルID(イメージ共有ファイルID).build();
        } else {
            image = image.createBuilderForEdit().setイメージ共有ファイルID(イメージ共有ファイルID).build().modifiedModel();
        }
        mannger.saveイメージ情報(image);
    }

    private void csvCheck処理(List<TorokuData> dataList, ImageinputDiv div) {
        if (dataList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(ファイル名.toString()));
        }
        ImageinputFindler service = ImageinputFindler.createInstance();
        List<TorokuData> dB更新用 = new ArrayList<>();
        for (TorokuData csvData : dataList) {
            ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(csvData.get保険者番号(),
                    csvData.get被保険者番号(),
                    csvData.get申請日());
            if (csvData.get項目数() != CSV項目数) {
                csvData.setOK_NG(チェックNG);
            } else {
                csvData.setOK_NG(チェックOK);
            }
            List<ImageinputResult> 関連データList = service.get関連データ(param).records();
            if (チェックOK.equals(csvData.getOK_NG())) {
                if (関連データList.isEmpty()) {
                    csvData.setOK_NG(チェックNG);
                } else {
                    csvData.setOK_NG(チェックOK);
                }
            }
            for (ImageinputResult 関連データ : 関連データList) {
                csvData.setT5101_厚労省IF識別コード(関連データ.getT5101_厚労省IF識別コード());
                csvData.setT5101_申請書管理番号(関連データ.getT5101_申請書管理番号());
                csvData.setT5101_被保険者氏名(関連データ.getT5101_被保険者氏名());
                csvData.setT5101_被保険者番号(関連データ.getT5101_被保険者番号());
                csvData.setT5101_証記載保険者番号(関連データ.getT5101_証記載保険者番号());
                csvData.setT5101_認定申請年月日(関連データ.getT5101_認定申請年月日());
                csvData.setT5115_イメージ共有ファイルID(関連データ.getT5115_イメージ共有ファイルID());
                csvData.setT5301_主治医コード(関連データ.getT5301_主治医コード());
                csvData.setT5301_主治医医療機関コード(関連データ.getT5301_主治医医療機関コード());
                csvData.setT5301_主治医意見書作成依頼年月日(関連データ.getT5301_主治医意見書作成依頼年月日());
                csvData.setT5301_主治医意見書依頼区分(関連データ.getT5301_主治医意見書依頼区分());
                csvData.setT5911_主治医医療機関コード(関連データ.getT5911_主治医医療機関コード());
                csvData.setT5911_医療機関名称(関連データ.getT5911_医療機関名称());
                csvData.setT5912_主治医コード(関連データ.getT5912_主治医コード());
                csvData.setT5912_主治医氏名(関連データ.getT5912_主治医氏名());
                csvData.setT7051_市町村名称(関連データ.getT7051_市町村名称());
                csvData.setT5301_主治医意見書作成依頼履歴番号(関連データ.getT5301_主治医意見書作成依頼履歴番号());
                dB更新用.add(csvData);
            }
        }
        getHandler(div).set画面一覧(dB更新用);
        TorokuDataCollection collection = new TorokuDataCollection(dB更新用);
        ViewStateHolder.put(ViewStateKeys.イメージ取込み, collection);
    }

    private void db更新(ImageinputDiv div) {
        List<TorokuData> dataList = ViewStateHolder.get(ViewStateKeys.イメージ取込み, TorokuDataCollection.class).getDataList();
        for (dgshinseishaichiran_Row row : div.getDgshinseishaichiran().getDataSource()) {
            if (row.getSelected() && チェックOK.equals(row.getOkNg())) {
                for (TorokuData data : dataList) {
                    if (row.getHihokenshano().equals(data.get被保険者番号())
                            && row.getNinteishinseiymd().equals(dateFormat(data.get申請日()))
                            && row.getShoKisaiHokenshaNo().equals(data.get保険者番号())) {
                        updataDbT5302(div, row, data);
                    }
                }
            }
        }
    }

    private void updataDbT5302(ImageinputDiv div, dgshinseishaichiran_Row row, TorokuData data) {
        ShujiiIkenshoJohoManager manager = ShujiiIkenshoJohoManager.createInstance();
        ShujiiIkenshoJohoMapperParameter dbT5302param = ShujiiIkenshoJohoMapperParameter.createSelectByKeyParam(new ShinseishoKanriNo(
                row.getShinseishoKanriNo()),
                data.getT5301_主治医意見書作成依頼履歴番号());
        ShujiiIkenshoJoho joho = manager.get要介護認定主治医意見書情報(dbT5302param);
        if (joho != null) {
            if (isNotEmpty(data.get記入日())) {
                joho = joho.createBuilderForEdit().set主治医意見書記入年月日(new FlexibleDate(data.get記入日())).build();
            }
            if (isNotEmpty(data.get意見書作成回数())) {
                joho = joho.createBuilderForEdit().set意見書作成回数区分(new Code(data.get意見書作成回数())).build();
            }
            joho = joho.createBuilderForEdit().set意見書同意フラグ(rStringToBeelan(data.get同意の有無())).build();
            if (isNotEmpty(data.get最終診察日())) {
                joho = joho.createBuilderForEdit().set最終診療日(new FlexibleDate(data.get最終診察日())).build();
            }
            joho = joho.createBuilderForEdit().set他科受診の有無(rStringToBeelan(data.get他科受信の有無())).build();
            joho = joho.createBuilderForEdit().set内科受診の有無(rStringToBeelan(data.get内科())).build();
            joho = joho.createBuilderForEdit().set精神科受診の有無(rStringToBeelan(data.get精神科())).build();
            joho = joho.createBuilderForEdit().set外科受診の有無(rStringToBeelan(data.get外科())).build();
            joho = joho.createBuilderForEdit().set整形外科受診の有無(rStringToBeelan(data.get整形外科())).build();
            joho = joho.createBuilderForEdit().set脳神経外科の有無(rStringToBeelan(data.get脳神経外科())).build();
            joho = joho.createBuilderForEdit().set皮膚科受診の有無(rStringToBeelan(data.get皮膚科())).build();
            joho = joho.createBuilderForEdit().set泌尿器科受診の有無(rStringToBeelan(data.get泌尿器科())).build();
            joho = joho.createBuilderForEdit().set婦人科受診の有無(rStringToBeelan(data.get婦人科())).build();
            joho = joho.createBuilderForEdit().set耳鼻咽喉科受診の有無(rStringToBeelan(data.get耳鼻咽喉科())).build();
            joho = joho.createBuilderForEdit().setリハビリテーション科受診の有無(rStringToBeelan(data.getリハビリテーション科())).build();
            joho = joho.createBuilderForEdit().set歯科受診の有無(rStringToBeelan(data.get歯科())).build();
            joho = joho.createBuilderForEdit().set眼科の有無(rStringToBeelan(data.get眼科())).build();
            joho = joho.createBuilderForEdit().setその他受診科の有無(rStringToBeelan(data.getその他())).build();
            joho = joho.createBuilderForEdit().set意見書_発症年月日1(data.get発症年月日1()).build();
            joho = joho.createBuilderForEdit().set意見書_発症年月日2(data.get発症年月日2()).build();
            joho = joho.createBuilderForEdit().set意見書_発症年月日3(data.get発症年月日3()).build();
            joho = joho.createBuilderForEdit().set意見書_症状としての安定性(data.get症状の安定性()).build();
            joho = joho.modifiedModel();
        } else {
            joho = new ShujiiIkenshoJoho(new ShinseishoKanriNo(row.getShinseishoKanriNo()), data.getT5301_主治医意見書作成依頼履歴番号());
            if (!RString.isNullOrEmpty(data.getT5101_厚労省IF識別コード())) {
                joho = joho.createBuilderForEdit().set厚労省IF識別コード(data.getT5101_厚労省IF識別コード()).build();
            }
            joho = joho.createBuilderForEdit().set主治医意見書依頼区分(data.getT5301_主治医意見書依頼区分()).build();
            joho = joho.createBuilderForEdit().set主治医医療機関コード(data.getT5301_主治医医療機関コード()).build();
            joho = joho.createBuilderForEdit().set主治医コード(data.getT5301_主治医コード()).build();
            joho = joho.createBuilderForEdit().set主治医意見書受領年月日(FlexibleDate.getNowDate()).build();
            if (isNotEmpty(data.get記入日())) {
                joho = joho.createBuilderForEdit().set主治医意見書記入年月日(new FlexibleDate(data.get記入日())).build();
            }
            if (isNotEmpty(data.get意見書作成回数())) {
                joho = joho.createBuilderForEdit().set意見書作成回数区分(new Code(data.get意見書作成回数())).build();
            }
            if (data.isT5101_施設入所の有無()) {
                joho = joho.createBuilderForEdit().set在宅_施設区分(new Code(ZaitakuShisetsuKubun.施設.getコード())).build();
            } else {
                joho = joho.createBuilderForEdit().set在宅_施設区分(new Code(ZaitakuShisetsuKubun.在宅.getコード())).build();
            }

            joho = joho.createBuilderForEdit().set意見書同意フラグ(rStringToBeelan(data.get同意の有無())).build();
            if (isNotEmpty(data.get最終診察日())) {
                joho = joho.createBuilderForEdit().set最終診療日(new FlexibleDate(data.get最終診察日())).build();
            }
            joho = joho.createBuilderForEdit().set他科受診の有無(rStringToBeelan(data.get他科受信の有無())).build();
            joho = joho.createBuilderForEdit().set内科受診の有無(rStringToBeelan(data.get内科())).build();
            joho = joho.createBuilderForEdit().set精神科受診の有無(rStringToBeelan(data.get精神科())).build();
            joho = joho.createBuilderForEdit().set外科受診の有無(rStringToBeelan(data.get外科())).build();
            joho = joho.createBuilderForEdit().set整形外科受診の有無(rStringToBeelan(data.get整形外科())).build();
            joho = joho.createBuilderForEdit().set脳神経外科の有無(rStringToBeelan(data.get脳神経外科())).build();
            joho = joho.createBuilderForEdit().set皮膚科受診の有無(rStringToBeelan(data.get皮膚科())).build();
            joho = joho.createBuilderForEdit().set泌尿器科受診の有無(rStringToBeelan(data.get泌尿器科())).build();
            joho = joho.createBuilderForEdit().set婦人科受診の有無(rStringToBeelan(data.get婦人科())).build();
            joho = joho.createBuilderForEdit().set耳鼻咽喉科受診の有無(rStringToBeelan(data.get耳鼻咽喉科())).build();
            joho = joho.createBuilderForEdit().setリハビリテーション科受診の有無(rStringToBeelan(data.getリハビリテーション科())).build();
            joho = joho.createBuilderForEdit().set歯科受診の有無(rStringToBeelan(data.get歯科())).build();
            joho = joho.createBuilderForEdit().set眼科の有無(rStringToBeelan(data.get眼科())).build();
            joho = joho.createBuilderForEdit().setその他受診科の有無(rStringToBeelan(data.getその他())).build();
            joho = joho.createBuilderForEdit().set意見書_発症年月日1(data.get発症年月日1()).build();
            joho = joho.createBuilderForEdit().set意見書_発症年月日2(data.get発症年月日2()).build();
            joho = joho.createBuilderForEdit().set意見書_発症年月日3(data.get発症年月日3()).build();
            joho = joho.createBuilderForEdit().set意見書_症状としての安定性(data.get症状の安定性()).build();
            joho = joho.createBuilderForEdit().set認定審査会後の二次判定結果の連絡確認フラグ(rStringToBeelan(data.get主治医への結果連絡())).build();
        }
        joho = getHandler(div).set項目(joho, row, data);
        manager.save(joho);
    }

    private boolean rStringToBeelan(RString flag) {
        return new RString("1").equals(flag);
    }

    private boolean isNotEmpty(RString data) {
        return !RString.isNullOrEmpty(data);
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().toDateString();
    }

    private ImageinputHandler getHandler(ImageinputDiv div) {
        return new ImageinputHandler(div);
    }

    private ImageinputValidationHandler getValidationHandler() {
        return new ImageinputValidationHandler();
    }
}
