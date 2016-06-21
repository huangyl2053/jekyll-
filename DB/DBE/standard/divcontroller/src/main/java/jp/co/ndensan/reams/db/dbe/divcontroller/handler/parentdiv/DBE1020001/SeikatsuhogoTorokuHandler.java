/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.SeikatsuhogoTorokuDiv;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
     * @param business 審査依頼受付／みなし２号審査受付のビジネスクラス
     * @param code 支所コード
     * @param list 支所コードリスト
     */
    public void load(Minashi2shisaiJoho business, RString code, List<KoseiShichosonShishoMaster> list) {
        div.getCcdHokenshaList().loadHokenshaList();
        List<KeyValueDataSource> sourceList = new ArrayList<>();
        if (business != null) {
            // TODO QA#88089待ち、画面の遷移不正です
//            div.getCcdHokenshaList().setSelectedItem(business.get保険者());
            div.getTxtHihokenshaNo().setValue(business.get被保険者番号().value());
            div.getTxtShimei().setValue(business.get氏名().value());
            div.getTxtKanaShimei().setValue(business.getカナ氏名().value());
            div.getTxtShikibetsuCode().setValue(business.get識別コード().value());
            div.getTxtKojinNo().setValue(business.get個人番号().value());
            div.getTxtGyoseiku().setValue(business.get行政区().get名称());
//            business.set行政区名称(RString.EMPTY);
            div.getTxtSetaiCode().setValue(business.get世帯コード().value());
            div.getTxtBirthYMD().setValue(business.get生年月日());
            div.getRadSeibetsu().setSelectedKey(business.get性別コード());
            div.getTxtYubinNo().setValue(business.get郵便番号());
            div.getCcdZenkokuJushoInput().load(business.get住所コード(), business.get住所名称());
            div.getTxtTelNo().setDomain(business.get電話番号());
//            business.set住民種別(RString.EMPTY);
            for (KoseiShichosonShishoMaster master : list) {
                sourceList.add(new KeyValueDataSource(master.get支所コード().value(), master.get支所コード().value()));
            }
        } else {
            if (!RString.isNullOrEmpty(code)) {
                sourceList.add(new KeyValueDataSource(code, code));
                div.getDdlShisho().setDataSource(sourceList);
            }
        }
        div.setHdnKey_Dialog(new RString("1"));
        div.setHdnKey_GyomuCode(GyomuCode.DB介護保険.value());
        div.setHdnKey_SearchYusenKubun(new RString("1"));
        div.setHdnKey_AgeArrivalDay(new RString("2"));
    }

    /**
     * 検索条件となる入力項目をViewSateにセットします
     *
     * @return Minashi2shisaiJoho
     */
    public Minashi2shisaiJoho setBusiness() {
        Minashi2shisaiJoho business = new Minashi2shisaiJoho();
        business.set保険者(div.getCcdHokenshaList().getSelectedItem());
        business.set被保険者番号(div.getTxtHihokenshaNo().getValue());
        business.set氏名(div.getTxtShimei().getValue());
        business.setカナ氏名(div.getTxtKanaShimei().getValue());
        business.set識別コード(div.getTxtShikibetsuCode().getValue());
        business.set個人番号(div.getTxtKojinNo().getValue());
        business.set行政区コード(div.getTxtGyoseiku().getValue());
        business.set行政区名称(RString.EMPTY);
        business.set世帯コード(div.getTxtSetaiCode().getValue());
        business.set生年月日(div.getTxtBirthYMD().getValue());
        business.set性別コード(div.getRadSeibetsu().getSelectedKey());
        business.set郵便番号(div.getTxtYubinNo().getValue());
        business.set住所コード(div.getCcdZenkokuJushoInput().get全国住所コード());
        business.set住所名称(div.getCcdZenkokuJushoInput().get全国住所名称());
        business.set電話番号(div.getTxtTelNo().getDomain());
        business.set住民種別(RString.EMPTY);
        return business;
    }
}
