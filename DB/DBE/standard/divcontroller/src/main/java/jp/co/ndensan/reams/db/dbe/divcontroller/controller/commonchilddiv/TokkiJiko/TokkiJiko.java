/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.TokkiJiko;

import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJiko.TokkiJiko.TokkiJikoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 特記事項入力のクラスです。
 */
public class TokkiJiko {

    /**
     * 特記事項入力の初期化。<br/>
     *
     * @param div TokkiJikoDiv
     * @return ResponseData<TokkiJikoDiv>
     */
    public ResponseData<TokkiJikoDiv> onLoad(TokkiJikoDiv div) {
        NinteiShinseiJoho 意見書情報 = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        Image イメージ情報 = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_イメージ情報, Image.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_申請書管理番号, RString.class));
        int 履歴番号 = Integer.valueOf(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, RString.class).toString());
        ShujiiIkenshoJoho shujiiIkenshoJoho = 意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号))
                .getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号));
        if (shujiiIkenshoJoho != null && !RString.isNullOrEmpty(shujiiIkenshoJoho.get特記事項())) {
            div.setHdnTokkiJiko(shujiiIkenshoJoho.get特記事項());
            div.getTxtTokki().setValue(shujiiIkenshoJoho.get特記事項());
        } else {
            div.getTxtTokki().setValue(RString.EMPTY);
        }
        if (イメージ情報 == null || イメージ情報.getイメージ共有ファイルID() == null) {
            div.getImgTokkiJiko().setSrc(RString.EMPTY);
            ViewStateHolder.put(ViewStateKeys.主治医意見書登録_イメージ情報, new Image(管理番号));
        } else {
            //TODO 共有ファイルの取り出し方法不明
            RString path = 共有ファイルを引き出す(イメージ情報);
            if (!RString.isNullOrEmpty(path)) {
                div.getTxtTokki().setVisible(false);
            }
            div.getImgTokkiJiko().setSrc(path);
            ViewStateHolder.put(ViewStateKeys.主治医意見書登録_イメージ情報, イメージ情報.modifiedModel());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンのonClick処理。<br/>
     *
     * @param div TokkiJikoDiv
     * @return ResponseData<TokkiJikoDiv>
     */
    public ResponseData<TokkiJikoDiv> onClick_KakuTeyi(TokkiJikoDiv div) {

        NinteiShinseiJoho 意見書情報 = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_申請書管理番号, RString.class));
        int 履歴番号 = Integer.valueOf(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, RString.class).toString());

        if (!div.getHdnTokkiJiko().equals(div.getTxtTokki().getValue()) && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if ((new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)
                || div.getHdnTokkiJiko().equals(div.getTxtTokki().getValue())) {
            ViewStateHolder.put(ViewStateKeys.主治医意見書登録_意見書情報, 意見書情報.createBuilderForEdit().setShujiiIkenshoIraiJoho(意見書情報.
                    getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).createBuilderForEdit().setShujiiIkenshoJoho(
                            意見書情報.getShujiiIkenshoIraiJoho(new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号)).
                            getSeishinTechoNini(new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号)).createBuilderForEdit().
                            set特記事項(div.getTxtTokki().getValue()).build()).build()).build());
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンのonClick処理。<br/>
     *
     * @param div TokkiJikoDiv
     * @return ResponseData<TokkiJikoDiv>
     */
    public ResponseData<TokkiJikoDiv> onClick_ToriKesi(TokkiJikoDiv div) {

        if (!div.getHdnTokkiJiko().equals(div.getTxtTokki().getValue()) && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if ((new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)
                || div.getHdnTokkiJiko().equals(div.getTxtTokki().getValue())) {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private RString 共有ファイルを引き出す(Image イメージ情報) {

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, RString.EMPTY, UzUDE0831EucAccesslogFileType.Other);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString path;
        FilesystemPath copiedPath = SharedFile.copyToLocal(new ReadOnlySharedFileEntryDescriptor(new FilesystemName("D1026_BAK.png"),
                イメージ情報.getイメージ共有ファイルID()), new FilesystemPath(spoolWorkPath));
        if (copiedPath != null) {
            path = Path.combinePath(copiedPath.toRString(), new RString("D1026_BAK.png"));
        } else {
            copiedPath = SharedFile.copyToLocal(new ReadOnlySharedFileEntryDescriptor(new FilesystemName("D1026.png"),
                    イメージ情報.getイメージ共有ファイルID()), new FilesystemPath(spoolWorkPath));
            path = Path.combinePath(copiedPath.toRString(), new RString("D1026.png"));
        }
        return path;
    }
}
