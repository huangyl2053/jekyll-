/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012;

import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.JikoFutangakuHosei2PanelDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算自己負担額情報補正(単)_補正入力のHandlerクラスです。
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public class JikoFutangakuHosei2Handler4 {

    private final JikoFutangakuHosei2PanelDiv div;
    private static final RString 呼び出しフラグ_1 = new RString("1");
    private static final RString 変更なし = new RString("0");
    private static final RString 変更あり = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 高額合算自己負担額情報補正(単)_補正入力画面のdiv
     */
    public JikoFutangakuHosei2Handler4(JikoFutangakuHosei2PanelDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化のメソッドです。
     *
     * @param 高額合算自己負担額補正保持Entity KogakuGassanJikofutangakuHosei
     */
    public void initialize_２回目以降(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        initialize_補正前_自己負担額(高額合算自己負担額補正保持Entity);
        initialize_補正前_うち70_74歳に係る負担額(高額合算自己負担額補正保持Entity);
        initialize_補正前_高額介護_予防_サービス費(高額合算自己負担額補正保持Entity);
        initialize_補正前_実際の自己負担額(高額合算自己負担額補正保持Entity);
        initialize_補正後_自己負担額(高額合算自己負担額補正保持Entity);
        initialize_補正後_うち70_74歳に係る負担額(高額合算自己負担額補正保持Entity);
        initialize_補正後_高額介護_予防_サービス費(高額合算自己負担額補正保持Entity);
        initialize_補正後_実際の自己負担額(高額合算自己負担額補正保持Entity);
        div.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_自己負担額());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_うち70_74歳に係る負担額());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_高額介護_予防_サービス費());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_実際の自己負担額());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_自己負担額());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_うち70_74歳に係る負担額());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_高額介護_予防_サービス費());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_実際の自己負担額());
    }

    private void initialize_補正前_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20NendoJikofutangaku4GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_4月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_5月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_6月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_7月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_8月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_9月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_10月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_11月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_12月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年1月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年2月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年3月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年4月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年5月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年6月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年7月分());
    }

    private void initialize_補正前_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_4月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_5月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_6月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_7月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_8月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_9月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_10月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_11月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_12月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年1月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年2月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年3月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年4月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年5月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年6月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年7月分());
    }

    private void initialize_補正前_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_4月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_5月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_6月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_7月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_8月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_9月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_10月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_11月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_12月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年1月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年2月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年3月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年4月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年5月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年6月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年7月分());
    }

    private void initialize_補正前_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_4月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_5月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_6月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_7月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_8月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_9月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_10月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_11月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_12月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年1月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年2月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年3月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年4月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年5月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年6月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年7月分());
    }

    private void initialize_補正後_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_4月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_5月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_6月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_7月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_8月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_9月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_10月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_11月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_12月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年1月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年2月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年3月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年4月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年5月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年6月分());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年7月分());
    }

    private void initialize_補正後_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_4月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_5月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_6月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_7月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_8月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_9月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_10月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_11月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_12月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年1月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年2月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年3月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年4月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年5月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年6月分());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年7月分());
    }

    private void initialize_補正後_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_4月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_5月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_6月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_7月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_8月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_9月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_10月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_11月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_12月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年1月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年2月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年3月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年4月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年5月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年6月分());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年7月分());
    }

    private void initialize_補正後_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_4月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_5月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_6月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_7月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_8月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_9月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_10月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_11月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_12月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年1月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年2月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年3月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年4月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年5月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年6月分());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年7月分());
    }

    /**
     * 補正前の金額をコピーするのメソッドです。
     */
    public void 補正後の金額コピー() {
        div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiMae().getValue());
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiGo().setValue(
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiMae().getValue());
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiGo().setValue(
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiMae().getValue());
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiGo().setValue(
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiMae().getValue());
    }

    /**
     * 変更前補正後金額の設定のメソッドです。
     *
     * @param 高額合算自己負担額補正保持Entity KogakuGassanJikofutangakuHosei
     */
    public void 変更前補正後金額の設定(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_4月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_5月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_6月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_7月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_8月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_9月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_10月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_11月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_12月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_4月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_5月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_6月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_7月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_8月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_9月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_10月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_11月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_12月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_4月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_5月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_6月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_7月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_8月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_9月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_10月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_11月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_12月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_4月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_5月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_6月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_7月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_8月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_9月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_10月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_11月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_12月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku7GatsuMae().getValue());
    }

    /**
     * 高額合算自己負担額保持Entity設定のメソッドです。
     *
     * @param 高額合算自己負担額保持Entity KogakuGassanJikofutangakuHosei
     */
    public void 高額合算自己負担額保持Entity設定(
            KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        set補正前_自己負担額(高額合算自己負担額保持Entity);
        set補正前_うち70_74歳に係る負担額(高額合算自己負担額保持Entity);
        set補正前_高額介護_予防_サービス費(高額合算自己負担額保持Entity);
        set補正前_実際の自己負担額(高額合算自己負担額保持Entity);
        set変更後_補正後_自己負担額(高額合算自己負担額保持Entity);
        set変更後_補正後_うち70_74歳に係る負担額(高額合算自己負担額保持Entity);
        set変更後_補正後_高額介護_予防_サービス費(高額合算自己負担額保持Entity);
        set変更後_補正後_実際の自己負担額(高額合算自己負担額保持Entity);
        高額合算自己負担額保持Entity.set変更前_合計_自己負担額(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更前_合計_うち70_74歳に係る負担額(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更前_合計_高額介護_予防_サービス費(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更前_合計_実際の自己負担額(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_自己負担額(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuGoukeiGo().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_うち70_74歳に係る負担額(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuGoukeiGo().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_高額介護_予防_サービス費(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiGoukeiGo().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_実際の自己負担額(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuGoukeiGo().getValue());
        if (is変更(高額合算自己負担額保持Entity)) {
            高額合算自己負担額保持Entity.set変更フラグ(変更あり);
        } else {
            高額合算自己負担額保持Entity.set変更フラグ(変更なし);
        }
        高額合算自己負担額保持Entity.set呼び出しフラグ(呼び出しフラグ_1);
    }

    private boolean is変更(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        return is変更_自己負担額(高額合算自己負担額保持Entity)
                || is変更_高額介護_予防_サービス費(高額合算自己負担額保持Entity)
                || is変更_うち70_74歳に係る負担額(高額合算自己負担額保持Entity);
    }

    private boolean is変更_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        return !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_4月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_4月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_5月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_5月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_6月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_6月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_7月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_7月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_8月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_8月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_9月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_9月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_10月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_10月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_11月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_11月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_12月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_12月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年1月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年1月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年2月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年2月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年3月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年3月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年4月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年4月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年5月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年5月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年6月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年6月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年7月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年7月分());
    }

    private boolean is変更_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        return !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_4月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_4月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_5月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_5月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_6月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_6月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_7月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_7月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_8月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_8月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_9月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_9月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_10月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_10月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_11月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_11月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_12月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_12月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年1月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年1月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年2月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年2月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年3月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年3月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年4月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年4月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年5月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年5月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年6月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年6月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年7月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年7月分());
    }

    private boolean is変更_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        return !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_4月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_4月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_5月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_5月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_6月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_6月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_7月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_7月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_8月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_8月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_9月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_9月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_10月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_10月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_11月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_11月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_12月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_12月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年1月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年1月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年2月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年2月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年3月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年3月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年4月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年4月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年5月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年5月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年6月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年6月分())
                || !isNull(高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年7月分())
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年7月分());
    }

    private void set補正前_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_自己負担額_4月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_5月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_6月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_7月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku7GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_8月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_9月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_10月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_11月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_12月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku7GatsuMae().getValue());
    }

    private void set補正前_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_4月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_5月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_6月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_7月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku7GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_8月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_9月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_10月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_11月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_12月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku7GatsuMae().getValue());
    }

    private void set補正前_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_4月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_5月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_6月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_7月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi7GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_8月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_9月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_10月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_11月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_12月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae().getValue());
    }

    private void set補正前_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_4月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_5月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_6月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_7月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku7GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_8月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_9月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_10月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_11月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_12月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku7GatsuMae().getValue());
    }

    private void set変更後_補正後_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_4月分(div.getTbl20Nendo()
                .getCel20NendoJikofutangaku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_5月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_6月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_7月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku7GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_8月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_9月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_10月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_11月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_12月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_4月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_5月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_6月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_7月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_8月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_9月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_10月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_11月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_12月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_4月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_5月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_6月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_7月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_8月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_9月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_10月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_11月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_12月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_4月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_5月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_6月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_7月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku7GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_8月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_9月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_10月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_11月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_12月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangaku12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年1月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年2月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年3月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年4月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年5月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年6月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年7月分(div.getTbl20Nendo()
                .getTxt20NendoJissaiJikofutangakuYoku7GatsuGo().getValue());
    }

    private Decimal isNull(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        } else {
            return 金額;
        }
    }
}
