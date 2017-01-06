/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.onseifileoperator;

import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator.OnseiFileOperatorDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator.OnseiFileOperatorHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;

/**
 * 音声情報操作用共有子Divのコントローラクラスです。
 */
public class OnseiFileOperator {

    private static final RString 連結文字列 = new RString("-");
    private static final RString 拡張子文字列 = new RString(".mp3");

    public IDownLoadServletResponse onClick_btnDownload(OnseiFileOperatorDiv div, IDownLoadServletResponse response) {
        response.setFileName(getFilename(div));
        response.writeData(get音声情報(div));
        return response;
    }

    public ResponseData<OnseiFileOperatorDiv> onClick_btnDelete(OnseiFileOperatorDiv div) {
        delete音声情報(div);
        OnseiFileOperatorHandler handler = new OnseiFileOperatorHandler(div);
        handler.set削除状態();
        return ResponseData.of(div).respond();
    }

    private void delete音声情報(OnseiFileOperatorDiv div) {
        OnseiFileOperatorHandler handler = new OnseiFileOperatorHandler(div);
        ShinsakaiOnseiJohoManager manager = ShinsakaiOnseiJohoManager.createInstance();
        ShinsakaiOnseiJoho2 介護認定審査会音声情報 = manager.get介護認定審査会音声情報(handler.get審査会管理番号(), handler.get連番());
        介護認定審査会音声情報 = 介護認定審査会音声情報.deleted();
        manager.save介護認定審査会音声情報(介護認定審査会音声情報);
    }

    private RString getFilename(OnseiFileOperatorDiv div) {
        OnseiFileOperatorHandler handler = new OnseiFileOperatorHandler(div);
        return handler.get審査会管理番号()
                .concat(連結文字列)
                .concat(new RString(handler.get連番()))
                .concat(拡張子文字列);
    }

    private byte[] get音声情報(OnseiFileOperatorDiv div) {
        OnseiFileOperatorHandler handler = new OnseiFileOperatorHandler(div);
        ShinsakaiOnseiJohoManager manager = ShinsakaiOnseiJohoManager.createInstance();
        ShinsakaiOnseiJoho2 介護認定審査会音声情報 = manager.get介護認定審査会音声情報(handler.get審査会管理番号(), handler.get連番());
        return 介護認定審査会音声情報.get審査会音声ファイル();
    }
}
