/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00005;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00005.KyufuJisekiSanshoKeyCreateMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績参照キー作成_process処理のパラメタークラスクラスです。
 *
 * @reamsid_L DBD-3880-050 x_lilh
 */
public class KyufuJisekiSanshoKeyCreateProcessParameter implements IBatchProcessParameter {

    // TODO
    //給付実績参照キー作成_process処理のパラメター
//    対象年月
//年月範囲の開始
//年月範囲の終了
//事業者番号
//地区コード種類
//開始地区コード
//終了地区コード
//市町村コード
//改頁出力順ID
//帳票ID
//帳票作成日時
    /**
     * コンストラクタです。
     *
     * @param パラメター パラメター(TODO)
     * @return 給付実績参照キー作成のMyBatis用パラメー
     */
    public KyufuJisekiSanshoKeyCreateMybatisParameter toKyufuJisekiSanshoKeyCreateMybatisParameter(RString パラメター) {
        //TODO
        return new KyufuJisekiSanshoKeyCreateMybatisParameter(パラメター);
    }
}
