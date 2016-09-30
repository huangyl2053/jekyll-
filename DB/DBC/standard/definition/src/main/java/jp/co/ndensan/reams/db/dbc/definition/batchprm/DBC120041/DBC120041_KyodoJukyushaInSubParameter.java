/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120041;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyodojukyushainsub.KyufuJissekiInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計書_DBCMNF2002-5Cx_共同処理用受給者情報更新結果情報取込共通処理（CSVファイル取込）Parameterクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120041_KyodoJukyushaInSubParameter extends BatchParameterBase {

    private static final String HOZONSAKIFOLDER = "hozonsakifolder";
    private static final String ENTRYJYOHOU_LIST = "entryjyohou_list";

    @BatchParameter(key = HOZONSAKIFOLDER, name = "保存先フォルダ")
    private RString 保存先フォルダ;
    @BatchParameter(key = ENTRYJYOHOU_LIST, name = "エントリ情報List")
    private List<RString> エントリ情報List;

    /**
     * CreateTmptableProcessパラメータの取得です。
     *
     * @param csvファイル名 csvファイル名
     * @return CreateTmptableProcessパラメータ
     */
    public KyufuJissekiInProcessParameter toKyufuJissekiInProcessParameter(RString csvファイル名) {
        return new KyufuJissekiInProcessParameter(保存先フォルダ, csvファイル名);
    }
}
