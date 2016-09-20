/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho.ChosaJisshishaJohoFinder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 調査実施者情報の処理クラスです。
 *
 * @reamsid_L DBE-3000-100 dongyabin
 */
public class ChosaJisshishaJohoHandler {

    private static final RString SHOKAI_KEY = new RString("key0");
    private final ChosaJisshishaJohoDiv div;
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
        for (ChosaJisshiBashoCode code : ChosaJisshiBashoCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getコード(), code.get名称());
            chosaJisshiBasho.add(data);
        }
        div.getDdlChosaJisshiBasho().setDataSource(chosaJisshiBasho);
        if (key.get調査実施場所() != null && !key.get調査実施場所().isEmpty()) {
            div.getDdlChosaJisshiBasho().setSelectedValue(key.get調査実施場所());
        }
        div.getTxtJisshiBashoMeisho().setValue(key.get実施場所名称());
        List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = service.getSyozokuKikan(key.
                get申請書管理番号()).records();
        List<KeyValueDataSource> shozokuKikan = new ArrayList<>();
        shozokuKikan.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinteichosaItakusakiJoho ninteichosaItakusakiJoho : ninteichosaItakusakiJohoList) {
            KeyValueDataSource date = new KeyValueDataSource(ninteichosaItakusakiJoho.get認定調査委託先コード(),
                    ninteichosaItakusakiJoho.get事業者名称());
            shozokuKikan.add(date);
        }
        div.getDdlShozokuKikan().setDataSource(shozokuKikan);
        if (key.get所属機関() != null && !key.get所属機関().isEmpty()) {
            div.getDdlShozokuKikan().setSelectedValue(key.get所属機関());
        }
        List<ChosainJoho> chosainJohoList = service.getKinyusha(key
                .get申請書管理番号(), div.getDdlShozokuKikan().getSelectedKey()).records();
        List<KeyValueDataSource> kinyusha = new ArrayList<>();
        kinyusha.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosainJoho chosainJoho : chosainJohoList) {
            KeyValueDataSource data = new KeyValueDataSource(chosainJoho.get認定調査員コード(),
                    chosainJoho.get調査員氏名());
            kinyusha.add(data);
        }
        div.getDdlKinyusha().setDataSource(kinyusha);
        if (key.get記入者() != null && !key.get記入者().isEmpty()) {
            div.getDdlKinyusha().setSelectedValue(key.get記入者());
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
        if (!RString.isNullOrEmpty(key.get調査実施日())) {
            div.getTxtChosaJisshiDate().setValue(new RDate(key.get調査実施日().toString()));
        }
        List<KeyValueDataSource> chosaJisshiBasho = new ArrayList<>();
        KeyValueDataSource chosaJisshi = new KeyValueDataSource(SHOKAI_KEY, key.get調査実施場所());
        chosaJisshiBasho.add(chosaJisshi);
        div.getDdlChosaJisshiBasho().setDataSource(chosaJisshiBasho);
        div.getDdlChosaJisshiBasho().setSelectedKey(SHOKAI_KEY);
        div.getTxtJisshiBashoMeisho().setValue(key.get実施場所名称());
        List<KeyValueDataSource> shozokuKikan = new ArrayList<>();
        KeyValueDataSource shozoku = new KeyValueDataSource(SHOKAI_KEY,
                key.get所属機関());
        shozokuKikan.add(shozoku);
        div.getDdlShozokuKikan().setDataSource(shozokuKikan);
        div.getDdlShozokuKikan().setSelectedKey(SHOKAI_KEY);
        List<KeyValueDataSource> kinyushaList = new ArrayList<>();
        KeyValueDataSource kinyusha = new KeyValueDataSource(SHOKAI_KEY,
                key.get記入者());
        kinyushaList.add(kinyusha);
        div.getDdlKinyusha().setDataSource(kinyushaList);
        div.getDdlKinyusha().setSelectedKey(SHOKAI_KEY);
        div.getTxtChosaKubun().setValue(key.get調査区分());
    }
}
