/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0240011;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jukyusyaidoujohorirek.JukyusyaIdouJohoRirekEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0240011.DBC0240011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0240011.KyoutsuIdoReanrakuhyoEraTeiseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0240011.KyoutsuIdoReanrakuhyoEraTeiseiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0240011.KyoutsuIdoReanrakuhyoEraTeiseiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.relate.kyodoshoriyojukyushaidorenrakuhyoerrorteisei.KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 共同処理用受給者異動連絡票エラー訂正のコントローラクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class KyoutsuIdoReanrakuhyoEraTeisei {

    private static final RString メッセージ引数 = new RString("履歴訂正データなし");
    private static final RString 履歴訂正リストファイル名 = new RString("JukyusyaIdouJohoRirekilist.csv");
    private static final RString LOCAL_FILE_NAME = new RString("5C1.csv");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData<KyoutsuIdoReanrakuhyoEraTeiseiDiv>
     */
    public ResponseData<KyoutsuIdoReanrakuhyoEraTeiseiDiv> onLoad(KyoutsuIdoReanrakuhyoEraTeiseiDiv div) {
        List<JukyusyaIdouJohoRirekEntity> list = new ArrayList<>();
        div.getDgIdoReanrakuhyoEraTeisei().setDataSource(new ArrayList());
        List<UzT0885SharedFileEntryEntity> 共有ファイル情報リスト = SharedFile.searchSharedFile(履歴訂正リストファイル名);
        if (共有ファイル情報リスト == null || 共有ファイル情報リスト.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbzErrorMessages.理由付き登録不可.getMessage().replace(メッセージ引数.toString()).getCode(),
                        DbzErrorMessages.理由付き登録不可.getMessage().replace(メッセージ引数.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).addValidationMessages(getValidationHandler().get対象データなしメッセージ()).respond();
        } else {
            SharedFile.defineSharedFile(FilesystemName.fromString(履歴訂正リストファイル名));
            File file;
            for (UzT0885SharedFileEntryEntity entity : 共有ファイル情報リスト) {
                file = new File(Path.combinePath(get履歴訂正共有ファイル(
                        FilesystemPath.fromString(Path.getTmpDirectoryPath()),
                        entity.getSharedFileId()).toRString(), LOCAL_FILE_NAME).toString());
                if (file.exists()) {
                    list = KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeisei.createInstance().getRirekiTeiseiJoho(file);
                }
            }
        }
        if (list == null || list.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbzErrorMessages.理由付き登録不可.getMessage().replace(メッセージ引数.toString()).getCode(),
                        DbzErrorMessages.理由付き登録不可.getMessage().replace(メッセージ引数.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).addValidationMessages(getValidationHandler().get対象データなしメッセージ()).respond();
        }
        getHandler(div).onLoad(list);
        return ResponseData.of(div).respond();
    }

    private FilesystemPath get履歴訂正共有ファイル(FilesystemPath localFilePath, RDateTime sharedFileId) {
        ReadOnlySharedFileEntryDescriptor ro_entry = new ReadOnlySharedFileEntryDescriptor(
                FilesystemName.fromString(履歴訂正リストファイル名), sharedFileId);
        return SharedFile.copyToLocal(ro_entry, localFilePath);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData<KyoutsuIdoReanrakuhyoEraTeiseiDiv>
     */
    public ResponseData<KyoutsuIdoReanrakuhyoEraTeiseiDiv> onSelectByModifyButton(KyoutsuIdoReanrakuhyoEraTeiseiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0240011TransitionEventName.修正).respond();
    }

    private KyoutsuIdoReanrakuhyoEraTeiseiHandler getHandler(KyoutsuIdoReanrakuhyoEraTeiseiDiv div) {
        return new KyoutsuIdoReanrakuhyoEraTeiseiHandler(div);
    }

    private KyoutsuIdoReanrakuhyoEraTeiseiValidationHandler getValidationHandler() {
        return new KyoutsuIdoReanrakuhyoEraTeiseiValidationHandler();
    }
}
