/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public final class ImageFileItem {

    private static final RString イメージファイル原本名 = new RString("_BAK");

    private ImageFileItem() {
    }

    /**
     * 概況調査に関するイメージファイルの名前のリストを返します。
     *
     * @return 概況調査に関するイメージファイルリスト
     */
    public static List<RString> getGaikyoChosaImageFileList_ALL() {
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

    /**
     * 概況調査においてマスクが存在し得るイメージファイルの名前のリストを返します。
     *
     * @return 概況調査においてマスクが存在し得るイメージファイルリスト
     */
    public static List<RString> getGaikyoChosaImageFileList_Mask() {
        List<RString> 調査票概況特記 = new ArrayList<>();
        調査票概況特記.add(new RString("C0007"));
        return 調査票概況特記;
    }

    /**
     * 特記事項（特記資料含む）に関するイメージファイルの名前のリストを返します。
     *
     * @return 特記事項（特記資料含む）に関するイメージファイルリスト
     */
    public static List<RString> getChosahyoTokkiImageFileList_ALL() {
        List<RString> 調査票特記 = new ArrayList<>();
        for (RString 連番範囲 : getChosahyoTokkiItemRemban()) {
            for (RString 特記範囲 : getChosahyoTokkiItemImageFileList()) {
                調査票特記.add(特記範囲.concat("-").concat(連番範囲));
                調査票特記.add(特記範囲.concat("-").concat(連番範囲).concat(イメージファイル原本名));
            }
        }
        getChosahyoTokkiShiryoImageFileList(調査票特記);
        return 調査票特記;
    }

    /**
     * 特記事項（特記資料含む）においてマスクが存在し得るイメージファイルの名前のリストを返します。
     *
     * @return 特記事項（特記資料含む）においてマスクが存在し得るイメージファイルリスト
     */
    public static List<RString> getChosahyoTokkiImageFileList_Mask() {
        List<RString> 調査票特記イメージ_原本あり = new ArrayList<>();
        for (RString 連番範囲 : getChosahyoTokkiItemRemban()) {
            for (RString 特記範囲 : getChosahyoTokkiItemImageFileList()) {
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

    private static void getChosahyoTokkiShiryoImageFileList(List<RString> 調査票特記) {
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

    private static List<RString> getChosahyoTokkiItemImageFileList() {
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

    private static List<RString> getChosahyoTokkiItemRemban() {
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

    /**
     * 概況特記に関するイメージファイルの名前のリストを返します。
     *
     * @return 概況特記に関するイメージファイルリスト
     */
    public static List<RString> getGaikyoTokkiImageFileList_ALL() {
        List<RString> 概況特記 = new ArrayList<>();
        概況特記.add(new RString("G0001"));
        return 概況特記;
    }

    /**
     * 主治医意見書(定型外)に関するイメージファイルの名前のリストを返します。
     *
     * @return 主治医意見書(定型外)に関するイメージファイルリスト
     */
    public static List<RString> getOpinionTeikeigaiImageFileList_ALL() {
        List<RString> 主治医意見書イメージ_定型外 = new ArrayList<>();
        主治医意見書イメージ_定型外.add(new RString("E0001"));
        主治医意見書イメージ_定型外.add(new RString("E0001_BAK"));
        主治医意見書イメージ_定型外.add(new RString("E0002"));
        主治医意見書イメージ_定型外.add(new RString("E0002_BAK"));
        return 主治医意見書イメージ_定型外;
    }

    /**
     * 主治医意見書(定型)に関するイメージファイルの名前のリストを返します。
     *
     * @return 主治医意見書(定型)に関するイメージファイルリスト
     */
    public static List<RString> getOpinionTeikeiImageFileList_ALL() {
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

    /**
     * 主治医意見書(定型・定型外)においてマスクが存在し得るイメージファイルの名前のリストを返します。
     *
     * @return 主治医意見書(定型・定型外)においてマスクが存在し得るイメージファイルリスト
     */
    public static List<RString> getOpinionImageFileList_Mask() {
        List<RString> 主治医意見書イメージ_原本あり = new ArrayList<>();
        主治医意見書イメージ_原本あり.add(new RString("E0001"));
        主治医意見書イメージ_原本あり.add(new RString("E0002"));
        主治医意見書イメージ_原本あり.add(new RString("D1005"));
        主治医意見書イメージ_原本あり.add(new RString("D1008"));
        主治医意見書イメージ_原本あり.add(new RString("D1026"));
        主治医意見書イメージ_原本あり.add(new RString("D1027"));
        return 主治医意見書イメージ_原本あり;
    }

    /**
     * その他資料に関するイメージファイルの名前のリストを返します。
     *
     * @return その他資料に関するイメージファイルリスト
     */
    public static List<RString> getOtherFileImageFileList_ALL() {
        List<RString> その他資料 = new ArrayList<>();
        for (RString 表示順範囲 : getOtherFileRemban()) {
            for (RString その他資料範囲 : getOtherFileImageFileList()) {
                その他資料.add(その他資料範囲.concat(表示順範囲));
                その他資料.add(その他資料範囲.concat(表示順範囲).concat(イメージファイル原本名));
            }
        }
        return その他資料;
    }

    /**
     * その他資料においてマスクが存在し得るイメージファイルの名前のリストを返します。
     *
     * @return その他資料においてマスクが存在し得るイメージファイルリスト
     */
    public static List<RString> getOtherFileImageFileList_Mask() {
        List<RString> その他資料_原本あり = new ArrayList<>();
        for (RString 表示順範囲 : getOtherFileRemban()) {
            for (RString その他資料範囲 : getOtherFileImageFileList()) {
                その他資料_原本あり.add(その他資料範囲.concat(表示順範囲));
            }
        }
        return その他資料_原本あり;
    }

    private static List<RString> getOtherFileRemban() {
        List<RString> その他資料表示順範囲 = new ArrayList<>();
        その他資料表示順範囲.add(new RString("01"));
        その他資料表示順範囲.add(new RString("02"));
        その他資料表示順範囲.add(new RString("03"));
        その他資料表示順範囲.add(new RString("04"));
        その他資料表示順範囲.add(new RString("05"));
        その他資料表示順範囲.add(new RString("06"));
        return その他資料表示順範囲;
    }

    private static List<RString> getOtherFileImageFileList() {
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
