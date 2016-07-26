/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.chosakekkainfogaikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyoHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_概況調査取得処理。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyo {

    private static final RString FILENAME_G0001 = new RString("G0001.png");

    /**
     * 認定調査結果情報照会_概況調査_一覧情報。
     *
     * @param div 認定調査結果情報照会_概況調査_一覧情報Div
     * @return 認定調査結果情報照会Div
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onLoad(ChosaKekkaInfoGaikyoDiv div) {
        RString 申請書管理番号 = div.getShinseishoKanriNo();
        int 認定調査依頼履歴番号 = Integer.parseInt(String.valueOf(div.getNinteichosaRirekiNo()));
        RString 概況調査テキスト_イメージ区分 = div.getGaikyoChosaTextImageKubun();
        RString 概況特記テキスト_イメージ区分 = div.getGaikyoTokkiTextImageKubun();
        ChosaKekkaInfoGaikyoParameter gaikyoParameter = ChosaKekkaInfoGaikyoParameter.
                createGamenParam(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキスト_イメージ区分, 概況特記テキスト_イメージ区分);
        List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList
                = ChosaKekkaInfoGaikyoFinder.createInstance().getChosaKekkaInfoGaikyo(gaikyoParameter).records();
        List<RembanServiceJokyoBusiness> serviceJokyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().getRembanServiceJokyo(gaikyoParameter).records();
        List<NinteichosahyoShisetsuRiyo> shisetsuRiyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().get5210NinteichosahyoShisetsu(gaikyoParameter).records();
        Image image = ChosaKekkaInfoGaikyoFinder.createInstance().DbT5115Image(gaikyoParameter);
        RString path = 共有ファイルを引き出す(image);
        getHandler(div).onLoad(chosaKekkaInfoGaikyoList, serviceJokyos, shisetsuRiyos, path);
        return createResponse(div);
    }

    /**
     * 戻るボタンを押下します。
     *
     * @param div 画面情報
     * @return 認定調査結果情報照会Div
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onClick_Moderu(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

    private RString 共有ファイルを引き出す(Image イメージ情報) {
        RString imagePath = RString.EMPTY;
        if (イメージ情報 != null) {
            imagePath = getFilePath(イメージ情報.getイメージ共有ファイルID(), FILENAME_G0001);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

    private ChosaKekkaInfoGaikyoHandler getHandler(ChosaKekkaInfoGaikyoDiv div) {
        return new ChosaKekkaInfoGaikyoHandler(div);
    }

    private ResponseData<ChosaKekkaInfoGaikyoDiv> createResponse(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

}
