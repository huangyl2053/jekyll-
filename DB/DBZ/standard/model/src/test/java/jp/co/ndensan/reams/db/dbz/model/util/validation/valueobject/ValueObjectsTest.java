/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.RStringValueObjects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki.RokenShichosonNo;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author N3327 三浦 凌
 */
public class ValueObjectsTest {

    public ValueObjectsTest() {
    }

    @Test
    public void testGetValidator() {
        KaigoHihokenshaNo no = new KaigoHihokenshaNo(new RString("1234567890"));
        IValidationMessages message = RStringValueObjects.validationFor(RokenShichosonNo.class).validate(null);
        System.out.println(message == null);
    }
}
