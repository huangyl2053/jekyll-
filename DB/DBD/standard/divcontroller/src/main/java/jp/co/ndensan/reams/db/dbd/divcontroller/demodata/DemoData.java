/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter.IConverter;

/**
 * demo用のデータを扱います。
 *
 * @author N3327 三浦 凌
 * @param <T> 変換させたい型
 */
class DemoData<T> implements IDemoData<T> {

    private final List<HashMap> rowData;
    private final IConverter<T> conv;

    DemoData(List<HashMap> rowData, IConverter<T> conv) {
        this.rowData = rowData;
        this.conv = conv;
    }

    @Override
    public List<T> asConvertedType() {
        return rowData.isEmpty() ? Collections.EMPTY_LIST : YamlUtil.convertList(rowData, conv);
    }

    @Override
    public List<HashMap> asRow() {
        return rowData.isEmpty() ? Collections.EMPTY_LIST : this.rowData;
    }
}
