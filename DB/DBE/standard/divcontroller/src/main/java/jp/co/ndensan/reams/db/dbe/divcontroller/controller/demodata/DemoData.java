/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter.IConverter;

/**
 *
 * @author N3327 三浦 凌
 */
class DemoData<T> implements IDemoData<T> {

    private final List<HashMap> rawData;
    private final IConverter<T> conveter;

    DemoData(List<HashMap> rawData, IConverter<T> conveter) {
        this.rawData = rawData;
        this.conveter = conveter;
    }

    @Override
    public List<T> asConvetedType() {
        return YamlUtil.convertList(this.rawData, this.conveter);
    }

    @Override
    public List<HashMap> asRaw() {
        return Collections.unmodifiableList(this.rawData);
    }

}
