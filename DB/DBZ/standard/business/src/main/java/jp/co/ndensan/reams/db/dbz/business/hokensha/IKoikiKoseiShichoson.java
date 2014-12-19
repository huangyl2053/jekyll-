/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hokensha;

import jp.co.ndensan.reams.db.dbz.model.hokensha.IKoikiKoseiShichosonMaster;

/**
 * 広域構成市町村であることを表します。<br/>
 * 現在、広域構成市町村マスタテーブルの情報を返す{@link IKoikiKoseiShichosonMaster}と同じ情報しか扱いませんが、
 * 将来的に、構成市町村支所マスタ等と同時に情報を取る必要が現れた時の拡張用に、このインタフェースを用意しています。
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichoson extends IKoikiKoseiShichosonMaster {
}
