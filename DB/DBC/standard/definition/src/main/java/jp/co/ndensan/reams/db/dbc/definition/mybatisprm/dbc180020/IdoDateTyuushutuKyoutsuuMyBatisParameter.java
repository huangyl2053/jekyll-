/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 異動データ抽出のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-4950-033 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoDateTyuushutuKyoutsuuMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private YMDHMS 介護所得抽出開始日時;
    private YMDHMS 介護所得抽出終了日時;
    private FlexibleDate 対象年度開始日;
    private FlexibleDate 対象年度終了日;
    private FlexibleYear 対象年度;

    /**
     * コンストラクタです。
     *
     * @param 抽出開始日時 抽出開始日時
     * @param 抽出終了日時 抽出終了日時
     * @param 対象年度開始日 対象年度開始日
     * @param 対象年度終了日 対象年度終了日
     * @param 対象年度 対象年度
     * @param searchKey searchKey
     */
    public IdoDateTyuushutuKyoutsuuMyBatisParameter(RDateTime 抽出開始日時, RDateTime 抽出終了日時, FlexibleDate 対象年度開始日,
            FlexibleDate 対象年度終了日, FlexibleYear 対象年度, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抽出開始日時 = 抽出開始日時;
        this.抽出終了日時 = 抽出終了日時;
        this.介護所得抽出開始日時 = new YMDHMS(抽出開始日時);
        this.介護所得抽出終了日時 = new YMDHMS(抽出終了日時);
        this.対象年度開始日 = 対象年度開始日;
        this.対象年度終了日 = 対象年度終了日;
        this.対象年度 = 対象年度;
    }

}
