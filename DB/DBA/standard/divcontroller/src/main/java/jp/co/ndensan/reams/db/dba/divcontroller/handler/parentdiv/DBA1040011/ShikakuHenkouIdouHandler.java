/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1040011;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1040011.ShikakuHenkouIdouDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 資格変更異動の抽象Handlerクラスです。
 *
 * @reamsid_L DBA-1370-030 chengsanyuan
 */
public class ShikakuHenkouIdouHandler {

    private static final RString MENUID_DBAMN23001 = new RString("DBAMN23001");
    private static final RString MENUID_DBAMN23002 = new RString("DBAMN23002");
    private static final RString MENUID_DBAMN23003 = new RString("DBAMN23003");
    private final ShikakuHenkouIdouDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuHenkouIdouDiv
     */
    public ShikakuHenkouIdouHandler(ShikakuHenkouIdouDiv div) {
        this.div = div;
    }

    /**
     * 資格変更異動初期化
     *
     * @param hihokensha 資格変更異動最新データ
     */
    public void load(HihokenshaShutokuJyoho hihokensha) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        div.getCcdHihosyosai().被保詳細モード(new RString("shokai"));
        div.getCcdHihosyosai().住所地特例表示タイプ(new RString("shokai"));
        div.getCcdHihosyosai().資格関連異動表示モード(new RString("toroku"));
        div.getCcdHihosyosai().施設入退所利用モード(new RString("被保険者対象機能"));
        div.getCcdHihosyosai().施設入退所表示モード(new RString("資格異動"));
        div.getCcdHihosyosai().施設入退所表示widthサイズ(new RString("モード1"));
        div.getCcdHihosyosai().施設入退所明細表示モード(new RString("追加_修正"));
        div.getCcdHihosyosai().initilize(
                hihokensha.get市町村コード(), 導入形態コード,
                hihokensha.get広住特措置元市町村コード(), hihokensha.get被保険者番号(),
                hihokensha.get異動日(), hihokensha.get枝番(),
                hihokensha.get識別コード(), hihokensha.get資格取得年月日(), DaichoType.被保険者.getコード());
        RString menuId = ResponseHolder.getMenuID();
        if (MENUID_DBAMN23001.equals(menuId)) {
            div.getCcdHihosyosai().setDdlHenkoJiyu(ShikakuHenkoJiyu.転居.getコード(), true);
        }
        if (MENUID_DBAMN23002.equals(menuId)) {
            div.getCcdHihosyosai().setDdlHenkoJiyu(ShikakuHenkoJiyu.氏名変更.getコード(), true);
        }
        if (MENUID_DBAMN23003.equals(menuId)) {
            div.getCcdHihosyosai().setDdlHenkoJiyu(ShikakuHenkoJiyu.その他.getコード(), false);
        }
    }

    public boolean isSavable() {
        return div.getCcdHihosyosai().is資格変更情報追加済み();
    }
}
