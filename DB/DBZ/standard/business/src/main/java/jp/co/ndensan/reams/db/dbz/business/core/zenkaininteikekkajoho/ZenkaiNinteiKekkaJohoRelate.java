/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.zenkaininteikekkajoho;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 前回結果情報検索Releteビジネスクラスです。
 */
public class ZenkaiNinteiKekkaJohoRelate {
    
    private final ZenkaiNinteiKekkaJohoRelateEntity entity;
    
    /**
     * コンストラクタです。
     */
    public ZenkaiNinteiKekkaJohoRelate() {
        this.entity = new ZenkaiNinteiKekkaJohoRelateEntity();
    }
    
    /**
     * コンストラクタです。
     * @param entity 前回結果情報RelateEntity
     */
    public ZenkaiNinteiKekkaJohoRelate(ZenkaiNinteiKekkaJohoRelateEntity entity) {
        this.entity = entity;
    }
    
    /**
     * 厚労省IF識別コードを取得します。
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }
    
    /**
     * 二次判定要介護状態区分コードを取得します。
     * @return 二次判定要介護状態区分コード
     */
    public RString get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }
    
    /**
     * 次判定年月日を取得します。
     * @return 次判定年月日
     */
    public RString get次判定年月日() {
        return entity.getNijiHanteiYMD();
    }
    
    /**
     * 二次判定認定有効開始年月日を取得します。
     * @return 二次判定認定有効開始年月日
     */
    public RString get二次判定認定有効開始年月日() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }
    
    /**
     * 二次判定認定有効終了年月日を取得します。
     * @return 二次判定認定有効終了年月日
     */
    public RString get二次判定認定有効終了年月日() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
    }
}
