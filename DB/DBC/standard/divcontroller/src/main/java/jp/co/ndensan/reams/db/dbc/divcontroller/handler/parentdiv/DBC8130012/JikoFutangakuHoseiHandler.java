/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012;

import jp.co.ndensan.reams.db.dbc.business.core.kogaku.JigyoKogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012.JikoFutangakuHosei2Div;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業分自己負担額情報補正（単）_補正入力のHandlerのクラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
public class JikoFutangakuHoseiHandler {

    private final JikoFutangakuHosei2Div div;

    /**
     * コンストラクタです。
     *
     * @param div 事業分自己負担額情報補正（単）_補正入力画面のdiv
     */
    public JikoFutangakuHoseiHandler(JikoFutangakuHosei2Div div) {
        this.div = div;
    }

    /**
     * 画面の初期化のメソッドです。
     *
     * @param 事業高額合算自己負担額補正保持Entity JigyoKogakuGassanJikofutangakuHoseiEntity
     */
    public void initialize_２回目以降(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        initialize_補正前_自己負担額(事業高額合算自己負担額補正保持Entity);
        initialize_補正前_うち70_74歳に係る負担額(事業高額合算自己負担額補正保持Entity);
        initialize_補正前_高額総合事業サービス費(事業高額合算自己負担額補正保持Entity);
        initialize_補正前_実際の自己負担額(事業高額合算自己負担額補正保持Entity);
        initialize_補正後_自己負担額(事業高額合算自己負担額補正保持Entity);
        initialize_補正後_うち70_74歳に係る負担額(事業高額合算自己負担額補正保持Entity);
        initialize_補正後_高額総合事業サービス費(事業高額合算自己負担額補正保持Entity);
        initialize_補正後_実際の自己負担額(事業高額合算自己負担額補正保持Entity);
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuGoukeiMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更前_合計_自己負担額());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuGoukeiMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更前_合計_うち70_74歳に係る負担額());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiGoukeiMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更前_合計_高額総合事業サービス費());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuGoukeiMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更前_合計_実際の自己負担額());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuGoukeiGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_合計_補正後_自己負担額());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuGoukeiGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_合計_補正後_うち70_74歳に係る負担額());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiGoukeiGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_合計_補正後_高額総合事業サービス費());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuGoukeiGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_合計_補正後_実際の自己負担額());

    }

    private void initialize_補正後_実際の自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku8GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_8月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku9GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_9月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku10GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_10月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku11GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_11月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku12GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_12月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku1GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_1月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku2GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_2月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku3GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_3月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku4GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_4月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku5GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_5月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku6GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_6月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku7GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_実際の自己負担額_7月分());
    }

    private void initialize_補正後_高額総合事業サービス費(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_8月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_9月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_10月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_11月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_12月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_1月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_2月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_3月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_4月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_5月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_6月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_高額総合事業サービス費_7月分());
    }

    private void initialize_補正後_うち70_74歳に係る負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_8月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_9月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_10月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_11月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_12月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_1月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_2月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_3月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_4月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_5月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_6月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_うち70_74歳に係る負担額_7月分());
    }

    private void initialize_補正後_自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getCelJikofutangaku8GatsuGo().setValue(事業高額合算自己負担額補正保持Entity
                .get変更後_補正後_自己負担額_8月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuGo().setValue(事業高額合算自己負担額補正保持Entity
                .get変更後_補正後_自己負担額_9月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuGo().setValue(事業高額合算自己負担額補正保持Entity
                .get変更後_補正後_自己負担額_10月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuGo().setValue(事業高額合算自己負担額補正保持Entity
                .get変更後_補正後_自己負担額_11月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuGo().setValue(事業高額合算自己負担額補正保持Entity
                .get変更後_補正後_自己負担額_12月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_1月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_2月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_3月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_4月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_5月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_6月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuGo()
                .setValue(事業高額合算自己負担額補正保持Entity.get変更後_補正後_自己負担額_7月分());
    }

    private void initialize_補正前_実際の自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku8GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_8月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku9GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_9月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku10GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_10月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku11GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_11月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangaku12GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_12月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku1GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_1月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku2GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_2月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku3GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_3月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku4GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_4月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku5GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_5月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku6GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_6月分());
        div.getJikoFutangakuHosei2a().getTxtJissaiJikofutangakuYoku7GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_実際の自己負担額_7月分());
    }

    private void initialize_補正前_高額総合事業サービス費(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi8GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_8月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi9GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_9月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi10GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_10月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi11GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_11月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehi12GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_12月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku1GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_1月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku2GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_2月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku3GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_3月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku4GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_4月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku5GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_5月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku6GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_6月分());
        div.getJikoFutangakuHosei2a().getTxtKougakuSogoJigyoServicehiYoku7GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_高額総合事業サービス費_7月分());
    }

    private void initialize_補正前_うち70_74歳に係る負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_8月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_9月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_10月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_11月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_12月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_1月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_2月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_3月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_4月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_5月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_6月分());
        div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_うち70_74歳に係る負担額_7月分());
    }

    private void initialize_補正前_自己負担額(JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity) {
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku8GatsuMae().setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_8月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku9GatsuMae().setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_9月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku10GatsuMae().setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_10月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku11GatsuMae().setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_11月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangaku12GatsuMae().setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_12月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku1GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_1月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku2GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_2月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku3GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_3月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku4GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_4月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku5GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_5月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku6GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_6月分());
        div.getJikoFutangakuHosei2a().getTxtJikofutangakuYoku7GatsuMae()
                .setValue(事業高額合算自己負担額補正保持Entity.get補正前_自己負担額_7月分());
    }

    /**
     * 補正後　うち70～74歳に係る負担額　の合計
     */
    public void onChange_txt70Kara74FutangakuGatsuGo() {
        Decimal 補正後_うち70_74歳に係る負担額_8月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku8GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_8月分)) {
            補正後_うち70_74歳に係る負担額_8月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_9月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku9GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_9月分)) {
            補正後_うち70_74歳に係る負担額_9月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_10月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku10GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_10月分)) {
            補正後_うち70_74歳に係る負担額_10月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_11月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku11GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_11月分)) {
            補正後_うち70_74歳に係る負担額_11月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_12月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74Futangaku12GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_12月分)) {
            補正後_うち70_74歳に係る負担額_12月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_1月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku1GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_1月分)) {
            補正後_うち70_74歳に係る負担額_1月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_2月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku2GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_2月分)) {
            補正後_うち70_74歳に係る負担額_2月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_3月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku3GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_3月分)) {
            補正後_うち70_74歳に係る負担額_3月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_4月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku4GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_4月分)) {
            補正後_うち70_74歳に係る負担額_4月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_5月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku5GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_5月分)) {
            補正後_うち70_74歳に係る負担額_5月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_6月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku6GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_6月分)) {
            補正後_うち70_74歳に係る負担額_6月分 = Decimal.ZERO;
        }
        Decimal 補正後_うち70_74歳に係る負担額_7月分 = div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuYoku7GatsuGo().getValue();
        if (isNull(補正後_うち70_74歳に係る負担額_7月分)) {
            補正後_うち70_74歳に係る負担額_7月分 = Decimal.ZERO;
        }
        Decimal うち70_74歳に係る負担額の合計 = 補正後_うち70_74歳に係る負担額_8月分.add(補正後_うち70_74歳に係る負担額_9月分)
                .add(補正後_うち70_74歳に係る負担額_10月分).add(補正後_うち70_74歳に係る負担額_11月分).add(補正後_うち70_74歳に係る負担額_12月分)
                .add(補正後_うち70_74歳に係る負担額_1月分).add(補正後_うち70_74歳に係る負担額_2月分).add(補正後_うち70_74歳に係る負担額_3月分)
                .add(補正後_うち70_74歳に係る負担額_4月分).add(補正後_うち70_74歳に係る負担額_5月分).add(補正後_うち70_74歳に係る負担額_6月分)
                .add(補正後_うち70_74歳に係る負担額_7月分);
        if (うち70_74歳に係る負担額の合計 != null) {
            div.getJikoFutangakuHosei2a().getTxt70Kara74FutangakuGoukeiGo().setValue(うち70_74歳に係る負担額の合計);
        }

    }

    private boolean isNull(Decimal 金額) {
        return 金額 == null;
    }
}
