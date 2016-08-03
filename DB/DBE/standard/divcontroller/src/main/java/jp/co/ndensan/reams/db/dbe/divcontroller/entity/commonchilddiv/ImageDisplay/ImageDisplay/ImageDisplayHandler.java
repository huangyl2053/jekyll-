/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ情報表示のHandlerクラスです。
 *
 * @reamsid_L DBE-3000-280 jinjue
 */
public class ImageDisplayHandler {

    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージファイル原本名 = new RString("_BAK");

    /**
     * コンストラクタです。
     */
    public ImageDisplayHandler() {
    }

    /**
     * 調査票概況のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 調査票概況のイメージファイルが存在しない：true、存在する：false
     */
    public boolean is調査票概況のイメージファイルが存在しない(List<RString> 存在したイメージファイル名) {
        return !存在したイメージファイル名.contains(new RString("G0001"));
    }

    /**
     * 主治医意見書のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return イメージファイルが存在区分
     */
    public RString get主治医意見書のイメージファイルが存在区分(List<RString> 存在したイメージファイル名) {
        RString イメージファイルが存在区分 = RString.EMPTY;
        List<RString> 主治医意見書イメージ_白黒 = get主治医意見書イメージ_白黒();
        List<RString> 主治医意見書イメージ_OCR = get主治医意見書イメージ_OCR();
        int 主治医意見書イメージファイルが存在しない = 0;
        for (RString ファイル名 : 主治医意見書イメージ_白黒) {
            if (!存在したイメージファイル名.contains(ファイル名)) {
                主治医意見書イメージファイルが存在しない++;
            }
        }
        for (RString ファイル名 : 主治医意見書イメージ_OCR) {
            if (!存在したイメージファイル名.contains(ファイル名)) {
                主治医意見書イメージファイルが存在しない++;
            }
        }
        if (主治医意見書イメージファイルが存在しない == (主治医意見書イメージ_白黒.size() + 主治医意見書イメージ_OCR.size())) {
            イメージファイルが存在区分 = イメージファイルが存在区分_存在しない;
        }
        return イメージファイルが存在区分;
    }

    /**
     * その他資料のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return イメージファイルが存在区分
     */
    public RString getその他資料のイメージファイルが存在区分(List<RString> 存在したイメージファイル名) {
        RString イメージファイルが存在区分 = RString.EMPTY;
        List<RString> その他資料イメージ = getその他資料イメージ();
        int その他資料イメージファイルが存在しない = 0;
        for (RString ファイル名 : その他資料イメージ) {
            if (!存在したイメージファイル名.contains(ファイル名)) {
                その他資料イメージファイルが存在しない++;
            }
        }
        if (その他資料イメージファイルが存在しない == その他資料イメージ.size()) {
            イメージファイルが存在区分 = イメージファイルが存在区分_存在しない;
        }
        return イメージファイルが存在区分;
    }

    private List<RString> get主治医意見書イメージ_白黒() {
        List<RString> 主治医意見書イメージ_白黒 = new ArrayList<>();
        主治医意見書イメージ_白黒.add(new RString("E0001"));
        主治医意見書イメージ_白黒.add(new RString("E0001_BAK"));
        主治医意見書イメージ_白黒.add(new RString("E0002"));
        主治医意見書イメージ_白黒.add(new RString("E0002_BAK"));
        return 主治医意見書イメージ_白黒;
    }

    private List<RString> get主治医意見書イメージ_OCR() {
        List<RString> 主治医意見書イメージ_OCR = new ArrayList<>();
        主治医意見書イメージ_OCR.add(new RString("D1001"));
        主治医意見書イメージ_OCR.add(new RString("D1002"));
        主治医意見書イメージ_OCR.add(new RString("D1003"));
        主治医意見書イメージ_OCR.add(new RString("D1004"));
        主治医意見書イメージ_OCR.add(new RString("D1005"));
        主治医意見書イメージ_OCR.add(new RString("D1005_BAK"));
        主治医意見書イメージ_OCR.add(new RString("D1006"));
        主治医意見書イメージ_OCR.add(new RString("D1007"));
        主治医意見書イメージ_OCR.add(new RString("D1008"));
        主治医意見書イメージ_OCR.add(new RString("D1008_BAK"));
        主治医意見書イメージ_OCR.add(new RString("D1009"));
        主治医意見書イメージ_OCR.add(new RString("D1010"));
        主治医意見書イメージ_OCR.add(new RString("D1011"));
        主治医意見書イメージ_OCR.add(new RString("D1012"));
        主治医意見書イメージ_OCR.add(new RString("D1013"));
        主治医意見書イメージ_OCR.add(new RString("D1014"));
        主治医意見書イメージ_OCR.add(new RString("D1015"));
        主治医意見書イメージ_OCR.add(new RString("D1017"));
        主治医意見書イメージ_OCR.add(new RString("D1018"));
        主治医意見書イメージ_OCR.add(new RString("D1019"));
        主治医意見書イメージ_OCR.add(new RString("D1020"));
        主治医意見書イメージ_OCR.add(new RString("D1021"));
        主治医意見書イメージ_OCR.add(new RString("D1022"));
        主治医意見書イメージ_OCR.add(new RString("D1023"));
        主治医意見書イメージ_OCR.add(new RString("D1024"));
        主治医意見書イメージ_OCR.add(new RString("D1025"));
        主治医意見書イメージ_OCR.add(new RString("D1026"));
        主治医意見書イメージ_OCR.add(new RString("D1026_BAK"));
        主治医意見書イメージ_OCR.add(new RString("D1027"));
        主治医意見書イメージ_OCR.add(new RString("D1027_BAK"));
        主治医意見書イメージ_OCR.add(new RString("D1028"));
        主治医意見書イメージ_OCR.add(new RString("D1029"));
        主治医意見書イメージ_OCR.add(new RString("D1030"));
        主治医意見書イメージ_OCR.add(new RString("D1031"));
        return 主治医意見書イメージ_OCR;
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
