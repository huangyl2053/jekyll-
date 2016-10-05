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
public class JikoFutangakuHosei2Handler1 {

    private final JikoFutangakuHosei2PanelDiv div;
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
    public JikoFutangakuHosei2Handler1(JikoFutangakuHosei2PanelDiv div) {
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
        initialize_高額合算自己負担額明細_8月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_9月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_10月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_11月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_12月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年1月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年2月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年3月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年4月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年5月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年6月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_高額合算自己負担額明細_翌年7月分_20以外(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        補正前_自己負担額の合計();
        補正前_うち70_74歳に係る負担額の合計();
        補正前_高額介護_予防_サービス費の合計();
        補正前_実際の自己負担額の合計();
        補正後_自己負担額の合計();
        補正後_うち70_74歳に係る負担額の合計();
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    private void initialize_高額合算自己負担額明細_8月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_8月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_008, 履歴番号);
        if (高額合算自己負担額明細_8月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuMae().setValue(高額合算自己負担額明細_8月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuMae()
                    .setValue(高額合算自己負担額明細_8月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuMae()
                    .setValue(高額合算自己負担額明細_8月分.get70未満高額支給額());
            Decimal 補正前_自己負担額８月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuMae().getValue();
            if (isNull(補正前_自己負担額８月分)) {
                補正前_自己負担額８月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費８月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費８月分)) {
                補正前_高額介護_予防_サービス費８月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuMae()
                    .setValue(補正前_自己負担額８月分.subtract(補正前_高額介護_予防_サービス費８月分));
            if (高額合算自己負担額明細_8月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().setValue(高額合算自己負担額明細_8月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_8月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo()
                        .setValue(高額合算自己負担額明細_8月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_8月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo()
                        .setValue(高額合算自己負担額明細_8月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_8月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_8月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo()
                        .setValue(高額合算自己負担額明細_8月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_8月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_9月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_9月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_009, 履歴番号);
        if (高額合算自己負担額明細_9月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuMae().setValue(高額合算自己負担額明細_9月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuMae()
                    .setValue(高額合算自己負担額明細_9月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuMae()
                    .setValue(高額合算自己負担額明細_9月分.get70未満高額支給額());
            Decimal 補正前_自己負担額9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuMae().getValue();
            if (isNull(補正前_自己負担額9月分)) {
                補正前_自己負担額9月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費9月分)) {
                補正前_高額介護_予防_サービス費9月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuMae()
                    .setValue(補正前_自己負担額9月分.subtract(補正前_高額介護_予防_サービス費9月分));
            if (高額合算自己負担額明細_9月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().setValue(高額合算自己負担額明細_9月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_9月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo()
                        .setValue(高額合算自己負担額明細_9月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_9月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo()
                        .setValue(高額合算自己負担額明細_9月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_9月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_9月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo()
                        .setValue(高額合算自己負担額明細_9月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_9月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_10月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_10月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_010, 履歴番号);
        if (高額合算自己負担額明細_10月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuMae().setValue(高額合算自己負担額明細_10月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuMae()
                    .setValue(高額合算自己負担額明細_10月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuMae()
                    .setValue(高額合算自己負担額明細_10月分.get70未満高額支給額());
            Decimal 補正前_自己負担額10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuMae().getValue();
            if (isNull(補正前_自己負担額10月分)) {
                補正前_自己負担額10月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費10月分)) {
                補正前_高額介護_予防_サービス費10月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuMae()
                    .setValue(補正前_自己負担額10月分.subtract(補正前_高額介護_予防_サービス費10月分));
            if (高額合算自己負担額明細_10月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().setValue(高額合算自己負担額明細_10月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_10月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo()
                        .setValue(高額合算自己負担額明細_10月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_10月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo()
                        .setValue(高額合算自己負担額明細_10月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_10月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_10月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo()
                        .setValue(高額合算自己負担額明細_10月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_10月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_11月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_11月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_011, 履歴番号);
        if (高額合算自己負担額明細_11月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuMae().setValue(高額合算自己負担額明細_11月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuMae()
                    .setValue(高額合算自己負担額明細_11月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuMae()
                    .setValue(高額合算自己負担額明細_11月分.get70未満高額支給額());
            Decimal 補正前_自己負担額11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuMae().getValue();
            if (isNull(補正前_自己負担額11月分)) {
                補正前_自己負担額11月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費11月分)) {
                補正前_高額介護_予防_サービス費11月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuMae()
                    .setValue(補正前_自己負担額11月分.subtract(補正前_高額介護_予防_サービス費11月分));
            if (高額合算自己負担額明細_11月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().setValue(高額合算自己負担額明細_11月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_11月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo()
                        .setValue(高額合算自己負担額明細_11月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_11月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo()
                        .setValue(高額合算自己負担額明細_11月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_11月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_11月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo()
                        .setValue(高額合算自己負担額明細_11月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_11月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_12月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_12月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_012, 履歴番号);
        if (高額合算自己負担額明細_12月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuMae().setValue(高額合算自己負担額明細_12月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuMae()
                    .setValue(高額合算自己負担額明細_12月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuMae()
                    .setValue(高額合算自己負担額明細_12月分.get70未満高額支給額());
            Decimal 補正前_自己負担額12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuMae().getValue();
            if (isNull(補正前_自己負担額12月分)) {
                補正前_自己負担額12月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費12月分)) {
                補正前_高額介護_予防_サービス費12月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuMae()
                    .setValue(補正前_自己負担額12月分.subtract(補正前_高額介護_予防_サービス費12月分));
            if (高額合算自己負担額明細_12月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().setValue(高額合算自己負担額明細_12月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_12月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo()
                        .setValue(高額合算自己負担額明細_12月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_12月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo()
                        .setValue(高額合算自己負担額明細_12月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_12月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_12月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo()
                        .setValue(高額合算自己負担額明細_12月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_12月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年1月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_1月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_101, 履歴番号);
        if (高額合算自己負担額明細_1月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuMae().setValue(高額合算自己負担額明細_1月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuMae()
                    .setValue(高額合算自己負担額明細_1月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae()
                    .setValue(高額合算自己負担額明細_1月分.get70未満高額支給額());
            Decimal 補正前_自己負担額1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuMae().getValue();
            if (isNull(補正前_自己負担額1月分)) {
                補正前_自己負担額1月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費1月分)) {
                補正前_高額介護_予防_サービス費1月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae()
                    .setValue(補正前_自己負担額1月分.subtract(補正前_高額介護_予防_サービス費1月分));
            if (高額合算自己負担額明細_1月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().setValue(高額合算自己負担額明細_1月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_1月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo()
                        .setValue(高額合算自己負担額明細_1月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_1月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo()
                        .setValue(高額合算自己負担額明細_1月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_1月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_1月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo()
                        .setValue(高額合算自己負担額明細_1月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_1月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年2月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_2月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_102, 履歴番号);
        if (高額合算自己負担額明細_2月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuMae().setValue(高額合算自己負担額明細_2月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuMae()
                    .setValue(高額合算自己負担額明細_2月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae()
                    .setValue(高額合算自己負担額明細_2月分.get70未満高額支給額());
            Decimal 補正前_自己負担額2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuMae().getValue();
            if (isNull(補正前_自己負担額2月分)) {
                補正前_自己負担額2月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費2月分)) {
                補正前_高額介護_予防_サービス費2月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae()
                    .setValue(補正前_自己負担額2月分.subtract(補正前_高額介護_予防_サービス費2月分));
            if (高額合算自己負担額明細_2月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().setValue(高額合算自己負担額明細_2月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_2月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo()
                        .setValue(高額合算自己負担額明細_2月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_2月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo()
                        .setValue(高額合算自己負担額明細_2月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_2月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_2月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo()
                        .setValue(高額合算自己負担額明細_2月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_2月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年3月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_3月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_103, 履歴番号);
        if (高額合算自己負担額明細_3月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuMae().setValue(高額合算自己負担額明細_3月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuMae()
                    .setValue(高額合算自己負担額明細_3月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae()
                    .setValue(高額合算自己負担額明細_3月分.get70未満高額支給額());
            Decimal 補正前_自己負担額3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuMae().getValue();
            if (isNull(補正前_自己負担額3月分)) {
                補正前_自己負担額3月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費3月分)) {
                補正前_高額介護_予防_サービス費3月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae()
                    .setValue(補正前_自己負担額3月分.subtract(補正前_高額介護_予防_サービス費3月分));
            if (高額合算自己負担額明細_3月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().setValue(高額合算自己負担額明細_3月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_3月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo()
                        .setValue(高額合算自己負担額明細_3月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_3月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo()
                        .setValue(高額合算自己負担額明細_3月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_3月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_3月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo()
                        .setValue(高額合算自己負担額明細_3月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_3月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年4月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_4月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_104, 履歴番号);
        if (高額合算自己負担額明細_4月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuMae().setValue(高額合算自己負担額明細_4月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuMae()
                    .setValue(高額合算自己負担額明細_4月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae()
                    .setValue(高額合算自己負担額明細_4月分.get70未満高額支給額());
            Decimal 補正前_自己負担額4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuMae().getValue();
            if (isNull(補正前_自己負担額4月分)) {
                補正前_自己負担額4月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費4月分)) {
                補正前_高額介護_予防_サービス費4月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae()
                    .setValue(補正前_自己負担額4月分.subtract(補正前_高額介護_予防_サービス費4月分));
            if (高額合算自己負担額明細_4月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().setValue(高額合算自己負担額明細_4月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_4月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo()
                        .setValue(高額合算自己負担額明細_4月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_4月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年5月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_5月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_105, 履歴番号);
        if (高額合算自己負担額明細_5月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuMae().setValue(高額合算自己負担額明細_5月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuMae()
                    .setValue(高額合算自己負担額明細_5月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae()
                    .setValue(高額合算自己負担額明細_5月分.get70未満高額支給額());
            Decimal 補正前_自己負担額5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuMae().getValue();
            if (isNull(補正前_自己負担額5月分)) {
                補正前_自己負担額5月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費5月分)) {
                補正前_高額介護_予防_サービス費5月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae()
                    .setValue(補正前_自己負担額5月分.subtract(補正前_高額介護_予防_サービス費5月分));
            if (高額合算自己負担額明細_5月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().setValue(高額合算自己負担額明細_5月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_5月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo()
                        .setValue(高額合算自己負担額明細_5月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_5月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年6月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_6月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_106, 履歴番号);
        if (高額合算自己負担額明細_6月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuMae().setValue(高額合算自己負担額明細_6月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuMae()
                    .setValue(高額合算自己負担額明細_6月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae()
                    .setValue(高額合算自己負担額明細_6月分.get70未満高額支給額());
            Decimal 補正前_自己負担額6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuMae().getValue();
            if (isNull(補正前_自己負担額6月分)) {
                補正前_自己負担額6月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費6月分)) {
                補正前_高額介護_予防_サービス費6月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae()
                    .setValue(補正前_自己負担額6月分.subtract(補正前_高額介護_予防_サービス費6月分));
            if (高額合算自己負担額明細_6月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().setValue(高額合算自己負担額明細_6月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_6月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo()
                        .setValue(高額合算自己負担額明細_6月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_6月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_高額合算自己負担額明細_翌年7月分_20以外(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細_7月分 = manager
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_107, 履歴番号);
        if (高額合算自己負担額明細_7月分 != null) {
            div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuMae().setValue(高額合算自己負担額明細_7月分.get自己負担額());
            div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuMae()
                    .setValue(高額合算自己負担額明細_7月分.get70_74自己負担額_内数());
            div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae()
                    .setValue(高額合算自己負担額明細_7月分.get70未満高額支給額());
            Decimal 補正前_自己負担額7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuMae().getValue();
            if (isNull(補正前_自己負担額7月分)) {
                補正前_自己負担額7月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額介護_予防_サービス費7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae().getValue();
            if (isNull(補正前_高額介護_予防_サービス費7月分)) {
                補正前_高額介護_予防_サービス費7月分 = Decimal.ZERO;
            }
            div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae()
                    .setValue(補正前_自己負担額7月分.subtract(補正前_高額介護_予防_サービス費7月分));
            if (高額合算自己負担額明細_7月分.get補正済_自己負担額() != null) {
                div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().setValue(高額合算自己負担額明細_7月分.get補正済_自己負担額());
            }
            if (高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数() != null) {
                div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数());
            }
            if (高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_70未満高額支給額());
            }
            if (高額合算自己負担額明細_7月分.get補正済_自己負担額() != null && 高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo()
                        .setValue(高額合算自己負担額明細_7月分.get補正済_自己負担額()
                                .subtract(高額合算自己負担額明細_7月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private boolean isNull(Decimal 金額) {
        return 金額 == null;
    }

    private void 補正前_自己負担額の合計() {
        Decimal 補正前_自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuMae().getValue();
        if (isNull(補正前_自己負担額_8月分)) {
            補正前_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuMae().getValue();
        if (isNull(補正前_自己負担額_9月分)) {
            補正前_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuMae().getValue();
        if (isNull(補正前_自己負担額_10月分)) {
            補正前_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuMae().getValue();
        if (isNull(補正前_自己負担額_11月分)) {
            補正前_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuMae().getValue();
        if (isNull(補正前_自己負担額_12月分)) {
            補正前_自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_自己負担額_1月分)) {
            補正前_自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_自己負担額_2月分)) {
            補正前_自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_自己負担額_3月分)) {
            補正前_自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_自己負担額_4月分)) {
            補正前_自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_自己負担額_5月分)) {
            補正前_自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_自己負担額_6月分)) {
            補正前_自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_自己負担額_7月分)) {
            補正前_自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 自己負担額の合計 = 補正前_自己負担額_8月分.add(補正前_自己負担額_9月分).add(補正前_自己負担額_10月分).add(補正前_自己負担額_11月分)
                .add(補正前_自己負担額_12月分).add(補正前_自己負担額_1月分).add(補正前_自己負担額_2月分).add(補正前_自己負担額_3月分)
                .add(補正前_自己負担額_4月分).add(補正前_自己負担額_5月分).add(補正前_自己負担額_6月分).add(補正前_自己負担額_7月分);
        div.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiMae().setValue(自己負担額の合計);
    }

    private void 補正後_自己負担額の合計() {
        Decimal 補正後_自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額_8月分)) {
            補正後_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額_9月分)) {
            補正後_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額_10月分)) {
            補正後_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額_11月分)) {
            補正後_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額_12月分)) {
            補正後_自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額_1月分)) {
            補正後_自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額_2月分)) {
            補正後_自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額_3月分)) {
            補正後_自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額_4月分)) {
            補正後_自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額_5月分)) {
            補正後_自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額_6月分)) {
            補正後_自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額_7月分)) {
            補正後_自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 自己負担額の合計 = 補正後_自己負担額_8月分.add(補正後_自己負担額_9月分).add(補正後_自己負担額_10月分).add(補正後_自己負担額_11月分)
                .add(補正後_自己負担額_12月分).add(補正後_自己負担額_1月分).add(補正後_自己負担額_2月分).add(補正後_自己負担額_3月分)
                .add(補正後_自己負担額_4月分).add(補正後_自己負担額_5月分).add(補正後_自己負担額_6月分).add(補正後_自己負担額_7月分);
        div.getTbl20Igai().getTxt20IgaiJikofutangakuGoukeiGo().setValue(自己負担額の合計);
    }

    private void 補正前_うち70_74歳に係る負担額の合計() {
        Decimal 補正前_うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_8月分)) {
            補正前_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_9月分)) {
            補正前_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_10月分)) {
            補正前_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_11月分)) {
            補正前_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_12月分)) {
            補正前_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_1月分)) {
            補正前_うち70_74歳に係る負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_2月分)) {
            補正前_うち70_74歳に係る負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_3月分)) {
            補正前_うち70_74歳に係る負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_4月分)) {
            補正前_うち70_74歳に係る負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_5月分)) {
            補正前_うち70_74歳に係る負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_6月分)) {
            補正前_うち70_74歳に係る負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_7月分)) {
            補正前_うち70_74歳に係る負担額_7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額の合計 = 補正前_うち70_74歳に係る負担額_8月分.add(補正前_うち70_74歳に係る負担額_9月分)
                .add(補正前_うち70_74歳に係る負担額_10月分).add(補正前_うち70_74歳に係る負担額_11月分).add(補正前_うち70_74歳に係る負担額_12月分)
                .add(補正前_うち70_74歳に係る負担額_1月分).add(補正前_うち70_74歳に係る負担額_2月分).add(補正前_うち70_74歳に係る負担額_3月分)
                .add(補正前_うち70_74歳に係る負担額_4月分).add(補正前_うち70_74歳に係る負担額_5月分).add(補正前_うち70_74歳に係る負担額_6月分)
                .add(補正前_うち70_74歳に係る負担額_7月分);
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiMae().setValue(うち70_74歳に係る負担額の合計);
    }

    /**
     * 補正後　うち70～74歳に係る負担額　の合計
     */
    public void 補正後_うち70_74歳に係る負担額の合計() {
        Decimal 補正後_うち70_74歳に係る負担額_8月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_8月分)) {
            補正後_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_9月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_9月分)) {
            補正後_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_10月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_10月分)) {
            補正後_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_11月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_11月分)) {
            補正後_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_12月分 = div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_12月分)) {
            補正後_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_1月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_1月分)) {
            補正後_うち70_74歳に係る負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_2月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_2月分)) {
            補正後_うち70_74歳に係る負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_3月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_3月分)) {
            補正後_うち70_74歳に係る負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_4月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_4月分)) {
            補正後_うち70_74歳に係る負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_5月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_5月分)) {
            補正後_うち70_74歳に係る負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_6月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_6月分)) {
            補正後_うち70_74歳に係る負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_7月分 = div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_7月分)) {
            補正後_うち70_74歳に係る負担額_7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額の合計 = 補正後_うち70_74歳に係る負担額_8月分.add(補正後_うち70_74歳に係る負担額_9月分)
                .add(補正後_うち70_74歳に係る負担額_10月分).add(補正後_うち70_74歳に係る負担額_11月分).add(補正後_うち70_74歳に係る負担額_12月分)
                .add(補正後_うち70_74歳に係る負担額_1月分).add(補正後_うち70_74歳に係る負担額_2月分).add(補正後_うち70_74歳に係る負担額_3月分)
                .add(補正後_うち70_74歳に係る負担額_4月分).add(補正後_うち70_74歳に係る負担額_5月分).add(補正後_うち70_74歳に係る負担額_6月分)
                .add(補正後_うち70_74歳に係る負担額_7月分);
        div.getTbl20Igai().getTxt20Igai70Kara74FutangakuGoukeiGo().setValue(うち70_74歳に係る負担額の合計);
    }

    private void 補正前_高額介護_予防_サービス費の合計() {
        Decimal 補正前_高額介護_予防_サービス費_8月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_8月分)) {
            補正前_高額介護_予防_サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_9月分)) {
            補正前_高額介護_予防_サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_10月分)) {
            補正前_高額介護_予防_サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_11月分)) {
            補正前_高額介護_予防_サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_12月分)) {
            補正前_高額介護_予防_サービス費_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_1月分)) {
            補正前_高額介護_予防_サービス費_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_2月分)) {
            補正前_高額介護_予防_サービス費_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_3月分)) {
            補正前_高額介護_予防_サービス費_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_4月分)) {
            補正前_高額介護_予防_サービス費_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_5月分)) {
            補正前_高額介護_予防_サービス費_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_6月分)) {
            補正前_高額介護_予防_サービス費_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額介護_予防_サービス費_7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuMae().getValue();
        if (isNull(補正前_高額介護_予防_サービス費_7月分)) {
            補正前_高額介護_予防_サービス費_7月分 = Decimal.ZERO;
        }
        Decimal 高額介護_予防_サービス費の合計 = 補正前_高額介護_予防_サービス費_8月分.add(補正前_高額介護_予防_サービス費_9月分)
                .add(補正前_高額介護_予防_サービス費_10月分).add(補正前_高額介護_予防_サービス費_11月分).add(補正前_高額介護_予防_サービス費_12月分)
                .add(補正前_高額介護_予防_サービス費_1月分).add(補正前_高額介護_予防_サービス費_2月分).add(補正前_高額介護_予防_サービス費_3月分)
                .add(補正前_高額介護_予防_サービス費_4月分).add(補正前_高額介護_予防_サービス費_5月分).add(補正前_高額介護_予防_サービス費_6月分)
                .add(補正前_高額介護_予防_サービス費_7月分);
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiMae().setValue(高額介護_予防_サービス費の合計);
    }

    private void 補正後_高額介護_予防_サービス費の合計() {
        Decimal 補正後_高額介護_予防_サービス費_8月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_8月分)) {
            補正後_高額介護_予防_サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_9月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_9月分)) {
            補正後_高額介護_予防_サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_10月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_10月分)) {
            補正後_高額介護_予防_サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_11月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_11月分)) {
            補正後_高額介護_予防_サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_12月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_12月分)) {
            補正後_高額介護_予防_サービス費_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_1月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_1月分)) {
            補正後_高額介護_予防_サービス費_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_2月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_2月分)) {
            補正後_高額介護_予防_サービス費_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_3月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_3月分)) {
            補正後_高額介護_予防_サービス費_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_4月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_4月分)) {
            補正後_高額介護_予防_サービス費_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_5月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_5月分)) {
            補正後_高額介護_予防_サービス費_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_6月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_6月分)) {
            補正後_高額介護_予防_サービス費_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費_7月分 = div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費_7月分)) {
            補正後_高額介護_予防_サービス費_7月分 = Decimal.ZERO;
        }
        Decimal 高額介護_予防_サービス費の合計 = 補正後_高額介護_予防_サービス費_8月分.add(補正後_高額介護_予防_サービス費_9月分)
                .add(補正後_高額介護_予防_サービス費_10月分).add(補正後_高額介護_予防_サービス費_11月分).add(補正後_高額介護_予防_サービス費_12月分)
                .add(補正後_高額介護_予防_サービス費_1月分).add(補正後_高額介護_予防_サービス費_2月分).add(補正後_高額介護_予防_サービス費_3月分)
                .add(補正後_高額介護_予防_サービス費_4月分).add(補正後_高額介護_予防_サービス費_5月分).add(補正後_高額介護_予防_サービス費_6月分)
                .add(補正後_高額介護_予防_サービス費_7月分);
        div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiGoukeiGo().setValue(高額介護_予防_サービス費の合計);
    }

    private void 補正前_実際の自己負担額の合計() {
        Decimal 補正前_実際の自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_8月分)) {
            補正前_実際の自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_9月分)) {
            補正前_実際の自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_10月分)) {
            補正前_実際の自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_11月分)) {
            補正前_実際の自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_12月分)) {
            補正前_実際の自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_1月分)) {
            補正前_実際の自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_2月分)) {
            補正前_実際の自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_3月分)) {
            補正前_実際の自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_4月分)) {
            補正前_実際の自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_5月分)) {
            補正前_実際の自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_6月分)) {
            補正前_実際の自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_7月分)) {
            補正前_実際の自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 実際の自己負担額の合計 = 補正前_実際の自己負担額_8月分.add(補正前_実際の自己負担額_9月分).add(補正前_実際の自己負担額_10月分)
                .add(補正前_実際の自己負担額_11月分).add(補正前_実際の自己負担額_12月分).add(補正前_実際の自己負担額_1月分)
                .add(補正前_実際の自己負担額_2月分).add(補正前_実際の自己負担額_3月分).add(補正前_実際の自己負担額_4月分)
                .add(補正前_実際の自己負担額_5月分).add(補正前_実際の自己負担額_6月分).add(補正前_実際の自己負担額_7月分);
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiMae().setValue(実際の自己負担額の合計);
    }

    private void 補正後_実際の自己負担額の合計() {
        Decimal 補正後_実際の自己負担額_8月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_8月分)) {
            補正後_実際の自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_9月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_9月分)) {
            補正後_実際の自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_10月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_10月分)) {
            補正後_実際の自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_11月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_11月分)) {
            補正後_実際の自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_12月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_12月分)) {
            補正後_実際の自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_1月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_1月分)) {
            補正後_実際の自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_2月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_2月分)) {
            補正後_実際の自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_3月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_3月分)) {
            補正後_実際の自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_4月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_4月分)) {
            補正後_実際の自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_5月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_5月分)) {
            補正後_実際の自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_6月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_6月分)) {
            補正後_実際の自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_7月分 = div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_7月分)) {
            補正後_実際の自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 実際の自己負担額の合計 = 補正後_実際の自己負担額_8月分.add(補正後_実際の自己負担額_9月分).add(補正後_実際の自己負担額_10月分)
                .add(補正後_実際の自己負担額_11月分).add(補正後_実際の自己負担額_12月分).add(補正後_実際の自己負担額_1月分)
                .add(補正後_実際の自己負担額_2月分).add(補正後_実際の自己負担額_3月分).add(補正後_実際の自己負担額_4月分)
                .add(補正後_実際の自己負担額_5月分).add(補正後_実際の自己負担額_6月分).add(補正後_実際の自己負担額_7月分);
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuGoukeiGo().setValue(実際の自己負担額の合計);
    }

    /**
     * [8月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangaku8GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [9月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangaku9GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [10月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangaku10GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [11月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangaku11GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [12月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangaku12GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年1月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku1GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年2月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku2GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年3月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku3GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年4月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年5月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年6月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年7月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txt20IgaiJikofutangakuYoku7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [8月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehi8GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku8GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [9月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehi9GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku9GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [10月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehi10GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku10GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [11月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehi11GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku11GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [12月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehi12GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangaku12GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年1月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku1GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku1GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年2月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku2GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku2GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年3月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku3GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku3GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年4月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku4GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年5月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku5GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年6月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku6GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌年7月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     */
    public void onChange_Txt20IgaiKougakuKaigoServicehiYoku7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getTbl20Igai()
                .getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額介護_予防_サービス費 = div.getTbl20Igai()
                .getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額介護_予防_サービス費)) {
            補正後_高額介護_予防_サービス費 = Decimal.ZERO;
        }
        div.getTbl20Igai().getTxt20IgaiJissaiJikofutangakuYoku7GatsuGo()
                .setValue(補正後_自己負担額.subtract(補正後_高額介護_予防_サービス費));
        補正後_高額介護_予防_サービス費の合計();
        補正後_実際の自己負担額の合計();
    }
}
