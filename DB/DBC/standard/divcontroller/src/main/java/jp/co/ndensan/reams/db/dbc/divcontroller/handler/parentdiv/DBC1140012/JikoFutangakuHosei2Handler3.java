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
public class JikoFutangakuHosei2Handler3 {

    private final JikoFutangakuHosei2PanelDiv div;
    private static final RString 呼び出しフラグ_1 = new RString("1");
    private static final RString 変更なし = new RString("0");
    private static final RString 変更あり = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 高額合算自己負担額情報補正(単)_補正入力画面のdiv
     */
    public JikoFutangakuHosei2Handler3(JikoFutangakuHosei2PanelDiv div) {
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
        div.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_自己負担額());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_うち70_74歳に係る負担額());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_高額介護_予防_サービス費());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiMae()
                .setValue(高額合算自己負担額補正保持Entity.get変更前_合計_実際の自己負担額());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_自己負担額());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_うち70_74歳に係る負担額());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_高額介護_予防_サービス費());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_合計_補正後_実際の自己負担額());
    }

    private void initialize_補正前_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_8月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_9月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_10月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_11月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_12月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年1月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年2月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年3月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年4月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年5月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年6月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuMae().setValue(高額合算自己負担額補正保持Entity.get補正前_自己負担額_翌年7月分());
    }

    private void initialize_補正前_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_8月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_9月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_10月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_11月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_12月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年1月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年2月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年3月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年4月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年5月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年6月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_翌年7月分());
    }

    private void initialize_補正前_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_8月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_9月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_10月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_11月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_12月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年1月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年2月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年3月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年4月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年5月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年6月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_高額介護_予防_サービス費_翌年7月分());
    }

    private void initialize_補正前_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_8月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_9月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_10月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_11月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_12月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年1月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年2月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年3月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年4月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年5月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年6月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae()
                .setValue(高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_翌年7月分());
    }

    private void initialize_補正後_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_8月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_9月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_10月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_11月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_12月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年1月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年2月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年3月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年4月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年5月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年6月分());
        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_翌年7月分());
    }

    private void initialize_補正後_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_8月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_9月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_10月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_11月分());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_12月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年1月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年2月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年3月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年4月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年5月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年6月分());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年7月分());
    }

    private void initialize_補正後_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_8月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_9月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_10月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_11月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_12月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年1月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年2月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年3月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年4月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年5月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年6月分());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年7月分());
    }

    private void initialize_補正後_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_8月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_9月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_10月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_11月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_12月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年1月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年2月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年3月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年4月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年5月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年6月分());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo()
                .setValue(高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_翌年7月分());
    }

    /**
     * 補正前の金額をコピーするのメソッドです。
     */
    public void 補正後の金額コピー() {
        div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae().getValue());

        div.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiMae().getValue());
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiGo().setValue(
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiMae().getValue());
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiGo().setValue(
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiMae().getValue());
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiGo().setValue(
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiMae().getValue());
    }

    /**
     * 変更前補正後金額の設定のメソッドです。
     *
     * @param 高額合算自己負担額補正保持Entity KogakuGassanJikofutangakuHosei
     */
    public void 変更前補正後金額の設定(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_8月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_9月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_10月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_11月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_12月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_8月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_9月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_10月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_11月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_12月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_8月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_9月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_10月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_11月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_12月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_高額介護_予防_サービス費_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_8月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_9月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_10月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_11月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_12月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae().getValue());
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
        高額合算自己負担額保持Entity.set変更前_合計_自己負担額(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更前_合計_うち70_74歳に係る負担額(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更前_合計_高額介護_予防_サービス費(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更前_合計_実際の自己負担額(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuGoukeiMae().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_自己負担額(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuGoukeiGo().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_うち70_74歳に係る負担額(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuGoukeiGo().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_高額介護_予防_サービス費(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiGoukeiGo().getValue());
        高額合算自己負担額保持Entity.set変更後_合計_補正後_実際の自己負担額(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuGoukeiGo().getValue());
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
        Decimal 変更前_補正後_自己負担額_8月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_8月分();
        if (isNull(変更前_補正後_自己負担額_8月分)) {
            変更前_補正後_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_9月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_9月分();
        if (isNull(変更前_補正後_自己負担額_9月分)) {
            変更前_補正後_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_10月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_10月分();
        if (isNull(変更前_補正後_自己負担額_10月分)) {
            変更前_補正後_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_11月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_11月分();
        if (isNull(変更前_補正後_自己負担額_11月分)) {
            変更前_補正後_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_12月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_12月分();
        if (isNull(変更前_補正後_自己負担額_12月分)) {
            変更前_補正後_自己負担額_12月分 = Decimal.ZERO;
        }

        if (!変更前_補正後_自己負担額_8月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_8月分())
                || !変更前_補正後_自己負担額_9月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_9月分())
                || !変更前_補正後_自己負担額_10月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_10月分())
                || !変更前_補正後_自己負担額_11月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_11月分())
                || !変更前_補正後_自己負担額_12月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_12月分())) {
            return true;
        }
        return is変更_自己負担額_翌年(高額合算自己負担額保持Entity);
    }

    private boolean is変更_自己負担額_翌年(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        Decimal 変更前_補正後_自己負担額_翌年1月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年1月分();
        if (isNull(変更前_補正後_自己負担額_翌年1月分)) {
            変更前_補正後_自己負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_翌年2月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年2月分();
        if (isNull(変更前_補正後_自己負担額_翌年2月分)) {
            変更前_補正後_自己負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_翌年3月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年3月分();
        if (isNull(変更前_補正後_自己負担額_翌年3月分)) {
            変更前_補正後_自己負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_翌年4月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年4月分();
        if (isNull(変更前_補正後_自己負担額_翌年4月分)) {
            変更前_補正後_自己負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_翌年5月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年5月分();
        if (isNull(変更前_補正後_自己負担額_翌年5月分)) {
            変更前_補正後_自己負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_翌年6月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年6月分();
        if (isNull(変更前_補正後_自己負担額_翌年6月分)) {
            変更前_補正後_自己負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_自己負担額_翌年7月分 = 高額合算自己負担額保持Entity.get変更前_補正後_自己負担額_翌年7月分();
        if (isNull(変更前_補正後_自己負担額_翌年7月分)) {
            変更前_補正後_自己負担額_翌年7月分 = Decimal.ZERO;
        }
        return !変更前_補正後_自己負担額_翌年1月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年1月分())
                || !変更前_補正後_自己負担額_翌年2月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年2月分())
                || !変更前_補正後_自己負担額_翌年3月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年3月分())
                || !変更前_補正後_自己負担額_翌年4月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年4月分())
                || !変更前_補正後_自己負担額_翌年5月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年5月分())
                || !変更前_補正後_自己負担額_翌年6月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年6月分())
                || !変更前_補正後_自己負担額_翌年7月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_自己負担額_翌年7月分());
    }

    private boolean is変更_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        Decimal 変更前_補正後_うち70_74歳に係る負担額_8月分 = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_8月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_8月分)) {
            変更前_補正後_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_9月分 = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_9月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_9月分)) {
            変更前_補正後_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_10月分 = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_10月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_10月分)) {
            変更前_補正後_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_11月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_11月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_11月分)) {
            変更前_補正後_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_12月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_12月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_12月分)) {
            変更前_補正後_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        if (!変更前_補正後_うち70_74歳に係る負担額_8月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_8月分())
                || !変更前_補正後_うち70_74歳に係る負担額_9月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_9月分())
                || !変更前_補正後_うち70_74歳に係る負担額_10月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_10月分())
                || !変更前_補正後_うち70_74歳に係る負担額_11月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_11月分())
                || !変更前_補正後_うち70_74歳に係る負担額_12月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_12月分())) {
            return true;
        }
        return is変更_うち70_74歳に係る負担額_翌年(高額合算自己負担額保持Entity);
    }

    private boolean is変更_うち70_74歳に係る負担額_翌年(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年1月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年1月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年1月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年2月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年2月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年2月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年3月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年3月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年3月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年4月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年4月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年4月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年5月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年5月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年5月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年6月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年6月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年6月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_うち70_74歳に係る負担額_翌年7月分
                = 高額合算自己負担額保持Entity.get変更前_補正後_うち70_74歳に係る負担額_翌年7月分();
        if (isNull(変更前_補正後_うち70_74歳に係る負担額_翌年7月分)) {
            変更前_補正後_うち70_74歳に係る負担額_翌年7月分 = Decimal.ZERO;
        }
        return !変更前_補正後_うち70_74歳に係る負担額_翌年1月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年1月分())
                || !変更前_補正後_うち70_74歳に係る負担額_翌年2月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年2月分())
                || !変更前_補正後_うち70_74歳に係る負担額_翌年3月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年3月分())
                || !変更前_補正後_うち70_74歳に係る負担額_翌年4月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年4月分())
                || !変更前_補正後_うち70_74歳に係る負担額_翌年5月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年5月分())
                || !変更前_補正後_うち70_74歳に係る負担額_翌年6月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年6月分())
                || !変更前_補正後_うち70_74歳に係る負担額_翌年7月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_うち70_74歳に係る負担額_翌年7月分());
    }

    private boolean is変更_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        Decimal 変更前_補正後_高額介護_予防_サービス費_8月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_8月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_8月分)) {
            変更前_補正後_高額介護_予防_サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_9月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_9月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_9月分)) {
            変更前_補正後_高額介護_予防_サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_10月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_10月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_10月分)) {
            変更前_補正後_高額介護_予防_サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_11月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_11月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_11月分)) {
            変更前_補正後_高額介護_予防_サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_12月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_12月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_12月分)) {
            変更前_補正後_高額介護_予防_サービス費_12月分 = Decimal.ZERO;
        }

        if (!変更前_補正後_高額介護_予防_サービス費_8月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_8月分())
                || !変更前_補正後_高額介護_予防_サービス費_9月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_9月分())
                || !変更前_補正後_高額介護_予防_サービス費_10月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_10月分())
                || !変更前_補正後_高額介護_予防_サービス費_11月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_11月分())
                || !変更前_補正後_高額介護_予防_サービス費_12月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_12月分())) {
            return true;
        }
        return is変更_高額介護_予防_サービス費_翌年(高額合算自己負担額保持Entity);
    }

    private boolean is変更_高額介護_予防_サービス費_翌年(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年1月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年1月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年1月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年1月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年2月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年2月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年2月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年2月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年3月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年3月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年3月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年3月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年4月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年4月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年4月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年4月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年5月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年5月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年5月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年5月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年6月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年6月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年6月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年6月分 = Decimal.ZERO;
        }
        Decimal 変更前_補正後_高額介護_予防_サービス費_翌年7月分 = 高額合算自己負担額保持Entity.get変更前_補正後_高額介護_予防_サービス費_翌年7月分();
        if (isNull(変更前_補正後_高額介護_予防_サービス費_翌年7月分)) {
            変更前_補正後_高額介護_予防_サービス費_翌年7月分 = Decimal.ZERO;
        }
        return !変更前_補正後_高額介護_予防_サービス費_翌年1月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年1月分())
                || !変更前_補正後_高額介護_予防_サービス費_翌年2月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年2月分())
                || !変更前_補正後_高額介護_予防_サービス費_翌年3月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年3月分())
                || !変更前_補正後_高額介護_予防_サービス費_翌年4月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年4月分())
                || !変更前_補正後_高額介護_予防_サービス費_翌年5月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年5月分())
                || !変更前_補正後_高額介護_予防_サービス費_翌年6月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年6月分())
                || !変更前_補正後_高額介護_予防_サービス費_翌年7月分
                .equals(高額合算自己負担額保持Entity.get変更後_補正後_高額介護_予防_サービス費_翌年7月分());
    }

    private void set補正前_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_自己負担額_8月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_9月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_10月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_11月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_12月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_自己負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku7GatsuMae().getValue());
    }

    private void set補正前_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_8月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_9月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_10月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_11月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_12月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_うち70_74歳に係る負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku7GatsuMae().getValue());
    }

    private void set補正前_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_8月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_9月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_10月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_11月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_12月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_高額介護_予防_サービス費_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae().getValue());
    }

    private void set補正前_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_8月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku8GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_9月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku9GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_10月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku10GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_11月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku11GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_12月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku12GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae().getValue());
        高額合算自己負担額保持Entity.set補正前_実際の自己負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae().getValue());
    }

    private void set変更後_補正後_自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_8月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_9月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_10月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_11月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_12月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_自己負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_うち70_74歳に係る負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_8月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_9月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_10月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_11月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_12月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74Futangaku12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_うち70_74歳に係る負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_高額介護_予防_サービス費(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_8月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_9月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_10月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_11月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_12月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_高額介護_予防_サービス費_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_実際の自己負担額(KogakuGassanJikofutangakuHosei 高額合算自己負担額保持Entity) {
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_8月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku8GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_9月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku9GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_10月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku10GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_11月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku11GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_12月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangaku12GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年1月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年2月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年3月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年4月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年5月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年6月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo().getValue());
        高額合算自己負担額保持Entity.set変更後_補正後_実際の自己負担額_翌年7月分(div.getTbl20Igai()
                .getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo().getValue());
    }

    private boolean isNull(Decimal 金額) {
        return 金額 == null;
    }
}
