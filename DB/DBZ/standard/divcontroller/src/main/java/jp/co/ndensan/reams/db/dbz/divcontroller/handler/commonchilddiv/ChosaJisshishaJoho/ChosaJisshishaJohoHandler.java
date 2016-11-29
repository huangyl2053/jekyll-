/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ChosaJisshishaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho.ChosaJisshishaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author n3423
 */
public class ChosaJisshishaJohoHandler {

    private static final RString 照会状態 = new RString("ShokaiMode");
    private static final RString 単純入力状態 = new RString("SimpleInputMode");
    private static final RString 単純照会状態 = new RString("SimpleShokaiMode");
    private final ChosaJisshishaJohoDiv div;

    private static final RString SHOKAI_KEY = new RString("key0");
    private final ChosaJisshishaJohoFinder service;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ChosaJisshishaJohoHandler(ChosaJisshishaJohoDiv div) {
        this.div = div;
        service = ChosaJisshishaJohoFinder.createInstance();
    }

    /**
     * 調査実施者(記入者)Divの初期化します。
     *
     * @param key 親画面から受け取ったパラメータ
     */
    public void intialize(ChosaJisshishaJohoModel key) {
        if ("Input".equals(div.getMode_State().toString())) {
            setInput(key);
        } else {
            setShokai(key);
        }
    }

