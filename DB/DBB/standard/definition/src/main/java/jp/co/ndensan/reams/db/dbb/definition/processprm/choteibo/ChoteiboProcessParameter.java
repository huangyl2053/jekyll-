/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo.ChoteiboMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 調定簿作成のバッチ処理クラスのパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ChoteiboProcessParameter implements IBatchProcessParameter {

    private FlexibleYear shoriNendo;
    private YMDHMS chushutsuStYMD;
    private YMDHMS chushutsuEdYMD;

    /**
     * コンストラクタ
     *
     * @param shoriNendo 処理年度
     * @param chushutsuStYMD 開始調定日時
     * @param chushutsuEdYMD 終了調定日時
     */
    public ChoteiboProcessParameter(FlexibleYear shoriNendo, YMDHMS chushutsuStYMD, YMDHMS chushutsuEdYMD) {
        this.shoriNendo = shoriNendo;
        this.chushutsuStYMD = chushutsuStYMD;
        this.chushutsuEdYMD = chushutsuEdYMD;
    }

    /**
     * 検索パラメータへ変更
     *
     * @return ChoteiboMyBatisParameter
     */
    public ChoteiboMyBatisParameter toChoteiboMyBatisParameter() {
        return new ChoteiboMyBatisParameter(shoriNendo, chushutsuStYMD, chushutsuEdYMD);
    }
}
