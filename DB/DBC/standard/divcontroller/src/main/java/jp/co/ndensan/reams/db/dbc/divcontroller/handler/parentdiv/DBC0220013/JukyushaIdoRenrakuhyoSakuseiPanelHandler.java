/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220013;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMN83001_受給者異動連絡票作成です
 *
 * @reamsid_L DBC-2102-010 lihang
 */
public class JukyushaIdoRenrakuhyoSakuseiPanelHandler {

    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private final JukyushaIdoRenrakuhyoSakuseiPanelDiv div;

    /**
     * コンストラクタです。
     *
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     */
    public JukyushaIdoRenrakuhyoSakuseiPanelHandler(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        this.div = div;
    }

    /**
     * 受給者訂正連絡票Entityです
     *
     * @param 作成年月日 FlexibleDate
     * @param 氏名性別生年月日を印字する RString
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者訂正連絡票Entity(
            FlexibleDate 作成年月日, RString 氏名性別生年月日を印字する) {
        JukyushaIdoRenrakuhyoTorokuEntity entity = div.getCcdJukyushaIdoRenrakuhyo().get受給者訂正連絡票Entity();
        entity.set作成年月日(作成年月日);
        entity.set氏名性別生年月日を印字する(氏名性別生年月日を印字する);
        return entity;
    }

    /**
     * 受給者異動連絡票Entityです
     *
     * @param 作成年月日 FlexibleDate
     * @param 氏名性別生年月日を印字する RString
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者異動連絡票Entity(
            FlexibleDate 作成年月日, RString 氏名性別生年月日を印字する) {
        JukyushaIdoRenrakuhyoTorokuEntity entity
                = div.getCcdJukyushaIdoRenrakuhyo().get受給者異動連絡票Entity();
        entity.set作成年月日(作成年月日);
        entity.set氏名性別生年月日を印字する(氏名性別生年月日を印字する);
        return entity;
    }

}
