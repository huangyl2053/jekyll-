/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.dbamn71001.Dbamn71001BatchFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 *　
 * 認定調査督促対象者一覧表CSV作成_バッチ処理クラスパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
public class HihokenshaDaichoUpdateProcessParameter implements IBatchProcessParameter {
    
    private Object enList;
    private Dbamn71001BatchFlowParameter flowParam;
    
   /**
     * 資格異動対象者リストの取得です。
     *
     * @return 資格異動対象者の情報リスト
     */
    public Object getShikakuIdoTaishoshaEntityList() {
        return enList;
    }

    /**
     * 資格異動対象者リストの設定です。
     *
     * @param shikakuIdoTaishoshaList 資格異動対象者リスト
     */
    public void setShikakuIdoTaishoshaEntityList(Object shikakuIdoTaishoshaList) {
        this.enList = shikakuIdoTaishoshaList;
    }
    
   /**
     * 65歳年齢到達資格異動バッチパラメータの取得です。
     *
     * @return 65歳年齢到達資格異動バッチパラメータ
     */
    public Dbamn71001BatchFlowParameter getFlowParam() {
        return flowParam;
    }
    
   /**
     * 65歳年齢到達資格異動バッチパラメータの設定です。
     * 
     * @param flowParam 65歳年齢到達資格異動バッチパラメータ
     */
    public void setFlowParam(Dbamn71001BatchFlowParameter flowParam) {
        this.flowParam = flowParam;
    }
    
}
