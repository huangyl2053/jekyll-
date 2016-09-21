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
public class JikoFutangakuHosei2Handler3 {

    private final JikoFutangakuHosei2PanelDiv div;
    private static final RString 呼び出しフラグ_1 = new RString("1");
    private static final int 歳_75 = 75;
    private static final int 歳_70 = 70;
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
     * is補正後チェック１のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック１(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        if (isNull(自己負担額_8月分)) {
            自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        if (isNull(自己負担額_9月分)) {
            自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        if (isNull(自己負担額_10月分)) {
            自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        if (isNull(自己負担額_11月分)) {
            自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        if (isNull(自己負担額_12月分)) {
            自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
        if ((!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分) && !自己負担額_8月分.equals(うち70_74歳に係る負担額_8月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分) && !自己負担額_9月分.equals(うち70_74歳に係る負担額_9月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分) && !自己負担額_10月分.equals(うち70_74歳に係る負担額_10月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分) && !自己負担額_11月分.equals(うち70_74歳に係る負担額_11月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分) && !自己負担額_12月分.equals(うち70_74歳に係る負担額_12月分))) {
            return true;
        }
        return is補正後チェック１_翌年1(div);
    }

    private boolean is補正後チェック１_翌年1(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(自己負担額_1月分)) {
            自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(自己負担額_2月分)) {
            自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(自己負担額_3月分)) {
            自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();

        if ((!Decimal.ZERO.equals(うち70_74歳に係る負担額_1月分) && !自己負担額_1月分.equals(うち70_74歳に係る負担額_1月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_2月分) && !自己負担額_2月分.equals(うち70_74歳に係る負担額_2月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_3月分) && !自己負担額_3月分.equals(うち70_74歳に係る負担額_3月分))) {
            return true;
        }
        return is補正後チェック１_翌年2(div);
    }

    private boolean is補正後チェック１_翌年2(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(自己負担額_4月分)) {
            自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(自己負担額_5月分)) {
            自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(自己負担額_6月分)) {
            自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(自己負担額_7月分)) {
            自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
        return (!Decimal.ZERO.equals(うち70_74歳に係る負担額_4月分) && !自己負担額_4月分.equals(うち70_74歳に係る負担額_4月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_5月分) && !自己負担額_5月分.equals(うち70_74歳に係る負担額_5月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_6月分) && !自己負担額_6月分.equals(うち70_74歳に係る負担額_6月分))
                || (!Decimal.ZERO.equals(うち70_74歳に係る負担額_7月分) && !自己負担額_7月分.equals(うち70_74歳に係る負担額_7月分));
    }

    /**
     * is補正後チェック２のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック２(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
        if ((Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分))
                || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分))
                || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分))
                || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分))
                || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分))) {
            return true;
        }
        return is補正後チェック２_翌年(div);
    }

    private boolean is補正後チェック２_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
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
        Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
        if ((Decimal.ZERO.equals(自己負担額_8月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_8月分))
                || (Decimal.ZERO.equals(自己負担額_9月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_9月分))
                || (Decimal.ZERO.equals(自己負担額_10月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_10月分))
                || (Decimal.ZERO.equals(自己負担額_11月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_11月分))
                || (Decimal.ZERO.equals(自己負担額_12月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_12月分))) {
            return true;
        }
        return is補正後チェック３_翌年(div);
    }

    private boolean is補正後チェック３_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
        return (Decimal.ZERO.equals(自己負担額_1月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_1月分))
                || (Decimal.ZERO.equals(自己負担額_2月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_2月分))
                || (Decimal.ZERO.equals(自己負担額_3月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_3月分))
                || (Decimal.ZERO.equals(自己負担額_4月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_4月分))
                || (Decimal.ZERO.equals(自己負担額_5月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_5月分))
                || (Decimal.ZERO.equals(自己負担額_6月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_6月分))
                || (Decimal.ZERO.equals(自己負担額_7月分) && !Decimal.ZERO.equals(高額介護_予防_サービス費_7月分));
    }

    /**
     * is補正後チェック4_補正後のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return boolean
     */
    public boolean is補正後チェック4_補正後(JikoFutangakuHosei2PanelDiv div) {
        Decimal うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
        if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分)
                || !Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分)) {
            return true;
        }
        return is補正後チェック4_補正後翌年(div);
    }

    private boolean is補正後チェック4_補正後翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
        Decimal うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
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
    public int is補正後チェック8_10(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_008 = new FlexibleYearMonth(対象年度.toString().concat(月_008.toString()));
        FlexibleYearMonth 対象年月_009 = new FlexibleYearMonth(対象年度.toString().concat(月_009.toString()));
        FlexibleYearMonth 対象年月_010 = new FlexibleYearMonth(対象年度.toString().concat(月_010.toString()));
        Decimal うち70_74歳に係る負担額_8月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
        if (対象年月_008.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_008)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_8月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_9月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
        if (対象年月_009.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_009)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_9月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_10月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
        if (対象年月_010.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_010)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_10月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック11_翌年1(div, 生年月日, 対象年度);
    }

    private int is補正後チェック11_翌年1(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_011 = new FlexibleYearMonth(対象年度.toString().concat(月_011.toString()));
        FlexibleYearMonth 対象年月_012 = new FlexibleYearMonth(対象年度.toString().concat(月_012.toString()));
        FlexibleYearMonth 対象年月_101 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_101.toString()));
        Decimal うち70_74歳に係る負担額_11月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
        if (対象年月_011.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_011)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_11月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_12月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
        if (対象年月_012.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_012)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_12月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年1月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
        if (対象年月_101.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_101)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年1月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック翌年2_4(div, 生年月日, 対象年度);
    }

    private int is補正後チェック翌年2_4(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_102 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_102.toString()));
        FlexibleYearMonth 対象年月_103 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_103.toString()));
        FlexibleYearMonth 対象年月_104 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_104.toString()));
        Decimal うち70_74歳に係る負担額_翌年2月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
        if (対象年月_102.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_102)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年2月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年3月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
        if (対象年月_103.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_103)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年3月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年4月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
        if (対象年月_104.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_104)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年4月分_補正後)) {
                return CODE_36;
            }
        }
        return is補正後チェック翌年5_7(div, 生年月日, 対象年度);
    }

    private int is補正後チェック翌年5_7(JikoFutangakuHosei2PanelDiv div, FlexibleDate 生年月日, FlexibleYear 対象年度) {
        FlexibleYearMonth 生年月 = new FlexibleYearMonth(生年月日.toString().substring(INT_0, INT_6));
        FlexibleYearMonth 歳_75_年月 = 生年月.plusYear(歳_75);
        FlexibleYearMonth 歳_70_年月 = 生年月.plusYear(歳_70);
        FlexibleYearMonth 対象年月_105 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_105.toString()));
        FlexibleYearMonth 対象年月_106 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_106.toString()));
        FlexibleYearMonth 対象年月_107 = new FlexibleYearMonth(対象年度.plusYear(INT_1).toString().concat(月_107.toString()));
        Decimal うち70_74歳に係る負担額_翌年5月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
        if (対象年月_105.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_105)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年5月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年6月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
        if (対象年月_106.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_106)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年6月分_補正後)) {
                return CODE_36;
            }
        }
        Decimal うち70_74歳に係る負担額_翌年7月分_補正後 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
        if (対象年月_107.isBefore(歳_70_年月) || 歳_75_年月.isBeforeOrEquals(対象年月_107)) {
            if (!Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
                return CODE_35;
            }
        } else {
            if (Decimal.ZERO.equals(うち70_74歳に係る負担額_翌年7月分_補正後)) {
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
        Decimal 自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_8月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
        Decimal 自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
        Decimal 自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
        Decimal 自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
        Decimal 自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
        if (高額介護_予防_サービス費_8月分.compareTo(自己負担額_8月分) == INT_1
                || 高額介護_予防_サービス費_9月分.compareTo(自己負担額_9月分) == INT_1
                || 高額介護_予防_サービス費_10月分.compareTo(自己負担額_10月分) == INT_1
                || 高額介護_予防_サービス費_11月分.compareTo(自己負担額_11月分) == INT_1
                || 高額介護_予防_サービス費_12月分.compareTo(自己負担額_12月分) == INT_1) {
            return true;
        }
        return is高額介護_予防_サービス費チェック_翌年(div);
    }

    private boolean is高額介護_予防_サービス費チェック_翌年(JikoFutangakuHosei2PanelDiv div) {
        Decimal 自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
        Decimal 自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
        Decimal 自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
        Decimal 自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
        Decimal 自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
        Decimal 自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
        Decimal 自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        Decimal 高額介護_予防_サービス費_7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
        return (高額介護_予防_サービス費_1月分.compareTo(自己負担額_1月分) == INT_1
                || 高額介護_予防_サービス費_2月分.compareTo(自己負担額_2月分) == INT_1
                || 高額介護_予防_サービス費_3月分.compareTo(自己負担額_3月分) == INT_1
                || 高額介護_予防_サービス費_4月分.compareTo(自己負担額_4月分) == INT_1
                || 高額介護_予防_サービス費_5月分.compareTo(自己負担額_5月分) == INT_1
                || 高額介護_予防_サービス費_6月分.compareTo(自己負担額_6月分) == INT_1
                || 高額介護_予防_サービス費_7月分.compareTo(自己負担額_7月分) == INT_1);
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
