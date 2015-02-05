/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import java.io.Serializable;

/**
 * 広域構成市町村のモデルです。{@link KoseiShichosonMasterModel 構成市町村マスタ}に対する処理の拡張に対応するためのラッパーです。
 * 構成市町村マスタに関連するテーブルを同時更新する必要が生じた時は、このクラスを使用して、RelateModelを作成してください。
 *
 * @author N3327 三浦 凌
 */
public class KoseiShichosonModel implements Serializable {

    private final KoseiShichosonMasterModel masterModel;

    /**
     * {@link KoseiShichosonMasterModel}からインスタンスを生成します。
     *
     * @param masterModel KoseiShichosonMasterModel
     */
    public KoseiShichosonModel(KoseiShichosonMasterModel masterModel) {
        this.masterModel = masterModel;
    }

    /**
     * 構成市町村に関する情報を返します。
     *
     * @return 構成市町村に関する情報
     */
    public KoseiShichosonMasterModel get構成市町村() {
        return this.masterModel;
    }
}
