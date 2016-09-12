/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.idoriyoshafutanwariaihentei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.idoriyoshafutanwariaihentei.IdoRiyoshaFutanwariaiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 高額サービス費給付お知らせ通知書作成のプロセス用パラメータクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoRiyoshaFutanwariaiHanteiProcessParameter implements IBatchProcessParameter {

    private FlexibleYear taishoNendo;
    private YMDHMS chushutsuKaishiTime;
    private YMDHMS chushutsuShuryoTime;

    /**
     * コンストラクタです。
     *
     * @param taishoNendo 対象年度
     * @param chushutsuKaishiTime 抽出開始日時
     * @param chushutsuShuryoTime 抽出終了日時
     */
    public IdoRiyoshaFutanwariaiHanteiProcessParameter(FlexibleYear taishoNendo, RDateTime chushutsuKaishiTime, RDateTime chushutsuShuryoTime) {
        this.taishoNendo = taishoNendo;
        this.chushutsuKaishiTime = new YMDHMS(chushutsuKaishiTime);
        this.chushutsuShuryoTime = new YMDHMS(chushutsuShuryoTime);
    }

    /**
     * MYBATISパラメータを取得します。
     *
     * @return MYBATISパラメータ
     */
    public IdoRiyoshaFutanwariaiHanteiMybatisParameter toMybatisParameter() {
        return new IdoRiyoshaFutanwariaiHanteiMybatisParameter(taishoNendo, ShoriName.異動分負担割合判定.get名称());
    }
}
