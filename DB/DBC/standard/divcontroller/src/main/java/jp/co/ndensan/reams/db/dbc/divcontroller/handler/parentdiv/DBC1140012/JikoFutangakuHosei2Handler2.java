/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.JikoFutangakuHosei2PanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanJikoFutanGakuMeisaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算自己負担額情報補正(単)_補正入力のHandlerクラスです。
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public class JikoFutangakuHosei2Handler2 {

    private final JikoFutangakuHosei2PanelDiv div;
    private static final RString 対象月_004 = new RString("004");
    private static final RString 対象月_005 = new RString("005");
    private static final RString 対象月_006 = new RString("006");
    private static final RString 対象月_007 = new RString("007");
    private static final RString 対象月_008 = new RString("008");
    private static final RString 対象月_009 = new RString("009");
    private static final RString 対象月_010 = new RString("010");
    private static final RString 対象月_011 = new RString("011");
    private static final RString 対象月_012 = new RString("012");
    private static final RString 対象月_101 = new RString("101");
    private static final RString 対象月_102 = new RString("102");
    private static final RString 対象月_103 = new RString("103");
    private static final RString 対象月_104 = new RString("104");
    private static final RString 対象月_105 = new RString("105");
    private static final RString 対象月_106 = new RString("106");
    private static final RString 対象月_107 = new RString("107");

    /**
     * コンストラクタです。
     *
     * @param div 高額合算自己負担額情報補正(単)_補正入力画面のdiv
     */
    public JikoFutangakuHosei2Handler2(JikoFutangakuHosei2PanelDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化のメソッドです。
     *
     * @param 高額合算自己負担額補正保持Entity KogakuGassanJikofutangakuHosei
     */
    public void initilize_初回(KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        HihokenshaNo 被保険者番号 = 高額合算自己負担額補正保持Entity.get被保険者番号();
        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();
        HokenshaNo 保険者番号 = 高額合算自己負担額補正保持Entity.get保険者番号();
        RString 支給申請書整理番号 = 高額合算自己負担額補正保持Entity.get支給申請書整理番号();
        int 履歴番号 = Integer.valueOf(高額合算自己負担額補正保持Entity.get履歴番号().toString());
        KogakuGassanJikoFutanGakuMeisaiManager manager = new KogakuGassanJikoFutanGakuMeisaiManager();
        initialize_高額合算自己負担額明細_4月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_5月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_6月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_7月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_8月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_9月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_10月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_11月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_12月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年1月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年2月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年3月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年4月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年5月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年6月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年7月分_20(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        補正前_自己負担額の合計();
        補正前_うち70_74歳に係る負担額の合計();
        補正前_高額介護_予防_サービス費の合計();
        補正前_実際の自己負担額の合計();
        補正後_自己負担額の合計();
        補正後_うち70_74歳に係る負担額の合計();
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    private void initialize_高額合算自己負担額明細_4月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_4月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_004, 履歴番号);
        if (高額合算自己負担額明細_4月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku4GatsuMae().setValue(高額合算自己負担額明細_4月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae()
                    .setValue(高額合算自己負担額明細_4月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuMae()
                    .setValue(高額合算自己負担額明細_4月分.get70未満高額支給額());
            Decimal 補正前_自己負担額4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku4GatsuMae().getValue();
            if (isNull(補正前_自己負担額4月分)) {
                補正前_自己負担額4月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費4月分)) {
                補正前_高額介護_予防_サービス費4月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuMae()
                    .setValue(補正前_自己負担額4月分.subtract(補正前_高額介護_予防_サービス費4月分));
            if (高額合算自己負担額明細_4月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().setValue(高額合算自己負担額明細_4月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_4月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_4月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_5月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_5月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_005, 履歴番号);
        if (高額合算自己負担額明細_5月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuMae().setValue(高額合算自己負担額明細_5月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae()
                    .setValue(高額合算自己負担額明細_5月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuMae()
                    .setValue(高額合算自己負担額明細_5月分.get70未満高額支給額());
            Decimal 補正前_自己負担額5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuMae().getValue();
            if (isNull(補正前_自己負担額5月分)) {
                補正前_自己負担額5月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費5月分)) {
                補正前_高額介護_予防_サービス費5月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuMae()
                    .setValue(補正前_自己負担額5月分.subtract(補正前_高額介護_予防_サービス費5月分));
            if (高額合算自己負担額明細_5月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().setValue(高額合算自己負担額明細_5月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_5月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_5月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_6月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_6月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_006, 履歴番号);
        if (高額合算自己負担額明細_6月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuMae().setValue(高額合算自己負担額明細_6月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae()
                    .setValue(高額合算自己負担額明細_6月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuMae()
                    .setValue(高額合算自己負担額明細_6月分.get70未満高額支給額());
            Decimal 補正前_自己負担額6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuMae().getValue();
            if (isNull(補正前_自己負担額6月分)) {
                補正前_自己負担額6月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費6月分)) {
                補正前_高額介護_予防_サービス費6月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuMae()
                    .setValue(補正前_自己負担額6月分.subtract(補正前_高額介護_予防_サービス費6月分));
            if (高額合算自己負担額明細_6月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().setValue(高額合算自己負担額明細_6月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_6月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_6月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_7月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_7月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_007, 履歴番号);
        if (高額合算自己負担額明細_7月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuMae().setValue(高額合算自己負担額明細_7月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae()
                    .setValue(高額合算自己負担額明細_7月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuMae()
                    .setValue(高額合算自己負担額明細_7月分.get70未満高額支給額());
            Decimal 補正前_自己負担額7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuMae().getValue();
            if (isNull(補正前_自己負担額7月分)) {
                補正前_自己負担額7月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費7月分)) {
                補正前_高額介護_予防_サービス費7月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuMae()
                    .setValue(補正前_自己負担額7月分.subtract(補正前_高額介護_予防_サービス費7月分));
            if (高額合算自己負担額明細_7月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().setValue(高額合算自己負担額明細_7月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_7月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_7月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_8月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_8月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_008, 履歴番号);
        if (高額合算自己負担額明細_8月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuMae().setValue(高額合算自己負担額明細_8月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae()
                    .setValue(高額合算自己負担額明細_8月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuMae()
                    .setValue(高額合算自己負担額明細_8月分.get70未満高額支給額());
            Decimal 補正前_自己負担額8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuMae().getValue();
            if (isNull(補正前_自己負担額8月分)) {
                補正前_自己負担額8月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費8月分)) {
                補正前_高額介護_予防_サービス費8月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuMae()
                    .setValue(補正前_自己負担額8月分.subtract(補正前_高額介護_予防_サービス費8月分));
            if (高額合算自己負担額明細_8月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().setValue(高額合算自己負担額明細_8月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_8月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo()
                        .setValue(高額合算自己負担額明細_8月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_8月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo()
                        .setValue(高額合算自己負担額明細_8月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_8月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_8月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo()
                        .setValue(高額合算自己負担額明細_8月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_8月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_9月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_9月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_009, 履歴番号);
        if (高額合算自己負担額明細_9月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuMae().setValue(高額合算自己負担額明細_9月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae()
                    .setValue(高額合算自己負担額明細_9月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuMae()
                    .setValue(高額合算自己負担額明細_9月分.get70未満高額支給額());
            Decimal 補正前_自己負担額9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuMae().getValue();
            if (isNull(補正前_自己負担額9月分)) {
                補正前_自己負担額9月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費9月分)) {
                補正前_高額介護_予防_サービス費9月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuMae()
                    .setValue(補正前_自己負担額9月分.subtract(補正前_高額介護_予防_サービス費9月分));
            if (高額合算自己負担額明細_9月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().setValue(高額合算自己負担額明細_9月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_9月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo()
                        .setValue(高額合算自己負担額明細_9月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_9月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo()
                        .setValue(高額合算自己負担額明細_9月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_9月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_9月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo()
                        .setValue(高額合算自己負担額明細_9月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_9月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_10月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_10月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_010, 履歴番号);
        if (高額合算自己負担額明細_10月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuMae().setValue(高額合算自己負担額明細_10月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae()
                    .setValue(高額合算自己負担額明細_10月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuMae()
                    .setValue(高額合算自己負担額明細_10月分.get70未満高額支給額());
            Decimal 補正前_自己負担額10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuMae().getValue();
            if (isNull(補正前_自己負担額10月分)) {
                補正前_自己負担額10月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費10月分)) {
                補正前_高額介護_予防_サービス費10月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuMae()
                    .setValue(補正前_自己負担額10月分.subtract(補正前_高額介護_予防_サービス費10月分));
            if (高額合算自己負担額明細_10月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().setValue(高額合算自己負担額明細_10月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_10月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo()
                        .setValue(高額合算自己負担額明細_10月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_10月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo()
                        .setValue(高額合算自己負担額明細_10月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_10月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_10月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo()
                        .setValue(高額合算自己負担額明細_10月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_10月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_11月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_11月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_011, 履歴番号);
        if (高額合算自己負担額明細_11月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuMae().setValue(高額合算自己負担額明細_11月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae()
                    .setValue(高額合算自己負担額明細_11月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuMae()
                    .setValue(高額合算自己負担額明細_11月分.get70未満高額支給額());
            Decimal 補正前_自己負担額11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuMae().getValue();
            if (isNull(補正前_自己負担額11月分)) {
                補正前_自己負担額11月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費11月分)) {
                補正前_高額介護_予防_サービス費11月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuMae()
                    .setValue(補正前_自己負担額11月分.subtract(補正前_高額介護_予防_サービス費11月分));
            if (高額合算自己負担額明細_11月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().setValue(高額合算自己負担額明細_11月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_11月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo()
                        .setValue(高額合算自己負担額明細_11月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_11月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo()
                        .setValue(高額合算自己負担額明細_11月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_11月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_11月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo()
                        .setValue(高額合算自己負担額明細_11月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_11月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_12月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_12月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_012, 履歴番号);
        if (高額合算自己負担額明細_12月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuMae().setValue(高額合算自己負担額明細_12月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae()
                    .setValue(高額合算自己負担額明細_12月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuMae()
                    .setValue(高額合算自己負担額明細_12月分.get70未満高額支給額());
            Decimal 補正前_自己負担額12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuMae().getValue();
            if (isNull(補正前_自己負担額12月分)) {
                補正前_自己負担額12月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費12月分)) {
                補正前_高額介護_予防_サービス費12月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuMae()
                    .setValue(補正前_自己負担額12月分.subtract(補正前_高額介護_予防_サービス費12月分));
            if (高額合算自己負担額明細_12月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().setValue(高額合算自己負担額明細_12月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_12月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo()
                        .setValue(高額合算自己負担額明細_12月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_12月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo()
                        .setValue(高額合算自己負担額明細_12月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_12月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_12月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo()
                        .setValue(高額合算自己負担額明細_12月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_12月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年1月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_1月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_101, 履歴番号);
        if (高額合算自己負担額明細_1月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuMae().setValue(高額合算自己負担額明細_1月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae()
                    .setValue(高額合算自己負担額明細_1月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae()
                    .setValue(高額合算自己負担額明細_1月分.get70未満高額支給額());
            Decimal 補正前_自己負担額1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuMae().getValue();
            if (isNull(補正前_自己負担額1月分)) {
                補正前_自己負担額1月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費1月分)) {
                補正前_高額介護_予防_サービス費1月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuMae()
                    .setValue(補正前_自己負担額1月分.subtract(補正前_高額介護_予防_サービス費1月分));
            if (高額合算自己負担額明細_1月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().setValue(高額合算自己負担額明細_1月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_1月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo()
                        .setValue(高額合算自己負担額明細_1月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_1月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo()
                        .setValue(高額合算自己負担額明細_1月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_1月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_1月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo()
                        .setValue(高額合算自己負担額明細_1月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_1月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年2月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_2月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_102, 履歴番号);
        if (高額合算自己負担額明細_2月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuMae().setValue(高額合算自己負担額明細_2月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae()
                    .setValue(高額合算自己負担額明細_2月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae()
                    .setValue(高額合算自己負担額明細_2月分.get70未満高額支給額());
            Decimal 補正前_自己負担額2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuMae().getValue();
            if (isNull(補正前_自己負担額2月分)) {
                補正前_自己負担額2月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費2月分)) {
                補正前_高額介護_予防_サービス費2月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuMae()
                    .setValue(補正前_自己負担額2月分.subtract(補正前_高額介護_予防_サービス費2月分));
            if (高額合算自己負担額明細_2月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().setValue(高額合算自己負担額明細_2月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_2月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo()
                        .setValue(高額合算自己負担額明細_2月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_2月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo()
                        .setValue(高額合算自己負担額明細_2月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_2月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_2月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo()
                        .setValue(高額合算自己負担額明細_2月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_2月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年3月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_3月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_103, 履歴番号);
        if (高額合算自己負担額明細_3月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuMae().setValue(高額合算自己負担額明細_3月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae()
                    .setValue(高額合算自己負担額明細_3月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae()
                    .setValue(高額合算自己負担額明細_3月分.get70未満高額支給額());
            Decimal 補正前_自己負担額3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuMae().getValue();
            if (isNull(補正前_自己負担額3月分)) {
                補正前_自己負担額3月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費3月分)) {
                補正前_高額介護_予防_サービス費3月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuMae()
                    .setValue(補正前_自己負担額3月分.subtract(補正前_高額介護_予防_サービス費3月分));
            if (高額合算自己負担額明細_3月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().setValue(高額合算自己負担額明細_3月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_3月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo()
                        .setValue(高額合算自己負担額明細_3月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_3月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo()
                        .setValue(高額合算自己負担額明細_3月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_3月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_3月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo()
                        .setValue(高額合算自己負担額明細_3月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_3月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年4月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_4月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_104, 履歴番号);
        if (高額合算自己負担額明細_4月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuMae().setValue(高額合算自己負担額明細_4月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae()
                    .setValue(高額合算自己負担額明細_4月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae()
                    .setValue(高額合算自己負担額明細_4月分.get70未満高額支給額());
            Decimal 補正前_自己負担額4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuMae().getValue();
            if (isNull(補正前_自己負担額4月分)) {
                補正前_自己負担額4月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費4月分)) {
                補正前_高額介護_予防_サービス費4月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuMae()
                    .setValue(補正前_自己負担額4月分.subtract(補正前_高額介護_予防_サービス費4月分));
            if (高額合算自己負担額明細_4月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().setValue(高額合算自己負担額明細_4月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_4月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_4月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年5月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_5月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_105, 履歴番号);
        if (高額合算自己負担額明細_5月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuMae().setValue(高額合算自己負担額明細_5月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae()
                    .setValue(高額合算自己負担額明細_5月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae()
                    .setValue(高額合算自己負担額明細_5月分.get70未満高額支給額());
            Decimal 補正前_自己負担額5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuMae().getValue();
            if (isNull(補正前_自己負担額5月分)) {
                補正前_自己負担額5月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費5月分)) {
                補正前_高額介護_予防_サービス費5月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuMae()
                    .setValue(補正前_自己負担額5月分.subtract(補正前_高額介護_予防_サービス費5月分));
            if (高額合算自己負担額明細_5月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().setValue(高額合算自己負担額明細_5月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_5月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_5月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年6月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_6月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_106, 履歴番号);
        if (高額合算自己負担額明細_6月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuMae().setValue(高額合算自己負担額明細_6月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae()
                    .setValue(高額合算自己負担額明細_6月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae()
                    .setValue(高額合算自己負担額明細_6月分.get70未満高額支給額());
            Decimal 補正前_自己負担額6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuMae().getValue();
            if (isNull(補正前_自己負担額6月分)) {
                補正前_自己負担額6月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費6月分)) {
                補正前_高額介護_予防_サービス費6月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuMae()
                    .setValue(補正前_自己負担額6月分.subtract(補正前_高額介護_予防_サービス費6月分));
            if (高額合算自己負担額明細_6月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().setValue(高額合算自己負担額明細_6月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_6月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_6月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年7月分_20(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_7月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_107, 履歴番号);
        if (高額合算自己負担額明細_7月分 != null) {
            div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuMae().setValue(高額合算自己負担額明細_7月分.get自己負担額());
            div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae()
                    .setValue(高額合算自己負担額明細_7月分.get70_74自己負担額_内数());
            div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae()
                    .setValue(高額合算自己負担額明細_7月分.get70未満高額支給額());
            Decimal 補正前_自己負担額7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuMae().getValue();
            if (isNull(補正前_自己負担額7月分)) {
                補正前_自己負担額7月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費7月分)) {
                補正前_高額介護_予防_サービス費7月分 = Decimal.ZERO;
            }
            div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuMae()
                    .setValue(補正前_自己負担額7月分.subtract(補正前_高額介護_予防_サービス費7月分));
            if (高額合算自己負担額明細_7月分.get補正済_自己負担額() != null) {
                div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().setValue(高額合算自己負担額明細_7月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_7月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_7月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private boolean isNull(Decimal 金額) {
        return 金額 == null;
    }

    private void 補正前_自己負担額の合計() {
        Decimal 補正前_自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku4GatsuMae().getValue();
        if (isNull(補正前_自己負担額_4月分)) {
            補正前_自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuMae().getValue();
        if (isNull(補正前_自己負担額_5月分)) {
            補正前_自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuMae().getValue();
        if (isNull(補正前_自己負担額_6月分)) {
            補正前_自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuMae().getValue();
        if (isNull(補正前_自己負担額_7月分)) {
            補正前_自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuMae().getValue();
        if (isNull(補正前_自己負担額_8月分)) {
            補正前_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuMae().getValue();
        if (isNull(補正前_自己負担額_9月分)) {
            補正前_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuMae().getValue();
        if (isNull(補正前_自己負担額_10月分)) {
            補正前_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuMae().getValue();
        if (isNull(補正前_自己負担額_11月分)) {
            補正前_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuMae().getValue();
        if (isNull(補正前_自己負担額_12月分)) {
            補正前_自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年1月分)) {
            補正前_自己負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年2月分)) {
            補正前_自己負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年3月分)) {
            補正前_自己負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年4月分)) {
            補正前_自己負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年5月分)) {
            補正前_自己負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年6月分)) {
            補正前_自己負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_翌年7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_自己負担額_翌年7月分)) {
            補正前_自己負担額_翌年7月分 = Decimal.ZERO;
        }
        Decimal 自己負担額の合計 = 補正前_自己負担額_4月分.add(補正前_自己負担額_5月分).add(補正前_自己負担額_6月分).add(補正前_自己負担額_7月分)
                .add(補正前_自己負担額_8月分).add(補正前_自己負担額_9月分).add(補正前_自己負担額_10月分).add(補正前_自己負担額_11月分)
                .add(補正前_自己負担額_12月分).add(補正前_自己負担額_翌年1月分).add(補正前_自己負担額_翌年2月分).add(補正前_自己負担額_翌年3月分)
                .add(補正前_自己負担額_翌年4月分).add(補正前_自己負担額_翌年5月分).add(補正前_自己負担額_翌年6月分).add(補正前_自己負担額_翌年7月分);
        div.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiMae().setValue(自己負担額の合計);
    }

    private void 補正後_自己負担額の合計() {
        Decimal 補正後_自己負担額_4月分 = div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額_4月分)) {
            補正後_自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額_5月分)) {
            補正後_自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額_6月分)) {
            補正後_自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額_7月分)) {
            補正後_自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額_8月分)) {
            補正後_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額_9月分)) {
            補正後_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額_10月分)) {
            補正後_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額_11月分)) {
            補正後_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額_12月分)) {
            補正後_自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年1月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年1月分)) {
            補正後_自己負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年2月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年2月分)) {
            補正後_自己負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年3月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年3月分)) {
            補正後_自己負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年4月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年4月分)) {
            補正後_自己負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年5月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年5月分)) {
            補正後_自己負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年6月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年6月分)) {
            補正後_自己負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_翌年7月分 = div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額_翌年7月分)) {
            補正後_自己負担額_翌年7月分 = Decimal.ZERO;
        }
        Decimal 自己負担額の合計 = 補正後_自己負担額_4月分.add(補正後_自己負担額_5月分).add(補正後_自己負担額_6月分).add(補正後_自己負担額_7月分)
                .add(補正後_自己負担額_8月分).add(補正後_自己負担額_9月分).add(補正後_自己負担額_10月分).add(補正後_自己負担額_11月分)
                .add(補正後_自己負担額_12月分).add(補正後_自己負担額_翌年1月分).add(補正後_自己負担額_翌年2月分).add(補正後_自己負担額_翌年3月分)
                .add(補正後_自己負担額_翌年4月分).add(補正後_自己負担額_翌年5月分).add(補正後_自己負担額_翌年6月分).add(補正後_自己負担額_翌年7月分);
        div.getTbl20Nendo().getTxt20NendoJikofutangakuGoukeiGo().setValue(自己負担額の合計);
    }

    private void 補正前_うち70_74歳に係る負担額の合計() {
        Decimal 補正前_うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_4月分)) {
            補正前_うち70_74歳に係る負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_5月分)) {
            補正前_うち70_74歳に係る負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_6月分)) {
            補正前_うち70_74歳に係る負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_7月分)) {
            補正前_うち70_74歳に係る負担額_7月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_8月分)) {
            補正前_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_9月分)) {
            補正前_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_10月分)) {
            補正前_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_11月分)) {
            補正前_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_12月分)) {
            補正前_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年1月分)) {
            補正前_うち70_74歳に係る負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年2月分)) {
            補正前_うち70_74歳に係る負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年3月分)) {
            補正前_うち70_74歳に係る負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年4月分)) {
            補正前_うち70_74歳に係る負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年5月分)) {
            補正前_うち70_74歳に係る負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年6月分)) {
            補正前_うち70_74歳に係る負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_翌年7月分)) {
            補正前_うち70_74歳に係る負担額_翌年7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額の合計 = 補正前_うち70_74歳に係る負担額_4月分.add(補正前_うち70_74歳に係る負担額_5月分)
                .add(補正前_うち70_74歳に係る負担額_6月分).add(補正前_うち70_74歳に係る負担額_7月分).add(補正前_うち70_74歳に係る負担額_8月分)
                .add(補正前_うち70_74歳に係る負担額_9月分).add(補正前_うち70_74歳に係る負担額_10月分).add(補正前_うち70_74歳に係る負担額_11月分)
                .add(補正前_うち70_74歳に係る負担額_12月分).add(補正前_うち70_74歳に係る負担額_翌年1月分).add(補正前_うち70_74歳に係る負担額_翌年2月分)
                .add(補正前_うち70_74歳に係る負担額_翌年3月分).add(補正前_うち70_74歳に係る負担額_翌年4月分).add(補正前_うち70_74歳に係る負担額_翌年5月分)
                .add(補正前_うち70_74歳に係る負担額_翌年6月分).add(補正前_うち70_74歳に係る負担額_翌年7月分);
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiMae().setValue(うち70_74歳に係る負担額の合計);
    }

    /**
     * 補正後　うち70～74歳に係る負担額　の合計
     */
    public void 補正後_うち70_74歳に係る負担額の合計() {
        Decimal 補正後_うち70_74歳に係る負担額_4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_4月分)) {
            補正後_うち70_74歳に係る負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_5月分)) {
            補正後_うち70_74歳に係る負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_6月分)) {
            補正後_うち70_74歳に係る負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_7月分)) {
            補正後_うち70_74歳に係る負担額_7月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_8月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_8月分)) {
            補正後_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_9月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_9月分)) {
            補正後_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_10月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_10月分)) {
            補正後_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_11月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_11月分)) {
            補正後_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_12月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_12月分)) {
            補正後_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年1月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年1月分)) {
            補正後_うち70_74歳に係る負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年2月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年2月分)) {
            補正後_うち70_74歳に係る負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年3月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年3月分)) {
            補正後_うち70_74歳に係る負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年4月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年4月分)) {
            補正後_うち70_74歳に係る負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年5月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年5月分)) {
            補正後_うち70_74歳に係る負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年6月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年6月分)) {
            補正後_うち70_74歳に係る負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_翌年7月分 = div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_翌年7月分)) {
            補正後_うち70_74歳に係る負担額_翌年7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額の合計 = 補正後_うち70_74歳に係る負担額_4月分.add(補正後_うち70_74歳に係る負担額_5月分)
                .add(補正後_うち70_74歳に係る負担額_6月分).add(補正後_うち70_74歳に係る負担額_7月分).add(補正後_うち70_74歳に係る負担額_8月分)
                .add(補正後_うち70_74歳に係る負担額_9月分).add(補正後_うち70_74歳に係る負担額_10月分).add(補正後_うち70_74歳に係る負担額_11月分)
                .add(補正後_うち70_74歳に係る負担額_12月分).add(補正後_うち70_74歳に係る負担額_翌年1月分).add(補正後_うち70_74歳に係る負担額_翌年2月分)
                .add(補正後_うち70_74歳に係る負担額_翌年3月分).add(補正後_うち70_74歳に係る負担額_翌年4月分).add(補正後_うち70_74歳に係る負担額_翌年5月分)
                .add(補正後_うち70_74歳に係る負担額_翌年6月分).add(補正後_うち70_74歳に係る負担額_翌年7月分);
        div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuGoukeiGo().setValue(うち70_74歳に係る負担額の合計);
    }

    private void 補正前_高額介護_予防_サービス費の合計() {
        Decimal 補正前_高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_4月分)) {
            補正前_高額介護_予防_サービス費_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_5月分)) {
            補正前_高額介護_予防_サービス費_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_6月分)) {
            補正前_高額介護_予防_サービス費_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_7月分)) {
            補正前_高額介護_予防_サービス費_7月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_8月分)) {
            補正前_高額介護_予防_サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_9月分)) {
            補正前_高額介護_予防_サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_10月分)) {
            補正前_高額介護_予防_サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_11月分)) {
            補正前_高額介護_予防_サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_12月分)) {
            補正前_高額介護_予防_サービス費_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年1月分)) {
            補正前_高額介護_予防_サービス費_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年2月分)) {
            補正前_高額介護_予防_サービス費_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年3月分)) {
            補正前_高額介護_予防_サービス費_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年4月分)) {
            補正前_高額介護_予防_サービス費_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年5月分)) {
            補正前_高額介護_予防_サービス費_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年6月分)) {
            補正前_高額介護_予防_サービス費_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_翌年7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_翌年7月分)) {
            補正前_高額介護_予防_サービス費_翌年7月分 = Decimal.ZERO;
        }
        Decimal 高額介護_予防_サービス費の合計 = 補正前_高額介護_予防_サービス費_4月分.add(補正前_高額介護_予防_サービス費_5月分)
                .add(補正前_高額介護_予防_サービス費_6月分).add(補正前_高額介護_予防_サービス費_7月分)
                .add(補正前_高額介護_予防_サービス費_8月分).add(補正前_高額介護_予防_サービス費_9月分)
                .add(補正前_高額介護_予防_サービス費_10月分).add(補正前_高額介護_予防_サービス費_11月分)
                .add(補正前_高額介護_予防_サービス費_12月分).add(補正前_高額介護_予防_サービス費_翌年1月分)
                .add(補正前_高額介護_予防_サービス費_翌年2月分).add(補正前_高額介護_予防_サービス費_翌年3月分)
                .add(補正前_高額介護_予防_サービス費_翌年4月分).add(補正前_高額介護_予防_サービス費_翌年5月分)
                .add(補正前_高額介護_予防_サービス費_翌年6月分).add(補正前_高額介護_予防_サービス費_翌年7月分);
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiMae().setValue(高額介護_予防_サービス費の合計);
    }

    private void 補正後_高額介護_予防_サービス費の合計() {
        Decimal 補正後_高額介護_予防_サービス費_4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_4月分)) {
            補正後_高額介護_予防_サービス費_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_5月分)) {
            補正後_高額介護_予防_サービス費_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_6月分)) {
            補正後_高額介護_予防_サービス費_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_7月分)) {
            補正後_高額介護_予防_サービス費_7月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_8月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_8月分)) {
            補正後_高額介護_予防_サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_9月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_9月分)) {
            補正後_高額介護_予防_サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_10月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_10月分)) {
            補正後_高額介護_予防_サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_11月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_11月分)) {
            補正後_高額介護_予防_サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_12月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_12月分)) {
            補正後_高額介護_予防_サービス費_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年1月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年1月分)) {
            補正後_高額介護_予防_サービス費_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年2月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年2月分)) {
            補正後_高額介護_予防_サービス費_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年3月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年3月分)) {
            補正後_高額介護_予防_サービス費_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年4月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年4月分)) {
            補正後_高額介護_予防_サービス費_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年5月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年5月分)) {
            補正後_高額介護_予防_サービス費_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年6月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年6月分)) {
            補正後_高額介護_予防_サービス費_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_翌年7月分 = div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_翌年7月分)) {
            補正後_高額介護_予防_サービス費_翌年7月分 = Decimal.ZERO;
        }
        Decimal 高額介護_予防_サービス費の合計 = 補正後_高額介護_予防_サービス費_4月分.add(補正後_高額介護_予防_サービス費_5月分)
                .add(補正後_高額介護_予防_サービス費_6月分).add(補正後_高額介護_予防_サービス費_7月分)
                .add(補正後_高額介護_予防_サービス費_8月分).add(補正後_高額介護_予防_サービス費_9月分)
                .add(補正後_高額介護_予防_サービス費_10月分).add(補正後_高額介護_予防_サービス費_11月分)
                .add(補正後_高額介護_予防_サービス費_12月分).add(補正後_高額介護_予防_サービス費_翌年1月分)
                .add(補正後_高額介護_予防_サービス費_翌年2月分).add(補正後_高額介護_予防_サービス費_翌年3月分)
                .add(補正後_高額介護_予防_サービス費_翌年4月分).add(補正後_高額介護_予防_サービス費_翌年5月分)
                .add(補正後_高額介護_予防_サービス費_翌年6月分).add(補正後_高額介護_予防_サービス費_翌年7月分);
        div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiGoukeiGo().setValue(高額介護_予防_サービス費の合計);
    }

    private void 補正前_実際の自己負担額の合計() {
        Decimal 補正前_実際の自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_4月分)) {
            補正前_実際の自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_5月分)) {
            補正前_実際の自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_6月分)) {
            補正前_実際の自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_7月分)) {
            補正前_実際の自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_8月分)) {
            補正前_実際の自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_9月分)) {
            補正前_実際の自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_10月分)) {
            補正前_実際の自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_11月分)) {
            補正前_実際の自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_12月分)) {
            補正前_実際の自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年1月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年1月分)) {
            補正前_実際の自己負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年2月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年2月分)) {
            補正前_実際の自己負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年3月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年3月分)) {
            補正前_実際の自己負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年4月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年4月分)) {
            補正前_実際の自己負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年5月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年5月分)) {
            補正前_実際の自己負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年6月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年6月分)) {
            補正前_実際の自己負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_翌年7月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_翌年7月分)) {
            補正前_実際の自己負担額_翌年7月分 = Decimal.ZERO;
        }
        Decimal 実際の自己負担額の合計 = 補正前_実際の自己負担額_4月分.add(補正前_実際の自己負担額_5月分)
                .add(補正前_実際の自己負担額_6月分).add(補正前_実際の自己負担額_7月分).add(補正前_実際の自己負担額_8月分)
                .add(補正前_実際の自己負担額_9月分).add(補正前_実際の自己負担額_10月分).add(補正前_実際の自己負担額_11月分)
                .add(補正前_実際の自己負担額_12月分).add(補正前_実際の自己負担額_翌年1月分).add(補正前_実際の自己負担額_翌年2月分)
                .add(補正前_実際の自己負担額_翌年3月分).add(補正前_実際の自己負担額_翌年4月分).add(補正前_実際の自己負担額_翌年5月分)
                .add(補正前_実際の自己負担額_翌年6月分).add(補正前_実際の自己負担額_翌年7月分);
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiMae().setValue(実際の自己負担額の合計);
    }

    private void 補正後_実際の自己負担額の合計() {
        Decimal 補正後_実際の自己負担額_4月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_4月分)) {
            補正後_実際の自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_5月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_5月分)) {
            補正後_実際の自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_6月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_6月分)) {
            補正後_実際の自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_7月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_7月分)) {
            補正後_実際の自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_8月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_8月分)) {
            補正後_実際の自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_9月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_9月分)) {
            補正後_実際の自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_10月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_10月分)) {
            補正後_実際の自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_11月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_11月分)) {
            補正後_実際の自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_12月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_12月分)) {
            補正後_実際の自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年1月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年1月分)) {
            補正後_実際の自己負担額_翌年1月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年2月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年2月分)) {
            補正後_実際の自己負担額_翌年2月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年3月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年3月分)) {
            補正後_実際の自己負担額_翌年3月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年4月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年4月分)) {
            補正後_実際の自己負担額_翌年4月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年5月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年5月分)) {
            補正後_実際の自己負担額_翌年5月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年6月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年6月分)) {
            補正後_実際の自己負担額_翌年6月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_翌年7月分 = div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_翌年7月分)) {
            補正後_実際の自己負担額_翌年7月分 = Decimal.ZERO;
        }
        Decimal 実際の自己負担額の合計 = 補正後_実際の自己負担額_4月分.add(補正後_実際の自己負担額_5月分)
                .add(補正後_実際の自己負担額_6月分).add(補正後_実際の自己負担額_7月分).add(補正後_実際の自己負担額_8月分)
                .add(補正後_実際の自己負担額_9月分).add(補正後_実際の自己負担額_10月分).add(補正後_実際の自己負担額_11月分)
                .add(補正後_実際の自己負担額_12月分).add(補正後_実際の自己負担額_翌年1月分).add(補正後_実際の自己負担額_翌年2月分)
                .add(補正後_実際の自己負担額_翌年3月分).add(補正後_実際の自己負担額_翌年4月分).add(補正後_実際の自己負担額_翌年5月分)
                .add(補正後_実際の自己負担額_翌年6月分).add(補正後_実際の自己負担額_翌年7月分);
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuGoukeiGo().setValue(実際の自己負担額の合計);
    }

    /**
     * [4月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_cel20NendoJikofutangaku4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getCel20NendoJikofutangaku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [5月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [6月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [7月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [8月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku8GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [9月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku9GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [10月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku10GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [11月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku11GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [12月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangaku12GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年1月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku1GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年2月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku2GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年3月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku3GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年4月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年5月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年6月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年7月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20NendoJikofutangakuYoku7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [4月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getCel20NendoJikofutangaku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku4GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [5月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku5GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [6月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku6GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [7月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku7GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [8月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi8GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku8GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [9月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi9GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku9GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [10月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi10GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku10GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [11月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi11GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku11GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [12月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehi12GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangaku12GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年1月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku1GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku1GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年2月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku2GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku2GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年3月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku3GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku3GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年4月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku4GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年5月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku5GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年6月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku6GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年7月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20NendoKougakuKaigoServicehiYoku7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Nendo()
                .getTxt20NendoJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Nendo()
                .getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Nendo().getTxt20NendoJissaiJikofutangakuYoku7GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }
}
