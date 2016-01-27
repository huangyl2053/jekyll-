/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会対象者候補者一覧エリア内容検索パラメータクラス。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KohoshaIchiranMapperParameter {

    private final RString kaisaiNo;
    private final boolean isItijiHannteiAto;

    /**
     * コンストラクタです。
     *
     * @param kaisaiNo 開催番号
     */
    private KohoshaIchiranMapperParameter(RString kaisaiNo, boolean isItijiHannteiAto) {
        this.kaisaiNo = kaisaiNo;
        this.isItijiHannteiAto = isItijiHannteiAto;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param kaisaiNo 開催番号
     * @return 介護認定審査会対象者候補者一覧エリア内容検索パラメータ
     */
    public static KohoshaIchiranMapperParameter createKohoshaIchiranMapperParameter(RString kaisaiNo, boolean isItijiHannteiAto) {
        return new KohoshaIchiranMapperParameter(kaisaiNo, isItijiHannteiAto);
    }
}
