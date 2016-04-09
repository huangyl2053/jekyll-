/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011.ShikakuShutokuIdoTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 資格取得異動のHandlerクラスです。
 */
public class ShiKaKuSyuToKuIdouTotalHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
    private static final RString 状態_登録 = new RString("登録");

    private static final RString FIRSTREQUEST以外 = new RString("2");
    private RString 状態_被保履歴タブ = RString.EMPTY;
    private RString 状態_医療保険タブ = RString.EMPTY;
    private RString 状態_老福年金タブ = RString.EMPTY;
    private RString 状態_施設入退所タブ = RString.EMPTY;

    /**
     * テストデータ
     */
    private static HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("0000000001"));
    private static RString 表示モード = new RString("HihokenrirekiNashiMode");
    private static ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("000001"));

    private final ShikakuShutokuIdoTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格取得異動Div
     */
    public ShiKaKuSyuToKuIdouTotalHandler(ShikakuShutokuIdoTotalDiv div) {
        this.div = div;
    }

    /**
     * 資格取得異動の初期化します。
     *
     */
    public void load() {
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(new ShikibetsuCode(RString.EMPTY));
        // TODO:　
        ViewStateHolder.put(ViewStateKeys.医療保険情報_識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.医療保険情報_市町村コード, LasdecCode.EMPTY);
        ViewStateHolder.put(ViewStateKeys.医療保険情報_モード, 状態_登録);
        onOpenTplDefault();
    }

    private void kaigoShikakuKihon_onload(HihokenshaNo 被保険者番号, RString 表示モード) {
        if (!RString.isNullOrEmpty(表示モード)) {
            if (認定履歴ボタン.equals(表示モード)) {
                div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(false);
                div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
            } else if (被保履歴ボタン.equals(表示モード)) {
                div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
                div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(false);
            }
        }

        // 楊さん指示より、以下実行です。
        if (!RString.isNullOrEmpty(被保険者番号.getColumnValue())) {
            div.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        }
    }

    private void kaigoNinteiAtenaInfo_onload(ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(識別コード);
    }

    /**
     * 被保履歴タブを打開です。
     *
     */
    public void onOpenTplDefault() {
        if (!状態_被保履歴タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().initialize(被保険者番号, 識別コード);
            状態_被保履歴タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 医療保険タブを打開です。
     *
     */
    public void onOpenTplIryou() {
        if (!状態_医療保険タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().initialize(状態_登録, 識別コード.getColumnValue());
            状態_医療保険タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 老福年金タブを打開です。
     *
     */
    public void onOpenTplRoNen() {
        if (!状態_老福年金タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().initialize(識別コード, 被保険者番号);
            状態_老福年金タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 施設入退所タブを打開です。
     *
     */
    public void onOpenTplShisetsu() {
        if (!状態_施設入退所タブ.equals(FIRSTREQUEST以外)) {
            div.getShikakuShutokuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().initialize(識別コード);
            状態_施設入退所タブ = FIRSTREQUEST以外;
        }
    }

    /**
     * 保存処理します。
     *
     */
    public void save() {
        // 資格得喪履歴  楊さんの状態は確認を待ち

        // 医療保険タブ
        div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki().save();
        // 老福年金タブ
        RoreiFukushiNenkinJukyushaManager roreiManager = RoreiFukushiNenkinJukyushaManager.createInstance();
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> models = ViewStateHolder
                .get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.老齢福祉年金情報_老齢福祉年金情報検索結果一覧, Models.class);
        while (models.iterator().hasNext()) {
            roreiManager.save老齢福祉年金受給者(models.iterator().next());
        }
        // 施設入退所タブ
        div.getShikakuShutokuJoho().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
    }
}
