/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocrdataread;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ocrfiledata.OcrFileLineDataTypeModel;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ ファイル読み取り結果 クラスです。
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrFileReadResult {

    private RString データ行_文字列;

    private List<RString> イメージファイル;

    public void clear() {
        this.イメージファイル = new ArrayList<>();
    }

    /**
     * 行を解析
     *
     * @param line 行
     * @param 読取中行番号 読取中行番号
     * @return 行データタイプ
     */
    public OcrFileLineDataTypeModel parse(RString line, long 読取中行番号) {
        OcrFileLineDataTypeModel lineDataTypeModel = OcrFileLineDataTypeModel.行データタイプ_対象外;
        lineDataTypeModel = this.parse1(line);
        lineDataTypeModel = OcrFileLineDataTypeModel.行データタイプ_データ行;
        return lineDataTypeModel;
    }

    /**
     * 行を解析
     *
     * @param line 行文字列
     * @param ヘッダー行番号 バッチパラメータで指定された行番号
     * @param 読取中行番号 読取中行番号
     * @return 行データタイプ
     */
    private OcrFileLineDataTypeModel parse1(RString line) {
        this.parse1データ行(line);
        return OcrFileLineDataTypeModel.行データタイプ_データ行;
    }

    private void parse1データ行(RString line) {
        
        データ行_文字列 = line;
        List<RString> ファイルList = new ArrayList<>();

        List<RString> lineList = line.split(",");
        int size = lineList.size();
        for (int i = 0; i < size; i++) {
            if (lineList.get(i).contains("\\")) {
                RString fileTest = lineList.get(i).substring(lineList.get(i).lastIndexOf("\\") + 1);
                if (fileTest.contains("01i011")) {
                    RString fileName = new RString("C0001.png");
                    ファイルList.add(fileName);
                } else if (fileTest.contains("01i048")) {
                    RString fileName = new RString("C0004.png");
                    ファイルList.add(fileName);
                } else if (fileTest.contains("01i049")) {
                    RString fileName = new RString("C0005.png");
                    ファイルList.add(fileName);
                } else if (fileTest.contains("01i050")) {
                    RString fileName = new RString("C0006.png");
                    ファイルList.add(fileName);
                } else if (fileTest.contains("01i051")) {
                    RString fileName = new RString("G0001.png");
                    ファイルList.add(fileName);
                } else if (fileTest.contains("01i038")) {
                    RString fileName = new RString("C0002.png");
                    ファイルList.add(fileName);
                } else if (fileTest.contains("01i039")) {
                    RString fileName = new RString("C0003.png");
                    ファイルList.add(fileName);
                }
            }
        }
        イメージファイル = ファイルList;
    }

}
