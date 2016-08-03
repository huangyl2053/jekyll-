/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt00005;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00005.ChohyoShutsuryokuJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00005.KyufuJisekiSanshoKeyCreateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別地域加算軽減実績管理リスト作成バッチパラメタークラスです．
 *
 * @reamsid_L DBD-3880-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuTiikiKasannKeigennJiqsekiKannriParameter extends BatchParameterBase {

    // TODO バッチパラメター実装
    //対象年月
    //年月範囲の開始
    //年月範囲の終了
    //事業者番号
    //地区コード種類
    //開始地区コード
    //終了地区コード
    //市町村コード
    //改頁出力順ID
    //帳票ID
    /**
     * TODO 帳票出力情報の取得_process処理のパラメターを取得します．
     *
     * @param パラメター パラメターTODO仕様書必要パラメター
     * @return　帳票出力情報の取得_process処理のパラメター
     */
    public ChohyoShutsuryokuJohoShutokuProcessParameter toChohyoShutsuryokuJohoShutokuProcessParameter(RString パラメター) {

        return null;
    }

    /**
     * TODO 給付実績参照キー作成_process処理のパラメターを取得します．
     *
     * @param パラメター パラメターTODO仕様書必要パラメター
     * @return 給付実績参照キー作成_process処理のパラメター
     */
    public KyufuJisekiSanshoKeyCreateProcessParameter toKyufuJisekiSanshoKeyCreateProcessParameter(RString パラメター) {
        return null;
    }

}
