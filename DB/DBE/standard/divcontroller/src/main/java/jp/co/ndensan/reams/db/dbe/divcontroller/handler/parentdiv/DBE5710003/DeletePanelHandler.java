/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定イメージ情報削除のHandlerクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public class DeletePanelHandler {

    private static final RString 確認メッセージ出力要 = new RString("1");
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージファイルが存在区分_マスキング有 = new RString("2");
    private static final RString イメージファイル原本名 = new RString("_BAK");
    private static final RString イメージファイル拡張子 = new RString(".png");

    /**
     * コンストラクタです。
     *
     */
    public DeletePanelHandler() {
    }

    /**
     * 「削除」ボタンを押下する場合、調査票特記のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @param 確認メッセージ出力区分 確認メッセージ出力区分
     * @return イメージファイルが存在区分
     */
    public RString get調査票特記のイメージファイルが存在区分(List<RString> 存在したイメージファイル名, RString 確認メッセージ出力区分) {
        RString イメージファイルが存在区分 = RString.EMPTY;
        List<RString> 調査票概況特記イメージ = get調査票概況特記イメージ();
        List<RString> 調査票特記イメージ = get調査票特記イメージ();
        boolean isNotExistsImageFile = true;
        for (RString ファイル名 : 調査票概況特記イメージ) {
            if (存在したイメージファイル名.contains(ファイル名)) {
                isNotExistsImageFile = false;
                break;
            }
        }
        for (RString ファイル名 : 調査票特記イメージ) {
            if (!isNotExistsImageFile) {
                break;
            }
            if (存在したイメージファイル名.contains(ファイル名)) {
                isNotExistsImageFile = false;
            }
        }
        if (isNotExistsImageFile) {
            イメージファイルが存在区分 = イメージファイルが存在区分_存在しない;
        }
        if (!確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            if (存在したイメージファイル名.contains(new RString("C0007_BAK"))) {
                return イメージファイルが存在区分_マスキング有;
            }
            for (RString ファイル名 : get調査票特記イメージ_原本あり()) {
                if (存在したイメージファイル名.contains(ファイル名.concat(イメージファイル原本名))) {
                    return イメージファイルが存在区分_マスキング有;
                }
            }
        }
        return イメージファイルが存在区分;
    }

    /**
     * 「削除」ボタンを押下する場合、調査票概況のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 調査票概況のイメージファイルが存在しない：true、存在する：false
     */
    public boolean is調査票概況のイメージファイルが存在しない(List<RString> 存在したイメージファイル名) {
        return !存在したイメージファイル名.contains(new RString("G0001"));
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
        RString イメージファイルが存在区分 = RString.EMPTY;
        List<RString> 主治医意見書イメージ_定型外 = get主治医意見書イメージ_定型外();
        List<RString> 主治医意見書イメージ_定型 = get主治医意見書イメージ_定型();
        boolean isNotExistsImageFile = true;
        for (RString ファイル名 : 主治医意見書イメージ_定型外) {
            if (!存在したイメージファイル名.contains(ファイル名)) {
                isNotExistsImageFile = false;
                break;
            }
        }
        for (RString ファイル名 : 主治医意見書イメージ_定型) {
            if (!isNotExistsImageFile) {
                break;
            }
            if (!存在したイメージファイル名.contains(ファイル名)) {
                isNotExistsImageFile = false;
            }
        }
        if (isNotExistsImageFile) {
            イメージファイルが存在区分 = イメージファイルが存在区分_存在しない;
        }
        if (!確認メッセージ出力要.equals(確認メッセージ出力区分)
                && (存在したイメージファイル名.contains(new RString("E0001_BAK"))
                || 存在したイメージファイル名.contains(new RString("E0002_BAK"))
                || 存在したイメージファイル名.contains(new RString("D1005_BAK"))
                || 存在したイメージファイル名.contains(new RString("D1008_BAK"))
                || 存在したイメージファイル名.contains(new RString("D1026_BAK"))
                || 存在したイメージファイル名.contains(new RString("D1027_BAK")))) {
            return イメージファイルが存在区分_マスキング有;
        }
        return イメージファイルが存在区分;
    }

    /**
     * 「削除」ボタンを押下する場合、その他資料のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @param 確認メッセージ出力区分 確認メッセージ出力区分
     * @return イメージファイルが存在区分
     */
    public RString getその他資料のイメージファイルが存在区分(List<RString> 存在したイメージファイル名,
            RString 確認メッセージ出力区分) {
        RString イメージファイルが存在区分 = RString.EMPTY;
        List<RString> その他資料イメージ = getその他資料イメージ();
        boolean isNotExistsImageFile = true;
        for (RString ファイル名 : その他資料イメージ) {
            if (!存在したイメージファイル名.contains(ファイル名)) {
                isNotExistsImageFile = false;
                break;
            }
        }
        if (isNotExistsImageFile) {
            イメージファイルが存在区分 = イメージファイルが存在区分_存在しない;
        }
        if (!確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            for (RString ファイル名 : getその他資料イメージ_原本あり()) {
                if (存在したイメージファイル名.contains(ファイル名.concat(イメージファイル原本名))) {
                    return イメージファイルが存在区分_マスキング有;
                }
            }
        }
        return イメージファイルが存在区分;
    }

    public void deleteGaikyoChosaImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        List<RString> gaikyoChosaImageList = get調査票概況特記イメージ();
        List<RString> tokkiJikoImageList = get調査票特記イメージ();

        if (isMaskOnly) {
            if (deleteImageFileList.contains(new RString("C0007_BAK"))) {
                reNameImageFile(descriptor, localCopyPath, new RString("C0007_BAK"));
                SharedFile.deleteFileInEntry(descriptor, "C0007_BAK.png");
            }
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, tokkiJikoImageList, deleteImageFileList);
        } else {
            deleteAllSharedFileInEntry(descriptor, gaikyoChosaImageList, deleteImageFileList);
            deleteAllSharedFileInEntry(descriptor, tokkiJikoImageList, deleteImageFileList);
        }
    }

    public void deleteGaikyoTokkiImageFile(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteImageFileList) {
        if (deleteImageFileList.contains(new RString("G0001"))) {
            SharedFile.deleteFileInEntry(descriptor, "G0001.png");
        }
    }

    public void deleteOpinionImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        List<RString> teikeigaiOpinionImageFileList = get主治医意見書イメージ_定型外();
        List<RString> teikeiOpinionImageFileList = get主治医意見書イメージ_定型();

        if (isMaskOnly) {
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, teikeigaiOpinionImageFileList, deleteImageFileList);
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, teikeiOpinionImageFileList, deleteImageFileList);
        } else {
            deleteAllSharedFileInEntry(descriptor, teikeigaiOpinionImageFileList, deleteImageFileList);
            deleteAllSharedFileInEntry(descriptor, teikeiOpinionImageFileList, deleteImageFileList);
        }
    }

    public void deleteOtherImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteImageFileList, boolean isMaskOnly) {
        List<RString> otherImageFileList = getその他資料イメージ();

        if (isMaskOnly) {
            deleteMaskSharedFileInEntry(descriptor, localCopyPath, otherImageFileList, deleteImageFileList);
        } else {
            deleteAllSharedFileInEntry(descriptor, otherImageFileList, deleteImageFileList);
        }
    }

    private void deleteAllSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, List<RString> deleteTargetImageFileList,
            List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (deleteImageFileList.contains(deleteTargetImageFile)) {
                SharedFile.deleteFileInEntry(descriptor, deleteTargetImageFile.toString());
            }
        }
    }

    private void deleteMaskSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath,
            List<RString> deleteTargetImageFileList, List<RString> deleteImageFileList) {
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            if (deleteImageFileList.contains(deleteTargetImageFile.concat(イメージファイル原本名))) {
                reNameImageFile(descriptor, localCopyPath,
                        deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子));
                SharedFile.deleteFileInEntry(descriptor,
                        deleteTargetImageFile.concat(イメージファイル原本名).concat(イメージファイル拡張子).toString());
            }
        }
    }

    private void reNameImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath, RString targetImageFile) {
        if (Directory.exists(Path.combinePath(localCopyPath, targetImageFile))) {
            boolean options = true;
            RString afterReNameImageFile = reName(targetImageFile);
            File.move(Path.combinePath(localCopyPath, targetImageFile), Path.combinePath(localCopyPath, afterReNameImageFile), options);
            SharedAppendOption option = new SharedAppendOption();
            option.overWrite(true);
            SharedFile.appendNewFile(descriptor, new FilesystemPath(Path.combinePath(localCopyPath, afterReNameImageFile)),
                    afterReNameImageFile.toString(), option);
        }
    }

    private RString reName(RString targetName) {
        targetName.replace("_BAK", "");
        return targetName;
    }

    private List<RString> get調査票概況特記イメージ() {
        List<RString> 調査票概況特記 = new ArrayList<>();
        調査票概況特記.add(new RString("C0001"));
        調査票概況特記.add(new RString("C0002"));
        調査票概況特記.add(new RString("C0003"));
        調査票概況特記.add(new RString("C0004"));
        調査票概況特記.add(new RString("C0005"));
        調査票概況特記.add(new RString("C0006"));
        調査票概況特記.add(new RString("C0007"));
        調査票概況特記.add(new RString("C0007_BAK"));
        return 調査票概況特記;
    }

    private List<RString> get調査票特記イメージ() {
        List<RString> 調査票特記 = new ArrayList<>();
        for (RString 連番範囲 : get調査票特記連番範囲イメージ()) {
            for (RString 特記範囲 : get調査票特記範囲イメージ()) {
                調査票特記.add(特記範囲.concat("-").concat(連番範囲));
                調査票特記.add(特記範囲.concat("-").concat(連番範囲).concat(イメージファイル原本名));
            }
        }
        get調査票特記資料イメージ(調査票特記);
        return 調査票特記;
    }

    private List<RString> get調査票特記イメージ_原本あり() {
        List<RString> 調査票特記イメージ_原本あり = new ArrayList<>();
        for (RString 連番範囲 : get調査票特記連番範囲イメージ()) {
            for (RString 特記範囲 : get調査票特記範囲イメージ()) {
                調査票特記イメージ_原本あり.add(特記範囲.concat("-").concat(連番範囲));
            }
        }
        調査票特記イメージ_原本あり.add(new RString("C4101"));
        調査票特記イメージ_原本あり.add(new RString("C4102"));
        調査票特記イメージ_原本あり.add(new RString("C4103"));
        調査票特記イメージ_原本あり.add(new RString("C4104"));
        調査票特記イメージ_原本あり.add(new RString("C4105"));
        調査票特記イメージ_原本あり.add(new RString("C4106"));
        return 調査票特記イメージ_原本あり;
    }

    private void get調査票特記資料イメージ(List<RString> 調査票特記) {
        調査票特記.add(new RString("C4101"));
        調査票特記.add(new RString("C4101_BAK"));
        調査票特記.add(new RString("C4102"));
        調査票特記.add(new RString("C4102_BAK"));
        調査票特記.add(new RString("C4103"));
        調査票特記.add(new RString("C4103_BAK"));
        調査票特記.add(new RString("C4104"));
        調査票特記.add(new RString("C4104_BAK"));
        調査票特記.add(new RString("C4105"));
        調査票特記.add(new RString("C4105_BAK"));
        調査票特記.add(new RString("C4106"));
        調査票特記.add(new RString("C4106_BAK"));
    }

    private List<RString> get調査票特記範囲イメージ() {
        List<RString> 調査票特記範囲 = new ArrayList<>();
        調査票特記範囲.add(new RString("C3001"));
        調査票特記範囲.add(new RString("C3006"));
        調査票特記範囲.add(new RString("C3010"));
        調査票特記範囲.add(new RString("C3011"));
        調査票特記範囲.add(new RString("C3012"));
        調査票特記範囲.add(new RString("C3013"));
        調査票特記範囲.add(new RString("C3014"));
        調査票特記範囲.add(new RString("C3015"));
        調査票特記範囲.add(new RString("C3016"));
        調査票特記範囲.add(new RString("C3017"));
        調査票特記範囲.add(new RString("C3018"));
        調査票特記範囲.add(new RString("C3019"));
        調査票特記範囲.add(new RString("C3020"));
        調査票特記範囲.add(new RString("C3021"));
        調査票特記範囲.add(new RString("C3022"));
        調査票特記範囲.add(new RString("C3023"));
        調査票特記範囲.add(new RString("C3024"));
        調査票特記範囲.add(new RString("C3025"));
        調査票特記範囲.add(new RString("C3026"));
        調査票特記範囲.add(new RString("C3027"));
        調査票特記範囲.add(new RString("C3028"));
        調査票特記範囲.add(new RString("C3029"));
        調査票特記範囲.add(new RString("C3030"));
        調査票特記範囲.add(new RString("C3031"));
        調査票特記範囲.add(new RString("C3032"));
        調査票特記範囲.add(new RString("C3033"));
        調査票特記範囲.add(new RString("C3034"));
        調査票特記範囲.add(new RString("C3035"));
        調査票特記範囲.add(new RString("C3036"));
        調査票特記範囲.add(new RString("C3037"));
        調査票特記範囲.add(new RString("C3038"));
        調査票特記範囲.add(new RString("C3039"));
        調査票特記範囲.add(new RString("C3040"));
        調査票特記範囲.add(new RString("C3041"));
        調査票特記範囲.add(new RString("C3042"));
        調査票特記範囲.add(new RString("C3043"));
        調査票特記範囲.add(new RString("C3044"));
        調査票特記範囲.add(new RString("C3045"));
        調査票特記範囲.add(new RString("C3046"));
        調査票特記範囲.add(new RString("C3047"));
        調査票特記範囲.add(new RString("C3048"));
        調査票特記範囲.add(new RString("C3049"));
        調査票特記範囲.add(new RString("C3050"));
        調査票特記範囲.add(new RString("C3051"));
        調査票特記範囲.add(new RString("C3052"));
        調査票特記範囲.add(new RString("C3053"));
        調査票特記範囲.add(new RString("C3054"));
        調査票特記範囲.add(new RString("C3055"));
        調査票特記範囲.add(new RString("C3056"));
        調査票特記範囲.add(new RString("C3057"));
        調査票特記範囲.add(new RString("C3058"));
        調査票特記範囲.add(new RString("C3059"));
        調査票特記範囲.add(new RString("C3060"));
        調査票特記範囲.add(new RString("C3061"));
        調査票特記範囲.add(new RString("C3062"));
        調査票特記範囲.add(new RString("C3063"));
        調査票特記範囲.add(new RString("C3064"));
        調査票特記範囲.add(new RString("C3065"));
        調査票特記範囲.add(new RString("C3066"));
        調査票特記範囲.add(new RString("C3067"));
        調査票特記範囲.add(new RString("C3068"));
        調査票特記範囲.add(new RString("C3069"));
        調査票特記範囲.add(new RString("C3070"));
        調査票特記範囲.add(new RString("C3071"));
        調査票特記範囲.add(new RString("C3072"));
        調査票特記範囲.add(new RString("C3073"));
        調査票特記範囲.add(new RString("C3074"));
        調査票特記範囲.add(new RString("C3075"));
        調査票特記範囲.add(new RString("C3076"));
        return 調査票特記範囲;
    }

    private List<RString> get調査票特記連番範囲イメージ() {
        List<RString> 調査票特記連番範囲 = new ArrayList<>();
        調査票特記連番範囲.add(new RString("00"));
        調査票特記連番範囲.add(new RString("01"));
        調査票特記連番範囲.add(new RString("02"));
        調査票特記連番範囲.add(new RString("03"));
        調査票特記連番範囲.add(new RString("04"));
        調査票特記連番範囲.add(new RString("05"));
        調査票特記連番範囲.add(new RString("06"));
        調査票特記連番範囲.add(new RString("07"));
        調査票特記連番範囲.add(new RString("08"));
        調査票特記連番範囲.add(new RString("09"));
        return 調査票特記連番範囲;
    }

    private List<RString> get主治医意見書イメージ_定型外() {
        List<RString> 主治医意見書イメージ_定型外 = new ArrayList<>();
        主治医意見書イメージ_定型外.add(new RString("E0001"));
        主治医意見書イメージ_定型外.add(new RString("E0001_BAK"));
        主治医意見書イメージ_定型外.add(new RString("E0002"));
        主治医意見書イメージ_定型外.add(new RString("E0002_BAK"));
        return 主治医意見書イメージ_定型外;
    }

    private List<RString> get主治医意見書イメージ_定型() {
        List<RString> 主治医意見書イメージ_定型 = new ArrayList<>();
        主治医意見書イメージ_定型.add(new RString("D1001"));
        主治医意見書イメージ_定型.add(new RString("D1002"));
        主治医意見書イメージ_定型.add(new RString("D1003"));
        主治医意見書イメージ_定型.add(new RString("D1004"));
        主治医意見書イメージ_定型.add(new RString("D1005"));
        主治医意見書イメージ_定型.add(new RString("D1005_BAK"));
        主治医意見書イメージ_定型.add(new RString("D1006"));
        主治医意見書イメージ_定型.add(new RString("D1007"));
        主治医意見書イメージ_定型.add(new RString("D1008"));
        主治医意見書イメージ_定型.add(new RString("D1008_BAK"));
        主治医意見書イメージ_定型.add(new RString("D1009"));
        主治医意見書イメージ_定型.add(new RString("D1010"));
        主治医意見書イメージ_定型.add(new RString("D1011"));
        主治医意見書イメージ_定型.add(new RString("D1012"));
        主治医意見書イメージ_定型.add(new RString("D1013"));
        主治医意見書イメージ_定型.add(new RString("D1014"));
        主治医意見書イメージ_定型.add(new RString("D1015"));
        主治医意見書イメージ_定型.add(new RString("D1017"));
        主治医意見書イメージ_定型.add(new RString("D1018"));
        主治医意見書イメージ_定型.add(new RString("D1019"));
        主治医意見書イメージ_定型.add(new RString("D1020"));
        主治医意見書イメージ_定型.add(new RString("D1021"));
        主治医意見書イメージ_定型.add(new RString("D1022"));
        主治医意見書イメージ_定型.add(new RString("D1023"));
        主治医意見書イメージ_定型.add(new RString("D1024"));
        主治医意見書イメージ_定型.add(new RString("D1025"));
        主治医意見書イメージ_定型.add(new RString("D1026"));
        主治医意見書イメージ_定型.add(new RString("D1026_BAK"));
        主治医意見書イメージ_定型.add(new RString("D1027"));
        主治医意見書イメージ_定型.add(new RString("D1027_BAK"));
        主治医意見書イメージ_定型.add(new RString("D1028"));
        主治医意見書イメージ_定型.add(new RString("D1029"));
        主治医意見書イメージ_定型.add(new RString("D1030"));
        主治医意見書イメージ_定型.add(new RString("D1031"));
        return 主治医意見書イメージ_定型;
    }

    private List<RString> getその他資料イメージ() {
        List<RString> その他資料 = new ArrayList<>();
        for (RString 表示順範囲 : getその他資料表示順範囲イメージ()) {
            for (RString その他資料範囲 : getその他資料範囲イメージ()) {
                その他資料.add(その他資料範囲.concat(表示順範囲));
                その他資料.add(その他資料範囲.concat(表示順範囲).concat(イメージファイル原本名));
            }
        }
        return その他資料;
    }

    private List<RString> getその他資料イメージ_原本あり() {
        List<RString> その他資料_原本あり = new ArrayList<>();
        for (RString 表示順範囲 : getその他資料表示順範囲イメージ()) {
            for (RString その他資料範囲 : getその他資料範囲イメージ()) {
                その他資料_原本あり.add(その他資料範囲.concat(表示順範囲));
            }
        }
        return その他資料_原本あり;
    }

    private List<RString> getその他資料表示順範囲イメージ() {
        List<RString> その他資料表示順範囲 = new ArrayList<>();
        その他資料表示順範囲.add(new RString("01"));
        その他資料表示順範囲.add(new RString("02"));
        その他資料表示順範囲.add(new RString("03"));
        その他資料表示順範囲.add(new RString("04"));
        その他資料表示順範囲.add(new RString("05"));
        その他資料表示順範囲.add(new RString("06"));
        return その他資料表示順範囲;
    }

    private List<RString> getその他資料範囲イメージ() {
        List<RString> その他資料範囲 = new ArrayList<>();
        その他資料範囲.add(new RString("F1401A"));
        その他資料範囲.add(new RString("F1401B"));
        その他資料範囲.add(new RString("F1401C"));
        その他資料範囲.add(new RString("F1401D"));
        その他資料範囲.add(new RString("F1401E"));
        その他資料範囲.add(new RString("F1401F"));
        return その他資料範囲;
    }

}
