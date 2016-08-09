/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.JigyoKogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012.JikoFutangakuHosei2Div;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanJikoFutanGakuMeisaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業分自己負担額情報補正（単）_補正入力のHandlerのクラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
public class JikoFutangakuHosei2Handler {

    private final JikoFutangakuHosei2Div div;
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
    private static final RString 変更なし = new RString("0");
    private static final RString 変更あり = new RString("1");
    private static final RString 呼び出しフラグ = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 事業分自己負担額情報補正（単）_補正入力画面のdiv
     */
    public JikoFutangakuHosei2Handler(JikoFutangakuHosei2Div div) {
        this.div = div;
    }

    /**
     * 画面の初期化のメソッドです。
     *
     * @param 事業高額合算自己負担額補正保持Entity JigyoKogakuGassanJikofutangakuHosei
     */
    public void initilize_初回(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        HihokenshaNo 被保険者番号 = 事業高額合算自己負担額補正保持Entity.get被保険者番号();
        FlexibleYear 対象年度 = 事業高額合算自己負担額補正保持Entity.get対象年度();
        HokenshaNo 保険者番号 = 事業高額合算自己負担額補正保持Entity.get保険者番号();
        RString 支給申請書整理番号 = 事業高額合算自己負担額補正保持Entity.get支給申請書整理番号();
        int 履歴番号 = Integer.valueOf(事業高額合算自己負担額補正保持Entity.get履歴番号().toString());
        KogakuGassanJikoFutanGakuMeisaiManager manager = new KogakuGassanJikoFutanGakuMeisaiManager();
        initialize_事業高額合算自己負担額明細_8月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_9月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_10月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_11月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_12月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_1月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_2月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_3月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_4月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_5月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_6月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        initialize_事業高額合算自己負担額明細_7月分(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号, manager);
        補正前_自己負担額の合計();
        補正前_うち70_74歳に係る負担額の合計();
        補正前_高額総合事業サービス費の合計();
        補正前_実際の自己負担額の合計();
        補正後_自己負担額の合計();
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    private void initialize_事業高額合算自己負担額明細_7月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度,
            HokenshaNo 保険者番号, RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_7月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_107, 履歴番号);
        if (事業高額合算自己負担額明細_7月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuMae().setValue(事業高額合算自己負担額明細_7月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuMae().setValue(事業高額合算自己負担額明細_7月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuMae()
                    .setValue(事業高額合算自己負担額明細_7月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku7GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_7月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().setValue(事業高額合算自己負担額明細_7月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo()
                        .setValue(事業高額合算自己負担額明細_7月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_7月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo()
                        .setValue(事業高額合算自己負担額明細_7月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_6月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_6月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_106, 履歴番号);
        if (事業高額合算自己負担額明細_6月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuMae().setValue(事業高額合算自己負担額明細_6月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuMae().setValue(事業高額合算自己負担額明細_6月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuMae()
                    .setValue(事業高額合算自己負担額明細_6月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku6GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_6月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().setValue(事業高額合算自己負担額明細_6月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo()
                        .setValue(事業高額合算自己負担額明細_6月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_6月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo()
                        .setValue(事業高額合算自己負担額明細_6月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_5月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_5月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_105, 履歴番号);
        if (事業高額合算自己負担額明細_5月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuMae().setValue(事業高額合算自己負担額明細_5月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuMae().setValue(事業高額合算自己負担額明細_5月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuMae()
                    .setValue(事業高額合算自己負担額明細_5月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku5GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_5月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().setValue(事業高額合算自己負担額明細_5月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo()
                        .setValue(事業高額合算自己負担額明細_5月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_5月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo()
                        .setValue(事業高額合算自己負担額明細_5月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_4月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_4月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_104, 履歴番号);
        if (事業高額合算自己負担額明細_4月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuMae().setValue(事業高額合算自己負担額明細_4月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuMae().setValue(事業高額合算自己負担額明細_4月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuMae()
                    .setValue(事業高額合算自己負担額明細_4月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku4GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_4月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().setValue(事業高額合算自己負担額明細_4月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo()
                        .setValue(事業高額合算自己負担額明細_4月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_4月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo()
                        .setValue(事業高額合算自己負担額明細_4月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_3月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_3月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_103, 履歴番号);
        if (事業高額合算自己負担額明細_3月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuMae().setValue(事業高額合算自己負担額明細_3月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuMae().setValue(事業高額合算自己負担額明細_3月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuMae()
                    .setValue(事業高額合算自己負担額明細_3月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku3GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_3月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().setValue(事業高額合算自己負担額明細_3月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_3月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo()
                        .setValue(事業高額合算自己負担額明細_3月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_3月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo()
                        .setValue(事業高額合算自己負担額明細_3月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_2月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_2月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_102, 履歴番号);
        if (事業高額合算自己負担額明細_2月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuMae().setValue(事業高額合算自己負担額明細_2月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuMae().setValue(事業高額合算自己負担額明細_2月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuMae()
                    .setValue(事業高額合算自己負担額明細_2月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku2GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_2月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().setValue(事業高額合算自己負担額明細_2月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_2月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo()
                        .setValue(事業高額合算自己負担額明細_2月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_2月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo()
                        .setValue(事業高額合算自己負担額明細_2月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_1月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_1月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_101, 履歴番号);
        if (事業高額合算自己負担額明細_1月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuMae().setValue(事業高額合算自己負担額明細_1月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuMae().setValue(事業高額合算自己負担額明細_1月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuMae()
                    .setValue(事業高額合算自己負担額明細_1月分.get70未満高額支給額());
            Decimal 補正前_自己負担額１月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuMae().getValue();
            if (isNull(補正前_自己負担額１月分)) {
                補正前_自己負担額１月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費１月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費１月分)) {
                補正前_高額総合事業サービス費１月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangakuYoku1GatsuMae().setValue(補正前_自己負担額１月分.subtract(補正前_高額総合事業サービス費１月分));
            if (事業高額合算自己負担額明細_1月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().setValue(事業高額合算自己負担額明細_1月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_1月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo()
                        .setValue(事業高額合算自己負担額明細_1月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_1月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo()
                        .setValue(事業高額合算自己負担額明細_1月分.get補正済_70未満高額支給額());
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_12月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_12月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_012, 履歴番号);
        if (事業高額合算自己負担額明細_12月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuMae().setValue(事業高額合算自己負担額明細_12月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuMae()
                    .setValue(事業高額合算自己負担額明細_12月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuMae()
                    .setValue(事業高額合算自己負担額明細_12月分.get70未満高額支給額());
            Decimal 補正前_自己負担額12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuMae().getValue();
            if (isNull(補正前_自己負担額12月分)) {
                補正前_自己負担額12月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費12月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費12月分)) {
                補正前_高額総合事業サービス費12月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangaku12GatsuMae().setValue(補正前_自己負担額12月分.subtract(補正前_高額総合事業サービス費12月分));
            if (事業高額合算自己負担額明細_12月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().setValue(事業高額合算自己負担額明細_12月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_12月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo()
                        .setValue(事業高額合算自己負担額明細_12月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_12月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo()
                        .setValue(事業高額合算自己負担額明細_12月分.get補正済_70未満高額支給額());
            }
            if (事業高額合算自己負担額明細_12月分.get補正済_自己負担額() != null && 事業高額合算自己負担額明細_12月分.get補正済_70未満高額支給額() != null) {
                div.getTxtJissaiJikofutangaku12GatsuGo().setValue(事業高額合算自己負担額明細_12月分.get補正済_自己負担額()
                        .subtract(事業高額合算自己負担額明細_12月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_11月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_11月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_011, 履歴番号);
        if (事業高額合算自己負担額明細_11月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuMae().setValue(事業高額合算自己負担額明細_11月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuMae()
                    .setValue(事業高額合算自己負担額明細_11月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuMae()
                    .setValue(事業高額合算自己負担額明細_11月分.get70未満高額支給額());
            Decimal 補正前_自己負担額11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuMae().getValue();
            if (isNull(補正前_自己負担額11月分)) {
                補正前_自己負担額11月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費11月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費11月分)) {
                補正前_高額総合事業サービス費11月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangaku11GatsuMae().setValue(補正前_自己負担額11月分.subtract(補正前_高額総合事業サービス費11月分));
            if (事業高額合算自己負担額明細_11月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().setValue(事業高額合算自己負担額明細_11月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_11月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo()
                        .setValue(事業高額合算自己負担額明細_11月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_11月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo()
                        .setValue(事業高額合算自己負担額明細_11月分.get補正済_70未満高額支給額());
            }
            if (事業高額合算自己負担額明細_11月分.get補正済_自己負担額() != null && 事業高額合算自己負担額明細_11月分.get補正済_70未満高額支給額() != null) {
                div.getTxtJissaiJikofutangaku11GatsuGo().setValue(事業高額合算自己負担額明細_11月分.get補正済_自己負担額()
                        .subtract(事業高額合算自己負担額明細_11月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_10月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_10月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_010, 履歴番号);
        if (事業高額合算自己負担額明細_10月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuMae().setValue(事業高額合算自己負担額明細_10月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuMae()
                    .setValue(事業高額合算自己負担額明細_10月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuMae()
                    .setValue(事業高額合算自己負担額明細_10月分.get70未満高額支給額());
            Decimal 補正前_自己負担額10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuMae().getValue();
            if (isNull(補正前_自己負担額10月分)) {
                補正前_自己負担額10月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費10月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費10月分)) {
                補正前_高額総合事業サービス費10月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangaku10GatsuMae().setValue(補正前_自己負担額10月分.subtract(補正前_高額総合事業サービス費10月分));
            if (事業高額合算自己負担額明細_10月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().setValue(事業高額合算自己負担額明細_10月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_10月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo()
                        .setValue(事業高額合算自己負担額明細_10月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_10月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo()
                        .setValue(事業高額合算自己負担額明細_10月分.get補正済_70未満高額支給額());
            }
            if (事業高額合算自己負担額明細_10月分.get補正済_自己負担額() != null && 事業高額合算自己負担額明細_10月分.get補正済_70未満高額支給額() != null) {
                div.getTxtJissaiJikofutangaku10GatsuGo().setValue(事業高額合算自己負担額明細_10月分.get補正済_自己負担額()
                        .subtract(事業高額合算自己負担額明細_10月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_9月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_9月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_009, 履歴番号);
        if (事業高額合算自己負担額明細_9月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuMae().setValue(事業高額合算自己負担額明細_9月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuMae()
                    .setValue(事業高額合算自己負担額明細_9月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuMae()
                    .setValue(事業高額合算自己負担額明細_9月分.get70未満高額支給額());
            Decimal 補正前_自己負担額9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuMae().getValue();
            if (isNull(補正前_自己負担額9月分)) {
                補正前_自己負担額9月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費9月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費9月分)) {
                補正前_高額総合事業サービス費9月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangaku9GatsuMae().setValue(補正前_自己負担額9月分.subtract(補正前_高額総合事業サービス費9月分));
            if (事業高額合算自己負担額明細_9月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().setValue(事業高額合算自己負担額明細_9月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_9月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo()
                        .setValue(事業高額合算自己負担額明細_9月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_9月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo()
                        .setValue(事業高額合算自己負担額明細_9月分.get補正済_70未満高額支給額());
            }
            if (事業高額合算自己負担額明細_9月分.get補正済_自己負担額() != null && 事業高額合算自己負担額明細_9月分.get補正済_70未満高額支給額() != null) {
                div.getTxtJissaiJikofutangaku9GatsuGo().setValue(事業高額合算自己負担額明細_9月分.get補正済_自己負担額()
                        .subtract(事業高額合算自己負担額明細_9月分.get補正済_70未満高額支給額()));
            }
        }
    }

    private void initialize_事業高額合算自己負担額明細_8月分(HihokenshaNo 被保険者番号, FlexibleYear 対象年度, HokenshaNo 保険者番号,
            RString 支給申請書整理番号, int 履歴番号, KogakuGassanJikoFutanGakuMeisaiManager manager) {
        KogakuGassanJikoFutanGakuMeisai 事業高額合算自己負担額明細_8月分 = new KogakuGassanJikoFutanGakuMeisaiManager()
                .get高額合算自己負担額明細(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 対象月_008, 履歴番号);
        if (事業高額合算自己負担額明細_8月分 != null) {
            div.getJikoFutangakuHosei2a().getTxtJikofutangaku8GatsuMae().setValue(事業高額合算自己負担額明細_8月分.get自己負担額());
            div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuMae()
                    .setValue(事業高額合算自己負担額明細_8月分.get70_74自己負担額_内数());
            div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuMae()
                    .setValue(事業高額合算自己負担額明細_8月分.get70未満高額支給額());
            Decimal 補正前_自己負担額８月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku8GatsuMae().getValue();
            if (isNull(補正前_自己負担額８月分)) {
                補正前_自己負担額８月分 = Decimal.ZERO;
            }
            Decimal 補正前_高額総合事業サービス費８月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuMae().getValue();
            if (isNull(補正前_高額総合事業サービス費８月分)) {
                補正前_高額総合事業サービス費８月分 = Decimal.ZERO;
            }
            div.getTxtJissaiJikofutangaku8GatsuMae().setValue(補正前_自己負担額８月分.subtract(補正前_高額総合事業サービス費８月分));
            if (事業高額合算自己負担額明細_8月分.get補正済_自己負担額() != null) {
                div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().setValue(事業高額合算自己負担額明細_8月分.get補正済_自己負担額());
            }
            if (事業高額合算自己負担額明細_8月分.get補正済_70_74自己負担額_内数() != null) {
                div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo()
                        .setValue(事業高額合算自己負担額明細_8月分.get補正済_70_74自己負担額_内数());
            }
            if (事業高額合算自己負担額明細_8月分.get補正済_70未満高額支給額() != null) {
                div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo()
                        .setValue(事業高額合算自己負担額明細_8月分.get補正済_70未満高額支給額());
            }
            if (事業高額合算自己負担額明細_8月分.get補正済_自己負担額() != null && 事業高額合算自己負担額明細_8月分.get補正済_70未満高額支給額() != null) {
                div.getTxtJissaiJikofutangaku8GatsuGo().setValue(事業高額合算自己負担額明細_8月分.get補正済_自己負担額()
                        .subtract(事業高額合算自己負担額明細_8月分.get補正済_70未満高額支給額()));
            }
        }
    }

    /**
     * 変更前補正後金額の設定のメソッドです。
     *
     * @param 事業高額合算自己負担額補正保持Entity JigyoKogakuGassanJikofutangakuHosei
     */
    public void 変更前補正後金額の設定(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_自己負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku7GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_うち70_74歳に係る負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku7GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_8月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_9月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_10月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_11月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_12月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_1月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_2月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_3月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_4月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_5月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_6月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_高額総合事業サービス費_7月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku7GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_補正後_実際の自己負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku7GatsuMae().getValue());
    }

    /**
     * 補正前の金額をコピーするのメソッドです。
     */
    public void 補正後の金額コピー() {
        Decimal 補正前_自己負担額_８月分 = div.getTxtJikofutangaku8GatsuMae().getValue();
        div.getCelJikofutangaku8GatsuGo().setValue(補正前_自己負担額_８月分);
        Decimal 補正前_うち70_74歳に係る負担額_８月分 = div.getTxt70Kara74Futangaku8GatsuMae().getValue();
        div.getTxt70Kara74Futangaku8GatsuGo().setValue(補正前_うち70_74歳に係る負担額_８月分);
        Decimal 補正前_高額総合事業サービス費_８月分 = div.getTxtKougakuSogoJigyoServicehi8GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehi8GatsuGo().setValue(補正前_高額総合事業サービス費_８月分);
        Decimal 補正前_実際の自己負担額_８月分 = div.getTxtJissaiJikofutangaku8GatsuMae().getValue();
        div.getTxtJissaiJikofutangaku8GatsuGo().setValue(補正前_実際の自己負担額_８月分);

        Decimal 補正前_自己負担額_９月分 = div.getTxtJikofutangaku9GatsuMae().getValue();
        div.getTxtJikofutangaku9GatsuGo().setValue(補正前_自己負担額_９月分);
        Decimal 補正前_うち70_74歳に係る負担額_９月分 = div.getTxt70Kara74Futangaku9GatsuMae().getValue();
        div.getTxt70Kara74Futangaku9GatsuGo().setValue(補正前_うち70_74歳に係る負担額_９月分);
        Decimal 補正前_高額総合事業サービス費_９月分 = div.getTxtKougakuSogoJigyoServicehi9GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehi9GatsuGo().setValue(補正前_高額総合事業サービス費_９月分);
        Decimal 補正前_実際の自己負担額_９月分 = div.getTxtJissaiJikofutangaku9GatsuMae().getValue();
        div.getTxtJissaiJikofutangaku9GatsuGo().setValue(補正前_実際の自己負担額_９月分);

        Decimal 補正前_自己負担額_１０月分 = div.getTxtJikofutangaku10GatsuMae().getValue();
        div.getTxtJikofutangaku10GatsuGo().setValue(補正前_自己負担額_１０月分);
        Decimal 補正前_うち70_74歳に係る負担額_１０月分 = div.getTxt70Kara74Futangaku10GatsuMae().getValue();
        div.getTxt70Kara74Futangaku10GatsuGo().setValue(補正前_うち70_74歳に係る負担額_１０月分);
        Decimal 補正前_高額総合事業サービス費_１０月分 = div.getTxtKougakuSogoJigyoServicehi10GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehi10GatsuGo().setValue(補正前_高額総合事業サービス費_１０月分);
        Decimal 補正前_実際の自己負担額_１０月分 = div.getTxtJissaiJikofutangaku10GatsuMae().getValue();
        div.getTxtJissaiJikofutangaku10GatsuGo().setValue(補正前_実際の自己負担額_１０月分);

        Decimal 補正前_自己負担額_１１月分 = div.getTxtJikofutangaku11GatsuMae().getValue();
        div.getTxtJikofutangaku11GatsuGo().setValue(補正前_自己負担額_１１月分);
        Decimal 補正前_うち70_74歳に係る負担額_１１月分 = div.getTxt70Kara74Futangaku11GatsuMae().getValue();
        div.getTxt70Kara74Futangaku11GatsuGo().setValue(補正前_うち70_74歳に係る負担額_１１月分);
        Decimal 補正前_高額総合事業サービス費_１１月分 = div.getTxtKougakuSogoJigyoServicehi11GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehi11GatsuGo().setValue(補正前_高額総合事業サービス費_１１月分);
        Decimal 補正前_実際の自己負担額_１１月分 = div.getTxtJissaiJikofutangaku11GatsuMae().getValue();
        div.getTxtJissaiJikofutangaku11GatsuGo().setValue(補正前_実際の自己負担額_１１月分);

        Decimal 補正前_自己負担額_１２月分 = div.getTxtJikofutangaku12GatsuMae().getValue();
        div.getTxtJikofutangaku12GatsuGo().setValue(補正前_自己負担額_１２月分);
        Decimal 補正前_うち70_74歳に係る負担額_１２月分 = div.getTxt70Kara74Futangaku12GatsuMae().getValue();
        div.getTxt70Kara74Futangaku12GatsuGo().setValue(補正前_うち70_74歳に係る負担額_１２月分);
        Decimal 補正前_高額総合事業サービス費_１２月分 = div.getTxtKougakuSogoJigyoServicehi12GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehi12GatsuGo().setValue(補正前_高額総合事業サービス費_１２月分);
        Decimal 補正前_実際の自己負担額_１２月分 = div.getTxtJissaiJikofutangaku12GatsuMae().getValue();
        div.getTxtJissaiJikofutangaku12GatsuGo().setValue(補正前_実際の自己負担額_１２月分);

        Decimal 補正前_自己負担額_１月分 = div.getTxtJikofutangakuYoku1GatsuMae().getValue();
        div.getTxtJikofutangakuYoku1GatsuGo().setValue(補正前_自己負担額_１月分);
        Decimal 補正前_うち70_74歳に係る負担額_１月分 = div.getTxt70Kara74FutangakuYoku1GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku1GatsuGo().setValue(補正前_うち70_74歳に係る負担額_１月分);
        Decimal 補正前_高額総合事業サービス費_１月分 = div.getTxtKougakuSogoJigyoServicehiYoku1GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().setValue(補正前_高額総合事業サービス費_１月分);
        Decimal 補正前_実際の自己負担額_１月分 = div.getTxtJissaiJikofutangakuYoku1GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku1GatsuGo().setValue(補正前_実際の自己負担額_１月分);

        Decimal 補正前_自己負担額_２月分 = div.getTxtJikofutangakuYoku2GatsuMae().getValue();
        div.getTxtJikofutangakuYoku2GatsuGo().setValue(補正前_自己負担額_２月分);
        Decimal 補正前_うち70_74歳に係る負担額_２月分 = div.getTxt70Kara74FutangakuYoku2GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku2GatsuGo().setValue(補正前_うち70_74歳に係る負担額_２月分);
        Decimal 補正前_高額総合事業サービス費_２月分 = div.getTxtKougakuSogoJigyoServicehiYoku2GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().setValue(補正前_高額総合事業サービス費_２月分);
        Decimal 補正前_実際の自己負担額_２月分 = div.getTxtJissaiJikofutangakuYoku2GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku2GatsuGo().setValue(補正前_実際の自己負担額_２月分);

        Decimal 補正前_自己負担額_３月分 = div.getTxtJikofutangakuYoku3GatsuMae().getValue();
        div.getTxtJikofutangakuYoku3GatsuGo().setValue(補正前_自己負担額_３月分);
        Decimal 補正前_うち70_74歳に係る負担額_３月分 = div.getTxt70Kara74FutangakuYoku3GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku3GatsuGo().setValue(補正前_うち70_74歳に係る負担額_３月分);
        Decimal 補正前_高額総合事業サービス費_３月分 = div.getTxtKougakuSogoJigyoServicehiYoku3GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().setValue(補正前_高額総合事業サービス費_３月分);
        Decimal 補正前_実際の自己負担額_３月分 = div.getTxtJissaiJikofutangakuYoku3GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku3GatsuGo().setValue(補正前_実際の自己負担額_３月分);

        Decimal 補正前_自己負担額_４月分 = div.getTxtJikofutangakuYoku4GatsuMae().getValue();
        div.getTxtJikofutangakuYoku4GatsuGo().setValue(補正前_自己負担額_４月分);
        Decimal 補正前_うち70_74歳に係る負担額_４月分 = div.getTxt70Kara74FutangakuYoku4GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku4GatsuGo().setValue(補正前_うち70_74歳に係る負担額_４月分);
        Decimal 補正前_高額総合事業サービス費_４月分 = div.getTxtKougakuSogoJigyoServicehiYoku4GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().setValue(補正前_高額総合事業サービス費_４月分);
        Decimal 補正前_実際の自己負担額_４月分 = div.getTxtJissaiJikofutangakuYoku4GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku4GatsuGo().setValue(補正前_実際の自己負担額_４月分);

        Decimal 補正前_自己負担額_５月分 = div.getTxtJikofutangakuYoku5GatsuMae().getValue();
        div.getTxtJikofutangakuYoku5GatsuGo().setValue(補正前_自己負担額_５月分);
        Decimal 補正前_うち70_74歳に係る負担額_５月分 = div.getTxt70Kara74FutangakuYoku5GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku5GatsuGo().setValue(補正前_うち70_74歳に係る負担額_５月分);
        Decimal 補正前_高額総合事業サービス費_５月分 = div.getTxtKougakuSogoJigyoServicehiYoku5GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().setValue(補正前_高額総合事業サービス費_５月分);
        Decimal 補正前_実際の自己負担額_５月分 = div.getTxtJissaiJikofutangakuYoku5GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku5GatsuGo().setValue(補正前_実際の自己負担額_５月分);

        Decimal 補正前_自己負担額_６月分 = div.getTxtJikofutangakuYoku6GatsuMae().getValue();
        div.getTxtJikofutangakuYoku6GatsuGo().setValue(補正前_自己負担額_６月分);
        Decimal 補正前_うち70_74歳に係る負担額_６月分 = div.getTxt70Kara74FutangakuYoku6GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku6GatsuGo().setValue(補正前_うち70_74歳に係る負担額_６月分);
        Decimal 補正前_高額総合事業サービス費_６月分 = div.getTxtKougakuSogoJigyoServicehiYoku6GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().setValue(補正前_高額総合事業サービス費_６月分);
        Decimal 補正前_実際の自己負担額_６月分 = div.getTxtJissaiJikofutangakuYoku6GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku6GatsuGo().setValue(補正前_実際の自己負担額_６月分);

        Decimal 補正前_自己負担額_７月分 = div.getTxtJikofutangakuYoku7GatsuMae().getValue();
        div.getTxtJikofutangakuYoku7GatsuGo().setValue(補正前_自己負担額_７月分);
        Decimal 補正前_うち70_74歳に係る負担額_７月分 = div.getTxt70Kara74FutangakuYoku7GatsuMae().getValue();
        div.getTxt70Kara74FutangakuYoku7GatsuGo().setValue(補正前_うち70_74歳に係る負担額_７月分);
        Decimal 補正前_高額総合事業サービス費_７月分 = div.getTxtKougakuSogoJigyoServicehiYoku7GatsuMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().setValue(補正前_高額総合事業サービス費_７月分);
        Decimal 補正前_実際の自己負担額_７月分 = div.getTxtJissaiJikofutangakuYoku7GatsuMae().getValue();
        div.getTxtJissaiJikofutangakuYoku7GatsuGo().setValue(補正前_実際の自己負担額_７月分);

        Decimal 合計_補正前_自己負担額 = div.getTxtJikofutangakuGoukeiMae().getValue();
        div.getTxtJikofutangakuGoukeiGo().setValue(合計_補正前_自己負担額);
        Decimal 合計_補正前_うち70_74歳に係る負担額 = div.getTxt70Kara74FutangakuGoukeiMae().getValue();
        div.getTxt70Kara74FutangakuGoukeiGo().setValue(合計_補正前_うち70_74歳に係る負担額);
        Decimal 合計_補正前_高額総合事業サービス費 = div.getTxtKougakuSogoJigyoServicehiGoukeiMae().getValue();
        div.getTxtKougakuSogoJigyoServicehiGoukeiGo().setValue(合計_補正前_高額総合事業サービス費);
        Decimal 合計_補正前_実際の自己負担額 = div.getTxtJissaiJikofutangakuGoukeiMae().getValue();
        div.getTxtJissaiJikofutangakuGoukeiGo().setValue(合計_補正前_実際の自己負担額);
    }

    /**
     * [８月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_celJikofutangaku8GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku8GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [８月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi8GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku8GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [９月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangaku9GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku9GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [９月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi9GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku9GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [１０月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangaku10GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku10GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [１０月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi10GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku10GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [１１月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangaku11GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku11GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [１１月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi11GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku11GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [１２月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangaku12GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku12GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [１２月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi12GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangaku12GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌１月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku1GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku1GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌１月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehiYoku1GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku1GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌２月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku2GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku2GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌２月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehiYoku2GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku2GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌３月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku3GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku3GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌３月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi3GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku3GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌４月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku4GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌４月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi4GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku4GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌５月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku5GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌５月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi5GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku5GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌６月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku6GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌６月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi6GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku6GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌７月分　補正後　自己負担額]changeのメソッドです。
     */
    public void onChange_txtJikofutangakuYoku7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku7GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_自己負担額の合計();
        補正後_実際の自己負担額の合計();
    }

    /**
     * [翌７月分　補正後　高額総合事業サービス費]changeのメソッドです。
     */
    public void onChange_txtKougakuSogoJigyoServicehi7GatsuGo() {
        Decimal 補正後_自己負担額 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額)) {
            補正後_自己負担額 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費)) {
            補正後_高額総合事業サービス費 = Decimal.ZERO;
        }
        div.getTxtJissaiJikofutangakuYoku7GatsuGo().setValue(補正後_自己負担額.subtract(補正後_高額総合事業サービス費));
        補正後_高額総合事業サービス費の合計();
        補正後_実際の自己負担額の合計();
    }

    private void 補正前_うち70_74歳に係る負担額の合計() {
        Decimal 補正前_うち70_74歳に係る負担額_8月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_8月分)) {
            補正前_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_9月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_9月分)) {
            補正前_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_10月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_10月分)) {
            補正前_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_11月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_11月分)) {
            補正前_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_12月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_12月分)) {
            補正前_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_1月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_1月分)) {
            補正前_うち70_74歳に係る負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_2月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_2月分)) {
            補正前_うち70_74歳に係る負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_3月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_3月分)) {
            補正前_うち70_74歳に係る負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_4月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_4月分)) {
            補正前_うち70_74歳に係る負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_5月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_5月分)) {
            補正前_うち70_74歳に係る負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_6月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_6月分)) {
            補正前_うち70_74歳に係る負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_うち70_74歳に係る負担額_7月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_うち70_74歳に係る負担額_7月分)) {
            補正前_うち70_74歳に係る負担額_7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額の合計 = 補正前_うち70_74歳に係る負担額_8月分.add(補正前_うち70_74歳に係る負担額_9月分)
                .add(補正前_うち70_74歳に係る負担額_10月分).add(補正前_うち70_74歳に係る負担額_11月分).add(補正前_うち70_74歳に係る負担額_12月分)
                .add(補正前_うち70_74歳に係る負担額_1月分).add(補正前_うち70_74歳に係る負担額_2月分).add(補正前_うち70_74歳に係る負担額_3月分)
                .add(補正前_うち70_74歳に係る負担額_4月分).add(補正前_うち70_74歳に係る負担額_5月分).add(補正前_うち70_74歳に係る負担額_6月分)
                .add(補正前_うち70_74歳に係る負担額_7月分);
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuGoukeiMae().setValue(うち70_74歳に係る負担額の合計);

    }

    private boolean isNull(Decimal 金額) {
        return 金額 == null;
    }

    private void 補正後_自己負担額の合計() {
        Decimal 補正後_自己負担額_8月分 = div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_自己負担額_8月分)) {
            補正後_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_自己負担額_9月分)) {
            補正後_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_自己負担額_10月分)) {
            補正後_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_自己負担額_11月分)) {
            補正後_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_自己負担額_12月分)) {
            補正後_自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_自己負担額_1月分)) {
            補正後_自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_自己負担額_2月分)) {
            補正後_自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_自己負担額_3月分)) {
            補正後_自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_自己負担額_4月分)) {
            補正後_自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_自己負担額_5月分)) {
            補正後_自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_自己負担額_6月分)) {
            補正後_自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_自己負担額_7月分)) {
            補正後_自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 自己負担額の合計 = 補正後_自己負担額_8月分.add(補正後_自己負担額_9月分).add(補正後_自己負担額_10月分).add(補正後_自己負担額_11月分)
                .add(補正後_自己負担額_12月分).add(補正後_自己負担額_1月分).add(補正後_自己負担額_2月分).add(補正後_自己負担額_3月分)
                .add(補正後_自己負担額_4月分).add(補正後_自己負担額_5月分).add(補正後_自己負担額_6月分).add(補正後_自己負担額_7月分);
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuGoukeiGo().setValue(自己負担額の合計);
    }

    private void 補正前_自己負担額の合計() {
        Decimal 補正前_自己負担額_8月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku8GatsuMae().getValue();
        if (isNull(補正前_自己負担額_8月分)) {
            補正前_自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuMae().getValue();
        if (isNull(補正前_自己負担額_9月分)) {
            補正前_自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuMae().getValue();
        if (isNull(補正前_自己負担額_10月分)) {
            補正前_自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuMae().getValue();
        if (isNull(補正前_自己負担額_11月分)) {
            補正前_自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuMae().getValue();
        if (isNull(補正前_自己負担額_12月分)) {
            補正前_自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_自己負担額_1月分)) {
            補正前_自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_自己負担額_2月分)) {
            補正前_自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_自己負担額_3月分)) {
            補正前_自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_自己負担額_4月分)) {
            補正前_自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_自己負担額_5月分)) {
            補正前_自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_自己負担額_6月分)) {
            補正前_自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_自己負担額_7月分)) {
            補正前_自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 自己負担額の合計 = 補正前_自己負担額_8月分.add(補正前_自己負担額_9月分).add(補正前_自己負担額_10月分).add(補正前_自己負担額_11月分)
                .add(補正前_自己負担額_12月分).add(補正前_自己負担額_1月分).add(補正前_自己負担額_2月分).add(補正前_自己負担額_3月分)
                .add(補正前_自己負担額_4月分).add(補正前_自己負担額_5月分).add(補正前_自己負担額_6月分).add(補正前_自己負担額_7月分);
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuGoukeiMae().setValue(自己負担額の合計);
    }

    private void 補正後_高額総合事業サービス費の合計() {
        Decimal 補正後_高額総合事業サービス費_8月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_8月分)) {
            補正後_高額総合事業サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_9月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_9月分)) {
            補正後_高額総合事業サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_10月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_10月分)) {
            補正後_高額総合事業サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_11月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_11月分)) {
            補正後_高額総合事業サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_12月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_12月分)) {
            補正後_高額総合事業サービス費_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_1月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_1月分)) {
            補正後_高額総合事業サービス費_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_2月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_2月分)) {
            補正後_高額総合事業サービス費_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_3月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_3月分)) {
            補正後_高額総合事業サービス費_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_4月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_4月分)) {
            補正後_高額総合事業サービス費_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_5月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_5月分)) {
            補正後_高額総合事業サービス費_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_6月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_6月分)) {
            補正後_高額総合事業サービス費_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_高額総合事業サービス費_7月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue();
        if (isNull(補正後_高額総合事業サービス費_7月分)) {
            補正後_高額総合事業サービス費_7月分 = Decimal.ZERO;
        }
        Decimal 高額総合事業サービス費の合計 = 補正後_高額総合事業サービス費_8月分.add(補正後_高額総合事業サービス費_9月分)
                .add(補正後_高額総合事業サービス費_10月分).add(補正後_高額総合事業サービス費_11月分).add(補正後_高額総合事業サービス費_12月分)
                .add(補正後_高額総合事業サービス費_1月分).add(補正後_高額総合事業サービス費_2月分).add(補正後_高額総合事業サービス費_3月分)
                .add(補正後_高額総合事業サービス費_4月分).add(補正後_高額総合事業サービス費_5月分).add(補正後_高額総合事業サービス費_6月分)
                .add(補正後_高額総合事業サービス費_7月分);
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiGoukeiGo().setValue(高額総合事業サービス費の合計);
    }

    private void 補正前_高額総合事業サービス費の合計() {
        Decimal 補正前_高額総合事業サービス費_8月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_8月分)) {
            補正前_高額総合事業サービス費_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_9月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_9月分)) {
            補正前_高額総合事業サービス費_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_10月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_10月分)) {
            補正前_高額総合事業サービス費_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_11月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_11月分)) {
            補正前_高額総合事業サービス費_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_12月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_12月分)) {
            補正前_高額総合事業サービス費_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_1月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_1月分)) {
            補正前_高額総合事業サービス費_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_2月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_2月分)) {
            補正前_高額総合事業サービス費_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_3月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_3月分)) {
            補正前_高額総合事業サービス費_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_4月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_4月分)) {
            補正前_高額総合事業サービス費_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_5月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_5月分)) {
            補正前_高額総合事業サービス費_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_6月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_6月分)) {
            補正前_高額総合事業サービス費_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_高額総合事業サービス費_7月分 = div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuMae().getValue();
        if (isNull(補正前_高額総合事業サービス費_7月分)) {
            補正前_高額総合事業サービス費_7月分 = Decimal.ZERO;
        }
        Decimal 高額総合事業サービス費の合計 = 補正前_高額総合事業サービス費_8月分.add(補正前_高額総合事業サービス費_9月分)
                .add(補正前_高額総合事業サービス費_10月分).add(補正前_高額総合事業サービス費_11月分).add(補正前_高額総合事業サービス費_12月分)
                .add(補正前_高額総合事業サービス費_1月分).add(補正前_高額総合事業サービス費_2月分).add(補正前_高額総合事業サービス費_3月分)
                .add(補正前_高額総合事業サービス費_4月分).add(補正前_高額総合事業サービス費_5月分).add(補正前_高額総合事業サービス費_6月分)
                .add(補正前_高額総合事業サービス費_7月分);
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiGoukeiMae().setValue(高額総合事業サービス費の合計);
    }

    private void 補正後_実際の自己負担額の合計() {
        Decimal 補正後_実際の自己負担額_8月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku8GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_8月分)) {
            補正後_実際の自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku9GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_9月分)) {
            補正後_実際の自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku10GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_10月分)) {
            補正後_実際の自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku11GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_11月分)) {
            補正後_実際の自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku12GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_12月分)) {
            補正後_実際の自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_1月分)) {
            補正後_実際の自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_2月分)) {
            補正後_実際の自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_3月分)) {
            補正後_実際の自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_4月分)) {
            補正後_実際の自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_5月分)) {
            補正後_実際の自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_6月分)) {
            補正後_実際の自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_実際の自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_実際の自己負担額_7月分)) {
            補正後_実際の自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 実際の自己負担額の合計 = 補正後_実際の自己負担額_8月分.add(補正後_実際の自己負担額_9月分).add(補正後_実際の自己負担額_10月分)
                .add(補正後_実際の自己負担額_11月分).add(補正後_実際の自己負担額_12月分).add(補正後_実際の自己負担額_1月分)
                .add(補正後_実際の自己負担額_2月分).add(補正後_実際の自己負担額_3月分).add(補正後_実際の自己負担額_4月分)
                .add(補正後_実際の自己負担額_5月分).add(補正後_実際の自己負担額_6月分).add(補正後_実際の自己負担額_7月分);
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuGoukeiGo().setValue(実際の自己負担額の合計);
    }

