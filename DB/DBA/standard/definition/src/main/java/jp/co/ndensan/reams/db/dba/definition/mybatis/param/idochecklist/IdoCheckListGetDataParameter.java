/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.idochecklist;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動チェックリストのパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoCheckListGetDataParameter implements IBatchProcessParameter {

    private RDateTime konkaiKaishi;
    private RDateTime konkaiShuryo;
    private RString daichoShubetsu;

    /**
     * コンストラクタです。
     *
     * @param konkaiKaishi 今回開始日時
     * @param konkaiShuryo 今回終了日時
     * @param daichoShubetsu 台帳種別
     */
    private IdoCheckListGetDataParameter(RDateTime konkaiKaishi, RDateTime konkaiShuryo, RString daichoShubetsu) {
        this.konkaiKaishi = konkaiKaishi;
        this.konkaiShuryo = konkaiShuryo;
        this.daichoShubetsu = daichoShubetsu;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param konkaiKaishi 今回開始日時
     * @param konkaiShuryo 今回終了日時
     * @param daichoShubetsu 台帳種別
     * @return IdoCheckListGetDataParameter
     */
    public static IdoCheckListGetDataParameter createIdoCheckListGetDataParameter(
            RDateTime konkaiKaishi, RDateTime konkaiShuryo, RString daichoShubetsu) {
        return new IdoCheckListGetDataParameter(konkaiKaishi, konkaiShuryo, daichoShubetsu);
    }

}
