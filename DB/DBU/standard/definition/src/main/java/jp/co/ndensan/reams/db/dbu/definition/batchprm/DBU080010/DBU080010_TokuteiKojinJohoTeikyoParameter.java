/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.RenkeisakiDantainaiTogoAtena;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 特定個人情報提供のバッチフ処理parameterクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU080010_TokuteiKojinJohoTeikyoParameter extends BatchParameterBase {

    private static final String TOKUTEIKOJINJOHO = "TokuteiKojinJoho";
    private static final String SHINKIIDOKUBUN = "ShinkiIdoKubun";
    private static final String TAISHOKAISHITIMESTAMP = "TaishoKaishiTimestamp";
    private static final String TAISHOSHURYOTIMESTAMP = "TaishoShuryoTimestamp";
    private static final String RENKEISAKIDANTAINAITOGOATENA = "RenkeisakiDantainaiTogoAtena";

    @BatchParameter(key = TOKUTEIKOJINJOHO, name = "特定個人情報")
    private List<DBU080010_TokuteiKojinJohoTeikyoParameterHandler> 特定個人情報;
    @BatchParameter(key = SHINKIIDOKUBUN, name = "新規異動区分")
    private ShinkiIdoKubun 新規異動区分;
    @BatchParameter(key = TAISHOKAISHITIMESTAMP, name = "対象開始日時")
    private RDateTime 対象開始日時;
    @BatchParameter(key = TAISHOSHURYOTIMESTAMP, name = "対象終了日時")
    private RDateTime 対象終了日時;
    @BatchParameter(key = RENKEISAKIDANTAINAITOGOATENA, name = "連携先団体内統合宛名（連携方式）")
    private RenkeisakiDantainaiTogoAtena 連携先団体内統合宛名_連携方式;

    /**
     * コンストラクタです。
     */
    public DBU080010_TokuteiKojinJohoTeikyoParameter() {

    }
}
