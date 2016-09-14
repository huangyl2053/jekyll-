/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012;

import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.JikoFutangakuHosei2PanelDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
    private static final int 歳_75 = 75;
    private static final int 歳_70 = 70;
    private static final RString 月_004 = new RString("04");
    private static final RString 月_005 = new RString("05");
    private static final RString 月_006 = new RString("06");
    private static final RString 月_007 = new RString("07");
    private static final RString 月_008 = new RString("08");
    private static final RString 月_009 = new RString("09");
    private static final RString 月_010 = new RString("10");
    private static final RString 月_011 = new RString("11");
    private static final RString 月_012 = new RString("12");
    private static final RString 月_101 = new RString("01");
    private static final RString 月_102 = new RString("02");
    private static final RString 月_103 = new RString("03");
    private static final RString 月_104 = new RString("04");
    private static final RString 月_105 = new RString("05");
    private static final RString 月_106 = new RString("06");
    private static final RString 月_107 = new RString("07");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_6 = 6;
    private static final int CODE_35 = 35;
    private static final int CODE_36 = 36;
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
        高額合算自己負担額補正保持Entity.set呼び出しフラグ(呼び出しフラグ_1);
    }

    /**
     * is補正後チェック１のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック１(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
        Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
        if ((!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分) && !isNull(自己負担額_4月分).equals(うち70_74歳に係る負担額_4月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分) && !isNull(自己負担額_5月分).equals(うち70_74歳に係る負担額_5月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分) && !isNull(自己負担額_6月分).equals(うち70_74歳に係る負担額_6月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分) && !isNull(自己負担額_7月分).equals(うち70_74歳に係る負担額_7月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分) && !isNull(自己負担額_8月分).equals(うち70_74歳に係る負担額_8月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分) && !isNull(自己負担額_9月分).equals(うち70_74歳に係る負担額_9月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分) && !isNull(自己負担額_10月分).equals(うち70_74歳に係る負担額_10月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分) && !isNull(自己負担額_11月分).equals(うち70_74歳に係る負担額_11月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分) && !isNull(自己負担額_12月分).equals(うち70_74歳に係る負担額_12月分))) {
            return true;
        }
        return is補正後チェック１_翌年(div);
    }

    private boolean is補正後チェック１_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
        return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分) && !isNull(自己負担額_1月分).equals(うち70_74歳に係る負担額_1月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分) && !isNull(自己負担額_2月分).equals(うち70_74歳に係る負担額_2月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分) && !isNull(自己負担額_3月分).equals(うち70_74歳に係る負担額_3月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分) && !isNull(自己負担額_4月分).equals(うち70_74歳に係る負担額_4月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分) && !isNull(自己負担額_5月分).equals(うち70_74歳に係る負担額_5月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分) && !isNull(自己負担額_6月分).equals(うち70_74歳に係る負担額_6月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分) && !isNull(自己負担額_7月分).equals(うち70_74歳に係る負担額_7月分));
    }

    /**
     * is補正後チェック２のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック２(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
        Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
        if ((Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分))
                || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分))
                || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分))
                || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分))
                || (Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分))
                || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分))
                || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分))
                || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分))
                || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分))) {
            return true;
        }
        return is補正後チェック２_翌年(div);
    }

    private boolean is補正後チェック２_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
        return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分))
                || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分))
                || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分))
                || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分))
                || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分))
                || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分))
                || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分));
    }

    /**
     * is補正後チェック3のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック３(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
        Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
        if ((Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_4月分))
                || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_5月分))
                || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_6月分))
                || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_7月分))
                || (Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_8月分))
                || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_9月分))
                || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_10月分))
                || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_11月分))
                || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_12月分))) {
            return true;
        }
        return is補正後チェック３_翌年(div);
    }

    private boolean is補正後チェック３_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
        return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_1月分))
                || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_2月分))
                || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_3月分))
                || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_4月分))
                || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_5月分))
                || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_6月分))
                || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_7月分));
    }

    /**
     * is補正後チェック4のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック4(JikoFutangakuHosei2PanelDiv div) {
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae().getValue();
        if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)) {
            return true;
        }
        return is補正後チェック4_翌年(div);
    }

    private boolean is補正後チェック4_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae().getValue();
        return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分));
    }

    /**
     * is補正後チェック4_補正後のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック4_補正後(JikoFutangakuHosei2PanelDiv div) {
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
        if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)) {
            return true;
        }
        return is補正後チェック4_補正後翌年(div);
    }

    private boolean is補正後チェック4_補正後翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
        return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分));
    }

    /**
     * is補正後チェック5_6のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @param 生年月日 FlexibleDate
     * @param 対象年度 FlexibleYear
     * @return 警告(メッセージ )のコッド
     */
    public int is補正後チェック4_6(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_004 = new FlexibleYearMonth(対象年度.toString().concat(月_004.toString()));
        FlexibleYearMonth 対象年月_005 = new FlexibleYearMonth(対象年度.toString().concat(月_005.toString()));
        FlexibleYearMonth 対象年月_006 = new FlexibleYearMonth(対象年度.toString().concat(月_006.toString()));
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_4月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
        if (対象年月_004.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_004)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_5月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
        if (対象年月_005.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_005)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_6月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
        if (対象年月_006.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_006)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック7_9(div, 生年月日, 対象年度);
    }

    private int is補正後チェック7_9(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_007 = new FlexibleYearMonth(対象年度.toString().concat(月_007.toString()));
        FlexibleYearMonth 対象年月_008 = new FlexibleYearMonth(対象年度.toString().concat(月_008.toString()));
        FlexibleYearMonth 対象年月_009 = new FlexibleYearMonth(対象年度.toString().concat(月_009.toString()));
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_7月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
        if (対象年月_007.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_007)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_8月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
        if (対象年月_008.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_008)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_9月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
        if (対象年月_009.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_009)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック10_12(div, 生年月日, 対象年度);
    }

    private int is補正後チェック10_12(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_010 = new FlexibleYearMonth(対象年度.toString().concat(月_010.toString()));
        FlexibleYearMonth 対象年月_011 = new FlexibleYearMonth(対象年度.toString().concat(月_011.toString()));
        FlexibleYearMonth 対象年月_012 = new FlexibleYearMonth(対象年度.toString().concat(月_012.toString()));
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_10月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
        if (対象年月_010.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_010)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_11月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
        if (対象年月_011.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_011)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_12月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
        if (対象年月_012.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_012)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック翌年1_3(div, 生年月日, 対象年度);
    }

    private int is補正後チェック翌年1_3(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_101 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_101.toString()));
        FlexibleYearMonth 対象年月_102 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_102.toString()));
        FlexibleYearMonth 対象年月_103 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_103.toString()));
        Decimal うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年1月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
        if (対象年月_101.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_101)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年2月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
        if (対象年月_102.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_102)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年3月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
        if (対象年月_103.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_103)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック翌年4_6(div, 生年月日, 対象年度);
    }

    private int is補正後チェック翌年4_6(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_104 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_104.toString()));
        FlexibleYearMonth 対象年月_105 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_105.toString()));
        FlexibleYearMonth 対象年月_106 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_106.toString()));
        Decimal うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年4月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
        if (対象年月_104.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_104)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年5月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
        if (対象年月_105.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_105)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年6月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
        if (対象年月_106.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_106)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック翌年7(div, 生年月日, 対象年度);
    }

    private int is補正後チェック翌年7(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_107 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_107.toString()));
        Decimal うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae().getValue();
        Decimal うち70_74歳に係る負担額_翌年7月分_補正後 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
        if (対象年月_107.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_107)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分)
                    || !Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分)
                    || Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                return CODE_36;
            }
        }
        return INT_0;
    }

    /**
     * is高額介護_予防_サービス費チェックのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is高額介護_予防_サービス費チェック(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
        Decimal 自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
        if (高額介護_予防_サービス費_4月分.compareTo(自己負担額_4月分) != INT_1
                || 高額介護_予防_サービス費_5月分.compareTo(自己負担額_5月分) != INT_1
                || 高額介護_予防_サービス費_6月分.compareTo(自己負担額_6月分) != INT_1
                || 高額介護_予防_サービス費_7月分.compareTo(自己負担額_7月分) != INT_1
                || 高額介護_予防_サービス費_8月分.compareTo(自己負担額_8月分) != INT_1
                || 高額介護_予防_サービス費_9月分.compareTo(自己負担額_9月分) != INT_1
                || 高額介護_予防_サービス費_10月分.compareTo(自己負担額_10月分) != INT_1
                || 高額介護_予防_サービス費_11月分.compareTo(自己負担額_11月分) != INT_1
                || 高額介護_予防_サービス費_12月分.compareTo(自己負担額_12月分) != INT_1) {
            return true;
        }
        return is高額介護_予防_サービス費チェック_翌年(div);
    }

    private boolean is高額介護_予防_サービス費チェック_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
        return (高額介護_予防_サービス費_1月分.compareTo(自己負担額_1月分) != INT_1
                || 高額介護_予防_サービス費_2月分.compareTo(自己負担額_2月分) != INT_1
                || 高額介護_予防_サービス費_3月分.compareTo(自己負担額_3月分) != INT_1
                || 高額介護_予防_サービス費_4月分.compareTo(自己負担額_4月分) != INT_1
                || 高額介護_予防_サービス費_5月分.compareTo(自己負担額_5月分) != INT_1
                || 高額介護_予防_サービス費_6月分.compareTo(自己負担額_6月分) != INT_1
                || 高額介護_予防_サービス費_7月分.compareTo(自己負担額_7月分) != INT_1);
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
