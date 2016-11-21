/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyotruku;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojuminhyotruku.KaigojuminHyotrukuMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaigojuminHyotrukuProcessParameter implements IBatchProcessParameter {

    private RDateTime shoriTimestamp;
    private List<RString> shichosonCodelist;

    /**
     * コンストラクタ
     *
     * @param shoriTimestamp 処理日時
     */
    public KaigojuminHyotrukuProcessParameter(
            RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;

    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】のバッチのパラメータを設定します。
     *
     * @return KaigoJuminhyoMapperParameter
     */
    public KaigojuminHyotrukuMapperParameter toKaigojuminHyotrukuMapperParameter() {
        return KaigojuminHyotrukuMapperParameter.createParam_common(shoriTimestamp, shichosonCodelist);
    }
}
