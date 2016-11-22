/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojuminhyotruku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KaigojuminHyotrukuMapperParameter implements IMyBatisParameter {

    private final RDateTime shoriTimestamp;
    private final List<RString> shichosonCodelist;

    /**
     * コンストラクタです。
     *
     * @param shoriTimestamp RDateTime
     */
    private KaigojuminHyotrukuMapperParameter(
            RDateTime shoriTimestamp,
            List<RString> shichosonCodelist) {

        this.shoriTimestamp = shoriTimestamp;
        this.shichosonCodelist = shichosonCodelist;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shoriTimestamp RDateTime
     * @param shichosonCodelist List<RString>
     * @return 対象日時範囲チェックの検索パラメータ
     */
    public static KaigojuminHyotrukuMapperParameter createParam_common(
            RDateTime shoriTimestamp,
            List<RString> shichosonCodelist) {
        return new KaigojuminHyotrukuMapperParameter(shoriTimestamp, shichosonCodelist);
    }
}
