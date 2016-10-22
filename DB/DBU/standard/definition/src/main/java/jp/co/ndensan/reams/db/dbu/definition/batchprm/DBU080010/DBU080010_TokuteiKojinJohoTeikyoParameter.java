/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JukyushaKihonJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.SougouJigyouJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoKanriUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinKadouKahiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    private static final String KOJINBANGOHIHOKENSHANO = "KojinbangoTsukekaeTaisyosyaHihokenshaNo";

    @BatchParameter(key = TOKUTEIKOJINJOHO, name = "特定個人情報")
    private List<RString> 特定個人情報;
    @BatchParameter(key = SHINKIIDOKUBUN, name = "新規異動区分")
    private RString 新規異動区分;
    @BatchParameter(key = TAISHOKAISHITIMESTAMP, name = "対象開始日時")
    private RDateTime 対象開始日時;
    @BatchParameter(key = TAISHOSHURYOTIMESTAMP, name = "対象終了日時")
    private RDateTime 対象終了日時;
    @BatchParameter(key = RENKEISAKIDANTAINAITOGOATENA, name = "連携先団体内統合宛名（連携方式）")
    private RString 連携先団体内統合宛名_連携方式;
    @BatchParameter(key = KOJINBANGOHIHOKENSHANO, name = "個人番号付替対象者被保険者番号")
    private HihokenshaNo 個人番号付替対象者被保険者番号;

    /**
     * コンストラクタです。
     */
    public DBU080010_TokuteiKojinJohoTeikyoParameter() {

    }

    /**
     * JukyushaKihonJohoProcessParameterに転換します。
     *
     * @return JukyushaKihonJohoProcessParameter
     */
    public JukyushaKihonJohoProcessParameter toJukyushaKihonJohoProcessParameter() {
        JukyushaKihonJohoProcessParameter parameter = new JukyushaKihonJohoProcessParameter();
        parameter.set対象開始日時(対象開始日時);
        parameter.set対象終了日時(対象終了日時);
        parameter.set新規異動区分(新規異動区分);
        parameter.set特定個人情報名コードList(特定個人情報);
        return parameter;
    }

    /**
     * TokuteiKojinKadouKahiHanteiProcessParameterに転換します。
     *
     * @return TokuteiKojinKadouKahiHanteiProcessParameter
     */
    public TokuteiKojinKadouKahiHanteiProcessParameter toTokuteiKojinKadouKahiHanteiProcessParameter() {
        TokuteiKojinKadouKahiHanteiProcessParameter parameter = new TokuteiKojinKadouKahiHanteiProcessParameter();
        parameter.set新規異動区分(新規異動区分);
        return parameter;
    }

    /**
     * TokuteiKojinKadouKahiHanteiProcessParameterに転換します。
     *
     * @return TokuteiKojinKadouKahiHanteiProcessParameter
     */
    public JogaiTokureiSyaJyohouProcessParameter toJogaiTokureiSyaJyohouProcessParameter() {
        JogaiTokureiSyaJyohouProcessParameter parameter = new JogaiTokureiSyaJyohouProcessParameter();
        parameter.set新規異動区分(新規異動区分);
        parameter.set対象開始日時(対象開始日時);
        parameter.set対象終了日時(対象終了日時);
        parameter.set連携先団体内統合宛名_連携方式(連携先団体内統合宛名_連携方式);
        parameter.set個人番号付替対象者被保険者番号(個人番号付替対象者被保険者番号);
        return parameter;
    }

    /**
     * SougouJigyouJyohouProcessParameterに転換します。
     *
     * @return SougouJigyouJyohouProcessParameter
     */
    public SougouJigyouJyohouProcessParameter toSougouJigyouJyohouProcessParameter() {
        SougouJigyouJyohouProcessParameter parameter = new SougouJigyouJyohouProcessParameter();
        parameter.set新規異動区分(新規異動区分);
        parameter.set対象開始日時(対象開始日時);
        parameter.set対象終了日時(対象終了日時);
        parameter.set連携先団体内統合宛名_連携方式(連携先団体内統合宛名_連携方式);
        parameter.set個人番号付替対象者被保険者番号(個人番号付替対象者被保険者番号);
        return parameter;
    }

    /**
     * RiyoshaFutanwariaiProcessParameterに転換します。
     *
     * @return RiyoshaFutanwariaiProcessParameter
     */
    public RiyoshaFutanwariaiProcessParameter toRiyoshaFutanwariaiProcessParameter() {
        RiyoshaFutanwariaiProcessParameter parameter = new RiyoshaFutanwariaiProcessParameter();
        parameter.set新規異動区分(新規異動区分);
        parameter.set対象開始日時(対象開始日時);
        parameter.set対象終了日時(対象終了日時);
        parameter.set連携先団体内統合宛名_連携方式(連携先団体内統合宛名_連携方式);
        parameter.set個人番号付替対象者被保険者番号(個人番号付替対象者被保険者番号);
        return parameter;
    }

    /**
     * TokuteiKojinJohoTeikyoKanriUpdateProcessParameterに転換します。
     *
     * @return TokuteiKojinJohoTeikyoKanriUpdateProcessParameter
     */
    public TokuteiKojinJohoTeikyoKanriUpdateProcessParameter toTokuteiKojinJohoTeikyoKanriUpdateProcessParameter() {
        TokuteiKojinJohoTeikyoKanriUpdateProcessParameter parameter = new TokuteiKojinJohoTeikyoKanriUpdateProcessParameter();
        parameter.set新規異動区分(新規異動区分);
        return parameter;
    }
}
