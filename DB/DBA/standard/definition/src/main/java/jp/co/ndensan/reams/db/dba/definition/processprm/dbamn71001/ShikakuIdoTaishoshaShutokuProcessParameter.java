/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.AtenaMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.ShikakuIdoTaishoshaShutokuMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格異動対象者情報取得_バッチ用のパラメータです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuIdoTaishoshaShutokuProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    

   /**
     * 資格異動対象者情報取得のMybatisパラメータを作成します。
     * @param 識別コード 識別コード
     * @param 年齢到達日 年齢到達日
     * @return 資格異動対象者情報取得のMybatisパラメータ
     */ 
    public ShikakuIdoTaishoshaShutokuMybatisParameter toShikakuIdoTaishoshaShutokuMybatisParameter(
            ShikibetsuCode 識別コード, FlexibleDate 年齢到達日) {
        
        return new ShikakuIdoTaishoshaShutokuMybatisParameter(識別コード, 年齢到達日);
    }
    
   /**
     * 抽出条件の生成のMybatisパラメータを作成します。
     * 
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     * @param shikibetsuCode 識別コード
     * @return 抽出条件の生成のMybatisパラメータ
     */ 
    public AtenaMybatisParameter toAtenaMybatisParameter(IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey,
            List<ShikibetsuCode> shikibetsuCode) {
        
        return new AtenaMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuCode);
    }
}
