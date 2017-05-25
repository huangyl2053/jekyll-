/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.images;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR2000iで読み取ったイメージファイル名と、Reamsで管理するファイル名を変換する関数の一覧です。
 */
public enum FileNameConvertionTheories implements IFileNameConvertionTheory {

    /**
     * ID501
     */
    ID501 {
                @Override
                public RString convert(RString fileName) {
                    for (Map.Entry<String, RString> entry : 認定調査票_概況.entrySet()) {
                        if (fileName.endsWith(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return RString.EMPTY;
                }
            },
    /**
     * ID777 通常読取時
     */
    ID777 {
                @Override
                public RString convert(RString t) {
                    if (t.endsWith("w01i000.png")) {
                        return 主治医意見書_表;
                    }
                    if (t.endsWith("w02i000.png")) {
                        return 主治医意見書_裏;
                    }
                    return RString.EMPTY;
                }
            },
    /**
     * ID777 表裏逆転読取時
     */
    ID777_reversed {
                @Override
                public RString convert(RString t) {
                    if (t.endsWith("w01i000.png")) {
                        return 主治医意見書_裏;
                    }
                    if (t.endsWith("w02i000.png")) {
                        return 主治医意見書_表;
                    }
                    return RString.EMPTY;
                }
            };

    private static final Map<String, RString> 認定調査票_概況;
    public static final RString 主治医意見書_表;
    public static final RString 主治医意見書_裏;

    static {
        //ファイル名が一元管理されていないが、
        //他の機能を修正すると予期しない影響がありそうで怖いので、ここでも個別に定義する。
        主治医意見書_表 = new RString("E0001.png");
        主治医意見書_裏 = new RString("E0002.png");

        Map<String, RString> chosahyoGaikyo = new HashMap<>();
        chosahyoGaikyo.put("w01i011.png", new RString("C0001.png"));
        chosahyoGaikyo.put("w01i038.png", new RString("C0002.png"));
        chosahyoGaikyo.put("w01i039.png", new RString("C0003.png"));
        chosahyoGaikyo.put("w01i048.png", new RString("C0004.png"));
        chosahyoGaikyo.put("w01i049.png", new RString("C0005.png"));
        chosahyoGaikyo.put("w01i050.png", new RString("C0006.png"));
        chosahyoGaikyo.put("w01i051.png", new RString("C0007.png"));
        認定調査票_概況 = Collections.unmodifiableMap(chosahyoGaikyo);
    }
}
