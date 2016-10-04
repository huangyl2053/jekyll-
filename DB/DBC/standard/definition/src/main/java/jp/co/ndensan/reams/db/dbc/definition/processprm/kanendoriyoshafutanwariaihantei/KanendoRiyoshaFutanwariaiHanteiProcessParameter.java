/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kanendoriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kanendoriyoshafutanwariaihantei.KanendoRiyoshaFutanwariaiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 異動分利用者負担割合判定（過年度）のプロセス用パラメータクラスです。
 *
 * @reamsid_L DBC-4940-030 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoRiyoshaFutanwariaiHanteiProcessParameter implements IBatchProcessParameter {

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
    public KanendoRiyoshaFutanwariaiHanteiProcessParameter(FlexibleYear taishoNendo, RDateTime chushutsuKaishiTime, RDateTime chushutsuShuryoTime) {
        this.taishoNendo = taishoNendo;
        this.chushutsuKaishiTime = new YMDHMS(chushutsuKaishiTime);
        this.chushutsuShuryoTime = new YMDHMS(chushutsuShuryoTime);
    }

    /**
     * MYBATISパラメータを取得します。
     *
     * @return MYBATISパラメータ
     */
    public KanendoRiyoshaFutanwariaiHanteiMybatisParameter toMybatisParameter() {
        return new KanendoRiyoshaFutanwariaiHanteiMybatisParameter(ShoriName.異動分利用者負担割合判定_過年度.get名称());
    }
}
