/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.dbamn71001;

import jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001.ShikakuIdoTaishoshaShutokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 65歳年齢到達資格異動バッチパラメータクラスです。
 */
@Getter
@Setter
public class Dbamn71001BatchFlowParameter extends BatchParameterBase {

    /**
     *
     * 65歳年齢到達資格異動バッチパラメータクラスです。
     */
    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;
    
   /**
     * コンストラクタです。
     */
    public Dbamn71001BatchFlowParameter() {
        
    }

    /**
     * 65歳年齢到達資格異動バッチパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     */
    private Dbamn71001BatchFlowParameter(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD
    ) {
        this.kaishiYMD = kaishiYMD;
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * 65歳年齢到達資格異動バッチのパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     * @return 65歳年齢到達資格異動バッチパラメータ
     */
    public Dbamn71001BatchFlowParameter createRoreiFukushiParam(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD) {
        return new Dbamn71001BatchFlowParameter(
                kaishiYMD,
                shuryoYMD);
    }
    
    /**
     * 認定調査督促対象者一覧表作成のパラメータを作成します。
     * 
     * @return 認定調査督促対象者一覧表作成のパラメータ
     */
    public ShikakuIdoTaishoshaShutokuProcessParameter toShikakuIdoTaishoshaShutokuProcessParameter() {
        
        ShikakuIdoTaishoshaShutokuProcessParameter parameter = new ShikakuIdoTaishoshaShutokuProcessParameter();
        parameter.set開始日(kaishiYMD);
        parameter.set終了日(shuryoYMD);
        return parameter;
    }
}
