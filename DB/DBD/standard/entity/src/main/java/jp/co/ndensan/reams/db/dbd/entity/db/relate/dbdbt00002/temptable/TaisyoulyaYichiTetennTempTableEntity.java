/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.temptable;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.TaishoshaJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 対象者一時テーブルEntity
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaisyoulyaYichiTetennTempTableEntity extends DbTableEntityBase<TaishoshaJohoTempTableEntity> implements IDbAccessable {

    private RString 被保険者番号;
    private FlexibleDate 基準年月日;

    /**
     * 減免減額対象者判定用根拠作成対象者一時テーブルの引数を作成
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     */
    public TaisyoulyaYichiTetennTempTableEntity(RString 被保険者番号, FlexibleDate 基準年月日) {
        this.被保険者番号 = 被保険者番号;
        this.基準年月日 = 基準年月日;
    }
}
