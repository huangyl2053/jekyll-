/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.util.json;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.serialization.FlexibleDateJsonDeserializer;
import jp.co.ndensan.reams.uz.uza.util.serialization.RDateTimeJsonDeserializer;

/**
 *
 */
public class ObjectMapperProvider {

    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        this.objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        com.fasterxml.jackson.databind.module.SimpleModule module = new com.fasterxml.jackson.databind.module.SimpleModule("");
        module.addDeserializer(RDateTime.class, new RDateTimeJsonDeserializer());
        module.addDeserializer(FlexibleDate.class, new FlexibleDateJsonDeserializer());
        module.addDeserializer(ShinseishoKanriNo.class, new ShinseishoKanriNoJsonDeserializer());
        module.addDeserializer(Code.class, new CodeJsonDeserializer());
        this.objectMapper.registerModule(module);
    }

    public com.fasterxml.jackson.databind.ObjectMapper get() {
        return this.objectMapper;
    }
}
