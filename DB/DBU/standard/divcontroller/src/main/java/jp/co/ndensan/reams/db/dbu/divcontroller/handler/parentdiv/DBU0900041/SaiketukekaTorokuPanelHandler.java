package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900041;

import jp.co.ndensan.reams.db.dbu.business.core.saiketukekameisaijoho.SaiketukekaMeisaiJohoData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041.SaiketukekaTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbu.service.core.saiketukekatoroku.SaiketukekaToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 裁決結果登録_登録DivのHandlerクラスです。
 *
 * @reamsid_L DBU-1080-110 xuyue
 */
public class SaiketukekaTorokuPanelHandler {

    private final SaiketukekaTorokuPanelDiv div;
    private static final RString 更新ボタン = new RString("btnUpdate");

    /**
     * コンストラクタです。
     *
     * @param div 裁決結果登録Divのエンティティ
     */
    public SaiketukekaTorokuPanelHandler(SaiketukekaTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 裁決結果登録修正状態の初期化です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 審査請求届出日 審査請求届出日
     *
     * @return 修正前の値
     */
    public RString 修正_初期化の編集(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {

        初期化の編集(識別コード, 被保険者番号, 審査請求届出日);
        活性の恢復();
        RString 修正前の値 = 初期画面値の保持();
        共有子DIVの初期化(識別コード, 被保険者番号);
        return 修正前の値;
    }

    /**
     * 裁決結果登録削除状態の初期化です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 審査請求届出日 審査請求届出日
     */
    public void 削除_初期化の編集(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {

        初期化の編集(識別コード, 被保険者番号, 審査請求届出日);
        削除状態の非活性();
        共有子DIVの初期化(識別コード, 被保険者番号);
    }

    private void 初期化の編集(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {

        裁決結果登録明細情報の編集(識別コード, 被保険者番号, 審査請求届出日);
    }

    private void 共有子DIVの初期化(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {

        div.getAtenaInfoCommonChildDiv().initialize(識別コード);
        div.getKaigoShikakuKihonCommonChildDiv().initialize(被保険者番号);
    }

    /**
     * 裁決結果登録明細情報エリアの初期画面値の保持です。
     *
     * @return 修正前の値
     */
    public RString 初期画面値の保持() {

        RString 裁決結果 = div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka().getText();
        RString 裁決理由 = div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu().getText();
        RString 弁明書作成日 = div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().getText();

        RString 修正前の値 = RString.EMPTY;
        if (裁決結果 != null) {
            修正前の値 = 修正前の値.concat(裁決結果);
        }
        if (裁決理由 != null) {
            修正前の値 = 修正前の値.concat(裁決理由);
        }
        if (弁明書作成日 != null) {
            修正前の値 = 修正前の値.concat(弁明書作成日);
        }
        return 修正前の値;
    }

    private void 削除状態の非活性() {
        div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().setReadOnly(true);
        div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu().setReadOnly(true);
        div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka().setReadOnly(true);
        CommonButtonHolder.setTextByCommonButtonFieldName(更新ボタン, "削除する");
    }

    private void 活性の恢復() {
        div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().setReadOnly(false);
        div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu().setReadOnly(false);
        div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka().setReadOnly(false);
        CommonButtonHolder.setTextByCommonButtonFieldName(更新ボタン, "保存する");
    }

    /**
     * 裁決結果登録明細情報エリアの修正後の値を取得します。
     *
     * @return 修正後の値
     */
    public RString get修正後の値() {

        RString 裁決結果val = div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka().getValue();
        RString 裁決理由val = div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu().getValue();
        RDate 弁明書作成日 = div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().getValue();

        RString 修正後の値 = RString.EMPTY;
        if (裁決結果val != null) {
            修正後の値 = 修正後の値.concat(裁決結果val);
        }
        if (裁決理由val != null) {
            修正後の値 = 修正後の値.concat(裁決理由val);
        }
        if (弁明書作成日 != null) {
            修正後の値 = 修正後の値.concat(弁明書作成日.toDateString());
        }
        return 修正後の値;
    }

    /**
     * 裁決結果登録明細情報を設定します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     */
    public void 裁決結果登録明細情報の編集(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {

        SaiketukekaToroku saiketukekaToroku = new SaiketukekaToroku();

        SaiketukekaMeisaiJohoData data = new SaiketukekaMeisaiJohoData(saiketukekaToroku.
                getSaiketukekaMeisaiJoho(識別コード, 被保険者番号, 審査請求届出日));

        div.getTxtMultiLineSaiketukeka().setValue(data.get裁決結果());
        div.getTxtMultiLineSaiketuRiyu().setValue(data.get裁決理由());
        if (data.get弁明書作成日() != null) {
            div.getTxtDateBenmeisyoSakuseibi().setValue(new RDate(data.get弁明書作成日().toString()));
        }
    }

    /**
     * 内容の破棄を行いました。
     */
    public void 内容の破棄() {

        div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi().clearValue();
        div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketuRiyu().clearValue();
        div.getSaiketukekaMeisaiPanel().getTxtMultiLineSaiketukeka().clearValue();
    }

    /**
     * Dbu900041Keys
     */
    public enum Dbu900041Keys {

        /**
         * 修正前の値
         */
        修正前の値,
    }

}
