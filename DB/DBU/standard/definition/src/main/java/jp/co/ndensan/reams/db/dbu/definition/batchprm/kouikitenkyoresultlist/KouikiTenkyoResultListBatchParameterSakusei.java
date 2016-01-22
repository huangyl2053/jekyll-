/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 広域内転居結果一覧表作成バッチパラメータクラス
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KouikiTenkyoResultListBatchParameterSakusei extends BatchParameterBase {

    private RString 市町村コード;
    private RString 市町村名称;
    private FlexibleDate 日付FROM;
    private FlexibleDate 日付TO;
    private static final int 市町村コード位置 = 6;
    private static final int 市町村名称位置 = 7;

    /**
     * コンストラクタです
     *
     * @param parameter 広域内転居結果一覧表Divパラメータ
     */
    private KouikiTenkyoResultListBatchParameterSakusei(KouikiTenkyoResultListSakuseiParameter parameter) {
        this.市町村コード = parameter.getShichosonshitei().substring(0, 市町村コード位置);
        this.市町村名称 = parameter.getShichosonshitei().substring(市町村名称位置);
        this.日付FROM = parameter.getKaishihi();
        this.日付TO = parameter.getShohi();
    }

    /**
     * 広域内転居結果一覧表パラメータ取得
     *
     * @param parameter 広域内転居結果一覧表Divパラメータ
     * @return 広域内転居結果一覧表作成バッチパラメータクラス
     */
    public static KouikiTenkyoResultListBatchParameterSakusei getKouikiTenkyoResultListBatchParameter(
            KouikiTenkyoResultListSakuseiParameter parameter) {
        return new KouikiTenkyoResultListBatchParameterSakusei(parameter);
    }

}
