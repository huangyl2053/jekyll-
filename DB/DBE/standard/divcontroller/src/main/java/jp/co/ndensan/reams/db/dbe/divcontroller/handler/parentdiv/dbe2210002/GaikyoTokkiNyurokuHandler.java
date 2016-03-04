/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210002.GaikyoTokkiNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.gaikyotokki.GaikyoTokkiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 特徴平準化（特徴6月分）のHandlerクラスです。
 *
 */
public class GaikyoTokkiNyurokuHandler {

    private final GaikyoTokkiNyurokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div コントロールdiv
     */
    public GaikyoTokkiNyurokuHandler(GaikyoTokkiNyurokuDiv div) {
        this.div = div;
    }

    /**
     * コントロールdivの初期処理です。
     */
    public void initialize() {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        RString 調査実施日 = ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class);
        RString 調査実施場所 = ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class);
        RString 実施場所名称 = ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class);
        RString 所属機関 = ViewStateHolder.get(ViewStateKeys.所属機関, RString.class);
        RString 記入者 = ViewStateHolder.get(ViewStateKeys.記入者, RString.class);
        RString 調査区分 = ViewStateHolder.get(ViewStateKeys.調査区分, RString.class);
        model.set調査実施日(調査実施日);
        model.set調査実施場所(調査実施場所);
        model.set実施場所名称(実施場所名称);
        model.set所属機関(所属機関);
        model.set記入者(記入者);
        model.set調査区分(調査区分);
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());

        //  TODO 共有子DIVが未実装
