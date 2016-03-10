/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosatokkishokai;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.chosatokkishokai.ChosaTokkiShokaiJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShokai.ChosaTokkiShokai.ChosaTokkiShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査特記事項照会のDivControllerです。
 */
public class ChosaTokkiShokai {

    /**
     * 画面初期化
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onLoad(ChosaTokkiShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(div.getShinseishoKanriNo());
        int 認定調査依頼履歴番号 = Integer.parseInt(div.getNinteichosaRirekiNo().toString());
        ArrayList<RString> 認定調査特記事項番号List = DataPassingConverter.deserialize(div.getNinteichosaTokkijikoNoList(), ArrayList.class);
        div.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号List);
        return ResponseData.of(div).respond();
    }

    /**
     * 前へを押下
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onClick_btnBeforeTokkiJiko(ChosaTokkiShokaiDiv div) {
        ArrayList<ArrayList<ChosaTokkiShokaiJoho>> 認定調査特記事項List
                = ViewStateHolder.get(ChosaTokkiShokaiDiv.ChosaTokkiShokaiKey.認定調査特記事項List, ArrayList.class);
        int 連番PageNo = Integer.parseInt(div.getRembanPageNo().toString());
        div.setRembanPageNo(new RString(String.valueOf(連番PageNo - 1)));
        div.initializa(認定調査特記事項List.get(Integer.parseInt(div.getTokkijikoNoPageNo().toString())).get(連番PageNo - 1));
        return ResponseData.of(div).respond();
    }

    /**
     * 次へを押下
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onClick_btnAfterTokkiJiko(ChosaTokkiShokaiDiv div) {
        ArrayList<ArrayList<ChosaTokkiShokaiJoho>> 認定調査特記事項List
                = ViewStateHolder.get(ChosaTokkiShokaiDiv.ChosaTokkiShokaiKey.認定調査特記事項List, ArrayList.class);
        int 連番PageNo = Integer.parseInt(div.getRembanPageNo().toString());
        div.setRembanPageNo(new RString(String.valueOf(連番PageNo + 1)));
        div.initializa(認定調査特記事項List.get(Integer.parseInt(div.getTokkijikoNoPageNo().toString())).get(連番PageNo + 1));
        return ResponseData.of(div).respond();
    }

    /**
     * 前へ特記事項番号を押下
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onClick_btnBeforeTokkiJikoNo(ChosaTokkiShokaiDiv div) {
        ArrayList<ArrayList<ChosaTokkiShokaiJoho>> 認定調査特記事項List
                = ViewStateHolder.get(ChosaTokkiShokaiDiv.ChosaTokkiShokaiKey.認定調査特記事項List, ArrayList.class);
        int 特記事項番号PageNo = Integer.parseInt(div.getTokkijikoNoPageNo().toString());
        div.setRembanPageNo(new RString("0"));
        div.setTokkijikoNoPageNo(new RString(String.valueOf(特記事項番号PageNo - 1)));
        ArrayList<ChosaTokkiShokaiJoho> list = 認定調査特記事項List.get(特記事項番号PageNo - 1);
        div.setMaxRemban(new RString(list.get(list.size() - 1).get特記情報().get認定調査特記事項連番().toString()));
        div.initializa(認定調査特記事項List.get(特記事項番号PageNo - 1).get(0));
        return ResponseData.of(div).respond();
    }

    /**
     * 次へ特記事項番号を押下
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onClick_btnAfterTokkiJikoNo(ChosaTokkiShokaiDiv div) {
        ArrayList<ArrayList<ChosaTokkiShokaiJoho>> 認定調査特記事項List
                = ViewStateHolder.get(ChosaTokkiShokaiDiv.ChosaTokkiShokaiKey.認定調査特記事項List, ArrayList.class);
        int 特記事項番号PageNo = Integer.parseInt(div.getTokkijikoNoPageNo().toString());
        div.setRembanPageNo(new RString("0"));
        div.setTokkijikoNoPageNo(new RString(String.valueOf(特記事項番号PageNo + 1)));
        ArrayList<ChosaTokkiShokaiJoho> list = 認定調査特記事項List.get(特記事項番号PageNo + 1);
        div.setMaxRemban(new RString(list.get(list.size() - 1).get特記情報().get認定調査特記事項連番().toString()));
        div.initializa(認定調査特記事項List.get(特記事項番号PageNo + 1).get(0));
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るを押下
     *
     * @param div ChosaTokkiShokaiDiv
     * @return ResponseData<FukaTaishoshaSearchDiv>
     */
    public ResponseData<ChosaTokkiShokaiDiv> onClick_btnReturn(ChosaTokkiShokaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("親画面へ戻ります、")).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

}
