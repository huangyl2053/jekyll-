/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 共有子Div「訪問介護利用者負担額減額」のControllerクラスです。
 *
 * @reamsid_L DBD-3560-040 huangh
 */
public class HomonkaigoRiyoshaFutangakuGengaku {

    /**
     * 初期化処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv> onLoad(HomonkaigoRiyoshaFutangakuGengakuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtHiddenHihokenshaNo());
            if (被保険者番号 == null || 被保険者番号.isEmpty()) {
                throw new SystemException("被保険者番号が設定されていません。");
            }

            List<HomonKaigoRiyoshaFutangakuGengaku> 表示リスト = getHandler(div).表示リスト取得(被保険者番号);
            if (表示リスト == null || 表示リスト.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_申請情報なし.getMessage()).respond();
            } else {
                getHandler(div).initialize(表示リスト);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の選択処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv> onSelect_dgHomonkaigoRiyoshaFutangakuGengakuList(
            HomonkaigoRiyoshaFutangakuGengakuDiv div) {

        getHandler(div).詳細表示();
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じる処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<HomonkaigoRiyoshaFutangakuGengakuDiv> onClick_closeOK(HomonkaigoRiyoshaFutangakuGengakuDiv div) {

        return ResponseData.of(div).dialogOKClose();
    }

    private HomonkaigoRiyoshaFutangakuGengakuHandler getHandler(HomonkaigoRiyoshaFutangakuGengakuDiv div) {
        return new HomonkaigoRiyoshaFutangakuGengakuHandler(div);
    }
}