//        div.getChosaTaisho().getCcdKaigoNinteiShiseishaInfo().  // DBZ.KaigoNinteiShinseishaInfoのinitializeメソッドを呼ぶ
        div.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getCcdChosaJisshishaJoho().intialize(model);

        GaikyoTokkiManager manager = new GaikyoTokkiManager();
        //TODO primary key追加 概況調査テキストイメージ区分
        GaikyoTokki gaikyoTokki = manager.get認定調査票_概況特記(temp_申請書管理番号, temp_認定調査履歴番号, new RString("TODO"));
        if (gaikyoTokki != null) {
            div.getTxtJutakuKaishu().setValue(gaikyoTokki.get住宅改修());
            div.getTxtChosaTaishoShuso().setValue(gaikyoTokki.get概況特記事項_主訴());
            div.getTxtChosaTishoKazokuJokyo().setValue(gaikyoTokki.get概況特記事項_家族状況());
            div.getTxtChosaTaishoKyojuKankyo().setValue(gaikyoTokki.get概況特記事項_居住環境_());
            div.getTxtNichijoShiyoKikiUmu().setValue(gaikyoTokki.get概況特記事項_機器_器械());

            初期画面値の保持(RString.EMPTY, gaikyoTokki.get概況特記事項_主訴(), gaikyoTokki.get概況特記事項_家族状況(),
                    gaikyoTokki.get概況特記事項_居住環境_(), gaikyoTokki.get概況特記事項_機器_器械());
        } else {
            div.getTxtJutakuKaishu().setValue(RString.EMPTY);
            div.getTxtChosaTaishoShuso().setValue(RString.EMPTY);
            div.getTxtChosaTishoKazokuJokyo().setValue(RString.EMPTY);
            div.getTxtChosaTaishoKyojuKankyo().setValue(RString.EMPTY);
            div.getTxtNichijoShiyoKikiUmu().setValue(RString.EMPTY);

            初期画面値の保持(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }

    }

    private void 初期画面値の保持(RString 住宅改修, RString 主訴, RString 家族状況, RString 居住環境, RString 機器器械) {
        ViewStateHolder.put(Dbe2210002Keys.修正前の住宅改修, 住宅改修);
        ViewStateHolder.put(Dbe2210002Keys.修正前の主訴, 主訴);
        ViewStateHolder.put(Dbe2210002Keys.修正前の家族状況, 家族状況);
        ViewStateHolder.put(Dbe2210002Keys.修正前の居住環境, 居住環境);
        ViewStateHolder.put(Dbe2210002Keys.修正前の機器器械, 機器器械);
    }

    /**
     * 前回値をコピーします。
     */
    public void zenkaiCopy() {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        ShinseishoKanriNo 前回申請管理番号;
        int 前回最大認定調査依頼履歴番号 = 0;

        ShinseiRirekiJohoManager shinseiRirekiJohoManager = new ShinseiRirekiJohoManager();
        ShinseiRirekiJoho shinseiRirekiJoho = shinseiRirekiJohoManager.get申請履歴情報ByKey(temp_申請書管理番号);
        if (shinseiRirekiJoho != null) {
            前回申請管理番号 = shinseiRirekiJoho.get前回申請管理番号();

            NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
            List<NinteichosaIraiJoho> ninteichosaIraiJohoList = ninteichosaIraiJohoManager.get認定調査依頼情報リストBy申請書管理番号(前回申請管理番号);
            for (NinteichosaIraiJoho ninteichosaIraiJoho : ninteichosaIraiJohoList) {
                前回最大認定調査依頼履歴番号 = ninteichosaIraiJoho.get認定調査依頼履歴番号() > 前回最大認定調査依頼履歴番号
                        ? ninteichosaIraiJoho.get認定調査依頼履歴番号() : 前回最大認定調査依頼履歴番号;
            }

            GaikyoTokkiManager manager = new GaikyoTokkiManager();
            //TODO primary key追加 概況調査テキストイメージ区分
            GaikyoTokki gaikyoTokki = manager.get認定調査票_概況特記(前回申請管理番号, 前回最大認定調査依頼履歴番号, new RString("TODO"));
            if (gaikyoTokki != null) {
                div.getTxtJutakuKaishu().setValue(gaikyoTokki.get住宅改修());
                div.getTxtChosaTaishoShuso().setValue(gaikyoTokki.get概況特記事項_主訴());
                div.getTxtChosaTishoKazokuJokyo().setValue(gaikyoTokki.get概況特記事項_家族状況());
                div.getTxtChosaTaishoKyojuKankyo().setValue(gaikyoTokki.get概況特記事項_居住環境_());
                div.getTxtNichijoShiyoKikiUmu().setValue(gaikyoTokki.get概況特記事項_機器_器械());
            }
        }
    }

    /**
     * 入力内容を取り消します。
     */
    public void resetData() {
        div.getTxtJutakuKaishu().setValue(ViewStateHolder.get(Dbe2210002Keys.修正前の住宅改修, RString.class));
        div.getTxtChosaTaishoShuso().setValue(ViewStateHolder.get(Dbe2210002Keys.修正前の主訴, RString.class));
        div.getTxtChosaTishoKazokuJokyo().setValue(ViewStateHolder.get(Dbe2210002Keys.修正前の家族状況, RString.class));
        div.getTxtChosaTaishoKyojuKankyo().setValue(ViewStateHolder.get(Dbe2210002Keys.修正前の居住環境, RString.class));
        div.getTxtNichijoShiyoKikiUmu().setValue(ViewStateHolder.get(Dbe2210002Keys.修正前の機器器械, RString.class));
    }

    /**
     * 親画面から渡された申請書管理番号を取得します。
     *
     * @return 親画面から渡された申請書管理番号
     */
    public ShinseishoKanriNo getTemp_申請書管理番号() {
        return ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
    }

    /**
     * 親画面から渡された認定調査履歴番号を取得します。
     *
     * @return 親画面から渡された認定調査履歴番号
     */
    public int getTemp_認定調査履歴番号() {
        return ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
    }

    /**
     * Dbe2210002Keys
     */
    public enum Dbe2210002Keys {

        /**
         * 修正前の住宅改修
         */
        修正前の住宅改修,
        /**
         * 修正前の主訴
         */
        修正前の主訴,
        /**
         * 修正前の家族状況
         */
        修正前の家族状況,
        /**
         * 修正前の居住環境
         */
        修正前の居住環境,
        /**
         * 修正前の機器器械
         */
        修正前の機器器械

    }

}
