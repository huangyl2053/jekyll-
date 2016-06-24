/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0130011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011.DBU0130011MainDiv;
import jp.co.ndensan.reams.db.dbu.service.core.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJohoBuilder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 老人保健受給者台帳管理ハンドラクラスです。
 *
 * @reamsid_L DBU-1110-010 zuotao
 */
public class DBU0130011MainHandler {

    private static final RString モード_データなし = new RString("0");

    private final DBU0130011MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 老人保健受給者台帳管理Div
     */
    public DBU0130011MainHandler(DBU0130011MainDiv div) {
        this.div = div;
    }

    /**
     * 老健受給情報を設定します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param モード モード
     * @param 老健受給情報 老健受給情報
     */
    public void update老健受給情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, RString モード, RojinHokenJukyushaJoho 老健受給情報) {
        if (モード_データなし.equals(モード)) {
            RojinHokenJukyushaJoho hokenJukyushaJoho = new RojinHokenJukyushaJoho(識別コード);
            RojinHokenJukyushaJohoBuilder builder = hokenJukyushaJoho.createBuilderForEdit();
            builder.set市町村コード(new LasdecCode(RoujinHokenJukyushaDaichoKanriManager.createInstance().get宛名情報(識別コード)));
            if (div.getTxtRoukenShichosonNo().getValue() == null) {
                builder.set老人保健市町村コード(RString.EMPTY);
            } else {
                builder.set老人保健市町村コード(div.getTxtRoukenShichosonNo().getValue());
            }
            builder.set被保険者番号(被保険者番号);
            builder.set老人保健受給者番号(div.getTxtRokenJukyushaNo().getValue());
            RoujinHokenJukyushaDaichoKanriManager.createInstance().updateRoukenJukyuJoho(builder.build(), EntityDataState.Added);
        } else {
            RojinHokenJukyushaJohoBuilder builder = 老健受給情報.createBuilderForEdit();
            if (div.getTxtRoukenShichosonNo().getValue() == null) {
                builder.set老人保健市町村コード(RString.EMPTY);
            } else {
                builder.set老人保健市町村コード(div.getTxtRoukenShichosonNo().getValue());
            }
            builder.set老人保健受給者番号(div.getTxtRokenJukyushaNo().getValue());
            RoujinHokenJukyushaDaichoKanriManager.createInstance().updateRoukenJukyuJoho(builder.build(), EntityDataState.Modified);
        }
    }
}
