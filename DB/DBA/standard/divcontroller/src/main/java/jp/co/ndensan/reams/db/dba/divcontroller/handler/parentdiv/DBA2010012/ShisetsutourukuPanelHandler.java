/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010012;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012.ShisetsutourukuPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 施設登録のクラスです。
 *
 * @reamsid_L DBA-0340-040 wanghui
 */
public class ShisetsutourukuPanelHandler {

    private static final RString 追加 = new RString("追加状態");
    private static final RString 修正 = new RString("修正状態");
    private static final RString 削除 = new RString("削除状態");
    private static final RString 照会 = new RString("照会状態");
    private static final RString その他特例施設 = new RString("2");
    private static final RString 管内 = new RString("1");
    private final ShisetsutourukuPanelDiv div;

    /**
     * コンストラクタ。
     *
     * @param div ShisetsutourukuPanelDiv
     */
    public ShisetsutourukuPanelHandler(ShisetsutourukuPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     */
    public void initialize() {
        if (追加.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            追加_状態();
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            修正_状態();
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            削除_状態();
        }
        if (照会.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            削除_状態();
        }
    }

    private void 追加_状態() {
        div.getJigyoshaShurui().getRadServiceShurui().setSelectedKey(その他特例施設);
        div.getShisetsuJoho().getRadShisetsuKannaiKangaiKubun().setSelectedKey(管内);
    }

    /**
     * 施設情報エリア。
     *
     * @param list 事業者情報エリア内容
     */
    public void set施設情報エリア(List<KaigoJogaiTokureiTaishoShisetsu> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                KaigoJogaiTokureiTaishoShisetsu business = list.get(i);
                div.getTxtShisetsuYukoKaishiYMD().setValue(business.get有効開始年月日() == null
                        ? FlexibleDate.EMPTY : business.get有効開始年月日());
                div.getTxtShisetsuYukoShuryoYMD().setValue(business.get有効終了年月日() == null
                        ? FlexibleDate.EMPTY : business.get有効終了年月日());
                div.getRadShisetsuKannaiKangaiKubun().setSelectedKey(business.get管内_管外区分() == null
                        ? RString.EMPTY : business.get管内_管外区分());
                div.getTxtShisetsuJigyoshaNo().setValue(business.get事業者番号() == null
                        ? RString.EMPTY : business.get事業者番号());
                div.getTxtShisetsuJigyoshaName().setValue(business.get事業者名称().value() == null
                        ? RString.EMPTY : business.get事業者名称().value());
                div.getTxtShisetsuJigyoshaNameKana().setValue(business.get事業者名称カナ().value() == null
                        ? RString.EMPTY : business.get事業者名称カナ().value());
                div.getTxtShisetsuRyakusho();
                div.getTxtShisetsuRyakushoKana();
                div.getTxtShisetsuJigyoKaishiYMD().setValue(business.get事業開始年月日() == null
                        ? FlexibleDate.EMPTY : business.get事業開始年月日());
                div.getTxtShisetsuJigyoKyushuYMD().setValue(business.get事業休止年月日() == null
                        ? FlexibleDate.EMPTY : business.get事業休止年月日());
                div.getTxtShisetsuJigyoSaikaiYMD().setValue(business.get事業再開年月日() == null
                        ? FlexibleDate.EMPTY : business.get事業再開年月日());
                div.getTxtShisetsuJigyoHaishiYMD().setValue(business.get事業廃止年月日() == null
                        ? FlexibleDate.EMPTY : business.get事業廃止年月日());
                div.getTxtShisetsuYubinNo().setValue(business.get郵便番号() == null
                        ? YubinNo.EMPTY : business.get郵便番号());
                div.getTxtShisetsuTelNo().setValue(business.get電話番号().value() == null
                        ? RString.EMPTY : business.get電話番号().value());
                div.getTxtShisetsuFaxNo().setValue(business.getFAX番号().value() == null
                        ? RString.EMPTY : business.getFAX番号().value());
                div.getTxtShisetsuJusho().setValue(business.get事業者住所() == null
                        ? RString.EMPTY : business.get事業者住所());
                div.getTxtShisetsuJushoKana().setValue(business.get事業者住所カナ() == null
                        ? RString.EMPTY : business.get事業者住所カナ());
                div.getTxtShisetsuDaihyoshaName().setValue(business.get代表者名称().value() == null
                        ? RString.EMPTY : business.get代表者名称().value());
                div.getTxtShisetsuDaihyoshaNameKana().setValue(business.get代表者名称カナ().value());
                div.getTxtShisetsuYakushoku().setValue(business.get役職());
                div.getTxtShisetsuBiko().setValue(business.get備考());
            }
        }
    }

    private void 修正_状態() {
        div.getJigyoshaShurui().getRadServiceShurui().setSelectedKey(その他特例施設);
        div.getShisetsuJoho().getRadShisetsuKannaiKangaiKubun().setSelectedKey(管内);
        div.getJigyoshaShurui().getRadServiceShurui().setDisabled(true);
    }

    private void 削除_状態() {
        div.getJigyoshaShurui().getRadServiceShurui().setSelectedKey(その他特例施設);
        div.getShisetsuJoho().getRadShisetsuKannaiKangaiKubun().setSelectedKey(管内);
        div.getJigyoshaShurui().getRadServiceShurui().setDisabled(true);
        div.getShisetsuJoho().setDisabled(true);
    }

    /**
     * 事業者種類の変更。
     */
    public void set事業者種類() {
        if (その他特例施設.equals(div.getRadShisetsuKannaiKangaiKubun().getSelectedKey())) {
            div.getRadShisetsuKannaiKangaiKubun().setVisible(true);
        } else {
            div.getRadShisetsuKannaiKangaiKubun().setVisible(false);
        }
    }
}
