/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.SeikatsuhogoTorokuResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.SeikatsuhogoTorokuDiv;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * みなし2号登録の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public class SeikatsuhogoTorokuHandler {

    private final SeikatsuhogoTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div みなし2号登録Div
     */
    public SeikatsuhogoTorokuHandler(SeikatsuhogoTorokuDiv div) {
        this.div = div;
        
    }

    /**
     *
     * みなし2号登録初期化の設定します。
     *
     * @param result 申請情報
     * @param list 支所コードリスト
     * @param ninteiTandokuDounyuFlag 支所コードリスト
     */
    public void load(SeikatsuhogoTorokuResult result, List<KoseiShichosonShishoMaster> list, boolean ninteiTandokuDounyuFlag) {
        div.getCcdZenkokuJushoInput().initialize();
        if (ninteiTandokuDounyuFlag) {
            ((ZenkokuJushoInputDiv)div.getCcdZenkokuJushoInput()).getBtnZenkokuJushoGuide().setVisible(false);
            ((ZenkokuJushoInputDiv)div.getCcdZenkokuJushoInput()).getBtnZenkokuJushoGuide().setDisplayNone(true);
            ((ZenkokuJushoInputDiv)div.getCcdZenkokuJushoInput()).getTxtZenkokuJushoCode().setDisplayNone(true);
            ((ZenkokuJushoInputDiv)div.getCcdZenkokuJushoInput()).getTxtJusho().setLabelLWidth(new RString("0px"));
            div.getBtnAtenaKensaku().setVisible(false);
        }
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        if (result != null) {
            div.getTxtHihokenshaNo().setValue(result.get被保険者番号());
            div.getTxtShimei().setValue(result.get被保険者氏名().value());
            div.getTxtKanaShimei().setValue(result.get被保険者氏名カナ().value());
            div.getTxtShikibetsuCode().setValue(result.get識別コード().value());
            if (result.get生年月日() != null && !result.get生年月日().isEmpty()) {
                div.getTxtBirthYMD().setValue(new RDate(result.get生年月日().getYearValue(),
                        result.get生年月日().getMonthValue(), result.get生年月日().getDayValue()));
            }
            div.getRadSeibetsu().setSelectedKey(result.get性別().value());
            div.getTxtYubinNo().setValue(result.get郵便番号());
            
            div.getCcdZenkokuJushoInput().load(ZenkokuJushoCode.EMPTY, result.get住所().value());
            div.getTxtTelNo().setDomain(result.get電話番号());
        }
        for (KoseiShichosonShishoMaster master : list) {
            sourceList.add(new KeyValueDataSource(master.get支所名(), master.get支所コード().value()));
        }
        
        div.getDdlShisho().setDataSource(sourceList);
        div.setHdnKey_Dialog(new RString("1"));
        div.setHdnKey_GyomuCode(GyomuCode.DB介護保険.value());
        div.setHdnKey_SearchYusenKubun(new RString("1"));
        div.setHdnKey_AgeArrivalDay(new RString("2"));
    }

    /**
     * 検索条件となる入力項目をViewSateにセットします
     *
     * @param 前回申請書管理番号 前回申請書管理番号
     * @return 審査依頼受付／みなし２号審査受付画面データ
     */
    public Minashi2shisaiJoho setBusiness(ShinseishoKanriNo 前回申請書管理番号) {
        Minashi2shisaiJoho business = new Minashi2shisaiJoho();
        ShichosonSecurityJoho security = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        security = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (security.get導入形態コード().equals(new Code("211"))) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            HokenshaList hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護認定);
            business.set保険者(hokenshaList.get(association.get地方公共団体コード()));
        } else {
            business.set保険者(div.getCcdHokenshaList().getSelectedItem());
        }
        business.set被保険者番号(div.getTxtHihokenshaNo().getValue());
        business.set氏名(div.getTxtShimei().getValue());
        business.setカナ氏名(div.getTxtKanaShimei().getValue());
        business.set識別コード(div.getTxtShikibetsuCode().getValue());
        business.set個人番号(div.getTxtKojinNo().getValue());
        business.set行政区コード(div.getTxtGyoseiku().getValue());
        business.set行政区名称(div.getHdnGyoseikuCode());
        business.set世帯コード(div.getTxtSetaiCode().getValue());
        business.set生年月日(div.getTxtBirthYMD().getValue());
        if (div.getTxtBirthYMD().getValue() != null && !div.getTxtBirthYMD().getValue().toDateString().isEmpty()) {
            IDateOfBirth dob = DateOfBirthFactory.createInstance(div.getTxtBirthYMD().getValue().toFlexibleDate());
            AgeCalculator agecalculator = new AgeCalculator(dob, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
            business.set年齢(agecalculator.get年齢());
        }
        business.set性別コード(div.getRadSeibetsu().getSelectedKey());
        business.set郵便番号(div.getTxtYubinNo().getValue());
        business.set住所コード(div.getCcdZenkokuJushoInput().get全国住所コード());
        business.set住所名称(div.getCcdZenkokuJushoInput().get全国住所名称());
        business.set電話番号(div.getTxtTelNo().getDomain());
        business.set支所コード(div.getDdlShisho().getSelectedKey());
        if (前回申請書管理番号 != null) {
            business.set前回申請書管理番号(前回申請書管理番号);
        }
        business.set市町村コード(div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        return business;
    }
}