    private void setInput(ChosaJisshishaJohoModel key) {
        div.getTxtChosaJisshiDate().setValue(RString.isNullOrEmpty(key.get調査実施日()) ? RDate.getNowDate() : new RDate(key.get調査実施日().toString()));
        List<KeyValueDataSource> chosaJisshiBasho = new ArrayList<>();
        List<NinteiShinseiJoho> ninteiShinseiJohoList = service.get認定申請情報(key.get申請書管理番号()).records();
        if (ninteiShinseiJohoList != null && !ninteiShinseiJohoList.isEmpty()) {
            div.getTxtNinteiShinseiDate().setValue(ninteiShinseiJohoList.get(0).get認定申請年月日());
            List<KoseiShichosonMaster> koseiShichosonMasterList = service.get市町村コード(ninteiShinseiJohoList.get(0).get証記載保険者番号()).records();
            if (koseiShichosonMasterList != null && !koseiShichosonMasterList.isEmpty()) {
                div.setHdnShichosonCode(koseiShichosonMasterList.get(0).get市町村コード().value());
            }
        }
        chosaJisshiBasho.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosaJisshiBashoCode code : ChosaJisshiBashoCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getコード(), code.get名称());
            chosaJisshiBasho.add(data);
        }
        div.getDdlChosaJisshiBasho().setDataSource(chosaJisshiBasho);
        if (key.get調査実施場所() != null && !key.get調査実施場所().isEmpty()) {
            div.getDdlChosaJisshiBasho().setSelectedValue(key.get調査実施場所());
        }
        div.getTxtJisshiBashoMeisho().setValue(key.get実施場所名称());

        if (ChosaJisshiBashoCode.自宅内.getコード().equals(div.getDdlChosaJisshiBasho().getSelectedKey())
                || ChosaJisshiBashoCode.自宅外.getコード().equals(div.getDdlChosaJisshiBasho().getSelectedKey())) {
            div.getTxtJisshiBashoMeisho().setDisabled(true);
        } else {
            div.getTxtJisshiBashoMeisho().setDisabled(false);
        }

        if (key.get所属機関コード() != null && !key.get所属機関コード().isEmpty()) {
            div.getTxtShozokuKikanCode().setValue(key.get所属機関コード());
            this.onBlurTxtShozokuKikanCode();
        } else {
            List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = service.getSyozokuKikan(key.get申請書管理番号()).records();
            if (ninteichosaItakusakiJohoList != null && !ninteichosaItakusakiJohoList.isEmpty()) {
                div.getTxtShozokuKikanCode().setValue(ninteichosaItakusakiJohoList.get(0).get認定調査委託先コード());
                div.getTxtShozokuKikanName().setValue(ninteichosaItakusakiJohoList.get(0).get事業者名称());
            }
        }

        if (key.get記入者コード() != null && !key.get記入者コード().isEmpty()) {
            div.getTxtKinyushaCode().setValue(key.get記入者コード());
            this.onBlurTxtKinyushaCode();
        } else {
            List<ChosainJoho> chosainJohoList = service.getKinyusha(key.get申請書管理番号()).records();
            if (chosainJohoList != null && !chosainJohoList.isEmpty()) {
                div.getTxtKinyushaCode().setValue(chosainJohoList.get(0).get認定調査員コード());
                div.getTxtKinyushaName().setValue(chosainJohoList.get(0).get調査員氏名());
            }
        }

        List<NinteiShinseiJoho> ninteiShinseiJoho = service.get調査区分(key.
                get申請書管理番号()).records();
        if (!ninteiShinseiJoho.isEmpty()) {
            if (ninteiShinseiJoho.get(0).get調査区分() == null) {
                div.getTxtChosaKubun().setValue(RString.EMPTY);
            } else if (ChosaKubun.新規調査.getコード().equals(ninteiShinseiJoho.get(0).get調査区分().getColumnValue())) {
                div.getTxtChosaKubun().setValue(ChosaKubun.新規調査.get名称());
            } else if (ChosaKubun.再調査.getコード().equals(ninteiShinseiJoho.get(0).get調査区分().getColumnValue())) {
                div.getTxtChosaKubun().setValue(ChosaKubun.再調査.get名称());
            } else {
                div.getTxtChosaKubun().setValue(RString.EMPTY);
            }
        }
    }

    private void setShokai(ChosaJisshishaJohoModel key) {
        if (!RString.isNullOrEmpty(key.get認定申請日())) {
            div.getTxtNinteiShinseiDate().setValue(new FlexibleDate(key.get認定申請日()));
        }
        if (!RString.isNullOrEmpty(key.get調査実施日())) {
            div.getTxtChosaJisshiDate().setValue(new RDate(key.get調査実施日().toString()));
        }
        List<KeyValueDataSource> chosaJisshiBasho = new ArrayList<>();
        KeyValueDataSource chosaJisshi = new KeyValueDataSource(SHOKAI_KEY, key.get調査実施場所());
        chosaJisshiBasho.add(chosaJisshi);
        div.getDdlChosaJisshiBasho().setDataSource(chosaJisshiBasho);
        div.getDdlChosaJisshiBasho().setSelectedKey(SHOKAI_KEY);
        div.getTxtJisshiBashoMeisho().setValue(key.get実施場所名称());
        div.getTxtShozokuKikanCode().setValue(key.get所属機関コード());
        div.getTxtShozokuKikanName().setValue(key.get所属機関名称());
        div.getTxtKinyushaCode().setValue(key.get記入者コード());
        div.getTxtKinyushaName().setValue(key.get記入者名称());
        div.getTxtChosaKubun().setValue(key.get調査区分());
    }

    /**
     * (所属機関コード）引数から受け取った認定調査委託先情報を取得します。
     */
    public void onBlurTxtShozokuKikanCode() {
        ChosaJisshishaJohoFinder finder = ChosaJisshishaJohoFinder.createInstance();
        NinteichosaItakusakiJoho ninteichosaItakusakiJoho
                = finder.onBlurTxtShozokuKikanCode(new LasdecCode(div.getHdnShichosonCode()), div.getTxtShozokuKikanCode().getText());
        div.getTxtShozokuKikanName().setValue(ninteichosaItakusakiJoho == null ? RString.EMPTY
                : ninteichosaItakusakiJoho.get事業者名称() == null ? RString.EMPTY
                : ninteichosaItakusakiJoho.get事業者名称());
    }

    /**
     * (記入者コード）引数から受け取った調査員情報を取得します。
     */
    public void onBlurTxtKinyushaCode() {
        ChosaJisshishaJohoFinder finder = ChosaJisshishaJohoFinder.createInstance();
        ShinsakaiChosainJoho shinsakaiChosainJoho
                = finder.onBlurTxtKinyushaCode(
                        new LasdecCode(div.getHdnShichosonCode()),
                        new ChosaItakusakiCode(div.getTxtShozokuKikanCode().getText()),
                        new ChosainCode(div.getTxtKinyushaCode().getText()));
        div.getTxtKinyushaName().setValue(shinsakaiChosainJoho == null ? RString.EMPTY
                : shinsakaiChosainJoho.get調査員氏名() == null ? RString.EMPTY
                : shinsakaiChosainJoho.get調査員氏名());
    }

    /**
     * 調査実施場所ddl変更時のイベントメソッド
     */
    public void onChange_ddlChosaJisshiBasho() {
        if (ChosaJisshiBashoCode.自宅内.getコード().equals(div.getDdlChosaJisshiBasho().getSelectedKey())
                || ChosaJisshiBashoCode.自宅外.getコード().equals(div.getDdlChosaJisshiBasho().getSelectedKey())) {
            div.getTxtJisshiBashoMeisho().clearValue();
            div.getTxtJisshiBashoMeisho().setDisabled(true);
        } else {
            div.getTxtJisshiBashoMeisho().setDisabled(false);
        }
    }
}
