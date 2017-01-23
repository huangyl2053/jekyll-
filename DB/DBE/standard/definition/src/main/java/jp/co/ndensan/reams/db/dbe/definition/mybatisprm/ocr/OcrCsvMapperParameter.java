/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ocr;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * {@link IOcrCsvMapper}のパラメータです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class OcrCsvMapperParameter implements IMyBatisParameter {

    private final RString tempTableName;

    private OcrCsvMapperParameter(RString tempTableName) {
        this.tempTableName = tempTableName;
    }

    /**
     * @param tempTableName 一時テーブル名
     * @return 指定の一時テーブルからデータを取得する際のパラメータ
     */
    public static OcrCsvMapperParameter selectForm(RString tempTableName) {
        return new OcrCsvMapperParameter(Objects.requireNonNull(tempTableName));
    }
}
