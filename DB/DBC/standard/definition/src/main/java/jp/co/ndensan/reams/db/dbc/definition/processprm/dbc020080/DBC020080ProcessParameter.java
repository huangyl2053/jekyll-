/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.DBC020080MyBatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080ProcessParameter implements IBatchProcessParameter {

    private RDateTime 処理日時;
    private FlexibleDate 申請対象開始日;
    private FlexibleDate 申請対象終了日;
    private boolean 出力フラグ;
    private Long 帳票出力順ID;
    private LasdecCode 市町村コード;
    private RString 出力順;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;
    private RString 処理区分;

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     */
    public DBC020080ProcessParameter() {
    }

    /**
     * DBC020080ProcessParameterのコンストラクタです。
     *
     * @param 処理日時 処理日時
     * @param 申請対象開始日 申請対象開始日
     * @param 申請対象終了日 申請対象終了日
     * @param 出力フラグ 出力フラグ
     * @param 帳票出力順ID 帳票出力順ID
     * @param 市町村コード 市町村コード
     */
    public DBC020080ProcessParameter(RDateTime 処理日時,
            FlexibleDate 申請対象開始日,
            FlexibleDate 申請対象終了日,
            boolean 出力フラグ,
            Long 帳票出力順ID,
            LasdecCode 市町村コード) {
        this.処理日時 = 処理日時;
        this.申請対象開始日 = 申請対象開始日;
        this.申請対象終了日 = 申請対象終了日;
        this.出力フラグ = 出力フラグ;
        this.帳票出力順ID = 帳票出力順ID;
        this.市町村コード = 市町村コード;
    }

    /**
     * toDBC020080MyBatisParameterのコンストラクタです
     *
     * @return DBC020080MyBatisParameter
     */
    public DBC020080MyBatisParameter toDBC020080MyBatisParameter() {
        return new DBC020080MyBatisParameter(出力順, ShoriName.高額合算自己負担額計算登録.get名称());
    }
}
