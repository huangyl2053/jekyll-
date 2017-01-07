/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR2000iで読み取ったイメージファイル名と、Reamsで管理するファイル名を変換する関数の一覧です。
 */
public enum FileNameConvertionTheories {

    ID777 {
                @Override
                RString convert(RString t) {
                    if (t.endsWith("w01i000.png")) {
                        return 主治医意見書_表;
                    }
                    if (t.endsWith("w02i000.png")) {
                        return 主治医意見書_裏;
                    }
                    return RString.EMPTY;
                }
            },
    ID777_reversed {
                @Override
                RString convert(RString t) {
                    if (t.endsWith("w01i000.png")) {
                        return 主治医意見書_裏;
                    }
                    if (t.endsWith("w02i000.png")) {
                        return 主治医意見書_表;
                    }
                    return RString.EMPTY;
                }
            };

    /**
     * @param fileName ファイル名
     * @return Reamsで管理するファイル名
     */
    abstract RString convert(RString fileName);

    private static final RString 主治医意見書_表;
    private static final RString 主治医意見書_裏;

    static {
        主治医意見書_表 = new RString("E0001.png"); //TODO 要確認。どこかenumで一元管理されていないか…？
        主治医意見書_裏 = new RString("E0002.png");
    }
}
