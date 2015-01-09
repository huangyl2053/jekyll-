///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package messagemapping;
//
//import jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage;
//import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
//
//import jp.co.ndensan.reams.uz.uza.message.Message;
//
///**
// *
// * @author N8235 船山 洋介
// */
//public enum ShikakuHenkoValidationMessageMapping implements IValidationMessageMapping {
//
//    入所日が未入力(ShikakuHenkoValidationMessage.変更日が未入力, "txtNyushoDate"),
//    終了日設定なし(ShikakuHenkoValidationMessage.届出日設定なし, "taishoDate"),
//    入所施設が未入力(ShikakuHenkoValidationMessage.変更事由が未入力, "txtShisetsuCode"),
//    入所年月日より前(ShikakuHenkoValidationMessage.変更日より前, "txtTaishoDate"),
//    退所日と次の履歴データの入所日の期間が重複(ShikakuHenkoValidationMessage.届出日と次の履歴データの変更日の期間が重複, "txtTaishoDate"),
//    入所日と前の履歴データの退所日の期間が重複(ShikakuHenkoValidationMessage.変更日と前の履歴データの届出日の期間が重複, "txtNyushoDate"),
//    入所日と期間が重複する履歴がある(ShikakuHenkoValidationMessage.届出日と期間が重複する履歴がある, "txtNyushoDate"),
//    退所日と期間が重複する履歴がある(ShikakuHenkoValidationMessage.届出日と期間が重複する履歴がある, "txtTaishoDate");
//
//    private final IValidationMessage message;
//    private final String fieldName;
//
//    private ShikakuHenkoValidationMessageMapping(IValidationMessage message, String fieldName) {
//        this.message = message;
//        this.fieldName = fieldName;
//    }
//
////    @Override
////    public jp.co.ndensan.reams.uz.uza.message.IValidationMessage getValidationMessage() {
////        return message;
////    }
//    @Override
//    public IValidationMessage getValidationMessage() {
//        return message;
//    }
//
//    @Override
//    public Message getMessage() {
//        return message.getMessage();
//    }
//
//    @Override
//    public String getFieldName() {
//        return fieldName;
//    }
//
//}
