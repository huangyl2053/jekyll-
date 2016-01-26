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

        // test用
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(new RString("22")));
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, 1);
        RString temp_調査実施者情報 = RString.EMPTY;  // TODO 利用されていない  del

//        div.getChosaTaisho().getCcdKaigoNinteiShiseishaInfo().  // DBZ.KaigoNinteiShinseishaInfoのinitializeメソッドを呼ぶ
//        div.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon().   // DBZ.NinteiShinseiRenrakusakiKihonのinitializeメソッドを呼ぶ
//        div.getCcdChosaJisshishaJoho().   // DBZ.ChosaJisshishaJohoのinitializeメソッドを呼ぶ
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        GaikyoTokkiManager manager = new GaikyoTokkiManager();
        GaikyoTokki gaikyoTokki = manager.get認定調査票_概況特記(temp_申請書管理番号, temp_認定調査履歴番号);
        // DbT5206GaikyoTokki
        if (gaikyoTokki != null) {
            div.getTxtJutakuKaishu().setValue(RString.EMPTY);  // 在宅改修  TODO テーブルにこの項目がない
            div.getTxtChosaTaishoShuso().setValue(gaikyoTokki.get概況特記事項_主訴());  // 概況特記事項（主訴）
            div.getTxtChosaTishoKazokuJokyo().setValue(gaikyoTokki.get概況特記事項_家族状況()); // 概況特記事項（家族状況）
            div.getTxtChosaTaishoKyojuKankyo().setValue(gaikyoTokki.get概況特記事項_居住環境_());  // 概況特記事項（居住環境） 
            div.getTxtNichijoShiyoKikiUmu().setValue(gaikyoTokki.get概況特記事項_機器_器械());  // 概況特記事項（機器・器械）
        } else {
            div.getTxtJutakuKaishu().setValue(RString.EMPTY);
            div.getTxtChosaTaishoShuso().setValue(RString.EMPTY);
            div.getTxtChosaTishoKazokuJokyo().setValue(RString.EMPTY);
            div.getTxtChosaTaishoKyojuKankyo().setValue(RString.EMPTY);
            div.getTxtNichijoShiyoKikiUmu().setValue(RString.EMPTY);
        }

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
            GaikyoTokki gaikyoTokki = manager.get認定調査票_概況特記(前回申請管理番号, 前回最大認定調査依頼履歴番号);
            if (gaikyoTokki != null) {
                // TODO 住宅改修 74645
                div.getTxtChosaTaishoShuso().setValue(gaikyoTokki.get概況特記事項_主訴());  // 概況特記事項（主訴）
                div.getTxtChosaTishoKazokuJokyo().setValue(gaikyoTokki.get概況特記事項_家族状況()); // 概況特記事項（家族状況）
                div.getTxtChosaTaishoKyojuKankyo().setValue(gaikyoTokki.get概況特記事項_居住環境_());  // 概況特記事項（居住環境） 
                div.getTxtNichijoShiyoKikiUmu().setValue(gaikyoTokki.get概況特記事項_機器_器械());  // 概況特記事項（機器・器械）
            }
        }
    }

    /**
     * 入力内容を取り消します。
     */
    public void clearData() {
        div.getTxtJutakuKaishu().clearValue();
        div.getTxtChosaTaishoShuso().clearValue(); // 概況特記事項（主訴）
        div.getTxtChosaTishoKazokuJokyo().clearValue(); // 概況特記事項（家族状況）
        div.getTxtChosaTaishoKyojuKankyo().clearValue();  // 概況特記事項（居住環境） 
        div.getTxtNichijoShiyoKikiUmu().clearValue();  // 概況特記事項（機器・器械）
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

}
