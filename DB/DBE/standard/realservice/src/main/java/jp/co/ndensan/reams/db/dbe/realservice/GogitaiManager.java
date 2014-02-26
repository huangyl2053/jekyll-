/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;

/**
 * 合議体の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiManager {

    /**
     * 合議体番号を指定して、合議体のリストを取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 指定した合議体の履歴のリスト
     */
    public GogitaiList get合議体履歴List(GogitaiNo 合議体番号) {
    }

    /**
     * 指定した年月日時点で、有効な合議体のリストを取得します。
     *
     * @param 基準年月日 基準年月日
     * @return 現時点で有効な合議体のリスト
     */
    public GogitaiList get有効合議体List(RDate 基準年月日) {
    }

    /**
     * 引数に指定した合議体の情報を保存します。
     *
     * @param 合議体 合議体
     * @return 保存に成功したらtrue
     */
    public boolean save(Gogitai 合議体) {
    }

    /**
     * 引数に指定した合議体の情報を削除します。
     *
     * @param 合議体 合議体
     * @return 削除に成功したらtrue
     */
    public boolean remove(Gogitai 合議体) {
    }
}
