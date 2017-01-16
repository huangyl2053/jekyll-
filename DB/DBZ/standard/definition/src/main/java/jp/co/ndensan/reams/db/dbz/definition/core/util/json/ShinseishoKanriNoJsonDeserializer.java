/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.util.json;

import java.io.IOException;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 *
 */
class ShinseishoKanriNoJsonDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<ShinseishoKanriNo> {

    @Override
    public ShinseishoKanriNo deserialize(
            com.fasterxml.jackson.core.JsonParser jp,
            com.fasterxml.jackson.databind.DeserializationContext ctxt
    ) throws IOException, com.fasterxml.jackson.core.JsonProcessingException {
        return new ShinseishoKanriNo(jp.getText());
    }
}
