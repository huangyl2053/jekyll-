/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokki;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210002.GaikyoTokkiNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.gaikyotokki.GaikyoTokkiManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 概況特記登録のHandlerクラスです。
 *
 * @reamsid_L DBE-0040-020 xuyue
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
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @param 調査実施日 調査実施日
     * @param 調査実施場所 調査実施場所
     * @param 実施場所名称 実施場所名称
     * @param 所属機関 所属機関
     * @param 記入者 記入者
     * @param 調査区分 調査区分
     * @return 認定調査票（概況特記）
     */
    public GaikyoTokki initialize(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号,
            RString 調査実施日, RString 調査実施場所, RString 実施場所名称,
            RString 所属機関, RString 記入者, RString 調査区分) {

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        model.set調査実施日(調査実施日);
        model.set調査実施場所(調査実施場所);
        model.set実施場所名称(実施場所名称);
        model.set所属機関(所属機関);
        model.set記入者(記入者);
        model.set調査区分(調査区分);
        model.set申請書管理番号(申請書管理番号.getColumnValue());

        div.getChosaTaisho().getCcdNinteiShinseishaKihonInfo().initialize(申請書管理番号);
        div.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon().initialize(申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getCcdChosaJisshishaJoho().intialize(model);

        GaikyoTokkiManager manager = new GaikyoTokkiManager();
        RString 概況調査テキストイメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        GaikyoTokki gaikyoTokki = manager.get認定調査票_概況特記(申請書管理番号, 認定調査履歴番号, 概況調査テキストイメージ区分);
        if (gaikyoTokki != null) {
            div.getTxtJutakuKaishu().setValue(gaikyoTokki.get住宅改修());
            div.getTxtChosaTaishoShuso().setValue(gaikyoTokki.get概況特記事項_主訴());
            div.getTxtChosaTishoKazokuJokyo().setValue(gaikyoTokki.get概況特記事項_家族状況());
            div.getTxtChosaTaishoKyojuKankyo().setValue(gaikyoTokki.get概況特記事項_居住環境_());
            div.getTxtNichijoShiyoKikiUmu().setValue(gaikyoTokki.get概況特記事項_機器_器械());
        } else {
            div.getTxtJutakuKaishu().setValue(RString.EMPTY);
            div.getTxtChosaTaishoShuso().setValue(RString.EMPTY);
            div.getTxtChosaTishoKazokuJokyo().setValue(RString.EMPTY);
            div.getTxtChosaTaishoKyojuKankyo().setValue(RString.EMPTY);
            div.getTxtNichijoShiyoKikiUmu().setValue(RString.EMPTY);
        }
        return gaikyoTokki;
    }

    /**
     * 前回値をコピーします。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void zenkaiCopy(ShinseishoKanriNo 申請書管理番号) {

        ShinseishoKanriNo 前回申請管理番号;
        int 前回最大認定調査依頼履歴番号 = 0;

        ShinseiRirekiJohoManager shinseiRirekiJohoManager = new ShinseiRirekiJohoManager();
        ShinseiRirekiJoho shinseiRirekiJoho = shinseiRirekiJohoManager.get申請履歴情報ByKey(申請書管理番号);
        if (shinseiRirekiJoho != null) {
            前回申請管理番号 = shinseiRirekiJoho.get前回申請管理番号();

            NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
            List<NinteichosaIraiJoho> ninteichosaIraiJohoList = ninteichosaIraiJohoManager.get認定調査依頼情報リストBy申請書管理番号(前回申請管理番号);
            for (NinteichosaIraiJoho ninteichosaIraiJoho : ninteichosaIraiJohoList) {
                前回最大認定調査依頼履歴番号 = ninteichosaIraiJoho.get認定調査依頼履歴番号() > 前回最大認定調査依頼履歴番号
                        ? ninteichosaIraiJoho.get認定調査依頼履歴番号() : 前回最大認定調査依頼履歴番号;
            }

            GaikyoTokkiManager manager = new GaikyoTokkiManager();
            RString 概況調査テキストイメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            GaikyoTokki gaikyoTokki = manager.get認定調査票_概況特記(前回申請管理番号, 前回最大認定調査依頼履歴番号, 概況調査テキストイメージ区分);
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
     * 入力内容を廃棄します。
     *
     * @param gaikyoTokki 初期の概況特記
     */
    public void resetData(GaikyoTokki gaikyoTokki) {
        if (gaikyoTokki != null) {
            div.getTxtJutakuKaishu().setValue(gaikyoTokki.get住宅改修());
            div.getTxtChosaTaishoShuso().setValue(gaikyoTokki.get概況特記事項_主訴());
            div.getTxtChosaTishoKazokuJokyo().setValue(gaikyoTokki.get概況特記事項_家族状況());
            div.getTxtChosaTaishoKyojuKankyo().setValue(gaikyoTokki.get概況特記事項_居住環境_());
            div.getTxtNichijoShiyoKikiUmu().setValue(gaikyoTokki.get概況特記事項_機器_器械());
        }

    }

}
