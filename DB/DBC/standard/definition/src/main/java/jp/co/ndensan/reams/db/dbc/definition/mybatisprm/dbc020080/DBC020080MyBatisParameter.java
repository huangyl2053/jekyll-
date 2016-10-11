/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080MyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 申請対象日開始;
    private RString 申請対象日終了;
//    TODO Unused to delete
    private RString 処理年月日;
    private RString 出力順;
    private RString 市町村コード;
    private RString 処理名;
    //    TODO Unused to delete
    private RString システム日付の年;
    private boolean 事業者フラグ;
    private final IShikibetsuTaishoPSMSearchKey 宛名検索条件;

    /**
     * DBC020080MyBatisParameterのコンストラクタです。
     *
     * @param 申請対象日開始 申請対象日開始
     * @param 申請対象日終了 申請対象日終了
     * @param 処理年月日 処理年月日
     * @param 出力順 出力順
     * @param 市町村コード 市町村コード
     * @param 処理名 処理名
     * @param システム日付の年 システム日付の年
     * @param 事業者フラグ boolean
     * @param 宛名検索条件 IShikibetsuTaishoPSMSearchKey
     *
     */
    public DBC020080MyBatisParameter(RString 申請対象日開始,
            RString 申請対象日終了,
            RString 処理年月日,
            RString 出力順,
            RString 市町村コード,
            RString 処理名,
            RString システム日付の年,
            boolean 事業者フラグ,
            IShikibetsuTaishoPSMSearchKey 宛名検索条件) {
        super(宛名検索条件);
        this.宛名検索条件 = 宛名検索条件;
        this.申請対象日開始 = 申請対象日開始;
        this.申請対象日終了 = 申請対象日終了;
        this.処理年月日 = 処理年月日;
        this.出力順 = RString.isNullOrEmpty(出力順) ? null : 出力順;
        this.市町村コード = 市町村コード;
        this.処理名 = 処理名;
        this.システム日付の年 = システム日付の年;
        this.事業者フラグ = 事業者フラグ;
    }

}
