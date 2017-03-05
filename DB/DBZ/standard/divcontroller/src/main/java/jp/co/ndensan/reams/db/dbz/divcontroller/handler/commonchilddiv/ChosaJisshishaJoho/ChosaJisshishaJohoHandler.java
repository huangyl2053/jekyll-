/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ChosaJisshishaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chosajisshishajoho.ChosaJisshishaJohoParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoValidationHandler;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.chosajisshishajoho.ChosaJisshishaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho.ChosaJisshishaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

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

    /**
     * バリデーション結果を取得します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validationResult = new ValidationMessageControlPairs();
        ChosaJisshishaJohoValidationHandler validator = new ChosaJisshishaJohoValidationHandler(div);
        validationResult.add(validator.validate所属機関コード());
        validationResult.add(validator.validate記入者コード());
        return validationResult;
    }

    private void setInput(ChosaJisshishaJohoModel key) {
        div.getTxtChosaJisshiDate().setValue(RString.isNullOrEmpty(key.get調査実施日()) ? RDate.getNowDate() : new RDate(key.get調査実施日().toString()));
        List<KeyValueDataSource> chosaJisshiBasho = new ArrayList<>();
        List<NinteiShinseiJoho> ninteiShinseiJohoList = service.get認定申請情報(key.get申請書管理番号()).records();
        if (ninteiShinseiJohoList != null && !ninteiShinseiJohoList.isEmpty()) {
            NinteiShinseiJoho 認定申請情報 = ninteiShinseiJohoList.get(0);
            div.getTxtNinteiShinseiDate().setValue(認定申請情報.get認定申請年月日());
            div.setHdnShichosonCode(認定申請情報.get市町村コード().value());
        }
        chosaJisshiBasho.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosaJisshiBashoCode code : ChosaJisshiBashoCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(code.getコード(), code.get名称());
            chosaJisshiBasho.add(data);
        }
        div.getDdlChosaJisshiBasho().setDataSource(chosaJisshiBasho);
        if (key.get調査実施場所() != null && !key.get調査実施場所().isEmpty()) {
            div.getDdlChosaJisshiBasho().setSelectedValue(key.get調査実施場所());
        } else {
            div.getDdlChosaJisshiBasho().setSelectedValue(ChosaJisshiBashoCode.自宅内.get名称());
        }
        div.getTxtJisshiBashoMeisho().setValue(key.get実施場所名称());
        if (key.get所属機関コード() != null && !key.get所属機関コード().isEmpty()) {
            div.getTxtShozokuKikanCode().setValue(key.get所属機関コード());
            getShozokuKikanName();
            if (key.get記入者コード() != null && !key.get記入者コード().isEmpty()) {
                div.getTxtKinyushaCode().setValue(key.get記入者コード());
                getKinyushaName();
            }
        } else {
            ChosaJisshishaJohoParameter parameter = ChosaJisshishaJohoParameter.createParameter(new ShinseishoKanriNo(key.get申請書管理番号()), key.get認定調査依頼履歴番号());
            ChosaJisshishaJohoRelateEntity 調査実施者情報 = service.getChosaJisshishaJoho(parameter);
            if (調査実施者情報 != null) {
                div.getTxtShozokuKikanCode().setValue(調査実施者情報.getNinteichosaItakusakiCode().getColumnValue());
                div.getTxtShozokuKikanName().setValue(調査実施者情報.getJigyoshaMeisho());
                div.getTxtKinyushaCode().setValue(調査実施者情報.getNinteiChosainCode());
                div.getTxtKinyushaName().setValue(調査実施者情報.getChosainShimei());
            }
        }

        NinteichosaIraiJohoManager ninteiChosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho 認定調査依頼情報 = ninteiChosaIraiJohoManager.get認定調査依頼情報(new ShinseishoKanriNo(key.get申請書管理番号()), key.get認定調査依頼履歴番号());
        if (認定調査依頼情報 != null) {
            NinteiChousaIraiKubunCode 認定調査依頼区分 = NinteiChousaIraiKubunCode.toValue(認定調査依頼情報.get認定調査依頼区分コード().getColumnValue());
            div.getTxtChosaKubun().setValue(認定調査依頼区分.get名称());
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

    private void getShozokuKikanName() {
        ChosaJisshishaJohoFinder finder = ChosaJisshishaJohoFinder.createInstance();
        NinteichosaItakusakiJoho ninteichosaItakusakiJoho
                = finder.onBlurTxtShozokuKikanCode(new LasdecCode(div.getHdnShichosonCode()), div.getTxtShozokuKikanCode().getText());
        div.getTxtShozokuKikanName().setValue(ninteichosaItakusakiJoho == null ? RString.EMPTY
                : ninteichosaItakusakiJoho.get事業者名称() == null ? RString.EMPTY
                : ninteichosaItakusakiJoho.get事業者名称());
    }

    private void getKinyushaName() {
        ChosaJisshishaJohoFinder finder = ChosaJisshishaJohoFinder.createInstance();
        ShinsakaiChosainJoho shinsakaiChosainJoho
                = finder.onBlurTxtKinyushaCode(
                        new LasdecCode(div.getHdnShichosonCode()),
                        new ChosaItakusakiCode(div.getTxtShozokuKikanCode().getText()),
                        new ChosainCode(div.getTxtKinyushaCode().getText()));
        if (shinsakaiChosainJoho == null) {
            div.getTxtShozokuKikanName().setValue(RString.EMPTY);
            div.getTxtKinyushaName().setValue(RString.EMPTY);
        } else {
            if (shinsakaiChosainJoho.get調査員氏名() != null) {
                NinteichosaItakusakiJoho ninteichosaItakusakiJoho
                        = finder.onBlurTxtShozokuKikanCode(new LasdecCode(div.getHdnShichosonCode()), shinsakaiChosainJoho.get認定調査委託先コード());
                div.getTxtShozokuKikanName().setValue(ninteichosaItakusakiJoho.get事業者名称());
                div.getTxtKinyushaName().setValue(shinsakaiChosainJoho.get調査員氏名());
            } else {
                div.getTxtShozokuKikanName().setValue(RString.EMPTY);
                div.getTxtKinyushaName().setValue(RString.EMPTY);
            }
        }
    }
}
