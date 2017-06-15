/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.ShujiiIkenshoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書登録の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public class ShujiiIkenshoTorokuHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_NAIKA = new RString("key0");
    private static final RString SELECT_SEISHINKA = new RString("key1");
    private static final RString SELECT_GEKA = new RString("key2");
    private static final RString SELECT_SEIKEIGEKA = new RString("key3");
    private static final RString SELECT_NOSHINKEIGEKA = new RString("key4");
    private static final RString SELECT_HIFUKA = new RString("key5");
    private static final RString SELECT_HINYOKIKA = new RString("key6");
    private static final RString SELECT_FUJINKA = new RString("key7");
    private static final RString SELECT_GANKA = new RString("key8");
    private static final RString SELECT_JIBIINKOKA = new RString("key9");
    private static final RString SELECT_REHABIRITATIONKA = new RString("key10");
    private static final RString SELECT_SHIKA = new RString("key11");
    private final ShujiiIkenshoTorokuTotalDiv div;
    private static final RString 連絡不要 = new RString("key0");
    private static final RString 連絡必要 = new RString("key1");
    private static final RString 確認メッセージ出力要 = new RString("1");
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージファイルが存在区分_マスキング有 = new RString("2");
    private static final RString イメージファイル原本名 = new RString("_BAK");
    private static final RString イメージファイル拡張子 = new RString(".png");

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書登録Div
     */
    public ShujiiIkenshoTorokuHandler(ShujiiIkenshoTorokuTotalDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書登録の設定します。
     *
     * @param result 画面のデータ
     */
    public void load(ShujiiIkenshoTorokuResult result) {
        div.getRadDoi().setSelectedKey(result.is意見書同意フラグ() ? SELECT_KEY0 : SELECT_KEY1);
        div.getIkenshoKihonJoho().getTxtShujiiCode().setValue(isEmptyOrNull(result.get主治医コード()));
        div.getIkenshoKihonJoho().getTxtSujiiName().setValue(isEmptyOrNull(result.get主治医氏名()));
        div.getTxtKinyuYMD().setValue(flexToRdate(result.get主治医意見書記入年月日()));
        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanCode().setValue(isEmptyOrNull(result.get医療機関コード()));
        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().setValue(isEmptyOrNull(result.get医療機関名称()));
        div.getTxtShujiiIryoKikanShozaichi().setDomain(new AtenaJusho(isEmptyOrNull(result.get住所())));
        div.getTxtShujiiIryoKikanTelNumber().setDomain(result.get電話番号() == null ? TelNo.EMPTY : result.get電話番号());
        div.getTxtShujiiIryoKikanFaxNumber().setDomain(result.getFAX番号() == null ? TelNo.EMPTY : result.getFAX番号());
        div.getTxtSaishuShinryoYMD().setValue(flexToRdate(result.get最終診察日()));

        SakuseiryoSeikyuKubun sakuseiryoSeikyuKubun = result.get作成料請求区分();
        IkenshoSakuseiKaisuKubun sakuseiKaisuKubun = result.get意見書作成回数区分();
        if (sakuseiKaisuKubun != null) {
            div.getRadIkenshoSakuseiKaisu().setSelectedKey(
                    IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(sakuseiKaisuKubun.getコード())
                    ? SELECT_KEY1 : SELECT_KEY0);
        } else if (sakuseiryoSeikyuKubun != null) {
            div.getRadIkenshoSakuseiKaisu().setSelectedKey(
                    IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(sakuseiryoSeikyuKubun.as作成回数区分().getコード())
                    ? SELECT_KEY1 : SELECT_KEY0);
        }
        ZaitakuShisetsuKubun zaitakuShisetsuKubun = result.get在宅施設区分();
        if (zaitakuShisetsuKubun != null) {
            div.getRadZaitakuShisetsuKubun().setSelectedKey(zaitakuShisetsuKubun.getコード());
        } else if (sakuseiryoSeikyuKubun != null) {
            div.getRadZaitakuShisetsuKubun().setSelectedKey(sakuseiryoSeikyuKubun.as在宅施設区分().getコード());
        }

        div.getRadTakaShinryo().setSelectedKey(result.is他科受診の有無() ? SELECT_KEY0 : SELECT_KEY1);
        setChkTakaJushin(result);
        List<RString> selKeysList = new ArrayList<>();
        if (result.isその他受診科の有無()) {
            selKeysList.add(SELECT_KEY0);
        }
        div.getChkSonota().setSelectedItemsByKey(selKeysList);
        div.getTxtSonotaNyuryoku().setValue(isEmptyOrNull(result.getその他受診科名()));
        div.getTxtShujiiMemo().setValue(isEmptyOrNull(result.getメモ()));
        if (result.is連絡確認の有無()) {
            div.getRadShujiiRenraku().setSelectedKey(連絡必要);
        } else {
            div.getRadShujiiRenraku().setSelectedKey(連絡不要);
        }
        setShujiiJohoDisable(true);
        setChosaTishoJohoDisable(!result.is他科受診の有無());
        setSonotaDisable(!result.isその他受診科の有無());
    }

    /**
     * 編集前のデータを取得します。
     *
     * @return RString 画面のデータ
     */
    public RString getDataRString() {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(div.getRadDoi().getSelectedValue());
        rsb.append(div.getTxtSaishuShinryoYMD().getValue() == null
                ? RString.EMPTY : div.getTxtSaishuShinryoYMD().getValue().toDateString());
        rsb.append(div.getRadIkenshoSakuseiKaisu().getSelectedKey());
        rsb.append(div.getRadTakaShinryo().getSelectedKey());
        for (RString selKey : div.getChkTakaJushinSelect().getSelectedKeys()) {
            rsb.append(selKey);
        }
        for (RString selKey : div.getChkSonota().getSelectedKeys()) {
            rsb.append(selKey);
        }
        rsb.append(div.getTxtSonotaNyuryoku().getValue());
        rsb.append(div.getTxtKinyuYMD().getValue());
        rsb.append(div.getTxtShujiiMemo().getValue());
        rsb.append(div.getRadShujiiRenraku().getSelectedKey());
        rsb.append(div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().getValue());
        rsb.append(div.getIkenshoKihonJoho().getTxtSujiiName().getValue());
        return rsb.toRString();
    }

    /**
     * チェック変更した際の選択項目により、他科診療チェックボックスを変更可能にします。
     *
     * @param takaFlag 他科診療有無フラグ
     */
    public void setChosaTishoJohoDisable(boolean takaFlag) {
        div.getChkTakaJushinSelect().setDisabled(takaFlag);
        div.getChkSonota().setDisabled(takaFlag);
        div.getTxtSonotaNyuryoku().setDisabled(takaFlag);
        List<RString> selKeysList = new ArrayList<>();
        if (takaFlag) {
            div.getChkTakaJushinSelect().setSelectedItemsByKey(selKeysList);
            div.getChkSonota().setSelectedItemsByKey(selKeysList);
            div.getTxtSonotaNyuryoku().clearValue();
        }
    }

    /**
     * チェック変更した際の選択項目により、その他チェックボックスを変更可能にします。
     *
     * @param sonotaFlag その他フラグ
     */
    public void setSonotaDisable(boolean sonotaFlag) {
        div.getTxtSonotaNyuryoku().setDisabled(sonotaFlag);
        if (sonotaFlag) {
            div.getTxtSonotaNyuryoku().clearValue();
        }
    }

    private void setShujiiJohoDisable(boolean flag) {
        div.getIkenshoKihonJoho().getTxtShujiiIryoKikanMei().setDisabled(flag);
        div.getTxtShujiiIryoKikanShozaichi().setDisabled(flag);
        div.getTxtShujiiIryoKikanTelNumber().setDisabled(flag);
        div.getTxtShujiiIryoKikanFaxNumber().setDisabled(flag);
    }

    public void setChkTakaJushin(ShujiiIkenshoTorokuResult result) {
        List<RString> selKeysList = new ArrayList<>();
        if (result.is内科受診の有無()) {
            selKeysList.add(SELECT_NAIKA);
        }
        if (result.is精神科受診の有無()) {
            selKeysList.add(SELECT_SEISHINKA);
        }
        if (result.is外科受診の有無()) {
            selKeysList.add(SELECT_GEKA);
        }
        if (result.is整形外科受診の有無()) {
            selKeysList.add(SELECT_SEIKEIGEKA);
        }
        if (result.is脳神経外科受診の有無()) {
            selKeysList.add(SELECT_NOSHINKEIGEKA);
        }
        if (result.is皮膚科受診の有無()) {
            selKeysList.add(SELECT_HIFUKA);
        }
        if (result.is泌尿器科受診の有無()) {
            selKeysList.add(SELECT_HINYOKIKA);
        }
        if (result.is婦人科受診の有無()) {
            selKeysList.add(SELECT_FUJINKA);
        }
        if (result.is眼科受診の有無()) {
            selKeysList.add(SELECT_GANKA);
        }
        if (result.is耳鼻咽喉科受診の有無()) {
            selKeysList.add(SELECT_JIBIINKOKA);
        }
        if (result.isﾘﾊﾋﾞﾘﾃｰｼｮﾝ科受診の有無()) {
            selKeysList.add(SELECT_REHABIRITATIONKA);
        }
        if (result.is歯科受診の有無()) {
            selKeysList.add(SELECT_SHIKA);
        }
        div.getChkTakaJushinSelect().setSelectedItemsByKey(selKeysList);
    }

    private RString isEmptyOrNull(RString rstr) {
        if (RString.isNullOrEmpty(rstr)) {
            return RString.EMPTY;
        }
        return rstr;
    }

    private RDate flexToRdate(FlexibleDate fromDate) {
        if (fromDate == null || fromDate.isEmpty()) {
            return null;
        }
        return new RDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     */
    public void 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().set主治医意見書登録完了年月日(null).build();
        ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit().setマスキング完了年月日(null).build();
        IkenshogetManager.createInstance().要介護認定完了情報更新(ninteiKanryoJoho);
    }

    /**
     * 「削除」ボタンを押下する場合、主治医意見書のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @param 確認メッセージ出力区分 確認メッセージ出力区分
     * @return イメージファイルが存在区分
     */
    public RString get主治医意見書のイメージファイルが存在区分(List<RString> 存在したイメージファイル名,
            RString 確認メッセージ出力区分) {
        boolean isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getOpinionTeikeigaiImageFileList_ALL(), 存在したイメージファイル名);
        if (isNotExistsImageFile) {
            isNotExistsImageFile = !isExistsImageFileList(ImageFileItem.getOpinionTeikeiImageFileList_ALL(), 存在したイメージファイル名);
        }
        if (isNotExistsImageFile) {
            return イメージファイルが存在区分_存在しない;
        }
        if (確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            return イメージファイルが存在区分_マスキング有;
        }
        if (isExistsMaskImageFileList(ImageFileItem.getOpinionImageFileList_Mask(), 存在したイメージファイル名)) {
            return イメージファイルが存在区分_マスキング有;
        }
        return RString.EMPTY;
    }

    public void deleteOpinionImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        if (isMaskOnly) {
            List<RString> opinionMaskImageFileList = ImageFileItem.getOpinionImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, opinionMaskImageFileList, deleteImageFileList);
        } else {
            List<RString> teikeigaiOpinionImageFileList = ImageFileItem.getOpinionTeikeigaiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, teikeigaiOpinionImageFileList, deleteImageFileList);

            List<RString> teikeiOpinionImageFileList = ImageFileItem.getOpinionTeikeiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, teikeiOpinionImageFileList, deleteImageFileList);
        }
    }

    public void deleteGaikyoChosaImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        if (isMaskOnly) {
            List<RString> gaikyoChosaMaskImageFileList = ImageFileItem.getGaikyoChosaImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, gaikyoChosaMaskImageFileList, deleteImageFileList);

            List<RString> tokkiJikoMaskImageList = ImageFileItem.getChosahyoTokkiImageFileList_Mask();
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, tokkiJikoMaskImageList, deleteImageFileList);
        } else {
            List<RString> gaikyoChosaImageList = ImageFileItem.getGaikyoChosaImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, gaikyoChosaImageList, deleteImageFileList);

            List<RString> tokkiJikoImageList = ImageFileItem.getChosahyoTokkiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, tokkiJikoImageList, deleteImageFileList);
        }
    }

    public void deleteGaikyoTokkiImageFile(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteImageFileList,
            boolean isMaskOnly) {
        if (!isMaskOnly) {
            List<RString> gaikyoTokkiImageList = ImageFileItem.getGaikyoTokkiImageFileList_ALL();
            deleteAllSharedFileInEntry(descriptor, gaikyoTokkiImageList, deleteImageFileList);
        }
    }

    private void deleteAllSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteTargetImageFileList,
            List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (isExistsImageFile(deleteTargetImageFile, deleteImageFileList)) {
                SharedFile.deleteFileInEntry(descriptor, deleteTargetImageFile.concat(イメージファイル拡張子).toString());
            }
        }
    }

    private void deleteMaskSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteTargetImageFileList, List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (isExistsMaskImageFile(deleteTargetImageFile, deleteImageFileList)) {
                appendNewImageFile(descriptor, localCopyPath,
                        deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子));
                SharedFile.deleteFileInEntry(descriptor,
                        deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子).toString());
            }
        }
    }

    private void appendNewImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath, RString targetImageFile) {
        if (Directory.exists(Path.combinePath(localCopyPath, targetImageFile))) {
            boolean options = true;
            RString afterReNameImageFile = reName(targetImageFile);
            File.move(Path.combinePath(localCopyPath, targetImageFile), Path.combinePath(localCopyPath, afterReNameImageFile), options);
            SharedAppendOption option = new SharedAppendOption();
            option.overWrite(true);
            SharedFile.appendNewFile(descriptor, new FilesystemPath(Path.combinePath(localCopyPath, afterReNameImageFile)),
                    "", option);
        }
    }

    private RString reName(RString targetName) {
        RString reNameTargetName = targetName.replace("_BAK", "");
        return reNameTargetName;
    }

    private boolean isExistsMaskImageFileList(List<RString> ファイル名リスト, List<RString> 存在したイメージファイル名) {
        for (RString ファイル名 : ファイル名リスト) {
            if (isExistsMaskImageFile(ファイル名, 存在したイメージファイル名)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistsImageFileList(List<RString> ファイル名リスト, List<RString> 存在したイメージファイル名) {
        for (RString ファイル名 : ファイル名リスト) {
            if (isExistsImageFile(ファイル名, 存在したイメージファイル名)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistsImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistsMaskImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名.concat(イメージファイル原本名))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 対象者一覧を更新します。また、一次判定結果にエラーが出なかったデータのみ、ViewState上のデータも合わせて更新します。
     *
     * @param kekkaList 一次判定処理結果List
     */
    public void updateGridAndViewStateData(List<IchijiHanteiShoriKekka> kekkaList) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        List<RString> shinseishoKanriNoList = new ArrayList<>();
        shinseishoKanriNoList.add(申請書管理番号.value());
        IChiJiPanTeiSyoRiParameter parameter = IChiJiPanTeiSyoRiParameter.
                createParameterOf一次判定完了処理(
                        ShoKisaiHokenshaNo.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        Decimal.ZERO,
                        RString.EMPTY,
                        shinseishoKanriNoList,
                        RString.EMPTY);
        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
        List<IchijiHanteiKekkaJoho> kekkaJohoList = manager.get一次判定結果情報_調査結果(parameter).records();
        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models;
        if (!kekkaJohoList.isEmpty()) {
            models = Models.create(kekkaJohoList);
        } else {
            models = Models.create(new ArrayList<IchijiHanteiKekkaJoho>());
        }
        IchijiHanteiShoriKekka kekka = getKekka(kekkaList, 申請書管理番号);

        if (!kekka.isError()) {
            IchijiHanteiKekkaJoho joho = models.get(kekka.getHanteiKekka().identifier());
            if (joho == null) {
                models.add(get一次判定結果情報_仮一次判定区分編集(kekka.getHanteiKekka()));
            } else {
                joho = updateIchijiHanteiKekkaJoho(joho, get一次判定結果情報_仮一次判定区分編集(kekka.getHanteiKekka()));
                models.add(joho);
            }
        }

        List<IchijiHanteiKekkaJoho> torokuTaishoList = new ArrayList<>();
        torokuTaishoList.addAll(models.values());
        manager.save要介護認定一次判定結果情報List(torokuTaishoList);
    }

    private IchijiHanteiShoriKekka getKekka(List<IchijiHanteiShoriKekka> kekkaList, ShinseishoKanriNo shinseishoKanriNo) {
        for (IchijiHanteiShoriKekka kekka : kekkaList) {
            if (kekka.getShinseishoKanriNo().equals(shinseishoKanriNo)) {
                return kekka;
            }
        }
        return null;
    }

    private IchijiHanteiKekkaJoho get一次判定結果情報_仮一次判定区分編集(IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class));
        DbT5105NinteiKanryoJohoDac dbt5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        DbT5105NinteiKanryoJohoEntity entity = dbt5105Dac.selectByShinseishoKanriNo(申請書管理番号);
        IchijiHanteiKekkaJohoBuilder builder = ichijiHanteiKekkaJoho.createBuilderForEdit();
        if (entity != null) {
            if (entity.getNinteichosaKanryoYMD() == null || entity.getIkenshoTorokuKanryoYMD() == null) {
                builder.set仮一次判定区分(Boolean.TRUE);
            } else {
                builder.set仮一次判定区分(Boolean.FALSE);
            }
        } else {
            builder.set仮一次判定区分(Boolean.TRUE);
        }
        return builder.build();
    }

    private IchijiHanteiKekkaJoho updateIchijiHanteiKekkaJoho(IchijiHanteiKekkaJoho original, IchijiHanteiKekkaJoho updateData) {

        IchijiHanteiKekkaJohoBuilder builder = original.createBuilderForEdit();
        builder.set仮一次判定区分(updateData.get仮一次判定区分());
        builder.set要介護認定一次判定年月日(new FlexibleDate(RDate.getNowDate().toDateString()));

        builder.set要介護認定一次判定結果コード(updateData.get要介護認定一次判定結果コード());
        builder.set要介護認定一次判定結果コード_認知症加算(updateData.get要介護認定一次判定結果コード_認知症加算());
        builder.set要介護認定一次判定警告コード(updateData.get要介護認定一次判定警告コード());

        builder.set要介護認定等基準時間(updateData.get要介護認定等基準時間());
        builder.set要介護認定等基準時間_食事(updateData.get要介護認定等基準時間_食事());
        builder.set要介護認定等基準時間_排泄(updateData.get要介護認定等基準時間_排泄());
        builder.set要介護認定等基準時間_移動(updateData.get要介護認定等基準時間_移動());
        builder.set要介護認定等基準時間_清潔保持(updateData.get要介護認定等基準時間_清潔保持());
        builder.set要介護認定等基準時間_間接ケア(updateData.get要介護認定等基準時間_間接ケア());
        builder.set要介護認定等基準時間_BPSD関連(updateData.get要介護認定等基準時間_BPSD関連());
        builder.set要介護認定等基準時間_機能訓練(updateData.get要介護認定等基準時間_機能訓練());
        builder.set要介護認定等基準時間_医療関連(updateData.get要介護認定等基準時間_医療関連());
        builder.set要介護認定等基準時間_認知症加算(updateData.get要介護認定等基準時間_認知症加算());
        builder.set中間評価項目得点第1群(updateData.get中間評価項目得点第1群());
        builder.set中間評価項目得点第2群(updateData.get中間評価項目得点第2群());
        builder.set中間評価項目得点第3群(updateData.get中間評価項目得点第3群());
        builder.set中間評価項目得点第4群(updateData.get中間評価項目得点第4群());
        builder.set中間評価項目得点第5群(updateData.get中間評価項目得点第5群());
        builder.set中間評価項目得点第6群(updateData.get中間評価項目得点第6群());
        builder.set中間評価項目得点第7群(updateData.get中間評価項目得点第7群());

        builder.set要介護認定状態の安定性コード(updateData.get要介護認定状態の安定性コード());
        builder.set認知症自立度Ⅱ以上の蓋然性(updateData.get認知症自立度Ⅱ以上の蓋然性());
        builder.set認知機能及び状態安定性から推定される給付区分コード(updateData.get認知機能及び状態安定性から推定される給付区分コード());

        builder.set運動能力の低下していない認知症高齢者の指標コード(Code.EMPTY);
        builder.set日常生活自立度の組み合わせ_自立(0);
        builder.set日常生活自立度の組み合わせ_要支援(0);
        builder.set日常生活自立度の組み合わせ_要介護１(0);
        builder.set日常生活自立度の組み合わせ_要介護２(0);
        builder.set日常生活自立度の組み合わせ_要介護３(0);
        builder.set日常生活自立度の組み合わせ_要介護４(0);
        builder.set日常生活自立度の組み合わせ_要介護５(0);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価コード(Code.EMPTY);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価(0);
        builder.set一次判定結果送付区分(RString.EMPTY);
        builder.set一次判定結果送付年月日(FlexibleDate.EMPTY);
        builder.setチャート(RString.EMPTY);
        builder.set状態像(RString.EMPTY);

        return builder.build();
    }
}
