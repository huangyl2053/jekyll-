/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiranDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiranHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 共有子Div「居宅計画」のControllerクラスです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
public class KyotakuServiceKeikakuIchiran {

    /**
     * 初期化処理です。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onLoad(KyotakuServiceKeikakuIchiranDiv div) {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHiddenHihokenshaNo());
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new SystemException("被保険者番号が設定されていません。");
        }
        getHandler(div).initialize(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅サービス一覧より選択ボタンです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClick_select(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).select();
        return ResponseData.of(div).respond();
    }

    /**
     * 計画依頼受付情報ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClick_btnKeikakuIraiUketsuke(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).onClick_btnKeikakuIraiUketsuke();
        return ResponseData.of(div).respond();
    }

    /**
     * 自己作成計画情報ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClick_btnJikosakuseiKeikaku(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).onClick_btnJikosakuseiKeikaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅サービス情報ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClick_btnKyotakuService(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).onClick_btnKyotakuService();
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅サービス情報データグリッドを選択するです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onSelect_dgKyotakuService(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).onSelect_dgKyotakuService();
        return ResponseData.of(div).respond();
    }

    /**
     * 種類限度額確認ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClick_btnShuruiGendoGakuKakunin(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).onClick_btnShuruiGendoGakuKakunin();
        return ResponseData.of(div).respond();
    }

    /**
     * 計画依頼受付情報「閉じる」ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClickClose_keikakuIraiUketsuke(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).to状態１();
        return ResponseData.of(div).respond();
    }

    /**
     * 自己作成計画情報「閉じる」ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClickClose_jikosakuseiKeikaku(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).to状態１();
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅サービス明細「閉じる」ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClickClose_kyotakuServiceMeisai(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).to状態４();
        return ResponseData.of(div).respond();
    }

    /**
     * 種類限度確認「閉じる」ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClickClose_shuruiGendoGakuKakunin(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).to状態４();
        return ResponseData.of(div).respond();
    }

    /**
     * 居宅サービス情報「閉じる」ボタンをクリンクするです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<KyotakuServiceKeikakuIchiranDiv> onClickClose_kyotakuServiceJoho(KyotakuServiceKeikakuIchiranDiv div) {

        getHandler(div).to状態１();
        return ResponseData.of(div).respond();
    }

    private KyotakuServiceKeikakuIchiranHandler getHandler(KyotakuServiceKeikakuIchiranDiv div) {
        return new KyotakuServiceKeikakuIchiranHandler(div);
    }
}
