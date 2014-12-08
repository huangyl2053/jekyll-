/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject._ValueObjectValidator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * _ValueObjectValidatorのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class _ValueObjectValidatorTest extends DbzTestBase {

    public _ValueObjectValidatorTest() {
    }

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullの時_NullPointerExceptionをスローする() {
            _ValueObjectValidator sut = new _ValueObjectValidator(null);
        }
    }

    public static class validate extends DbzTestBase {

        private IValueObjectInfo info;
        private _ValueObjectValidator<String, ValueObject> sut;
        private IValueObjectCheckable<String> check1;
        private IValueObjectCheckable<String> check2;
        private ValueObjectCheckList<String> checkList;

        @Before
        public void setUp() {
            info = ValueObjectInfo.displayName("test").unit(Unit.桁).build();
            check1 = createValueObjectCheckable(toValidationMessages(Message01.values()));
            check2 = createValueObjectCheckable(toValidationMessages(Message02.values()));
        }

        @Test
        public void コンストラクタ引数が保持するValueObjectCheckListが_IValueObjectCheckableを含む時_そのcheckが返すIValidationMessagesを_validateの戻り値が_含む() {
            checkList = ValueObjectCheckList.checks(check1);
            sut = new _ValueObjectValidator(createValidationSpec(info, checkList));

            assertThat(check1.check(ValueObject.INSTANCE, info).contains(Message01.INSTANCE), is(true));
            assertThat(sut.validate(ValueObject.INSTANCE).contains(Message01.INSTANCE), is(true));
            assertThat(check1.check(ValueObject.INSTANCE, info).contains(Message02.INSTANCE), is(false));
            assertThat(sut.validate(ValueObject.INSTANCE).contains(Message02.INSTANCE), is(false));
        }

        @Test
        public void コンストラクタ引数が保持するValueObjectCheckListが_IValueObjectCheckableを複数含む時_それらのcheckが返すIValidationMessagesをすべて_validateの戻り値が_含む() {
            checkList = ValueObjectCheckList.checks(check1, check2);
            sut = new _ValueObjectValidator(createValidationSpec(info, checkList));

            assertThat(check1.check(ValueObject.INSTANCE, info).contains(Message01.INSTANCE), is(true));
            assertThat(sut.validate(ValueObject.INSTANCE).contains(Message01.INSTANCE), is(true));
            assertThat(check2.check(ValueObject.INSTANCE, info).contains(Message02.INSTANCE), is(true));
            assertThat(sut.validate(ValueObject.INSTANCE).contains(Message02.INSTANCE), is(true));
        }

        private IValueObjectCheckable<String> createValueObjectCheckable(IValidationMessages messages) {
            IValueObjectCheckable<String> check = mock(IValueObjectCheckable.class);
            when(check.check(any(IValueObject.class), any(IValueObjectInfo.class))).thenReturn(messages);
            return check;
        }

        private IValueObjectValidationSpec<String> createValidationSpec(IValueObjectInfo info, ValueObjectCheckList<String> checkList) {
            IValueObjectValidationSpec<String> spec = mock(IValueObjectValidationSpec.class);
            when(spec.getValueObjectInfo()).thenReturn(info);
            when(spec.getCheckList()).thenReturn(checkList);
            return spec;
        }

        /**
         * {@code IValueObject<String>}のインスタンスを持ちます。
         */
        private enum ValueObject implements IValueObject<String> {

            INSTANCE;

            @Override
            public String value() {
                return "test";
            }

        }

        private static IValidationMessages toValidationMessages(IValidationMessage[] m) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            for (IValidationMessage item : m) {
                messages.add(item);
            }
            return messages;
        }

        private enum Message01 implements IValidationMessage {

            INSTANCE;

            @Override
            public Message getMessage() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            static IValidationMessages toValidationMessages() {
                IValidationMessages messages = ValidationMessagesFactory.createInstance();
                for (IValidationMessage item : values()) {
                    messages.add(item);
                }
                return messages;
            }
        }

        private enum Message02 implements IValidationMessage {

            INSTANCE;

            @Override
            public Message getMessage() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            static IValidationMessages toValidationMessages() {
                IValidationMessages messages = ValidationMessagesFactory.createInstance();
                for (IValidationMessage item : values()) {
                    messages.add(item);
                }
                return messages;
            }
        }
    }
}