    private void 補正前_実際の自己負担額の合計() {
        Decimal 補正前_実際の自己負担額_8月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku8GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_8月分)) {
            補正前_実際の自己負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_9月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku9GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_9月分)) {
            補正前_実際の自己負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_10月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku10GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_10月分)) {
            補正前_実際の自己負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_11月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku11GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_11月分)) {
            補正前_実際の自己負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_12月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku12GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_12月分)) {
            補正前_実際の自己負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_1月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku1GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_1月分)) {
            補正前_実際の自己負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_2月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku2GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_2月分)) {
            補正前_実際の自己負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_3月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku3GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_3月分)) {
            補正前_実際の自己負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_4月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku4GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_4月分)) {
            補正前_実際の自己負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_5月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku5GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_5月分)) {
            補正前_実際の自己負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_6月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku6GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_6月分)) {
            補正前_実際の自己負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正前_実際の自己負担額_7月分 = div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku7GatsuMae().getValue();
        if (isNull(補正前_実際の自己負担額_7月分)) {
            補正前_実際の自己負担額_7月分 = Decimal.ZERO;
        }
        Decimal 実際の自己負担額の合計 = 補正前_実際の自己負担額_8月分.add(補正前_実際の自己負担額_9月分).add(補正前_実際の自己負担額_10月分)
                .add(補正前_実際の自己負担額_11月分).add(補正前_実際の自己負担額_12月分).add(補正前_実際の自己負担額_1月分)
                .add(補正前_実際の自己負担額_2月分).add(補正前_実際の自己負担額_3月分).add(補正前_実際の自己負担額_4月分)
                .add(補正前_実際の自己負担額_5月分).add(補正前_実際の自己負担額_6月分).add(補正前_実際の自己負担額_7月分);
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuGoukeiMae().setValue(実際の自己負担額の合計);
    }

    /**
     * 事業高額合算自己負担額保持Entityの設定のメソッドです。
     *
     * @param 事業高額合算自己負担額補正保持Entity JigyoKogakuGassanJikofutangakuHosei
     */
    public void 事業高額合算自己負担額保持Entityの設定(
            JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_自己負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku7GatsuMae().getValue());
        set補正前_うち70_74歳に係る負担額(事業高額合算自己負担額補正保持Entity);
        set補正前_高額総合事業サービス費(事業高額合算自己負担額補正保持Entity);
        set補正前_実際の自己負担額(事業高額合算自己負担額補正保持Entity);
        set変更後_補正後_自己負担額(事業高額合算自己負担額補正保持Entity);
        set変更後_補正後_うち70_74歳に係る負担額(事業高額合算自己負担額補正保持Entity);
        set変更後_補正後_高額総合事業サービス費(事業高額合算自己負担額補正保持Entity);
        set変更後_補正後_実際の自己負担額(事業高額合算自己負担額補正保持Entity);
        事業高額合算自己負担額補正保持Entity.set変更前_合計_自己負担額(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuGoukeiMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_合計_うち70_74歳に係る負担額(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuGoukeiMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_合計_高額総合事業サービス費(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiGoukeiMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更前_合計_実際の自己負担額(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuGoukeiMae().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_合計_補正後_自己負担額(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuGoukeiGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_合計_補正後_うち70_74歳に係る負担額(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuGoukeiGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_合計_補正後_高額総合事業サービス費(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiGoukeiGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_合計_補正後_実際の自己負担額(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuGoukeiGo().getValue());
        if (is変更(事業高額合算自己負担額補正保持Entity)) {
            事業高額合算自己負担額補正保持Entity.set変更フラグ(変更あり);
        } else {
            事業高額合算自己負担額補正保持Entity.set変更フラグ(変更なし);
        }
        事業高額合算自己負担額補正保持Entity.set呼び出しフラグ(呼び出しフラグ);
    }

    private void set変更後_補正後_実際の自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku8GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku9GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku10GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku11GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku12GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku1GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku2GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku3GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku4GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku5GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku6GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_実際の自己負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_高額総合事業サービス費(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_8月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi8GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_9月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi9GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_10月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi10GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_11月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi11GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_12月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi12GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_1月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku1GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_2月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku2GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_3月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku3GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_4月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku4GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_5月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku5GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_6月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku6GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_高額総合事業サービス費_7月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_うち70_74歳に係る負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku8GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku9GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku10GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku11GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku12GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku1GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku2GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku3GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku4GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku5GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku6GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_うち70_74歳に係る負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku7GatsuGo().getValue());
    }

    private void set変更後_補正後_自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_8月分(div.getJikoFutangakuHosei2a()
                .getCelJikofutangaku8GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku9GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku10GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku11GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangaku12GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku1GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku2GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku3GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku4GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku5GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku6GatsuGo().getValue());
        事業高額合算自己負担額補正保持Entity.set変更後_補正後_自己負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxtJikofutangakuYoku7GatsuGo().getValue());
    }

    private void set補正前_実際の自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangaku12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_実際の自己負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxtJissaiJikofutangakuYoku7GatsuMae().getValue());
    }

    private void set補正前_高額総合事業サービス費(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_8月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_9月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_10月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_11月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_12月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehi12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_1月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_2月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_3月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_4月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_5月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_6月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_高額総合事業サービス費_7月分(div.getJikoFutangakuHosei2a()
                .getTxtKougakuSogoJigyoServicehiYoku7GatsuMae().getValue());
    }

    private void set補正前_うち70_74歳に係る負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_8月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku8GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_9月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku9GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_10月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku10GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_11月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku11GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_12月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74Futangaku12GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_1月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku1GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_2月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku2GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_3月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku3GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_4月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku4GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_5月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku5GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_6月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku6GatsuMae().getValue());
        事業高額合算自己負担額補正保持Entity.set補正前_うち70_74歳に係る負担額_7月分(div.getJikoFutangakuHosei2a()
                .getTxt70Kara74FutangakuYoku7GatsuMae().getValue());
    }

    private boolean is変更(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        boolean flag = false;
        if (事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_8月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_8月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_9月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_9月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_10月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_10月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_11月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_11月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_12月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_12月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_1月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_1月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_2月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_2月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_3月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_3月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_4月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_4月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_5月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_5月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_6月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_6月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_自己負担額_7月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_7月分()) {
            return true;
        }
        if (is変更_うち70_74歳に係る負担額(事業高額合算自己負担額補正保持Entity)) {
            return true;
        }
        if (is変更_高額総合事業サービス費(事業高額合算自己負担額補正保持Entity)) {
            return true;
        }
        return flag;
    }

    private boolean is変更_高額総合事業サービス費(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        return 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_8月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_8月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_9月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_9月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_10月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_10月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_11月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_11月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_12月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_12月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_1月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_1月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_2月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_2月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_3月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_3月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_4月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_4月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_5月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_5月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_6月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_6月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_高額総合事業サービス費_7月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_7月分();
    }

    private boolean is変更_うち70_74歳に係る負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        return 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_8月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_8月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_9月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_9月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_10月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_10月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_11月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_11月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_12月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_12月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_1月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_1月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_2月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_2月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_3月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_3月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_4月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_4月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_5月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_5月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_6月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_6月分()
                || 事業高額合算自己負担額補正保持Entity.get変更前_補正後_うち70_74歳に係る負担額_7月分()
                != 事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_7月分();
    }

}
