/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220013;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 画面設計_DBCMN83001_受給者異動連絡票作成です
 *
 * @reamsid_L DBC-2102-010 lihang
 */
public class JukyushaIdoRenrakuhyoSakuseiPanelHandler {

    private final JukyushaIdoRenrakuhyoSakuseiPanelDiv div;
    private static final RString CODE_ミ = new RString("0003");
    private static final RString 被保番号 = new RString("被保険者番号");

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
        JukyushaIdoRenrakuhyoTorokuEntity entity = div.getCcdJukyushaIdoRenrakuhyo().
                get受給者訂正連絡票Entity(作成年月日, 氏名性別生年月日を印字する);
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

    /**
     * アクセスログの出力です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 RString
     * @return PersonalData
     */
    public PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code(CODE_ミ), 被保番号, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }

}
