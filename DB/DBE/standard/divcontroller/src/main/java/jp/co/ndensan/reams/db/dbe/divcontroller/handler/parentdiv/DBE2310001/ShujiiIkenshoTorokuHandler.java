/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2310001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001.ShujiiIkenshoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoget.IkenshogetManager;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
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
        if (result.get意見書作成回数区分() != null) {
            div.getRadIkenshoSakuseiKaisu().setSelectedKey(
                    IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(result.get意見書作成回数区分().value())
                    ? SELECT_KEY1 : SELECT_KEY0);
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

}
