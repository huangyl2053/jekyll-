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

    //TODO ファイル名が一元管理されていない。他の機能を修正すると予期しない影響がありそうで怖いので、ここでも個別に定義する。
    private static final RString 主治医意見書_表;
    private static final RString 主治医意見書_裏;

    static {
        主治医意見書_表 = new RString("E0001.png");
        主治医意見書_裏 = new RString("E0002.png");
    }
}
