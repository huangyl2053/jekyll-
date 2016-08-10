/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 氏名カナ突合結果件数一時テーブルEntityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiKanaTotsugoKensuTempTableEntity extends DbTableEntityBase<ShimeiKanaTotsugoKensuTempTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("ShimeiKanaTotsugoKensuTempTable");
    // TODO
//            DT年金保険者コード
//        DT年金コード
//        DT基礎年金番号
//        DT対象年
//        DT作成年月日
//        件数
}
