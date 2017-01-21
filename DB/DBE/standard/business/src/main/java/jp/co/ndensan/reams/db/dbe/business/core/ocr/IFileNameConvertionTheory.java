/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCRで取り込んだイメージファイル名とRemadで管理するイメージファイル名を変換する方法を定義します。
 */
public interface IFileNameConvertionTheory {

    /**
     * @param fileName ファイル名
     * @return Reamsで管理するファイル名
     */
    RString convert(RString fileName);
}
